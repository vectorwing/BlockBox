package vectorwing.blockbox.common.registry;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;
import vectorwing.blockbox.BlockBox;

import java.util.function.Supplier;

public class ModSounds
{

	// Stove
	public static final Supplier<SoundEvent> ITEM_SWORD_CARVE = register("item.sword.carve",
			() -> SoundEvent.createVariableRangeEvent(Identifier.fromNamespaceAndPath(BlockBox.MODID, "item.sword.carve")));

	private static Supplier<SoundEvent> register(String name, Supplier<SoundEvent> supplier) {
		SoundEvent register = Registry.register(BuiltInRegistries.SOUND_EVENT, Identifier.fromNamespaceAndPath(BlockBox.MODID, name), supplier.get());
		return ()->register;
	}

	public static void register() {

	}
}
