package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.states.GameState;

public class ItemNothing extends Skills {
	
public Item thing;
public GameState gs;
	public ItemNothing(int index, GameState gs) {
		super(index, Assets.item);
		this.gs=gs;

	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.bt.textList.add(perp.getName()+" throws nothing at "+vic.getName());
		bs.bp.bt.textList.add(vic.getName()+" doesn't seem impressed.");
	}

}
