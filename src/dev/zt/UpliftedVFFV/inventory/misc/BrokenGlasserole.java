package dev.zt.UpliftedVFFV.inventory.misc;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Bleed;

public class BrokenGlasserole extends Item{
	
	static int id = 95;
	static String name = "Broken Glasserole";
	static boolean menu = false;
	static boolean battle = true;
	static boolean consume = true;
	static boolean target = true;
	static int value = 4;
	static int slot = 2;
	static int lvlReq = 1;
	static String descr="A savory casserole made of ground beef, vegetables and broken glass.";
	static String descrShort="Damages and inflicts Bleed on target.";
	public BrokenGlasserole() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

	}

	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.em.hpChange(-50, perp, vic, 6);
		bs.bp.stm.addStatus(vic, new Bleed(3, perp, vic, 50));
	}
	
	public String useName(Schmuck perp, Schmuck vic, BattleState bs){
		if(perp.getName().equals(vic.getName())){
			return perp.getName()+" eats a Broken Glasserole!";
		}
		else{
			return perp.getName()+" throws a Broken Glasserole at "+vic.getName();
		}
	}
	
	public boolean startTeamTarget(){
		return false;
	}
}
