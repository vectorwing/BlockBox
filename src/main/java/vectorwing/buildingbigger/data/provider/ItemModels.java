package vectorwing.buildingbigger.data.provider;

import com.google.common.collect.Sets;
import net.minecraft.client.renderer.block.model.BlockModel;
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

		palisadeModel(ModItems.OAK_PALISADE.get(), items);
		palisadeModel(ModItems.SPIKED_OAK_PALISADE.get(), items);
		palisadeModel(ModItems.SPRUCE_PALISADE.get(), items);
		palisadeModel(ModItems.SPIKED_SPRUCE_PALISADE.get(), items);
		palisadeModel(ModItems.BIRCH_PALISADE.get(), items);
		palisadeModel(ModItems.SPIKED_BIRCH_PALISADE.get(), items);
		palisadeModel(ModItems.JUNGLE_PALISADE.get(), items);
		palisadeModel(ModItems.SPIKED_JUNGLE_PALISADE.get(), items);
		palisadeModel(ModItems.ACACIA_PALISADE.get(), items);
		palisadeModel(ModItems.SPIKED_ACACIA_PALISADE.get(), items);
		palisadeModel(ModItems.DARK_OAK_PALISADE.get(), items);
		palisadeModel(ModItems.SPIKED_DARK_OAK_PALISADE.get(), items);
		palisadeModel(ModItems.MANGROVE_PALISADE.get(), items);
		palisadeModel(ModItems.SPIKED_MANGROVE_PALISADE.get(), items);
		palisadeModel(ModItems.CHERRY_PALISADE.get(), items);
		palisadeModel(ModItems.SPIKED_CHERRY_PALISADE.get(), items);
		palisadeModel(ModItems.CRIMSON_PALISADE.get(), items);
		palisadeModel(ModItems.SPIKED_CRIMSON_PALISADE.get(), items);
		palisadeModel(ModItems.WARPED_PALISADE.get(), items);
		palisadeModel(ModItems.SPIKED_WARPED_PALISADE.get(), items);

		trapdoorModel(ModItems.IRON_PLATE_TRAPDOOR.get(), items);
		trapdoorModel(ModItems.GOLDEN_TRAPDOOR.get(), items);

		wallInventory(itemName(ModItems.PACKED_SNOW_BRICK_WALL.get()), resourceBlock(itemName(ModItems.PACKED_SNOW_BRICKS.get())));
		items.remove(ModItems.PACKED_SNOW_BRICK_WALL.get());

		itemGeneratedModel(ModItems.WAXED_COPPER_BARS.get(), resourceBlock(itemName(ModItems.COPPER_BARS.get())));
		items.remove(ModItems.WAXED_COPPER_BARS.get());
		itemGeneratedModel(ModItems.WAXED_EXPOSED_COPPER_BARS.get(), resourceBlock(itemName(ModItems.EXPOSED_COPPER_BARS.get())));
		items.remove(ModItems.WAXED_EXPOSED_COPPER_BARS.get());
		itemGeneratedModel(ModItems.WAXED_WEATHERED_COPPER_BARS.get(), resourceBlock(itemName(ModItems.WEATHERED_COPPER_BARS.get())));
		items.remove(ModItems.WAXED_WEATHERED_COPPER_BARS.get());
		itemGeneratedModel(ModItems.WAXED_OXIDIZED_COPPER_BARS.get(), resourceBlock(itemName(ModItems.OXIDIZED_COPPER_BARS.get())));
		items.remove(ModItems.WAXED_OXIDIZED_COPPER_BARS.get());

		blockBasedOnOtherModel(ModItems.WAXED_COPPER_PILLAR.get(), ModItems.COPPER_PILLAR.get());
		items.remove(ModItems.WAXED_COPPER_PILLAR.get());
		blockBasedOnOtherModel(ModItems.WAXED_EXPOSED_COPPER_PILLAR.get(), ModItems.EXPOSED_COPPER_PILLAR.get());
		items.remove(ModItems.WAXED_EXPOSED_COPPER_PILLAR.get());
		blockBasedOnOtherModel(ModItems.WAXED_WEATHERED_COPPER_PILLAR.get(), ModItems.WEATHERED_COPPER_PILLAR.get());
		items.remove(ModItems.WAXED_WEATHERED_COPPER_PILLAR.get());
		blockBasedOnOtherModel(ModItems.WAXED_OXIDIZED_COPPER_PILLAR.get(), ModItems.OXIDIZED_COPPER_PILLAR.get());
		items.remove(ModItems.WAXED_OXIDIZED_COPPER_PILLAR.get());

		// Blocks with a flat block texture for an item
		Set<Item> flatBlockItems = Sets.newHashSet(
				ModItems.COPPER_BARS.get(),
				ModItems.EXPOSED_COPPER_BARS.get(),
				ModItems.WEATHERED_COPPER_BARS.get(),
				ModItems.OXIDIZED_COPPER_BARS.get(),
				ModItems.GOLDEN_BARS.get()
		);
		takeAll(items, flatBlockItems.toArray(new Item[0])).forEach(item -> itemGeneratedModel(item, resourceBlock(itemName(item))));

		// Blocks with an unique item sprite
		Set<Item> spritedBlockItems = Sets.newHashSet(
				ModItems.IRON_PLATE_DOOR.get(),
				ModItems.GOLDEN_DOOR.get(),
				ModItems.WHITE_SKY_LANTERN.get(),
				ModItems.LIGHT_GRAY_SKY_LANTERN.get(),
				ModItems.GRAY_SKY_LANTERN.get(),
				ModItems.BLACK_SKY_LANTERN.get(),
				ModItems.BROWN_SKY_LANTERN.get(),
				ModItems.RED_SKY_LANTERN.get(),
				ModItems.ORANGE_SKY_LANTERN.get(),
				ModItems.YELLOW_SKY_LANTERN.get(),
				ModItems.LIME_SKY_LANTERN.get(),
				ModItems.GREEN_SKY_LANTERN.get(),
				ModItems.CYAN_SKY_LANTERN.get(),
				ModItems.LIGHT_BLUE_SKY_LANTERN.get(),
				ModItems.BLUE_SKY_LANTERN.get(),
				ModItems.PURPLE_SKY_LANTERN.get(),
				ModItems.MAGENTA_SKY_LANTERN.get(),
				ModItems.PINK_SKY_LANTERN.get()
		);
		takeAll(items, spritedBlockItems.toArray(new Item[0])).forEach(item -> itemGeneratedModel(item, resourceItem(itemName(item))));

		// Blocks with 3D models
		takeAll(items, i -> i instanceof BlockItem).forEach(item -> blockBasedModel(item, ""));
	}

	public void palisadeModel(Item item, Set<Item> items) {
		blockBasedModelFrontLight(item, "_post");
		items.remove(item);
	}

	public void trapdoorModel(Item item, Set<Item> items) {
		blockBasedModel(item, "_bottom");
		items.remove(item);
	}

	public void blockBasedOnOtherModel(Item item, Item modelItem) {
		withExistingParent(itemName(item), resourceBlock(itemName(modelItem)));
	}

	public void blockBasedModel(Item item, String suffix) {
		withExistingParent(itemName(item), resourceBlock(itemName(item) + suffix));
	}

	public void blockBasedModelFrontLight(Item item, String suffix) {
		withExistingParent(itemName(item), resourceBlock(itemName(item) + suffix)).guiLight(BlockModel.GuiLight.FRONT);
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

	@SafeVarargs
	@SuppressWarnings("varargs")
	public static <T> Collection<T> takeAll(Set<? extends T> src, T... items) {
		List<T> ret = Arrays.asList(items);
		for (T item : items) {
			if (!src.contains(item)) {
				BuildingBigger.LOGGER.warn("Item {} not found in set", item);
			}
		}
		if (!src.removeAll(ret)) {
			BuildingBigger.LOGGER.warn("takeAll array didn't yield anything ({})", Arrays.toString(items));
		}
		return ret;
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
