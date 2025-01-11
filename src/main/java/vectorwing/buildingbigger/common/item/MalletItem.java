package vectorwing.buildingbigger.common.item;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
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
import net.minecraft.world.level.block.piston.PistonHeadBlock;
import net.minecraft.world.level.block.piston.PistonStructureResolver;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.PistonType;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.NotNull;

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
		BlockPos pos = clickedPos.relative(clickedFace);

		if (this.moveBlocks(level, pos, context.getClickedFace().getOpposite())) {
			level.playSound(null, pos, SoundEvents.ZOMBIE_ATTACK_IRON_DOOR, SoundSource.BLOCKS, 0.5F, level.random.nextFloat() * 0.25F + 0.6F);
			Player player = context.getPlayer();
			if (player != null) {
				player.getCooldowns().addCooldown(this, 20);
			}
			return InteractionResult.sidedSuccess(level.isClientSide);
		} else {
			level.playSound(null, pos, SoundEvents.NETHERITE_BLOCK_HIT, SoundSource.BLOCKS, 0.5F, level.random.nextFloat() * 0.25F + 0.6F);
			return InteractionResult.PASS;
		}
	}

	protected boolean moveBlocks(Level level, BlockPos pos, Direction facing) {
		BlockPos blockpos = pos.relative(facing);
		boolean extending = true;

		PistonStructureResolver structureResolver = new PistonStructureResolver(level, pos, facing, extending);
		if (!structureResolver.resolve()) {
			return false;
		} else {
			Map<BlockPos, BlockState> map = Maps.newHashMap();
			List<BlockPos> list = structureResolver.getToPush();
			List<BlockState> list1 = Lists.newArrayList();

			for (BlockPos blockpos1 : list) {
				BlockState blockstate = level.getBlockState(blockpos1);
				list1.add(blockstate);
				map.put(blockpos1, blockstate);
			}

			List<BlockPos> list2 = structureResolver.getToDestroy();
			BlockState[] ablockstate = new BlockState[list.size() + list2.size()];
			int i = 0;

			for (int j = list2.size() - 1; j >= 0; j--) {
				BlockPos blockpos2 = list2.get(j);
				BlockState blockstate1 = level.getBlockState(blockpos2);
				BlockEntity blockentity = blockstate1.hasBlockEntity() ? level.getBlockEntity(blockpos2) : null;
				dropResources(blockstate1, level, blockpos2, blockentity);
				blockstate1.onDestroyedByPushReaction(level, blockpos2, facing, level.getFluidState(blockpos2));
				if (!blockstate1.is(BlockTags.FIRE)) {
					level.addDestroyBlockEffect(blockpos2, blockstate1);
				}

				ablockstate[i++] = blockstate1;
			}

			for (int k = list.size() - 1; k >= 0; k--) {
				BlockPos blockpos3 = list.get(k);
				BlockState blockstate5 = level.getBlockState(blockpos3);
				blockpos3 = blockpos3.relative(facing);
				map.remove(blockpos3);
				BlockState blockstate8 = Blocks.MOVING_PISTON.defaultBlockState().setValue(DirectionalBlock.FACING, facing);
				level.setBlock(blockpos3, blockstate8, 68);
				level.setBlockEntity(MovingPistonBlock.newMovingBlockEntity(blockpos3, blockstate8, list1.get(k), facing, extending, false));
				ablockstate[i++] = blockstate5;
			}


//			PistonType pistontype = PistonType.DEFAULT;
//			BlockState blockstate4 = Blocks.PISTON_HEAD
//					.defaultBlockState()
//					.setValue(PistonHeadBlock.FACING, facing)
//					.setValue(PistonHeadBlock.TYPE, pistontype);
//			BlockState blockstate6 = Blocks.MOVING_PISTON
//					.defaultBlockState()
//					.setValue(MovingPistonBlock.FACING, facing)
//					.setValue(MovingPistonBlock.TYPE, PistonType.DEFAULT);
//			map.remove(blockpos);
//			level.setBlock(blockpos, blockstate6, 68);
//			level.setBlockEntity(MovingPistonBlock.newMovingBlockEntity(blockpos, blockstate6, blockstate4, facing, true, true));


			BlockState blockstate3 = Blocks.AIR.defaultBlockState();

			for (BlockPos blockpos4 : map.keySet()) {
				level.setBlock(blockpos4, blockstate3, 82);
			}

			for (Map.Entry<BlockPos, BlockState> entry : map.entrySet()) {
				BlockPos blockpos5 = entry.getKey();
				BlockState blockstate2 = entry.getValue();
				blockstate2.updateIndirectNeighbourShapes(level, blockpos5, 2);
				blockstate3.updateNeighbourShapes(level, blockpos5, 2);
				blockstate3.updateIndirectNeighbourShapes(level, blockpos5, 2);
			}

			i = 0;

			for (int l = list2.size() - 1; l >= 0; l--) {
				BlockState blockstate7 = ablockstate[i++];
				BlockPos blockpos6 = list2.get(l);
				blockstate7.updateIndirectNeighbourShapes(level, blockpos6, 2);
				level.updateNeighborsAt(blockpos6, blockstate7.getBlock());
			}

			for (int i1 = list.size() - 1; i1 >= 0; i1--) {
				level.updateNeighborsAt(list.get(i1), ablockstate[i++].getBlock());
			}

			level.updateNeighborsAt(blockpos, Blocks.PISTON_HEAD);

			return true;
		}
	}
}
