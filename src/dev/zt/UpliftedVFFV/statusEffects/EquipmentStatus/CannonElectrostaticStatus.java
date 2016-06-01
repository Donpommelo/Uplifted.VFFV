package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Blind;
import dev.zt.UpliftedVFFV.statusEffects.CoolingDown;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class CannonElectrostaticStatus extends status{
	
	public static String name = "Cannon: Cationic";
	public static Boolean perm = false;
	public static Boolean visible = false;
	public static Boolean removedEnd = false;
	public static Boolean decay = false;
	
	public CannonElectrostaticStatus(Schmuck v,int pr){
		super(name, v,pr);
	}
	
	public void onDillyDally(Schmuck s, BattleState bs){
		if(!bs.bp.stm.checkStatus(s, new CoolingDown(0,s,s,50)) || bs.bp.stm.checkStatus(s, new CrawlingFortressStatus(s,50))){
			bs.bp.bt.addScene(s.getName()+" fires "+s.getPronoun(1)+" Cationic Cannon!");
			for(Schmuck foe : bs.bp.getSelectableEnemies(s)){
				int damage = (int)(bs.bp.em.logScaleDamage(s, foe) / bs.bp.getSelectableEnemies(s).size()*(1 + s.getEquipPow()));
				bs.bp.em.hpChange(damage, s, foe,6);
				bs.bp.stm.addStatus(foe, new Blind(1, s,foe,50));
			}
			bs.bp.stm.addStatus(s, new CoolingDown(5, s, s,50));
		}
	}
	
}
