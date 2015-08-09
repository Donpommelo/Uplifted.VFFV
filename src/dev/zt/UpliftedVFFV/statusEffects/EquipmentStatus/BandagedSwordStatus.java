package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class BandagedSwordStatus extends status{
	
	
	public int stack;
	public BattleState bs;
	public BandagedSwordStatus(int i, Schmuck perp, int pr){
		super(i,"Kodak", false, true, true, perp, pr);
	}
	
	public BandagedSwordStatus(Schmuck perp, int pr){
		super("Bandanged Sword Status", false, false, perp, pr);
	}	
		
	public String inflictText(Schmuck s){
		return "kodakodakodakodak";
	}

	public String cureText(Schmuck s){
		return "kodakodakodakodak";
	}
}
