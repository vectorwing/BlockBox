package vectorwing.buildingbigger.data.provider;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.common.data.ParticleDescriptionProvider;
import vectorwing.buildingbigger.BuildingBigger;
import vectorwing.buildingbigger.common.registry.ModParticleTypes;

public class ParticleTypes extends ParticleDescriptionProvider
{
	public ParticleTypes(PackOutput output, ExistingFileHelper fileHelper) {
		super(output, fileHelper);
	}

	@Override
	protected void addDescriptions() {
		spriteSet(ModParticleTypes.SPARKLE.get(),
				// The base name.
				ResourceLocation.fromNamespaceAndPath(BuildingBigger.MODID, "sparkle"),
				// The amount of textures.
				4,
				// Whether to reverse the list, i.e. start at the last element instead of the first.
				false
		);
	}
}
