package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.states.GameState;

public class SkillNothing extends Skills {
	
public Item thing;
public GameState gs;

	public SkillNothing(int index, GameState gs) {
		super(index,1,6,"","","",0);
		this.gs=gs;

	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.bt.textList.add(perp.getName()+" did nothing in "+vic.getName()+"'s general direction.");
		bs.bp.bt.textList.add(vic.getName()+" doesn't seem impressed.");
	}


}
