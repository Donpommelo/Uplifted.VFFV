package dev.zt.UpliftedVFFV.Decorations.decor;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.states.GameState;

public class FilterDark extends Decor{

	public FilterDark(int idnum) {
		super(Assets.DarkFilter0, idnum);
	}
	
	public void render(Graphics g, Game game, GameState gs, int x, int y) {
		BufferedImage texDrawn = Assets.DarkFilter3;
		switch(gs.getVar(29)){
		case 0:
			texDrawn = Assets.DarkFilter0;
			break;
		case 1:
			texDrawn = Assets.DarkFilter1;
			break;
		case 2:
			texDrawn = Assets.DarkFilter2;
			break;
		case 3:
			texDrawn = Assets.DarkFilter3;
			break;
		}
		if((int)(x - game.getGameCamera().getxOffset() * parallaxMultX()) < 640 &&
			(int)(x - game.getGameCamera().getxOffset() * parallaxMultX()+this.getxDim()) > 0 &&
			(int)(y - game.getGameCamera().getyOffset()* parallaxMultY()) < 416 &&
			(int)(y - game.getGameCamera().getyOffset()* parallaxMultY()+this.getyDim())>0){
			g.drawImage(texDrawn,(int)(x - game.getGameCamera().getxOffset() * parallaxMultX()),(int)(y - game.getGameCamera().getyOffset()* parallaxMultY()), tex.getWidth(), tex.getHeight(), null);
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
