//? neoforge {
package vectorwing.blockbox.data.provider;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import vectorwing.blockbox.data.recipe.CraftingRecipes;
import vectorwing.blockbox.data.recipe.SmeltingRecipes;
import vectorwing.blockbox.data.recipe.StonecuttingRecipes;

import java.util.concurrent.CompletableFuture;

public class Recipes extends RecipeProvider
{
	public Recipes(HolderLookup.Provider registries, RecipeOutput output) {
		super(registries, output);
	}

	@Override
	protected void buildRecipes() {
		CraftingRecipes.register(items, output);
		SmeltingRecipes.register(output);
		StonecuttingRecipes.register(output);
	}

	public static class Runner extends RecipeProvider.Runner {

		public Runner(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
			super(output, registries);
		}

		@Override
		protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
			return new Recipes(registries, output);
		}

		@Override
		public String getName() {
			return "The Block Box recipes";
		}
	}
}
//?}