package vectorwing.blockbox.data.provider;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.level.ItemLike;
import vectorwing.blockbox.data.recipe.CraftingRecipes;
import vectorwing.blockbox.data.recipe.SmeltingRecipes;
import vectorwing.blockbox.data.recipe.StonecuttingRecipes;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.concurrent.CompletableFuture;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class Recipes extends RecipeProvider
{
	public Recipes(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
		super(output, registries);
	}

	@Override
	protected void buildRecipes(RecipeOutput output) {
		CraftingRecipes.register(output);
		SmeltingRecipes.register(output);
		StonecuttingRecipes.register(output);
	}

	public static String itemName(ItemLike itemLike) {
		return BuiltInRegistries.ITEM.getKey(itemLike.asItem()).getPath();
	}
}
