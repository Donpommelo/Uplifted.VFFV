package dev.zt.UpliftedVFFV.inventory.misc;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.ablities.ExtraTurn;
import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class ProofofWill extends Item{

	static int id = 2;
	static String name = "Proof of Will";
	static boolean menu = false;
	static boolean battle = true;
	static boolean consume = true;
	static boolean target = true;
	static int value = 125;
	static int slot = 0;
	static int lvlReq = 12;
	static String descr="TEMP";
	static String descrShort="User gains an extra turn.";
	public ProofofWill() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

	}
	
	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.bt.addScene(perp.getName()+" gains an additional turn!");
		bs.bp.TurnOrderQueue.add(1,new Action(perp,perp,new ExtraTurn(0),bs));
		bs.bp.TurnOrderQueue.add(1,new Action(perp,perp,new ExtraTurn(0),bs));

	}
	
	public String useName(Schmuck perp, Schmuck vic, BattleState bs){
		return perp.getName()+" provides Proof of Will!";
	}
	
	public int getTargetType(){
		return 1;
	}
}
