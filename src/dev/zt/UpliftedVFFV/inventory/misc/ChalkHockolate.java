package dev.zt.UpliftedVFFV.inventory.misc;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Blind;

public class ChalkHockolate extends Item{
	
	static int id = 95;
	static String name = "Chalk Hockolate";
	static boolean menu = false;
	static boolean battle = true;
	static boolean consume = true;
	static boolean target = true;
	static int value = 4;
	static int slot = 2;
	static int lvlReq = 1;
	static String descr="A frothy and repulsive drink made of chalk and stuff that some guy hocked up.";
	static String descrShort="Damages and blinds target.";
	public ChalkHockolate() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

	}

	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.em.hpChange(-40, perp, vic, 6);
		bs.bp.stm.addStatus(vic, new Blind(3, perp, vic, 50));
	}
	
	public String useName(Schmuck perp, Schmuck vic, BattleState bs){
		if(perp.getName().equals(vic.getName())){
			return perp.getName()+" uses a Chalk Hockalate on "+perp.getPronoun(1)+"self";
		}
		else{
			return perp.getName()+" throws a Chalk Hockalate at "+vic.getName();
		}
	}
	
	public boolean startTeamTarget(){
		return false;
	}
}
