package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class PennyBlackStatus extends status{
	
	public int duration;
	public Boolean perm = false;
	public Boolean visible = true;
//	public BattleState bs;
	public PennyBlackStatus(int i){
		super(i, "Penny Black", true);
//		this.bs = bs;
	}
	
	public void attackModify(Schmuck perp,Schmuck vic, BattleState bs, int damage){
		bs.bp.bt.textList.add(perp.getName()+"'s Penny Black sucks away some of "+vic.getName()+"'s soul");
		bs.bp.em.hpChange(-vic.getMaxHp()/10,vic,5);
	}

	public String inflictText(Schmuck s){
		return s.getName()+" became infused with Void energy.";

	}

	public String cureText(Schmuck s){
		return s.getName()+"'s Void energy wore off.";
	}
	
	public int getDuration(){
		return duration;
	}

}
