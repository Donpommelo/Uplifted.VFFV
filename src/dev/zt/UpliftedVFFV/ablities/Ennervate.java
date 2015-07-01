package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.TestStatBuff;

public class Ennervate extends Skills {

	public String name = "Ennervate";
	public String descr = "User casts a fatiguing aura that\ncauses a targeted foe's Power\nand Speed to decrease.";
	public String descrShort = "Lowers single targets Pow\nand Spd.";
	public int cost = 4;
	public Ennervate(int index) {
		super(index);

	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.bt.textList.add(perp.getName()+" used Ennervate!");
		bs.bp.stm.addStatus(vic, new TestStatBuff(2,2,.9, perp,60));
		bs.bp.stm.addStatus(vic, new TestStatBuff(2,4,.9, perp,60));
	}
	
	public void runCrit(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.bt.textList.add(perp.getName()+" used Ennervate!");
		bs.bp.bt.textList.add(vic.getName()+" was Critically Ennervated!");
		bs.bp.stm.addStatus(vic, new TestStatBuff((int)(2*(1.5+perp.getCritMulti())),2,.9, perp,60));
		bs.bp.stm.addStatus(vic, new TestStatBuff((int)(2*(1.5+perp.getCritMulti())),4,.9, perp,60));		
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
