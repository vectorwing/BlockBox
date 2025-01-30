package vectorwing.blockbox.common.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import vectorwing.blockbox.common.entity.SeatEntity;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class SeatBlock extends HorizontalDirectionalBlock
{
	public static final MapCodec<SeatBlock> CODEC = simpleCodec(SeatBlock::new);

	private static final VoxelShape SHAPE = Shapes.or(
			Block.box(0.0, 4.0, 0.0, 16.0, 8.0, 16.0),
			Block.box(0.0, 0.0, 0.0, 3.0, 4.0, 3.0),
			Block.box(13.0, 0.0, 0.0, 16.0, 4.0, 3.0),
			Block.box(0.0, 0.0, 13.0, 3.0, 4.0, 16.0),
			Block.box(13.0, 0.0, 13.0, 16.0, 4.0, 16.0)
	);

	public SeatBlock(Properties properties) {
		super(properties);
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
	}

	@Override
	public InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
		if (player.isShiftKeyDown())
			return InteractionResult.PASS;
		if (level.isClientSide)
			return InteractionResult.SUCCESS;
		sitDown(level, pos, player);
		return InteractionResult.SUCCESS;
	}

	public static void sitDown(Level level, BlockPos pos, Entity entity) {
		if (level.isClientSide)
			return;
		SeatEntity seat = new SeatEntity(level, pos);
		seat.setPos(pos.getX() + 0.5f, pos.getY(), pos.getZ() + 0.5f);
		level.addFreshEntity(seat);
		entity.startRiding(seat, true);
		if (entity instanceof TamableAnimal animal)
			animal.setInSittingPose(true);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
	}

	@Override
	protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
		return SHAPE;
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(FACING);
	}

	@Override
	protected @NotNull MapCodec<? extends HorizontalDirectionalBlock> codec() {
		return CODEC;
	}
}
