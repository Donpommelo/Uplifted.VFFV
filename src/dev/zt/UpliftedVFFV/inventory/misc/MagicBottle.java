package dev.zt.UpliftedVFFV.inventory.misc;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Stats.ElemPointsBuff;

public class MagicBottle extends Item{
	
	static int id = 65;
	static String name = "Magic Bottle";
	static boolean menu = false;
	static boolean battle = true;
	static boolean consume = false;
	static boolean target = true;
	static int value = 10;
	static int slot = 2;
	static int lvlReq = 1;
	static String descr="TEMP";
	static String descrShort="OVERIDE";
	public MagicBottle() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
	}

	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		if(this.getCharges() == 0){
			bs.bp.bt.addScene("But the bottle was empty!");
		}
		else{
			bs.bp.em.bpChange(75, perp);
			bs.bp.em.hpChange(75,perp, perp,1);
			bs.bp.stm.addStatus(perp, new ElemPointsBuff(5,1,15,perp,perp,50));
			this.setCharges(this.getCharges()-1);
			bs.bp.bt.addScene(this.getCharges()+" charges remaining!");
		}
	}
	
	public int getTargetType(){
		return 1;
	}
	
	public String useName(Schmuck perp, Schmuck vic, BattleState bs){
		return perp.getName()+" takes a sip from "+perp.getPronoun(1)+" Magic Bottle!";
	}
	
	public String getDescrShort() {
		return "An ornate bottle made of frosted glass.\n Looks about "+this.getCharges()+"/3 filled.";
	}
}
