package dev.zt.UpliftedVFFV.statusEffects.skillSpecific;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class PennyBlackStatus extends status{
	
	public static String name = "Penny Black";
	public static Boolean perm = false;
	public static Boolean visible = true;
	public static Boolean removedEnd = true;
	public static Boolean decay = true;
	public PennyBlackStatus(int i, Schmuck perp, int pr){
		super(i, name, perm, visible, removedEnd, decay, perp, pr);
	}
	
	public void attackModify(Schmuck perp,Schmuck vic, BattleState bs, int damage){
		bs.bp.bt.addScene(perp.getName()+"'s Penny Black sucks away some of "+vic.getName()+"'s soul");
		bs.bp.em.hpChange(-vic.getMaxHp()/10,perp, vic,5);
	}

	public String inflictText(Schmuck s){
		return s.getName()+" became infused with Void energy.";
	}

	public String cureText(Schmuck s){
		return s.getName()+"'s Void energy wore off.";
	}
	
	public int stackingEffect(){
		return 3;
	}
}
