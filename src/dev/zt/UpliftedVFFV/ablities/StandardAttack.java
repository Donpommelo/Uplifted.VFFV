package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class StandardAttack extends Skills {

	public StandardAttack(int index) {
		super(index, Assets.attack);

	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.bt.textList.add(perp.getName()+" attacks "+vic.getName()+"!");
		int hitChance = (int)(Math.random()*100);
		if(hitChance<bs.bp.em.getAcc(perp, vic)){
			bs.bp.em.hpChange(-(perp.buffedStats[2]*perp.buffedStats[2])/vic.buffedStats[3],vic);
			for(status s : perp.statuses){
				s.attackModify(perp, vic, bs, -(perp.buffedStats[2]*perp.buffedStats[2])/vic.buffedStats[3]);
			}
		}		
		else{
			bs.bp.bt.textList.add(perp.getName()+" missed!");
		}
		
		
	}
	

}
