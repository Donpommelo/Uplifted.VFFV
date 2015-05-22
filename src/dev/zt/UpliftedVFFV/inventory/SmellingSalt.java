package dev.zt.UpliftedVFFV.inventory;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.incapacitate;

public class SmellingSalt extends Item{

	static String descr="A package of chemicals used in reviving overworked or dead coworkers.";
	public SmellingSalt() {
		super(2, "Smellingsalt",true, true, true, true, false,descr);

	}
	
	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.bt.textList.add(perp.getName()+" administers the Smellingsalt to "+vic.getName());
		bs.bp.stm.removeStatus(vic, new incapacitate() );
		bs.bp.em.hpChange(5,vic);
	}
	
	

}
