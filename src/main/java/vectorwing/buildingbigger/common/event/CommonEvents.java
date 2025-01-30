package vectorwing.buildingbigger.common.event;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import vectorwing.buildingbigger.BuildingBigger;
import vectorwing.buildingbigger.common.network.ClientPayloadHandler;
import vectorwing.buildingbigger.common.network.payload.MalletPushPayload;

@EventBusSubscriber(modid = BuildingBigger.MODID, bus = EventBusSubscriber.Bus.MOD)
public class CommonEvents
{
	@SubscribeEvent
	public static void register(final RegisterPayloadHandlersEvent event) {
		final PayloadRegistrar registrar = event.registrar("1");
		registrar.playToClient(
				MalletPushPayload.TYPE,
				MalletPushPayload.STREAM_CODEC,
				ClientPayloadHandler::handleMalletPush
		);
	}
}
