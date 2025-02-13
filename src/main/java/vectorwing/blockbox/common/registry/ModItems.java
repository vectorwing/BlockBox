package vectorwing.blockbox.common.registry;

import com.google.common.collect.Sets;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredRegister;
import vectorwing.blockbox.BlockBox;
import vectorwing.blockbox.common.event.VanillaTabOrdering;
import vectorwing.blockbox.common.item.SkyLanternItem;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.function.Supplier;

import static vectorwing.blockbox.common.event.VanillaTabOrdering.FUNCTIONAL_BLOCKS;

@SuppressWarnings("unused")
public class ModItems
{
	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(BlockBox.MODID);
	public static LinkedHashSet<Supplier<? extends Item>> CREATIVE_TAB_ITEMS = Sets.newLinkedHashSet();

	public static Supplier<Item> registerItem(final String name, final Supplier<Item> supplier) {
		Supplier<Item> block = ITEMS.register(name, supplier);
		CREATIVE_TAB_ITEMS.add(block);
		return block;
	}

	public static Supplier<Item> registerItem(final String name, final Supplier<Item> supplier, final Item vanillaTabNeighbor, LinkedHashMap<Supplier<? extends Item>, ItemLike> vanillaTab) {
		Supplier<Item> block = registerItem(name, supplier);
		vanillaTab.put(block, vanillaTabNeighbor);
		return block;
	}

	public static Supplier<BlockItem> registerSimpleBlockItem(final String name, final Supplier<Block> supplier) {
		Supplier<BlockItem> block = ITEMS.registerSimpleBlockItem(name, supplier);
		CREATIVE_TAB_ITEMS.add(block);
		return block;
	}

	public static Supplier<BlockItem> registerSimpleBlockItem(final String name, final Supplier<Block> supplier, final Item vanillaTabNeighbor) {
		Supplier<BlockItem> block = registerSimpleBlockItem(name, supplier);
		VanillaTabOrdering.BUILDING_BLOCKS.put(block, vanillaTabNeighbor);
		return block;
	}

	public static final Supplier<BlockItem> GRANITE_BRICKS = registerSimpleBlockItem("granite_bricks", ModBlocks.GRANITE_BRICKS, Items.POLISHED_GRANITE_SLAB);
	public static final Supplier<BlockItem> GRANITE_BRICK_STAIRS = registerSimpleBlockItem("granite_brick_stairs", ModBlocks.GRANITE_BRICK_STAIRS, Items.POLISHED_GRANITE_SLAB);
	public static final Supplier<BlockItem> GRANITE_BRICK_SLAB = registerSimpleBlockItem("granite_brick_slab", ModBlocks.GRANITE_BRICK_SLAB, Items.POLISHED_GRANITE_SLAB);
	public static final Supplier<BlockItem> GRANITE_BRICK_WALL = registerSimpleBlockItem("granite_brick_wall", ModBlocks.GRANITE_BRICK_WALL, Items.POLISHED_GRANITE_SLAB);
	public static final Supplier<BlockItem> DIORITE_BRICKS = registerSimpleBlockItem("diorite_bricks", ModBlocks.DIORITE_BRICKS, Items.POLISHED_DIORITE_SLAB);
	public static final Supplier<BlockItem> DIORITE_BRICK_STAIRS = registerSimpleBlockItem("diorite_brick_stairs", ModBlocks.DIORITE_BRICK_STAIRS, Items.POLISHED_DIORITE_SLAB);
	public static final Supplier<BlockItem> DIORITE_BRICK_SLAB = registerSimpleBlockItem("diorite_brick_slab", ModBlocks.DIORITE_BRICK_SLAB, Items.POLISHED_DIORITE_SLAB);
	public static final Supplier<BlockItem> DIORITE_BRICK_WALL = registerSimpleBlockItem("diorite_brick_wall", ModBlocks.DIORITE_BRICK_WALL, Items.POLISHED_DIORITE_SLAB);
	public static final Supplier<BlockItem> ANDESITE_BRICKS = registerSimpleBlockItem("andesite_bricks", ModBlocks.ANDESITE_BRICKS, Items.POLISHED_ANDESITE_SLAB);
	public static final Supplier<BlockItem> ANDESITE_BRICK_STAIRS = registerSimpleBlockItem("andesite_brick_stairs", ModBlocks.ANDESITE_BRICK_STAIRS, Items.POLISHED_ANDESITE_SLAB);
	public static final Supplier<BlockItem> ANDESITE_BRICK_SLAB = registerSimpleBlockItem("andesite_brick_slab", ModBlocks.ANDESITE_BRICK_SLAB, Items.POLISHED_ANDESITE_SLAB);
	public static final Supplier<BlockItem> ANDESITE_BRICK_WALL = registerSimpleBlockItem("andesite_brick_wall", ModBlocks.ANDESITE_BRICK_WALL, Items.POLISHED_ANDESITE_SLAB);

	public static final Supplier<BlockItem> SANDSTONE_BRICKS = registerSimpleBlockItem("sandstone_bricks", ModBlocks.SANDSTONE_BRICKS, Items.CUT_STANDSTONE_SLAB);
	public static final Supplier<BlockItem> SANDSTONE_BRICK_STAIRS = registerSimpleBlockItem("sandstone_brick_stairs", ModBlocks.SANDSTONE_BRICK_STAIRS, Items.CUT_STANDSTONE_SLAB);
	public static final Supplier<BlockItem> SANDSTONE_BRICK_SLAB = registerSimpleBlockItem("sandstone_brick_slab", ModBlocks.SANDSTONE_BRICK_SLAB, Items.CUT_STANDSTONE_SLAB);
	public static final Supplier<BlockItem> RED_SANDSTONE_BRICKS = registerSimpleBlockItem("red_sandstone_bricks", ModBlocks.RED_SANDSTONE_BRICKS, Items.CUT_RED_SANDSTONE_SLAB);
	public static final Supplier<BlockItem> RED_SANDSTONE_BRICK_STAIRS = registerSimpleBlockItem("red_sandstone_brick_stairs", ModBlocks.RED_SANDSTONE_BRICK_STAIRS, Items.CUT_RED_SANDSTONE_SLAB);
	public static final Supplier<BlockItem> RED_SANDSTONE_BRICK_SLAB = registerSimpleBlockItem("red_sandstone_brick_slab", ModBlocks.RED_SANDSTONE_BRICK_SLAB, Items.CUT_RED_SANDSTONE_SLAB);

	public static final Supplier<BlockItem> TILES = registerSimpleBlockItem("tiles", ModBlocks.TILES, Items.BRICK_WALL);
	public static final Supplier<BlockItem> TILE_STAIRS = registerSimpleBlockItem("tile_stairs", ModBlocks.TILE_STAIRS, Items.BRICK_WALL);
	public static final Supplier<BlockItem> TILE_SLAB = registerSimpleBlockItem("tile_slab", ModBlocks.TILE_SLAB, Items.BRICK_WALL);
	public static final Supplier<BlockItem> BROKEN_TILE_MOSAIC = registerSimpleBlockItem("broken_tile_mosaic", ModBlocks.BROKEN_TILE_MOSAIC, Items.BRICK_WALL);

	public static final Supplier<BlockItem> POLISHED_PACKED_ICE = registerSimpleBlockItem("polished_packed_ice", ModBlocks.POLISHED_PACKED_ICE, Items.CUT_RED_SANDSTONE_SLAB);
	public static final Supplier<BlockItem> PACKED_ICE_BRICKS = registerSimpleBlockItem("packed_ice_bricks", ModBlocks.PACKED_ICE_BRICKS, Items.CUT_RED_SANDSTONE_SLAB);
	public static final Supplier<BlockItem> PACKED_ICE_BRICK_STAIRS = registerSimpleBlockItem("packed_ice_brick_stairs", ModBlocks.PACKED_ICE_BRICK_STAIRS, Items.CUT_RED_SANDSTONE_SLAB);
	public static final Supplier<BlockItem> PACKED_ICE_BRICK_SLAB = registerSimpleBlockItem("packed_ice_brick_slab", ModBlocks.PACKED_ICE_BRICK_SLAB, Items.CUT_RED_SANDSTONE_SLAB);
	public static final Supplier<BlockItem> PACKED_ICE_BRICK_WALL = registerSimpleBlockItem("packed_ice_brick_wall", ModBlocks.PACKED_ICE_BRICK_WALL, Items.CUT_RED_SANDSTONE_SLAB);
	public static final Supplier<BlockItem> PACKED_SNOW = registerSimpleBlockItem("packed_snow", ModBlocks.PACKED_SNOW, Items.CUT_RED_SANDSTONE_SLAB);
	public static final Supplier<BlockItem> CARVED_SNOW = registerSimpleBlockItem("carved_snow", ModBlocks.CARVED_SNOW, Items.CUT_RED_SANDSTONE_SLAB);
	public static final Supplier<BlockItem> SNOW_BRICKS = registerSimpleBlockItem("snow_bricks", ModBlocks.SNOW_BRICKS, Items.CUT_RED_SANDSTONE_SLAB);
	public static final Supplier<BlockItem> SNOW_BRICK_STAIRS = registerSimpleBlockItem("snow_brick_stairs", ModBlocks.SNOW_BRICK_STAIRS, Items.CUT_RED_SANDSTONE_SLAB);
	public static final Supplier<BlockItem> SNOW_BRICK_SLAB = registerSimpleBlockItem("snow_brick_slab", ModBlocks.SNOW_BRICK_SLAB, Items.CUT_RED_SANDSTONE_SLAB);
	public static final Supplier<BlockItem> SNOW_BRICK_WALL = registerSimpleBlockItem("snow_brick_wall", ModBlocks.SNOW_BRICK_WALL, Items.CUT_RED_SANDSTONE_SLAB);

	public static final Supplier<BlockItem> POLISHED_OBSIDIAN = registerSimpleBlockItem("polished_obsidian", ModBlocks.POLISHED_OBSIDIAN, Items.DARK_PRISMARINE_SLAB);

	public static final Supplier<BlockItem> ROUGH_GLASS = registerSimpleBlockItem("rough_glass", ModBlocks.ROUGH_GLASS);
	public static final Supplier<BlockItem> ROUGH_GLASS_PANE = registerSimpleBlockItem("rough_glass_pane", ModBlocks.ROUGH_GLASS_PANE);

	public static final Supplier<BlockItem> COPPER_BARS = registerSimpleBlockItem("copper_bars", ModBlocks.COPPER_BARS, Items.COPPER_TRAPDOOR);
	public static final Supplier<BlockItem> EXPOSED_COPPER_BARS = registerSimpleBlockItem("exposed_copper_bars", ModBlocks.EXPOSED_COPPER_BARS, Items.EXPOSED_COPPER_TRAPDOOR);
	public static final Supplier<BlockItem> WEATHERED_COPPER_BARS = registerSimpleBlockItem("weathered_copper_bars", ModBlocks.WEATHERED_COPPER_BARS, Items.WEATHERED_COPPER_TRAPDOOR);
	public static final Supplier<BlockItem> OXIDIZED_COPPER_BARS = registerSimpleBlockItem("oxidized_copper_bars", ModBlocks.OXIDIZED_COPPER_BARS, Items.OXIDIZED_COPPER_TRAPDOOR);
	public static final Supplier<BlockItem> WAXED_COPPER_BARS = registerSimpleBlockItem("waxed_copper_bars", ModBlocks.WAXED_COPPER_BARS, Items.WAXED_COPPER_TRAPDOOR);
	public static final Supplier<BlockItem> WAXED_EXPOSED_COPPER_BARS = registerSimpleBlockItem("waxed_exposed_copper_bars", ModBlocks.WAXED_EXPOSED_COPPER_BARS, Items.WAXED_EXPOSED_COPPER_TRAPDOOR);
	public static final Supplier<BlockItem> WAXED_WEATHERED_COPPER_BARS = registerSimpleBlockItem("waxed_weathered_copper_bars", ModBlocks.WAXED_WEATHERED_COPPER_BARS, Items.WAXED_WEATHERED_COPPER_TRAPDOOR);
	public static final Supplier<BlockItem> WAXED_OXIDIZED_COPPER_BARS = registerSimpleBlockItem("waxed_oxidized_copper_bars", ModBlocks.WAXED_OXIDIZED_COPPER_BARS, Items.WAXED_OXIDIZED_COPPER_TRAPDOOR);

	public static final Supplier<BlockItem> COPPER_PILLAR = registerSimpleBlockItem("copper_pillar", ModBlocks.COPPER_PILLAR, Items.COPPER_GRATE);
	public static final Supplier<BlockItem> EXPOSED_COPPER_PILLAR = registerSimpleBlockItem("exposed_copper_pillar", ModBlocks.EXPOSED_COPPER_PILLAR, Items.EXPOSED_COPPER_GRATE);
	public static final Supplier<BlockItem> WEATHERED_COPPER_PILLAR = registerSimpleBlockItem("weathered_copper_pillar", ModBlocks.WEATHERED_COPPER_PILLAR, Items.WEATHERED_COPPER_GRATE);
	public static final Supplier<BlockItem> OXIDIZED_COPPER_PILLAR = registerSimpleBlockItem("oxidized_copper_pillar", ModBlocks.OXIDIZED_COPPER_PILLAR, Items.OXIDIZED_COPPER_GRATE);
	public static final Supplier<BlockItem> WAXED_COPPER_PILLAR = registerSimpleBlockItem("waxed_copper_pillar", ModBlocks.WAXED_COPPER_PILLAR, Items.WAXED_COPPER_GRATE);
	public static final Supplier<BlockItem> WAXED_EXPOSED_COPPER_PILLAR = registerSimpleBlockItem("waxed_exposed_copper_pillar", ModBlocks.WAXED_EXPOSED_COPPER_PILLAR, Items.WAXED_EXPOSED_COPPER_GRATE);
	public static final Supplier<BlockItem> WAXED_WEATHERED_COPPER_PILLAR = registerSimpleBlockItem("waxed_weathered_copper_pillar", ModBlocks.WAXED_WEATHERED_COPPER_PILLAR, Items.WAXED_WEATHERED_COPPER_GRATE);
	public static final Supplier<BlockItem> WAXED_OXIDIZED_COPPER_PILLAR = registerSimpleBlockItem("waxed_oxidized_copper_pillar", ModBlocks.WAXED_OXIDIZED_COPPER_PILLAR, Items.WAXED_OXIDIZED_COPPER_GRATE);

	public static final Supplier<BlockItem> IRON_PLATE = registerSimpleBlockItem("iron_plate", ModBlocks.IRON_PLATE, Items.HEAVY_WEIGHTED_PRESSURE_PLATE);
	public static final Supplier<BlockItem> IRON_TREAD_PLATE = registerSimpleBlockItem("iron_tread_plate", ModBlocks.IRON_TREAD_PLATE, Items.HEAVY_WEIGHTED_PRESSURE_PLATE);
	public static final Supplier<BlockItem> IRON_TREAD_PLATE_STAIRS = registerSimpleBlockItem("iron_tread_plate_stairs", ModBlocks.IRON_TREAD_PLATE_STAIRS, Items.HEAVY_WEIGHTED_PRESSURE_PLATE);
	public static final Supplier<BlockItem> IRON_TREAD_PLATE_SLAB = registerSimpleBlockItem("iron_tread_plate_slab", ModBlocks.IRON_TREAD_PLATE_SLAB, Items.HEAVY_WEIGHTED_PRESSURE_PLATE);
	public static final Supplier<BlockItem> CORRUGATED_IRON_PLATE = registerSimpleBlockItem("corrugated_iron_plate", ModBlocks.CORRUGATED_IRON_PLATE, Items.HEAVY_WEIGHTED_PRESSURE_PLATE);
	public static final Supplier<BlockItem> CORRUGATED_IRON_PLATE_STAIRS = registerSimpleBlockItem("corrugated_iron_plate_stairs", ModBlocks.CORRUGATED_IRON_PLATE_STAIRS, Items.HEAVY_WEIGHTED_PRESSURE_PLATE);
	public static final Supplier<BlockItem> CORRUGATED_IRON_PLATE_SLAB = registerSimpleBlockItem("corrugated_iron_plate_slab", ModBlocks.CORRUGATED_IRON_PLATE_SLAB, Items.HEAVY_WEIGHTED_PRESSURE_PLATE);
	public static final Supplier<BlockItem> IRON_PLATE_PILLAR = registerSimpleBlockItem("iron_plate_pillar", ModBlocks.IRON_PLATE_PILLAR, Items.HEAVY_WEIGHTED_PRESSURE_PLATE);
	public static final Supplier<BlockItem> IRON_PLATE_DOOR = registerSimpleBlockItem("iron_plate_door", ModBlocks.IRON_PLATE_DOOR, Items.HEAVY_WEIGHTED_PRESSURE_PLATE);
	public static final Supplier<BlockItem> IRON_PLATE_TRAPDOOR = registerSimpleBlockItem("iron_plate_trapdoor", ModBlocks.IRON_PLATE_TRAPDOOR, Items.HEAVY_WEIGHTED_PRESSURE_PLATE);

	public static final Supplier<BlockItem> CHISELED_GOLD = registerSimpleBlockItem("chiseled_gold", ModBlocks.CHISELED_GOLD, Items.LIGHT_WEIGHTED_PRESSURE_PLATE);
	public static final Supplier<BlockItem> GOLDEN_TILES = registerSimpleBlockItem("golden_tiles", ModBlocks.GOLDEN_TILES, Items.LIGHT_WEIGHTED_PRESSURE_PLATE);
	public static final Supplier<BlockItem> GOLDEN_BRICKS = registerSimpleBlockItem("golden_bricks", ModBlocks.GOLDEN_BRICKS, Items.LIGHT_WEIGHTED_PRESSURE_PLATE);
	public static final Supplier<BlockItem> GOLDEN_BRICK_STAIRS = registerSimpleBlockItem("golden_brick_stairs", ModBlocks.GOLDEN_BRICK_STAIRS, Items.LIGHT_WEIGHTED_PRESSURE_PLATE);
	public static final Supplier<BlockItem> GOLDEN_BRICK_SLAB = registerSimpleBlockItem("golden_brick_slab", ModBlocks.GOLDEN_BRICK_SLAB, Items.LIGHT_WEIGHTED_PRESSURE_PLATE);
	public static final Supplier<BlockItem> GOLDEN_PILLAR = registerSimpleBlockItem("golden_pillar", ModBlocks.GOLDEN_PILLAR, Items.LIGHT_WEIGHTED_PRESSURE_PLATE);
	public static final Supplier<BlockItem> GOLDEN_DOOR = registerSimpleBlockItem("golden_door", ModBlocks.GOLDEN_DOOR, Items.LIGHT_WEIGHTED_PRESSURE_PLATE);
	public static final Supplier<BlockItem> GOLDEN_TRAPDOOR = registerSimpleBlockItem("golden_trapdoor", ModBlocks.GOLDEN_TRAPDOOR, Items.LIGHT_WEIGHTED_PRESSURE_PLATE);
	public static final Supplier<BlockItem> GOLDEN_BARS = registerSimpleBlockItem("golden_bars", ModBlocks.GOLDEN_BARS, Items.LIGHT_WEIGHTED_PRESSURE_PLATE);

	public static final Supplier<BlockItem> POLISHED_AMETHYST = registerSimpleBlockItem("polished_amethyst", ModBlocks.POLISHED_AMETHYST, Items.AMETHYST_BLOCK);
	public static final Supplier<BlockItem> CUT_AMETHYST = registerSimpleBlockItem("cut_amethyst", ModBlocks.CUT_AMETHYST, Items.AMETHYST_BLOCK);
	public static final Supplier<BlockItem> CUT_AMETHYST_STAIRS = registerSimpleBlockItem("cut_amethyst_stairs", ModBlocks.CUT_AMETHYST_STAIRS, Items.AMETHYST_BLOCK);
	public static final Supplier<BlockItem> CUT_AMETHYST_SLAB = registerSimpleBlockItem("cut_amethyst_slab", ModBlocks.CUT_AMETHYST_SLAB, Items.AMETHYST_BLOCK);
	public static final Supplier<BlockItem> AMETHYST_MOSAIC = registerSimpleBlockItem("amethyst_mosaic", ModBlocks.AMETHYST_MOSAIC, Items.AMETHYST_BLOCK);
	public static final Supplier<BlockItem> AMETHYST_MOSAIC_STAIRS = registerSimpleBlockItem("amethyst_mosaic_stairs", ModBlocks.AMETHYST_MOSAIC_STAIRS, Items.AMETHYST_BLOCK);
	public static final Supplier<BlockItem> AMETHYST_MOSAIC_SLAB = registerSimpleBlockItem("amethyst_mosaic_slab", ModBlocks.AMETHYST_MOSAIC_SLAB, Items.AMETHYST_BLOCK);

	public static final Supplier<BlockItem> LAPIS_LAZULI_BRICKS = registerSimpleBlockItem("lapis_lazuli_bricks", ModBlocks.LAPIS_LAZULI_BRICKS, Items.LAPIS_BLOCK);
	public static final Supplier<BlockItem> LAPIS_LAZULI_BRICK_STAIRS = registerSimpleBlockItem("lapis_lazuli_brick_stairs", ModBlocks.LAPIS_LAZULI_BRICK_STAIRS, Items.LAPIS_BLOCK);
	public static final Supplier<BlockItem> LAPIS_LAZULI_BRICK_SLAB = registerSimpleBlockItem("lapis_lazuli_brick_slab", ModBlocks.LAPIS_LAZULI_BRICK_SLAB, Items.LAPIS_BLOCK);
	public static final Supplier<BlockItem> LAPIS_LAZULI_MOSAIC = registerSimpleBlockItem("lapis_lazuli_mosaic", ModBlocks.LAPIS_LAZULI_MOSAIC, Items.LAPIS_BLOCK);
	public static final Supplier<BlockItem> LAPIS_LAZULI_MOSAIC_STAIRS = registerSimpleBlockItem("lapis_lazuli_mosaic_stairs", ModBlocks.LAPIS_LAZULI_MOSAIC_STAIRS, Items.LAPIS_BLOCK);
	public static final Supplier<BlockItem> LAPIS_LAZULI_MOSAIC_SLAB = registerSimpleBlockItem("lapis_lazuli_mosaic_slab", ModBlocks.LAPIS_LAZULI_MOSAIC_SLAB, Items.LAPIS_BLOCK);

	public static final Supplier<BlockItem> OAK_SEAT = registerSimpleBlockItem("oak_seat", ModBlocks.OAK_SEAT);
	public static final Supplier<BlockItem> SPRUCE_SEAT = registerSimpleBlockItem("spruce_seat", ModBlocks.SPRUCE_SEAT);
	public static final Supplier<BlockItem> BIRCH_SEAT = registerSimpleBlockItem("birch_seat", ModBlocks.BIRCH_SEAT);
	public static final Supplier<BlockItem> JUNGLE_SEAT = registerSimpleBlockItem("jungle_seat", ModBlocks.JUNGLE_SEAT);
	public static final Supplier<BlockItem> ACACIA_SEAT = registerSimpleBlockItem("acacia_seat", ModBlocks.ACACIA_SEAT);
	public static final Supplier<BlockItem> DARK_OAK_SEAT = registerSimpleBlockItem("dark_oak_seat", ModBlocks.DARK_OAK_SEAT);
	public static final Supplier<BlockItem> MANGROVE_SEAT = registerSimpleBlockItem("mangrove_seat", ModBlocks.MANGROVE_SEAT);
	public static final Supplier<BlockItem> CHERRY_SEAT = registerSimpleBlockItem("cherry_seat", ModBlocks.CHERRY_SEAT);
	public static final Supplier<BlockItem> BAMBOO_SEAT = registerSimpleBlockItem("bamboo_seat", ModBlocks.BAMBOO_SEAT);
	public static final Supplier<BlockItem> CRIMSON_SEAT = registerSimpleBlockItem("crimson_seat", ModBlocks.CRIMSON_SEAT);
	public static final Supplier<BlockItem> WARPED_SEAT = registerSimpleBlockItem("warped_seat", ModBlocks.WARPED_SEAT);

	public static final Supplier<BlockItem> OAK_PALISADE = registerSimpleBlockItem("oak_palisade", ModBlocks.OAK_PALISADE, Items.OAK_BUTTON);
	public static final Supplier<BlockItem> SPIKED_OAK_PALISADE = registerSimpleBlockItem("spiked_oak_palisade", ModBlocks.SPIKED_OAK_PALISADE, Items.OAK_BUTTON);
	public static final Supplier<BlockItem> SPRUCE_PALISADE = registerSimpleBlockItem("spruce_palisade", ModBlocks.SPRUCE_PALISADE, Items.SPRUCE_BUTTON);
	public static final Supplier<BlockItem> SPIKED_SPRUCE_PALISADE = registerSimpleBlockItem("spiked_spruce_palisade", ModBlocks.SPIKED_SPRUCE_PALISADE, Items.SPRUCE_BUTTON);
	public static final Supplier<BlockItem> BIRCH_PALISADE = registerSimpleBlockItem("birch_palisade", ModBlocks.BIRCH_PALISADE, Items.BIRCH_BUTTON);
	public static final Supplier<BlockItem> SPIKED_BIRCH_PALISADE = registerSimpleBlockItem("spiked_birch_palisade", ModBlocks.SPIKED_BIRCH_PALISADE, Items.BIRCH_BUTTON);
	public static final Supplier<BlockItem> JUNGLE_PALISADE = registerSimpleBlockItem("jungle_palisade", ModBlocks.JUNGLE_PALISADE, Items.JUNGLE_BUTTON);
	public static final Supplier<BlockItem> SPIKED_JUNGLE_PALISADE = registerSimpleBlockItem("spiked_jungle_palisade", ModBlocks.SPIKED_JUNGLE_PALISADE, Items.JUNGLE_BUTTON);
	public static final Supplier<BlockItem> ACACIA_PALISADE = registerSimpleBlockItem("acacia_palisade", ModBlocks.ACACIA_PALISADE, Items.ACACIA_BUTTON);
	public static final Supplier<BlockItem> SPIKED_ACACIA_PALISADE = registerSimpleBlockItem("spiked_acacia_palisade", ModBlocks.SPIKED_ACACIA_PALISADE, Items.ACACIA_BUTTON);
	public static final Supplier<BlockItem> DARK_OAK_PALISADE = registerSimpleBlockItem("dark_oak_palisade", ModBlocks.DARK_OAK_PALISADE, Items.DARK_OAK_BUTTON);
	public static final Supplier<BlockItem> SPIKED_DARK_OAK_PALISADE = registerSimpleBlockItem("spiked_dark_oak_palisade", ModBlocks.SPIKED_DARK_OAK_PALISADE, Items.DARK_OAK_BUTTON);
	public static final Supplier<BlockItem> MANGROVE_PALISADE = registerSimpleBlockItem("mangrove_palisade", ModBlocks.MANGROVE_PALISADE, Items.MANGROVE_BUTTON);
	public static final Supplier<BlockItem> SPIKED_MANGROVE_PALISADE = registerSimpleBlockItem("spiked_mangrove_palisade", ModBlocks.SPIKED_MANGROVE_PALISADE, Items.MANGROVE_BUTTON);
	public static final Supplier<BlockItem> CHERRY_PALISADE = registerSimpleBlockItem("cherry_palisade", ModBlocks.CHERRY_PALISADE, Items.CHERRY_BUTTON);
	public static final Supplier<BlockItem> SPIKED_CHERRY_PALISADE = registerSimpleBlockItem("spiked_cherry_palisade", ModBlocks.SPIKED_CHERRY_PALISADE, Items.CHERRY_BUTTON);
	public static final Supplier<BlockItem> CRIMSON_PALISADE = registerSimpleBlockItem("crimson_palisade", ModBlocks.CRIMSON_PALISADE, Items.CRIMSON_BUTTON);
	public static final Supplier<BlockItem> SPIKED_CRIMSON_PALISADE = registerSimpleBlockItem("spiked_crimson_palisade", ModBlocks.SPIKED_CRIMSON_PALISADE, Items.CRIMSON_BUTTON);
	public static final Supplier<BlockItem> WARPED_PALISADE = registerSimpleBlockItem("warped_palisade", ModBlocks.WARPED_PALISADE, Items.WARPED_BUTTON);
	public static final Supplier<BlockItem> SPIKED_WARPED_PALISADE = registerSimpleBlockItem("spiked_warped_palisade", ModBlocks.SPIKED_WARPED_PALISADE, Items.WARPED_BUTTON);

	public static final Supplier<BlockItem> STRIPPED_OAK_PALISADE = registerSimpleBlockItem("stripped_oak_palisade", ModBlocks.STRIPPED_OAK_PALISADE, Items.OAK_BUTTON);
	public static final Supplier<BlockItem> STRIPPED_SPIKED_OAK_PALISADE = registerSimpleBlockItem("stripped_spiked_oak_palisade", ModBlocks.STRIPPED_SPIKED_OAK_PALISADE, Items.OAK_BUTTON);
	public static final Supplier<BlockItem> STRIPPED_SPRUCE_PALISADE = registerSimpleBlockItem("stripped_spruce_palisade", ModBlocks.STRIPPED_SPRUCE_PALISADE, Items.SPRUCE_BUTTON);
	public static final Supplier<BlockItem> STRIPPED_SPIKED_SPRUCE_PALISADE = registerSimpleBlockItem("stripped_spiked_spruce_palisade", ModBlocks.STRIPPED_SPIKED_SPRUCE_PALISADE, Items.SPRUCE_BUTTON);
	public static final Supplier<BlockItem> STRIPPED_BIRCH_PALISADE = registerSimpleBlockItem("stripped_birch_palisade", ModBlocks.STRIPPED_BIRCH_PALISADE, Items.BIRCH_BUTTON);
	public static final Supplier<BlockItem> STRIPPED_SPIKED_BIRCH_PALISADE = registerSimpleBlockItem("stripped_spiked_birch_palisade", ModBlocks.STRIPPED_SPIKED_BIRCH_PALISADE, Items.BIRCH_BUTTON);
	public static final Supplier<BlockItem> STRIPPED_JUNGLE_PALISADE = registerSimpleBlockItem("stripped_jungle_palisade", ModBlocks.STRIPPED_JUNGLE_PALISADE, Items.JUNGLE_BUTTON);
	public static final Supplier<BlockItem> STRIPPED_SPIKED_JUNGLE_PALISADE = registerSimpleBlockItem("stripped_spiked_jungle_palisade", ModBlocks.STRIPPED_SPIKED_JUNGLE_PALISADE, Items.JUNGLE_BUTTON);
	public static final Supplier<BlockItem> STRIPPED_ACACIA_PALISADE = registerSimpleBlockItem("stripped_acacia_palisade", ModBlocks.STRIPPED_ACACIA_PALISADE, Items.ACACIA_BUTTON);
	public static final Supplier<BlockItem> STRIPPED_SPIKED_ACACIA_PALISADE = registerSimpleBlockItem("stripped_spiked_acacia_palisade", ModBlocks.STRIPPED_SPIKED_ACACIA_PALISADE, Items.ACACIA_BUTTON);
	public static final Supplier<BlockItem> STRIPPED_DARK_OAK_PALISADE = registerSimpleBlockItem("stripped_dark_oak_palisade", ModBlocks.STRIPPED_DARK_OAK_PALISADE, Items.DARK_OAK_BUTTON);
	public static final Supplier<BlockItem> STRIPPED_SPIKED_DARK_OAK_PALISADE = registerSimpleBlockItem("stripped_spiked_dark_oak_palisade", ModBlocks.STRIPPED_SPIKED_DARK_OAK_PALISADE, Items.DARK_OAK_BUTTON);
	public static final Supplier<BlockItem> STRIPPED_MANGROVE_PALISADE = registerSimpleBlockItem("stripped_mangrove_palisade", ModBlocks.STRIPPED_MANGROVE_PALISADE, Items.MANGROVE_BUTTON);
	public static final Supplier<BlockItem> STRIPPED_SPIKED_MANGROVE_PALISADE = registerSimpleBlockItem("stripped_spiked_mangrove_palisade", ModBlocks.STRIPPED_SPIKED_MANGROVE_PALISADE, Items.MANGROVE_BUTTON);
	public static final Supplier<BlockItem> STRIPPED_CHERRY_PALISADE = registerSimpleBlockItem("stripped_cherry_palisade", ModBlocks.STRIPPED_CHERRY_PALISADE, Items.CHERRY_BUTTON);
	public static final Supplier<BlockItem> STRIPPED_SPIKED_CHERRY_PALISADE = registerSimpleBlockItem("stripped_spiked_cherry_palisade", ModBlocks.STRIPPED_SPIKED_CHERRY_PALISADE, Items.CHERRY_BUTTON);
	public static final Supplier<BlockItem> STRIPPED_CRIMSON_PALISADE = registerSimpleBlockItem("stripped_crimson_palisade", ModBlocks.STRIPPED_CRIMSON_PALISADE, Items.CRIMSON_BUTTON);
	public static final Supplier<BlockItem> STRIPPED_SPIKED_CRIMSON_PALISADE = registerSimpleBlockItem("stripped_spiked_crimson_palisade", ModBlocks.STRIPPED_SPIKED_CRIMSON_PALISADE, Items.CRIMSON_BUTTON);
	public static final Supplier<BlockItem> STRIPPED_WARPED_PALISADE = registerSimpleBlockItem("stripped_warped_palisade", ModBlocks.STRIPPED_WARPED_PALISADE, Items.WARPED_BUTTON);
	public static final Supplier<BlockItem> STRIPPED_SPIKED_WARPED_PALISADE = registerSimpleBlockItem("stripped_spiked_warped_palisade", ModBlocks.STRIPPED_SPIKED_WARPED_PALISADE, Items.WARPED_BUTTON);


	public static final Supplier<BlockItem> BRAZIER = registerSimpleBlockItem("brazier", ModBlocks.BRAZIER);
	public static final Supplier<BlockItem> SOUL_BRAZIER = registerSimpleBlockItem("soul_brazier", ModBlocks.SOUL_BRAZIER);

	public static final Supplier<Item> WHITE_SKY_LANTERN = registerItem("white_sky_lantern", () -> new SkyLanternItem(ModBlocks.WHITE_SKY_LANTERN.get(), new Item.Properties()), Items.PINK_CANDLE, FUNCTIONAL_BLOCKS);
	public static final Supplier<Item> LIGHT_GRAY_SKY_LANTERN = registerItem("light_gray_sky_lantern", () -> new SkyLanternItem(ModBlocks.LIGHT_GRAY_SKY_LANTERN.get(), new Item.Properties()), Items.PINK_CANDLE, FUNCTIONAL_BLOCKS);
	public static final Supplier<Item> GRAY_SKY_LANTERN = registerItem("gray_sky_lantern", () -> new SkyLanternItem(ModBlocks.GRAY_SKY_LANTERN.get(), new Item.Properties()), Items.PINK_CANDLE, FUNCTIONAL_BLOCKS);
	public static final Supplier<Item> BLACK_SKY_LANTERN = registerItem("black_sky_lantern", () -> new SkyLanternItem(ModBlocks.BLACK_SKY_LANTERN.get(), new Item.Properties()), Items.PINK_CANDLE, FUNCTIONAL_BLOCKS);
	public static final Supplier<Item> BROWN_SKY_LANTERN = registerItem("brown_sky_lantern", () -> new SkyLanternItem(ModBlocks.BROWN_SKY_LANTERN.get(), new Item.Properties()), Items.PINK_CANDLE, FUNCTIONAL_BLOCKS);
	public static final Supplier<Item> RED_SKY_LANTERN = registerItem("red_sky_lantern", () -> new SkyLanternItem(ModBlocks.RED_SKY_LANTERN.get(), new Item.Properties()), Items.PINK_CANDLE, FUNCTIONAL_BLOCKS);
	public static final Supplier<Item> ORANGE_SKY_LANTERN = registerItem("orange_sky_lantern", () -> new SkyLanternItem(ModBlocks.ORANGE_SKY_LANTERN.get(), new Item.Properties()), Items.PINK_CANDLE, FUNCTIONAL_BLOCKS);
	public static final Supplier<Item> YELLOW_SKY_LANTERN = registerItem("yellow_sky_lantern", () -> new SkyLanternItem(ModBlocks.YELLOW_SKY_LANTERN.get(), new Item.Properties()), Items.PINK_CANDLE, FUNCTIONAL_BLOCKS);
	public static final Supplier<Item> LIME_SKY_LANTERN = registerItem("lime_sky_lantern", () -> new SkyLanternItem(ModBlocks.LIME_SKY_LANTERN.get(), new Item.Properties()), Items.PINK_CANDLE, FUNCTIONAL_BLOCKS);
	public static final Supplier<Item> GREEN_SKY_LANTERN = registerItem("green_sky_lantern", () -> new SkyLanternItem(ModBlocks.GREEN_SKY_LANTERN.get(), new Item.Properties()), Items.PINK_CANDLE, FUNCTIONAL_BLOCKS);
	public static final Supplier<Item> CYAN_SKY_LANTERN = registerItem("cyan_sky_lantern", () -> new SkyLanternItem(ModBlocks.CYAN_SKY_LANTERN.get(), new Item.Properties()), Items.PINK_CANDLE, FUNCTIONAL_BLOCKS);
	public static final Supplier<Item> LIGHT_BLUE_SKY_LANTERN = registerItem("light_blue_sky_lantern", () -> new SkyLanternItem(ModBlocks.LIGHT_BLUE_SKY_LANTERN.get(), new Item.Properties()), Items.PINK_CANDLE, FUNCTIONAL_BLOCKS);
	public static final Supplier<Item> BLUE_SKY_LANTERN = registerItem("blue_sky_lantern", () -> new SkyLanternItem(ModBlocks.BLUE_SKY_LANTERN.get(), new Item.Properties()), Items.PINK_CANDLE, FUNCTIONAL_BLOCKS);
	public static final Supplier<Item> PURPLE_SKY_LANTERN = registerItem("purple_sky_lantern", () -> new SkyLanternItem(ModBlocks.PURPLE_SKY_LANTERN.get(), new Item.Properties()), Items.PINK_CANDLE, FUNCTIONAL_BLOCKS);
	public static final Supplier<Item> MAGENTA_SKY_LANTERN = registerItem("magenta_sky_lantern", () -> new SkyLanternItem(ModBlocks.MAGENTA_SKY_LANTERN.get(), new Item.Properties()), Items.PINK_CANDLE, FUNCTIONAL_BLOCKS);
	public static final Supplier<Item> PINK_SKY_LANTERN = registerItem("pink_sky_lantern", () -> new SkyLanternItem(ModBlocks.PINK_SKY_LANTERN.get(), new Item.Properties()), Items.PINK_CANDLE, FUNCTIONAL_BLOCKS);
}
