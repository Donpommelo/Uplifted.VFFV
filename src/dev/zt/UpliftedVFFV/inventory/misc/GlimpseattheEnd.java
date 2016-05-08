package dev.zt.UpliftedVFFV.inventory.misc;

import java.util.ArrayList;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Asleep;
import dev.zt.UpliftedVFFV.statusEffects.Invuln;
import dev.zt.UpliftedVFFV.statusEffects.Isolated;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.Stats.ElemPointsBuff;


public class GlimpseattheEnd extends Item{
	
	static int id = 45;
	static String name = "Glimpse of the End";
	static boolean menu = false;
	static boolean battle = true;
	static boolean consume = false;
	static boolean target = false;
	static int value = 23;
	static int slot = 2;
	static int lvlReq = 1;
	static String descr="A single syllable of ";
	static String descrShort="Take a Glimpse at the End";
	public GlimpseattheEnd() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

	}
		
	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		int itemReq = 1000;
		switch(bs.gs.variablemanager.getVar(20)){
		case 0:
			itemReq = 1;
			break;
		case 1:
			itemReq = 3;
			break;
		case 2:
			itemReq = 8;
			break;
		case 3:
			itemReq = 17;
			break;
		case 4:
			itemReq = 30;
			break;
		case 5:
			itemReq = 50;
			break;
		case 6:
			itemReq = 99;
			break;
			
		}
		if(bs.gs.inventorymanager.backpack.get(this) >= itemReq){
			switch(bs.gs.variablemanager.getVar(20)){
			case 0:
				bs.bp.bt.addScene("You see an empty void above, lit by countless stars!");
				for(Schmuck s : bs.bp.getSelectableAllies(perp)){
					bs.bp.em.bpChange(50, s);
					bs.bp.em.hpChange(50, perp,s,6);
				}
				break;
			case 1:
				bs.bp.bt.addScene("You see a distant smoke-stacks churning out the very sky itself!");
				for(Schmuck s : bs.bp.getSelectableAllies(perp)){
					bs.bp.stm.addStatus(s, new ElemPointsBuff(10,3,30, perp,s,50));
				}
				break;
			case 2:
				bs.bp.bt.addScene("You see a vivid image; a sturdy and resolute anchor!");
				for(Schmuck s : bs.bp.getSelectableAllies(perp)){
					bs.bp.stm.addStatus(s, new Invuln(0, perp, s,100));
					ArrayList<status> removed = new ArrayList<status>();
					for(status st : s.statuses){
						if(!st.perm && st.isBad()){
							removed.add(st);
						}
					}
					for(status st : removed){
						bs.bp.stm.removeStatus(s, st);
					}
				}
				
				break;
			case 3:
				bs.bp.bt.addScene("You see a chamber of people locked away in endless sleep!");
				for(Schmuck s : bs.bp.getSelectableEnemies(perp)){
					bs.bp.stm.addStatus(s, new Asleep(5,perp,s,50));
				}
				break;
			case 4:
				bs.bp.bt.addScene("You see a fleet of aging ships and all the oceans in between!");
				for(Schmuck s : bs.bp.getSelectableEnemies(perp)){
					bs.bp.stm.addStatus(s, new Isolated(5,perp,s,50));
				}
				for(Schmuck s : bs.bp.getSelectableAllies(perp)){
					bs.bp.stm.addStatus(s, new Isolated(5,perp,s,50));
				}
				break;
			case 5:
				bs.bp.bt.addScene("You see water. An endless ocean swallowing the last skyscrapers!");
				for(Schmuck s : bs.bp.getSelectableEnemies(perp)){
					bs.bp.em.hpChange(-500, perp, s, 1);
				}
				break;
			case 6:
				bs.bp.bt.addScene("You the trunk of a massive tree, poking through the surface of the still waters!");
				for(Schmuck s : bs.bp.getSelectableAllies(perp)){
					bs.bp.em.hpChange(9999, perp, s, 2);
				}
				break;
				
			}
			bs.gs.inventorymanager.loot(this, -itemReq);
			bs.gs.variablemanager.setVar(20,bs.gs.variablemanager.getVar(20)+1);
		}
		else{
			bs.bp.bt.addScene(perp.getName()+" needs more Glimpses to get a clear look at anything!");
		}
	}
	
	public void TOQChange(Action a, BattleState bs){
		bs.bp.TurnOrderQueue.remove(a);
		bs.bp.TurnOrderQueue.add(0, a);
	}
	
	public int getTargetType(){
		return 1;
	}
}
