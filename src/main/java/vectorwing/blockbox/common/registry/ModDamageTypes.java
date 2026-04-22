package vectorwing.blockbox.common.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.level.Level;
import vectorwing.blockbox.BlockBox;

public class ModDamageTypes
{
	public static final ResourceKey<DamageType> PALISADE = ResourceKey.create(Registries.DAMAGE_TYPE, Identifier.fromNamespaceAndPath(BlockBox.MODID, "palisade"));

	public static DamageSource getSimpleDamageSource(Level level, ResourceKey<DamageType> type) {
		return new DamageSource(level.registryAccess().lookupOrThrow(Registries.DAMAGE_TYPE).getOrThrow(type));
	}
}
