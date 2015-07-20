package dev.zt.UpliftedVFFV.inventory;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.incapacitate;

public class SmellingSalt extends Item{

	static String descr="A package of chemicals used in reviving overworked or dead coworkers.";
	static String descrShort="Revives target.";
	public SmellingSalt() {
		super(2, "Smellingsalt",true, true, true, true,descr, descrShort,35,0);

	}
	
	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.bt.textList.add(perp.getName()+" administers the Smellingsalt to "+vic.getName());
		bs.bp.stm.removeStatus(vic, new incapacitate(vic) );
		bs.bs.targetUpdate();
		bs.bp.em.hpChange(5, perp, vic,6);
	}
	
	public void use(Schmuck s){
		s.hpChange(5);
		for(int i=0; i<s.statuses.size(); i++){
			if(s.statuses.get(i).getName()!=null){
				if(s.statuses.get(i).getName().equals("incapacitated")){
					s.statuses.remove(i);
					i--;
				}
			}
		}
		
	}
	
	public int getTargetType(){
		return 2;
	}

}
