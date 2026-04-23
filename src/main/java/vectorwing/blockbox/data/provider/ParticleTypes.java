//? neoforge {
package vectorwing.blockbox.data.provider;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.neoforged.neoforge.client.data.ParticleDescriptionProvider;
import vectorwing.blockbox.BlockBox;
import vectorwing.blockbox.common.registry.ModParticleTypes;

public class ParticleTypes extends ParticleDescriptionProvider
{
	public ParticleTypes(PackOutput output) {
		super(output);
	}

	@Override
	protected void addDescriptions() {
		spriteSet(ModParticleTypes.SPARKLE.get(),
				Identifier.fromNamespaceAndPath(BlockBox.MODID, "sparkle"),
				4,
				false
		);
	}
}
//?}