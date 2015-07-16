package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Invuln;
import dev.zt.UpliftedVFFV.statusEffects.LimitedUse;


public class GodsBreath extends Skills {

	public static String name = "Gods Breath";
	public static String descr = "User infuses allies with divine aether\ngiving allies invulnerability\nLimit : One use per fight.";
	public static String descrShort = "Protects all allies\n1 use per fight.";
	public static int cost = 15;
	public GodsBreath(int index) {
		super(index,1,6, name, descr, descrShort, cost);

	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.bt.textList.add(perp.getName()+" used Gods Breath!");
		bs.bp.bt.textList.add("All allies were fortified!");
			bs.bp.stm.addStatus(perp, new LimitedUse(0,this,0, perp));
			for(Schmuck s : bs.bp.getSelectableAllies(perp)){
				bs.bp.stm.addStatus(s, new Invuln(0, perp));
			}
		
	}
	
	public void TOQChange(Action a, BattleState bs){
		bs.bp.TurnOrderQueue.remove(a);
		bs.bp.TurnOrderQueue.add(0, a);
	}
	
	public int getTargetType(){
		return targetType;
	}

}
