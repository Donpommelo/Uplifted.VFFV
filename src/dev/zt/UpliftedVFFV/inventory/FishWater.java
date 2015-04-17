package dev.zt.UpliftedVFFV.inventory;

import dev.zt.UpliftedVFFV.party.Schmuck;

public class FishWater extends Item{
	
	static String descr="Water from the Fourth Floor Aquarium. It smells fishy.";
	public FishWater() {
		super(2, "Fish Water", true, true,descr);

	}
	
	public void use(Schmuck perp, Schmuck vic){
		vic.setCurrentHp(vic.getCurrentHp()-12);
	}
}
