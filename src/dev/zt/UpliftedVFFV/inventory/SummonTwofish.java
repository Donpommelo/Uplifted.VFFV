package dev.zt.UpliftedVFFV.inventory;

public class SummonTwofish extends Item{

	static String descr="An artifact used in communicating with spirits. Hopefully the two fish\nare friends, because they're going to be enjoying each other's company\nfor a very long time.";
	static String descrShort = "Summon spirit allies.";
	public SummonTwofish() {
		super(2, "Summoning Twofish",false,false,false, false, false, descr, descrShort);

	}
	
	public void use(Character c){
		
	}

}
