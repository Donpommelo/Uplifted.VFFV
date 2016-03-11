package dev.zt.UpliftedVFFV.inventory.misc;

import dev.zt.UpliftedVFFV.inventory.Item;

public class SleepingPills extends Item{

	static int id = 2;
	static String name = "Sleeping Pills";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = true;
	static boolean target = false;
	static int value = 100;
	static int slot = 2;
	static int lvlReq = 1;
	static String descr="You wonder if everyone in the building needs these to sleep, or if its just you.";
	static String descrShort = "Helps you sleep at night";
	public SleepingPills() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

	}
	
}
