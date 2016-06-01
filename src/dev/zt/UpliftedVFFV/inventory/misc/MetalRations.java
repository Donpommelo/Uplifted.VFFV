package dev.zt.UpliftedVFFV.inventory.misc;

import dev.zt.UpliftedVFFV.inventory.Item;



public class MetalRations extends Item{

	static int id = 51;
	static String name = "Metal Rations";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = true;
	static boolean target = false;
	static int value = 80;
	static int slot = 2;
	static int lvlReq = 1;
	static String descr="Imposing looking bullets. You didn't know these were allowed here.";
	static String descrShort="Handy ammunition.";
	public MetalRations() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

	}
}
