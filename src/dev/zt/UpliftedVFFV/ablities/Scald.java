package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Ablaze;
import dev.zt.UpliftedVFFV.statusEffects.TestStatBuff;

public class Scald extends Skills {

	public String name = "Scald";
	public String descr = "A spray of boiling hot liquid that can inflict nasty burns.";
	public String descrShort = "Red damage and Ablaze.";
	public int cost = 1;
	public Scald(int index) {
		super(index, Assets.attack);

	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.bt.textList.add(perp.getName()+" uses Scald!");
		int hitChance = (int)(Math.random()*100);
		if(hitChance<bs.bp.em.getAcc(perp, vic)){
			bs.bp.em.hpChange(-(perp.buffedStats[2]*perp.buffedStats[2])/vic.buffedStats[2],vic,0);
			bs.bp.stm.addStatus(vic, new Ablaze(3));
		}		
		else{
			bs.bp.bt.textList.add(perp.getName()+" missed!");
		}
		
	}
	
	public String getName(){
		return name;
	}
	
	public String getDescr() {
		return descr;
	}
	
	public String getDescrShort() {
		return descrShort;
	}
	
	public int getCost(){
		return cost;
	}
	

}
