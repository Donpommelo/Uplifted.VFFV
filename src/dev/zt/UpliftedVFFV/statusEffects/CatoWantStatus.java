package dev.zt.UpliftedVFFV.statusEffects;


import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;


public class CatoWantStatus extends status{
	
	public int duration;
	public Boolean perm = false;
	public Boolean visible = true;
	public CatoWantStatus(int i, Schmuck perp){
		super(i, "Wanting", false, false, true, perp);
	}
	
	public CatoWantStatus(Schmuck perp, int pr){
		super("Wanting", false, false, perp,pr);
	}
	
	public void restrict(Schmuck s, Action a, BattleState bs){
		int overkill = s.getCurrentBp() - (int)(a.skill.getCost()*(1+a.user.getMpCost()));
		if(overkill <= 0){
			if(s.getCurrentHp() >= -(overkill*2+5)){
				bs.bp.bt.textList.add(s.getName()+" doesn't have the Motivation to cast "+a.getSkill().getName()+"!");
				bs.bp.bt.textList.add(s.getName()+" casts it anyways using Catalogue of Want!");
				bs.bp.em.hpChange((int)(overkill*2-5),s.itemDummy,s);
				s.setCurrentBp((int)(a.skill.getCost()*(1+a.user.getMpCost())));
			}
		}
	}
		
	public String inflictText(Schmuck s){
		return s.getName()+" looks wanting!";

	}

	public String cureText(Schmuck s){
		return s.getName()+" looks normal again.";
	}
	
	public int getDuration(){
		return duration;
	}

}
