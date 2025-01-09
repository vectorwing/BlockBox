package vectorwing.buildingbigger.common.registry;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.neoforged.neoforge.registries.DeferredRegister;
import vectorwing.buildingbigger.BuildingBigger;

import java.util.function.Supplier;

public class ModParticleTypes
{
	public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create(Registries.PARTICLE_TYPE, BuildingBigger.MODID);

	public static final Supplier<SimpleParticleType> SPARKLE = PARTICLE_TYPES.register("sparkle",
			() -> new SimpleParticleType(true));
}
