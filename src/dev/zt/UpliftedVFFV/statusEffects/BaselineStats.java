package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class BaselineStats extends status{
	
	public static String name = "Broken";
	public static Boolean perm = false;
	public static Boolean visible = false;
	public static Boolean removedEnd = true;
	public static Boolean decay = true;
	public BaselineStats(int i, Schmuck perp, int pr) {
		super(i, name, perm, visible, removedEnd, decay, perp, pr);
	}
	
	public BaselineStats(int pr){
		super("Baseline Stats", pr);
	}	

	public void statchanges(Schmuck s){
		s.setBuffedPow(s.getBasePow());
		s.setBuffedDef(s.getBaseDef());
		s.setBuffedSpd(s.getBaseSpd());
		s.setBuffedSkl(s.getBaseSkl());
		s.setBuffedLuk(s.getBaseLuk());
		s.setBuffedInt(s.getBaseInt());
	}
}
