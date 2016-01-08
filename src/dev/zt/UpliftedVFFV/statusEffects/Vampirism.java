package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class Vampirism extends status{
	
	public static String name = "Vampiric";
	public static Boolean perm = false;
	public static Boolean visible = false;
	public static Boolean removedEnd = true;
	public static Boolean decay = true;
	public double lifesteal;
	public Vampirism(int i, double amount, Schmuck perp, int pr){
		super(i, name, perm, visible, removedEnd, decay, perp, pr);
		this.lifesteal = amount;
	}
	
	public Vampirism(double amount, int pr){
		super("Vampiric", pr);
		this.lifesteal = amount;
	}
	
	public void attackModify(Schmuck perp,Schmuck vic, BattleState bs, int damage){
		bs.bp.bt.addScene(perp.getName()+" drains "+vic.getName()+"'s life.");
		bs.bp.em.hpChange(-(int)(damage*lifesteal*(1+perp.getHealPower())), perp, perp,6);
	}
	
	public String inflictText(Schmuck s){
		return s.getName()+" became Vampiric!";
	}

	public String cureText(Schmuck s){
		return s.getName()+" is no longer Vampiric!";
	}
	
	public int stackingEffect(){
		return 3;
	}
	
}
