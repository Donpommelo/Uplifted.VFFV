package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;

import dev.zt.UpliftedVFFV.Battle.BattleAnimation;
import dev.zt.UpliftedVFFV.Battle.Animations.UseItemAnim;
import dev.zt.UpliftedVFFV.inventory.equipables.SlackerSlacks;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class SlackerSlacksStatus extends status{
	
	public static String name = "Slacking";
	public static Boolean perm = false;
	public static Boolean visible = true;
	public static Boolean removedEnd = false;
	public static Boolean decay = true;
	
	public SlackerSlacksStatus(Schmuck v,int pr){
		super(name, v,pr);
	}
	
	public void onDillyDally(Schmuck s, BattleState bs){
		BattleAnimation ba = new UseItemAnim(new SlackerSlacks(),vic);
		bs.bp.bt.addScene(s.getName()+"'s Slacker Slacks make waiting more comfortable!",ba,this,true);
//		bs.bp.em.hpChange((int)(s.getMaxHp()*.1*(1+s.getEquipPow())*(1+s.getRegenBonus())), s, s, 6);
	}
	
	public void postAnimRun(BattleState bs){
		bs.bp.em.hpChange((int)(vic.getMaxHp()*.1*(1+vic.getEquipPow())*(1+vic.getRegenBonus())), vic, vic, 6);
	}
	
}
