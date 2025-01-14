package vectorwing.buildingbigger.common.network.payload;

import io.netty.buffer.ByteBuf;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import vectorwing.buildingbigger.BuildingBigger;

public record MalletPushPayload(BlockPos pos, Direction facing) implements CustomPacketPayload
{
	public static final CustomPacketPayload.Type<MalletPushPayload> TYPE = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath(BuildingBigger.MODID, "mallet_push"));

	public static final StreamCodec<ByteBuf, MalletPushPayload> STREAM_CODEC = StreamCodec.composite(
			BlockPos.STREAM_CODEC,
			MalletPushPayload::pos,
			Direction.STREAM_CODEC,
			MalletPushPayload::facing,
			MalletPushPayload::new
	);

	@Override
	public Type<? extends CustomPacketPayload> type() {
		return TYPE;
	}
}
