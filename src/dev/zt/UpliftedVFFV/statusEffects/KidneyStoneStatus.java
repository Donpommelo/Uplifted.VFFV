package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class KidneyStoneStatus extends status{
	
	public int duration;
	public Boolean perm = false;
	public Boolean visible = true;
	public int cooldown;

	public KidneyStoneStatus(Schmuck perp, int pr){
		super("Filtering", false, false, perp, pr);
	}
	
	public void startoffightEffect(Schmuck s, BattleState bs){
		cooldown = 0;
	}
	
	public void onStatusInflict(Schmuck s, status st, BattleState bs){
		if(cooldown == 0){
			if(st.getName().equals("Stunned") || st.getName().equals("Silenced") || st.getName().equals("Ablaze") || st.getName().equals("Disarmed")
			 || st.getName().equals("HealBlock") || st.getName().equals("Impatient")){
				bs.bp.bt.textList.add(s.getName()+"'s Kidney Stone removes the ailment!");
				bs.bp.stm.removeStatus(s, st);
				cooldown +=4;
			}
		}
	}
	
	public void endofturnEffect(Schmuck s, BattleState bs){
		if(cooldown >0){
			cooldown--;
		}
	}
	
	public String inflictText(Schmuck s){
		return "";

	}

	public String cureText(Schmuck s){
		return "";
	}
	
}
