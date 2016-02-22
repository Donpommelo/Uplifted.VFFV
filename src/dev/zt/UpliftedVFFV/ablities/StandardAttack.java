package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.Battle.BattleAnimation;
import dev.zt.UpliftedVFFV.Battle.Animations.StandardAttackAnim;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.BandagedSwordStatus;
import dev.zt.UpliftedVFFV.statusEffects.Stats.StatBuffMult;

public class StandardAttack extends Skills {

	public static String name = "Attack";
	public static String descr = "User attacks a foe.";
	public static String descrShort = "Deals damage target.";
	public static int cost = 0;
	public static int baseAcc = 100; public static int baseCrit = 0;
	public static boolean canMiss = true; public static boolean canCrit = true;
	public static int element = 6;	//Physical
	public static int targetType = 0;	//Any Single Target
	public static int maxFrames = 30;
	public static BattleAnimation ba = new StandardAttackAnim();
	public StandardAttack(int index) {
		super(index, targetType, element, name, descr, descrShort, cost, 0, baseAcc, baseCrit, canMiss, canCrit, ba);
	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){
		int damage = bs.bp.em.logScaleDamage(perp, vic);
		//Elementally Aligned units gain special standard attacks
		switch((int)(perp.getElemAlignment())){
		//physical is boring
		case 0:
			bs.bp.em.hpChange(damage, perp, vic,6);
			break;
		//Red Aligned have increased Critical Multiplier	
		case 1:
			bs.bp.em.hpChange(damage, perp, vic,0);
			break;
		//Blue Aligned reduce the Spd of targets
		case 2:
			bs.bp.em.hpChange(damage, perp, vic,1);
			bs.bp.stm.addStatus(vic, new StatBuffMult(1,4,.75,perp,50));
			break;
		//Green Aligned gain Life-Steal
		case 3:
			bs.bp.em.hpChange(damage, perp, vic,2);
			bs.bp.em.hpChange((int)(-damage*(.5+perp.getHealPower())), perp, perp,2);
			break;
		//Yellow Aligned take Initiative
		case 4:
			bs.bp.em.hpChange(damage, perp, vic,3);
			break;
		//Purple Aligned deal splash damage to other targets
		case 5:
			bs.bp.em.hpChange(damage, perp, vic,4);
			for(Schmuck s : bs.bp.getSelectableEnemies(perp)){
				if(!s.equals(vic)){
					bs.bp.em.hpChange((int)(damage * .5), perp, s,4);
				}
			}
			break;
		//Void Aligned do pure damage
		case 6:
			vic.hpChange((int)(damage *(1-vic.getVoidRes())));
			break;
		}
		
		//Activate User's Post-Action Effects
		perp.statusProcTime(11, bs, null, vic, damage, 0, true, null);
	}
	
	public void runCrit(Schmuck perp, Schmuck vic, BattleState bs){
		int damage = (int)(bs.bp.em.logScaleDamage(perp, vic)*(1.5+perp.getCritMulti()-vic.getCritRes()));
		//Elementally Aligned units gain special standard attacks
		switch((int)(perp.getElemAlignment())){
		//Physical is boring
		case 0:
			bs.bp.em.hpChange(damage, perp, vic,6);
			break;
		//Red Aligned have increased Critical Multiplier	
		case 1:
			bs.bp.em.hpChange((int)(damage*1.5), perp, vic,0);
			break;
		//Blue Aligned reduce the Sod of targets
		case 2:
			bs.bp.em.hpChange(damage, perp, vic,1);
			bs.bp.stm.addStatus(vic, new StatBuffMult(1,4,.75,perp,50));
			break;
		//Green Aligned gain Life-Steal
		case 3:
			bs.bp.em.hpChange(damage, perp, vic,2);
			bs.bp.em.hpChange((int)(-damage*(.5+perp.getHealPower())), perp, perp,2);
			break;
		//Yellow Aligned take Initiative
		case 4:
			bs.bp.em.hpChange(damage, perp, vic,3);
			break;
		//Purple Aligned deal splash damage to other targets
		case 5:
			bs.bp.em.hpChange(damage, perp, vic,4);
			for(Schmuck s : bs.bp.getSelectableEnemies(perp)){
				if(!s.equals(vic)){
					bs.bp.em.hpChange((int)(damage * .5), perp, s,4);
				}
			}
			break;
		//Void Aligned do pure damage
		case 6:
			vic.hpChange((int)(damage *(1-vic.getVoidRes())));
			break;
		}
		
		//Activate User's Post-Action Effects
		perp.statusProcTime(11, bs, null, vic, damage, 0, true, null);

	}
		
	public void TOQChange(Action a, BattleState bs){
		if(bs.bp.stm.checkStatus(a.user, new BandagedSwordStatus(50)) || a.getUser().getElemAlignment() == 4){
			bs.bp.TurnOrderQueue.remove(a);
			bs.bp.TurnOrderQueue.add(0, a);
		}
	}
		
	public int getElement(Schmuck s){
		if((int)s.getElemAlignment() == 0 ){
			return 6;
		}
		else{
			return (int)(s.getElemAlignment()-1);
		}
	}
	
	public String useName(Schmuck perp, Schmuck vic, BattleState bs){
		return 	perp.getName()+" attacks "+vic.getName()+"!";
	}
	
	public boolean silenceBlocked(){
		return false;
	}
		
}
