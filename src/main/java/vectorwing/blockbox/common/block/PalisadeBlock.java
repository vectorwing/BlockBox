package vectorwing.blockbox.common.block;

import com.google.common.collect.Maps;
import com.mojang.serialization.MapCodec;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.ItemAbility;
import org.jetbrains.annotations.NotNull;
import vectorwing.blockbox.common.block.state.PalisadeConnection;
import vectorwing.blockbox.common.tag.ModTags;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Map;
import java.util.function.Supplier;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class PalisadeBlock extends CrossCollisionBlock implements SimpleWaterloggedBlock
{
	public static final MapCodec<PalisadeBlock> CODEC = simpleCodec(PalisadeBlock::new);

	public static final EnumProperty<PalisadeConnection> TYPE_NORTH = EnumProperty.create("north", PalisadeConnection.class);
	public static final EnumProperty<PalisadeConnection> TYPE_EAST = EnumProperty.create("east", PalisadeConnection.class);
	public static final EnumProperty<PalisadeConnection> TYPE_SOUTH = EnumProperty.create("south", PalisadeConnection.class);
	public static final EnumProperty<PalisadeConnection> TYPE_WEST = EnumProperty.create("west", PalisadeConnection.class);

	public final Supplier<Block> strippedForm;

	public static final Map<Direction, EnumProperty<PalisadeConnection>> PROPERTY_BY_DIRECTION = Util.make(Maps.newHashMap(), (map) -> {
		map.put(Direction.NORTH, TYPE_NORTH);
		map.put(Direction.EAST, TYPE_EAST);
		map.put(Direction.SOUTH, TYPE_SOUTH);
		map.put(Direction.WEST, TYPE_WEST);
	});

	public PalisadeBlock(Properties properties) {
		this(null, 4.0F, 4.0F, 16.0F, 16.0F, 16.0F, properties);
	}

	public PalisadeBlock(@Nullable Supplier<Block> strippedForm, Properties properties) {
		this(strippedForm, 4.0F, 4.0F, 16.0F, 16.0F, 16.0F, properties);
	}

	public PalisadeBlock(@Nullable Supplier<Block> strippedForm, float nodeWidth, float extensionWidth, float nodeHeight, float extensionHeight, float collisionHeight, Properties properties) {
		super(nodeWidth, extensionWidth, nodeHeight, extensionHeight, collisionHeight, properties);
		this.strippedForm = strippedForm;
		this.registerDefaultState(this.stateDefinition.any()
				.setValue(TYPE_NORTH, PalisadeConnection.NONE)
				.setValue(TYPE_EAST, PalisadeConnection.NONE)
				.setValue(TYPE_SOUTH, PalisadeConnection.NONE)
				.setValue(TYPE_WEST, PalisadeConnection.NONE)
				.setValue(WATERLOGGED, false));
	}

	@Override
	public BlockState getToolModifiedState(BlockState state, UseOnContext context, ItemAbility itemAbility, boolean simulate) {
		if (strippedForm == null) {
			return null;
		}
		if (itemAbility == ItemAbilities.AXE_STRIP) {
			return strippedForm.get().defaultBlockState()
					.setValue(TYPE_NORTH, state.getValue(TYPE_NORTH))
					.setValue(TYPE_EAST, state.getValue(TYPE_EAST))
					.setValue(TYPE_SOUTH, state.getValue(TYPE_SOUTH))
					.setValue(TYPE_WEST, state.getValue(TYPE_WEST))
					.setValue(WATERLOGGED, state.getValue(WATERLOGGED));
		}
		return null;
	}

	@Override
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
				.setValue(TYPE_NORTH, this.getConnectionType(stateNorth, stateNorth.isFaceSturdy(level, north, Direction.SOUTH), Direction.SOUTH))
				.setValue(TYPE_EAST, this.getConnectionType(stateEast, stateEast.isFaceSturdy(level, east, Direction.WEST), Direction.WEST))
				.setValue(TYPE_SOUTH, this.getConnectionType(stateSouth, stateSouth.isFaceSturdy(level, south, Direction.NORTH), Direction.NORTH))
				.setValue(TYPE_WEST, this.getConnectionType(stateWest, stateWest.isFaceSturdy(level, west, Direction.EAST), Direction.EAST))
				.setValue(WATERLOGGED, fluidState.getType() == Fluids.WATER);
	}

	@Override
	protected BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor level, BlockPos currentPos, BlockPos facingPos) {
		if (state.getValue(WATERLOGGED)) {
			level.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
		}

		return facing.getAxis().getPlane() == Direction.Plane.HORIZONTAL
				? state.setValue(PROPERTY_BY_DIRECTION.get(facing), this.getConnectionType(facingState, facingState.isFaceSturdy(level, facingPos, facing.getOpposite()), facing.getOpposite()))
				: super.updateShape(state, facing, facingState, level, currentPos, facingPos);
	}

	protected static int indexFor(Direction facing) {
		return 1 << facing.get2DDataValue();
	}

	@Override
	protected int getAABBIndex(BlockState state) {
		return this.stateToIndex.computeIntIfAbsent(state, (currentState) -> {
			int i = 0;
			if (!currentState.getValue(TYPE_NORTH).equals(PalisadeConnection.NONE)) {
				i |= indexFor(Direction.NORTH);
			}

			if (!currentState.getValue(TYPE_EAST).equals(PalisadeConnection.NONE)) {
				i |= indexFor(Direction.EAST);
			}

			if (!currentState.getValue(TYPE_SOUTH).equals(PalisadeConnection.NONE)) {
				i |= indexFor(Direction.SOUTH);
			}

			if (!currentState.getValue(TYPE_WEST).equals(PalisadeConnection.NONE)) {
				i |= indexFor(Direction.WEST);
			}

			return i;
		});
	}

	public PalisadeConnection getConnectionType(BlockState state, boolean isSideSolid, Direction direction) {
		PalisadeConnection type = PalisadeConnection.NONE;
		if (state.is(ModTags.SPIKED_PALISADES) || state.getBlock() instanceof SpikedPalisadeBlock) {
			return PalisadeConnection.SPIKED;
		}
		boolean isFenceGateAligned = state.getBlock() instanceof FenceGateBlock && FenceGateBlock.connectsToDirection(state, direction);
		if (state.is(ModTags.PALISADES) || state.is(BlockTags.WALLS) || state.getBlock() instanceof IronBarsBlock || (!isExceptionForConnection(state) && isSideSolid) || isFenceGateAligned) {
			return PalisadeConnection.FULL;
		}
		return type;
	}

	@Override
	protected @NotNull MapCodec<? extends CrossCollisionBlock> codec() {
		return CODEC;
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(TYPE_NORTH, TYPE_EAST, TYPE_WEST, TYPE_SOUTH, WATERLOGGED);
	}

	@Override
	protected BlockState rotate(BlockState state, Rotation rot) {
		switch (rot) {
			case CLOCKWISE_180 -> {
				return state.setValue(TYPE_NORTH, state.getValue(TYPE_SOUTH)).setValue(TYPE_EAST, state.getValue(TYPE_WEST)).setValue(TYPE_SOUTH, state.getValue(TYPE_NORTH)).setValue(TYPE_WEST, state.getValue(TYPE_EAST));
			}
			case COUNTERCLOCKWISE_90 -> {
				return state.setValue(TYPE_NORTH, state.getValue(TYPE_EAST)).setValue(TYPE_EAST, state.getValue(TYPE_SOUTH)).setValue(TYPE_SOUTH, state.getValue(TYPE_WEST)).setValue(TYPE_WEST, state.getValue(TYPE_NORTH));
			}
			case CLOCKWISE_90 -> {
				return state.setValue(TYPE_NORTH, state.getValue(TYPE_WEST)).setValue(TYPE_EAST, state.getValue(TYPE_NORTH)).setValue(TYPE_SOUTH, state.getValue(TYPE_EAST)).setValue(TYPE_WEST, state.getValue(TYPE_SOUTH));
			}
			default -> {
				return state;
			}
		}
	}

	@Override
	protected BlockState mirror(BlockState state, Mirror mirror) {
		switch (mirror) {
			case LEFT_RIGHT -> {
				return state.setValue(TYPE_NORTH, state.getValue(TYPE_SOUTH)).setValue(TYPE_SOUTH, state.getValue(TYPE_NORTH));
			}
			case FRONT_BACK -> {
				return state.setValue(TYPE_EAST, state.getValue(TYPE_WEST)).setValue(TYPE_WEST, state.getValue(TYPE_EAST));
			}
			default -> {
				return super.mirror(state, mirror);
			}
		}
	}
}
