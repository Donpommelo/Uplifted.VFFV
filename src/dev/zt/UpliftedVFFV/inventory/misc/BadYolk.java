package dev.zt.UpliftedVFFV.inventory.misc;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Stats.BonusStatBuff;

public class BadYolk extends Item{
	
	static int id = 2;
	static String name = "Bad Yolk";
	static boolean menu = false;
	static boolean battle = true;
	static boolean consume = true;
	static boolean target = true;
	static int value = 4;
	static int slot = 2;
	static int lvlReq = 1;
	static String descr="The yolk of a bad egg. Useful in the preparation of all manner of baked bads.";
	static String descrShort="Increases target's Crit vulnerability.";
	public BadYolk() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

	}

	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.stm.addStatus(vic, new BonusStatBuff(2,28,-.3 *(1+perp.getItemPow()),perp,50));
		bs.bp.stm.addStatus(vic, new BonusStatBuff(2,32,-.3 *(1+perp.getItemPow()),perp,50));
	}
	
	public String useName(Schmuck perp, Schmuck vic, BattleState bs){
		if(perp.getName().equals(vic.getName())){
			return perp.getName()+" uses a Bad Yolk on "+perp.getPronoun(1)+"self";
		}
		else{
			return perp.getName()+" throws a Bad Yolk at "+vic.getName();
		}
	}
	
	public boolean startTeamTarget(){
		return false;
	}
}
