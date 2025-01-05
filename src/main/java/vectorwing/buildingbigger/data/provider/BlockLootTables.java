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
		dropSelf(ModBlocks.SANDSTONE_BRICKS.get());
		dropSelf(ModBlocks.RED_SANDSTONE_BRICKS.get());
		dropSelf(ModBlocks.CLAY_TILES.get());
		dropSelf(ModBlocks.PACKED_SNOW.get());
		dropSelf(ModBlocks.PACKED_SNOW_BRICKS.get());
		dropSelf(ModBlocks.POLISHED_PACKED_ICE.get());
		dropSelf(ModBlocks.PACKED_ICE_BRICKS.get());
		dropSelf(ModBlocks.IRON_PLATE.get());
		dropSelf(ModBlocks.IRON_TREAD_PLATE.get());
		dropSelf(ModBlocks.CORRUGATED_IRON_PLATE.get());
		dropSelf(ModBlocks.IRON_PLATE_PILLAR.get());
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
