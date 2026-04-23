//? fabric {
package vectorwing.blockbox.fabric;

import net.fabricmc.fabric.api.client.particle.v1.ParticleProviderRegistry;
import net.minecraft.client.renderer.entity.EntityRenderers;
import vectorwing.blockbox.client.particle.SparkleParticle;
import vectorwing.blockbox.common.entity.SeatEntity;
import vectorwing.blockbox.common.registry.ModEntityTypes;
import vectorwing.blockbox.common.registry.ModParticleTypes;

public class FabricClientSetupEvents
{
	public static void registerParticles() {

	}

	public static void onRegisterRenderers() {
		EntityRenderers.register(ModEntityTypes.SEAT.get(), SeatEntity.Renderer::new);
	}
}
//?}