package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class BalancedStats extends status{
	
	public static String name = "Balanced";
	public static Boolean perm = false;
	public static Boolean visible = false;
	public static Boolean removedEnd = true;
	public static Boolean decay = true;
	public BalancedStats(int i, Schmuck perp, Schmuck vic, int pr) {
		super(i, name, perm, visible, removedEnd, decay, perp, vic, pr);
	}
	
	public BalancedStats(Schmuck v,int pr){
		super(name, v, pr);
	}	

	public void statchanges(Schmuck s){
		int sumstat = 0;
		sumstat +=s.getBuffedPow();
		sumstat +=s.getBuffedDef();
		sumstat +=s.getBuffedSpd();
		sumstat +=s.getBuffedSkl();
		sumstat +=s.getBuffedInt();
		sumstat +=s.getBuffedLuk();
		
		s.setBuffedPow(sumstat/6);
		s.setBuffedDef(sumstat/6);
		s.setBuffedSpd(sumstat/6);
		s.setBuffedSkl(sumstat/6);
		s.setBuffedLuk(sumstat/6);
		s.setBuffedInt(sumstat/6);
	}
}
