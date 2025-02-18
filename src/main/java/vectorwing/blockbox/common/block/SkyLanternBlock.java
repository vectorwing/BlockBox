package vectorwing.blockbox.common.block;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.Fireworks;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DirectionalBlock;
import net.minecraft.world.level.block.piston.MovingPistonBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.neoforged.neoforge.common.ItemAbilities;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class SkyLanternBlock extends Block
{
	public SkyLanternBlock(Properties properties) {
		super(properties);
	}

	@Override
	protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
		int flyingDistance = 0;
		if (stack.is(Items.FIREWORK_ROCKET)) {
			Fireworks fireworks = stack.get(DataComponents.FIREWORKS);
			if (fireworks != null) {
				flyingDistance = 8 * fireworks.flightDuration();
			}
		}
		else if (stack.is(Items.FIRE_CHARGE)) {
			flyingDistance = 16;
		}
		else if (stack.canPerformAction(ItemAbilities.FIRESTARTER_LIGHT)) {
			flyingDistance = 8;
		}

		if (flyingDistance > 0) {
			return boostSkyLantern(flyingDistance, state, level, pos, player);
		}
		return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
	}

	public ItemInteractionResult boostSkyLantern(int distance, BlockState state, Level level, BlockPos pos, Player player) {
		if (FlyingSkyLanternBlock.maybeMove(distance, state, level, pos)) {
			level.gameEvent(player, GameEvent.BLOCK_ACTIVATE, pos);
			return ItemInteractionResult.sidedSuccess(level.isClientSide);
		}
		return ItemInteractionResult.FAIL;
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
