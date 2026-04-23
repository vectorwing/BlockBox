//? neoforge {
/*package vectorwing.blockbox.data;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import vectorwing.blockbox.BlockBox;
import vectorwing.blockbox.data.provider.*;
import vectorwing.blockbox.data.tag.BlockTags;
import vectorwing.blockbox.data.tag.DamageTypeTags;
import vectorwing.blockbox.data.tag.ItemTags;

@SuppressWarnings("unused")
@EventBusSubscriber(modid = BlockBox.MODID)
public class DataGenerators
{
	@SubscribeEvent
	public static void gatherData(GatherDataEvent.Client event) {
		// Data packs
		event.createDatapackRegistryObjects(BuiltInEntries.BUILDER);

		event.createBlockAndItemTags(BlockTags::new, ItemTags::new);
		event.createProvider(DamageTypeTags::new);

		event.createProvider(Recipes.Runner::new);
		event.createProvider(DataMaps::new);
		event.createProvider(LootTables::new);

		// Resource packs
		event.createProvider(BlockItemModels::new);
		event.createProvider(ParticleTypes::new);
	}
}
*///?}