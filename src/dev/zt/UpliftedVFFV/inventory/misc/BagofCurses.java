package dev.zt.UpliftedVFFV.inventory.misc;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Poisoned;
import dev.zt.UpliftedVFFV.statusEffects.Stats.BonusStatBuff;

public class BagofCurses extends Item{
	
	static int id = 2;
	static String name = "Bag of Assorted Curses";
	static boolean menu = false;
	static boolean battle = true;
	static boolean consume = true;
	static boolean target = true;
	static int value = 13;
	static int slot = 2;
	static int lvlReq = 1;
	static String descr="TEMP";
	static String descrShort="Randomly debuffs target.";
	public BagofCurses() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

	}
	
	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.stm.addStatus(vic, bs.bp.stm.randomBad((int)(3 *(1+perp.getItemPow())), perp));
		bs.bp.stm.addStatus(vic, bs.bp.stm.randomBad((int)(3 *(1+perp.getItemPow())), perp));
		bs.bp.stm.addStatus(vic, bs.bp.stm.randomBad((int)(3 *(1+perp.getItemPow())), perp));
	}
	
	public String useName(Schmuck perp, Schmuck vic, BattleState bs){
		if(perp.getName().equals(vic.getName())){
			return perp.getName()+" throws a Bag of Assorted Curses at "+perp.getPronoun(3)+"self!";
		}
		else{
			return perp.getName()+" throws a Bag of Assorted Curses at "+vic.getName();
		}
	}
	
	public boolean startTeamTarget(){
		return false;
	}
}
