package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.GameState;

public class SkillNothing extends Skills {
	
public Item thing;
public GameState gs;

	public SkillNothing(int index, Item i, GameState gs) {
		super(index);
		this.thing=i;
		this.gs=gs;

	}
	
	public void run(Schmuck perp, Schmuck vic){
	
	}
	
	public String useText(Schmuck perp, Schmuck vic){
		return perp+" did nothing in "+vic+"'s general direction.";
	}
	
	public String resultText(Schmuck perp, Schmuck vic){
		return vic+" doesn't seem impressed.";
	}

}
