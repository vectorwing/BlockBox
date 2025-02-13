package vectorwing.blockbox.common.event;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.RegisterEvent;
import vectorwing.blockbox.BlockBox;
import vectorwing.blockbox.Config;
import vectorwing.blockbox.common.registry.ModBlocks;
import vectorwing.blockbox.common.registry.ModItems;

@EventBusSubscriber(modid = BlockBox.MODID, bus = EventBusSubscriber.Bus.MOD)
@SuppressWarnings("unused")
public class CommonEvents
{
	// TODO: Remap the following IDs:
	// clay_tiles -> tiles
	// jagged_clay_tiles -> broken_tile_mosaic

	@SubscribeEvent
	public static void addItemsToVanillaCreativeTabs(BuildCreativeModeTabContentsEvent event) {
		if (!Config.ADD_ITEMS_TO_VANILLA_TABS.get()) {
			return;
		}

		if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
			VanillaTabOrdering.BUILDING_BLOCKS.reversed().forEach((item, startingPoint) -> event.insertAfter(new ItemStack(startingPoint), new ItemStack(item.get()), CreativeModeTab.TabVisibility.PARENT_TAB_ONLY));
		}
		if (event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
			// TODO: Figure out a better way of handling the methods which organize this. Manual or automated?
//			VanillaTabOrdering.FUNCTIONAL_BLOCKS.reversed().forEach((item, startingPoint) -> {
//				event.insertAfter(new ItemStack(startingPoint), new ItemStack(item.get()), CreativeModeTab.TabVisibility.PARENT_TAB_ONLY);
//			});
			event.insertAfter(new ItemStack(Items.SOUL_CAMPFIRE), new ItemStack(ModItems.SOUL_BRAZIER.get()), CreativeModeTab.TabVisibility.PARENT_TAB_ONLY);
			event.insertAfter(new ItemStack(Items.SOUL_CAMPFIRE), new ItemStack(ModItems.BRAZIER.get()), CreativeModeTab.TabVisibility.PARENT_TAB_ONLY);
			event.insertAfter(new ItemStack(Items.PINK_CANDLE), new ItemStack(ModItems.PINK_SKY_LANTERN.get()), CreativeModeTab.TabVisibility.PARENT_TAB_ONLY);
			event.insertAfter(new ItemStack(Items.PINK_CANDLE), new ItemStack(ModItems.MAGENTA_SKY_LANTERN.get()), CreativeModeTab.TabVisibility.PARENT_TAB_ONLY);
			event.insertAfter(new ItemStack(Items.PINK_CANDLE), new ItemStack(ModItems.PURPLE_SKY_LANTERN.get()), CreativeModeTab.TabVisibility.PARENT_TAB_ONLY);
			event.insertAfter(new ItemStack(Items.PINK_CANDLE), new ItemStack(ModItems.BLUE_SKY_LANTERN.get()), CreativeModeTab.TabVisibility.PARENT_TAB_ONLY);
			event.insertAfter(new ItemStack(Items.PINK_CANDLE), new ItemStack(ModItems.LIGHT_BLUE_SKY_LANTERN.get()), CreativeModeTab.TabVisibility.PARENT_TAB_ONLY);
			event.insertAfter(new ItemStack(Items.PINK_CANDLE), new ItemStack(ModItems.CYAN_SKY_LANTERN.get()), CreativeModeTab.TabVisibility.PARENT_TAB_ONLY);
			event.insertAfter(new ItemStack(Items.PINK_CANDLE), new ItemStack(ModItems.GREEN_SKY_LANTERN.get()), CreativeModeTab.TabVisibility.PARENT_TAB_ONLY);
			event.insertAfter(new ItemStack(Items.PINK_CANDLE), new ItemStack(ModItems.LIME_SKY_LANTERN.get()), CreativeModeTab.TabVisibility.PARENT_TAB_ONLY);
			event.insertAfter(new ItemStack(Items.PINK_CANDLE), new ItemStack(ModItems.YELLOW_SKY_LANTERN.get()), CreativeModeTab.TabVisibility.PARENT_TAB_ONLY);
			event.insertAfter(new ItemStack(Items.PINK_CANDLE), new ItemStack(ModItems.ORANGE_SKY_LANTERN.get()), CreativeModeTab.TabVisibility.PARENT_TAB_ONLY);
			event.insertAfter(new ItemStack(Items.PINK_CANDLE), new ItemStack(ModItems.RED_SKY_LANTERN.get()), CreativeModeTab.TabVisibility.PARENT_TAB_ONLY);
			event.insertAfter(new ItemStack(Items.PINK_CANDLE), new ItemStack(ModItems.BROWN_SKY_LANTERN.get()), CreativeModeTab.TabVisibility.PARENT_TAB_ONLY);
			event.insertAfter(new ItemStack(Items.PINK_CANDLE), new ItemStack(ModItems.BLACK_SKY_LANTERN.get()), CreativeModeTab.TabVisibility.PARENT_TAB_ONLY);
			event.insertAfter(new ItemStack(Items.PINK_CANDLE), new ItemStack(ModItems.GRAY_SKY_LANTERN.get()), CreativeModeTab.TabVisibility.PARENT_TAB_ONLY);
			event.insertAfter(new ItemStack(Items.PINK_CANDLE), new ItemStack(ModItems.LIGHT_GRAY_SKY_LANTERN.get()), CreativeModeTab.TabVisibility.PARENT_TAB_ONLY);
			event.insertAfter(new ItemStack(Items.PINK_CANDLE), new ItemStack(ModItems.WHITE_SKY_LANTERN.get()), CreativeModeTab.TabVisibility.PARENT_TAB_ONLY);
		}
	}
}
