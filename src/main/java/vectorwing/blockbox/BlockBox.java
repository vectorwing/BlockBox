package vectorwing.blockbox;

import com.mojang.logging.LogUtils;
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

		ModBlocks.BLOCKS.register(modEventBus);
		ModItems.ITEMS.register(modEventBus);
		ModEntityTypes.ENTITY_TYPES.register(modEventBus);
		ModParticleTypes.PARTICLE_TYPES.register(modEventBus);
		ModCreativeTabs.CREATIVE_MODE_TABS.register(modEventBus);
	}
}
