package vectorwing.buildingbigger;

import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import org.slf4j.Logger;
import vectorwing.buildingbigger.common.registry.*;

@Mod(BuildingBigger.MODID)
public class BuildingBigger
{
	public static final String MODID = "buildingbigger";
	public static final Logger LOGGER = LogUtils.getLogger();

	public BuildingBigger(IEventBus modEventBus, ModContainer modContainer) {
		modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);

		ModBlocks.BLOCKS.register(modEventBus);
		ModItems.ITEMS.register(modEventBus);
		ModEntityTypes.ENTITY_TYPES.register(modEventBus);
		ModParticleTypes.PARTICLE_TYPES.register(modEventBus);
		ModCreativeTabs.CREATIVE_MODE_TABS.register(modEventBus);
	}
}
