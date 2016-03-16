package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;


import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.incapacitate;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class KillSwitchStatus extends status{
	
	int reviveTimer;
	public KillSwitchStatus(int pr){
		super("Killed?", pr);
		this.reviveTimer = 3;
		
	}
	
	public void endofturnEffect(Schmuck s, BattleState bs){
		if(reviveTimer > 0){
			reviveTimer--;
		}
		else{
			if(bs.bp.stm.checkStatus(s, new incapacitate(s,s))){
				bs.bp.bt.addScene(s.getName()+"'s Kill Switch crackles with life!");
				bs.bp.stm.removeStatus(s, new incapacitate(s,s));
				bs.bp.stm.removeStatus(s, this);
				bs.bp.em.hpChange((int)(5*(1+s.getEquipPow())*(1+s.getRegenBonus())), s, s, 3);
			}
		}
	}
	
	public Boolean runWhenDead(){
		return false;
	}
}
