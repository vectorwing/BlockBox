package vectorwing.buildingbigger;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.common.ModConfigSpec;

public class Config
{
	private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

	private static final ModConfigSpec.BooleanValue ADD_ITEMS_TO_VANILLA_TABS = BUILDER
			.comment("Should the items from this mod be organized within vanilla tabs? They will be placed together with similar block sets.")
			.define("addItemsToVanillaTabs", true);

	private static final ModConfigSpec.BooleanValue ENABLE_MOD_CREATIVE_TAB = BUILDER
			.comment("Should this mod have its own Creative tab?")
			.define("enableModCreativeTab", true);

	static final ModConfigSpec SPEC = BUILDER.build();

	private static boolean validateItemName(final Object obj) {
		return obj instanceof String itemName && BuiltInRegistries.ITEM.containsKey(ResourceLocation.parse(itemName));
	}
}
