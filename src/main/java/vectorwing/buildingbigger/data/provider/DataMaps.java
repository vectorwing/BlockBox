package vectorwing.buildingbigger.data.provider;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;
import net.neoforged.neoforge.registries.datamaps.builtin.Oxidizable;
import vectorwing.buildingbigger.common.registry.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class DataMaps extends DataMapProvider
{
	public DataMaps(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
		super(packOutput, lookupProvider);
	}

	@Override
	protected void gather() {
		builder(NeoForgeDataMaps.OXIDIZABLES)
				.add(ModBlocks.COPPER_BARS.get().builtInRegistryHolder(), new Oxidizable(ModBlocks.EXPOSED_COPPER_BARS.get()), false)
				.add(ModBlocks.EXPOSED_COPPER_BARS.get().builtInRegistryHolder(), new Oxidizable(ModBlocks.WEATHERED_COPPER_BARS.get()), false)
				.add(ModBlocks.WEATHERED_COPPER_BARS.get().builtInRegistryHolder(), new Oxidizable(ModBlocks.OXIDIZED_COPPER_BARS.get()), false);
	}
}
