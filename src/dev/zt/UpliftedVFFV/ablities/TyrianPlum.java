package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.TyrianPlumEffect;

public class TyrianPlum extends Skills {

	public static String name = "Tyrian Plum";
	public static String descr = "User plants a seed into a target\nthat saps health over time.";
	public static String descrShort = "Drains health from target\nwhen using Mp";
	public static int cost = 13;
	public TyrianPlum(int index) {
		super(index,0,2, name, descr, descrShort, cost);

	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.bt.textList.add(perp.getName()+" used Tyrian Plum!");
		if(bs.bp.em.getAcc(perp, vic,100)){
			bs.bp.stm.addStatus(vic, new TyrianPlumEffect(6,perp, 70));
		}
		else{
			bs.bp.bt.textList.add(perp.getName()+" missed!");
		}
	}
	
	public void runCrit(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.bt.textList.add(perp.getName()+" used Tyrian Plum!");
		bs.bp.bt.textList.add("A Critical blow!");
		bs.bp.stm.addStatus(vic, new TyrianPlumEffect((int)(6*(1+perp.getCritMulti())),perp, 70));	
	}

}
