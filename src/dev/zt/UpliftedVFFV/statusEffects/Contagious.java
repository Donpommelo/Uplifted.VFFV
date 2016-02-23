package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class Contagious extends status{
	
	public static String name = "Contagion";
	public static Boolean perm = false;
	public static Boolean visible = true;
	public static Boolean removedEnd = true;
	public static Boolean decay = true;	
	public Contagious(int i, Schmuck perp, int pr){
		super(i, name, perm, visible, removedEnd, decay, perp, pr);
	}
	
	public Contagious(int pr){
		super(name, pr);
	}	
		
	public void onStatusInflict(Schmuck s, status st, BattleState bs){
		for(Schmuck ally : bs.bp.getSelectableAllies(s)){
			if(!bs.bp.stm.checkStatus(ally, st) && st.name != "Contagion" && s != ally){
				bs.bp.bt.addScene(s.getName()+"'s Contagion spreads to "+ally.getName()+"!");
				bs.bp.stm.addStatus(ally, st);
			}
		}
	}
	
	public String inflictText(Schmuck s){
		return s.getName()+" became Contagious.";
	}

	public String cureText(Schmuck s){
		return s.getName()+" is no longer Contagious.";
	}
}
