package vectorwing.blockbox.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.piston.MovingPistonBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import vectorwing.blockbox.common.block.entity.FlyingSkyLanternBlockEntity;
import vectorwing.blockbox.common.registry.ModBlockEntities;
import vectorwing.blockbox.common.registry.ModBlocks;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class FlyingSkyLanternBlock extends MovingPistonBlock
{
	public FlyingSkyLanternBlock(Properties properties) {
		super(properties);
	}

	public static boolean maybeMove(int distance, BlockState state, Level level, BlockPos pos) {
		BlockPos abovePos = pos.above();
		BlockState aboveState = level.getBlockState(abovePos);
		if (!aboveState.isAir()) {
			return false;
		}

		FlyingSkyLanternBlock.move(distance, state, level, pos, abovePos);
//		if (!level.isClientSide) {
//			level.playSound(null, pos, ModSounds.SLIDY_BLOCK_SLIDE.get(), SoundSource.BLOCKS,
//					1.0F, 1.1F + level.random.nextFloat() * 0.15F);
//		}

		return true;
	}

	private static void move(int distance, BlockState state, Level level, BlockPos pos, BlockPos neighborPos) {
		BlockState newState = ModBlocks.FLYING_SKY_LANTERN.get().defaultBlockState();

		level.setBlock(neighborPos, newState, UPDATE_ALL);
		var blockEntity = FlyingSkyLanternBlock.newMovingBlockEntity(distance, neighborPos, newState, state, Direction.UP);
		level.setBlockEntity(blockEntity);

//		if(!level.isClientSide) {
//			NetworkHelper.sendToAllClientPlayersInDefaultRange((ServerLevel) level, neighborPos,
//					new ClientBoundSetSlidingBlockEntityPacket(blockEntity));
//		}

		//pistons usually call this from both sides. here sometimes we dont... we must use a custom packet since tile is set manually
		//calling remove on same pst to hopefully fixe some tile entity issues
		level.removeBlock(pos, true);
		level.setBlock(pos, ModBlocks.FLYING_SKY_LANTERN_SOURCE.get()
				.defaultBlockState(), 3);
	}

	public static FlyingSkyLanternBlockEntity newMovingBlockEntity(int distance, BlockPos pos, BlockState blockState, BlockState movedState, Direction direction) {
		return new FlyingSkyLanternBlockEntity(distance, pos, blockState, movedState, direction, true, false);
	}

	@Override
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntityType) {
		return createTickerHelper(blockEntityType, ModBlockEntities.FLYING_SKY_LANTERN.get(), FlyingSkyLanternBlockEntity::tick);
	}
}
