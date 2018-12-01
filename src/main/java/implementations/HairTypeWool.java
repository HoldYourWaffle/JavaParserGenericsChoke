package implementations;
import interfaces.HairType;

public class HairTypeWool implements HairType<WoolRenderer> {
	
	@Override
	public WoolRenderer getRenderer() {
		return WoolRenderer.INSTANCE;
	}
	
}
