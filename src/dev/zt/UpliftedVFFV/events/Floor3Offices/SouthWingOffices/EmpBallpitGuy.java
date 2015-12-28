package dev.zt.UpliftedVFFV.events.Floor3Offices.SouthWingOffices;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.entities.creatures.Player;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.events.SpriteSorter;
import dev.zt.UpliftedVFFV.gfx.Assets;


public class EmpBallpitGuy extends Event {

	public static BufferedImage img=SpriteSorter.SpriteSort(10,Assets.EmployeeM2);
	public static int stagenum = 0;
	public EmpBallpitGuy(float x, float y, int idnum) {
		super(img,idnum,x, y, stagenum);
	}
		
	public void run(){
		if (Player.runlast==0){
			Event.events[this.getId()].setTex(SpriteSorter.SpriteSort(1,Assets.EmployeeM2));
		}
		if (Player.runlast==1){
			Event.events[this.getId()].setTex(SpriteSorter.SpriteSort(10,Assets.EmployeeM2));
		}
		if (Player.runlast==2){
			Event.events[this.getId()].setTex(SpriteSorter.SpriteSort(7,Assets.EmployeeM2));
		}
		if (Player.runlast==3){
			Event.events[this.getId()].setTex(SpriteSorter.SpriteSort(4,Assets.EmployeeM2));
		}
		if(!this.isSelfswitch1()){
			Dialog[] d = new Dialog[6];
			d[0] = new Dialog("Employee","/CharacterBusts/3rdSouthOffices-1.png",1,"What a disapointment./Looks like we're going to need more colored plastic balls./");
			d[1] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"What's going on here?/");
			d[2] = new Dialog("Employee","/CharacterBusts/3rdSouthOffices-1.png",1,"Well, this was originally a conference room, you see./But we barely had any conferences, and nobody showed up to the few we did have./So we decided to turn this room into a Ball Pit instead./");
			d[3] = new Dialog("Employee","/CharacterBusts/3rdSouthOffices-1.png",1,"Do you like it? It was my idea./I always wanted to have a ball pit in this office./");
			d[4] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"It's . . . interesting./");
			d[5] = new Dialog("Employee","/CharacterBusts/3rdSouthOffices-1.png",1,"Sadly, its not full yet, which makes getting in and out a real hassle./");

			super.Dialog(d, 5, this.getId(), true);
			this.setSelfswitch1(true);
		}
		else{
			Dialog[] d = new Dialog[1];
			d[0] = new Dialog("Employee","/CharacterBusts/3rdSouthOffices-1.png",1,"Man, when this thing is done, it'll be amazing./The other offices will be so jealous./");	
			super.Dialog(d, 0, this.getId(), true);
		}
	}
		
	public boolean isSolid(int i){
		return true;
	}
	
}
