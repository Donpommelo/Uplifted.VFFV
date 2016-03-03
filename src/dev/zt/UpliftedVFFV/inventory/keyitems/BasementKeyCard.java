package dev.zt.UpliftedVFFV.inventory.keyitems;

import dev.zt.UpliftedVFFV.inventory.Item;

public class BasementKeyCard extends Item{

	static int id = 2;
	static String name = "Basement Keycard";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 999;
	static int slot = 3;
	static int lvlReq = 1;
	static String descr="";
	static String descrShort = "Gives access to B1 and B2.";
	public BasementKeyCard() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

	}
}
