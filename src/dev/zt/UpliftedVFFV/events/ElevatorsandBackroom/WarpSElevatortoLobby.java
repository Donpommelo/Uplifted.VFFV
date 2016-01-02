package dev.zt.UpliftedVFFV.events.ElevatorsandBackroom;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.input.KeyManager;

public class WarpSElevatortoLobby extends Event {

	public static BufferedImage img=Assets.ElevatorDoor1;
	public static int frame = 0;
	public boolean open = false;
	public static int stagenum = 1;
	public WarpSElevatortoLobby(float x, float y, int idnum) {
		super(img,idnum,x, y, stagenum);
		frame = 0;
	}
	
	public void run(){
		if(Event.events[52].isSelfswitch1()){
			switch(this.getstage()){
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
				this.setstage(0);
				game.getAudiomanager().playMusic(2, true);
				switch(super.getVar(1)){
				case 0:
					super.transport("/Worlds/Floor1Reception/Lobby1.txt", 22, 58,"Reception");
					break;
				case 1:
					super.transport("/Worlds/Floor2Bathhouse/BathHouseSouth.txt", 6, 16,"Bathhouse");
					break;
				case 2:
					if(!super.getSwitch(2)){
						super.transport("/Worlds/Floor3Offices/SouthWingOffices/Lobby.txt", 9, 14,"South Lobby");
						if(!this.isSelfswitch3()){
							this.setSelfswitch3(true);
							Dialog[] d = new Dialog[2];
							d[0] = new Dialog("Pen Pal" ,"/CharacterBusts/Player-5.png" ,1 ," Floor 3! This place certainly seems familiar!/We should ask around to see if anyone can help us find Suite 521./");
							d[1] = new Dialog("Operator" ,"/CharacterBusts/Player-1.png" ,0 ,"I'll look around for someone knowledgable./");
							super.Dialog(d, 1, this.getId(), true);
						}
					}
					else{
						super.transport("/Worlds/Floor3Offices/SouthWingOffices/PostJorgeLobby.txt", 9, 14,"South Lobby");
					}
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
	
	}
	
	public void tick() {
		if(open){
			if(frame<6){
				frame++;
			}
			else{
				if(KeyManager.isCutsceneMode() && gamestate.getPlayer().getPlayerX() == 160){
					this.setstage(this.getstage()+1);
					run();
				}	
			}
		}
		else{
			if(frame>0){
				frame--;
			}
			else{
				if(KeyManager.isCutsceneMode() && gamestate.getPlayer().getPlayerX() == 160){
					this.setstage(this.getstage()+1);
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
		
	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public boolean isSolid(int i){
		return true;
	}
	
	public boolean isDoor(){
		return true;
	}

}
