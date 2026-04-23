package vectorwing.blockbox.fabric;

import net.fabricmc.fabric.api.registry.FuelValueEvents;
import net.fabricmc.fabric.api.registry.OxidizableBlocksRegistry;
import net.minecraft.world.level.block.Block;
import vectorwing.blockbox.common.registry.ModBlocks;
import vectorwing.blockbox.common.tag.ModTags;

import java.util.function.Supplier;

public class DataMaps {

	// Fabric replacements for NeoForge data maps.
	public static void register() {
		FuelValueEvents.BUILD.register((builder, context) -> {
			builder.add(ModTags.PALISADE_ITEMS, 150);
			builder.add(ModTags.SPIKED_PALISADE_ITEMS, 150);
			builder.add(ModTags.WOODEN_SEAT_ITEMS, 200);
		});

		oxidize(ModBlocks.COPPER_CHAIN_LINKS, ModBlocks.EXPOSED_COPPER_CHAIN_LINKS);
		oxidize(ModBlocks.EXPOSED_COPPER_CHAIN_LINKS, ModBlocks.WEATHERED_COPPER_CHAIN_LINKS);
		oxidize(ModBlocks.WEATHERED_COPPER_CHAIN_LINKS, ModBlocks.OXIDIZED_COPPER_CHAIN_LINKS);

		oxidize(ModBlocks.COPPER_PILLAR, ModBlocks.EXPOSED_COPPER_PILLAR);
		oxidize(ModBlocks.EXPOSED_COPPER_PILLAR, ModBlocks.WEATHERED_COPPER_PILLAR);
		oxidize(ModBlocks.WEATHERED_COPPER_PILLAR, ModBlocks.OXIDIZED_COPPER_PILLAR);

		wax(ModBlocks.COPPER_CHAIN_LINKS, ModBlocks.WAXED_COPPER_CHAIN_LINKS);
		wax(ModBlocks.EXPOSED_COPPER_CHAIN_LINKS, ModBlocks.WAXED_EXPOSED_COPPER_CHAIN_LINKS);
		wax(ModBlocks.WEATHERED_COPPER_CHAIN_LINKS, ModBlocks.WAXED_WEATHERED_COPPER_CHAIN_LINKS);
		wax(ModBlocks.OXIDIZED_COPPER_CHAIN_LINKS, ModBlocks.WAXED_OXIDIZED_COPPER_CHAIN_LINKS);

		wax(ModBlocks.COPPER_PILLAR, ModBlocks.WAXED_COPPER_PILLAR);
		wax(ModBlocks.EXPOSED_COPPER_PILLAR, ModBlocks.WAXED_EXPOSED_COPPER_PILLAR);
		wax(ModBlocks.WEATHERED_COPPER_PILLAR, ModBlocks.WAXED_WEATHERED_COPPER_PILLAR);
		wax(ModBlocks.OXIDIZED_COPPER_PILLAR, ModBlocks.WAXED_OXIDIZED_COPPER_PILLAR);
	}

	private static void oxidize(Supplier<Block> less, Supplier<Block> more) {
		OxidizableBlocksRegistry.registerNextStage(less.get(), more.get());
	}

	private static void wax(Supplier<Block> unwaxed, Supplier<Block> waxed) {
		OxidizableBlocksRegistry.registerWaxable(unwaxed.get(), waxed.get());
	}
}