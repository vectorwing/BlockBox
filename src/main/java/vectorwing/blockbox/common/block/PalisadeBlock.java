package vectorwing.blockbox.common.block;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
//? neoforge {
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.ItemAbility;
//?} else {

/*import vectorwing.blockbox.fabric.porting.ItemAbilities;
import vectorwing.blockbox.fabric.porting.ItemAbility;
*///?}
import vectorwing.blockbox.fabric.porting.BlockWithItemAbility;
import org.jspecify.annotations.Nullable;
import vectorwing.blockbox.common.block.state.PalisadeConnection;
import vectorwing.blockbox.common.registry.ModSounds;
import vectorwing.blockbox.common.tag.ModTags;

import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

public class PalisadeBlock extends CrossCollisionBlock implements SimpleWaterloggedBlock, BlockWithItemAbility
{

	public static final EnumProperty<PalisadeConnection> TYPE_NORTH = EnumProperty.create("north", PalisadeConnection.class);
	public static final EnumProperty<PalisadeConnection> TYPE_EAST = EnumProperty.create("east", PalisadeConnection.class);
	public static final EnumProperty<PalisadeConnection> TYPE_SOUTH = EnumProperty.create("south", PalisadeConnection.class);
	public static final EnumProperty<PalisadeConnection> TYPE_WEST = EnumProperty.create("west", PalisadeConnection.class);

	public @Nullable Supplier<Block> strippedForm;
	public @Nullable Supplier<Block> spikedForm;

	public static final Map<Direction, EnumProperty<PalisadeConnection>> PROPERTY_BY_DIRECTION = ImmutableMap.copyOf(Maps.newEnumMap(Map.of(
		Direction.NORTH, TYPE_NORTH,
		Direction.EAST, TYPE_EAST,
		Direction.SOUTH, TYPE_SOUTH,
		Direction.WEST, TYPE_WEST
	)));

	public PalisadeBlock(@Nullable Supplier<Block> spikedForm, @Nullable Supplier<Block> strippedForm, Properties properties) {
		this(spikedForm, strippedForm, 8.0F, 16.0F, 8.0F, 16.0F, 16.0F, properties);
	}

	public PalisadeBlock(@Nullable Supplier<Block> spikedForm, @Nullable Supplier<Block> strippedForm, float postWidth, float postHeight, float wallWidth, float wallHeight, float collisionHeight, Properties properties) {
		super(postWidth, postHeight, wallWidth, wallHeight, collisionHeight, properties);
		this.registerDefaultState(this.stateDefinition.any()
				.setValue(TYPE_NORTH, PalisadeConnection.NONE)
				.setValue(TYPE_EAST, PalisadeConnection.NONE)
				.setValue(TYPE_SOUTH, PalisadeConnection.NONE)
				.setValue(TYPE_WEST, PalisadeConnection.NONE)
				.setValue(WATERLOGGED, false));
	}

	@Override
	protected Function<BlockState, VoxelShape> makeShapes(float postWidth, float postHeight, float wallWidth, float wallBottom, float wallTop) {
		VoxelShape post = Block.column(postWidth, 0.0, postHeight);
		Map<Direction, VoxelShape> arms = Shapes.rotateHorizontal(Block.boxZ(wallWidth, wallBottom, wallTop, 0.0, 8.0));
		return this.getShapeForEachState(state -> {
			VoxelShape shape = post;

			for (Map.Entry<Direction, EnumProperty<PalisadeConnection>> entry : PROPERTY_BY_DIRECTION.entrySet()) {
				if (!state.getValue(entry.getValue()).equals(PalisadeConnection.NONE)) {
					shape = Shapes.or(shape, arms.get(entry.getKey()));
				}
			}

			return shape;
		}, WATERLOGGED);
	}

	@Override
	protected InteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
		if (spikedForm == null) {
			spikedForm = ()-> {
				Identifier id = BuiltInRegistries.BLOCK.getKey(this);
				Identifier spiked;
				if (id.getPath().contains("stripped")) {
					spiked = id.withPath(path -> path.replace("stripped", "stripped_spiked"));
				} else {
					spiked = id.withPrefix("spiked_");
				}
				return BuiltInRegistries.BLOCK.getValue(spiked);

			};
		}
		if (stack.is(ItemTags.SWORDS) && !spikedForm.get().equals(Blocks.AIR) && level.getBlockState(pos.above()).isAir()) {
			level.playSound(null, pos, ModSounds.ITEM_SWORD_CARVE.get(), SoundSource.BLOCKS, 1.0F, 0.9F);
			level.addDestroyBlockEffect(pos, state);
			stack.hurtAndBreak(2, player, hand.asEquipmentSlot());
			level.setBlock(pos, spikedForm.get().defaultBlockState()
					.setValue(SpikedPalisadeBlock.NORTH, !state.getValue(TYPE_NORTH).equals(PalisadeConnection.NONE))
					.setValue(SpikedPalisadeBlock.EAST, !state.getValue(TYPE_EAST).equals(PalisadeConnection.NONE))
					.setValue(SpikedPalisadeBlock.SOUTH, !state.getValue(TYPE_SOUTH).equals(PalisadeConnection.NONE))
					.setValue(SpikedPalisadeBlock.WEST, !state.getValue(TYPE_WEST).equals(PalisadeConnection.NONE))
					.setValue(WATERLOGGED, state.getValue(WATERLOGGED)), 11);
			return InteractionResult.SUCCESS;
		}
		return super.useItemOn(stack, state, level, pos, player, hand, hitResult);
	}

	@Override
	public BlockState getToolModifiedState(BlockState state, UseOnContext context, ItemAbility itemAbility, boolean simulate) {
		if (strippedForm == null) {
			strippedForm = ()-> {
				Identifier stripped = BuiltInRegistries.BLOCK.getKey(this).withPrefix("stripped_");
				return BuiltInRegistries.BLOCK.getValue(stripped);
			};
		}

		if (itemAbility == ItemAbilities.AXE_STRIP && !strippedForm.get().equals(Blocks.AIR)) {
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
	protected BlockState updateShape(BlockState state, LevelReader level, ScheduledTickAccess ticks, BlockPos currentPos, Direction facing, BlockPos facingPos, BlockState facingState, RandomSource random) {
		if (state.getValue(WATERLOGGED)) {
			ticks.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
		}

		return facing.getAxis().getPlane() == Direction.Plane.HORIZONTAL
				? state.setValue(PROPERTY_BY_DIRECTION.get(facing), this.getConnectionType(facingState, facingState.isFaceSturdy(level, facingPos, facing.getOpposite()), facing.getOpposite()))
				: super.updateShape(state, level, ticks, currentPos, facing, facingPos, facingState, random);
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
	protected MapCodec<? extends CrossCollisionBlock> codec() {
		return null;
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
