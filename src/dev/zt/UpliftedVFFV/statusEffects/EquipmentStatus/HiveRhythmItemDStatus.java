package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;

import java.util.ArrayList;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Paralysis;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.Stats.BonusStatBuff;
import dev.zt.UpliftedVFFV.statusEffects.Stats.StatBuffMult;

public class HiveRhythmItemDStatus extends status{

	status buff;
	public HiveRhythmItemDStatus(Schmuck v,int pr, status st){
		super("Hive Rhythm : D",v, pr);
		this.buff = st;
	}
	
	public void onActionUser(BattleState bs, Action a){
		switch(buff.getExtraVar1()){
		case 0:
			bs.bp.bt.addScene("Hive Rhythm A-D chord echoes Urgently!");
			for(Schmuck ally : bs.bp.getSelectableAllies(a.getUser())){
				if(bs.bp.stm.checkStatus(ally, new HiveRhythmBuffStatus(ally,50))){
					bs.bp.stm.addStatus(ally, new BonusStatBuff(1, 14, 0.5*(1+a.getUser().getEquipPow()), a.getUser(), ally, 50));
				}
			}
			break;
		case 1:
			bs.bp.bt.addScene("Hive Rhythm B-D chord echoes Purifyingly!");
			for(Schmuck ally : bs.bp.getSelectableAllies(a.getUser())){
				if(bs.bp.stm.checkStatus(ally, new HiveRhythmBuffStatus(ally,50))){
					ArrayList<status> removed = new ArrayList<status>();
					for(status st : ally.statuses){
						if(!st.perm && st.isBad()){
							removed.add(st);
						}
					}
					for(status st : ally.statusesChecked){
						if(!st.perm && st.isBad()){
							removed.add(st);
						}
					}
					for(status st : removed){
						bs.bp.stm.removeStatus(ally, st);
					}
				}
			}
			break;
		case 2:
			bs.bp.bt.addScene("Hive Rhythm C-D chord echoes Rapidly!");
			for(Schmuck ally : bs.bp.getSelectableAllies(a.getUser())){
				if(bs.bp.stm.checkStatus(ally, new HiveRhythmBuffStatus(ally,50))){
					bs.bp.stm.addStatus(ally, new StatBuffMult(3, 4, 1.1*(1+a.getUser().getEquipPow()), a.getUser(), ally, 50));
				}
			}
			break;
		case 4:
			bs.bp.bt.addScene("Hive Rhythm E-D chord echoes Mesmerizingly!");
			for(Schmuck enemy : bs.bp.getSelectableEnemies(a.getUser())){
				bs.bp.stm.addStatus(enemy, new Paralysis(0,a.getUser(), enemy, 50));
			}
			break;
		}
		for(Schmuck ally : bs.bp.getSelectableAllies(a.getUser())){
			if(bs.bp.stm.checkStatus(ally, new HiveRhythmBuffStatus(ally,50))){
				bs.bp.stm.findStatus(ally, new HiveRhythmBuffStatus(ally,50)).setExtraVar1(3);
			}
		}
	}
	
	
	
}
