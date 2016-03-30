package dev.zt.UpliftedVFFV.Decorations.decor;


import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.states.GameState;

public class FilterUnderwaterVariable extends Decor{

	public FilterUnderwaterVariable(int idnum) {
		super(Assets.UnderwaterFilter, idnum);
	}
	
	public boolean isRendered(GameState gs){
		if(gs.getSwitch(34)){
			return true;
		}
		else{
			return false;
		}
	}
	
	public int renderBelow(){
		return 1;
	}
	
	public double parallaxMultX(){
		return 0;
	}
	
	public double parallaxMultY(){
		return 0;
	}

}
