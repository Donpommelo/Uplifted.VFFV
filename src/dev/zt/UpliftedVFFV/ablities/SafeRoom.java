package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.Battle.BattleProcessor;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.IntrusiveThoughtEffect;
import dev.zt.UpliftedVFFV.statusEffects.Invuln;

public class SafeRoom extends Skills {

	public String name = "Safe Room";
	public String descr = "User banishes a target into an\n impervious box that both\nprotects and subdues the target.";
	public String descrShort = "Banish and protect target.";
	public int cost = 6;
	public SafeRoom(int index) {
		super(index);

	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.bt.textList.add(perp.getName()+" uses Safe Room!");
		bs.bp.bt.textList.add(vic.getName()+" was banished.");
		for(int i = 0; i<bs.bp.TurnOrderQueue.size(); i++){
			if(bs.bp.TurnOrderQueue.get(i).user.equals(vic) && !vic.equals(perp)){
				bs.bp.TurnOrderQueue.remove(i);
				i--;
			}
		
		}
		bs.bp.stm.addStatus(vic, new Invuln(0));
		
	}
	
	public String getName(){
		return name;
	}
	
	public String getDescr(){
		return descr;
	}
	
	public String getDescrShort() {
		return descrShort;
	}
	
	public int getCost(){
		return cost;
	}
	
	public void TOQChange(Action a, BattleState bs){
		bs.bp.TurnOrderQueue.remove(a);
		bs.bp.TurnOrderQueue.add(0, a);
	}
	

}
