package dev.zt.UpliftedVFFV.events.ElevatorsandBackroom;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.input.KeyManager;
import dev.zt.UpliftedVFFV.states.GameState;
import dev.zt.UpliftedVFFV.statusEffects.Special.BathHouseIntrinsic;
import dev.zt.UpliftedVFFV.statusEffects.Special.UnderwaterPenalty;

public class WarpWElevatortoLobby extends Event {

	public static BufferedImage img=Assets.ElevatorDoor1;
	public static int stagenum = 1;
	public WarpWElevatortoLobby(float x, float y, int idnum) {
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
				super.transport("/Worlds/Floor2Bathhouse/BathHouseWest.txt", 5, 20,"Bathhouse");
				break;
			case 2:
				super.transport("/Worlds/Floor3Offices/WestWingOffices/Lobby.txt", 9, 14,"West Offices");
				break;
			case 3:
				super.transport("/Worlds/Floor4Aquarium/AquariumTank/TankMain.txt",24,24,"Aquarium Tank");
				if(!super.getSwitch(33)){
					super.setSwitch(33, true);
					super.getGamestate().getPartymanager().getParty().get(0).statuses.add(new UnderwaterPenalty(super.getGamestate().getPartymanager().getParty().get(0),15));
				}
				super.setSwitch(34, true);
				break;
			case 4:
				break;
			case 5:
				super.transport("/Worlds/Floor6FoodServery/Processing/WestLobby.txt",8,14,"West Lobby");
				break;
			case 6:
				super.transport("/Worlds/Floor7Infirmary/ResearchFacility/IncubatorRoom.txt",6,12,"Incubator Room");
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
