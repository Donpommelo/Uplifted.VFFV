package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.Stats.BonusStatBuff;
import dev.zt.UpliftedVFFV.statusEffects.Stats.StatBuffMult;

public class SalvagerToolBeltStatus extends status{

	public SalvagerToolBeltStatus(Schmuck v,int pr){
		super("Tool-Using Salvager", v,pr);
	}
	
	public void statchanges(Schmuck s, BattleState bs){
		s.setBonusItem(s.getBonusItem()+.10*(1+s.getEquipPow()));
	}
	
	public void endofturnEffect(Schmuck s, BattleState bs){
		double percent = s.getBonusItem()*(1+s.getEquipPow());
		if(percent > 0){
			int option = (int)(Math.random()*7);
			switch(option){
			case 0:
				bs.bp.bt.addScene(s.getName()+" produces a suture from "+s.getPronoun(1)+" toolbelt and closes up wounds!");
				bs.bp.em.hpChange((int)(s.getMaxHp()*percent/2), s, s, 6);
				break;
			case 1:
				bs.bp.bt.addScene(s.getName()+" produces a needle from "+s.getPronoun(1)+" toolbelt and injects "+s.getPronoun(3)+"self!");
				bs.bp.em.bpChange((int)(s.getMaxBp()*percent/2),s);
				break;
			case 2:
				bs.bp.bt.addScene(s.getName()+" produces a hook from "+s.getPronoun(1)+" toolbelt and jabs a foe!");
				Schmuck target = bs.bp.getSelectableEnemies(s).get((int)(Math.random()*bs.bp.getSelectableEnemies(s).size()));
				int damage = (int)(bs.bp.em.logScaleDamage(s, target) * percent);
				bs.bp.em.hpChange(damage, s, target,6);		
				break;
			case 3:
				bs.bp.bt.addScene(s.getName()+" produces a metal sheet from "+s.getPronoun(1)+" toolbelt and reinforces armor!");
				bs.bp.stm.addStatus(s, new StatBuffMult(2,3,1.25,s,s,50));
				break;
			case 4:
				bs.bp.bt.addScene(s.getName()+" produces a compass from "+s.getPronoun(1)+" toolbelt and orients "+s.getPronoun(3)+"self!");
				bs.bp.stm.addStatus(s, new BonusStatBuff(2,0,1.25,s,s,50));
				break;
			case 5:
				bs.bp.bt.addScene(s.getName()+" produces a rope from "+s.getPronoun(1)+" toolbelt and looks prepared!");
				bs.bp.stm.addStatus(s, new StatBuffMult(2,5,1.25,s,s,50));
				break;
			case 6:
				bs.bp.bt.addScene(s.getName()+" produces a razor from "+s.getPronoun(1)+" toolbelt and sharpens "+s.getPronoun(1)+" weapons!");
				bs.bp.stm.addStatus(s, new BonusStatBuff(2,16,1.25,s,s,50));
				break;
			}
		}
	}
	
}
