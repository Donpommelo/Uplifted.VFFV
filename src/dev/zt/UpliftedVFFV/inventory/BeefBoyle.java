package dev.zt.UpliftedVFFV.inventory;

import dev.zt.UpliftedVFFV.party.Schmuck;

public class BeefBoyle extends Item{
	
	static String descr="A thick, stew filled with beef as well as several ingredients that are \nless likely to be beef. ";
	public BeefBoyle() {
		super(2, "Beef Boyleston", true, true,descr);

	}
	
	public void use(Schmuck perp, Schmuck vic){

	}
	
	public String useText(Schmuck perp, Schmuck vic){
		return vic.getName()+" chokes down the Beef Boyleston.";
	}
	
	public String resultText(Schmuck perp, Schmuck vic){
		return vic.getName()+"'s throat is clogged with beefy sludge.";
	}

}
