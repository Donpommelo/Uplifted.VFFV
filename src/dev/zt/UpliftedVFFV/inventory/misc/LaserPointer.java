package dev.zt.UpliftedVFFV.inventory.misc;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Blind;

public class LaserPointer extends Item{
	
	static int id = 2;
	static String name = "Laser Pointer";
	static boolean menu = false;
	static boolean battle = true;
	static boolean consume = false;
	static boolean target = true;
	static int value = 10;
	static int slot = 2;
	static int lvlReq = 1;
	static String descr="TEMP";
	static String descrShort="Sometimes Blind target.\nNot consumed on use.";
	public LaserPointer() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

	}

	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.bt.addScene(perp.getName()+" shines a Laser Pointer at "+ vic.getName()+"'s eyes!");
		if(bs.bp.TurnOrderQueue.size() !=0 && bs.bp.TurnOrderQueue.get(1) != null){
			if(bs.bp.TurnOrderQueue.get(1).getUser() == vic && bs.bp.TurnOrderQueue.get(1).skill.getTargetType() == 1){
				bs.bp.bt.addScene(vic.getName()+" angrily turns towards "+perp.getName()+"!");
				bs.bp.stm.addStatus(vic, new Blind(0,perp,50));
				}
			else{
				bs.bp.bt.addScene(vic.getName()+" was annoyed, but not harmed!");
			}
		}
		else{
			bs.bp.bt.addScene(vic.getName()+" was annoyed, but not harmed!");
		}
	}
	
	public boolean startTeamTarget(){
		return false;
	}
}
