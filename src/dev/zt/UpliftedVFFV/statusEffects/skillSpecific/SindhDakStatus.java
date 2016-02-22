package dev.zt.UpliftedVFFV.statusEffects.skillSpecific;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class SindhDakStatus extends status{
	
	public static String name = "Deliverance";
	public static Boolean perm = false;
	public static Boolean visible = true;
	public static Boolean removedEnd = true;
	public static Boolean decay = false;
	
	public boolean turnused;
	
	public SindhDakStatus(int i, Schmuck perp, int pr){
		super(i, name, perm, visible, removedEnd, decay, perp, pr);
		turnused = true;
	}

	public void onActionUser(BattleState bs, Action a){
		if(a.getSkill().getTargetType() == 0 && !(a.getSkill().getName() == "Sindh Dak" && turnused)){
			bs.bp.bt.addScene(a.getUser().getName()+"'s Sindh Dak buff spreads the message!");
			for(Schmuck s : bs.bp.getSelectableAllies(a.getTarget())){
				if(s != a.getTarget()){
					a.getSkill().run(a.user, s, bs);
				}
			}
			bs.bp.stm.hardRemoveStatus(a.getUser(), this);
		}
		turnused = false;
	}
	
}
