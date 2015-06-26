package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.LimitedUse;
import dev.zt.UpliftedVFFV.statusEffects.Silenced;
import dev.zt.UpliftedVFFV.statusEffects.TestStatBuff;

public class ForceWithin extends Skills {

	public String name = "Force Within";
	public String descr = "User channels a powerful force at\nfoes, damaging and dazing\nLimit : One use per fight.";
	public String descrShort = "Damages and stuns all foes\n1 use per fight.";
	public int cost = 6;
	public ForceWithin(int index) {
		super(index);

	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.bt.textList.add(perp.getName()+" used Force Within!");
		int hitChance = (int)(Math.random()*100);
		if(hitChance<bs.bp.em.getAcc(perp, vic)){
//			if(!bs.bp.stm.checkStatus(perp, new)){
				
//			}
			bs.bp.stm.addStatus(perp, new LimitedUse(0,this,0));
			for(Schmuck s : bs.bs.enemyTargets){
				bs.bp.em.hpChange(-11,s);
				for(int i = 0; i<bs.bp.TurnOrderQueue.size(); i++){
					if(bs.bp.TurnOrderQueue.get(i)!=null){
						if(bs.bp.TurnOrderQueue.get(i).user.equals(s) && !s.equals(perp)){
							bs.bp.TurnOrderQueue.remove(i);
							i--;
						}
					}
					
				}
			}
		}
		else{
			bs.bp.bt.textList.add(perp.getName()+" missed!");
		}
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


}
