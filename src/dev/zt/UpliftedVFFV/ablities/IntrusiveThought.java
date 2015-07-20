package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.IntrusiveThoughtEffect;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class IntrusiveThought extends Skills {

	public static String name = "Intrusive Thought";
	public static String descr = "User causes a target's Intrusive\nThoughts to flourish,\nstacking an invisible debuff.";
	public static String descrShort = "Delayed damage debuff.";
	public static int cost = 1;
	public IntrusiveThought(int index) {
		super(index,0,4, name, descr, descrShort, cost);

	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.bt.textList.add(perp.getName()+" used Intrusive Thought!");
		if(bs.bp.em.getAcc(perp, vic,100)){
			bs.bp.em.hpChange(-(3), perp, vic,6);
			int stacked = -1;
			for(status s : vic.statuses){
				if(s!=null){
					if(s.getName().equals("Intrusive Thoughts")){
						stacked = vic.statuses.indexOf(s);
					}	
				}
								
			}
			if(stacked!=-1){
				vic.statuses.get(stacked).stack++;
				bs.bp.bt.textList.add(vic.getName()+"'s Intrusive Thoughts grow.");
			}
			else{
				bs.bp.stm.addStatus(vic, new IntrusiveThoughtEffect(10, perp, 50));
			}
		}
		else{
			bs.bp.bt.textList.add(perp.getName()+" missed!");
		}

		
	}
	
	public int damageCalc(Schmuck perp, Schmuck vic, BattleState bs){
		return 3;
	}
}
