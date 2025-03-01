package vectorwing.blockbox.common.block.state;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import vectorwing.blockbox.common.block.PlaqueBlock;
import vectorwing.blockbox.common.registry.ModBlockEntities;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class PlaqueBlockEntity extends SignBlockEntity
{
	public PlaqueBlockEntity(BlockPos pos, BlockState blockState) {
		super(pos, blockState);
	}

	@Override
	public BlockEntityType<?> getType() {
		return ModBlockEntities.PLAQUE.get();
	}

	@Override
	public boolean isValidBlockState(BlockState state) {
		return this.getType().isValid(state);
	}

	@Override
	public int getTextLineHeight() {
		return 9;
	}

	@Override
	public int getMaxTextLineWidth() {
		return 80;
	}

	public boolean isFacingFrontText(Player player) {
		if (this.getBlockState().getBlock() instanceof PlaqueBlock plaque) {
			Vec3 vec3 = plaque.getSignHitboxCenterPosition(this.getBlockState());
			double d0 = player.getX() - ((double) this.getBlockPos().getX() + vec3.x);
			double d1 = player.getZ() - ((double) this.getBlockPos().getZ() + vec3.z);
			float f = plaque.getYRotationDegrees(this.getBlockState());
			float f1 = (float) (Mth.atan2(d1, d0) * 180.0F / (float) Math.PI) - 90.0F;
			return Mth.degreesDifferenceAbs(f, f1) <= 90.0F;
		} else {
			return false;
		}
	}
}
