package vectorwing.blockbox.data.model;

import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.world.level.block.Block;

public class ModTextureMappings
{
	public static TextureMapping modBars(Block block) {
		return new TextureMapping()
				.put(TextureSlot.BARS, TextureMapping.getBlockTexture(block))
				.put(TextureSlot.EDGE, TextureMapping.getBlockTexture(block, "_single"));
	}

	public static TextureMapping modBarsAlt(Block block) {
		return new TextureMapping()
				.put(TextureSlot.BARS, TextureMapping.getBlockTexture(block, "_single"))
				.put(TextureSlot.EDGE, TextureMapping.getBlockTexture(block));
	}

	public static TextureMapping pillar(Block block) {
		return new TextureMapping()
				.put(TextureSlot.SIDE, TextureMapping.getBlockTexture(block, "_side"))
				.put(TextureSlot.END, TextureMapping.getBlockTexture(block, "_end"));
	}

	public static TextureMapping palisade(Block block) {
		return new TextureMapping()
				.put(ModTextureSlots.CORE, TextureMapping.getBlockTexture(block, "_core"))
				.put(TextureSlot.SIDE, TextureMapping.getBlockTexture(block, "_side"))
				.put(TextureSlot.TOP, TextureMapping.getBlockTexture(block, "_top"));
	}

	public static TextureMapping seat(Block block) {
		return new TextureMapping()
				.put(TextureSlot.TOP, TextureMapping.getBlockTexture(block, "_top"))
				.put(TextureSlot.SIDE, TextureMapping.getBlockTexture(block, "_side"));
	}

	public static TextureMapping brazier(Block block, Material side, Material bottom) {
		return new TextureMapping()
				.put(TextureSlot.TOP, TextureMapping.getBlockTexture(block, "_top"))
				.put(TextureSlot.SIDE, side)
				.put(TextureSlot.BOTTOM, bottom);
	}

	public static TextureMapping brazierLit(Block block, Material bottom, Block campfire) {
		return new TextureMapping()
				.put(TextureSlot.TOP, TextureMapping.getBlockTexture(block, "_top"))
				.put(TextureSlot.SIDE, TextureMapping.getBlockTexture(block, "_side_lit"))
				.put(TextureSlot.BOTTOM, bottom)
				.put(TextureSlot.FIRE, TextureMapping.getBlockTexture(campfire, "_fire"));
	}

	public static TextureMapping brazierHangingLit(Block block, Material bottom, Block campfire) {
		return new TextureMapping()
				.put(TextureSlot.TOP, TextureMapping.getBlockTexture(block, "_top"))
				.put(TextureSlot.SIDE, TextureMapping.getBlockTexture(block, "_side_hanging_lit"))
				.put(TextureSlot.BOTTOM, bottom)
				.put(TextureSlot.FIRE, TextureMapping.getBlockTexture(campfire, "_fire"));
	}

	public static TextureMapping skyLantern(Block block, Material bottom, Block candle) {
		return new TextureMapping()
				.put(TextureSlot.TOP, TextureMapping.getBlockTexture(block, "_top"))
				.put(TextureSlot.SIDE, TextureMapping.getBlockTexture(block, "_side"))
				.put(TextureSlot.INNER_TOP, TextureMapping.getBlockTexture(block, "_inner_top"))
				.put(ModTextureSlots.INNER_SIDE, TextureMapping.getBlockTexture(block, "_inner_side"))
				.put(TextureSlot.BOTTOM, bottom)
				.put(TextureSlot.CANDLE, TextureMapping.getBlockTexture(candle, "_lit"));
	}
}
