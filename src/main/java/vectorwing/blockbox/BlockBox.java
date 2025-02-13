package vectorwing.blockbox;

import com.mojang.logging.LogUtils;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import org.slf4j.Logger;
import vectorwing.blockbox.common.registry.*;

@Mod(BlockBox.MODID)
public class BlockBox
{
	public static final String MODID = "blockbox";
	public static final Logger LOGGER = LogUtils.getLogger();

	public BlockBox(IEventBus modEventBus, ModContainer modContainer) {
		modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);

		ModBlocks.BLOCKS.addAlias(ResourceLocation.fromNamespaceAndPath(BlockBox.MODID, "clay_tiles"), ResourceLocation.fromNamespaceAndPath(BlockBox.MODID, "tiles"));
		ModBlocks.BLOCKS.addAlias(ResourceLocation.fromNamespaceAndPath(BlockBox.MODID, "clay_tile_stairs"), ResourceLocation.fromNamespaceAndPath(BlockBox.MODID, "tile_stairs"));
		ModBlocks.BLOCKS.addAlias(ResourceLocation.fromNamespaceAndPath(BlockBox.MODID, "clay_tile_slab"), ResourceLocation.fromNamespaceAndPath(BlockBox.MODID, "tile_slab"));
		ModBlocks.BLOCKS.addAlias(ResourceLocation.fromNamespaceAndPath(BlockBox.MODID, "jagged_clay_tiles"), ResourceLocation.fromNamespaceAndPath(BlockBox.MODID, "broken_tile_mosaic"));
		ModBlocks.BLOCKS.addAlias(ResourceLocation.fromNamespaceAndPath(BlockBox.MODID, "chiseled_amethyst"), ResourceLocation.fromNamespaceAndPath(BlockBox.MODID, "amethyst_mosaic"));
		ModBlocks.BLOCKS.addAlias(ResourceLocation.fromNamespaceAndPath(BlockBox.MODID, "chiseled_amethyst_stairs"), ResourceLocation.fromNamespaceAndPath(BlockBox.MODID, "amethyst_mosaic_stairs"));
		ModBlocks.BLOCKS.addAlias(ResourceLocation.fromNamespaceAndPath(BlockBox.MODID, "chiseled_amethyst_slab"), ResourceLocation.fromNamespaceAndPath(BlockBox.MODID, "amethyst_mosaic_slab"));

		ModItems.ITEMS.addAlias(ResourceLocation.fromNamespaceAndPath(BlockBox.MODID, "clay_tiles"), ResourceLocation.fromNamespaceAndPath(BlockBox.MODID, "tiles"));
		ModItems.ITEMS.addAlias(ResourceLocation.fromNamespaceAndPath(BlockBox.MODID, "clay_tile_stairs"), ResourceLocation.fromNamespaceAndPath(BlockBox.MODID, "tile_stairs"));
		ModItems.ITEMS.addAlias(ResourceLocation.fromNamespaceAndPath(BlockBox.MODID, "clay_tile_slab"), ResourceLocation.fromNamespaceAndPath(BlockBox.MODID, "tile_slab"));
		ModItems.ITEMS.addAlias(ResourceLocation.fromNamespaceAndPath(BlockBox.MODID, "jagged_clay_tiles"), ResourceLocation.fromNamespaceAndPath(BlockBox.MODID, "broken_tile_mosaic"));
		ModItems.ITEMS.addAlias(ResourceLocation.fromNamespaceAndPath(BlockBox.MODID, "chiseled_amethyst"), ResourceLocation.fromNamespaceAndPath(BlockBox.MODID, "amethyst_mosaic"));
		ModItems.ITEMS.addAlias(ResourceLocation.fromNamespaceAndPath(BlockBox.MODID, "chiseled_amethyst_stairs"), ResourceLocation.fromNamespaceAndPath(BlockBox.MODID, "amethyst_mosaic_stairs"));
		ModItems.ITEMS.addAlias(ResourceLocation.fromNamespaceAndPath(BlockBox.MODID, "chiseled_amethyst_slab"), ResourceLocation.fromNamespaceAndPath(BlockBox.MODID, "amethyst_mosaic_slab"));

		ModBlocks.BLOCKS.register(modEventBus);
		ModItems.ITEMS.register(modEventBus);
		ModEntityTypes.ENTITY_TYPES.register(modEventBus);
		ModParticleTypes.PARTICLE_TYPES.register(modEventBus);
		ModCreativeTabs.CREATIVE_MODE_TABS.register(modEventBus);
	}
}
