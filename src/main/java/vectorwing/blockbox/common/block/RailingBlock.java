package vectorwing.blockbox.common.block;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.PipeBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Map;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class RailingBlock extends Block implements SimpleWaterloggedBlock
{
	public static final BooleanProperty NORTH = PipeBlock.NORTH;
	public static final BooleanProperty EAST = PipeBlock.EAST;
	public static final BooleanProperty SOUTH = PipeBlock.SOUTH;
	public static final BooleanProperty WEST = PipeBlock.WEST;
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
	protected static final Map<Direction, BooleanProperty> PROPERTY_BY_DIRECTION = PipeBlock.PROPERTY_BY_DIRECTION.entrySet().stream().filter(
			(value) -> value.getKey().getAxis().isHorizontal()
	).collect(Util.toMap());

	protected static final VoxelShape SHAPE_SIMPLE = Block.box(0.0, 0.0, 0.0, 16.0, 16.0, 2.0);

	public RailingBlock(Properties properties) {
		super(properties);
		this.registerDefaultState(stateDefinition.any()
				.setValue(NORTH, true)
				.setValue(EAST, false)
				.setValue(SOUTH, false)
				.setValue(WEST, false)
				.setValue(WATERLOGGED, false)
		);
	}

	public BlockState getStateForPlacement(BlockPlaceContext context) {
		Direction facing = context.getHorizontalDirection();
		BooleanProperty targetProperty = PROPERTY_BY_DIRECTION.get(facing);
		BlockState targetState = context.getLevel().getBlockState(context.getClickedPos());
		if (targetState.is(this)) {
			if (!targetState.getValue(targetProperty)) {
				return targetState.setValue(targetProperty, true);
			}
			return targetState;
		}
		return getBlankState().setValue(PROPERTY_BY_DIRECTION.get(facing), true);
	}

	public boolean canBeReplaced(BlockState state, BlockPlaceContext context) {
		Direction facing = context.getHorizontalDirection();
		BooleanProperty targetProperty = PROPERTY_BY_DIRECTION.get(facing);
		BlockState targetState = context.getLevel().getBlockState(context.getClickedPos());

		return !context.isSecondaryUseActive() && context.getItemInHand().is(this.asItem()) && !state.getValue(targetProperty) || super.canBeReplaced(state, context);
	}

	public BlockState getBlankState() {
		return this.defaultBlockState().setValue(NORTH, false);
	}

	@Override
	protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
		return SHAPE_SIMPLE;
	}

	protected FluidState getFluidState(BlockState state) {
		return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(NORTH, EAST, WEST, SOUTH, WATERLOGGED);
	}
}
