package vectorwing.blockbox.common.block;

import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
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
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import vectorwing.blockbox.common.helper.ClickHelper;

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

	protected static final VoxelShape SHAPE_NORTH = Block.box(0.0, 0.0, 0.0, 16.0, 16.0, 2.0);
	protected static final VoxelShape SHAPE_SOUTH = Block.box(0.0, 0.0, 14.0, 16.0, 16.0, 16.0);
	protected static final VoxelShape SHAPE_WEST = Block.box(0.0, 0.0, 0.0, 2.0, 16.0, 16.0);
	protected static final VoxelShape SHAPE_EAST = Block.box(14.0, 0.0, 0.0, 16.0, 16.0, 16.0);

	protected final VoxelShape[] shapeByIndex;
	protected Object2IntMap<BlockState> stateToIndex = new Object2IntOpenHashMap<>();

	public RailingBlock(Properties properties) {
		super(properties);
		this.shapeByIndex = makeShapes();

		for (BlockState blockstate : this.stateDefinition.getPossibleStates()) {
			this.getAABBIndex(blockstate);
		}

		this.registerDefaultState(stateDefinition.any()
				.setValue(NORTH, true)
				.setValue(EAST, false)
				.setValue(SOUTH, false)
				.setValue(WEST, false)
				.setValue(WATERLOGGED, false));
	}

	protected VoxelShape[] makeShapes() {
		VoxelShape northEast = Shapes.or(SHAPE_NORTH, SHAPE_EAST);
		VoxelShape southWest = Shapes.or(SHAPE_SOUTH, SHAPE_WEST);

		return new VoxelShape[]{
				Shapes.empty(), SHAPE_SOUTH, SHAPE_WEST, southWest, SHAPE_NORTH, Shapes.or(SHAPE_SOUTH, SHAPE_NORTH), Shapes.or(SHAPE_WEST, SHAPE_NORTH), Shapes.or(southWest, SHAPE_NORTH), SHAPE_EAST, Shapes.or(SHAPE_SOUTH, SHAPE_EAST), Shapes.or(SHAPE_WEST, SHAPE_EAST), Shapes.or(southWest, SHAPE_EAST), northEast, Shapes.or(SHAPE_SOUTH, northEast), Shapes.or(SHAPE_WEST, northEast), Shapes.or(southWest, northEast)};
	}

	public BlockState getStateForPlacement(BlockPlaceContext context) {
		BlockState targetState = context.getLevel().getBlockState(context.getClickedPos());
		Direction targetDirection = getRailingPlacementTarget(context);
		BooleanProperty targetProperty = PROPERTY_BY_DIRECTION.get(targetDirection);
		if (targetState.is(this)) {
			if (!targetState.getValue(targetProperty)) {
				return targetState.setValue(targetProperty, true);
			}
			return targetState;
		}
		return getBlankState().setValue(PROPERTY_BY_DIRECTION.get(targetDirection), true);
	}

	public boolean canBeReplaced(BlockState state, BlockPlaceContext context) {
		Direction facing = getRailingPlacementTarget(context);
		BooleanProperty targetProperty = PROPERTY_BY_DIRECTION.get(facing);

		return !context.isSecondaryUseActive() && context.getItemInHand().is(this.asItem()) && !state.getValue(targetProperty) || super.canBeReplaced(state, context);
	}

	public Direction getRailingPlacementTarget(BlockPlaceContext context) {
		Direction face = context.getClickedFace();
		if (face.getAxis().isHorizontal() && !context.replacingClickedOnBlock()) {
			return face.getOpposite();
		}
		Vec3 clickLocation = context.getClickLocation();
		return face.getAxis().isHorizontal() ? ClickHelper.getHorizontalDirectionByThirds(face, clickLocation, 0.3) : ClickHelper.getDirectionByCross(face, context.getClickLocation());
	}

	public BlockState getBlankState() {
		return this.defaultBlockState().setValue(NORTH, false);
	}

	@Override
	protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
		return this.shapeByIndex[this.getAABBIndex(state)];
	}

	protected FluidState getFluidState(BlockState state) {
		return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(NORTH, EAST, WEST, SOUTH, WATERLOGGED);
	}

	private static int indexFor(Direction facing) {
		return 1 << facing.get2DDataValue();
	}

	protected int getAABBIndex(BlockState state) {
		return this.stateToIndex.computeIntIfAbsent(state, (blockState) -> {
			int i = 0;
			if (blockState.getValue(NORTH)) {
				i |= indexFor(Direction.NORTH);
			}

			if (blockState.getValue(EAST)) {
				i |= indexFor(Direction.EAST);
			}

			if (blockState.getValue(SOUTH)) {
				i |= indexFor(Direction.SOUTH);
			}

			if (blockState.getValue(WEST)) {
				i |= indexFor(Direction.WEST);
			}

			return i;
		});
	}
}
