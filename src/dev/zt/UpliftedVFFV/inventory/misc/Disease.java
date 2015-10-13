package dev.zt.UpliftedVFFV.inventory.misc;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Regendegen;

public class Disease extends Item{
	
	static int id = 2;
	static String name = "Disease";
	static boolean menu = false;
	static boolean battle = true;
	static boolean consume = true;
	static boolean target = true;
	static int value = 3;
	static int slot = 2;
	static int lvlReq = 1;
	static String descr="A handful of some ambiguous illness.";
	static String descrShort="Poisons target.";
	public Disease() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

	}
	
	public String useText(Schmuck perp, Schmuck vic){
		return perp.getName()+" throws the Disease at "+vic.getName();
	}
	
	public String resultText(Schmuck perp, Schmuck vic){
		return vic.getName()+" contracts an illness.";
	}
	
	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		if(perp.getName().equals(vic.getName())){
			bs.bp.bt.textList.add(perp.getName()+" eats the Disease.");
		}
		else{
			bs.bp.bt.textList.add(perp.getName()+" throws the Disease at "+vic.getName());
		}
		bs.bp.stm.addStatus(vic, new Regendegen(4,true,(int)(-6*(1+perp.getItemPow())), perp, 50));
	}
	
	public boolean startTeamTarget(){
		return false;
	}
}
