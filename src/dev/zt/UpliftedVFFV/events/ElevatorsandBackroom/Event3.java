package dev.zt.UpliftedVFFV.events.ElevatorsandBackroom;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.entities.creatures.Player;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.events.EventEmployeeIntro;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.input.KeyManager;
import dev.zt.UpliftedVFFV.inventory.*;
import dev.zt.UpliftedVFFV.party.PenPal;
import dev.zt.UpliftedVFFV.states.GameState;

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
/*		super.loot(new AngryBeef(), 2);
		super.loot(new BeefBoyle(), 3);
		super.loot(new BossMug(), 1);
		super.loot(new BucketBattery(), 1);
		super.loot(new CaffeinePatch(), 5);
		super.loot(new CarrotJuice(), 3);
		super.loot(new CoffeeBean(), 2);
		super.loot(new CoffeedIce(), 1);
		super.loot(new DeploreApp(), 1);
		super.loot(new Disease(),4);
		super.loot(new EightBall(), 1);
		super.loot(new EnvenomEarth(), 1);
		super.loot(new FadedSash(), 1);
		super.loot(new FennelDonut(), 1);
		super.loot(new FishWater(), 1);
		super.loot(new Fishbones(), 1);
		super.loot(new Lachiplatre(), 683);
		super.loot(new LemonyFresh(), 2);
		super.loot(new LetterOpener(), 1);
		super.loot(new MedPak(), 6);
		super.loot(new MeltedIcecream(), 3);
		super.loot(new MentalLeakage(), 5);
		super.loot(new MidgeBlood(), 4);
		super.loot(new MidgeProboscis(), 1);
		super.loot(new NewtonCradle(), 1);
		super.loot(new Paperweight(), 1);
		super.loot(new SeeingEye(), 1);
		super.loot(new PostageStamp(),4);
		super.loot(new SimmerResent(), 1);
		super.loot(new SleepingPills(), 6);
		super.loot(new SmellingSalt(), 3);
		super.loot(new Unbeef(), 3);*/
		
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
				super.transport("/Worlds/Floor3Offices/SouthWingOffices/Lobby.txt", 7, 10,"South Lobby");
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

	public static void main(String[] args) {
		
	}

}
