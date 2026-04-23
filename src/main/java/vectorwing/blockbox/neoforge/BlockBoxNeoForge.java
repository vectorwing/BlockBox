package vectorwing.blockbox.neoforge;

//? neoforge {
/*import net.minecraft.core.registries.Registries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.registries.RegisterEvent;
import vectorwing.blockbox.BlockBox;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import vectorwing.blockbox.Config;
import vectorwing.blockbox.common.registry.*;

@Mod(BlockBox.MODID)
@EventBusSubscriber(modid = BlockBox.MODID)
public class BlockBoxNeoForge {

    public BlockBoxNeoForge(IEventBus eventBus, ModContainer container) {
        container.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
        RegistryAliases.addRegistryAliases();
    }

    @SubscribeEvent
    public static void register(RegisterEvent event) {
        if (event.getRegistryKey().equals(Registries.BLOCK)) {
            ModBlocks.register();
        } else if (event.getRegistryKey().equals(Registries.ITEM)) {
            ModItems.register();
        } else if (event.getRegistryKey().equals(Registries.ENTITY_TYPE)) {
            ModEntityTypes.register();
        }  else if (event.getRegistryKey().equals(Registries.SOUND_EVENT)) {
            ModSounds.register();
        } else if (event.getRegistryKey().equals(Registries.CREATIVE_MODE_TAB)) {
            ModCreativeTabs.register();
        } else if (event.getRegistryKey().equals(Registries.PARTICLE_TYPE)) {
            ModParticleTypes.register();
        }
    }

}
*///?}
