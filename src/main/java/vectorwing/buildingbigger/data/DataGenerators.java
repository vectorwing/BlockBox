package vectorwing.buildingbigger.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import vectorwing.buildingbigger.BuildingBigger;
import vectorwing.buildingbigger.data.provider.BlockLootTables;
import vectorwing.buildingbigger.data.provider.BlockStates;
import vectorwing.buildingbigger.data.provider.ItemModels;
import vectorwing.buildingbigger.data.provider.Recipes;
import vectorwing.buildingbigger.data.tag.BlockTags;
import vectorwing.buildingbigger.data.tag.DamageTypeTags;
import vectorwing.buildingbigger.data.tag.ItemTags;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@SuppressWarnings("unused")
@EventBusSubscriber(modid = BuildingBigger.MODID, bus = EventBusSubscriber.Bus.MOD)
public class DataGenerators
{
	@SubscribeEvent
	public static void gatherData(GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		PackOutput output = generator.getPackOutput();
		CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
		ExistingFileHelper helper = event.getExistingFileHelper();
//		RegistrySetBuilder registrySetBuilder = new RegistrySetBuilder()
//				.add(Registries.ENCHANTMENT, ModEnchantments::bootstrap);

		BlockTags blockTags = new BlockTags(output, lookupProvider, helper);
		generator.addProvider(event.includeServer(), blockTags);
		generator.addProvider(event.includeServer(), new ItemTags(output, lookupProvider, blockTags.contentsGetter(), helper));
//		generator.addProvider(event.includeServer(), new EntityTags(output, lookupProvider, helper));
		generator.addProvider(event.includeServer(), new DamageTypeTags(output, lookupProvider, helper));

//		DatapackBuiltinEntriesProvider datapackProvider = new DatapackBuiltinEntriesProvider(output, lookupProvider, registrySetBuilder, Set.of(FarmersDelight.MODID));
//		CompletableFuture<HolderLookup.Provider> builtinLookupProvider = datapackProvider.getRegistryProvider();
//		generator.addProvider(event.includeServer(), datapackProvider);
//		generator.addProvider(event.includeServer(), new EnchantmentTags(output, builtinLookupProvider, helper));

		generator.addProvider(event.includeServer(), new Recipes(output, lookupProvider));
//		generator.addProvider(event.includeServer(), new DataMaps(output, lookupProvider));
//		generator.addProvider(event.includeServer(), new Advancements(output, lookupProvider, helper));
		generator.addProvider(event.includeServer(), new LootTableProvider(output, Collections.emptySet(), List.of(
				new LootTableProvider.SubProviderEntry(BlockLootTables::new, LootContextParamSets.BLOCK)
		), lookupProvider));
//		generator.addProvider(event.includeServer(), new StructureUpdater("structures/village/houses", FarmersDelight.MODID, helper, output));
//
		BlockStates blockStates = new BlockStates(output, helper);
		generator.addProvider(event.includeClient(), blockStates);
		generator.addProvider(event.includeClient(), new ItemModels(output, blockStates.models().existingFileHelper));
	}
}
