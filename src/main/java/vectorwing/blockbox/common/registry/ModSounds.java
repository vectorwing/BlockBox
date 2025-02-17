package vectorwing.blockbox.common.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredRegister;
import vectorwing.blockbox.BlockBox;

import java.util.function.Supplier;

public class ModSounds
{
	public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(Registries.SOUND_EVENT, BlockBox.MODID);

	// Stove
	public static final Supplier<SoundEvent> ITEM_SWORD_CARVE = SOUNDS.register("item.sword.carve",
			() -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(BlockBox.MODID, "item.sword.carve")));
}
