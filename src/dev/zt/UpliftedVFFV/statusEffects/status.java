package dev.zt.UpliftedVFFV.statusEffects;

import java.io.Serializable;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class status implements Serializable{
	
	private static final long serialVersionUID = -51248655534544301L;
	
	public int duration = 0;
	public String name;
	public Boolean perm = false;
	public Boolean visible = true;
	public Boolean removedEnd = true;
	public int stack;
	public int priority;
	public Schmuck perp;	
	public status(int i, String n, Boolean perm, Boolean vis, Boolean end, Schmuck p, int pr){
		this.duration=i;
		this.name = n;
		this.perm = perm;
		this.visible = vis;
		this.removedEnd = end;
		this.perp = p;
		this.priority = pr;
	}
	
	public status(String n, Boolean vis, Boolean end, Schmuck p, int pr){
		this.name = n;
		this.perm = true;
		this.visible = vis;
		this.removedEnd = end;
		this.perp = p;
		this.priority = pr;
	}
	
	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}
		
	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	//Activates upon selecting a move. Prolly should rename. Atm used for restricting; if certain moves are selected, they are replaced
	public void restrict(Schmuck s, Action a, BattleState bs){

	}
	
	//Activates at the end of round in stm.endofRound
	public void endofturnEffect(Schmuck s, BattleState bs){
	
	}
	
	//Activates right before sorting and TOQ changes
	public void preBattlePhase(Schmuck s, BattleState bs){
		
	}
	
	//When fight starts.
	public void startoffightEffect(Schmuck s, BattleState bs){//
		
	}
	
	//Executed at the end of fights befoe item + script calculations
	public void endoffightEffect(Schmuck s, BattleState bs){
		
	}
	
	//upon dealing damage from any source. 
	//Elements: 0:Red 1:Blue 2:Green 3:Yellow 4:Purple 5:Void 6:Nonaligned
	public int dealdamageEffect(Schmuck perp,Schmuck vic, BattleState bs, int damage, int elem){
		return damage;
	}
	
	//upon taking damage from any source. 
	//Elements: 0:Red 1:Blue 2:Green 3:Yellow 4:Purple 5:Void 6:Nonaligned
	public int takedamageEffect(Schmuck perp,Schmuck vic, BattleState bs, int damage, int elem){
		return damage;
	}	
	
	//upon being healed by any Schmuck. 
	//Elements: 0:Red 1:Blue 2:Green 3:Yellow 4:Purple 5:Void 6:Nonaligned
	public int onHealEffect(Schmuck perp,Schmuck vic, BattleState bs, int damage, int elem){
		return damage;
	}
	
	//Upon a move is used. Contrast with "restrict" which is activated before move is used.
	public void onAction(BattleState bs, Action a){
		
	}
	
	//Takes place after any action, whether ally or enemy.
	public void endofAnyAction(BattleState bs, Action a, Schmuck s){
		
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
	//Upon any action critting
	public void onCrit(Schmuck perp,Schmuck vic, BattleState bs){
		
	}
	
	//Upon any action missing
	public void onMiss(Action a, BattleState bs){
		
	}
	
	//When calcStats is called. This includes all passive changes to any Schmuck's stat	
	public void statchanges(Schmuck s){

	}
	
	//Occurs right before a character makes a delayed move
	public void onDillyDally(Schmuck s, BattleState bs){
		
	}
	
	//Occurs after status is inflicted
	public void onStatusInflict(Schmuck s, status st, BattleState bs){
			
	}
	

	//not currently used
	public void run(Schmuck s){
		
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
