package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class DamageReflect extends status{
	
	public int duration;
	public double percent;
	public Boolean perm = false;
	public Boolean visible = true;
	public DamageReflect(int i, double percent, Schmuck perp){
		super(i, "Damage Reflect", false, false, true, perp);
		this.percent = percent;
	}
	
	public DamageReflect(double percent, Schmuck perp){
		super("Damage Reflect", false, false, perp);
		this.percent = percent;
	}
	
	
	public int takedamageEffect(Schmuck perp,Schmuck vic, BattleState bs, int damage, int elem){
		if(!perp.equals(vic) && !perp.getName().equals("Item Dummy")){
			bs.bp.bt.textList.add(vic.getName()+" reflected some damage back at "+perp.getName());
			perp.hpChange((int)(damage*percent));
		}
		bs.bs.targetUpdate();
		return damage;
	}	
	
	public String inflictText(Schmuck s){
		return s.getName()+" is reflecting damage!";

	}

	public String cureText(Schmuck s){
		return s.getName()+" is not longer reflecting damage.";
	}
	
	public int getDuration(){
		return duration;
	}

}
