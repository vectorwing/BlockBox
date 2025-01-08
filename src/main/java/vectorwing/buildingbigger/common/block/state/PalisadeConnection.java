package vectorwing.buildingbigger.common.block.state;

import net.minecraft.util.StringRepresentable;
import org.jetbrains.annotations.NotNull;

public enum PalisadeConnection implements StringRepresentable
{
	NONE("none"),
	FULL("full"),
	SPIKED("spiked");

	private final String connectionType;

	PalisadeConnection(String name) {
		this.connectionType = name;
	}

	@Override
	public String toString() {
		return this.getSerializedName();
	}

	@Override
	public @NotNull String getSerializedName() {
		return this.connectionType;
	}
}
