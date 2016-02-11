package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class Invuln extends status{
	
	public static String name = "Invulnerability";
	public static Boolean perm = false;
	public static Boolean visible = true;
	public static Boolean removedEnd = true;
	public static Boolean decay = true;
	public Invuln(int i, Schmuck perp, int pr){
		super(i, name, perm, visible, removedEnd, decay, perp, pr);
	}
	
	public int takedamageEffect(Schmuck perp,Schmuck vic, BattleState bs, int damage, int elem){
		bs.bp.bt.addScene(vic.getName()+"'s Invulnerability prevented damage!");
		return 0;
	}	
	
	public String inflictText(Schmuck s){
		return s.getName()+" was made Invulnerable!";
	}

	public String cureText(Schmuck s){
		return s.getName()+"'s invulnerablility wore off!";
	}
}
