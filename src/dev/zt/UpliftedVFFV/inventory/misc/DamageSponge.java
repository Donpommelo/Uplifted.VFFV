package dev.zt.UpliftedVFFV.inventory.misc;


import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.TempFortify;


public class DamageSponge extends Item{
	
	static int id = 95;
	static String name = "Damage Sponge";
	static boolean menu = false;
	static boolean battle = true;
	static boolean consume = false;
	static boolean target = false;
	static int value = 23;
	static int slot = 2;
	static int lvlReq = 1;
	static String descr="A handy tool if you every spill a pitcher of damage on the kitchen counter.";
	static String descrShort="Blocks next instance of damage against user.";
	public DamageSponge() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

	}
		
	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.stm.addStatus(perp, new TempFortify(7, perp, perp, 10));
	}
	
	public int getTargetType(){
		return 1;
	}
}
