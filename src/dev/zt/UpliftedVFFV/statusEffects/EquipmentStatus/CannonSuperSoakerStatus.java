package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Blind;
import dev.zt.UpliftedVFFV.statusEffects.CoolingDown;
import dev.zt.UpliftedVFFV.statusEffects.Stunned;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class CannonSuperSoakerStatus extends status{
	
	public static String name = "Cannon: Super Soaker";
	public static Boolean perm = false;
	public static Boolean visible = false;
	public static Boolean removedEnd = false;
	public static Boolean decay = false;
	
	public CannonSuperSoakerStatus(Schmuck v,int pr){
		super(name, v,pr);
	}
	
	public void onDillyDally(Schmuck s, BattleState bs){
		if(!bs.bp.stm.checkStatus(s, new CoolingDown(0,s,s,50)) || bs.bp.stm.checkStatus(s, new CrawlingFortressStatus(s,50))){
			bs.bp.bt.addScene(s.getName()+" fires "+s.getPronoun(1)+" Super Soaker!");
			for(Schmuck foe : bs.bp.getSelectableEnemies(s)){
				int damage = (int)(bs.bp.em.logScaleDamage(s, foe) / bs.bp.getSelectableEnemies(s).size()*(1 + s.getEquipPow()));
				bs.bp.em.hpChange(damage, s, foe,1);
			}
			bs.bp.stm.addStatus(s, new CoolingDown(3, s,s, 50));
		}
	}
	
}
