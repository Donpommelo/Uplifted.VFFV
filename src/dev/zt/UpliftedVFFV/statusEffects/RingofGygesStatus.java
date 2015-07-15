package dev.zt.UpliftedVFFV.statusEffects;



import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class RingofGygesStatus extends status{
	
	public int duration;
	public Boolean perm = false;
	public Boolean visible = true;
	public int damage = 0;
	public RingofGygesStatus(int i, Schmuck perp){
		super(i, "Delayed Response", false, false, true, perp);
	}
	
	public RingofGygesStatus(Schmuck perp, int pr){
		super("Delayed Response", false, false, perp,pr);
	}
			
	public int takedamageEffect(Schmuck perp,Schmuck vic, BattleState bs, int damage, int elem){
		if(vic.getCurrentHp()-damage <= .1*vic.getMaxHp()){
			bs.bp.bt.textList.add(vic.getName()+"'s Ring of Gyges grants Invisibility!");
			bs.bp.stm.addStatus(vic, new Untouchable(2, vic.getItemDummy()));
		}
		return damage;
	}
	
	
	
	public void endofturnEffect(Schmuck s, BattleState bs){
		bs.bp.bt.textList.add(s.getName()+"'s Prehistoric Synapse inflicted delayed damage!");
		s.hpChange(damage);
		damage = 0;
	}
	
	
	public String inflictText(Schmuck s){
		return s.getName()+" looks stoic!";

	}

	public String cureText(Schmuck s){
		return s.getName()+" looks normal again.";
	}
	
	public int getDuration(){
		return duration;
	}

}
