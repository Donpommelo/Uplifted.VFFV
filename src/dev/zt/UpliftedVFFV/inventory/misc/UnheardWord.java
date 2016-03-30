package dev.zt.UpliftedVFFV.inventory.misc;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Silenced;


public class UnheardWord extends Item{
	
	static int id = 42;
	static String name = "Unheard Word";
	static boolean menu = false;
	static boolean battle = true;
	static boolean consume = true;
	static boolean target = false;
	static int value = 23;
	static int slot = 2;
	static int lvlReq = 1;
	static String descr="TEMP";
	static String descrShort="Damages all enemies\nif user is Silenced";
	public UnheardWord() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

	}
		
	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		if(bs.bp.stm.checkStatus(perp, new Silenced(perp,0))){
			bs.bp.bt.addScene("The Unheard Word echoes in the minds of enemies!");
			for(Schmuck s : bs.bp.getSelectableEnemies(perp)){
				int damage = (int)(bs.bp.em.logScaleDamage(perp, s) * 1.5);
				bs.bp.em.hpChange(damage, perp, s,6);
			}
		}
		else{
			bs.bp.bt.addScene("The Unheard Word was, unsurprisingly, unnoticed.");
		}
	}
	
	
	public int getTargetType(){
		return 1;
	}
}
