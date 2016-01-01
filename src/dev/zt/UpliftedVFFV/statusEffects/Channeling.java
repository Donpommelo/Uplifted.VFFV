package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.ablities.FlavorNothing;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class Channeling extends status{
	
	public int damageThreshold;
	public int duration;
	public status Status;
	public boolean activateonBreak;
	public boolean endofround;
	public Schmuck Channeler;
	public static String name = "Channeling";
	public static Boolean perm = true;
	public static Boolean visible = false;
	public static Boolean removedEnd = true;
	public static Boolean decay = false;
	public Channeling(int dt, int du, status st, boolean aob, boolean eor,Schmuck perp, Schmuck channeler, int pr){
		super(1, name, perm, visible, removedEnd, decay, perp, pr);
		this.damageThreshold = dt;
		this.duration = du;
		this.Status = st;
		this.activateonBreak = aob;
		this.endofround = eor;
		this.Channeler = channeler;
	}
	
	public void restrict(Schmuck s, Action a, BattleState bs){
		bs.bp.TurnOrderQueue.set(0, new Action(s,s,new FlavorNothing(0,s.getName()+" is too busy Channeling to perfor other actions!"),bs));
	}
	
	public void endofturnEffect(Schmuck s, BattleState bs){
		if(endofround){
			Status.doneChanneling(s, bs);
			bs.bp.stm.hardRemoveStatus(s, this);
			bs.bp.stm.hardRemoveStatus(s, Status);
		}
	}

	public int takedamageEffect(Schmuck perp,Schmuck vic, BattleState bs, int damage, int elem){
		damageThreshold-=damage*(1-vic.getChannelBonus());
		if(damageThreshold <=0){
			bs.bp.bt.textList.add(vic.getName()+"'s Channeling was interrupted!");
			bs.bp.stm.hardRemoveStatus(vic, this);
			bs.bp.stm.hardRemoveStatus(vic, Status);
			if(activateonBreak){
				Status.doneChanneling(vic, bs);
			}
		}
		return damage;
	}	
	
	public void endofAnyAction(BattleState bs, Action a, Schmuck s){
		duration--;
		if(duration <= 0){
			bs.bp.bt.textList.add(Channeler.getName()+" completes "+s.getPronoun(1)+" Channeling!");
			Status.doneChanneling(Channeler, bs);
			bs.bp.stm.hardRemoveStatus(Channeler, this);
			bs.bp.stm.hardRemoveStatus(Channeler, Status);
		}
	}

	
	public String inflictText(Schmuck s){
		return s.getName()+" is Channeling something!";
	}

	public String cureText(Schmuck s){
		return s.getName()+"'s Channeling finishes!";
	}
	
	public int stackingEffect(){
		return 3;
	}
}
