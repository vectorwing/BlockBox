package vectorwing.buildingbigger.client.event;

import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import vectorwing.buildingbigger.BuildingBigger;
import vectorwing.buildingbigger.client.particle.SparkleParticle;
import vectorwing.buildingbigger.common.registry.ModParticleTypes;

@EventBusSubscriber(modid = BuildingBigger.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientSetupEvents
{
	@SubscribeEvent(priority = EventPriority.LOWEST)
	public static void registerParticles(RegisterParticleProvidersEvent event) {
		Minecraft.getInstance().particleEngine.register(ModParticleTypes.SPARKLE.get(), SparkleParticle.Provider::new);
	}
}
