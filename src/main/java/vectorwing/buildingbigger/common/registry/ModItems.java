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

	public static final Supplier<BlockItem> SANDSTONE_BRICKS = registerSimpleBlockItem("sandstone_bricks", ModBlocks.SANDSTONE_BRICKS);
	public static final Supplier<BlockItem> RED_SANDSTONE_BRICKS = registerSimpleBlockItem("red_sandstone_bricks", ModBlocks.RED_SANDSTONE_BRICKS);

	public static final Supplier<BlockItem> CLAY_TILES = registerSimpleBlockItem("clay_tiles", ModBlocks.CLAY_TILES);

	public static final Supplier<BlockItem> PACKED_SNOW = registerSimpleBlockItem("packed_snow", ModBlocks.PACKED_SNOW);
	public static final Supplier<BlockItem> PACKED_SNOW_BRICKS = registerSimpleBlockItem("packed_snow_bricks", ModBlocks.PACKED_SNOW_BRICKS);
	public static final Supplier<BlockItem> POLISHED_PACKED_ICE = registerSimpleBlockItem("polished_packed_ice", ModBlocks.POLISHED_PACKED_ICE);
	public static final Supplier<BlockItem> PACKED_ICE_BRICKS = registerSimpleBlockItem("packed_ice_bricks", ModBlocks.PACKED_ICE_BRICKS);

	public static final Supplier<BlockItem> IRON_PLATE = registerSimpleBlockItem("iron_plate", ModBlocks.IRON_PLATE);
	public static final Supplier<BlockItem> IRON_TREAD_PLATE = registerSimpleBlockItem("iron_tread_plate", ModBlocks.IRON_TREAD_PLATE);
	public static final Supplier<BlockItem> CORRUGATED_IRON_PLATE = registerSimpleBlockItem("corrugated_iron_plate", ModBlocks.CORRUGATED_IRON_PLATE);
	public static final Supplier<BlockItem> IRON_PLATE_PILLAR = registerSimpleBlockItem("iron_plate_pillar", ModBlocks.IRON_PLATE_PILLAR);

	public static final Supplier<BlockItem> GOLDEN_TILES = registerSimpleBlockItem("golden_tiles", ModBlocks.GOLDEN_TILES);
	public static final Supplier<BlockItem> GOLDEN_BRICKS = registerSimpleBlockItem("golden_bricks", ModBlocks.GOLDEN_BRICKS);
	public static final Supplier<BlockItem> GOLDEN_PILLAR = registerSimpleBlockItem("golden_pillar", ModBlocks.GOLDEN_PILLAR);
}
