package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Poisoned;
import dev.zt.UpliftedVFFV.statusEffects.Vampirism;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.Stats.BonusStatBuff;
import dev.zt.UpliftedVFFV.statusEffects.Stats.StatBuffMult;

public class HiveRhythmItemCStatus extends status{
	
	status buff;
	public HiveRhythmItemCStatus(int pr, status st){
		super("Hive Rhythm : C", pr);
		this.buff = st;
	}
	
	public void onActionUser(BattleState bs, Action a){
		switch(buff.getExtraVar1()){
		case 0:
			bs.bp.bt.addScene("Hive Rhythm A-C chord echoes Concretely!");
			for(Schmuck ally : bs.bp.getSelectableAllies(a.getUser())){
				if(bs.bp.stm.checkStatus(ally, new HiveRhythmBuffStatus(50))){
					bs.bp.stm.addStatus(ally, new BonusStatBuff(0, 10, 0.5*(1+a.getUser().getEquipPow()), a.getUser(), 50));
				}
			}
			break;
		case 1:
			bs.bp.bt.addScene("Hive Rhythm B-C chord echoes Hungrily!");
			for(Schmuck ally : bs.bp.getSelectableAllies(a.getUser())){
				if(bs.bp.stm.checkStatus(ally, new HiveRhythmBuffStatus(50))){
					bs.bp.stm.addStatus(ally, new Vampirism(0, 0.25*(1+a.getUser().getEquipPow()), a.getUser(), 50));
				}
			}
			break;
		case 3:
			bs.bp.bt.addScene("Hive Rhythm D-C chord echoes Poisonously!");
			for(Schmuck enemy : bs.bp.getSelectableEnemies(a.getUser())){
				bs.bp.stm.addStatus(enemy, new Poisoned((int)(2*(1+a.getUser().getEquipPow())),a.getUser(), 50));
			}
			break;
		case 4:
			bs.bp.bt.addScene("Hive Rhythm E-C chord echoes Expertly!");
			for(Schmuck ally : bs.bp.getSelectableAllies(a.getUser())){
				if(bs.bp.stm.checkStatus(ally, new HiveRhythmBuffStatus(50))){
					bs.bp.stm.addStatus(ally, new StatBuffMult(3, 5, 1.1*(1+a.getUser().getEquipPow()), a.getUser(), 50));
				}
			}
			break;
		}
		for(Schmuck ally : bs.bp.getSelectableAllies(a.getUser())){
			if(bs.bp.stm.checkStatus(ally, new HiveRhythmBuffStatus(50))){
				bs.bp.stm.findStatus(ally, new HiveRhythmBuffStatus(50)).setExtraVar1(2);
			}
		}
		
	}
	
	
	
}
