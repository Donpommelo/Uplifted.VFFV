package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.PrismaticResistance;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.Stats.BonusStatBuff;
import dev.zt.UpliftedVFFV.statusEffects.Stats.StatBuffMult;

public class HiveRhythmItemBStatus extends status{
	
	status buff;
	public HiveRhythmItemBStatus(Schmuck v,int pr, status st){
		super("Hive Rhythm : B", v, pr);
		this.buff = st;
	}
	
	public void onActionUser(BattleState bs, Action a){
		switch(buff.getExtraVar1()){
		case 0:
			bs.bp.bt.addScene("Hive Rhythm A-B chord echoes Salubriously!");
			for(Schmuck ally : bs.bp.getSelectableAllies(a.getUser())){
				if(bs.bp.stm.checkStatus(ally, new HiveRhythmBuffStatus(ally,50))){
					bs.bp.em.hpChange((int)(25*(1+a.getUser().getEquipPow())*(1+ally.getRegenBonus())), a.getUser(), ally, 1);
				}
			}
			break;
		case 2:
			bs.bp.bt.addScene("Hive Rhythm C-B chord echoes Smoothly!");
			for(Schmuck ally : bs.bp.getSelectableAllies(a.getUser())){
				if(bs.bp.stm.checkStatus(ally, new HiveRhythmBuffStatus(ally,50))){
					bs.bp.stm.addStatus(ally, new BonusStatBuff(0, 1, 0.5*(1+a.getUser().getEquipPow()), a.getUser(), ally, 50));
				}
			}
			break;
		case 3:
			bs.bp.bt.addScene("Hive Rhythm D-B chord echoes Protectively!");
			for(Schmuck ally : bs.bp.getSelectableAllies(a.getUser())){
				if(bs.bp.stm.checkStatus(ally, new HiveRhythmBuffStatus(ally,50))){
					bs.bp.stm.addStatus(ally, new StatBuffMult(3, 3, 1.1*(1+a.getUser().getEquipPow()), a.getUser(), ally, 50));
				}
			}
			break;
		case 4:
			bs.bp.bt.addScene("Hive Rhythm E-B chord echoes Resiliently!");
			for(Schmuck ally : bs.bp.getSelectableAllies(a.getUser())){
				if(bs.bp.stm.checkStatus(ally, new HiveRhythmBuffStatus(ally,50))){
					bs.bp.stm.addStatus(ally, new PrismaticResistance(0, .5*(1+a.getUser().getEquipPow()), a.getUser(), ally, 50));
				}
			}
			break;
		}
		for(Schmuck ally : bs.bp.getSelectableAllies(a.getUser())){
			if(bs.bp.stm.checkStatus(ally, new HiveRhythmBuffStatus(ally,50))){
				bs.bp.stm.findStatus(ally, new HiveRhythmBuffStatus(ally,50)).setExtraVar1(1);
			}
		}
	}
	
	
	
}
