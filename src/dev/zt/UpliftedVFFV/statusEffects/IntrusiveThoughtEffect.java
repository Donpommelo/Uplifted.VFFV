package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;

public class IntrusiveThoughtEffect extends status{
	
	public int duration;
	public Boolean perm = false;
	public Boolean visible = true;
	public int stack;
	public IntrusiveThoughtEffect(int i, Schmuck perp, int pr){
		super(i, "Intrusive Thoughts", false, false, true, perp, pr);
		stack = 0;
	}

	public String inflictText(Schmuck s){
		return s.getName()+" just had an unpleasant thought.";
	}

	public String cureText(Schmuck s){
		return s.getName()+"'s Intrusive Thoughts fade.";
	}
}
