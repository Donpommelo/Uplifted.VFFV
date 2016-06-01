package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class TomeofPermanenceStatus extends status{
	
	public TomeofPermanenceStatus(Schmuck v,int pr){
		super("Permanent", v,pr);
	}
	
	public void attackModify(Schmuck perp,Schmuck vic, BattleState bs, int damage){
		if(Math.random() < 0.5 * (1+perp.getEquipPow())*(float)(perp.getBuffedLuk()/vic.getBuffedLuk())){
			bs.bp.bt.addScene(perp.getName()+"'s Tome of Permanence extends duration of debuffs!");
			for(status st : vic.statuses){
				if(st.isBad() && !st.perm){
					bs.bp.bt.addScene("The duration of "+vic.getName()+"'s "+st.getName()+" was extended!");
					st.setDuration(st.getDuration()+1);
				}
			}
		}
	}

}
