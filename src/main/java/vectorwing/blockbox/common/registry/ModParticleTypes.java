package vectorwing.blockbox.common.registry;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.neoforged.neoforge.registries.DeferredRegister;
import vectorwing.blockbox.BlockBox;

import java.util.function.Supplier;

public class ModParticleTypes
{
	public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create(Registries.PARTICLE_TYPE, BlockBox.MODID);

	public static final Supplier<SimpleParticleType> SPARKLE = PARTICLE_TYPES.register("sparkle",
			() -> new SimpleParticleType(true));
}
