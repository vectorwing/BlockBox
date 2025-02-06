package vectorwing.blockbox.common.registry;

import com.google.common.collect.Sets;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredRegister;
import vectorwing.blockbox.BlockBox;
import vectorwing.blockbox.common.item.SkyLanternItem;
import vectorwing.blockbox.common.item.MalletItem;

import java.util.LinkedHashSet;
import java.util.function.Supplier;

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

	public static Supplier<BlockItem> registerSimpleBlockItem(final String name, final Supplier<Block> supplier) {
		Supplier<BlockItem> block = ITEMS.registerSimpleBlockItem(name, supplier);
		CREATIVE_TAB_ITEMS.add(block);
		return block;
	}

	public static final Supplier<Item> MALLET = registerItem("mallet", () -> new MalletItem(new Item.Properties().durability(512)));

	public static final Supplier<BlockItem> SANDSTONE_BRICKS = registerSimpleBlockItem("sandstone_bricks", ModBlocks.SANDSTONE_BRICKS);
	public static final Supplier<BlockItem> SANDSTONE_BRICK_STAIRS = registerSimpleBlockItem("sandstone_brick_stairs", ModBlocks.SANDSTONE_BRICK_STAIRS);
	public static final Supplier<BlockItem> SANDSTONE_BRICK_SLAB = registerSimpleBlockItem("sandstone_brick_slab", ModBlocks.SANDSTONE_BRICK_SLAB);
	public static final Supplier<BlockItem> RED_SANDSTONE_BRICKS = registerSimpleBlockItem("red_sandstone_bricks", ModBlocks.RED_SANDSTONE_BRICKS);
	public static final Supplier<BlockItem> RED_SANDSTONE_BRICK_STAIRS = registerSimpleBlockItem("red_sandstone_brick_stairs", ModBlocks.RED_SANDSTONE_BRICK_STAIRS);
	public static final Supplier<BlockItem> RED_SANDSTONE_BRICK_SLAB = registerSimpleBlockItem("red_sandstone_brick_slab", ModBlocks.RED_SANDSTONE_BRICK_SLAB);

	public static final Supplier<BlockItem> CLAY_TILES = registerSimpleBlockItem("clay_tiles", ModBlocks.CLAY_TILES);
	public static final Supplier<BlockItem> CLAY_TILE_STAIRS = registerSimpleBlockItem("clay_tile_stairs", ModBlocks.CLAY_TILE_STAIRS);
	public static final Supplier<BlockItem> CLAY_TILE_SLAB = registerSimpleBlockItem("clay_tile_slab", ModBlocks.CLAY_TILE_SLAB);
	public static final Supplier<BlockItem> JAGGED_CLAY_TILES = registerSimpleBlockItem("jagged_clay_tiles", ModBlocks.JAGGED_CLAY_TILES);

	public static final Supplier<BlockItem> PACKED_SNOW = registerSimpleBlockItem("packed_snow", ModBlocks.PACKED_SNOW);
	public static final Supplier<BlockItem> PACKED_SNOW_BRICKS = registerSimpleBlockItem("packed_snow_bricks", ModBlocks.PACKED_SNOW_BRICKS);
	public static final Supplier<BlockItem> PACKED_SNOW_BRICK_STAIRS = registerSimpleBlockItem("packed_snow_brick_stairs", ModBlocks.PACKED_SNOW_BRICK_STAIRS);
	public static final Supplier<BlockItem> PACKED_SNOW_BRICK_SLAB = registerSimpleBlockItem("packed_snow_brick_slab", ModBlocks.PACKED_SNOW_BRICK_SLAB);
	public static final Supplier<BlockItem> PACKED_SNOW_BRICK_WALL = registerSimpleBlockItem("packed_snow_brick_wall", ModBlocks.PACKED_SNOW_BRICK_WALL);
	public static final Supplier<BlockItem> POLISHED_PACKED_ICE = registerSimpleBlockItem("polished_packed_ice", ModBlocks.POLISHED_PACKED_ICE);
	public static final Supplier<BlockItem> PACKED_ICE_BRICKS = registerSimpleBlockItem("packed_ice_bricks", ModBlocks.PACKED_ICE_BRICKS);
	public static final Supplier<BlockItem> PACKED_ICE_BRICKS_STAIRS = registerSimpleBlockItem("packed_ice_brick_stairs", ModBlocks.PACKED_ICE_BRICKS_STAIRS);
	public static final Supplier<BlockItem> PACKED_ICE_BRICKS_SLAB = registerSimpleBlockItem("packed_ice_brick_slab", ModBlocks.PACKED_ICE_BRICKS_SLAB);

	public static final Supplier<BlockItem> POLISHED_OBSIDIAN = registerSimpleBlockItem("polished_obsidian", ModBlocks.POLISHED_OBSIDIAN);

	public static final Supplier<BlockItem> COPPER_BARS = registerSimpleBlockItem("copper_bars", ModBlocks.COPPER_BARS);
	public static final Supplier<BlockItem> EXPOSED_COPPER_BARS = registerSimpleBlockItem("exposed_copper_bars", ModBlocks.EXPOSED_COPPER_BARS);
	public static final Supplier<BlockItem> WEATHERED_COPPER_BARS = registerSimpleBlockItem("weathered_copper_bars", ModBlocks.WEATHERED_COPPER_BARS);
	public static final Supplier<BlockItem> OXIDIZED_COPPER_BARS = registerSimpleBlockItem("oxidized_copper_bars", ModBlocks.OXIDIZED_COPPER_BARS);
	public static final Supplier<BlockItem> WAXED_COPPER_BARS = registerSimpleBlockItem("waxed_copper_bars", ModBlocks.WAXED_COPPER_BARS);
	public static final Supplier<BlockItem> WAXED_EXPOSED_COPPER_BARS = registerSimpleBlockItem("waxed_exposed_copper_bars", ModBlocks.WAXED_EXPOSED_COPPER_BARS);
	public static final Supplier<BlockItem> WAXED_WEATHERED_COPPER_BARS = registerSimpleBlockItem("waxed_weathered_copper_bars", ModBlocks.WAXED_WEATHERED_COPPER_BARS);
	public static final Supplier<BlockItem> WAXED_OXIDIZED_COPPER_BARS = registerSimpleBlockItem("waxed_oxidized_copper_bars", ModBlocks.WAXED_OXIDIZED_COPPER_BARS);

	public static final Supplier<BlockItem> COPPER_PILLAR = registerSimpleBlockItem("copper_pillar", ModBlocks.COPPER_PILLAR);
	public static final Supplier<BlockItem> EXPOSED_COPPER_PILLAR = registerSimpleBlockItem("exposed_copper_pillar", ModBlocks.EXPOSED_COPPER_PILLAR);
	public static final Supplier<BlockItem> WEATHERED_COPPER_PILLAR = registerSimpleBlockItem("weathered_copper_pillar", ModBlocks.WEATHERED_COPPER_PILLAR);
	public static final Supplier<BlockItem> OXIDIZED_COPPER_PILLAR = registerSimpleBlockItem("oxidized_copper_pillar", ModBlocks.OXIDIZED_COPPER_PILLAR);
	public static final Supplier<BlockItem> WAXED_COPPER_PILLAR = registerSimpleBlockItem("waxed_copper_pillar", ModBlocks.WAXED_COPPER_PILLAR);
	public static final Supplier<BlockItem> WAXED_EXPOSED_COPPER_PILLAR = registerSimpleBlockItem("waxed_exposed_copper_pillar", ModBlocks.WAXED_EXPOSED_COPPER_PILLAR);
	public static final Supplier<BlockItem> WAXED_WEATHERED_COPPER_PILLAR = registerSimpleBlockItem("waxed_weathered_copper_pillar", ModBlocks.WAXED_WEATHERED_COPPER_PILLAR);
	public static final Supplier<BlockItem> WAXED_OXIDIZED_COPPER_PILLAR = registerSimpleBlockItem("waxed_oxidized_copper_pillar", ModBlocks.WAXED_OXIDIZED_COPPER_PILLAR);

	public static final Supplier<BlockItem> IRON_PLATE = registerSimpleBlockItem("iron_plate", ModBlocks.IRON_PLATE);
	public static final Supplier<BlockItem> IRON_TREAD_PLATE = registerSimpleBlockItem("iron_tread_plate", ModBlocks.IRON_TREAD_PLATE);
	public static final Supplier<BlockItem> IRON_TREAD_PLATE_STAIRS = registerSimpleBlockItem("iron_tread_plate_stairs", ModBlocks.IRON_TREAD_PLATE_STAIRS);
	public static final Supplier<BlockItem> IRON_TREAD_PLATE_SLAB = registerSimpleBlockItem("iron_tread_plate_slab", ModBlocks.IRON_TREAD_PLATE_SLAB);
	public static final Supplier<BlockItem> CORRUGATED_IRON_PLATE = registerSimpleBlockItem("corrugated_iron_plate", ModBlocks.CORRUGATED_IRON_PLATE);
	public static final Supplier<BlockItem> CORRUGATED_IRON_PLATE_STAIRS = registerSimpleBlockItem("corrugated_iron_plate_stairs", ModBlocks.CORRUGATED_IRON_PLATE_STAIRS);
	public static final Supplier<BlockItem> CORRUGATED_IRON_PLATE_SLAB = registerSimpleBlockItem("corrugated_iron_plate_slab", ModBlocks.CORRUGATED_IRON_PLATE_SLAB);
	public static final Supplier<BlockItem> IRON_PLATE_PILLAR = registerSimpleBlockItem("iron_plate_pillar", ModBlocks.IRON_PLATE_PILLAR);
	public static final Supplier<BlockItem> IRON_PLATE_DOOR = registerSimpleBlockItem("iron_plate_door", ModBlocks.IRON_PLATE_DOOR);
	public static final Supplier<BlockItem> IRON_PLATE_TRAPDOOR = registerSimpleBlockItem("iron_plate_trapdoor", ModBlocks.IRON_PLATE_TRAPDOOR);

	public static final Supplier<BlockItem> CHISELED_GOLD = registerSimpleBlockItem("chiseled_gold", ModBlocks.CHISELED_GOLD);
	public static final Supplier<BlockItem> GOLDEN_TILES = registerSimpleBlockItem("golden_tiles", ModBlocks.GOLDEN_TILES);
	public static final Supplier<BlockItem> GOLDEN_BRICKS = registerSimpleBlockItem("golden_bricks", ModBlocks.GOLDEN_BRICKS);
	public static final Supplier<BlockItem> GOLDEN_BRICK_STAIRS = registerSimpleBlockItem("golden_brick_stairs", ModBlocks.GOLDEN_BRICK_STAIRS);
	public static final Supplier<BlockItem> GOLDEN_BRICK_SLAB = registerSimpleBlockItem("golden_brick_slab", ModBlocks.GOLDEN_BRICK_SLAB);
	public static final Supplier<BlockItem> GOLDEN_PILLAR = registerSimpleBlockItem("golden_pillar", ModBlocks.GOLDEN_PILLAR);
	public static final Supplier<BlockItem> GOLDEN_DOOR = registerSimpleBlockItem("golden_door", ModBlocks.GOLDEN_DOOR);
	public static final Supplier<BlockItem> GOLDEN_TRAPDOOR = registerSimpleBlockItem("golden_trapdoor", ModBlocks.GOLDEN_TRAPDOOR);
	public static final Supplier<BlockItem> GOLDEN_BARS = registerSimpleBlockItem("golden_bars", ModBlocks.GOLDEN_BARS);

	public static final Supplier<BlockItem> POLISHED_AMETHYST = registerSimpleBlockItem("polished_amethyst", ModBlocks.POLISHED_AMETHYST);
	public static final Supplier<BlockItem> CUT_AMETHYST = registerSimpleBlockItem("cut_amethyst", ModBlocks.CUT_AMETHYST);
	public static final Supplier<BlockItem> CUT_AMETHYST_STAIRS = registerSimpleBlockItem("cut_amethyst_stairs", ModBlocks.CUT_AMETHYST_STAIRS);
	public static final Supplier<BlockItem> CUT_AMETHYST_SLAB = registerSimpleBlockItem("cut_amethyst_slab", ModBlocks.CUT_AMETHYST_SLAB);
	public static final Supplier<BlockItem> CHISELED_AMETHYST = registerSimpleBlockItem("chiseled_amethyst", ModBlocks.CHISELED_AMETHYST);
	public static final Supplier<BlockItem> CHISELED_AMETHYST_STAIRS = registerSimpleBlockItem("chiseled_amethyst_stairs", ModBlocks.CHISELED_AMETHYST_STAIRS);
	public static final Supplier<BlockItem> CHISELED_AMETHYST_SLAB = registerSimpleBlockItem("chiseled_amethyst_slab", ModBlocks.CHISELED_AMETHYST_SLAB);

	public static final Supplier<BlockItem> LAPIS_LAZULI_BRICKS = registerSimpleBlockItem("lapis_lazuli_bricks", ModBlocks.LAPIS_LAZULI_BRICKS);
	public static final Supplier<BlockItem> LAPIS_LAZULI_MOSAIC = registerSimpleBlockItem("lapis_lazuli_mosaic", ModBlocks.LAPIS_LAZULI_MOSAIC);

	public static final Supplier<BlockItem> OAK_SEAT = registerSimpleBlockItem("oak_seat", ModBlocks.OAK_SEAT);
	public static final Supplier<BlockItem> SPRUCE_SEAT = registerSimpleBlockItem("spruce_seat", ModBlocks.SPRUCE_SEAT);
	public static final Supplier<BlockItem> BIRCH_SEAT = registerSimpleBlockItem("birch_seat", ModBlocks.BIRCH_SEAT);
	public static final Supplier<BlockItem> JUNGLE_SEAT = registerSimpleBlockItem("jungle_seat", ModBlocks.JUNGLE_SEAT);
	public static final Supplier<BlockItem> ACACIA_SEAT = registerSimpleBlockItem("acacia_seat", ModBlocks.ACACIA_SEAT);
	public static final Supplier<BlockItem> DARK_OAK_SEAT = registerSimpleBlockItem("dark_oak_seat", ModBlocks.DARK_OAK_SEAT);
	public static final Supplier<BlockItem> MANGROVE_SEAT = registerSimpleBlockItem("mangrove_seat", ModBlocks.MANGROVE_SEAT);
	public static final Supplier<BlockItem> CHERRY_SEAT = registerSimpleBlockItem("cherry_seat", ModBlocks.CHERRY_SEAT);
	public static final Supplier<BlockItem> CRIMSON_SEAT = registerSimpleBlockItem("crimson_seat", ModBlocks.CRIMSON_SEAT);
	public static final Supplier<BlockItem> WARPED_SEAT = registerSimpleBlockItem("warped_seat", ModBlocks.WARPED_SEAT);

	public static final Supplier<BlockItem> OAK_PALISADE = registerSimpleBlockItem("oak_palisade", ModBlocks.OAK_PALISADE);
	public static final Supplier<BlockItem> SPIKED_OAK_PALISADE = registerSimpleBlockItem("spiked_oak_palisade", ModBlocks.SPIKED_OAK_PALISADE);
	public static final Supplier<BlockItem> SPRUCE_PALISADE = registerSimpleBlockItem("spruce_palisade", ModBlocks.SPRUCE_PALISADE);
	public static final Supplier<BlockItem> SPIKED_SPRUCE_PALISADE = registerSimpleBlockItem("spiked_spruce_palisade", ModBlocks.SPIKED_SPRUCE_PALISADE);
	public static final Supplier<BlockItem> BIRCH_PALISADE = registerSimpleBlockItem("birch_palisade", ModBlocks.BIRCH_PALISADE);
	public static final Supplier<BlockItem> SPIKED_BIRCH_PALISADE = registerSimpleBlockItem("spiked_birch_palisade", ModBlocks.SPIKED_BIRCH_PALISADE);
	public static final Supplier<BlockItem> JUNGLE_PALISADE = registerSimpleBlockItem("jungle_palisade", ModBlocks.JUNGLE_PALISADE);
	public static final Supplier<BlockItem> SPIKED_JUNGLE_PALISADE = registerSimpleBlockItem("spiked_jungle_palisade", ModBlocks.SPIKED_JUNGLE_PALISADE);
	public static final Supplier<BlockItem> ACACIA_PALISADE = registerSimpleBlockItem("acacia_palisade", ModBlocks.ACACIA_PALISADE);
	public static final Supplier<BlockItem> SPIKED_ACACIA_PALISADE = registerSimpleBlockItem("spiked_acacia_palisade", ModBlocks.SPIKED_ACACIA_PALISADE);
	public static final Supplier<BlockItem> DARK_OAK_PALISADE = registerSimpleBlockItem("dark_oak_palisade", ModBlocks.DARK_OAK_PALISADE);
	public static final Supplier<BlockItem> SPIKED_DARK_OAK_PALISADE = registerSimpleBlockItem("spiked_dark_oak_palisade", ModBlocks.SPIKED_DARK_OAK_PALISADE);
	public static final Supplier<BlockItem> MANGROVE_PALISADE = registerSimpleBlockItem("mangrove_palisade", ModBlocks.MANGROVE_PALISADE);
	public static final Supplier<BlockItem> SPIKED_MANGROVE_PALISADE = registerSimpleBlockItem("spiked_mangrove_palisade", ModBlocks.SPIKED_MANGROVE_PALISADE);
	public static final Supplier<BlockItem> CHERRY_PALISADE = registerSimpleBlockItem("cherry_palisade", ModBlocks.CHERRY_PALISADE);
	public static final Supplier<BlockItem> SPIKED_CHERRY_PALISADE = registerSimpleBlockItem("spiked_cherry_palisade", ModBlocks.SPIKED_CHERRY_PALISADE);
	public static final Supplier<BlockItem> CRIMSON_PALISADE = registerSimpleBlockItem("crimson_palisade", ModBlocks.CRIMSON_PALISADE);
	public static final Supplier<BlockItem> SPIKED_CRIMSON_PALISADE = registerSimpleBlockItem("spiked_crimson_palisade", ModBlocks.SPIKED_CRIMSON_PALISADE);
	public static final Supplier<BlockItem> WARPED_PALISADE = registerSimpleBlockItem("warped_palisade", ModBlocks.WARPED_PALISADE);
	public static final Supplier<BlockItem> SPIKED_WARPED_PALISADE = registerSimpleBlockItem("spiked_warped_palisade", ModBlocks.SPIKED_WARPED_PALISADE);

	public static final Supplier<BlockItem> BRAZIER = registerSimpleBlockItem("brazier", ModBlocks.BRAZIER);
	public static final Supplier<BlockItem> SOUL_BRAZIER = registerSimpleBlockItem("soul_brazier", ModBlocks.SOUL_BRAZIER);

	public static final Supplier<Item> WHITE_SKY_LANTERN = registerItem("white_sky_lantern", () -> new SkyLanternItem(ModBlocks.WHITE_SKY_LANTERN.get(), new Item.Properties()));
	public static final Supplier<Item> LIGHT_GRAY_SKY_LANTERN = registerItem("light_gray_sky_lantern", () -> new SkyLanternItem(ModBlocks.LIGHT_GRAY_SKY_LANTERN.get(), new Item.Properties()));
	public static final Supplier<Item> GRAY_SKY_LANTERN = registerItem("gray_sky_lantern", () -> new SkyLanternItem(ModBlocks.GRAY_SKY_LANTERN.get(), new Item.Properties()));
	public static final Supplier<Item> BLACK_SKY_LANTERN = registerItem("black_sky_lantern", () -> new SkyLanternItem(ModBlocks.BLACK_SKY_LANTERN.get(), new Item.Properties()));
	public static final Supplier<Item> BROWN_SKY_LANTERN = registerItem("brown_sky_lantern", () -> new SkyLanternItem(ModBlocks.BROWN_SKY_LANTERN.get(), new Item.Properties()));
	public static final Supplier<Item> RED_SKY_LANTERN = registerItem("red_sky_lantern", () -> new SkyLanternItem(ModBlocks.RED_SKY_LANTERN.get(), new Item.Properties()));
	public static final Supplier<Item> ORANGE_SKY_LANTERN = registerItem("orange_sky_lantern", () -> new SkyLanternItem(ModBlocks.ORANGE_SKY_LANTERN.get(), new Item.Properties()));
	public static final Supplier<Item> YELLOW_SKY_LANTERN = registerItem("yellow_sky_lantern", () -> new SkyLanternItem(ModBlocks.YELLOW_SKY_LANTERN.get(), new Item.Properties()));
	public static final Supplier<Item> LIME_SKY_LANTERN = registerItem("lime_sky_lantern", () -> new SkyLanternItem(ModBlocks.LIME_SKY_LANTERN.get(), new Item.Properties()));
	public static final Supplier<Item> GREEN_SKY_LANTERN = registerItem("green_sky_lantern", () -> new SkyLanternItem(ModBlocks.GREEN_SKY_LANTERN.get(), new Item.Properties()));
	public static final Supplier<Item> CYAN_SKY_LANTERN = registerItem("cyan_sky_lantern", () -> new SkyLanternItem(ModBlocks.CYAN_SKY_LANTERN.get(), new Item.Properties()));
	public static final Supplier<Item> LIGHT_BLUE_SKY_LANTERN = registerItem("light_blue_sky_lantern", () -> new SkyLanternItem(ModBlocks.LIGHT_BLUE_SKY_LANTERN.get(), new Item.Properties()));
	public static final Supplier<Item> BLUE_SKY_LANTERN = registerItem("blue_sky_lantern", () -> new SkyLanternItem(ModBlocks.BLUE_SKY_LANTERN.get(), new Item.Properties()));
	public static final Supplier<Item> PURPLE_SKY_LANTERN = registerItem("purple_sky_lantern", () -> new SkyLanternItem(ModBlocks.PURPLE_SKY_LANTERN.get(), new Item.Properties()));
	public static final Supplier<Item> MAGENTA_SKY_LANTERN = registerItem("magenta_sky_lantern", () -> new SkyLanternItem(ModBlocks.MAGENTA_SKY_LANTERN.get(), new Item.Properties()));
	public static final Supplier<Item> PINK_SKY_LANTERN = registerItem("pink_sky_lantern", () -> new SkyLanternItem(ModBlocks.PINK_SKY_LANTERN.get(), new Item.Properties()));
}
