package dev.zt.UpliftedVFFV.inventory.misc;

import dev.zt.UpliftedVFFV.inventory.Item;

public class PostageStamp extends Item{

	static int id = 14;
	static String name = "Postage Stamp";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = true;
	static boolean target = false;
	static int value = 100;
	static int slot = 2;
	static int lvlReq = 1;
	static String descr="A stamp. Use these to send messages to your Pen Pal.";
	static String descrShort = "Used to send letters to your pen pal.";
	public PostageStamp() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

	}
	
}
