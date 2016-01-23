package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.skillSpecific.BindStatus;


public class Bind extends Skills {

	public static String name = "Bind";
	public static String descr = "User holds a foe in place,\nstunning them but\npreoccuping oneself.";
	public static String descrShort = "Binds target for several turns.";
	public static int cost = 15;
	public static int baseAcc = 80; public static int baseCrit = 0;
	public static boolean canMiss = true; public static boolean canCrit = true;
	public static int element = 6;	//Physical
	public static int targetType = 0;	//Any Single Target
	public Bind(int index) {
		super(index, targetType, element, name, descr, descrShort, cost, baseAcc, baseCrit, canMiss, canCrit);
	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.stm.addStatus(perp, new BindStatus(3, perp,vic, 50));
		for(int i = 0; i<bs.bp.TurnOrderQueue.size(); i++){
			if(bs.bp.TurnOrderQueue.get(i) != null){
				if(bs.bp.TurnOrderQueue.get(i).getUser().equals(vic)){
					bs.bp.TurnOrderQueue.set(0, new Action(vic,vic,new FlavorNothing(0,vic.getName()+" is being Binded by "+perp.getName()+"!"),bs));
				}
			}
		}
	}

	public void runCrit(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.stm.addStatus(perp, new BindStatus((int)(3*(1.5+perp.getCritMulti()-vic.getCritRes())), perp,vic, 50));	
		for(int i = 0; i<bs.bp.TurnOrderQueue.size(); i++){
			if(bs.bp.TurnOrderQueue.get(i) != null){
				if(bs.bp.TurnOrderQueue.get(i).getUser().equals(vic)){
					bs.bp.TurnOrderQueue.set(0, new Action(vic,vic,new FlavorNothing(0,vic.getName()+" is being Binded by "+perp.getName()+"!"),bs));
				}
			}
		}
	}
}
