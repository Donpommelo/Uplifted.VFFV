package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class DespawnonDeath extends status{
	
	public static String name = "Despawn";
	public static Boolean perm = false;
	public static Boolean visible = false;
	public static Boolean removedEnd = false;
	public static Boolean decay = false;
	public DespawnonDeath(int i, Schmuck perp, Schmuck vic, int pr){
		super(i, name, perm, visible, removedEnd, decay, perp, vic, pr);
	}
	
	public DespawnonDeath(Schmuck v,int pr){
		super(name, v,pr);
	}

	public void onDeath(Schmuck perp, Schmuck vic, BattleState bs){
		//Do nothing. Removal from enemy team is now handled after animation. This is to prevent animations
		//from clashing weirdly with preemptive enemy placement updating
		
	/*	if(bs.bp.allies.contains(vic)){
			bs.bp.allies.remove(vic);
		}
		if(bs.bp.enemy.contains(vic)){
			bs.bp.enemy.remove(vic);
		}
		bs.bs.locationUpdate();
		bs.bs.targetUpdate();*/
	}
	
}
