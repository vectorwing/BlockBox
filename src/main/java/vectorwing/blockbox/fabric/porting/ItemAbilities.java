//? fabric {
/*package vectorwing.blockbox.fabric.porting;

import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.ItemStack;
import org.jspecify.annotations.Nullable;
import vectorwing.blockbox.common.tag.CommonTags;

public class ItemAbilities {
	public static final ItemAbility AXE_STRIP = new ItemAbility(ItemTags.AXES);
	public static final ItemAbility FIRESTARTER_LIGHT = new ItemAbility(CommonTags.Items.IGNITERS);
	public static final ItemAbility SHOVEL_DOUSE = new ItemAbility(ItemTags.SHOVELS);

	public static @Nullable ItemAbility get(ItemStack itemInHand) {
		if (itemInHand.is(AXE_STRIP.tagKey())) {
			return AXE_STRIP;
		}
		else if (itemInHand.is(FIRESTARTER_LIGHT.tagKey())) {
			return FIRESTARTER_LIGHT;
		}
		else if (itemInHand.is(SHOVEL_DOUSE.tagKey())) {
			return SHOVEL_DOUSE;
		}
		return null;
	}
}
*///?}