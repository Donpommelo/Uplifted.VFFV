package dev.zt.UpliftedVFFV.events.ElevatorsandBackroom;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.entities.creatures.Player;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.events.EventEmployeeIntro;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.input.KeyManager;

public class Event3 extends Event {

	public static BufferedImage img=Assets.ElevatorDoor1;
	public static int frame = 0;
	public boolean elevatorOn = false;
	public boolean open = false;
	public boolean solid = true;
	public static int stage=0;						
	public static int finalstage=1;	
	public Event3(float x, float y, int idnum) {
		super(img,idnum,x, y);
		frame = 0;
	}
	

	
	public void run(){
		
		if(elevatorOn){
			
		}
		else{
			
		}
		if(Event.events[45].isSelfswitch1()){
			switch(stage){
			case 0: 				
				if(!open){
					open = true;
				}
				else{
					open = false;
				}
				KeyManager.setCutsceneMode(true);
				break;
			case 1:
				KeyManager.setCutsceneMode(false);
				stage = 0;
				game.getAudiomanager().playMusic(2, true);
				switch(super.getVar(1)){
				case 0:
					super.transport("/Worlds/Floor1Reception/Lobby1.txt", 22, 58,"Reception");
					break;
				case 1:
					super.transport("/Worlds/Floor2Bathhouse/BathHouseSouth.txt", 6, 16,"Bathhouse");
					break;
				case 2:
					super.transport("/Worlds/Floor3Offices/SouthWingOffices/Lobby.txt", 7, 10,"South Lobby");
					break;
				case 3:
					break;
				case 5:
					break;
				case 6:
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
				open = false;
				break;
				
			}
		}
		
		
		
		
//		
		
	}
	
	public void tick() {
		if(open){
			if(frame<6){
				frame++;
			}
			else{
				if(KeyManager.isCutsceneMode() && Player.getPlayerX() == 96){
					stage++;
					run();
				}	
			}
		}
		else{
			if(frame>0){
				frame--;
			}
			else{
				if(KeyManager.isCutsceneMode() && Player.getPlayerX() == 96){
					stage++;
					run();
				}	
			}
		}
	}
	
	public void render(Graphics g, int x, int y) {
		switch(frame){
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
	
	public int getfinalstage() {
		return finalstage;
	}


	public int getstage() {
		return stage;
	}


	public void setstage(int stage) {
		EventEmployeeIntro.stage = stage;
	}
	
	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public boolean isSolid(){
		return solid;
	}

}
