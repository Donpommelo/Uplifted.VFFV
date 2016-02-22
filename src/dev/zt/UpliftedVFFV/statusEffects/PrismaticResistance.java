package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class PrismaticResistance extends status{
	
	public static String name = "Prismatic Resistance";
	public static Boolean perm = false;
	public static Boolean visible = false;
	public static Boolean removedEnd = true;
	public static Boolean decay = true;
	public double buffAmount;
	public PrismaticResistance(int i, double amount, Schmuck perp, int pr) {
		super(i, name, perm, visible, removedEnd, decay, perp, pr);
		this.buffAmount = amount;
	}
	
	public PrismaticResistance(double amount, int pr){
		super("Prismatic Resistance", pr);
		this.buffAmount = amount;

	}	

	public void statchanges(Schmuck s){
		s.setRedRes(s.getRedRes() + buffAmount);
		s.setBlueRes(s.getBlueRes() + buffAmount);
		s.setGreenRes(s.getGreenRes() + buffAmount);
		s.setYellowRes(s.getYellowRes() + buffAmount);
		s.setPurpleRes(s.getPurpleRes() + buffAmount);
	}
	
	public String inflictText(Schmuck s){
		return s.getName()+"'s Elemental resistances were bolstered!";
	}
}
