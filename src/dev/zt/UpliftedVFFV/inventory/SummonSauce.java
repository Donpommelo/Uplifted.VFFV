package dev.zt.UpliftedVFFV.inventory;

public class SummonSauce extends Item{

	static String descr="A sauce-packet containing some sort of spectral condiment.";
	static String descrShort = "Tribute for summoning spirit allies.";
	public SummonSauce() {
		super(2, "Summoning Sauce",false, false, true, false, false, descr, descrShort);

	}
	
	public void use(Character c){
		
	}

}
