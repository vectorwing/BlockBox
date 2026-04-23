package vectorwing.blockbox.fabric;

//? fabric {
import net.fabricmc.api.ClientModInitializer;
import vectorwing.blockbox.BlockBox;
import vectorwing.blockbox.client.event.ClientSetupEvents;
import vectorwing.blockbox.fabric.event.client.EntityRenderersEvent;
import vectorwing.blockbox.fabric.event.client.RegisterParticleProvidersEvent;

public class FabricClientEntrypoint implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockBox.LOGGER.info("Initializing {} Client", BlockBox.MODID);
        ClientSetupEvents.onRegisterRenderers(new EntityRenderersEvent.RegisterRenderers());
        ClientSetupEvents.registerParticles(new RegisterParticleProvidersEvent());
    }

}
//?}