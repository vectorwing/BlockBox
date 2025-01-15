package vectorwing.buildingbigger.data.provider;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import vectorwing.buildingbigger.BuildingBigger;
import vectorwing.buildingbigger.common.registry.ModItems;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ItemModels extends ItemModelProvider
{
	public static final String GENERATED = "item/generated";
	public static final String HANDHELD = "item/handheld";

	public ItemModels(PackOutput output, ExistingFileHelper existingFileHelper) {
		super(output, BuildingBigger.MODID, existingFileHelper);
	}

	@Override
	protected void registerModels() {
		Set<Item> items = BuiltInRegistries.ITEM.stream().filter(i -> BuildingBigger.MODID.equals(BuiltInRegistries.ITEM.getKey(i).getNamespace()))
				.collect(Collectors.toSet());

		palisadeModel(ModItems.OAK_PALISADE.get());
		items.remove(ModItems.OAK_PALISADE.get());
		palisadeModel(ModItems.SPIKED_OAK_PALISADE.get());
		items.remove(ModItems.SPIKED_OAK_PALISADE.get());
		palisadeModel(ModItems.BIRCH_PALISADE.get());
		items.remove(ModItems.BIRCH_PALISADE.get());
		palisadeModel(ModItems.SPIKED_BIRCH_PALISADE.get());
		items.remove(ModItems.SPIKED_BIRCH_PALISADE.get());

		trapdoorModel(ModItems.IRON_PLATE_TRAPDOOR.get());
		items.remove(ModItems.IRON_PLATE_TRAPDOOR.get());
		trapdoorModel(ModItems.GOLDEN_TRAPDOOR.get());
		items.remove(ModItems.GOLDEN_TRAPDOOR.get());

		itemGeneratedModel(ModItems.IRON_PLATE_DOOR.get(), resourceItem(itemName(ModItems.IRON_PLATE_DOOR.get())));
		items.remove(ModItems.IRON_PLATE_DOOR.get());
		itemGeneratedModel(ModItems.GOLDEN_DOOR.get(), resourceItem(itemName(ModItems.GOLDEN_DOOR.get())));
		items.remove(ModItems.GOLDEN_DOOR.get());

		// Blocks with 3D models
		takeAll(items, i -> i instanceof BlockItem).forEach(item -> blockBasedModel(item, ""));
	}

	public void palisadeModel(Item item) {
		blockBasedModel(item, "_post");
	}

	public void trapdoorModel(Item item) {
		blockBasedModel(item, "_bottom");
	}

	public void blockBasedModel(Item item, String suffix) {
		withExistingParent(itemName(item), resourceBlock(itemName(item) + suffix));
	}

	public void itemHandheldModel(Item item, ResourceLocation texture) {
		withExistingParent(itemName(item), HANDHELD).texture("layer0", texture);
	}

	public void itemGeneratedModel(Item item, ResourceLocation texture) {
		withExistingParent(itemName(item), GENERATED).texture("layer0", texture);
	}

	private String itemName(Item item) {
		return BuiltInRegistries.ITEM.getKey(item).getPath();
	}

	public ResourceLocation resourceBlock(String path) {
		return ResourceLocation.fromNamespaceAndPath(BuildingBigger.MODID, "block/" + path);
	}

	public ResourceLocation resourceItem(String path) {
		return ResourceLocation.fromNamespaceAndPath(BuildingBigger.MODID, "item/" + path);
	}

	public static <T> Collection<T> takeAll(Set<T> src, Predicate<T> pred) {
		List<T> ret = new ArrayList<>();

		Iterator<T> iter = src.iterator();
		while (iter.hasNext()) {
			T item = iter.next();
			if (pred.test(item)) {
				iter.remove();
				ret.add(item);
			}
		}

		if (ret.isEmpty()) {
			BuildingBigger.LOGGER.warn("takeAll predicate yielded nothing", new Throwable());
		}
		return ret;
	}
}
