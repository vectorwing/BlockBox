package vectorwing.blockbox.common.registry;

import vectorwing.blockbox.common.helper.RecipeHelper;

public class RegistryAliases
{
	public static void addRegistryAliases() {
		addBlockAlias("copper_lattice", "copper_chain_links");
		addBlockAlias("exposed_copper_lattice", "exposed_copper_chain_links");
		addBlockAlias("weathered_copper_lattice", "weathered_copper_chain_links");
		addBlockAlias("oxidized_copper_lattice", "oxidized_copper_chain_links");
		addBlockAlias("waxed_copper_lattice", "waxed_copper_chain_links");
		addBlockAlias("waxed_exposed_copper_lattice", "waxed_exposed_copper_chain_links");
		addBlockAlias("waxed_weathered_copper_lattice", "waxed_weathered_copper_chain_links");
		addBlockAlias("waxed_oxidized_copper_lattice", "waxed_oxidized_copper_chain_links");

		addItemAlias("copper_lattice", "copper_chain_links");
		addItemAlias("exposed_copper_lattice", "exposed_copper_chain_links");
		addItemAlias("weathered_copper_lattice", "weathered_copper_chain_links");
		addItemAlias("oxidized_copper_lattice", "oxidized_copper_chain_links");
		addItemAlias("waxed_copper_lattice", "waxed_copper_chain_links");
		addItemAlias("waxed_exposed_copper_lattice", "waxed_exposed_copper_chain_links");
		addItemAlias("waxed_weathered_copper_lattice", "waxed_weathered_copper_chain_links");
		addItemAlias("waxed_oxidized_copper_lattice", "waxed_oxidized_copper_chain_links");
	}

	public static void addBlockAlias(String oldName, String newName) {
		ModBlocks.BLOCKS.addAlias(RecipeHelper.modIdentifier(oldName), RecipeHelper.modIdentifier(newName));
	}

	public static void addItemAlias(String oldName, String newName) {
		ModItems.ITEMS.addAlias(RecipeHelper.modIdentifier(oldName), RecipeHelper.modIdentifier(newName));
	}
}
