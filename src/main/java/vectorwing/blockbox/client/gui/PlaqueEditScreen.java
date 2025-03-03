package vectorwing.blockbox.client.gui;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractSignEditScreen;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;
import vectorwing.blockbox.BlockBox;
import vectorwing.blockbox.common.block.PlaqueBlock;
import vectorwing.blockbox.common.block.state.PlaqueBlockEntity;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class PlaqueEditScreen extends AbstractSignEditScreen
{
	protected final PlaqueBlockEntity plaque;

	public PlaqueEditScreen(SignBlockEntity blockEntity, boolean isFront, boolean isTextFilteringEnabled) {
		super(blockEntity, isFront, isTextFilteringEnabled, Component.translatable(BlockBox.MODID + ".plaque.edit"));
		this.plaque = (PlaqueBlockEntity) blockEntity;
	}

	@Override
	protected void offsetSign(GuiGraphics guiGraphics, BlockState state) {
		super.offsetSign(guiGraphics, state);
		guiGraphics.pose().translate(0.0F, 35.0F, 0.0F);
	}

	@Override
	protected void renderSignBackground(@NotNull GuiGraphics guiGraphics, BlockState state) {
		Block block = state.getBlock();
		String blockName = BuiltInRegistries.BLOCK.getKey(block).getPath();

		ResourceLocation texture = ResourceLocation.fromNamespaceAndPath(BlockBox.MODID, blockName + "_front.png").withPrefix("textures/block/");
		guiGraphics.pose().translate(0.0F, 0.0F, 0.0F);
		guiGraphics.pose().scale(6F, 6F, 6F);
		guiGraphics.blit(texture, -8, -8, 0.0F, 0.0F, 16, 16, 16, 16);
	}

	@Override
	protected void renderSignText(GuiGraphics guiGraphics) {
		Block block = this.plaque.getBlockState().getBlock();
		PlaqueBlock plaqueBlock = block instanceof PlaqueBlock plaqueBlock1 ? plaqueBlock1 : null;

		guiGraphics.pose().translate(0.0F, 0.0F, 4.0F);
		Vector3f vector3f = this.getSignTextScale();
		guiGraphics.pose().scale(vector3f.x(), vector3f.y(), vector3f.z());

		boolean isCursorBlinking = this.frame / 6 % 2 == 0;
		int cursorPos = this.signField.getCursorPos();
		int selectionPos = this.signField.getSelectionPos();
		int lineHeightOffset = 4 * this.plaque.getTextLineHeight() / 2;
		int finalHeight = this.line * this.plaque.getTextLineHeight() - lineHeightOffset;

		if (plaqueBlock != null) {
			guiGraphics.pose().translate(1, 1, 0);
			renderTextWithColor(guiGraphics, plaqueBlock.getHighlightColor(), isCursorBlinking, cursorPos, selectionPos, lineHeightOffset, finalHeight);
			guiGraphics.pose().translate(-1, -1, 0);
		}
		int textColor = plaqueBlock != null ? plaqueBlock.getTextColor() : DyeColor.BLACK.getTextColor();
		renderTextWithColor(guiGraphics, textColor, isCursorBlinking, cursorPos, selectionPos, lineHeightOffset, finalHeight);

		for (int k3 = 0; k3 < this.messages.length; k3++) {
			String s1 = this.messages[k3];
			if (s1 != null && k3 == this.line && cursorPos >= 0) {
				int l3 = this.font.width(s1.substring(0, Math.max(Math.min(cursorPos, s1.length()), 0)));
				int i4 = l3 - this.font.width(s1) / 2;
				if (isCursorBlinking && cursorPos < s1.length()) {
					guiGraphics.fill(i4, finalHeight - 1, i4 + 1, finalHeight + this.plaque.getTextLineHeight(), 0xFF000000 | textColor);
				}

				if (selectionPos != cursorPos) {
					int j4 = Math.min(cursorPos, selectionPos);
					int j2 = Math.max(cursorPos, selectionPos);
					int k2 = this.font.width(s1.substring(0, j4)) - this.font.width(s1) / 2;
					int l2 = this.font.width(s1.substring(0, j2)) - this.font.width(s1) / 2;
					int i3 = Math.min(k2, l2);
					int j3 = Math.max(k2, l2);
					guiGraphics.fill(RenderType.guiTextHighlight(), i3, finalHeight, j3, finalHeight + this.plaque.getTextLineHeight(), -16776961);
				}
			}
		}
	}

	protected void renderTextWithColor(GuiGraphics guiGraphics, int textColor, boolean isCursorBlinking, int cursorPos, int selectionPos, int lineHeightOffset, int finalHeight) {
		for (int j1 = 0; j1 < this.messages.length; j1++) {
			String s = this.messages[j1];
			if (s != null) {
				if (this.font.isBidirectional()) {
					s = this.font.bidirectionalShaping(s);
				}

				int k1 = -this.font.width(s) / 2;
				guiGraphics.drawString(this.font, s, k1, j1 * this.plaque.getTextLineHeight() - lineHeightOffset, textColor, false);
				if (j1 == this.line && cursorPos >= 0 && isCursorBlinking) {
					int l1 = this.font.width(s.substring(0, Math.max(Math.min(cursorPos, s.length()), 0)));
					int i2 = l1 - this.font.width(s) / 2;
					if (cursorPos >= s.length()) {
						guiGraphics.drawString(this.font, "_", i2, finalHeight, textColor, false);
					}
				}
			}
		}
	}

	@Override
	protected Vector3f getSignTextScale() {
		return new Vector3f(1, 1, 1);
	}
}
