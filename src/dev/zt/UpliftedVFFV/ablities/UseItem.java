package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.states.GameState;

public class UseItem extends Skills {
	
public Item thing;
public GameState gs;
	public UseItem(int index, Item i, GameState gs) {
		super(index);
		this.thing=i;
		this.gs=gs;

	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.bt.textList.add(thing.useText(perp, vic));
		bs.bp.bt.textList.add(thing.resultText(perp, vic));
		if(thing.usedfromMenu==true){			//Replace usedfromMenu w/ consummable
			if(gs.inventorymanager.backpack.containsKey(thing)){
				if(gs.inventorymanager.backpack.get(thing)!=0){
					thing.use(perp,vic);
					int temp = gs.inventorymanager.backpack.get(thing);
					gs.inventorymanager.backpack.put(thing, temp-1);
					if(gs.inventorymanager.backpack.get(thing)==0){
						gs.inventorymanager.backpack.remove(thing);
					}
				}
				else{
					//running out of planned-to-use item
				}
				
				}
			}
		}
	public boolean startTarget(){
		if(thing!=null){
			return thing.startTeamTarget();
		}
		else{
			return false;
		}
	}

}
