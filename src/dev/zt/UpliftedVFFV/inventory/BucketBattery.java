package dev.zt.UpliftedVFFV.inventory;

import dev.zt.UpliftedVFFV.party.Schmuck;

public class BucketBattery extends Item{

	static String descr="A bucket filled with old, bulging batteries floating in some sort of\nacidic solution.";
	public BucketBattery() {
		super(2, "Bucket-o-Batteries", true, true,descr);

	}
	
	public void use(Schmuck perp, Schmuck vic){
		vic.CurrentHp-=50;
	}

}
