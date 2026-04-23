package vectorwing.blockbox;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.neoforged.neoforge.common.ModConfigSpec;

public class Config
{
	private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

	public static final ModConfigSpec.BooleanValue ADD_ITEMS_TO_VANILLA_TABS = BUILDER
			.comment("Should the items from this mod be organized within vanilla tabs? They will be placed together with similar block sets.")
			.define("addItemsToVanillaTabs", true);

	public static final ModConfigSpec SPEC = BUILDER.build();
}
