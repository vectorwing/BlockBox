package vectorwing.blockbox.fabric;

//? fabric {
import fuzs.forgeconfigapiport.fabric.api.v5.ConfigRegistry;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.fabricmc.fabric.api.event.player.ItemEvents;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.fml.config.ModConfig;
import vectorwing.blockbox.BlockBox;
import vectorwing.blockbox.Config;
import vectorwing.blockbox.fabric.event.BuildCreativeModeTabContentsEvent;
import vectorwing.blockbox.common.event.CommonEvents;
import vectorwing.blockbox.common.registry.*;

import static vectorwing.blockbox.BlockBox.MODID;

public class FabricEntrypoint implements ModInitializer {

    @Override
    public void onInitialize() {
        ConfigRegistry.INSTANCE.register(MODID, ModConfig.Type.COMMON, Config.SPEC);

        ModBlocks.register();
        ModItems.register();
        ModEntityTypes.register();
        ModSounds.register();
        ModParticleTypes.register();
        ModCreativeTabs.register();

        RegistryAliases.addRegistryAliases();
        CreativeModeTabEvents.MODIFY_OUTPUT_ALL.register((tab, output)-> CommonEvents.addItemsToVanillaCreativeTabs(new BuildCreativeModeTabContentsEvent(tab, output)));

        ItemEvents.USE_ON.register(useOnContext -> {
            BlockPos pos = useOnContext.getClickedPos();
            Level level = useOnContext.getLevel();
            BlockState state = level.getBlockState(pos);
            Block block = state.getBlock();
            if (block instanceof BlockWithItemAbility blockWithItemAbility) {
                ItemAbility itemAbility = ItemAbilities.get(useOnContext.getItemInHand());
                if (itemAbility != null) {
                    BlockState toolModifiedState = blockWithItemAbility.getToolModifiedState(state, useOnContext, itemAbility, false);
                    if (toolModifiedState != null) {
                        level.setBlockAndUpdate(pos, toolModifiedState);
                        return InteractionResult.SUCCESS;
                    }
                }
            }
            return null;
        });
        DataMaps.register();
    }

}
//?}
