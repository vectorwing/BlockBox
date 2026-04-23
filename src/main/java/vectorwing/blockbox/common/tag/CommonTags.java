package vectorwing.blockbox.common.tag;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class CommonTags {
	public static class Items {

		public static final TagKey<Item> RODS_WOODEN = commonItemTag("rods/wooden");
		public static final TagKey<Item> FIRESTARTERS = commonItemTag("firestarters");
	}

	private static TagKey<Item> commonItemTag(String path) {
		return TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath("c", path));
	}
}
