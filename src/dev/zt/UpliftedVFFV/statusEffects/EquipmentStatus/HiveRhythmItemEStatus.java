package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Poisoned;
import dev.zt.UpliftedVFFV.statusEffects.Vampirism;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.Stats.BonusStatBuff;
import dev.zt.UpliftedVFFV.statusEffects.Stats.StatBuffMult;

public class HiveRhythmItemEStatus extends status{

	status buff;
	public HiveRhythmItemEStatus(Schmuck v,int pr, status st){
		super("Hive Rhythm : E", v, pr);
		this.buff = st;
	}
	
	public void onActionUser(BattleState bs, Action a){
		switch(buff.getExtraVar1()){
		case 0:
			bs.bp.bt.addScene("Hive Rhythm A-E chord echoes Mysteriously!");
			for(Schmuck ally : bs.bp.getSelectableAllies(a.getUser())){
				if(bs.bp.stm.checkStatus(ally, new HiveRhythmBuffStatus(ally,50))){
					bs.bp.stm.addStatus(ally, new StatBuffMult(3, 6, 1.1*(1+a.getUser().getEquipPow()), a.getUser(), ally,50));
				}
			}
			break;
		case 1:
			bs.bp.bt.addScene("Hive Rhythm B-E chord echoes Inspiringly!");
			for(Schmuck ally : bs.bp.getSelectableAllies(a.getUser())){
				if(bs.bp.stm.checkStatus(ally, new HiveRhythmBuffStatus(ally,50))){
					bs.bp.em.bpChange((int)(25*(1+a.getUser().getEquipPow())*(1+ally.getRegenBonus())), ally);
				}
			}
			break;
		case 3:
			bs.bp.bt.addScene("Hive Rhythm C-E chord echoes Methodically!");
			for(Schmuck ally : bs.bp.getSelectableAllies(a.getUser())){
				if(bs.bp.stm.checkStatus(ally, new HiveRhythmBuffStatus(ally,50))){
					bs.bp.stm.addStatus(ally, new BonusStatBuff(0, 13, 0.5*(1+a.getUser().getEquipPow()), a.getUser(), ally,50));
				}
			}
			break;
		case 4:
			bs.bp.bt.addScene("Hive Rhythm D-E chord echoes Precisely!");
			for(Schmuck ally : bs.bp.getSelectableAllies(a.getUser())){
				if(bs.bp.stm.checkStatus(ally, new HiveRhythmBuffStatus(ally,50))){
					bs.bp.stm.addStatus(ally, new BonusStatBuff(0, 0, 0.5*(1+a.getUser().getEquipPow()), a.getUser(), ally,50));
				}
			}
			break;
		}
		for(Schmuck ally : bs.bp.getSelectableAllies(a.getUser())){
			if(bs.bp.stm.checkStatus(ally, new HiveRhythmBuffStatus(ally,50))){
				bs.bp.stm.findStatus(ally, new HiveRhythmBuffStatus(ally,50)).setExtraVar1(4);
			}
		}
	}
	
	
	
}
