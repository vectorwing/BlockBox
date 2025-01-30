package vectorwing.blockbox.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class SkyLanternBlock extends Block
{
	public SkyLanternBlock(Properties properties) {
		super(properties);
	}

	@Override
	protected void onProjectileHit(Level level, BlockState state, BlockHitResult hit, Projectile projectile) {
		BlockPos blockpos = hit.getBlockPos();
		if (!level.isClientSide && projectile.mayInteract(level, blockpos) && projectile.mayBreak(level)) {
			level.destroyBlock(blockpos, true, projectile);
		}
	}

	@Override
	public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
		double x = pos.getX() + 0.5;
		double y = pos.getY() + 0.2;
		double z = pos.getZ() + 0.5;
		float chance = random.nextFloat();

		if (chance < 0.3F) {
			level.addParticle(ParticleTypes.SMOKE, x, y, z, 0.0, 0.0, 0.0);
			if (chance < 0.17F) {
				level.playLocalSound(x, y, z, SoundEvents.CANDLE_AMBIENT, SoundSource.BLOCKS, 1.0F + random.nextFloat(),random.nextFloat() * 0.7F + 0.3F,false);
			}
		}

		level.addParticle(ParticleTypes.SMALL_FLAME, x, y, z, 0.0, 0.0, 0.0);
	}
}
