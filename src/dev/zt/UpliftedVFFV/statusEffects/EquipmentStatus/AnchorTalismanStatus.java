package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class AnchorTalismanStatus extends status{
	
	public AnchorTalismanStatus(Schmuck v,int pr){
		super("Anchored", v,pr);
	}
	
	public int takedamageEffect(Schmuck perp,Schmuck vic, BattleState bs, int damage, int elem){
		if(vic.getCurrentHp() == vic.getMaxHp() && -damage > vic.getCurrentHp()){
			bs.bp.bt.addScene(vic.getName()+"'s Anchor Talisman keeps "+vic.getPronoun(3)+" Anchored to Life!");
			return 0;
		}
		else{
			return damage;
		}
	}
}
