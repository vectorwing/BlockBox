package vectorwing.buildingbigger.data.tag;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import vectorwing.buildingbigger.common.registry.ModItems;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class ItemTags extends ItemTagsProvider
{
	public ItemTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
		super(output, lookupProvider, blockTags);
	}

	@Override
	protected void addTags(HolderLookup.Provider provider) {
		registerMinecraftTags();
	}

	private void registerMinecraftTags() {
		tag(net.minecraft.tags.ItemTags.DOORS)
				.add(ModItems.IRON_PLATE_DOOR.get())
				.add(ModItems.GOLDEN_DOOR.get());
		tag(net.minecraft.tags.ItemTags.TRAPDOORS)
				.add(ModItems.IRON_PLATE_TRAPDOOR.get())
				.add(ModItems.GOLDEN_TRAPDOOR.get());
	}
}
