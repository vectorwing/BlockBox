package vectorwing.buildingbigger.common.registry;

import com.google.common.collect.Sets;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredRegister;
import vectorwing.buildingbigger.BuildingBigger;

import java.util.LinkedHashSet;
import java.util.function.Supplier;

@SuppressWarnings("unused")
public class ModItems
{
	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(BuildingBigger.MODID);
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
	public static final Supplier<BlockItem> POLISHED_PACKED_ICE = registerSimpleBlockItem("polished_packed_ice", ModBlocks.POLISHED_PACKED_ICE);
	public static final Supplier<BlockItem> PACKED_ICE_BRICKS = registerSimpleBlockItem("packed_ice_bricks", ModBlocks.PACKED_ICE_BRICKS);
	public static final Supplier<BlockItem> PACKED_ICE_BRICKS_STAIRS = registerSimpleBlockItem("packed_ice_brick_stairs", ModBlocks.PACKED_ICE_BRICKS_STAIRS);
	public static final Supplier<BlockItem> PACKED_ICE_BRICKS_SLAB = registerSimpleBlockItem("packed_ice_brick_slab", ModBlocks.PACKED_ICE_BRICKS_SLAB);

	public static final Supplier<BlockItem> IRON_PLATE = registerSimpleBlockItem("iron_plate", ModBlocks.IRON_PLATE);
	public static final Supplier<BlockItem> IRON_TREAD_PLATE = registerSimpleBlockItem("iron_tread_plate", ModBlocks.IRON_TREAD_PLATE);
	public static final Supplier<BlockItem> IRON_TREAD_PLATE_STAIRS = registerSimpleBlockItem("iron_tread_plate_stairs", ModBlocks.IRON_TREAD_PLATE_STAIRS);
	public static final Supplier<BlockItem> IRON_TREAD_PLATE_SLAB = registerSimpleBlockItem("iron_tread_plate_slab", ModBlocks.IRON_TREAD_PLATE_SLAB);
	public static final Supplier<BlockItem> CORRUGATED_IRON_PLATE = registerSimpleBlockItem("corrugated_iron_plate", ModBlocks.CORRUGATED_IRON_PLATE);
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

	public static final Supplier<BlockItem> POLISHED_AMETHYST = registerSimpleBlockItem("polished_amethyst", ModBlocks.POLISHED_AMETHYST);
	public static final Supplier<BlockItem> CUT_AMETHYST = registerSimpleBlockItem("cut_amethyst", ModBlocks.CUT_AMETHYST);
	public static final Supplier<BlockItem> CUT_AMETHYST_STAIRS = registerSimpleBlockItem("cut_amethyst_stairs", ModBlocks.CUT_AMETHYST_STAIRS);
	public static final Supplier<BlockItem> CUT_AMETHYST_SLAB = registerSimpleBlockItem("cut_amethyst_slab", ModBlocks.CUT_AMETHYST_SLAB);
	public static final Supplier<BlockItem> CHISELED_AMETHYST = registerSimpleBlockItem("chiseled_amethyst", ModBlocks.CHISELED_AMETHYST);
	public static final Supplier<BlockItem> CHISELED_AMETHYST_STAIRS = registerSimpleBlockItem("chiseled_amethyst_stairs", ModBlocks.CHISELED_AMETHYST_STAIRS);
	public static final Supplier<BlockItem> CHISELED_AMETHYST_SLAB = registerSimpleBlockItem("chiseled_amethyst_slab", ModBlocks.CHISELED_AMETHYST_SLAB);
}
