package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;

public class MeterBlock extends status{
	
	public int duration;
	public Boolean perm = false;
	public Boolean visible = false;
	public MeterBlock(int i, Schmuck perp){
		super(i, "Meter Block", false, true, true, perp);
	}
	
	public String inflictText(Schmuck s){
		return s.getName()+" can no longer regain Mp!";
	}

	public String cureText(Schmuck s){
		return s.getName()+" can regain Mp again!";
	}
}
