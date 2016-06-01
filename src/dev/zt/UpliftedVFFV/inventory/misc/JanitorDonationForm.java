package dev.zt.UpliftedVFFV.inventory.misc;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.states.GameState;
import dev.zt.UpliftedVFFV.states.NotificationState;
import dev.zt.UpliftedVFFV.states.StateManager;

public class JanitorDonationForm extends Item{
	
	static int id = 64;
	static String name = "Janitor Donation Form";
	static boolean menu = true;
	static boolean battle = true;
	static boolean consume = true;
	static boolean target = false;
	static int value = 1;
	static int slot = 2;
	static int lvlReq = 1;
	static String descr="Some legal jargon designed to facilitate acts of generosity towards your local janitor friend.";
	static String descrShort="Donate 20 Script to the Janitor";
	public JanitorDonationForm() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

	}
	
	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		if(bs.gs.Script >=20){
			bs.bp.bt.addScene("The Janitor's opinion of you improves!");
			bs.gs.setVar(12, bs.gs.getVar(12)+1);
			bs.gs.scriptChange(-20);
		}
		else{
			bs.bp.bt.addScene("But "+perp.getPronoun(1)+" didn't have enough script!");
			bs.gs.inventorymanager.loot(this, 1);
		}
		

	}
	
	public String useName(Schmuck perp, Schmuck vic, BattleState bs){
		return perp.getName()+" fills out a Janitor Donation form.";
	}
	
	public void use(Game game, StateManager sm,GameState gs){
		if(gs.Script >=20){
			gs.setVar(12, gs.getVar(12)+1);
			gs.scriptChange(-20);
			StateManager.states.push(new NotificationState(game, gs, sm, "You can feel the Janitor smiling approvingly.", 0));

		}
		else{
			StateManager.states.push(new NotificationState(game, gs, sm, "You don't have the script to donate!", 0));
			gs.inventorymanager.loot(this, 1);
		}
		
	}


}
