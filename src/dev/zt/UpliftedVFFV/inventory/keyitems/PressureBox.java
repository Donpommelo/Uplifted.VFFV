package dev.zt.UpliftedVFFV.inventory.keyitems;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.states.GameState;
import dev.zt.UpliftedVFFV.states.NotificationState;
import dev.zt.UpliftedVFFV.states.StateManager;

public class PressureBox extends Item{

	static int id = 95;
	static String name = "Pressure-Locked Box";
	static boolean menu = true;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 999;
	static int slot = 3;
	static int lvlReq = 1;
	static String descr="TEMP";
	static String descrShort = "TEMP";
	public PressureBox() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

	}

	public void use(Game game, StateManager sm,GameState gs){
		StateManager.states.push(new NotificationState(game, gs, sm, "You attempt to open the box, to no avail.", 0));
	}
}
