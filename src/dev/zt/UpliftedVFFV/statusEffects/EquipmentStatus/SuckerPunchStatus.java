package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;


import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Suckered;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class SuckerPunchStatus extends status{
	
	public SuckerPunchStatus(int pr){
		super("Sucker Punching", pr);
	}
	
	public void startoffightEffect(Schmuck s, BattleState bs){
		bs.bp.bt.addScene(s.getName()+"'s Culling Grinder culls the weak!");
		for(Schmuck e : bs.bp.getSelectableEnemies(s)){
			bs.bp.stm.addStatus(e, new Suckered(100,s));
		}
	}
}
