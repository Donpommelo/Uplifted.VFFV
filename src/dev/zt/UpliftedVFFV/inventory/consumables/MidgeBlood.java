package dev.zt.UpliftedVFFV.inventory.consumables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Regendegen;

public class MidgeBlood extends Item{

	static int id = 2;
	static String name = "Midge Blood";
	static boolean menu = true;
	static boolean battle = true;
	static boolean consume = true;
	static boolean target = true;
	static int value = 3;
	static int slot = 0;
	static int lvlReq = 1;
	static String descr="Blood from a midge could really be anybody¡¦s.";
	static String descrShort="Regenerate Hp over time.";
	public MidgeBlood() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

	}
	
	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		if(perp.getName().equals(vic.getName())){
			bs.bp.bt.addScene(vic.getName()+" drinks the Midge Blood.");
		}
		else{
			bs.bp.bt.addScene(perp.getName()+" gives "+vic.getName()+" the Midge Blood.");
		}
		bs.bp.stm.addStatus(vic, new Regendegen(3,true,(int)(8*(1+perp.getItemPow())), perp, 40));

	}
	
	public void use(Schmuck s){
		s.hpChange((int)(10*(1+s.getItemPow())));
	}
}
