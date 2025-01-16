package vectorwing.buildingbigger.data.provider;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import vectorwing.buildingbigger.common.registry.ModBlocks;

import java.util.HashSet;
import java.util.Set;

public class BlockLootTables extends BlockLootSubProvider
{
	private final Set<Block> generatedLootTables = new HashSet<>();

	public BlockLootTables(HolderLookup.Provider registries) {
		super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
	}

	@Override
	protected void generate() {
		dropSelf(ModBlocks.OAK_PALISADE.get());
		dropSelf(ModBlocks.SPIKED_OAK_PALISADE.get());
		dropSelf(ModBlocks.SPRUCE_PALISADE.get());
		dropSelf(ModBlocks.SPIKED_SPRUCE_PALISADE.get());
		dropSelf(ModBlocks.BIRCH_PALISADE.get());
		dropSelf(ModBlocks.SPIKED_BIRCH_PALISADE.get());
		dropSelf(ModBlocks.JUNGLE_PALISADE.get());
		dropSelf(ModBlocks.SPIKED_JUNGLE_PALISADE.get());
		dropSelf(ModBlocks.ACACIA_PALISADE.get());
		dropSelf(ModBlocks.SPIKED_ACACIA_PALISADE.get());
		dropSelf(ModBlocks.DARK_OAK_PALISADE.get());
		dropSelf(ModBlocks.SPIKED_DARK_OAK_PALISADE.get());
		dropSelf(ModBlocks.MANGROVE_PALISADE.get());
		dropSelf(ModBlocks.SPIKED_MANGROVE_PALISADE.get());
		dropSelf(ModBlocks.CHERRY_PALISADE.get());
		dropSelf(ModBlocks.SPIKED_CHERRY_PALISADE.get());
		dropSelf(ModBlocks.CRIMSON_PALISADE.get());
		dropSelf(ModBlocks.SPIKED_CRIMSON_PALISADE.get());
		dropSelf(ModBlocks.WARPED_PALISADE.get());
		dropSelf(ModBlocks.SPIKED_WARPED_PALISADE.get());

		dropSelf(ModBlocks.SANDSTONE_BRICKS.get());
		dropSelf(ModBlocks.RED_SANDSTONE_BRICKS.get());

		dropSelf(ModBlocks.CLAY_TILES.get());
		dropSelf(ModBlocks.JAGGED_CLAY_TILES.get());

		dropSelf(ModBlocks.PACKED_SNOW.get());
		dropSelf(ModBlocks.PACKED_SNOW_BRICKS.get());
		dropSelf(ModBlocks.POLISHED_PACKED_ICE.get());
		dropSelf(ModBlocks.PACKED_ICE_BRICKS.get());

		dropSelf(ModBlocks.IRON_PLATE.get());
		dropSelf(ModBlocks.IRON_TREAD_PLATE.get());
		dropSelf(ModBlocks.CORRUGATED_IRON_PLATE.get());
		dropSelf(ModBlocks.IRON_PLATE_PILLAR.get());
		createDoorTable(ModBlocks.IRON_PLATE_DOOR.get());
		dropSelf(ModBlocks.IRON_PLATE_TRAPDOOR.get());

		dropSelf(ModBlocks.CHISELED_GOLD.get());
		dropSelf(ModBlocks.GOLDEN_TILES.get());
		dropSelf(ModBlocks.GOLDEN_BRICKS.get());
		dropSelf(ModBlocks.GOLDEN_PILLAR.get());
		createDoorTable(ModBlocks.GOLDEN_DOOR.get());
		dropSelf(ModBlocks.GOLDEN_TRAPDOOR.get());

		dropSelf(ModBlocks.POLISHED_AMETHYST.get());
		dropSelf(ModBlocks.AMETHYST_TILES.get());
		dropSelf(ModBlocks.CHISELED_AMETHYST.get());
	}

	@Override
	protected void add(Block block, LootTable.Builder builder) {
		this.generatedLootTables.add(block);
		this.map.put(block.getLootTable(), builder);
	}

	@Override
	protected Iterable<Block> getKnownBlocks() {
		return generatedLootTables;
	}
}
