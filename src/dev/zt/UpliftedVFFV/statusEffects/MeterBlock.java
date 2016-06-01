package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class MeterBlock extends status{
	
	public static String name = "Meter Block";
	public static Boolean perm = false;
	public static Boolean visible = true;
	public static Boolean removedEnd = false;
	public static Boolean decay = true;
	public MeterBlock(int i, Schmuck perp, Schmuck vic, int pr){
		super(i, name, perm, visible, removedEnd, decay, perp, vic, pr);
	}
	
	public MeterBlock(Schmuck v,int pr){
		super(name, v,pr);
	}
	
	
	public int gainMeterEffect(Schmuck s, BattleState bs, int mp){
		bs.bp.bt.addScene(s.getName()+" was prevented from regenerating Mp!");
		return 0;
	}
	
	public String inflictText(Schmuck s){
		return s.getName()+" can no longer regain Mp!";
	}

	public String cureText(Schmuck s){
		return s.getName()+" can regain Mp again!";
	}
	
	public Boolean isBad(){
		return true;
	}
}
