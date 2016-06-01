package dev.zt.UpliftedVFFV.events.EventsCommon;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.entities.creatures.Player;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.events.SpriteSorter;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.world.EventManager;



public class EventPushBlock extends Event {

	public static BufferedImage img=Assets.Monolith;
	public static int stagenum = 0;
	public EventPushBlock(float x, float y, int idnum) {
		super(img,idnum,x, y, stagenum);
	}
	
	public void run(){
		int pX = (int)(gamestate.getPlayer().getPlayerX()/32);
		int pY = (int)(gamestate.getPlayer().getPlayerY()/32);
		
		if (Player.runlast==0){
			if(!gamestate.getWorld().getTile(pX,pY-2).isSolid() && EventManager.getEvents()[pX][pY-2]==0){
					EventManager.getEvents()[pX][pY-1]=0;
					EventManager.getEvents()[pX][pY-2]=this.getId();
			}
		}
		if (Player.runlast==1){
			if(!gamestate.getWorld().getTile(pX,pY+2).isSolid() && EventManager.getEvents()[pX][pY+2]==0){
				EventManager.getEvents()[pX][pY+1]=0;
				EventManager.getEvents()[pX][pY+2]=this.getId();
			}
		}
		if (Player.runlast==2){
			if(!gamestate.getWorld().getTile(pX-2,pY).isSolid() && EventManager.getEvents()[pX-2][pY]==0){
				EventManager.getEvents()[pX-1][pY]=0;
				EventManager.getEvents()[pX-2][pY]=this.getId();
			}
		}
		if (Player.runlast==3){
			if(!gamestate.getWorld().getTile(pX+2,pY).isSolid() && EventManager.getEvents()[pX+2][pY]==0){
				EventManager.getEvents()[pX+1][pY]=0;
				EventManager.getEvents()[pX+2][pY]=this.getId();
			}
		}
	}
	
	public boolean isSolid(int i){
		return true;
	}
	
	public boolean isDoor(){
		return true;
	}
}
