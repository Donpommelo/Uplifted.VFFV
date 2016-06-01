package dev.zt.UpliftedVFFV.events.ElevatorsandBackroom;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.input.KeyManager;
import dev.zt.UpliftedVFFV.states.GameState;

public class WarpEElevatortoLobby extends Event {

	public static BufferedImage img=Assets.ElevatorDoor1;
	public static int stagenum = 1;
	public WarpEElevatortoLobby(float x, float y, int idnum) {
		super(img,idnum,x, y, stagenum);
	}
	
	public void run(){
		switch(this.getstage()){
		case 0: 				
			if(!this.isOpen()){
				this.setOpen(true);
			}
			else{
				this.setOpen(false);
			}
			KeyManager.setCutsceneMode(true);
			break;
		case 1:
			KeyManager.setCutsceneMode(false);
			this.setstage(0);
			game.getAudiomanager().playMusic(2, true);
			switch(super.getVar(1)){
			case 0:
				super.transport("/Worlds/Floor1Reception/SouthLobbyMain.txt", 17, 53,"Reception");
				break;
			case 1:
				super.transport("/Worlds/Floor2Bathhouse/BathHouseEast.txt", 11, 20,"Bathhouse");
				break;
			case 2:
				super.transport("/Worlds/Floor3Offices/EastWingOffices/EastOfficesCarlocsOfficePlus.txt", 21, 28,"East Offices");
				break;
			case 3:
				super.transport("/Worlds/Floor4Aquarium/AquariumTunnel/EastLobby.txt",11,16,"Aquarium");
				break;
			case 4:
				break;
			case 5:
				super.transport("/Worlds/Floor6FoodServery/LachiplatreLand/LachiplatreLobby.txt",9,16,"Lachiplatre Land Lobby");
				break;
			case 6:
				super.transport("/Worlds/Floor7Infirmary/Triage/FastTrack.txt",12,6,"Triage");
				break;
			case 7:
				break;
			case 8:
				break;
			case 9:
				break;
			case 10:
				break;
			case 11:
				break;
			case 12:
				break;
			case 13:
				break;
			case 14:
				break;
				
			}
			this.setOpen(false);
			break;
			
		}
			
	
	}
	
	public void tick(GameState gs) {
		if(this.isOpen()){
			if(this.getFrames()<6){
				this.setFrames(this.getFrames()+1);;
			}
			else{
				if(KeyManager.isCutsceneMode() && gs.getPlayer().getPlayerX() == 160){
					this.setstage(this.getstage()+1);
					run();
				}	
			}
		}
		else{
			if(this.getFrames()>0){
				this.setFrames(this.getFrames()-1);
			}
			else{
				if(KeyManager.isCutsceneMode() && gs.getPlayer().getPlayerX() == 160){
					this.setstage(this.getstage()+1);
					run();
				}	
			}
		}
	}
	
	public void render(Graphics g, int x, int y) {
		switch(this.getFrames()){
		case 0:
			tex = Assets.ElevatorDoor1;
			break;
		case 2:
			tex = Assets.ElevatorDoor2;
			break;
		case 4:
			tex = Assets.ElevatorDoor3;
			break;
		case 6:
			tex = Assets.ElevatorDoor4;
			break;
		}
		g.drawImage(tex,x-16, y-32, tex.getWidth(), tex.getHeight(), null);
	}
		
	public boolean isSolid(int i){
		return true;
	}
	
	public boolean isDoor(){
		return true;
	}

}
