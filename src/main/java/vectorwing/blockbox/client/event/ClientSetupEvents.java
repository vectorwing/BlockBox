package vectorwing.blockbox.client.event;

import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import vectorwing.blockbox.BlockBox;
import vectorwing.blockbox.client.particle.SparkleParticle;
import vectorwing.blockbox.common.entity.SeatEntity;
import vectorwing.blockbox.common.registry.ModEntityTypes;
import vectorwing.blockbox.client.particle.StrikeParticle;
import vectorwing.blockbox.common.registry.ModParticleTypes;

@EventBusSubscriber(modid = BlockBox.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientSetupEvents
{
	@SubscribeEvent(priority = EventPriority.LOWEST)
	public static void registerParticles(RegisterParticleProvidersEvent event) {
		Minecraft.getInstance().particleEngine.register(ModParticleTypes.SPARKLE.get(), SparkleParticle.Provider::new);
	}

	@SubscribeEvent
	public static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(ModEntityTypes.SEAT.get(), SeatEntity.Renderer::new);
	}
}
