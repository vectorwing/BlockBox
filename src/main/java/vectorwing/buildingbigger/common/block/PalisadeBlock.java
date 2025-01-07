package vectorwing.buildingbigger.common.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CrossCollisionBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import vectorwing.buildingbigger.common.tag.ModTags;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class PalisadeBlock extends CrossCollisionBlock implements SimpleWaterloggedBlock
{
	public static final MapCodec<PalisadeBlock> CODEC = simpleCodec(PalisadeBlock::new);

	public PalisadeBlock(Properties properties) {
		super(4.0F, 4.0F, 16.0F, 16.0F, 16.0F, properties);
		this.registerDefaultState(this.stateDefinition.any()
				.setValue(NORTH, false)
				.setValue(EAST, false)
				.setValue(SOUTH, false)
				.setValue(WEST, false)
				.setValue(WATERLOGGED, false));
	}

	public PalisadeBlock(float nodeWidth, float extensionWidth, float nodeHeight, float extensionHeight, float collisionHeight, Properties properties) {
		super(nodeWidth, extensionWidth, nodeHeight, extensionHeight, collisionHeight, properties);
		this.registerDefaultState(this.stateDefinition.any()
				.setValue(NORTH, false)
				.setValue(EAST, false)
				.setValue(SOUTH, false)
				.setValue(WEST, false)
				.setValue(WATERLOGGED, false));
	}

	public BlockState getStateForPlacement(BlockPlaceContext context) {
		BlockGetter level = context.getLevel();
		BlockPos pos = context.getClickedPos();
		FluidState fluidState = context.getLevel().getFluidState(context.getClickedPos());
		BlockPos north = pos.north();
		BlockPos east = pos.east();
		BlockPos south = pos.south();
		BlockPos west = pos.west();
		BlockState stateNorth = level.getBlockState(north);
		BlockState stateEast = level.getBlockState(east);
		BlockState stateSouth = level.getBlockState(south);
		BlockState stateWest = level.getBlockState(west);
		return super.getStateForPlacement(context)
				.setValue(NORTH, this.connectsTo(stateNorth, stateNorth.isFaceSturdy(level, north, Direction.SOUTH), Direction.SOUTH))
				.setValue(EAST, this.connectsTo(stateEast, stateEast.isFaceSturdy(level, east, Direction.WEST), Direction.WEST))
				.setValue(SOUTH, this.connectsTo(stateSouth, stateSouth.isFaceSturdy(level, south, Direction.NORTH), Direction.NORTH))
				.setValue(WEST, this.connectsTo(stateWest, stateWest.isFaceSturdy(level, west, Direction.EAST), Direction.EAST))
				.setValue(WATERLOGGED, fluidState.getType() == Fluids.WATER);
	}

	protected BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor level, BlockPos currentPos, BlockPos facingPos) {
		if (state.getValue(WATERLOGGED)) {
			level.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
		}

		return facing.getAxis().getPlane() == Direction.Plane.HORIZONTAL ? state.setValue(PROPERTY_BY_DIRECTION.get(facing), this.connectsTo(facingState, facingState.isFaceSturdy(level, facingPos, facing.getOpposite()), facing.getOpposite())) : super.updateShape(state, facing, facingState, level, currentPos, facingPos);
	}

	protected boolean isPathfindable(BlockState state, PathComputationType pathComputationType) {
		return false;
	}

	public boolean connectsTo(BlockState state, boolean isSideSolid, Direction direction) {
		boolean flag = this.isSamePalisade(state);
		return !isExceptionForConnection(state) && isSideSolid || flag;
	}

	private boolean isSamePalisade(BlockState state) {
		return state.is(ModTags.PALISADES) && state.is(ModTags.PALISADES) == this.defaultBlockState().is(ModTags.PALISADES);
	}

	@Override
	protected @NotNull MapCodec<? extends CrossCollisionBlock> codec() {
		return CODEC;
	}

	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(NORTH, EAST, WEST, SOUTH, WATERLOGGED);
	}
}
