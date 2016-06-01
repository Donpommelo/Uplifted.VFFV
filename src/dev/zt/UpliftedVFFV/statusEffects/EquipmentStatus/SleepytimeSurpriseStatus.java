package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;


import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Asleep;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class SleepytimeSurpriseStatus extends status{
	
	public SleepytimeSurpriseStatus(Schmuck v,int pr){
		super("Unsleeping",v, pr);
	}
	
	public void endofturnEffect(Schmuck s, BattleState bs){
		for(Schmuck ally : bs.bp.getSelectableAllies(s)){
			if(bs.bp.stm.checkStatus(ally, new Asleep(ally,50))){
				bs.bp.bt.addScene(s.getName()+"'s Sleepytime Surprise scans "+ally.getName()+"!");
				bs.bp.bt.addScene("UNPRODUCTIVITY DETECTED. COMMENCING DISCIPLINARY ACTION.");
				int damage = (int)(bs.bp.em.logScaleDamage(s, ally)*1.5);
				bs.bp.em.hpChange(damage, s, ally, 3);
			}
		}
		for(Schmuck enemy : bs.bp.getSelectableEnemies(s)){
			if(bs.bp.stm.checkStatus(enemy, new Asleep(enemy,50))){
				bs.bp.bt.addScene(s.getName()+"'s Sleepytime Surprise scans "+enemy.getName()+"!");
				bs.bp.bt.addScene("UNPRODUCTIVITY DETECTED. COMMENCING DISCIPLINARY ACTION.");
				int damage = (int)(bs.bp.em.logScaleDamage(s, enemy)*1.5);
				bs.bp.em.hpChange(damage, s, enemy, 3);
			}
		}
	}
}
