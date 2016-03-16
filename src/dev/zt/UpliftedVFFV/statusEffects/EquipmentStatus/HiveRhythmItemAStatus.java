package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Combustibility;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.Stats.BonusStatBuff;
import dev.zt.UpliftedVFFV.statusEffects.Stats.StatBuffMult;

public class HiveRhythmItemAStatus extends status{

	status buff;
	public HiveRhythmItemAStatus(int pr, status st){
		super("Hive Rhythm : A", pr);
		this.buff = st;
	}
	
	public void onActionUser(BattleState bs, Action a){
		switch(buff.getExtraVar1()){
		case 1:
			bs.bp.bt.addScene("Hive Rhythm B-A chord echoes Powerfully!");
			for(Schmuck ally : bs.bp.getSelectableAllies(a.getUser())){
				if(bs.bp.stm.checkStatus(ally, new HiveRhythmBuffStatus(50))){
					bs.bp.stm.addStatus(ally, new StatBuffMult(3, 2, 1.1 *(1+a.getUser().getEquipPow()), a.getUser(), ally,50));
				}
			}
			break;
		case 2:
			bs.bp.bt.addScene("Hive Rhythm C-A chord echoes Explosively!");
			for(Schmuck enemy : bs.bp.getSelectableEnemies(a.getUser())){
				bs.bp.stm.addStatus(enemy, new Combustibility(0,a.getUser(), enemy, 50));
			}
			break;
		case 3:
			bs.bp.bt.addScene("Hive Rhythm D-A chord echoes Dynamically!");
			for(Schmuck ally : bs.bp.getSelectableAllies(a.getUser())){
				if(bs.bp.stm.checkStatus(ally, new HiveRhythmBuffStatus(50))){
					bs.bp.stm.addStatus(ally, new BonusStatBuff(0, 16, 0.5*(1+a.getUser().getEquipPow()), a.getUser(), ally, 50));
					bs.bp.stm.addStatus(ally, new BonusStatBuff(0, 17, 0.5*(1+a.getUser().getEquipPow()), a.getUser(), ally, 50));
				}
			}
			break;
		case 4:
			bs.bp.bt.addScene("Hive Rhythm E-A chord echoes Furiously!");
			for(Schmuck enemy : bs.bp.getSelectableEnemies(a.getUser())){
				bs.bp.em.hpChange((int)(-25*(1+a.getUser().getEquipPow())), a.getUser(), enemy, 0);
			}
			break;
		}
		for(Schmuck ally : bs.bp.getSelectableAllies(a.getUser())){
			if(bs.bp.stm.checkStatus(ally, new HiveRhythmBuffStatus(50))){
				bs.bp.stm.findStatus(ally, new HiveRhythmBuffStatus(50)).setExtraVar1(0);
			}
		}
	}
	
	
	
}
