package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.TyrianPlumEffect;

public class TyrianPlum extends Skills {

	public String name = "Tyrian Plum";
	public String descr = "User plants a seed into a target\nthat saps health over time.";
	public String descrShort = "Drains health from target\nwhen using Mp";
	public int cost = 13;
	public TyrianPlum(int index) {
		super(index);

	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.bt.textList.add(perp.getName()+" used Tyrian Plum!");
		int hitChance = (int)(Math.random()*100);
		if(hitChance<.75*bs.bp.em.getAcc(perp, vic)){
			bs.bp.stm.addStatus(vic, new TyrianPlumEffect(6,perp));
		}
		else{
			bs.bp.bt.textList.add(perp.getName()+" missed!");
		}
	}
	
	public void runCrit(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.bt.textList.add(perp.getName()+" used Tyrian Plum!");
		bs.bp.bt.textList.add("A Critical blow!");
		bs.bp.em.hpChange(-(int)(((perp.buffedStats[2]*perp.buffedStats[2])/vic.buffedStats[3])*(1.5*perp.getCritMulti())), perp, vic);
		bs.bp.stm.addStatus(vic, new TyrianPlumEffect((int)(6*perp.getCritMulti()),perp));	
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
