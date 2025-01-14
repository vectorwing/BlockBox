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
				ResourceLocation.fromNamespaceAndPath(BuildingBigger.MODID, "sparkle"),
				4,
				false
		);
		spriteSet(ModParticleTypes.STRIKE.get(),
				ResourceLocation.fromNamespaceAndPath(BuildingBigger.MODID, "strike"),
				4,
				false
		);
	}
}
