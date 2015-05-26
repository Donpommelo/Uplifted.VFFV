package dev.zt.UpliftedVFFV.inventory;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class FishWater extends Item{
	
	static String descr="Water from the Fourth Floor Aquarium. It smells fishy.";
	static String descrShort="Damage target.";
	public FishWater() {
		super(2, "Fish Water",false, true, true, true, false,descr);

	}
	
	public String useText(Schmuck perp, Schmuck vic){
		return perp.getName()+" throws the Fishwater at "+vic.getName();
	}
	
	public String resultText(Schmuck perp, Schmuck vic){
		return vic.getName()+" looks grossed out.";
	}
	
	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		if(perp.getName().equals(vic.getName())){
			bs.bp.bt.textList.add(perp.getName()+" throws the Fishwater at "+vic.getName());
		}
		bs.bp.em.hpChange(-22,vic);
	}
	
	public boolean startTeamTarget(){
		return false;
	}
	
	public String getDescrShort() {
		return descrShort;
	}
}
