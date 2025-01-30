package vectorwing.blockbox.common.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import vectorwing.blockbox.BlockBox;

public class ModCreativeTabs
{
	public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BlockBox.MODID);

	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> TAB_BUILDING_BIGGER = CREATIVE_MODE_TABS.register("example_tab", () -> CreativeModeTab.builder()
			.title(Component.translatable("itemGroup." + BlockBox.MODID))
			.icon(() -> ModItems.MALLET.get().getDefaultInstance())
			.displayItems((parameters, output) -> ModItems.CREATIVE_TAB_ITEMS.forEach((item) -> output.accept(item.get())))
			.build());
}
