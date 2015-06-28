package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class Vampirism extends status{
	
	public int duration;
	public Boolean perm = false;
	public Boolean visible = true;
	public double lifesteal;
	public Vampirism(int i, double amount, Schmuck perp){
		super(i, "Lifesteal", false, true, true, perp);
		this.lifesteal = amount;
	}
	
	public Vampirism(double amount, Schmuck perp){
		super("Lifesteal", true, true, perp);
		this.lifesteal = amount;
	}
	
	public void attackModify(Schmuck perp,Schmuck vic, BattleState bs, int damage){
		bs.bp.bt.textList.add(perp.getName()+" drains "+vic.getName()+"'s life.");
		bs.bp.em.hpChange(-(int)(damage*lifesteal), perp, perp);
	}
	
	
	public String inflictText(Schmuck s){
		return s.getName()+" gained the ability lifesteal.";

	}

	public String cureText(Schmuck s){
		return s.getName()+" lost the ability to Lifesteal.";
	}
	
	public int getDuration(){
		return duration;
	}

}
