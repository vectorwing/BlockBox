package vectorwing.blockbox.common.block;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.mojang.serialization.MapCodec;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.contents.PlainTextContents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SignApplicator;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignText;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;
import vectorwing.blockbox.BlockBox;
import vectorwing.blockbox.common.block.state.PlaqueBlockEntity;
import vectorwing.blockbox.common.registry.ModBlockEntities;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Arrays;
import java.util.Map;
import java.util.UUID;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
@SuppressWarnings("deprecation")
public class PlaqueBlock extends BaseEntityBlock implements SimpleWaterloggedBlock
{
	public static final MapCodec<PlaqueBlock> CODEC = simpleCodec(PlaqueBlock::new);

	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

	private final int textColor;
	private final int highlightColor;

	private static final Map<Direction, VoxelShape> SHAPES_FACING = Maps.newEnumMap(
			ImmutableMap.of(
					Direction.NORTH, Block.box(0.0, 2.0, 14.0, 16.0, 14.0, 16.0),
					Direction.SOUTH, Block.box(0.0, 2.0, 0.0, 16.0, 14.0, 2.0),
					Direction.EAST, Block.box(0.0, 2.0, 0.0, 2.0, 14.0, 16.0),
					Direction.WEST, Block.box(14.0, 2.0, 0.0, 16.0, 14.0, 16.0)
			)
	);

	public PlaqueBlock(Properties properties) {
		this("555555", "cccccc", properties);
	}

	public PlaqueBlock(String hexTextColor, String hexHighlightColor, Properties properties) {
		this(Integer.parseInt(hexTextColor, 16), Integer.parseInt(hexHighlightColor, 16), properties);
	}

	public PlaqueBlock(int textColor, int highlightColor, Properties properties) {
		super(properties);
		this.textColor = textColor;
		this.highlightColor = highlightColor;
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, false));
	}


	public int getTextColor() {
		return this.textColor;
	}

	public int getHighlightColor() {
		return this.highlightColor;
	}

	@Override
	protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
		if (level.getBlockEntity(pos) instanceof PlaqueBlockEntity plaque) {
			SignApplicator applicatorItem = stack.getItem() instanceof SignApplicator signApplicator ? signApplicator : null;
			boolean isApplicationValid = applicatorItem != null && player.mayBuild();
			if (!level.isClientSide) {
				if (isApplicationValid && !plaque.isWaxed() && !this.isOtherPlayerEditingSign(player, plaque)) {
					if (!stack.getItem().equals(Items.HONEYCOMB)) {
						player.displayClientMessage(Component.translatable(BlockBox.MODID + ".block.plaque.invalid_applicator"), true);
						return ItemInteractionResult.FAIL;
					}
					if (applicatorItem.canApplyToSign(plaque.getText(true), player)
							&& applicatorItem.tryApplyToSign(level, plaque, true, player)) {
						plaque.executeClickCommandsIfPresent(player, level, pos, true);
						player.awardStat(Stats.ITEM_USED.get(stack.getItem()));
						level.gameEvent(GameEvent.BLOCK_CHANGE, plaque.getBlockPos(), GameEvent.Context.of(player, plaque.getBlockState()));
						stack.consume(1, player);
						return ItemInteractionResult.SUCCESS;
					} else {
						return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
					}
				} else {
					return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
				}
			} else {
				return !isApplicationValid && !plaque.isWaxed() ? ItemInteractionResult.CONSUME : ItemInteractionResult.SUCCESS;
			}
		}
		return ItemInteractionResult.SKIP_DEFAULT_BLOCK_INTERACTION;
	}

	@Override
	protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
		if (level.getBlockEntity(pos) instanceof PlaqueBlockEntity plaque) {
			boolean isCommandExecuted = plaque.executeClickCommandsIfPresent(player, level, pos, true);
			if (plaque.isWaxed()) {
				level.playSound(null, plaque.getBlockPos(), plaque.getSignInteractionFailedSoundEvent(), SoundSource.BLOCKS);
				return InteractionResult.SUCCESS;
			} else if (isCommandExecuted) {
				return InteractionResult.SUCCESS;
			} else if (!this.isOtherPlayerEditingSign(player, plaque)
					&& player.mayBuild()
					&& this.hasEditableText(player, plaque)) {
				this.openTextEdit(player, plaque, true);
				return InteractionResult.SUCCESS;
			} else {
				return InteractionResult.PASS;
			}
		}
		return InteractionResult.PASS;
	}

	public float getYRotationDegrees(BlockState state) {
		return state.getValue(FACING).toYRot();
	}

	public Vec3 getSignHitboxCenterPosition(BlockState state) {
		VoxelShape voxelshape = SHAPES_FACING.get(state.getValue(FACING));
		return voxelshape.bounds().getCenter();
	}

	private boolean hasEditableText(Player player, PlaqueBlockEntity plaque) {
		SignText signText = plaque.getText(true);
		return Arrays.stream(signText.getMessages(player.isTextFilteringEnabled()))
				.allMatch(p_339537_ -> p_339537_.equals(CommonComponents.EMPTY) || p_339537_.getContents() instanceof PlainTextContents);
	}

	public void openTextEdit(Player player, PlaqueBlockEntity plaque, boolean isFrontText) {
		plaque.setAllowedPlayerEditor(player.getUUID());
		player.openTextEdit(plaque, isFrontText);
	}

	private boolean isOtherPlayerEditingSign(Player player, PlaqueBlockEntity plaque) {
		UUID uuid = plaque.getPlayerWhoMayEdit();
		return uuid != null && !uuid.equals(player.getUUID());
	}

	@Override
	protected BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor level, BlockPos currentPos, BlockPos facingPos) {
		if (state.getValue(WATERLOGGED)) {
			level.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
		}

		return facing.getOpposite() == state.getValue(FACING) && !state.canSurvive(level, currentPos)
				? Blocks.AIR.defaultBlockState()
				: super.updateShape(state, facing, facingState, level, currentPos, facingPos);
	}

	@Override
	protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
		return SHAPES_FACING.get(state.getValue(FACING));
	}

	@Override
	protected boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
		return level.getBlockState(pos.relative(state.getValue(FACING).getOpposite())).isSolid();
	}

	@Override
	protected FluidState getFluidState(BlockState state) {
		return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
	}

	@javax.annotation.Nullable
	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		BlockState state = this.defaultBlockState();
		FluidState fluidState = context.getLevel().getFluidState(context.getClickedPos());
		LevelReader level = context.getLevel();
		BlockPos pos = context.getClickedPos();
		Direction[] lookingDirections = context.getNearestLookingDirections();

		for (Direction direction : lookingDirections) {
			if (direction.getAxis().isHorizontal()) {
				Direction direction1 = direction.getOpposite();
				state = state.setValue(FACING, direction1);
				if (state.canSurvive(level, pos)) {
					return state.setValue(WATERLOGGED, fluidState.getType() == Fluids.WATER);
				}
			}
		}

		return null;
	}

	@Nullable
	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return ModBlockEntities.PLAQUE.get().create(pos, state);
	}

	@Override
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntityType) {
		return createTickerHelper(blockEntityType, ModBlockEntities.PLAQUE.get(), PlaqueBlockEntity::tick);
	}

	@Override
	protected BlockState rotate(BlockState state, Rotation rotation) {
		return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
	}

	@Override
	protected BlockState mirror(BlockState state, Mirror mirror) {
		return state.rotate(mirror.getRotation(state.getValue(FACING)));
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(FACING, WATERLOGGED);
	}

	@Override
	protected MapCodec<? extends BaseEntityBlock> codec() {
		return CODEC;
	}

	@Override
	protected RenderShape getRenderShape(BlockState state) {
		return RenderShape.MODEL;
	}
}
