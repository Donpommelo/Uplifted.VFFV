package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.ablities.FlavorNothing;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class Frozen extends status{
	
	public int duration;
	public Boolean perm = false;
	public Boolean visible = true;
	public Frozen(int i, Schmuck perp, int pr){
		super(i, "Frozen", false, true, false, perp, pr);
	}
	
	public Frozen(Schmuck perp, int pr){
		super("Frozen", true, false, perp, pr);
	}
	
	public void restrict(Schmuck s, Action a, BattleState bs){
		bs.bp.TurnOrderQueue.set(0, new Action(s,s,new FlavorNothing(0,s.getName()+" is frozen solid!"),bs));
	}
	
	public int takedamageEffect(Schmuck perp,Schmuck vic, BattleState bs, int damage, int elem){
		return 1;
	}	

	public String inflictText(Schmuck s){
		return s.getName()+" was Frozen!";
	}

	public String cureText(Schmuck s){
		return s.getName()+" unfroze!";
	}
	
	public Boolean isBad(){
		return true;
	}
}
