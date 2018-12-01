package main;

import implementations.Sheep;
import interfaces.HairType;
import interfaces.HairTypeRenderer;
import interfaces.HairyAnimal;

public class MainClass {
	
	private final HairyAnimal sheep = new Sheep();
	
	public void chokes() {
		sheep.getHairType().getRenderer().renderHair(sheep.getHairType(), sheep);
	}
	
	public void chokes2() {
		HairType<?> hairType = sheep.getHairType();
		hairType.getRenderer().renderHair(hairType, sheep);
	}
	
	public void chokes3() {
		HairType<?> hairType = sheep.getHairType();
		hairType.getRenderer().renderHair(sheep.getHairType(), sheep);
	}
	
	
	
	
	
	public void works() {
		HairType<?> hairType = sheep.getHairType();
		HairTypeRenderer<?> hairTypeRenderer = hairType.getRenderer();
		
		hairTypeRenderer.renderHair(hairType, sheep);
	}
	
	public void works2() {
		HairTypeRenderer<?> hairTypeRenderer = sheep.getHairType().getRenderer();
		hairTypeRenderer.renderHair(sheep.getHairType(), sheep);
	}
	
	public void works3() {
		HairType<?> hairType = sheep.getHairType();
		HairTypeRenderer<?> hairTypeRenderer = hairType.getRenderer();
		
		hairTypeRenderer.renderHair(sheep.getHairType(), sheep);
	}
}
