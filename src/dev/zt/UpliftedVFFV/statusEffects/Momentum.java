package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class Momentum extends status{
	
	public static String name = "Momentous";
	public static Boolean perm = true;
	public static Boolean visible = true;
	public static Boolean removedEnd = true;
	public static Boolean decay = false;	
	public Momentum(int i, Schmuck perp, int pr){
		super(i, name, perm, visible, removedEnd, decay, perp, pr);
	}
	
	public Momentum(int pr){
		super(name, pr);
	}	
		
	public int dealdamageEffect(Schmuck perp,Schmuck vic, BattleState bs, int damage, int elem){
		bs.bp.bt.addScene(vic.getName()+"'s Momentum transfered to "+vic.getName()+"!");
		bs.bp.stm.addStatus(vic, this);
		bs.bp.stm.hardRemoveStatus(perp, this);
		return (int)(damage * 1.5);
	}	
}
