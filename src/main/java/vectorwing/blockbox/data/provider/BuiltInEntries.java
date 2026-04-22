package vectorwing.blockbox.data.provider;

import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.damagesource.DamageScaling;
import net.minecraft.world.damagesource.DamageType;
import vectorwing.blockbox.common.registry.ModDamageTypes;

public class BuiltInEntries
{
	public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
			.add(Registries.DAMAGE_TYPE, BuiltInEntries::damageTypes);

	private static void damageTypes(BootstrapContext<DamageType> context) {
		context.register(ModDamageTypes.PALISADE, new DamageType("blockbox.palisade", DamageScaling.WHEN_CAUSED_BY_LIVING_NON_PLAYER, 0.1f));
	}
}
