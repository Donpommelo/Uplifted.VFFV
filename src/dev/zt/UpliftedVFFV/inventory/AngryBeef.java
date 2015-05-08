package dev.zt.UpliftedVFFV.inventory;

import dev.zt.UpliftedVFFV.party.Schmuck;

public class AngryBeef extends Item{

	static String descr="A hunk of angry, angry beef.";
	public AngryBeef() {
		super(2, "Angry Beef", false, true, true,descr);

	}
	
	public void use(Schmuck perp, Schmuck vic){
		
	}
	
	public String useText(Schmuck perp, Schmuck vic){
		return vic.getName()+" angrily chews on the Angry Beef.";
	}
	
	public String resultText(Schmuck perp, Schmuck vic){
		return "The steak fills "+vic.getName()+" with a palpable rage!";
	}

}
