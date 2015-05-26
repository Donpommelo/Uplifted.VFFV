package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.states.GameState;

public class DillyDally extends Skills {
	
public Item thing;
	public String name = "Dilly Dally";
	public int cost = 0;
	public DillyDally(int index) {
		super(index,Assets.wait);

	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){
	
	}
	
	public String useText(Schmuck perp, Schmuck vic){
		return "DillyDally";
	}
	
	public String resultText(Schmuck perp, Schmuck vic){
		return "";
	}
	
	public void TOQChange(Action a, BattleState bs){
		bs.bp.TurnOrderQueue.remove(a);
		bs.bp.TurnOrderQueue.add(a);
	}
	
	public String getName(){
		return name;
	}

}
