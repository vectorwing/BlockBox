//? neoforge {
package vectorwing.blockbox.data.provider;

import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.data.PackOutput;
import vectorwing.blockbox.BlockBox;
import vectorwing.blockbox.data.generator.ModBlockModelGenerators;

public class BlockItemModels extends ModelProvider
{
	public BlockItemModels(PackOutput output) {
		super(output, BlockBox.MODID);
	}

	@Override
	protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
		new ModBlockModelGenerators(blockModels).run();
	}
}
//?}