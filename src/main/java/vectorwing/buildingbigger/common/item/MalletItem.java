package vectorwing.buildingbigger.common.item;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DirectionalBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.piston.MovingPistonBlock;
import net.minecraft.world.level.block.piston.PistonStructureResolver;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.network.PacketDistributor;
import org.jetbrains.annotations.NotNull;
import vectorwing.buildingbigger.BuildingBigger;
import vectorwing.buildingbigger.common.network.payload.MalletPushPayload;

import java.util.List;
import java.util.Map;

import static net.minecraft.world.level.block.Block.dropResources;

public class MalletItem extends Item
{
	public MalletItem(Properties properties) {
		super(properties);
	}

	@Override
	public @NotNull InteractionResult useOn(UseOnContext context) {
		Level level = context.getLevel();
		BlockPos clickedPos = context.getClickedPos();
		Direction clickedFace = context.getClickedFace();
		Direction pushDirection = clickedFace.getOpposite();
		BlockPos pos = clickedPos.relative(clickedFace);
		Player player = context.getPlayer();

		if (level.isClientSide) {
			PistonStructureResolver structureResolver = new PistonStructureResolver(level, pos, pushDirection, true);
			if (structureResolver.resolve()) {
				return InteractionResult.SUCCESS;
			}
			return InteractionResult.PASS;
		}

		if (moveBlocks(level, pos, context.getClickedFace().getOpposite())) {
			level.playSound(null, pos, SoundEvents.ZOMBIE_ATTACK_IRON_DOOR, SoundSource.BLOCKS, 0.5F, level.random.nextFloat() * 0.25F + 0.6F);
			if (player != null) {
				player.getCooldowns().addCooldown(this, 10);
			}
			PacketDistributor.sendToPlayersTrackingChunk((ServerLevel) level, level.getChunkAt(pos).getPos(), new MalletPushPayload(pos, pushDirection));
			return InteractionResult.CONSUME;
		} else {
			level.playSound(null, pos, SoundEvents.NETHERITE_BLOCK_HIT, SoundSource.BLOCKS, 0.5F, level.random.nextFloat() * 0.25F + 0.6F);
			if (player != null) {
				player.displayClientMessage(Component.translatable(BuildingBigger.MODID + ".item.mallet.failure"), true);
			}
			return InteractionResult.PASS;
		}
	}

	public static boolean moveBlocks(Level level, BlockPos pos, Direction facing) {
		PistonStructureResolver structureResolver = new PistonStructureResolver(level, pos, facing, true);
		if (!structureResolver.resolve()) {
			return false;
		}

		Map<BlockPos, BlockState> blocksToPush = Maps.newHashMap();
		List<BlockPos> positionsToPush = structureResolver.getToPush();
		List<BlockState> statesToPush = Lists.newArrayList();

		for (BlockPos posToPush : positionsToPush) {
			BlockState stateToPush = level.getBlockState(posToPush);
			statesToPush.add(stateToPush);
			blocksToPush.put(posToPush, stateToPush);
		}

		List<BlockPos> positionsToDestroy = structureResolver.getToDestroy();
		BlockState[] positionsToAffect = new BlockState[positionsToPush.size() + positionsToDestroy.size()];
		int i = 0;

		for (int j = positionsToDestroy.size() - 1; j >= 0; j--) {
			BlockPos destroyedPos = positionsToDestroy.get(j);
			BlockState destroyedState = level.getBlockState(destroyedPos);
			BlockEntity destroyedBlockEntity = destroyedState.hasBlockEntity() ? level.getBlockEntity(destroyedPos) : null;
			dropResources(destroyedState, level, destroyedPos, destroyedBlockEntity);
			destroyedState.onDestroyedByPushReaction(level, destroyedPos, facing, level.getFluidState(destroyedPos));
			if (!destroyedState.is(BlockTags.FIRE)) {
				level.addDestroyBlockEffect(destroyedPos, destroyedState);
			}

			positionsToAffect[i++] = destroyedState;
		}

		for (int k = positionsToPush.size() - 1; k >= 0; k--) {
			BlockPos pushedPos = positionsToPush.get(k);
			BlockState pushedState = level.getBlockState(pushedPos);
			pushedPos = pushedPos.relative(facing);
			blocksToPush.remove(pushedPos);
			BlockState movingBlockState = Blocks.MOVING_PISTON.defaultBlockState().setValue(DirectionalBlock.FACING, facing);
			level.setBlock(pushedPos, movingBlockState, 68);
			level.setBlockEntity(MovingPistonBlock.newMovingBlockEntity(pushedPos, movingBlockState, statesToPush.get(k), facing, true, false));
			positionsToAffect[i++] = pushedState;
		}

		BlockState airState = Blocks.AIR.defaultBlockState();

		for (BlockPos finishedPos : blocksToPush.keySet()) {
			level.setBlock(finishedPos, airState, 82);
		}

		for (Map.Entry<BlockPos, BlockState> entry : blocksToPush.entrySet()) {
			BlockPos blockpos5 = entry.getKey();
			BlockState blockstate2 = entry.getValue();
			blockstate2.updateIndirectNeighbourShapes(level, blockpos5, 2);
			airState.updateNeighbourShapes(level, blockpos5, 2);
			airState.updateIndirectNeighbourShapes(level, blockpos5, 2);
		}

		i = 0;

		for (int l = positionsToDestroy.size() - 1; l >= 0; l--) {
			BlockState blockstate7 = positionsToAffect[i++];
			BlockPos blockpos6 = positionsToDestroy.get(l);
			blockstate7.updateIndirectNeighbourShapes(level, blockpos6, 2);
			level.updateNeighborsAt(blockpos6, blockstate7.getBlock());
		}

		for (int i1 = positionsToPush.size() - 1; i1 >= 0; i1--) {
			level.updateNeighborsAt(positionsToPush.get(i1), positionsToAffect[i++].getBlock());
		}

		return true;
	}
}
