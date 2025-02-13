package vectorwing.blockbox.common.event;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import vectorwing.blockbox.common.registry.ModItems;

import java.util.LinkedHashMap;
import java.util.function.Supplier;

public class VanillaTabOrdering
{
	public static final LinkedHashMap<Supplier<? extends Item>, ItemLike> BUILDING_BLOCKS = new LinkedHashMap<>();
	public static final LinkedHashMap<Supplier<? extends Item>, ItemLike> FUNCTIONAL_BLOCKS = new LinkedHashMap<>();
}
