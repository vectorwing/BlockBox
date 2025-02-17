package vectorwing.blockbox.data.provider;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import vectorwing.blockbox.common.registry.ModBlocks;

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
		addBlockStairSlab(ModBlocks.GRANITE_BRICKS.get(), ModBlocks.GRANITE_BRICK_STAIRS.get(), ModBlocks.GRANITE_BRICK_SLAB.get());
		dropSelf(ModBlocks.GRANITE_BRICK_WALL.get());
		addBlockStairSlab(ModBlocks.DIORITE_BRICKS.get(), ModBlocks.DIORITE_BRICK_STAIRS.get(), ModBlocks.DIORITE_BRICK_SLAB.get());
		dropSelf(ModBlocks.DIORITE_BRICK_WALL.get());
		addBlockStairSlab(ModBlocks.ANDESITE_BRICKS.get(), ModBlocks.ANDESITE_BRICK_STAIRS.get(), ModBlocks.ANDESITE_BRICK_SLAB.get());
		dropSelf(ModBlocks.ANDESITE_BRICK_WALL.get());

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

		dropSelf(ModBlocks.STRIPPED_OAK_PALISADE.get());
		dropSelf(ModBlocks.STRIPPED_SPIKED_OAK_PALISADE.get());
		dropSelf(ModBlocks.STRIPPED_SPRUCE_PALISADE.get());
		dropSelf(ModBlocks.STRIPPED_SPIKED_SPRUCE_PALISADE.get());
		dropSelf(ModBlocks.STRIPPED_BIRCH_PALISADE.get());
		dropSelf(ModBlocks.STRIPPED_SPIKED_BIRCH_PALISADE.get());
		dropSelf(ModBlocks.STRIPPED_JUNGLE_PALISADE.get());
		dropSelf(ModBlocks.STRIPPED_SPIKED_JUNGLE_PALISADE.get());
		dropSelf(ModBlocks.STRIPPED_ACACIA_PALISADE.get());
		dropSelf(ModBlocks.STRIPPED_SPIKED_ACACIA_PALISADE.get());
		dropSelf(ModBlocks.STRIPPED_DARK_OAK_PALISADE.get());
		dropSelf(ModBlocks.STRIPPED_SPIKED_DARK_OAK_PALISADE.get());
		dropSelf(ModBlocks.STRIPPED_MANGROVE_PALISADE.get());
		dropSelf(ModBlocks.STRIPPED_SPIKED_MANGROVE_PALISADE.get());
		dropSelf(ModBlocks.STRIPPED_CHERRY_PALISADE.get());
		dropSelf(ModBlocks.STRIPPED_SPIKED_CHERRY_PALISADE.get());
		dropSelf(ModBlocks.STRIPPED_CRIMSON_PALISADE.get());
		dropSelf(ModBlocks.STRIPPED_SPIKED_CRIMSON_PALISADE.get());
		dropSelf(ModBlocks.STRIPPED_WARPED_PALISADE.get());
		dropSelf(ModBlocks.STRIPPED_SPIKED_WARPED_PALISADE.get());

		addBlockStairSlab(ModBlocks.SANDSTONE_BRICKS.get(), ModBlocks.SANDSTONE_BRICK_STAIRS.get(), ModBlocks.SANDSTONE_BRICK_SLAB.get());
		addBlockStairSlab(ModBlocks.RED_SANDSTONE_BRICKS.get(), ModBlocks.RED_SANDSTONE_BRICK_STAIRS.get(), ModBlocks.RED_SANDSTONE_BRICK_SLAB.get());

		addBlockStairSlab(ModBlocks.TILES.get(), ModBlocks.TILE_STAIRS.get(), ModBlocks.TILE_SLAB.get());
		dropSelf(ModBlocks.BROKEN_TILE_MOSAIC.get());

		dropSelf(ModBlocks.PACKED_SNOW.get());
		dropSelf(ModBlocks.CARVED_SNOW.get());
		addBlockStairSlab(ModBlocks.SNOW_BRICKS.get(), ModBlocks.SNOW_BRICK_STAIRS.get(), ModBlocks.SNOW_BRICK_SLAB.get());
		dropSelf(ModBlocks.SNOW_BRICK_WALL.get());
		dropSelf(ModBlocks.POLISHED_PACKED_ICE.get());
		addBlockStairSlab(ModBlocks.PACKED_ICE_BRICKS.get(), ModBlocks.PACKED_ICE_BRICK_STAIRS.get(), ModBlocks.PACKED_ICE_BRICK_SLAB.get());
		dropSelf(ModBlocks.PACKED_ICE_BRICK_WALL.get());

		dropSelf(ModBlocks.POLISHED_OBSIDIAN.get());

		dropWhenSilkTouch(ModBlocks.ROUGH_GLASS.get());
		dropWhenSilkTouch(ModBlocks.ROUGH_GLASS_PANE.get());

		dropSelf(ModBlocks.COPPER_BARS.get());
		dropSelf(ModBlocks.EXPOSED_COPPER_BARS.get());
		dropSelf(ModBlocks.WEATHERED_COPPER_BARS.get());
		dropSelf(ModBlocks.OXIDIZED_COPPER_BARS.get());
		dropSelf(ModBlocks.WAXED_COPPER_BARS.get());
		dropSelf(ModBlocks.WAXED_EXPOSED_COPPER_BARS.get());
		dropSelf(ModBlocks.WAXED_WEATHERED_COPPER_BARS.get());
		dropSelf(ModBlocks.WAXED_OXIDIZED_COPPER_BARS.get());

		dropSelf(ModBlocks.COPPER_PILLAR.get());
		dropSelf(ModBlocks.EXPOSED_COPPER_PILLAR.get());
		dropSelf(ModBlocks.WEATHERED_COPPER_PILLAR.get());
		dropSelf(ModBlocks.OXIDIZED_COPPER_PILLAR.get());
		dropSelf(ModBlocks.WAXED_COPPER_PILLAR.get());
		dropSelf(ModBlocks.WAXED_EXPOSED_COPPER_PILLAR.get());
		dropSelf(ModBlocks.WAXED_WEATHERED_COPPER_PILLAR.get());
		dropSelf(ModBlocks.WAXED_OXIDIZED_COPPER_PILLAR.get());

		dropSelf(ModBlocks.IRON_PLATE.get());
		addBlockStairSlab(ModBlocks.IRON_TREAD_PLATE.get(), ModBlocks.IRON_TREAD_PLATE_STAIRS.get(), ModBlocks.IRON_TREAD_PLATE_SLAB.get());
		addBlockStairSlab(ModBlocks.CORRUGATED_IRON_PLATE.get(), ModBlocks.CORRUGATED_IRON_PLATE_STAIRS.get(), ModBlocks.CORRUGATED_IRON_PLATE_SLAB.get());
		dropSelf(ModBlocks.IRON_PLATE_PILLAR.get());
		add(ModBlocks.IRON_PLATE_DOOR.get(), this::createDoorTable);
		dropSelf(ModBlocks.IRON_PLATE_TRAPDOOR.get());

		dropSelf(ModBlocks.CHISELED_GOLD.get());
		dropSelf(ModBlocks.GOLDEN_TILES.get());
		addBlockStairSlab(ModBlocks.GOLDEN_BRICKS.get(), ModBlocks.GOLDEN_BRICK_STAIRS.get(), ModBlocks.GOLDEN_BRICK_SLAB.get());
		dropSelf(ModBlocks.GOLDEN_PILLAR.get());
		add(ModBlocks.GOLDEN_DOOR.get(), this::createDoorTable);
		dropSelf(ModBlocks.GOLDEN_TRAPDOOR.get());
		dropSelf(ModBlocks.GOLDEN_BARS.get());

		dropSelf(ModBlocks.POLISHED_AMETHYST.get());
		addBlockStairSlab(ModBlocks.CUT_AMETHYST.get(), ModBlocks.CUT_AMETHYST_STAIRS.get(), ModBlocks.CUT_AMETHYST_SLAB.get());
		addBlockStairSlab(ModBlocks.AMETHYST_MOSAIC.get(), ModBlocks.AMETHYST_MOSAIC_STAIRS.get(), ModBlocks.AMETHYST_MOSAIC_SLAB.get());

		dropSelf(ModBlocks.LAPIS_LAZULI_BRICKS.get());
		dropSelf(ModBlocks.LAPIS_LAZULI_BRICK_STAIRS.get());
		dropSelf(ModBlocks.LAPIS_LAZULI_BRICK_SLAB.get());
		dropSelf(ModBlocks.LAPIS_LAZULI_MOSAIC.get());
		dropSelf(ModBlocks.LAPIS_LAZULI_MOSAIC_STAIRS.get());
		dropSelf(ModBlocks.LAPIS_LAZULI_MOSAIC_SLAB.get());

		dropSelf(ModBlocks.OAK_SEAT.get());
		dropSelf(ModBlocks.SPRUCE_SEAT.get());
		dropSelf(ModBlocks.BIRCH_SEAT.get());
		dropSelf(ModBlocks.JUNGLE_SEAT.get());
		dropSelf(ModBlocks.ACACIA_SEAT.get());
		dropSelf(ModBlocks.DARK_OAK_SEAT.get());
		dropSelf(ModBlocks.MANGROVE_SEAT.get());
		dropSelf(ModBlocks.CHERRY_SEAT.get());
		dropSelf(ModBlocks.BAMBOO_SEAT.get());
		dropSelf(ModBlocks.CRIMSON_SEAT.get());
		dropSelf(ModBlocks.WARPED_SEAT.get());

		dropSelf(ModBlocks.BRAZIER.get());
		dropSelf(ModBlocks.SOUL_BRAZIER.get());

		dropSelf(ModBlocks.WHITE_SKY_LANTERN.get());
		dropSelf(ModBlocks.LIGHT_GRAY_SKY_LANTERN.get());
		dropSelf(ModBlocks.GRAY_SKY_LANTERN.get());
		dropSelf(ModBlocks.BLACK_SKY_LANTERN.get());
		dropSelf(ModBlocks.BROWN_SKY_LANTERN.get());
		dropSelf(ModBlocks.RED_SKY_LANTERN.get());
		dropSelf(ModBlocks.ORANGE_SKY_LANTERN.get());
		dropSelf(ModBlocks.YELLOW_SKY_LANTERN.get());
		dropSelf(ModBlocks.LIME_SKY_LANTERN.get());
		dropSelf(ModBlocks.GREEN_SKY_LANTERN.get());
		dropSelf(ModBlocks.CYAN_SKY_LANTERN.get());
		dropSelf(ModBlocks.LIGHT_BLUE_SKY_LANTERN.get());
		dropSelf(ModBlocks.BLUE_SKY_LANTERN.get());
		dropSelf(ModBlocks.PURPLE_SKY_LANTERN.get());
		dropSelf(ModBlocks.MAGENTA_SKY_LANTERN.get());
		dropSelf(ModBlocks.PINK_SKY_LANTERN.get());
	}

	protected void addBlockStairSlab(Block block, Block stair, Block slab) {
		dropSelf(block);
		dropSelf(stair);
		add(slab, this::createSlabItemTable);
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
