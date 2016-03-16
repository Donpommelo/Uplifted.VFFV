package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.ablities.FlavorNothing;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class ElemBlock extends status{
	
	public static String name = "Elemental Block";
	public static Boolean perm = false;
	public static Boolean visible = true;
	public static Boolean removedEnd = false;
	public static Boolean decay = true;
	public int blocked;
	public ElemBlock(int i, int block, Schmuck perp, Schmuck vic, int pr){
		super(i, name, perm, visible, removedEnd, decay, perp, vic, pr);
		this.blocked = block;
	}
	
	public ElemBlock(int block, int pr){
		super(name, pr);
		this.blocked = block;
	}
	
	public void preActionUser(Schmuck s, Action a, BattleState bs){
		if(a.skill.getElement(s) == blocked){
			bs.bp.TurnOrderQueue.set(0, new Action(s,s,new FlavorNothing(0,s.getName()+" tried to use attack, but was Elementally Blocked!"),bs));
		}
	}

	public String inflictText(Schmuck s){
		String elem = "";
		switch(blocked){
		case 0:
			elem = "Red";
			break;
		case 1:
			elem = "Blue";
			break;
		case 2:
			elem = "Green";
			break;
		case 3:
			elem = "Yellow";
			break;
		case 4:
			elem = "Purple";
			break;
		case 5:
			elem = "Void";
			break;
		case 6:
			elem = "Physical";
			break;
		}
		return s.getName()+"'s " + elem +" Alignment was Blocked!";
	}

	public String cureText(Schmuck s){
		return s.getName()+" is no longer Elementally Blocked!";
	}
	
	public Boolean isBad(){
		return true;
	}
}
