package vectorwing.buildingbigger.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import vectorwing.buildingbigger.common.registry.ModDamageTypes;

public class SpikedPalisadeBlock extends PalisadeBlock
{
	protected static final VoxelShape SPIKE_SHAPE = Block.box(4.0D, 8.0D, 4.0D, 12.0D, 16.0D, 12.0D);

	public SpikedPalisadeBlock(Properties properties) {
		super(4.0F, 4.0F, 8.0F, 8.0F, 8.0F, properties);
	}

	protected void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
		if (isEntityTouchingSpike(entity, pos)) {
			entity.makeStuckInBlock(state, new Vec3(0.8, 0.75, 0.8));
			if (!level.isClientSide && (entity.xOld != entity.getX() || entity.zOld != entity.getZ())) {
				double d0 = Math.abs(entity.getX() - entity.xOld);
				double d1 = Math.abs(entity.getZ() - entity.zOld);
				if (d0 >= 0.003 || d1 >= 0.003) {
					entity.hurt(ModDamageTypes.getSimpleDamageSource(level, ModDamageTypes.PALISADE), 1.0F);
				}
			}
		}
	}

	protected boolean isEntityTouchingSpike(Entity entity, BlockPos pos) {
		VoxelShape voxelshape1 = SPIKE_SHAPE.move(pos.getX(), pos.getY(), pos.getZ());
		return Shapes.joinIsNotEmpty(voxelshape1, Shapes.create(entity.getBoundingBox()), BooleanOp.AND);
	}
}
