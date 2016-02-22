package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;


import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class NineLivesStatus extends status{
	
	public int duration;
	public Boolean perm = false;
	public Boolean visible = true;
	public NineLivesStatus(int pr){
		super("Nine Lives",pr);
	}
	
	public void statchanges(Schmuck s){
		s.setMaxHp(9);
	}
	
	public int takedamageEffect(Schmuck perp,Schmuck vic, BattleState bs, int damage, int elem){
		return -1;
	}
	
	public int onHealTargetEffect(Schmuck perp,Schmuck vic, BattleState bs, int damage, int elem){
		return 0;
	}
}
