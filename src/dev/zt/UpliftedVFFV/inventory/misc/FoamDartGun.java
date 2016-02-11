package dev.zt.UpliftedVFFV.inventory.misc;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class FoamDartGun extends Item{
	
	static int id = 2;
	static String name = "Foam Dart Gun";
	static boolean menu = false;
	static boolean battle = true;
	static boolean consume = false;
	static boolean target = true;
	static int value = 10;
	static int slot = 2;
	static int lvlReq = 1;
	static String descr="TEMP";
	static String descrShort="Sometimes Taunts target.\nNot consumed on use.";
	public FoamDartGun() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

	}

	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.bt.addScene(perp.getName()+" fires "+ perp.getPronoun(1)+" Foam Dart Gun at "+vic.getName()+"!");
		if(bs.bp.TurnOrderQueue.size() !=0 && bs.bp.TurnOrderQueue.get(1) != null){
			if(bs.bp.TurnOrderQueue.get(1).getUser() == vic && bs.bp.TurnOrderQueue.get(1).skill.getTargetType() == 1){
				bs.bp.bt.addScene(vic.getName()+" angrily turns towards "+perp.getName()+"!");
				bs.bp.TurnOrderQueue.get(1).setTarget(perp);
				}
			else{
				bs.bp.bt.addScene(vic.getName()+" ignores the attack!");
			}
		}
		else{
			bs.bp.bt.addScene(vic.getName()+" ignores the attack!");
		}
	}
	
	public boolean startTeamTarget(){
		return false;
	}
}
