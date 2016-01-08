package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class Impatient extends status{
	
	public double percent;
	public static String name = "Impatient";
	public static Boolean perm = false;
	public static Boolean visible = true;
	public static Boolean removedEnd = false;
	public static Boolean decay = true;
	public Impatient(int i, double percent, Schmuck perp, int pr){
		super(i, name, perm, visible, removedEnd, decay, perp, pr);
		this.percent = percent;
	}
	
	public Impatient(double percent, int pr){
		super(name, pr);
		this.percent = percent;
	}
	
	public void onDillyDally(Schmuck s, BattleState bs){
		bs.bp.bt.addScene(s.getName()+" is filled with burning impatience from waiting!");
		bs.bp.em.hpChange((int)(-s.getMaxHp()*percent), s, s, 0);
	}
	
	public String inflictText(Schmuck s){
		return s.getName()+" became Impatient!";
	}

	public String cureText(Schmuck s){
		return s.getName()+" is not longer Impatient.";
	}
	
	public Boolean isBad(){
		return true;
	}
}
