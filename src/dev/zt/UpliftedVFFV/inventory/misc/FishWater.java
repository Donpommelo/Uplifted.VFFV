package dev.zt.UpliftedVFFV.inventory.misc;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class FishWater extends Item{
	
	static int id = 2;
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
		if(perp.getName().equals(vic.getName())){
			bs.bp.bt.addScene(perp.getName()+" throws the Fishwater at "+vic.getName());
		}
		bs.bp.em.hpChange(-22,perp,vic,6);
	}
	
	public boolean startTeamTarget(){
		return false;
	}

}
