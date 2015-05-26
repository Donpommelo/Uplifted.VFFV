package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.PennyBlueStatus;
import dev.zt.UpliftedVFFV.statusEffects.TestStatBuff;

public class PennyBlue extends Skills {

	public String name = "Penny Blue";
	public String descr = "User grants a target a\nBlue-aligned shield that\nregenerates health and\nbolsters Red resistance.";
	public String descrShort = "Buffs Red Resist and regen.";
	public int cost = 6;
	public PennyBlue(int index) {
		super(index);
	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.bt.textList.add(perp.getName()+" used Penny Blue!");
		bs.bp.stm.addStatus(vic, new PennyBlueStatus(3));
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
	
	public boolean startTarget(){
		return true;
	}

}
