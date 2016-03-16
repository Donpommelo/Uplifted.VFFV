package dev.zt.UpliftedVFFV.statusEffects;

import java.io.Serializable;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.Battle.BattleAnimation;
import dev.zt.UpliftedVFFV.Battle.Animations.DefaultStatusAnim;
import dev.zt.UpliftedVFFV.ablities.Skills;
import dev.zt.UpliftedVFFV.ablities.StandardAttack;
import dev.zt.UpliftedVFFV.inventory.Item;
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
 13: Does your status proc right before an action? (PreActionUser or Target)? If so, DO NOT MAKE IT REMOVE THE
 		ACTION FROM THE TOQ. Replace it instead.
 14: Does your status proc onDamageTaken, onDamageDealt, onHeal, onStatus, onMpGain/lose? Remember that these proc
 		at any time. Make sure they do not proc each other potentially infinitely. That would be bad.
  */
	
	
	
	public int duration = 0;			//The amount of turns of the status remaining
	public String name;					//The name of the status
	public Boolean perm = false;		//Whether the status is purgeable by generic status removal.
	public Boolean visible = true;		//Whether the status is visible in the UI
	public Boolean removedEnd = true;	//Whether the status is removed at the end of combat.
	public Boolean decay = true;		//Whether the status's duration decreases at the end of each round.
	public int extraVar1;					//For stackable statuses
	public int priority;				//Status priority. Higher priority statuses have their effects applied first.
	public Schmuck perp, vic;			//Schmuck who inflicted this status, Schmuck afflicted
	
	public BattleAnimation ba;			//Animation played when this status is inflicted.
		
	public status(int i, String n, Boolean perm, Boolean vis, Boolean end, Boolean dec, Schmuck p, Schmuck v, int pr){
		this.duration=i;
		this.name = n;
		this.perm = perm;
		this.visible = vis;
		this.removedEnd = end;
		this.decay = dec;
		this.perp = p;
		this.vic = v;
		this.priority = pr;
		this.extraVar1 = 1;
	}
	
	public status(int i, String n, Boolean perm, Boolean vis, Boolean end, Boolean dec, Schmuck p, Schmuck v, int pr, BattleAnimation ba){
		this.duration=i;
		this.name = n;
		this.perm = perm;
		this.visible = vis;
		this.removedEnd = end;
		this.decay = dec;
		this.perp = p;
		this.vic = v;
		this.priority = pr;
		this.extraVar1 = 1;
		this.ba = ba;
	}
	
	//For creating Equipment Statuses
	public status(String n, int pr){
		this.name = n;
		this.priority = pr;
		this.duration = 1;
		this.perm = true;
		this.visible = false;
		this.removedEnd = false;
		this.decay = false;
		this.extraVar1 = 1;
		this.perp = new Schmuck();
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
	
	public BattleAnimation getBa(Schmuck s) {
		return new DefaultStatusAnim(this,s);
	}
	
	public Schmuck getVic() {
		return vic;
	}

	public void setVic(Schmuck vic) {
		this.vic = vic;
	}

	//Activates upon selecting a move. Atm used for restricting; if certain moves are selected, they are replaced
	//Implemented in Phase 2 of Battle Processor
	//GOOD: REPLACING/ADDING ACTIONS, CHANGING TARGETS.
	//BAD: DOING DAMAGE. DO NOT DO ANYTHING THAT WOULD REMOVE ACTION a FROM THE TOQ
	public void preActionUser(Schmuck s, Action a, BattleState bs){

	}
	
	public void preActionTarget(Schmuck s, Action a, BattleState bs){

	}
	
	//Activates at the end of round in stm.endofRound
	//Implements in endOfRound function in Status Manager.
	public void endofturnEffect(Schmuck s, BattleState bs){
	
	}
	
	//Activates right before sorting and TOQ changes
	//Implemented in Phase 1 of Battle Processor
	public void preBattlePhase(Schmuck s, BattleState bs){
		
	}
	
	//When fight starts.
	//Implemented in Phase 0 of Battle Processor
	public void startoffightEffect(Schmuck s, BattleState bs){//
		
	}
	
	//Executed at the end of fights before item + script calculations
	//Implements in endOfFight function in Status Manager.
	public void endoffightEffect(Schmuck s, Boolean won, BattleState bs){
		
	}
	
	//upon dealing damage from any source. 
	//Elements: 0:Red 1:Blue 2:Green 3:Yellow 4:Purple 5:Void 6:Nonaligned
	//Implemented in hpChange function in EffectManager
	public int dealdamageEffect(Schmuck perp,Schmuck vic, BattleState bs, int damage, int elem){
		return damage;
	}
	
	//upon taking damage from any source. 
	//Elements: 0:Red 1:Blue 2:Green 3:Yellow 4:Purple 5:Void 6:Nonaligned
	//Implemented in hpChange function in EffectManager
	public int takedamageEffect(Schmuck perp,Schmuck vic, BattleState bs, int damage, int elem){
		return damage;
	}	
	
	//upon healing/being healed by any Schmuck. 
	//Elements: 0:Red 1:Blue 2:Green 3:Yellow 4:Purple 5:Void 6:Nonaligned
	//Implemented in hpChange function in EffectManager
	
	public int onHealUserEffect(Schmuck perp,Schmuck vic, BattleState bs, int damage, int elem){
		return damage;
	}
	
	public int onHealTargetEffect(Schmuck perp,Schmuck vic, BattleState bs, int damage, int elem){
		return damage;
	}
	
	//Upon a move is used. Contrast with "restrict" which is activated before move is used.
	//Implemented in Phase 2 of Battle Processor
	public void onActionUser(BattleState bs, Action a){
		
	}
	
	public void onActionTarget(BattleState bs, Action a){
		
	}
	
	//Takes place after any action, whether ally or enemy.
	//Implemented in Phase 2 of Battle Processor
	public void endofAnyAction(BattleState bs, Action a, Schmuck s){
		
	}
	
	//Upon incapacitating any character
	//Implemented in hpChange function in EffectManager
	public void onKill(Schmuck perp, Schmuck vic, BattleState bs){
		
	}
	
	//upon being incapacitated
	//Implemented in hpChange function in EffectManager
	public void onDeath(Schmuck perp, Schmuck vic, BattleState bs){
		
	}
	
	//Upon standard attack is used 
	//Implemented in run and runCrit methods of StandardAttack
	public void attackModify(Schmuck perp,Schmuck vic, BattleState bs, int damage){
		
	}
	
	//Upon any action critting
	//Implemented in Phase 2 of Battle Processor
	public void onCrit(Schmuck perp,Schmuck vic, Action a, BattleState bs){
		
	}
	
	//Upon any action missing
	//Implemented in Phase 2 of Battle Processor
	public void onMiss(Schmuck s, Action a, BattleState bs){
		
	}
	
	//When calcStats is called. This includes all passive changes to any Schmuck's stat
	//Implemented in calcStats function of Schmucks which is called after every action in the Battle Processor, equiping/unequiping
	// and at the end of fights.
	public void statchanges(Schmuck s){

	}
	
	//Occurs right before a character makes a delayed move
	//Implemented upon initializing a battleMenu
	public void onDillyDally(Schmuck s, BattleState bs){
		
	}
	
	//Occurs after status is inflicted
	//Implemented in the addStatus function of the StatusManager
	public void onStatusInflict(Schmuck s, status st, BattleState bs){
			
	}
	
	//upon dealing damage from any source. 
	//Elements: 0:Red 1:Blue 2:Green 3:Yellow 4:Purple 5:Void 6:Nonaligned
	//Implemented in the bpChange method of the EffectManager
	public int spendMeterEffect(Schmuck s, BattleState bs, int mp){
		return mp;
	}
	
	//upon taking damage from any source. 
	//Elements: 0:Red 1:Blue 2:Green 3:Yellow 4:Purple 5:Void 6:Nonaligned
	//Implemented in the bpChange method of the EffectManager
	public int gainMeterEffect(Schmuck s, BattleState bs, int mp){
		return mp;
	}	
	
	//Upon completing the channeling of any channeling move.
	//Implemented in the Channeling Status
	public void doneChanneling(Schmuck s, BattleState bs){
		
	}
	//At end of battle when gaining script
	//Not too much stuff uses this.
	public int onLootScript(Schmuck s, BattleState bs, int script){
		return script;
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
	
	//What will happen if you gain this status while already having a status with the same name?
	//0: Nothing happens. (Most statuses)
	//1: The duration of the status is increased. (Poison)
	//2: You gain a new instance of the status. (Stat changes, Status Immunity, etc)
	//3: The new status replaces the old one. (Statuses with some numeric modifier like Vampirism or Damage Reflect)
	//4: Both statuses are removed. (Misaligned)
	//5: The status' stack variable increases by 1 (Intrusive Thought)
	public int stackingEffect(){
		return 0;
	}
	
	//Generic status curing stuff removes statuses if this returns true.
	public Boolean isBad(){
		return false;
	}
	
	//This might stop channeling and do other stuff i dunno.
	public Boolean isDisable(){
		return false;
	}
			
	//Does this status run if its owner is incapacitated?
	public Boolean runWhenDead(){
		return false;
	}
	
	//For use with Limited Use stuff
	public Skills getMove(){
		return new StandardAttack(0);
	}

	public int getExtraVar1() {
		return this.extraVar1;
	}

	public void setExtraVar1(int extraVar1) {
		this.extraVar1 = extraVar1;
	}
	
}
