package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class DamageReflect extends status{
	
	public static String name = "Reflect";
	public static Boolean perm = false;
	public static Boolean visible = false;
	public static Boolean removedEnd = true;
	public static Boolean decay = true;
	public double percent;
	public DamageReflect(int i, double percent, Schmuck perp, Schmuck vic, int pr){
		super(i, name, perm, visible, removedEnd, decay, perp, vic, pr);
		this.percent = percent;
	}
	
	public DamageReflect(double percent,Schmuck v, int pr){
		super(name, v,pr);
		this.percent = percent;
	}
	
	public int takedamageEffect(Schmuck perp,Schmuck vic, BattleState bs, int damage, int elem){
		double perc = percent;
		if(this.isEquipment()){
			perc = perc * (1 + perp.getEquipPow());
		}
		if(!perp.equals(vic) && !perp.getName().equals("Item Dummy")){
			bs.bp.bt.addScene(vic.getName()+" reflected some damage back at "+perp.getName());
			perp.hpChange((int)(damage*perc));
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
	
	public int stackingEffect(){
		return 3;
	}
}
