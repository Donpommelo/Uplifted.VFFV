package dev.zt.UpliftedVFFV.inventory.keyitems;

import dev.zt.UpliftedVFFV.inventory.Item;

public class WaiterTray extends Item{

	static int id = 95;
	static String name = "Waiter Tray";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 999;
	static int slot = 3;
	static int lvlReq = 1;
	static String descr="";
	static String descrShort = "Temp";
	public WaiterTray() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

	}
}
