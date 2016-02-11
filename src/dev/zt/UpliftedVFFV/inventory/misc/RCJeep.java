package dev.zt.UpliftedVFFV.inventory.misc;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class RCJeep extends Item{
	
	static int id = 2;
	static String name = "Remote-Controlled Jeep";
	static boolean menu = false;
	static boolean battle = true;
	static boolean consume = false;
	static boolean target = true;
	static int value = 10;
	static int slot = 2;
	static int lvlReq = 1;
	static String descr="TEMP";
	static String descrShort="Sometimes get stuff.\nNot consumed on use.";
	public RCJeep() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

	}

	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.bt.addScene(perp.getName()+" drives "+ perp.getPronoun(1)+" Remote-Controlled Jeep around!");
		double rand = Math.random();
		if(rand < 0.5){
			bs.bp.bt.addScene("Nothing happens.");
		}
		else if(rand < 5.5){
			
		}
	}
	
	public boolean startTeamTarget(){
		return false;
	}
}
