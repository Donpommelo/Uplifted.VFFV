package dev.zt.UpliftedVFFV.statusEffects.skillSpecific;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class IntrusiveThoughtEffect extends status{
	
	public static String name = "Intrusive Thinking";
	public static Boolean perm = false;
	public static Boolean visible = false;
	public static Boolean removedEnd = true;
	public static Boolean decay = false;
	public int stack;
	public IntrusiveThoughtEffect(Schmuck perp, int pr){
		super(1, name, perm, visible, removedEnd, decay, perp, pr);
		stack = 0;
	}

	public String inflictText(Schmuck s){
		return s.getName()+" just had an unpleasant thought.";
	}

	public String cureText(Schmuck s){
		return s.getName()+"'s Intrusive Thoughts fade.";
	}
}
