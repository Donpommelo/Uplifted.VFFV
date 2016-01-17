package dev.zt.UpliftedVFFV.inventory.keyitems;

import dev.zt.UpliftedVFFV.inventory.Item;

public class SummonConch extends Item{

	static int id = 2;
	static String name = "Summoning Conch";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 999;
	static int slot = 3;
	static int lvlReq = 1;
	static String descr="An artifact used in communicating with spirits. If you hold it to your\near, you can hear the ocean. Or at least that's what the Informant\nsays, and he's the only person you know who has ever been there, so\nyou take his word for it.";
	static String descrShort = "Summon spirit allies.";

	public SummonConch() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

	}
	
	public boolean isSummonObject(){
		return true;
	}
	
	public boolean isSellable(){
		return false;
	}
}
