package implementations;
import interfaces.HairType;
import interfaces.HairyAnimal;

public class Sheep implements HairyAnimal {
	
	@Override
	public HairType<?> getHairType() {
		//simplified
		return new HairTypeWool();
	}
	
}
