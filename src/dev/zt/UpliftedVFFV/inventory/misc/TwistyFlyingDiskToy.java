package dev.zt.UpliftedVFFV.inventory.misc;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.ablities.FlavorNothing;
import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class TwistyFlyingDiskToy extends Item{
	
	static int id = 2;
	static String name = "Twisty Flying Disk";
	static boolean menu = false;
	static boolean battle = true;
	static boolean consume = false;
	static boolean target = true;
	static int value = 10;
	static int slot = 2;
	static int lvlReq = 1;
	static String descr="TEMP";
	static String descrShort="See how high it goes!\nNot consumed on use.";
	public TwistyFlyingDiskToy() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

	}

	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.bt.addScene(perp.getName()+" launches "+perp.getPronoun(3)+" Spinny Flying Disk!");
		bs.bp.TurnOrderQueue.add(1,new Action(vic,vic,new FlavorNothing(0,perp.getName()+" retrieves "+perp.getPronoun(1)+" Spinny Flying Disk after it lands a distance away."),bs));
		bs.bp.TurnOrderQueue.add(1,new Action(vic,vic,new FlavorNothing(0,perp.getName()+"'s Spinny Flying Disck continues to fly!"),bs));
		bs.bp.TurnOrderQueue.add(1,new Action(vic,vic,new FlavorNothing(0,perp.getName()+" watches with glee as the disk flies!"),bs));
		
	}
	
	public boolean startTeamTarget(){
		return false;
	}
}
