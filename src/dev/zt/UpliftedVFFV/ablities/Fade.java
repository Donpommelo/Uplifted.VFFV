package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Untouchable;

public class Fade extends Skills {

	public static String name = "Fade";
	public static String descr = "User fades from existance\n becomming untargetable.";
	public static String descrShort = "User becomes untargetable.";
	public static int cost = 8;
	public Fade(int index) {
		super(index,1,6, name, descr, descrShort, cost);
	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.bt.textList.add(perp.getName()+" used Fade!");
		bs.bp.stm.addStatus(perp, new Untouchable(2, perp, 50));

	}
		
}
