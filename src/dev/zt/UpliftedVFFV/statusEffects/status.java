package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class status {
	public int duration;
	public String name;
	public Boolean perm = false;
	public Boolean visible = true;
	public Boolean removedEnd = true;
	public BattleState bs;
	public int stack;
	public status(int i, String n, Boolean end){//, BattleState bs){
		this.duration=i;
		this.perm = false;
		this.name = n;
		this.removedEnd = end;
//		this.bs = bs;
	}
	
/*	public status(String n, BattleState bs){
		this.perm=true;
		this.name = n;
		this.removedEnd=false;
		this.bs =bs;
	}*/
	
	public status(String n){
		this.perm=true;
		this.name = n;
		this.removedEnd=false;
	}
	
	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}


	
	//Activates upon selecting a move. Prolly should rename. Atm used for restricting; if certain moves are selected, they are replaced
	public void restrict(Schmuck s, Action a, BattleState bs){

	}
	
	
	public void endofturnEffect(Schmuck s, BattleState bs){
	
	}
	
	//When fight starts.
	public void startoffightEffect(Schmuck s, BattleState bs){//
		
	}
	
	//Executed at the end of fights befoe item + script calculations
	public void endoffightEffect(Schmuck s, BattleState bs){
		
	}
	
	//upon taking damage from any source. Source is NOT possible to identify.
	public void takedamageEffect(Schmuck s, BattleState bs, int damage){//
		
	}	
	
	//Upon a move is used. Contrast with "restrict" which is activated before move is used.
	public void onAction(BattleState bs, Action a){
		
	}
	
	//Upon standard attack is used
	public void attackModify(Schmuck perp,Schmuck vic, BattleState bs, int damage){
		
	}
	
	
	
	
	public void run(Schmuck s){
		
	}
	
	public void statchanges(Schmuck s){
//		System.out.println(s.buffedStats[3]);
	}
	
	public String inflictText(Schmuck s){
		return "";
	}

	public String cureText(Schmuck s){
		return "";
	}
	
	public String getName(){
		return name;
	}

}
