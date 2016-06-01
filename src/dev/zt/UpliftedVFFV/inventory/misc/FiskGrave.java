package dev.zt.UpliftedVFFV.inventory.misc;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Fear;

public class FiskGrave extends Item{
	
	static int id = 95;
	static String name = "Grave Fisk";
	static boolean menu = false;
	static boolean battle = true;
	static boolean consume = true;
	static boolean target = true;
	static int value = 4;
	static int slot = 2;
	static int lvlReq = 1;
	static String descr="A foul fish that has been growing fouler ever since employees were still allowed to bring raw fish to work.";
	static String descrShort="Inflicts Fear on Target.";
	public FiskGrave() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

	}

	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.stm.addStatus(vic, new Fear(3, perp, vic, perp, 50));
	}
	
	public String useName(Schmuck perp, Schmuck vic, BattleState bs){
		if(perp.getName().equals(vic.getName())){
			return perp.getName()+" eats a Grave Fisk!";
		}
		else{
			return perp.getName()+" throws a Grave Fisk at "+vic.getName();
		}
	}
	
	public boolean startTeamTarget(){
		return false;
	}
}
