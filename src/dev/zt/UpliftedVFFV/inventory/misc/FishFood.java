package dev.zt.UpliftedVFFV.inventory.misc;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class FishFood extends Item{
	
	static int id = 81;
	static String name = "Fish Food";
	static boolean menu = false;
	static boolean battle = true;
	static boolean consume = false;
	static boolean target = false;
	static int value = 23;
	static int slot = 2;
	static int lvlReq = 1;
	static String descr="TEMP";
	static String descrShort="Temp";
	public FishFood() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

	}
		
	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		if(bs.gs.getVar(24) != 0){
			bs.bp.bt.addScene("TEMP TEXT");
			bs.gs.setVar(25, bs.gs.getVar(25)+1);
		}
		else{
			bs.bp.bt.addScene("TEMP TEXT <Fail>");
		}
	}
	
	public int getTargetType(){
		return 1;
	}
}
