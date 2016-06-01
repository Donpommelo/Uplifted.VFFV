package dev.zt.UpliftedVFFV.inventory.misc;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.inventory.equipables.HiveRhythmA;
import dev.zt.UpliftedVFFV.inventory.equipables.HiveRhythmB;
import dev.zt.UpliftedVFFV.inventory.equipables.HiveRhythmC;
import dev.zt.UpliftedVFFV.inventory.equipables.HiveRhythmD;
import dev.zt.UpliftedVFFV.inventory.equipables.HiveRhythmE;
import dev.zt.UpliftedVFFV.states.GameState;
import dev.zt.UpliftedVFFV.states.NotificationState;
import dev.zt.UpliftedVFFV.states.StateManager;

public class HiveRhythm extends Item{
	
	static int id = 42;
	static String name = "Hive Rhythm";
	static boolean menu = true;
	static boolean battle = false;
	static boolean consume = true;
	static boolean target = false;
	static int value = 50;
	static int slot = 2;
	static int lvlReq = 1;
	static String descr="TEMP";
	static String descrShort="Gain 5 Hive Rhythms";
	public HiveRhythm() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

	}
	
	public void use(Game game, StateManager sm,GameState gs){
		StateManager.states.push(new NotificationState(game, gs, sm, "You break the rhythm into its basic components.\nAcquired Hive Rhythm A,B,C,D and E!", 0));
		gs.inventorymanager.loot(new HiveRhythmA(), 1);	
		gs.inventorymanager.loot(new HiveRhythmB(), 1);	
		gs.inventorymanager.loot(new HiveRhythmC(), 1);	
		gs.inventorymanager.loot(new HiveRhythmD(), 1);
		gs.inventorymanager.loot(new HiveRhythmE(), 1);	
	}


}
