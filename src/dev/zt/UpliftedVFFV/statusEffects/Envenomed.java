package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.inventory.EnvenomEarth;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class Envenomed extends status{
	
	public int duration;
	public double percent;
	public Boolean perm = false;
	public Boolean visible = true;
	public EnvenomEarth e;

	public Envenomed(double percent, Schmuck perp, EnvenomEarth e, int pr){
		super("Envenomed", false, false, perp, pr);
		this.percent = percent;
		this.e = e;
	}
	
	public void startoffightEffect(Schmuck s, BattleState bs){
		bs.bp.bt.textList.add(s.getName()+" was poisoned by Envenomed Earth!");
		bs.bp.stm.addStatus(s, new Regendegen(5, true, -(int)(s.getMaxHp()*percent),s.getItemDummy()));
		
	}
	
	public void endoffightEffect(Schmuck s, BattleState bs){
		if(e.getPoints() <50){
			e.setPoints(e.getPoints()+1);
			s.calcBuffs(bs);
		}
	}
	
	public void statchanges(Schmuck s){
		s.buffedStats[3]+=(int)(e.getPoints()/5);
	}
	
	public String inflictText(Schmuck s){
		return s.getName()+" became envenomed!";

	}

	public String cureText(Schmuck s){
		return s.getName()+" is not longer envenomed.";
	}
	
	public int getDuration(){
		return duration;
	}

}
