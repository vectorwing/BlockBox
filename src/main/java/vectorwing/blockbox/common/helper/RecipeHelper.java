package vectorwing.blockbox.common.helper;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.ItemLike;
import vectorwing.blockbox.BlockBox;

public class RecipeHelper
{
	public static Identifier modIdentifier(String path) {
		return Identifier.fromNamespaceAndPath(BlockBox.MODID, path);
	}

	public static String itemName(ItemLike itemLike) {
		return BuiltInRegistries.ITEM.getKey(itemLike.asItem()).getPath();
	}
}
