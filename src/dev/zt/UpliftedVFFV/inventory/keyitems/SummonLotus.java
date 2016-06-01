package dev.zt.UpliftedVFFV.inventory.keyitems;

import dev.zt.UpliftedVFFV.inventory.Item;

public class SummonLotus extends Item{

	static int id = 53;
	static String name = "Summoning Lotus";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 999;
	static int slot = 3;
	static int lvlReq = 1;
	static String descr="An artifact used in communicating with spirits. It seems to only bloom when particularly close to the sun.";
	static String descrShort = "Summon spirit allies.";
		
	public SummonLotus() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

	}

	public boolean isSummonObject(){
		return true;
	}
	
	public boolean isSellable(){
		return false;
	}
	
}
