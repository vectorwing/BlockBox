package vectorwing.blockbox.common.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import vectorwing.blockbox.client.gui.PlaqueEditScreen;
import vectorwing.blockbox.common.block.state.PlaqueBlockEntity;

@Mixin(LocalPlayer.class)
public class PlaqueEditScreenMixin
{
	@Shadow
	@Final
	protected Minecraft minecraft;

	@Inject(at = @At(value = "HEAD"), method = "openTextEdit", cancellable = true)
	private void openPlaqueEditScreen(SignBlockEntity signBlockEntity, boolean isFront, CallbackInfo ci) {
		if (signBlockEntity instanceof PlaqueBlockEntity) {
			minecraft.setScreen(new PlaqueEditScreen(signBlockEntity, isFront, minecraft.isTextFilteringEnabled()));
			ci.cancel();
		}
	}
}
