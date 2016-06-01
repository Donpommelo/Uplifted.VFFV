package dev.zt.UpliftedVFFV.inventory.keyitems;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Stats.StatBuffMult;

public class ShrinkingRay extends Item{

	static int id = 95;
	static String name = "Shrinking Ray";
	static boolean menu = false;
	static boolean battle = true;
	static boolean consume = false;
	static boolean target = false;
	static int value = 999;
	static int slot = 3;
	static int lvlReq = 1;
	static String descr="TEMP";
	static String descrShort = "Lowers target's Pow/Not consumed on use.";
	public ShrinkingRay() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

	}
	
	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.stm.addStatus(vic, new StatBuffMult(3,2,0.8, perp, vic, 50));
	}
	
	public String useName(Schmuck perp, Schmuck vic, BattleState bs){
		if(perp.getName().equals(vic.getName())){
			return perp.getName()+" uses a Shrinking Ray on "+perp.getPronoun(1)+"self";
		}
		else{
			return perp.getName()+" uses a Shrinking Ray at "+vic.getName();
		}
	}
	
	public boolean startTeamTarget(){
		return false;
	}
}
