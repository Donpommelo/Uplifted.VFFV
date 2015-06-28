package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Silenced;


public class Censor extends Skills {

	public String name = "Censor";
	public String descr = "User harshly Censors a for, causing\nthem to be unable to cast\nspecial abilities.";
	public String descrShort = "Silences target.";
	public int cost = 10;
	public Censor(int index) {
		super(index);

	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.bt.textList.add(perp.getName()+" used Censor!");
		int hitChance = (int)(Math.random()*100);
		if(hitChance<bs.bp.em.getAcc(perp, vic)){
			bs.bp.stm.addStatus(vic, new Silenced(3, perp));
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
