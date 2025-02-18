package vectorwing.blockbox.common.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.piston.PistonMovingBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;
import vectorwing.blockbox.common.block.FlyingSkyLanternBlock;
import vectorwing.blockbox.common.registry.ModBlockEntities;
import vectorwing.blockbox.common.registry.ModBlocks;

public class FlyingSkyLanternBlockEntity extends PistonMovingBlockEntity
{
	public static final double FLYING_SPEED = 0.125D;

	public int flyingDistanceLeft;

	public FlyingSkyLanternBlockEntity(BlockPos pos, BlockState blockState) {
		super(pos, blockState);
	}

	public FlyingSkyLanternBlockEntity(int distance, BlockPos pos, BlockState blockState, BlockState movedState, Direction direction, boolean extending, boolean isSourcePiston) {
		super(pos, blockState, movedState, direction, extending, isSourcePiston);
		this.flyingDistanceLeft = distance;
	}

	@Override
	public @NotNull BlockEntityType<?> getType() {
		return ModBlockEntities.FLYING_SKY_LANTERN.get();
	}

	public static void tick(Level level, BlockPos pos, BlockState state, FlyingSkyLanternBlockEntity t) {
		// TODO: Implement flame take-off particles later.
		if (level.isClientSide) {
			t.spawnBurningParticles(level, pos);
		}

		BlockState movedState = t.getMovedState();
		t.lastTicked = level.getGameTime();
		t.progressO = t.progress;
		if (t.progressO >= 1.0F) {
			if (level.isClientSide && t.deathTicks < 5) {
				++t.deathTicks;
			} else {
				level.removeBlockEntity(pos);
				t.setRemoved();
				if (level.getBlockState(pos).is(ModBlocks.FLYING_SKY_LANTERN.get())) {
					BlockState blockState = Block.updateFromNeighbourShapes(t.getMovedState(), level, pos);
					if (blockState.isAir()) {
						level.setBlock(pos, movedState, 84);
						Block.updateOrDestroy(movedState, blockState, level, pos, 3);
					} else {
						if (blockState.hasProperty(BlockStateProperties.WATERLOGGED) && blockState.getValue(BlockStateProperties.WATERLOGGED)) {
							blockState = blockState.setValue(BlockStateProperties.WATERLOGGED, false);
						}

						level.setBlock(pos, blockState, 67 | Block.UPDATE_KNOWN_SHAPE);
						level.neighborChanged(pos, blockState.getBlock(), pos);

						if (level instanceof ServerLevel sl) blockState.tick(sl, pos, sl.random);
					}
				}

			}
		} else {
			float f = (float) (t.progress + FLYING_SPEED);
			moveCollidedEntities(level, pos, f, t);
			moveStuckEntities(level, pos, f, t);

			t.progress = f;
			if (t.progress >= 1.0F) {
				t.progress = 1.0F;
				t.flyingDistanceLeft--;

				Direction direction = t.getDirection();
				if (direction.getAxis() != Direction.Axis.Y) return;
				if (t.flyingDistanceLeft > 0) {
					FlyingSkyLanternBlock.maybeMove(t.flyingDistanceLeft, movedState, level, pos);
					level.gameEvent(null, GameEvent.BLOCK_ACTIVATE, pos);
				}
			}
		}
	}

	private void spawnBurningParticles(Level level, BlockPos pos) {
		RandomSource random = level.random;

		double x = pos.getX() + 0.4 + (random.nextFloat() * 0.2);
		double y = pos.getY() + this.progress - 0.8;
		double z = pos.getZ() + 0.4 + (random.nextFloat() * 0.2);
		float chance = random.nextFloat();

		if (chance < 0.3F) {
			level.addParticle(ParticleTypes.SMOKE, x, y, z, 0.0, 0.0, 0.0);
			if (chance < 0.17F) {
				level.playLocalSound(x, y, z, SoundEvents.CANDLE_AMBIENT, SoundSource.BLOCKS, 1.0F + random.nextFloat(),random.nextFloat() * 0.7F + 0.3F,false);
			}
		}

		level.addParticle(ParticleTypes.FLAME, x, y, z, 0.0, 0.0, 0.0);
	}
}
