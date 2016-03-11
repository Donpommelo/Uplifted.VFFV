package dev.zt.UpliftedVFFV.inventory.misc;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.states.GameState;
import dev.zt.UpliftedVFFV.states.NotificationState;
import dev.zt.UpliftedVFFV.states.StateManager;

public class JanitorDonationForm extends Item{
	
	static int id = 2;
	static String name = "Janitor Donation Form";
	static boolean menu = true;
	static boolean battle = true;
	static boolean consume = true;
	static boolean target = false;
	static int value = 50;
	static int slot = 2;
	static int lvlReq = 1;
	static String descr="TEMP";
	static String descrShort="Donate 20 Script to the Janitor";
	public JanitorDonationForm() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

	}
	
	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.bt.addScene("The Janitor's opinion of you improves!");
		bs.gs.setVar(12, bs.gs.getVar(12)+1);

	}
	
	public String useName(Schmuck perp, Schmuck vic, BattleState bs){
		return perp.getName()+" fills out a Janitor Donation form.";
	}
	
	public void use(Game game, StateManager sm,GameState gs){
			gs.setVar(12, gs.getVar(12)+1);
			StateManager.states.push(new NotificationState(game, gs, sm, "You can feel the Janitor smiling approvingly.", 0));
	}


}
