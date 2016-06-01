package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class LeperKhansBladeStatus extends status{
	
	public LeperKhansBladeStatus(Schmuck v,int pr){
		super("Leperosy", v,pr);
	}
	
	public void attackModify(Schmuck perp,Schmuck vic, BattleState bs, int damage){
		for(status st : perp.statuses){
			if(st.isBad() && !st.perm){
				bs.bp.bt.addScene("Leper Khan's Blade infects "+vic.getName()+" with "+st.getName()+"!");
				if(Math.random() < .3 * (1+perp.getEquipPow())*(float)(perp.getBuffedLuk()/vic.getBuffedLuk())){
					bs.bp.stm.addStatus(vic, st);
				}
			}
		}
		for(status st : perp.statusesChecked){
			if(st.isBad() && !st.perm){
				bs.bp.bt.addScene("Leper Khan's Blade infects "+vic.getName()+" with "+st.getName()+"!");
				if(Math.random() < .3 * (1+perp.getEquipPow())*(float)(perp.getBuffedLuk()/vic.getBuffedLuk())){
					bs.bp.stm.addStatus(vic, st);
				}
			}
		}

	}

}
