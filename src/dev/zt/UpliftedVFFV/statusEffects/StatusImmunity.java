package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class StatusImmunity extends status{
	
	public int duration;
	public Boolean perm = false;
	public Boolean visible = true;
	public status immune;
	public StatusImmunity(int i, status imm, Schmuck perp, int pr){
		super(i, "Status Immunity", false, true, true, perp, pr);
		this.immune = imm;
	}
	
	public StatusImmunity(status imm, Schmuck perp, int pr){
		super("Status Immunity", true, false, perp, pr);
		this.immune = imm;
	}
	

	public void onStatusInflict(Schmuck s, status st, BattleState bs){
		if(!st.perm && st.getName().equals(this.immune.getName())){
			bs.bp.stm.removeStatus(s, st);
			bs.bp.bt.textList.add(s.getName()+"'s Immunity to "+st.getName()+" removed the status!");
		}
	}
	
	public String inflictText(Schmuck s){
		return s.getName()+" became Immune to "+this.immune.getName();
	}

	public String cureText(Schmuck s){
		return s.getName()+" is no longer Immune to "+this.immune.getName();
	}
	
	
}
