package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class StandardAttack extends Skills {

	public String name = "Attack";
	public StandardAttack(int index) {
		super(index, Assets.attack,6);

	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.bt.textList.add(perp.getName()+" attacks "+vic.getName()+"!");
		int statAttack = (int)(perp.getDamageStat()+2);
		int hitChance = (int)(Math.random()*100);
		if(hitChance<bs.bp.em.getAcc(perp, vic)){
			if((int)perp.getElemAlignment() == 0 ){
				bs.bp.em.hpChange(-(perp.buffedStats[statAttack]*perp.buffedStats[statAttack])/vic.buffedStats[3], perp, vic);
				}
			else{
				bs.bp.em.hpChange(-(perp.buffedStats[statAttack]*perp.buffedStats[statAttack])/vic.buffedStats[3], perp, vic,(int)(perp.getElemAlignment()-1));				
			}
			for(int i=0; i<perp.statuses.size(); i++){
				if(perp.statuses.get(i)!=null){
					perp.statuses.get(i).attackModify(perp, vic, bs, -(perp.buffedStats[statAttack]*perp.buffedStats[statAttack])/vic.buffedStats[3]);
				}
			}
		}		
		else{
			bs.bp.bt.textList.add(perp.getName()+" missed!");
		}		
	}
	
	public void runCrit(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.bt.textList.add(perp.getName()+" attacks "+vic.getName()+"!");
		int statAttack = (int)(perp.getDamageStat()+2);
		bs.bp.bt.textList.add("A Critical blow!");
		bs.bp.em.hpChange(-(int)(((perp.buffedStats[statAttack]*perp.buffedStats[statAttack])/vic.buffedStats[3])*(1.5+perp.getCritMulti())), perp, vic);
		for(int i=0; i<perp.statuses.size(); i++){
			if(perp.statuses.get(i)!=null){
				perp.statuses.get(i).attackModify(perp, vic, bs, -(perp.buffedStats[statAttack]*perp.buffedStats[statAttack])/vic.buffedStats[3]);
			}
		}		
	}
	
	
	public String getName(){
		return name;
	}
	

}
