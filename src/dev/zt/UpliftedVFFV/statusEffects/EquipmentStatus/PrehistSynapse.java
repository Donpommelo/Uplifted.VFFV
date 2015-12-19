package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;



import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class PrehistSynapse extends status{
	
	public int damage = 0;
	public PrehistSynapse(int pr){
		super("Delayed Response", pr);
	}
			
	public int takedamageEffect(Schmuck perp,Schmuck vic, BattleState bs, int damage, int elem){
		bs.bp.bt.textList.add(vic.getName()+"'s Prehistoric Synapse delays damage!");
		this.damage+=damage;
		return 0;
	}
	
	public void endofturnEffect(Schmuck s, BattleState bs){
		bs.bp.bt.textList.add(s.getName()+"'s Prehistoric Synapse inflicted delayed damage!");
		s.hpChange(damage);
		damage = 0;
	}
}
