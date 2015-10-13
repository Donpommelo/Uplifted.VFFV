package dev.zt.UpliftedVFFV.inventory.misc;

import dev.zt.UpliftedVFFV.inventory.Item;

public class ZDrug extends Item{

	static int id = 2;
	static String name = "Z-Drug";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = true;
	static boolean target = false;
	static int value = 150;
	static int slot = 2;
	static int lvlReq = 15;
	static String descr="A potent sleeping aid for when the constant grinding noise of the\nelevators keeps you up at night.";
	static String descrShort = "Helps you sleep at night.";
	public ZDrug() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

	}
	
}
