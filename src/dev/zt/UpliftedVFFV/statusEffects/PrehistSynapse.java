package dev.zt.UpliftedVFFV.statusEffects;



import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class PrehistSynapse extends status{
	
	public int duration;
	public Boolean perm = false;
	public Boolean visible = true;
	public int damage = 0;
	public PrehistSynapse(Schmuck perp, int pr){
		super("Delayed Response", false, false, perp,pr);
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
