package dev.zt.UpliftedVFFV.inventory.consumables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.TrueSight;

public class SeeingEye extends Item{

	static int id = 24;
	static String name = "Seeing Eye";
	static boolean menu = false;
	static boolean battle = true;
	static boolean consume = true;
	static boolean target = true;
	static int value = 25;
	static int slot = 0;
	static int lvlReq = 4;
	static String descr="Disembodied eyes have a way of always seeming terrified.";
	static String descrShort="Buffs User's Acc.";
	public SeeingEye() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

	}
	
	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.stm.addStatus(perp, new TrueSight(3, perp, perp, 70));
	}
	
	public int getTargetType(){
		return 1;
	}

}
