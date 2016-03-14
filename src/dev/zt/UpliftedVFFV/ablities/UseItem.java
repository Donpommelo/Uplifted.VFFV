package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.Battle.BattleAnimation;
import dev.zt.UpliftedVFFV.Battle.Animations.UseItemAnim;
import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.states.GameState;

public class UseItem extends Skills {
	
public Item thing;
public GameState gs;
public static String name = "Use Item";
public static String descr = "User uses an item.";
public static String descrShort = "Use an item.";
public static int cost = 0;
public static int baseAcc = 100; public static int baseCrit = 0;
public static boolean canMiss = false; public static boolean canCrit = false;
public static int element = 6;	//Physical
public static int targetType = 0;	//Any Single Target
public UseItem(int index, Item i, GameState gs) {
	super(index, targetType, element, name, descr, descrShort, cost, 4, baseAcc, baseCrit, canMiss, canCrit);
	this.thing = i;
	this.gs = gs;
}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){
		if(thing.usefromBattle==true){			//Replace usedfromMenu w/ consummable
			if(gs.inventorymanager.backpack.containsKey(thing)){
				if(gs.inventorymanager.backpack.get(thing)!=0){
					thing.use(perp,vic, bs);
					if(thing.isConsummable()){
						int temp = gs.inventorymanager.backpack.get(thing);
						gs.inventorymanager.backpack.put(thing, temp-1);
						if(gs.inventorymanager.backpack.get(thing)==0){
							gs.inventorymanager.backpack.remove(thing);
						}
					}
				}
				else{
					bs.bp.bt.addScene("But the item "+perp.getName()+ " wanted to use was not there!");//running out of planned-to-use item
				}
				
				}
			}
		}
	
	
	public boolean startTarget(){
		if(thing!=null){
			return thing.startTeamTarget();
		}
		else{
			return false;
		}
	}
	
	public String getName(){
		return "Item: "+thing.getName();
	}
	
	public String getDescr() {
		return thing.getDescr();
	}
	
	public String getDescrShort() {
		return thing.getDescrShort();
	}
	public int getTargetType(){
		return thing.getTargetType();
	}

	public void TOQChange(Action a, BattleState bs){
		thing.TOQChange(a, bs);
	}
	
	public String useName(Schmuck perp, Schmuck vic, BattleState bs){
		return thing.useName(perp, vic, bs);
	}
	
	public boolean silenceBlocked(){
		return false;
	}
	
	public BattleAnimation getBa() {
		return new UseItemAnim(thing);
	}
	
	
}
