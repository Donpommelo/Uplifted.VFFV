package dev.zt.UpliftedVFFV.inventory.consumables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Paralysis;

public class MuscleRelaxant extends Item{

	static int id = 2;
	static String name = "Muscle Relaxant";
	static boolean menu = false;
	static boolean battle = true;
	static boolean consume = true;
	static boolean target = true;
	static int value = 8;
	static int slot = 0;
	static int lvlReq = 1;
	static String descr="A tube of medicinal cream designed to\ncure stiffness of limbs.";
	static String descrShort="Cures Paralysis.";
	public MuscleRelaxant() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

	}
	
	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.stm.removeStatus(vic, new Paralysis(1, perp, 50) );
	}
	
	public String useName(Schmuck perp, Schmuck vic, BattleState bs){
		if(perp.getName().equals(vic.getName())){
			return vic.getName()+" uses a Muscle Relaxant on "+perp.getPronoun(3)+"self!";
		}
		else{
			return perp.getName()+" uses a Muscle Relaxant on "+vic.getName()+"!";
		}
	}
}
