//? neoforge {
/*package vectorwing.blockbox.data.tag;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.KeyTagProvider;
import net.minecraft.world.damagesource.DamageType;
import vectorwing.blockbox.BlockBox;
import vectorwing.blockbox.common.registry.ModDamageTypes;

import java.util.concurrent.CompletableFuture;

public class DamageTypeTags extends KeyTagProvider<DamageType>
{
	public DamageTypeTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
		super(output, Registries.DAMAGE_TYPE, lookupProvider, BlockBox.MODID);
	}

	@Override
	protected void addTags(HolderLookup.Provider provider) {
		tag(net.minecraft.tags.DamageTypeTags.NO_KNOCKBACK).add(ModDamageTypes.PALISADE);
		tag(net.minecraft.tags.DamageTypeTags.PANIC_ENVIRONMENTAL_CAUSES).add(ModDamageTypes.PALISADE);
	}
}
*///?}