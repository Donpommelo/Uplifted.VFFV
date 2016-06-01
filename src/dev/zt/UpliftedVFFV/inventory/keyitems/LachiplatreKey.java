package dev.zt.UpliftedVFFV.inventory.keyitems;

import dev.zt.UpliftedVFFV.inventory.Item;

public class LachiplatreKey extends Item{

	static int id = 74;
	static String name = "Lachiplatre Key";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 999;
	static int slot = 3;
	static int lvlReq = 1;
	static String descr="";
	static String descrShort = "A lachiplatre-shaped key that opens a door in Lachiplatre Land.";
	public LachiplatreKey() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

	}
}
