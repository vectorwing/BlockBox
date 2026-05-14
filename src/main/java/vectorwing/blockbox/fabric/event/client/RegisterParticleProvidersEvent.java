//? fabric {
/*package vectorwing.blockbox.fabric.event.client;

import net.fabricmc.fabric.api.client.particle.v1.ParticleProviderRegistry;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;

public class RegisterParticleProvidersEvent {
	public <T extends ParticleOptions> void registerSpriteSet(ParticleType<T> simpleParticleType, ParticleProviderRegistry.PendingParticleProvider<T> provider) {
		ParticleProviderRegistry.getInstance().register(simpleParticleType, provider);
	}
}
*///?}