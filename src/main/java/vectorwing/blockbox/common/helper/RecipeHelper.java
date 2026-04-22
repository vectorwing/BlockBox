package vectorwing.blockbox.common.helper;

import net.minecraft.resources.Identifier;
import vectorwing.blockbox.BlockBox;

public class RecipeHelper
{
	public static Identifier modIdentifier(String path) {
		return Identifier.fromNamespaceAndPath(BlockBox.MODID, path);
	}
}
