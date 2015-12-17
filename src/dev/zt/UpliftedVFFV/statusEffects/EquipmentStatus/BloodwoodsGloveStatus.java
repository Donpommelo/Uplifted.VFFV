package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class BloodwoodsGloveStatus extends status{
	
	public int duration;
	public Boolean perm = false;
	public Boolean visible = true;
	public BloodwoodsGloveStatus(int i, Schmuck perp, int pr){
		super(i, "Bloodwood's Blessing", false, true, true, perp, pr);
	}
	
	public BloodwoodsGloveStatus(Schmuck perp, int pr){
		super("Bloodwood's Blessing", true, false, perp, pr);
	}
	
	public void onStatusInflict(Schmuck s, status st, BattleState bs){
		int cost = (int)(s.getMaxHp() * 0.2);
		if(s.getCurrentHp() > cost && st.isBad()){
			bs.bp.bt.textList.add("Bloodwood's Glove cleanses "+s.getName()+" of "+s.getPronoun(1)+" status.");
			s.hpChange(-cost);
			bs.bp.stm.removeStatus(s, st);
		}
	}
	
	
	public String inflictText(Schmuck s){
		return s.getName()+"";
	}

	public String cureText(Schmuck s){
		return s.getName()+"";
	}
}
