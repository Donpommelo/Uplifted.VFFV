package dev.zt.UpliftedVFFV.inventory;

import dev.zt.UpliftedVFFV.party.Schmuck;

public class CaffeinePatch extends Item{

	static String descr="A small adhesive strip that administers your needed chemicals\ndirectly into the bloodstream.";
	public CaffeinePatch() {
		super(2, "Caffeine Patch", true, true,descr);

	}
	
	public void use(Schmuck perp, Schmuck vic){
		vic.bpChange(15);
	}
	
	public String useText(Schmuck perp, Schmuck vic){
		return vic.getName()+" uses the Caffeine Patch.";
	}
	
	public String resultText(Schmuck perp, Schmuck vic){
		return vic.getName()+" looks 15 Bp more motivated.";
	}

}
