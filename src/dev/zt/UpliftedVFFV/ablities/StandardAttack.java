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
		int hitChance = (int)(Math.random()*100);
		if(hitChance<bs.bp.em.getAcc(perp, vic)){
			switch((int)perp.getElemAlignment()){
			case 0:
				bs.bp.em.hpChange(-(perp.buffedStats[2]*perp.buffedStats[2])/vic.buffedStats[3], perp, vic);
				break;
			case 1:
				bs.bp.em.hpChange(-(perp.buffedStats[2]*perp.buffedStats[2])/vic.buffedStats[3], perp, vic,0);
				break;
			case 2:
				bs.bp.em.hpChange(-(perp.buffedStats[2]*perp.buffedStats[2])/vic.buffedStats[3], perp, vic,1);
				break;
			case 3:
				bs.bp.em.hpChange(-(perp.buffedStats[2]*perp.buffedStats[2])/vic.buffedStats[3], perp, vic,2);
				break;
			case 4:
				bs.bp.em.hpChange(-(perp.buffedStats[2]*perp.buffedStats[2])/vic.buffedStats[3], perp, vic,3);
				break;
			case 5:
				bs.bp.em.hpChange(-(perp.buffedStats[2]*perp.buffedStats[2])/vic.buffedStats[3], perp, vic,4);
				break;
			case 6:
				bs.bp.em.hpChange(-(perp.buffedStats[2]*perp.buffedStats[2])/vic.buffedStats[3], perp, vic,5);
				break;
				
			}
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
		bs.bp.em.hpChange(-(int)(((perp.buffedStats[2]*perp.buffedStats[2])/vic.buffedStats[3])*(1.5+perp.getCritMulti())), perp, vic);
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
