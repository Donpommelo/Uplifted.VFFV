package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class EmpathyLinkStatus extends status{
	
	public int duration;
	public Boolean perm = false;
	public Boolean visible = true;
	public EmpathyLinkStatus(int i, Schmuck perp, int pr){
		super(i, "Empathy", false, false, true, perp, pr);
	}
	
	public EmpathyLinkStatus(Schmuck perp, int pr){
		super("Empathy", false, false, perp,pr);
	}
	
	public void endofturnEffect(Schmuck s, BattleState bs){
		bs.bp.bt.textList.add(s.getName()+"'s Empathy Link equalizes the Hp of living allies!");
		int totalHp = 0;
		for(Schmuck e : bs.bp.getSelectableAllies(s)){
			totalHp += e.getCurrentHp();
		}
		for(Schmuck e : bs.bp.getSelectableAllies(s)){
			e.hpChange(totalHp/bs.bp.getSelectableAllies(s).size()-e.getCurrentHp());
		}
	}
	
	public String inflictText(Schmuck s){
		return s.getName()+" became Empathetic!";
	}

	public String cureText(Schmuck s){
		return s.getName()+" is not longer Empathetic.";
	}
}
