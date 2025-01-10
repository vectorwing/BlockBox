package vectorwing.buildingbigger.common.registry;

import com.google.common.base.Suppliers;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.BlockSetType;

import java.util.function.Supplier;

public class ModBlockSets
{
	public static final Supplier<BlockSetType> IRON_PLATE = Suppliers.memoize(() -> BlockSetType.register(
			new BlockSetType(
					"iron_plate",
					true,
					false,
					false,
					BlockSetType.PressurePlateSensitivity.MOBS,
					SoundType.METAL,
					SoundEvents.IRON_DOOR_CLOSE,
					SoundEvents.IRON_DOOR_OPEN,
					SoundEvents.IRON_TRAPDOOR_CLOSE,
					SoundEvents.IRON_TRAPDOOR_OPEN,
					SoundEvents.METAL_PRESSURE_PLATE_CLICK_OFF,
					SoundEvents.METAL_PRESSURE_PLATE_CLICK_ON,
					SoundEvents.STONE_BUTTON_CLICK_OFF,
					SoundEvents.STONE_BUTTON_CLICK_ON
			)
	));

	public static final Supplier<BlockSetType> GOLD = Suppliers.memoize(() -> BlockSetType.register(
			new BlockSetType(
					"iron_plate",
					true,
					true,
					false,
					BlockSetType.PressurePlateSensitivity.MOBS,
					SoundType.METAL,
					SoundEvents.IRON_DOOR_CLOSE,
					SoundEvents.IRON_DOOR_OPEN,
					SoundEvents.IRON_TRAPDOOR_CLOSE,
					SoundEvents.IRON_TRAPDOOR_OPEN,
					SoundEvents.METAL_PRESSURE_PLATE_CLICK_OFF,
					SoundEvents.METAL_PRESSURE_PLATE_CLICK_ON,
					SoundEvents.STONE_BUTTON_CLICK_OFF,
					SoundEvents.STONE_BUTTON_CLICK_ON
			)
	));
}
