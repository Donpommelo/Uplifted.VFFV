package dev.zt.UpliftedVFFV.events.Floor4Aquarium.Building;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.entities.creatures.Player;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.events.SpriteSorter;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class EventPettingZooKeeper extends Event {

	public String[] Choices={"Never Mind","..."};			//list of choices used in the choicebranch
	public static int stagenum = 7;
	public String name;
	public static BufferedImage img=SpriteSorter.SpriteSort(1,Assets.EmployeeM1);
	public EventPettingZooKeeper(float x, float y, int idnum) {
		super(img,idnum,x, y, stagenum);
	}
	
	public void run(){
		if (Player.runlast==0){
			this.setTex(SpriteSorter.SpriteSort(1,Assets.EmployeeM1));
		}
		if (Player.runlast==1){
			this.setTex(SpriteSorter.SpriteSort(10,Assets.EmployeeM1));
		}
		if (Player.runlast==2){
			this.setTex(SpriteSorter.SpriteSort(7,Assets.EmployeeM1));
		}
		if (Player.runlast==3){
			this.setTex(SpriteSorter.SpriteSort(4,Assets.EmployeeM1));
		}
		switch(this.getstage()){
		case 0: 
			if(!this.isSelfswitch1() || super.getVar(24) == 0){
				Dialog[] d = new Dialog[2];
				d[0] = new Dialog("Petting Zookeeper","/CharacterBusts/AquariumMsmall.png",1,"TEMP");
				d[1] = new Dialog("Petting Zookeeper","/CharacterBusts/AquariumMsmall.png",1,"MORE TEMP");
				super.Dialog(d, 1, this.getId(), true);
				this.setSelfswitch1(true);
			}
			else{
				Dialog[] d = new Dialog[2];
				d[0] = new Dialog("Petting Zookeeper","/CharacterBusts/AquariumMsmall.png",1,"Well, I think that ought to be enough play for now. You should get back to work.");
				d[1] = new Dialog("Petting Zookeeper","/CharacterBusts/AquariumMsmall.png",1,"");
				super.Dialog(d, 1, this.getId(), true);
				this.setstage(6);
			}
			break;
		case 1:
			Dialog[] d = new Dialog[1];
			d[0] = new Dialog("Petting Zookeeper","/CharacterBusts/AquariumMsmall.png",1,"Well, what do you say? Which fish do you wanna play with?");
			super.Dialog(d, 0, this.getId(), true);
			super.ChoiceBranch(this.getId(), Choices, 400);
			break;
		case 2:
			super.fade(-1, this.getId());
			break;
		case 3:
			super.Timer(this.getId(), 50);
			break;
		case 4:
			this.fade(1, this.getId());
			break;
		case 5:
			Dialog[] d1 = new Dialog[3];
			d1[0] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"You spend the hour playing with the <Name>./For once you are free of worry and anxiety.");
			d1[1] = new Dialog("Petting Zookeeper","/CharacterBusts/3rdSouthOffices-1.png",1,"Hey, that <Name> seems to have really taken a likin' to ya.");
			d1[2] = new Dialog("Petting Zookeeper","/CharacterBusts/3rdSouthOffices-1.png",1,"How 'bout I let ya name it?");
			super.Dialog(d1, 2, this.getId(), true);
			break;
		case 6:
			super.TypingState(this.getId(), "Name your newfound friend?", 20);
			break;
		case 7:
			this.setTex(SpriteSorter.SpriteSort(1,Assets.EmployeeM1));
			this.setstage(0);
			break;
			
		}
	}
	
	public void ChoiceMade(int i){
		super.setVar(24, i);
		if(i != 0){
			this.setstage(2);
			this.run();
		}
		else{
			this.setstage(0);
		}
	}
	
	public void textMade(String text) {
		Dialog[] d = new Dialog[2];
		d[0] = new Dialog("Petting Zookeeper","/CharacterBusts/AquariumMsmall.png",1,text+" . . .");
		d[1] = new Dialog("Petting Zookeeper","/CharacterBusts/AquariumMsmall.png",1,"That's a good name. I'm sure "+text+" will be there for you when you need it.");
		this.name = text;
		super.Dialog(d, 1, this.getId(), true);
		
	}
	
	public boolean isSolid(int i){
		return true;
	}
	
	public String getName(){
		if(name != null){
			return name;
		}
		else{
			return "";
		}
	}
	
		
}
