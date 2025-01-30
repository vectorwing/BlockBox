package vectorwing.buildingbigger.common.network;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import vectorwing.buildingbigger.common.item.MalletItem;
import vectorwing.buildingbigger.common.network.payload.MalletPushPayload;

public class ClientPayloadHandler
{
	public static void handleMalletPush(final MalletPushPayload data, final IPayloadContext context) {
		Player player = context.player();
		Level level = player.level();

		MalletItem.moveBlocks(level, data.pos(), data.facing());
	}
}
