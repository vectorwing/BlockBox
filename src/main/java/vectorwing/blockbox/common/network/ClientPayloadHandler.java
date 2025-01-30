package vectorwing.blockbox.common.network;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import vectorwing.blockbox.common.item.MalletItem;
import vectorwing.blockbox.common.network.payload.MalletPushPayload;

public class ClientPayloadHandler
{
	public static void handleMalletPush(final MalletPushPayload data, final IPayloadContext context) {
		Player player = context.player();
		Level level = player.level();

		MalletItem.moveBlocks(level, data.pos(), data.facing());
	}
}
