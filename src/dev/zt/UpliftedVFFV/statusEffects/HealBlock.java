package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class HealBlock extends status{
	
	public static String name = "Heal Block";
	public static Boolean perm = false;
	public static Boolean visible = true;
	public static Boolean removedEnd = false;
	public static Boolean decay = true;
	public HealBlock(int i, Schmuck perp, Schmuck vic, int pr){
		super(i, name, perm, visible, removedEnd, decay, perp, vic, pr);
	}
	
	public HealBlock(int pr){
		super(name, pr);
	}
	
	public int onHealTargetEffect(Schmuck perp,Schmuck vic, BattleState bs, int damage, int elem){
		bs.bp.bt.addScene(vic.getName()+" was prevented from healing!");
		return 0;
	}

	public String inflictText(Schmuck s){
		return s.getName()+" can no longer heal!";
	}

	public String cureText(Schmuck s){
		return s.getName()+" can heal again!";
	}
	
	public Boolean isBad(){
		return true;
	}
}
