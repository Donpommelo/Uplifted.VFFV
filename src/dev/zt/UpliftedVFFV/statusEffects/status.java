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
	public Schmuck perp;
	public status(int i, String n, Boolean perm, Boolean vis, Boolean end, Schmuck p){
		this.duration=i;
		this.perm = false;
		this.name = n;
		this.perm = perm;
		this.visible = vis;
		this.removedEnd = end;
		this.perp = p;
	}
	
	public status(String n, Boolean vis, Boolean end, Schmuck p){
		this.name = n;
		this.perm = true;
		this.visible = vis;
		this.removedEnd = end;
		this.perp = p;
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
	
	//upon taking damage from any source. 
	public void takedamageEffect(Schmuck perp,Schmuck vic, BattleState bs, int damage){
		
	}	
	
	//Upon a move is used. Contrast with "restrict" which is activated before move is used.
	public void onAction(BattleState bs, Action a){
		
	}
	
	//Upon incapacitating any character
	public void onKill(Schmuck perp, Schmuck vic, BattleState bs){
		
	}
	
	//upon being incapacitated
	public void onDeath(Schmuck perp, Schmuck vic, BattleState bs){
		
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
