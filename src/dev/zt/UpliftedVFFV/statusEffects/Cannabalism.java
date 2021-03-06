package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class Cannabalism extends status{
	
	public static String name = "Cannabalism";
	public static Boolean perm = false;
	public static Boolean visible = false;
	public static Boolean removedEnd = true;
	public static Boolean decay = true;
	public double lifesteal;
	public Cannabalism(int i, double amount, Schmuck perp, Schmuck vic, int pr){
		super(i, name, perm, visible, removedEnd, decay, perp, vic, pr);
		this.lifesteal = amount;
	}
	
	public Cannabalism(double amount, Schmuck v,int pr){
		super(name, v,pr);
		this.lifesteal = amount;
	}
	
	public void onKill(Schmuck perp, Schmuck vic, BattleState bs){
		double ls = lifesteal;
		if(this.isEquipment()){
			ls = ls * (1 + perp.getEquipPow());
		}
		bs.bp.bt.addScene(perp.getName()+" regained health from incapacitating "+vic.getName()+"!");
		bs.bp.em.hpChange((int)(vic.getMaxHp()*ls*(1+perp.getHealPower())), perp.itemDummy, perp,6);
	}
	
	public String inflictText(Schmuck s){
		return s.getName()+" became Cannabalistic.";
	}

	public String cureText(Schmuck s){
		return s.getName()+" is no longer Cannabalistic.";
	}
	
	public int stackingEffect(){
		return 3;
	}
}
