package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.incapacitate;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class GeniusMalignusStatus extends status{
	
	int actualHp;
	public GeniusMalignusStatus(Schmuck v,int pr){
		super("Lied To", v,pr);
	}
	
	public void startoffightEffect(Schmuck s, BattleState bs){//
		actualHp = s.getCurrentHp();
	}
	
	public int takedamageEffect(Schmuck perp,Schmuck vic, BattleState bs, int damage, int elem){
		actualHp += damage;
		if(actualHp <= 0){
			actualHp = 0;
			bs.bp.bt.addScene(vic.getName()+" suddenly collapses!");
			vic.setCurrentHp(0);
			bs.bp.stm.addStatus(vic, new incapacitate(vic,perp));
		}
		else{
			bs.bp.bt.addScene(vic.getName()+"'s Genius Malignus convinces "+vic.getPronoun(3)+" it didn't hurt at all!");
		}
		return 0;
	}
}
