package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class ElemPersuasion extends status{
	
	public static String name = "Elemental Persuasion";
	public static Boolean perm = false;
	public static Boolean visible = false;
	public static Boolean removedEnd = true;
	public static Boolean decay = true;
	public int elemBoost;
	public int amount;
	public ElemPersuasion(int i, int start, int amount, Schmuck perp, Schmuck vic, int pr){
		super(i, name, perm, visible, removedEnd, decay, perp, vic, pr);
		this.elemBoost = start;
		this.amount = amount;
	}
	
	public ElemPersuasion(int start, int amount, Schmuck v,int pr){
		super(name, v,pr);
		this.elemBoost = start;
		this.amount = amount;
	}
	
	public int takedamageEffect(Schmuck perp,Schmuck vic, BattleState bs, int damage, int elem){
		if(elem != 6){
			this.elemBoost = elem;
			bs.bp.bt.addScene(vic.getName()+"'s Elemental Persuasion shifts!");
		}
		return damage;
	}	
	
	public void statchanges(Schmuck s){
		s.buffedElemPoints[elemBoost]+=amount;
	}
	
	public String inflictText(Schmuck s){
		return s.getName()+"became Elementally Persuaded!";
	}

	public String cureText(Schmuck s){
		return " is no longer Elementally Persuaded!";
	}
	
	public int stackingEffect(){
		return 3;
	}
}
