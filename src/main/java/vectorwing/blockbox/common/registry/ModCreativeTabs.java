package vectorwing.blockbox.common.registry;

//? fabric
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import vectorwing.blockbox.BlockBox;

import java.util.function.Supplier;

public class ModCreativeTabs
{

	public static final Supplier<CreativeModeTab> TAB_BLOCK_BOX = register("example_tab", () ->
			//? fabric
			FabricCreativeModeTab.builder()
			//? neoforge
			/*CreativeModeTab.builder()*/
			.title(Component.translatable("itemGroup." + BlockBox.MODID))
			.icon(() -> ModItems.CHISELED_GOLD.get().getDefaultInstance())
			.displayItems((parameters, output) -> ModItems.CREATIVE_TAB_ITEMS.forEach((item) -> {
				output.accept(item.get());
			}))
			.build());

	private static Supplier<CreativeModeTab> register(String name, Supplier<CreativeModeTab> tabSupplier) {
		CreativeModeTab tab = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, Identifier.fromNamespaceAndPath(BlockBox.MODID, name), tabSupplier.get());
		return ()->tab;
	}

	public static void register() {

	}
}
