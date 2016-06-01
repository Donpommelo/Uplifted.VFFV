package dev.zt.UpliftedVFFV.inventory.misc;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.BaselineStats;

public class MediOkra extends Item{
	
	static int id = 95;
	static String name = "Medi-Okra";
	static boolean menu = false;
	static boolean battle = true;
	static boolean consume = true;
	static boolean target = true;
	static int value = 66;
	static int slot = 2;
	static int lvlReq = 1;
	static String descr="A piece of mediocre okra. Probably the tastiest item sold at Phlegming's.";
	static String descrShort="Sets targets stats to base values.";
	public MediOkra() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

	}

	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.stm.addStatus(vic, new BaselineStats(3, perp, vic, 50));
	}
	
	public String useName(Schmuck perp, Schmuck vic, BattleState bs){
		if(perp.getName().equals(vic.getName())){
			return perp.getName()+" uses a Medi-Okra on "+perp.getPronoun(1)+"self";
		}
		else{
			return perp.getName()+" throws a Medi-Okra at "+vic.getName();
		}
	}
	
	public boolean startTeamTarget(){
		return false;
	}
}
