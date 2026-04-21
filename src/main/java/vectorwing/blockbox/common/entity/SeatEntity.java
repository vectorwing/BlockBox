package vectorwing.blockbox.common.entity;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.common.util.FakePlayer;
import vectorwing.blockbox.common.block.SeatBlock;
import vectorwing.blockbox.common.registry.ModEntityTypes;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class SeatEntity extends Entity
{
	public SeatEntity(EntityType<?> entityType, Level level) {
		super(entityType, level);
	}

	public SeatEntity(Level world, BlockPos pos) {
		this(ModEntityTypes.SEAT.get(), world);
		noPhysics = true;
	}

	@Override
	public void tick() {
		if (level().isClientSide())
			return;
		boolean blockPresent = level().getBlockState(blockPosition()).getBlock() instanceof SeatBlock;
		if (isVehicle() && blockPresent)
			return;
		this.discard();
	}

	@Override
	public boolean hurtServer(ServerLevel level, DamageSource source, float damage) {
		return false;
	}

	@Override
	protected Vec3 getPassengerAttachmentPoint(Entity entity, EntityDimensions dimensions, float partialTick) {
		return new Vec3(0, 0.55, 0);
	}

	@Override
	public Vec3 getDismountLocationForPassenger(LivingEntity passenger) {
		return new Vec3(this.getX(), this.getY() + 0.6, this.getZ());
	}

	@Override
	protected boolean canRide(Entity entity) {
		return !(entity instanceof FakePlayer);
	}

    @Override
    public void onPassengerTurned(final Entity entity) {
        entity.setYHeadRot(entity.getYRot());
    }

    public static class Renderer extends EntityRenderer<SeatEntity, EntityRenderState>
	{
		public Renderer(EntityRendererProvider.Context context) {
			super(context);
		}

		@Override
		public boolean shouldRender(SeatEntity entity, Frustum camera, double camX, double camY, double camZ) {
			return false;
		}

		@Override
		public EntityRenderState createRenderState() {
			return new EntityRenderState();
		}
	}

	@Override
	protected void defineSynchedData(SynchedEntityData.Builder builder) {

	}

	@Override
	protected void readAdditionalSaveData(ValueInput input) {

	}

	@Override
	protected void addAdditionalSaveData(ValueOutput output) {

	}
}
