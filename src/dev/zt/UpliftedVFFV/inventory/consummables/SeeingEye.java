package dev.zt.UpliftedVFFV.inventory.consummables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.TrueSight;

public class SeeingEye extends Item{

	static int id = 2;
	static String name = "Seeing Eye";
	static boolean menu = false;
	static boolean battle = true;
	static boolean consume = true;
	static boolean target = true;
	static int value = 25;
	static int slot = 0;
	static int lvlReq = 4;
	static String descr="Disembodied eyes have a way of always seeming terrified.";
	static String descrShort="Buffs Acc.";
	public SeeingEye() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

	}
	
	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		if(perp.getName().equals(vic.getName())){
			bs.bp.bt.textList.add(vic.getName()+" swallows the Seeing Eye!");
		}
		else{
			bs.bp.bt.textList.add(perp.getName()+" gives "+vic.getName()+" the Seeing Eye.");
		}
		bs.bp.stm.addStatus(vic, new TrueSight(3, perp, 70));
	}

}
