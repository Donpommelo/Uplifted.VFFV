package dev.zt.UpliftedVFFV.inventory.misc;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class FishWater extends Item{
	
	static int id = 3;
	static String name = "Fish Water";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 2;
	static int slot = 2;
	static int lvlReq = 1;
	static String descr="Water from the Fourth Floor Aquarium. It smells fishy.";
	static String descrShort="Damage target.";
	public FishWater() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

	}
		
	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.em.hpChange(-22,perp,vic,6);
	}
	
	public String useName(Schmuck perp, Schmuck vic, BattleState bs){
		if(perp.getName().equals(vic.getName())){
			return perp.getName()+" drinks some Fish Water. Yuck.";
		}
		else{
			return perp.getName()+" splashes "+vic.getName()+" with Fish Water!";
		}
	}
	
	public boolean startTeamTarget(){
		return false;
	}

}
