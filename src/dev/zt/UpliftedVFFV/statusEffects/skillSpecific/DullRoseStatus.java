package dev.zt.UpliftedVFFV.statusEffects.skillSpecific;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.DamageReflect;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class DullRoseStatus extends status{
	
	public static String name = "Rosy";
	public static Boolean perm = false;
	public static Boolean visible = false;
	public static Boolean removedEnd = true;
	public static Boolean decay = true;
	public DullRoseStatus(int i, Schmuck perp, int pr){
		super(i, name, perm, visible, removedEnd, decay, perp, pr);
	}
	
	public DullRoseStatus(int pr){
		super(name, pr);
	}
	
	public int takedamageEffect(Schmuck perp,Schmuck vic, BattleState bs, int damage, int elem){
		if(!perp.equals(vic) && !perp.getName().equals("Item Dummy") && !bs.bp.stm.checkStatus(perp, this)){
			bs.bp.bt.addScene(vic.getName()+"'s Dull Rose scratches up "+perp.getName()+"!");
			bs.bp.em.hpChange((int)(damage * .15), vic, perp, 2);
			damage *= 0.85;
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
