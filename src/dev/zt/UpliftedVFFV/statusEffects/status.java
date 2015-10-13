package dev.zt.UpliftedVFFV.statusEffects;

import java.io.Serializable;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class status implements Serializable{
	
	private static final long serialVersionUID = -51248655534544301L;
	
/* Hej! Did you just implement a new effect? Did you remember to ...
 1: If the status is tied to a unique piece of equipment, did you implement Bonus Equip Power?
 2: Also, if that equipment is Legendary, did you remember to add the respective tag?
 3: Will the status run when its owner is incapacitated? Add runWhenDead if yes.
 4: Will the status be added to the list of grab-bag generic positive or negative statuses? GrabBagPlus and GrabBagMinus is so.
 5: Should the status be removed by generic curing items and abilities? Add an isBad method is so.
 6: Does your status have anything to do with Critical Hits? Don't forget to implement Critical Resist and Critical Multiplier.
 7: Does your status involve regenerating Hp? Implement the perpetrator's Bonus Heal Power if so.
 8: Regenerating Hp and Mp should also take into account the recipients Bonus Regeneration stat.
 9: Implement chargeBonus and cooldownBonus if these effects are applicable to the status.
 10: Is your status removed at the end of battle? (removedEnd) Can your status be removed outside of unequiping items? (perm) Will your
		status be visible in the BattleUI and also count when calculating number of statuses? (visible)
 11: Can multiple instances of your status be stacked? Or will reapplying it just increase the duration?
 12: What is your status' priority? Remember that higher priorities will be processed first.
  */
	
	
	
	public int duration = 0;
	public String name;
	public Boolean perm = false;
	public Boolean visible = true;
	public Boolean removedEnd = true;
	public int stack;
	public int priority;
	public int cooldown;
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
	
	public int getCooldown() {
		return cooldown;
	}

	public void setCooldown(int cd) {
		this.cooldown = cd;
	}

	//Activates upon selecting a move. Prolly should rename. Atm used for restricting; if certain moves are selected, they are replaced
	public void restrict(Schmuck s, Action a, BattleState bs){

	}
	
	//Activates at the end of round in stm.endofRound
	//Will not occur if owner is incapacitated unless status is marked runWhenDead or owner has Undead status.
	public void endofturnEffect(Schmuck s, BattleState bs){
	
	}
	
	//Activates right before sorting and TOQ changes
	//Will not occur if owner is incapacitated unless status is marked runWhenDead or owner has Undead status.
	public void preBattlePhase(Schmuck s, BattleState bs){
		
	}
	
	//When fight starts.
	//Will not occur if owner is incapacitated unless status is marked runWhenDead or owner has Undead status.
	public void startoffightEffect(Schmuck s, BattleState bs){//
		
	}
	
	//Executed at the end of fights before item + script calculations
	//Will not occur if owner is incapacitated unless status is marked runWhenDead or owner has Undead status.
	public void endoffightEffect(Schmuck s, BattleState bs){
		
	}
	
	//upon dealing damage from any source. 
	//Elements: 0:Red 1:Blue 2:Green 3:Yellow 4:Purple 5:Void 6:Nonaligned
	//Will not occur if owner is incapacitated unless status is marked runWhenDead or owner has Undead status.
	public int dealdamageEffect(Schmuck perp,Schmuck vic, BattleState bs, int damage, int elem){
		return damage;
	}
	
	//upon taking damage from any source. 
	//Elements: 0:Red 1:Blue 2:Green 3:Yellow 4:Purple 5:Void 6:Nonaligned
	//Will not occur if owner is incapacitated unless status is marked runWhenDead or owner has Undead status.
	public int takedamageEffect(Schmuck perp,Schmuck vic, BattleState bs, int damage, int elem){
		return damage;
	}	
	
	//upon being healed by any Schmuck. 
	//Elements: 0:Red 1:Blue 2:Green 3:Yellow 4:Purple 5:Void 6:Nonaligned
	//Will not occur if owner is incapacitated unless status is marked runWhenDead or owner has Undead status.
	public int onHealEffect(Schmuck perp,Schmuck vic, BattleState bs, int damage, int elem){
		return damage;
	}
	
	//Upon a move is used. Contrast with "restrict" which is activated before move is used.
	public void onAction(BattleState bs, Action a){
		
	}
	
	//Takes place after any action, whether ally or enemy.
	//Will not occur if owner is incapacitated unless status is marked runWhenDead or owner has Undead status.
	public void endofAnyAction(BattleState bs, Action a, Schmuck s){
		
	}
	
	//Upon incapacitating any character
	//Will not occur if owner is incapacitated unless status is marked runWhenDead or owner has Undead status.
	public void onKill(Schmuck perp, Schmuck vic, BattleState bs){
		
	}
	
	//upon being incapacitated
	//Will not occur if owner is (already) incapacitated unless status is marked runWhenDead or owner has Undead status.
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
	//Will not occur if owner is incapacitated unless status is marked runWhenDead or owner has Undead status.
	public void onStatusInflict(Schmuck s, status st, BattleState bs){
			
	}
	
	//upon dealing damage from any source. 
	//Elements: 0:Red 1:Blue 2:Green 3:Yellow 4:Purple 5:Void 6:Nonaligned
	//Will not occur if owner is incapacitated unless status is marked runWhenDead or owner has Undead status.
	public int spendMeterEffect(Schmuck s, BattleState bs, int mp){
		return mp;
	}
	
	//upon taking damage from any source. 
	//Elements: 0:Red 1:Blue 2:Green 3:Yellow 4:Purple 5:Void 6:Nonaligned
	//Will not occur if owner is incapacitated unless status is marked runWhenDead or owner has Undead status.
	public int gainMeterEffect(Schmuck s, BattleState bs, int mp){
		return mp;
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
	
	//Generic status curing stuff removes statuses if this returns true.
	public Boolean isBad(){
		return false;
	}
	
	//Stuff that gives random beneficial effects might give these if this returns true.
	public Boolean grabBagPlus(){
		return false;
	}
	
	//Stuff that gives random unbeneficial effects might give these if this returns true.
	public Boolean grabBagMinus(){
		return false;
	}
	
	public Boolean runWhenDead(){
		return false;
	}

}
