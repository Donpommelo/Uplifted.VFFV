package dev.zt.UpliftedVFFV.inventory;

import dev.zt.UpliftedVFFV.party.Schmuck;

public class Lachiplatre extends Item{

	static String descr="A stale, bun-like object stuffed with dry paste. You assume it is edible.";
	public Lachiplatre() {
		super(0, "Lachiplatre", true, true,descr);

	}
	
	public void use(Schmuck perp, Schmuck vic){
		vic.hpChange(5);
	}

}