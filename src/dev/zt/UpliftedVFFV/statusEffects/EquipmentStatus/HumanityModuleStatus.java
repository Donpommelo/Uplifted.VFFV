package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;


import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Queried;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.Stats.BonusStatBuff;
import dev.zt.UpliftedVFFV.statusEffects.Stats.StatBuffMult;

public class HumanityModuleStatus extends status{
	
	public HumanityModuleStatus(int pr){
		super("Humane", pr);
	}
	
	public void endoffightEffect(Schmuck s, BattleState bs){
		if(s.getCurrentBp() >= (int)(s.getMaxBp()*.1)){
			bs.bp.em.bpChange(-(int)(s.getMaxBp()*.1), s);
			bs.bp.bt.addScene(s.getName()+"'s Humanity Module activates!");
			for(int i = 0; i < 3; i++){
				int rand = (int)(Math.random()*34);
				switch(rand){
				case 0:
					bs.bp.stm.addStatus(s, new StatBuffMult(20,0,1.1,s,50));
					break;
				case 1:
					bs.bp.stm.addStatus(s, new StatBuffMult(20,1,1.1,s,50));
					break;
				case 2:
					bs.bp.stm.addStatus(s, new StatBuffMult(20,2,1.1,s,50));
					break;
				case 3:
					bs.bp.stm.addStatus(s, new StatBuffMult(20,3,1.1,s,50));
					break;
				case 4:
					bs.bp.stm.addStatus(s, new StatBuffMult(20,4,1.1,s,50));
					break;
				case 5:
					bs.bp.stm.addStatus(s, new StatBuffMult(20,5,1.1,s,50));
					break;
				case 6:
					bs.bp.stm.addStatus(s, new StatBuffMult(20,6,1.1,s,50));
					break;
				case 7:
					bs.bp.stm.addStatus(s, new StatBuffMult(20,7,1.1,s,50));
					break;
				case 8:
					bs.bp.stm.addStatus(s, new BonusStatBuff(20,0,0.1,s,50));
					break;
				case 9:
					bs.bp.stm.addStatus(s, new BonusStatBuff(20,1,0.1,s,50));
					break;
				case 10:
					bs.bp.stm.addStatus(s, new BonusStatBuff(20,2,0.1,s,50));
					break;
				case 11:
					bs.bp.stm.addStatus(s, new BonusStatBuff(20,3,0.1,s,50));
					break;
				case 12:
					bs.bp.stm.addStatus(s, new BonusStatBuff(20,4,0.1,s,50));
					break;
				case 13:
					bs.bp.stm.addStatus(s, new BonusStatBuff(20,9,0.1,s,50));
					break;
				case 14:
					bs.bp.stm.addStatus(s, new BonusStatBuff(20,10,0.1,s,50));
					break;
				case 15:
					bs.bp.stm.addStatus(s, new BonusStatBuff(20,11,0.1,s,50));
					break;
				case 16:
					bs.bp.stm.addStatus(s, new BonusStatBuff(20,13,0.1,s,50));
					break;
				case 17:
					bs.bp.stm.addStatus(s, new BonusStatBuff(20,14,0.1,s,50));
					break;
				case 18:
					bs.bp.stm.addStatus(s, new BonusStatBuff(20,15,0.1,s,50));
					break;
				case 19:
					bs.bp.stm.addStatus(s, new BonusStatBuff(20,16,0.1,s,50));
					break;
				case 20:
					bs.bp.stm.addStatus(s, new BonusStatBuff(20,17,0.1,s,50));
					break;
				case 21:
					bs.bp.stm.addStatus(s, new BonusStatBuff(20,18,0.1,s,50));
					break;
				case 22:
					bs.bp.stm.addStatus(s, new BonusStatBuff(20,19,0.1,s,50));
					break;
				case 23:
					bs.bp.stm.addStatus(s, new BonusStatBuff(20,20,0.1,s,50));
					break;
				case 24:
					bs.bp.stm.addStatus(s, new BonusStatBuff(20,21,0.1,s,50));
					break;
				case 25:
					bs.bp.stm.addStatus(s, new BonusStatBuff(20,22,0.1,s,50));
					break;
				case 26:
					bs.bp.stm.addStatus(s, new BonusStatBuff(20,23,0.1,s,50));
					break;
				case 27:
					bs.bp.stm.addStatus(s, new BonusStatBuff(20,24,0.1,s,50));
					break;
				case 28:
					bs.bp.stm.addStatus(s, new BonusStatBuff(20,25,0.1,s,50));
					break;
				case 29:
					bs.bp.stm.addStatus(s, new BonusStatBuff(20,28,0.1,s,50));
					break;
				case 30:
					bs.bp.stm.addStatus(s, new BonusStatBuff(20,29,0.1,s,50));
					break;
				case 31:
					bs.bp.stm.addStatus(s, new BonusStatBuff(20,32,0.1,s,50));
					break;
				case 32:
					bs.bp.stm.addStatus(s, new BonusStatBuff(20,34,5,s,50));
					break;
				case 33:
					bs.bp.stm.addStatus(s, new BonusStatBuff(20,35,5,s,50));
					break;
				}
			}
		}
		else{
			bs.bp.bt.addScene(s.getName()+"'s Humanity Module requires more Energy to operate!");
		}
	}
}
