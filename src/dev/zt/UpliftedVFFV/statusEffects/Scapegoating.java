package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.ablities.FlavorNothing;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class Scapegoating extends status{
	
	public static String name = "Scapegoat";
	public static Boolean perm = false;
	public static Boolean visible = true;
	public static Boolean removedEnd = false;
	public static Boolean decay = true;
	public Schmuck Goat;
	public Scapegoating(int i, Schmuck perp, Schmuck vic, Schmuck goat, int pr){
		super(i, name, perm, visible, removedEnd, decay, perp, vic, pr);
		this.Goat = goat;
	}
	
	public Scapegoating(Schmuck v,int pr){
		super(name,v, pr);
	}
	
	public void preActionTarget(Schmuck s, Action a, BattleState bs){
		bs.bp.bt.addScene(s.getName()+" uses "+Goat.getName()+" as a Scapegoat!");
		a.setTarget(Goat);
	}

	public String inflictText(Schmuck s){
		return s.getName()+" is using "+ Goat.getName()+" as a Scapegoat!";
	}

	public String cureText(Schmuck s){
		return s.getName()+" is no longer using "+ Goat.getName()+" as a Scapegoat!";
	}

}
