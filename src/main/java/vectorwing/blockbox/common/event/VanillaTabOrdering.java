package vectorwing.blockbox.common.event;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import vectorwing.blockbox.common.registry.ModItems;

import java.util.LinkedHashMap;
import java.util.function.Supplier;

public class VanillaTabOrdering
{
	public static final LinkedHashMap<Supplier<? extends Item>, ItemLike> BUILDING_BLOCKS = new LinkedHashMap<>();
	public static final LinkedHashMap<Supplier<? extends Item>, ItemLike> FUNCTIONAL_BLOCKS = new LinkedHashMap<>();

	static {
		FUNCTIONAL_BLOCKS.put(ModItems.BRAZIER, Items.SOUL_CAMPFIRE);
		FUNCTIONAL_BLOCKS.put(ModItems.SOUL_BRAZIER, Items.SOUL_CAMPFIRE);
		FUNCTIONAL_BLOCKS.put(ModItems.WHITE_SKY_LANTERN, Items.PINK_CANDLE);
		FUNCTIONAL_BLOCKS.put(ModItems.LIGHT_GRAY_SKY_LANTERN, Items.PINK_CANDLE);
		FUNCTIONAL_BLOCKS.put(ModItems.GRAY_SKY_LANTERN, Items.PINK_CANDLE);
		FUNCTIONAL_BLOCKS.put(ModItems.BLACK_SKY_LANTERN, Items.PINK_CANDLE);
		FUNCTIONAL_BLOCKS.put(ModItems.BROWN_SKY_LANTERN, Items.PINK_CANDLE);
		FUNCTIONAL_BLOCKS.put(ModItems.RED_SKY_LANTERN, Items.PINK_CANDLE);
		FUNCTIONAL_BLOCKS.put(ModItems.ORANGE_SKY_LANTERN, Items.PINK_CANDLE);
		FUNCTIONAL_BLOCKS.put(ModItems.YELLOW_SKY_LANTERN, Items.PINK_CANDLE);
		FUNCTIONAL_BLOCKS.put(ModItems.LIME_SKY_LANTERN, Items.PINK_CANDLE);
		FUNCTIONAL_BLOCKS.put(ModItems.GREEN_SKY_LANTERN, Items.PINK_CANDLE);
		FUNCTIONAL_BLOCKS.put(ModItems.CYAN_SKY_LANTERN, Items.PINK_CANDLE);
		FUNCTIONAL_BLOCKS.put(ModItems.LIGHT_BLUE_SKY_LANTERN, Items.PINK_CANDLE);
		FUNCTIONAL_BLOCKS.put(ModItems.BLUE_SKY_LANTERN, Items.PINK_CANDLE);
		FUNCTIONAL_BLOCKS.put(ModItems.PURPLE_SKY_LANTERN, Items.PINK_CANDLE);
		FUNCTIONAL_BLOCKS.put(ModItems.MAGENTA_SKY_LANTERN, Items.PINK_CANDLE);
		FUNCTIONAL_BLOCKS.put(ModItems.PINK_SKY_LANTERN, Items.PINK_CANDLE);
	}
}
