package dev.zt.UpliftedVFFV.inventory;

public class SummonConch extends Item{

	static String descr="An artifact used in communicating with spirits. If you hold it to your\near, you can hear the ocean. Or at least that's what the Informant\nsays, and he's the only person you know who has ever been there, so\nyou take his word for it.";
	static String descrShort = "Summon spirit allies.";
	public SummonConch() {
		super(2, "Summoning Conch",false,false,false, false, descr, descrShort,999,3);

	}
	
	public void use(Character c){
		
	}

}
