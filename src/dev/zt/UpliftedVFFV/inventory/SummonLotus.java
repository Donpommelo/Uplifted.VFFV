package dev.zt.UpliftedVFFV.inventory;

public class SummonLotus extends Item{

	static String descr="An artifact used in communicating with spirits. It seems to only bloom\nwhen particularly close to the sun.";
	static String descrShort = "Summon spirit allies.";
	public SummonLotus() {
		super(2, "Summoning Lotus",false,false,false, false, false, descr, descrShort);

	}
	
	public void use(Character c){
		
	}

}
