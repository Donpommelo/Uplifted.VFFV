package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.LimitedUse;
import dev.zt.UpliftedVFFV.statusEffects.Stunned;
import dev.zt.UpliftedVFFV.statusEffects.TestStatBuff;


public class Petrify extends Skills {

	public String name = "Petrify";
	public String descr = "User petrifies a target, disabling\nthem for a long duration\nLimit : One use per fight.";
	public String descrShort = "Stuns target\n1 use per fight.";
	public int cost = 10;
	public Petrify(int index) {
		super(index);

	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.bt.textList.add(perp.getName()+" used Petrify!");
		bs.bp.bt.textList.add(vic.getName()+" was petrified!");
		bs.bp.stm.addStatus(perp, new LimitedUse(0,this,0, perp));
		bs.bp.stm.addStatus(vic, new Stunned(3,perp));	
		bs.bp.stm.addStatus(vic, new TestStatBuff(3,1.5,perp,10));
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
	
	
	public int getTargetType(){
		return targetType;
	}

}
