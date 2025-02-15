package vectorwing.blockbox.data.provider;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.builtin.FurnaceFuel;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;
import net.neoforged.neoforge.registries.datamaps.builtin.Oxidizable;
import net.neoforged.neoforge.registries.datamaps.builtin.Waxable;
import vectorwing.blockbox.common.registry.ModBlocks;
import vectorwing.blockbox.common.registry.ModItems;
import vectorwing.blockbox.common.tag.ModTags;

import java.util.concurrent.CompletableFuture;

@SuppressWarnings("deprecation")
public class DataMaps extends DataMapProvider
{
	public DataMaps(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
		super(packOutput, lookupProvider);
	}

	@Override
	protected void gather() {
		builder(NeoForgeDataMaps.OXIDIZABLES)
				.replace(false)
				.add(ModBlocks.COPPER_BARS.get().builtInRegistryHolder(), new Oxidizable(ModBlocks.EXPOSED_COPPER_BARS.get()), false)
				.add(ModBlocks.EXPOSED_COPPER_BARS.get().builtInRegistryHolder(), new Oxidizable(ModBlocks.WEATHERED_COPPER_BARS.get()), false)
				.add(ModBlocks.WEATHERED_COPPER_BARS.get().builtInRegistryHolder(), new Oxidizable(ModBlocks.OXIDIZED_COPPER_BARS.get()), false)
				.add(ModBlocks.COPPER_PILLAR.get().builtInRegistryHolder(), new Oxidizable(ModBlocks.EXPOSED_COPPER_PILLAR.get()), false)
				.add(ModBlocks.EXPOSED_COPPER_PILLAR.get().builtInRegistryHolder(), new Oxidizable(ModBlocks.WEATHERED_COPPER_PILLAR.get()), false)
				.add(ModBlocks.WEATHERED_COPPER_PILLAR.get().builtInRegistryHolder(), new Oxidizable(ModBlocks.OXIDIZED_COPPER_PILLAR.get()), false);
		builder(NeoForgeDataMaps.WAXABLES)
				.replace(false)
				.add(ModBlocks.COPPER_BARS.get().builtInRegistryHolder(), new Waxable(ModBlocks.WAXED_COPPER_BARS.get()), false)
				.add(ModBlocks.EXPOSED_COPPER_BARS.get().builtInRegistryHolder(), new Waxable(ModBlocks.WAXED_EXPOSED_COPPER_BARS.get()), false)
				.add(ModBlocks.WEATHERED_COPPER_BARS.get().builtInRegistryHolder(), new Waxable(ModBlocks.WAXED_WEATHERED_COPPER_BARS.get()), false)
				.add(ModBlocks.OXIDIZED_COPPER_BARS.get().builtInRegistryHolder(), new Waxable(ModBlocks.WAXED_OXIDIZED_COPPER_BARS.get()), false)
				.add(ModBlocks.COPPER_PILLAR.get().builtInRegistryHolder(), new Waxable(ModBlocks.WAXED_COPPER_PILLAR.get()), false)
				.add(ModBlocks.EXPOSED_COPPER_PILLAR.get().builtInRegistryHolder(), new Waxable(ModBlocks.WAXED_EXPOSED_COPPER_PILLAR.get()), false)
				.add(ModBlocks.WEATHERED_COPPER_PILLAR.get().builtInRegistryHolder(), new Waxable(ModBlocks.WAXED_WEATHERED_COPPER_PILLAR.get()), false)
				.add(ModBlocks.OXIDIZED_COPPER_PILLAR.get().builtInRegistryHolder(), new Waxable(ModBlocks.WAXED_OXIDIZED_COPPER_PILLAR.get()), false);
		builder(NeoForgeDataMaps.FURNACE_FUELS)
				.replace(false)
				.add(ModTags.PALISADE_ITEMS, new FurnaceFuel(150), false)
				.add(ModTags.SPIKED_PALISADE_ITEMS, new FurnaceFuel(150), false)
				.add(ModTags.WOODEN_SEAT_ITEMS, new FurnaceFuel(200), false);
	}
}
