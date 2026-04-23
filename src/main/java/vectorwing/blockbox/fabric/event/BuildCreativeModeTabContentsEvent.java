//? fabric {
package vectorwing.blockbox.fabric.event;

import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTabOutput;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import java.util.Collections;

public class BuildCreativeModeTabContentsEvent {
	private final ResourceKey<CreativeModeTab> tabKey;
	private final FabricCreativeModeTabOutput output;

	public BuildCreativeModeTabContentsEvent(CreativeModeTab tab, FabricCreativeModeTabOutput output) {
		this.tabKey = BuiltInRegistries.CREATIVE_MODE_TAB.getResourceKey(tab).orElse(null);
		this.output = output;
	}

	public ResourceKey<CreativeModeTab> getTabKey() {
		return tabKey;
	}

	public void insertAfter(ItemStack anchor, ItemStack newStack, CreativeModeTab.TabVisibility tabVisibility) {
		output.insertAfter(anchor, Collections.singleton(newStack), tabVisibility);
	}
}
//?}