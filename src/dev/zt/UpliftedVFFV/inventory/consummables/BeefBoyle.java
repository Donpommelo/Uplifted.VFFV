package dev.zt.UpliftedVFFV.inventory.consummables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.BeefedUp;

public class BeefBoyle extends Item{
	
	
	static int id = 2;
	static String name = "Beef Boyleston";
	static boolean menu = false;
	static boolean battle = true;
	static boolean consume = true;
	static boolean target = true;
	static String descr="A thick, stew filled with beef as well as several ingredients that are \nless likely to be beef. ";
	static String descrShort="Silence and buff Pow.";
	static int value = 25;
	static int slot = 0;
	static int lvlReq = 12;
	
	public BeefBoyle() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
	}
	
	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		if(perp.getName().equals(vic.getName())){
			bs.bp.bt.textList.add(vic.getName()+" chokes down the Bef Boyleston!");
		}
		else{
			bs.bp.bt.textList.add(perp.getName()+" gives "+vic.getName()+" the Beef Boyleston.");
		}
		bs.bp.stm.addStatus(vic, new BeefedUp(5, perp, 30));
	}
}