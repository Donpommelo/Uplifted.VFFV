package dev.zt.UpliftedVFFV.events.EventsCommon;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.entities.creatures.Player;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;



public class EventSlipFloor extends Event {

	public static BufferedImage img=Assets.Mirror;
	public static int stagenum = 0;
	public EventSlipFloor(float x, float y, int idnum) {
		super(img,idnum,x, y, stagenum);
	}
	
	public void run(){
		int pX = (int)(gamestate.getPlayer().getPlayerX()/32);
		int pY = (int)(gamestate.getPlayer().getPlayerY()/32);
		gamestate.getPlayer().setStill(true);
		if (Player.runlast==0){
			if(!gamestate.getWorld().getTile(pX,pY-1).isSolid() && !gamestate.getEventmanager().getEvent(pX,pY-1).isSolid(0)){
				gamestate.getPlayer().movePlayer(0);
			}
		}
		if (Player.runlast==1){
			if(!gamestate.getWorld().getTile(pX,pY+1).isSolid() && !gamestate.getEventmanager().getEvent(pX,pY+1).isSolid(0)){
				gamestate.getPlayer().movePlayer(1);
			}
		}
		if (Player.runlast==2){
			if(!gamestate.getWorld().getTile(pX-1,pY).isSolid() && !gamestate.getEventmanager().getEvent(pX-1,pY).isSolid(0)){
				gamestate.getPlayer().movePlayer(2);
			}
		}
		if (Player.runlast==3){
			if(!gamestate.getWorld().getTile(pX+1,pY).isSolid() && !gamestate.getEventmanager().getEvent(pX+1,pY).isSolid(0)){
				gamestate.getPlayer().movePlayer(3);

			}
		}
	}
	
	public int renderBelow(){
		return -1;
	}
	
}
