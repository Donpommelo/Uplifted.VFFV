package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class StandardAttack extends Skills {

	public String name = "Attack";
	public StandardAttack(int index) {
		super(index, Assets.attack);

	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.bt.textList.add(perp.getName()+" attacks "+vic.getName()+"!");
		int hitChance = (int)(Math.random()*100);
		if(hitChance<bs.bp.em.getAcc(perp, vic)){
			bs.bp.em.hpChange(-(perp.buffedStats[2]*perp.buffedStats[2])/vic.buffedStats[3], perp, vic);
			for(int i=0; i<perp.statuses.size(); i++){
				if(perp.statuses.get(i)!=null){
					perp.statuses.get(i).attackModify(perp, vic, bs, -(perp.buffedStats[2]*perp.buffedStats[2])/vic.buffedStats[3]);
				}
			}
		}		
		else{
			bs.bp.bt.textList.add(perp.getName()+" missed!");
		}		
	}
	
	public void runCrit(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.bt.textList.add(perp.getName()+" attacks "+vic.getName()+"!");
		bs.bp.bt.textList.add("A Critical blow!");
		bs.bp.em.hpChange(-(int)(((perp.buffedStats[2]*perp.buffedStats[2])/vic.buffedStats[3])*(1.5*perp.getCritMulti())), perp, vic);
		for(int i=0; i<perp.statuses.size(); i++){
			if(perp.statuses.get(i)!=null){
				perp.statuses.get(i).attackModify(perp, vic, bs, -(perp.buffedStats[2]*perp.buffedStats[2])/vic.buffedStats[3]);
			}
		}		
	}
	
	
	public String getName(){
		return name;
	}
	

}
