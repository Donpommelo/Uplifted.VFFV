package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class Cannabalism extends status{
	
	public int duration;
	public Boolean perm = false;
	public Boolean visible = true;
	public double lifesteal;
	public Cannabalism(int i, double amount, Schmuck perp){
		super(i, "Cannabalism", false, true, true, perp);
		this.lifesteal = amount;
	}
	
	public Cannabalism(double amount, Schmuck perp){
		super("Cannabalism", true, false, perp);
		this.lifesteal = amount;
	}
	
	public void onKill(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.bt.textList.add(perp.getName()+" regained health from incapacitating "+vic.getName()+"!");
		bs.bp.em.hpChange((int)(vic.getMaxHp()*lifesteal*(1+perp.getHealPower())), perp.itemDummy, perp,6);
	}
	
	public String inflictText(Schmuck s){
		return s.getName()+" became Cannabalistic.";
	}

	public String cureText(Schmuck s){
		return s.getName()+" is no longer Cannabalistic.";
	}
}
