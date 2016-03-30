package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class Momentum extends status{
	
	public static String name = "Momentum";
	public static Boolean perm = true;
	public static Boolean visible = true;
	public static Boolean removedEnd = true;
	public static Boolean decay = false;	
	public Momentum(int i, Schmuck perp, Schmuck vic, int pr){
		super(i, name, perm, visible, removedEnd, decay, perp, vic,pr);
	}
		
	public int dealdamageEffect(Schmuck perp,Schmuck vic, BattleState bs, int damage, int elem){
		bs.bp.bt.addScene(perp.getName()+"'s Momentum transfered to "+vic.getName()+"!");
		bs.bp.stm.addStatus(vic, this);
		bs.bp.stm.hardRemoveStatus(perp, this);
		return (int)(damage * 1.5);
	}	
	
	public void onDeath(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.bt.addScene("Momentum was returned to "+perp.getName()+"!");
		bs.bp.stm.addStatus(perp, this);
	}

}
