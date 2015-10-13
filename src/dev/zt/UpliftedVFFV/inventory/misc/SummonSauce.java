package dev.zt.UpliftedVFFV.inventory.misc;

import dev.zt.UpliftedVFFV.inventory.Item;

public class SummonSauce extends Item{

	static int id = 2;
	static String name = "Summoning Sauce";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = true;
	static boolean target = false;
	static int value = 75;
	static int slot = 3;
	static int lvlReq = 1;
	static String descr="A sauce-packet containing some sort of spectral condiment.";
	static String descrShort = "Tribute for summoning spirit allies.";
	public SummonSauce() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

	}
}
