package dev.zt.UpliftedVFFV.inventory.keyitems;

import dev.zt.UpliftedVFFV.inventory.Item;

public class MonsterCoffee extends Item{

	static int id = 84;
	static String name = "'Coffee'";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 999;
	static int slot = 3;
	static int lvlReq = 1;
	static String descr="";
	static String descrShort = "A thermos half-filled with coffee and half-filled with evil-smelling, black sludge.";
	public MonsterCoffee() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
	}
}
