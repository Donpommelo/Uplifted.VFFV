package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;


import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Queried;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class AutoQuery extends status{
	
	public int duration;
	public Boolean perm = false;
	public Boolean visible = false;
	public AutoQuery(Schmuck perp,int pr){
		super("Auto-Query", false, false, perp, pr);
	}
	
	public void startoffightEffect(Schmuck s, BattleState bs){
		bs.bp.bt.textList.add(s.getName()+"'s Auto Querier scans all foes!");
		for(Schmuck e : bs.bp.getSelectableEnemies(s)){
			bs.bp.bt.textList.add("A(n) "+ e.getName()+". "+ e.getCurrentHp()+"/"+e.getMaxHp()+" Hp");
			bs.bp.stm.addStatus(e, new Queried(s, 50));
		}
	}
}
