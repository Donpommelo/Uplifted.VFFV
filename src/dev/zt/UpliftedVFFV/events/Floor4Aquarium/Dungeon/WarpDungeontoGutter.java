package dev.zt.UpliftedVFFV.events.Floor4Aquarium.Dungeon;

import java.awt.Graphics;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class WarpDungeontoGutter extends Event {
	
	public static int stagenum = 0;
	public WarpDungeontoGutter(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}

	public void run(){
		if(super.getSwitch(31)){
			super.transport("/Worlds/Floor4Aquarium/WetworksDungeon/Gutter.txt", 30, 56,"");
		}
		else{
			Dialog[] d = new Dialog[2];
			d[0] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"A sculpture of a man in a diving suit.");
			d[1] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"It seems to be made of porous sand.");
			super.Dialog(d, 1, this.getId(), true);
		}
	}
	
	public void render(Graphics g, int x, int y) {
		if(super.getSwitch(31)){
			tex = Assets.White;
		}
		else{
			tex = Assets.Monolith;
		}
		g.drawImage(tex,x, y+32-tex.getHeight(), tex.getWidth(), tex.getHeight(), null);
	}
	
	public boolean isSolid(int direction){
		return !super.getSwitch(31);
	}

}
