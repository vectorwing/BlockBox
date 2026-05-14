package vectorwing.blockbox.common.registry;

import net.minecraft.core.Registry;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import vectorwing.blockbox.BlockBox;

import java.util.function.Supplier;

public class ModParticleTypes
{

	public static final Supplier<SimpleParticleType> SPARKLE = register("sparkle",
			() -> new SimpleParticleType(true));

	private static Supplier<SimpleParticleType> register(String name, Supplier<SimpleParticleType> tabSupplier) {
		SimpleParticleType tab = Registry.register(BuiltInRegistries.PARTICLE_TYPE, Identifier.fromNamespaceAndPath(BlockBox.MODID, name), tabSupplier.get());
		return ()->tab;
	}

	public static void register() {

	}
}
