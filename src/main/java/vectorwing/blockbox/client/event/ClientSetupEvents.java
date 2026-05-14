package vectorwing.blockbox.client.event;

import net.minecraft.client.Minecraft;
//? neoforge {
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
//?} else {
/*import vectorwing.blockbox.fabric.event.client.EntityRenderersEvent;
import vectorwing.blockbox.fabric.event.client.RegisterParticleProvidersEvent;
*///?}
import vectorwing.blockbox.BlockBox;
import vectorwing.blockbox.client.particle.SparkleParticle;
import vectorwing.blockbox.common.entity.SeatEntity;
import vectorwing.blockbox.common.registry.ModEntityTypes;
import vectorwing.blockbox.client.particle.StrikeParticle;
import vectorwing.blockbox.common.registry.ModParticleTypes;

//? neoforge {
@EventBusSubscriber(modid = BlockBox.MODID, value = Dist.CLIENT)
//?}
public class ClientSetupEvents
{
	//? neoforge {
	@SubscribeEvent(priority = EventPriority.LOWEST)
	//?}
	public static void registerParticles(RegisterParticleProvidersEvent event) {
		event.registerSpriteSet(ModParticleTypes.SPARKLE.get(), SparkleParticle.Provider::new);
	}

	//? neoforge {
	@SubscribeEvent
	//?}
	public static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(ModEntityTypes.SEAT.get(), SeatEntity.Renderer::new);
	}
}
