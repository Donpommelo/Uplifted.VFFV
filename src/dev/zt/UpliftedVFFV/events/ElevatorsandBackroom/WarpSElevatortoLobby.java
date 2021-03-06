package dev.zt.UpliftedVFFV.events.ElevatorsandBackroom;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.input.KeyManager;
import dev.zt.UpliftedVFFV.states.GameState;

public class WarpSElevatortoLobby extends Event {

	public static BufferedImage img=Assets.ElevatorDoor1;
	public static int stagenum = 1;
	public WarpSElevatortoLobby(float x, float y, int idnum) {
		super(img,idnum,x, y, stagenum);
	}
	
	public void run(){
		if(super.getGamestate().getEvents()[52].isSelfswitch1()){
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
					super.transport("/Worlds/Floor2Bathhouse/BathHouseSouth.txt", 9, 21,"Bathhouse");
					break;
				case 2:
					if(!super.getSwitch(2)){
						super.transport("/Worlds/Floor3Offices/SouthWingOffices/Lobby.txt", 9, 14,"South Lobby");
						if(!this.isSelfswitch3()){
							this.setSelfswitch3(true);
							Dialog[] d = new Dialog[2];
							d[0] = new Dialog("Pen Pal" ,"/CharacterBusts/Player-5.png" ,1 ,"Floor 3! This place certainly seems familiar!/We should ask around to see if anyone can help us find Suite 521.");
							d[1] = new Dialog("Operator" ,"/CharacterBusts/Player-1.png" ,0 ,"I'll look around for someone knowledgable.");
							super.Dialog(d, 1, this.getId(), true);
							super.setQuest(1, 1);
						}
					}
					else{
						super.transport("/Worlds/Floor3Offices/SouthWingOffices/PostJorgeLobby.txt", 9, 14,"South Lobby");
					}
					break;
				case 3:
					super.transport("/Worlds/Floor4Aquarium/AquariumBuilding/SouthLobby.txt", 25, 26,"Aquarium Building");
					break;
				case 4:
					
					break;
				case 5:
					super.transport("/Worlds/Floor6FoodServery/FoodCourt/SouthLobby.txt", 22, 25,"Food Servery");
					if(super.getQuest(10)==0){
						super.setQuest(10, 1);
						Dialog[] d = new Dialog[8];
						d[0] = new Dialog("Pen Pal" ,"/CharacterBusts/Player-5.png" ,1 ,"Ah, the Sixth Floor!/Say, is that a Food Court.");
						d[1] = new Dialog("Operator" ,"/CharacterBusts/Player-1.png" ,0 ,"I believe so./could you smell it?");
						d[2] = new Dialog("Pen Pal" ,"/CharacterBusts/Player-5.png" ,1 ,"...I know I have made the urgency of our mission clear, but...well...");
						d[3] = new Dialog("Pen Pal" ,"/CharacterBusts/Player-5.png" ,1 ,"I've been stranded at sea for months with nothing to eat but seaweed and drifting Lachiplatre.");
						d[4] = new Dialog("Pen Pal" ,"/CharacterBusts/Player-5.png" ,1 ,"Could you perhaps pick something up to quell my appetite?");
						d[5] = new Dialog("Operator" ,"/CharacterBusts/Player-1.png" ,0 ,"I guess that wouldn't be too much trouble.");
						d[6] = new Dialog("Pen Pal" ,"/CharacterBusts/Player-5.png" ,1 ,"Excellent! Nothing too heavy I suppose...How about a plate of Crystal Dumplings? That ought to help me focus on the quest at hand.");
						d[7] = new Dialog("Pen Pal" ,"/CharacterBusts/Player-5.png" ,1 ,"Oh, and don't worry about money./I'll cover it. ;)");
						super.Dialog(d, 7, this.getId(), true);
					}
					break;
				case 6:
					super.transport("/Worlds/Floor7Infirmary/WaitingRoom.txt", 16, 32,"Waiting Room");
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
