package dev.zt.UpliftedVFFV.inventory;

public class BucketBattery extends Item{

	static String descr="A bucket filled with old, bulging batteries floating in some sort of\nacidic solution.";
	public BucketBattery() {
		super(2, "Bucket-o-Batteries", true, true,descr);

	}
	
	public void use(Character c){
		
	}

}
