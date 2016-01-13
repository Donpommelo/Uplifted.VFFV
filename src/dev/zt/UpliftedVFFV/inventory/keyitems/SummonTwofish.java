package dev.zt.UpliftedVFFV.inventory.keyitems;

import dev.zt.UpliftedVFFV.ablities.Skills;
import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;

public class SummonTwofish extends Item{

	static int id = 2;
	static String name = "Summoning Twofish";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 999;
	static int slot = 3;
	static int lvlReq = 1;
	static String descr="An artifact used in communicating with spirits. Hopefully the two fish\nare friends, because they're going to be enjoying each other's company\nfor a very long time.";
	static String descrShort = "Summon spirit allies.";
	
	public int xp;
	public Skills[] permedSkills;
	public Schmuck currentSummon;

	public SummonTwofish() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

	}
	
	

}
