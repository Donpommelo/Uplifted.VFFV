package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Blind;
import dev.zt.UpliftedVFFV.statusEffects.CoolingDown;
import dev.zt.UpliftedVFFV.statusEffects.Stunned;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class CannonHandStatus extends status{
	
	public static String name = "Cannon: Hand";
	public static Boolean perm = false;
	public static Boolean visible = false;
	public static Boolean removedEnd = false;
	public static Boolean decay = false;
	
	public CannonHandStatus(int pr){
		super(name, pr);
	}
	
	public void onDillyDally(Schmuck s, BattleState bs){
		if(!bs.bp.stm.checkStatus(s, new CoolingDown(0,s,50)) || bs.bp.stm.checkStatus(s, new CrawlingFortressStatus(50))){
			bs.bp.bt.addScene(s.getName()+" fires "+s.getPronoun(1)+" Hand Cannon!");
			for(Schmuck foe : bs.bp.getSelectableEnemies(s)){
				int damage = (int)(bs.bp.em.logScaleDamage(s, foe) / bs.bp.getSelectableEnemies(s).size()*(1 + s.getEquipPow()));
				bs.bp.em.hpChange(damage, s, foe,6);
			}
			bs.bp.stm.addStatus(s, new CoolingDown(3, s, 50));
		}
	}
	
}
