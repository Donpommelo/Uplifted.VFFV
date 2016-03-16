package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class Impotent extends status{
	
	public static String name = "Impotence";
	public static Boolean perm = false;
	public static Boolean visible = true;
	public static Boolean removedEnd = true;
	public static Boolean decay = true;
	public Impotent(int i, Schmuck perp, Schmuck vic, int pr){
		super(i, name, perm, visible, removedEnd, decay, perp, vic, pr);
	}
	
	public int dealdamageEffect(Schmuck perp,Schmuck vic, BattleState bs, int damage, int elem){
		bs.bp.bt.addScene(perp.getName()+"'s Impotency prevents damage from being done!!");
		return 0;
	}	
	
	public String inflictText(Schmuck s){
		return s.getName()+" was made Impotent and cannot inflict damage!";
	}

	public String cureText(Schmuck s){
		return s.getName()+"'s Impotency wore off!";
	}
}
