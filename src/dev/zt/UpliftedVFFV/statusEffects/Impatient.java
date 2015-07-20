package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class Impatient extends status{
	
	public int duration;
	public Boolean perm = false;
	public Boolean visible = true;
	public double percent;
	public Impatient(int i, double percent, Schmuck perp){
		super(i, "Impatient", false, false, true, perp);
		this.percent = percent;
	}
	
	public Impatient(double percent, Schmuck perp){
		super("Impatient", false, false, perp);
		this.percent = percent;
	}
	
	public void onDillyDally(Schmuck s, BattleState bs){
		bs.bp.bt.textList.add(s.getName()+" is filled with burning impatience from waiting!");
		bs.bp.em.hpChange((int)(-s.getMaxHp()*percent), s, s, 0);
	}
	
	public String inflictText(Schmuck s){
		return s.getName()+" became Impatient!";

	}

	public String cureText(Schmuck s){
		return s.getName()+" is not longer Impatient.";
	}
}
