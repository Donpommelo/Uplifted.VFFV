package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;



import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.incapacitate;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class PrehistSynapse extends status{
	
	public int damage = 0;
	public PrehistSynapse(Schmuck v,int pr){
		super("Delayed Response", v, pr);
	}
			
	public int takedamageEffect(Schmuck perp,Schmuck vic, BattleState bs, int damage, int elem){
		bs.bp.bt.addScene(vic.getName()+"'s Prehistoric Synapse delays damage!");
		this.damage+=damage;
		return 0;
	}
	
	public void endofturnEffect(Schmuck s, BattleState bs){
		bs.bp.bt.addScene(s.getName()+"'s Prehistoric Synapse inflicted delayed damage!");
		s.hpChange(damage);
		damage = 0;
		if(s.getCurrentHp() == 0){
			bs.bp.stm.addStatus(s, new incapacitate(s,s));
		}
	}
}
