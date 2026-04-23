//? neoforge {
package vectorwing.blockbox.data.model;

import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.resources.Identifier;
import vectorwing.blockbox.BlockBox;

public class ModModelTemplates
{
	public static final ModelTemplate BARS_POST = create("template_bars_post", "_post", TextureSlot.BARS);
	public static final ModelTemplate BARS_POST_ENDS = create("template_bars_post_ends", "_post_ends", TextureSlot.EDGE);
	public static final ModelTemplate BARS_CAP = create("template_bars_cap", "_cap", TextureSlot.BARS);
	public static final ModelTemplate BARS_CAP_ALT = create("template_bars_cap_alt", "_cap_alt", TextureSlot.BARS);
	public static final ModelTemplate BARS_SIDE = create("template_bars_side", "_side", TextureSlot.BARS, TextureSlot.EDGE);
	public static final ModelTemplate BARS_SIDE_ALT = create("template_bars_side_alt", "_side_alt", TextureSlot.BARS, TextureSlot.EDGE);
	public static final ModelTemplate BARS_SIDE_FLAT = create("template_bars_side_flat", "_side", TextureSlot.BARS);
	public static final ModelTemplate BARS_SIDE_FLAT_ALT = create("template_bars_side_flat_alt", "_side_alt", TextureSlot.BARS);
	public static final ModelTemplate PALISADE_POST = create("template_palisade_post", "_post", TextureSlot.SIDE, TextureSlot.TOP);
	public static final ModelTemplate SPIKED_PALISADE_POST = create("template_spiked_palisade_post", "_post", TextureSlot.SIDE, TextureSlot.TOP);
	public static final ModelTemplate PALISADE_FRONT = create("template_palisade_front", "_front", ModTextureSlots.CORE, TextureSlot.SIDE, TextureSlot.TOP);
	public static final ModelTemplate SPIKED_PALISADE_FRONT = create("template_spiked_palisade_front", "_front", ModTextureSlots.CORE, TextureSlot.SIDE, TextureSlot.TOP);
	public static final ModelTemplate PALISADE_BACK = create("template_palisade_back", "_back", ModTextureSlots.CORE, TextureSlot.SIDE, TextureSlot.TOP);
	public static final ModelTemplate SPIKED_PALISADE_BACK = create("template_spiked_palisade_back", "_back", ModTextureSlots.CORE, TextureSlot.SIDE, TextureSlot.TOP);
	public static final ModelTemplate SEAT = create("template_seat", TextureSlot.TOP, TextureSlot.SIDE);
	public static final ModelTemplate BRAZIER = create("template_brazier", TextureSlot.TOP, TextureSlot.SIDE, TextureSlot.BOTTOM);
	public static final ModelTemplate BRAZIER_HANGING = create("template_brazier_hanging", "_hanging", TextureSlot.TOP, TextureSlot.SIDE, TextureSlot.BOTTOM);
	public static final ModelTemplate BRAZIER_LIT = create("template_brazier_lit", "_lit", TextureSlot.TOP, TextureSlot.SIDE, TextureSlot.BOTTOM, TextureSlot.FIRE);
	public static final ModelTemplate BRAZIER_HANGING_LIT = create("template_brazier_hanging_lit", "_hanging_lit", TextureSlot.TOP, TextureSlot.SIDE, TextureSlot.BOTTOM, TextureSlot.FIRE);
	public static final ModelTemplate SKY_LANTERN = create("template_sky_lantern", TextureSlot.TOP, TextureSlot.SIDE, TextureSlot.INNER_TOP, ModTextureSlots.INNER_SIDE, TextureSlot.BOTTOM, TextureSlot.CANDLE);

	public static ModelTemplate create(String id, TextureSlot... slots) {
		return ModelTemplates.create(Identifier.fromNamespaceAndPath(BlockBox.MODID, id).toString(), slots);
	}

	public static ModelTemplate create(String id, String suffix, TextureSlot... slots) {
		return ModelTemplates.create(Identifier.fromNamespaceAndPath(BlockBox.MODID, id).toString(), suffix, slots);
	}
}
//?}