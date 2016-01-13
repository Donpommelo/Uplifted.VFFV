package dev.zt.UpliftedVFFV.events.Floor3Offices.SouthWingOffices;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.entities.creatures.Player;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.events.SpriteSorter;
import dev.zt.UpliftedVFFV.gfx.Assets;


public class EmpLocksley extends Event {

	public static BufferedImage img=SpriteSorter.SpriteSort(1,Assets.EmployeeM2);
	public static int stagenum = 0;
	public EmpLocksley(float x, float y, int idnum) {
		super(img,idnum,x, y, stagenum);
	}
		
	public void run(){
		if (Player.runlast==0){
			Event.getEvents()[this.getId()].setTex(SpriteSorter.SpriteSort(1,Assets.EmployeeM2));
		}
		if (Player.runlast==1){
			Event.getEvents()[this.getId()].setTex(SpriteSorter.SpriteSort(10,Assets.EmployeeM2));
		}
		if (Player.runlast==2){
			Event.getEvents()[this.getId()].setTex(SpriteSorter.SpriteSort(7,Assets.EmployeeM2));
		}
		if (Player.runlast==3){
			Event.getEvents()[this.getId()].setTex(SpriteSorter.SpriteSort(4,Assets.EmployeeM2));
		}
		if(!this.isSelfswitch1()){
			Dialog[] d = new Dialog[2];
			d[0] = new Dialog("Employee","/CharacterBusts/3rdSouthOffices-1.png",1,"I'm so jealous of those West Wing guys on the other side of that door./Their office is probably so much cooler than ours./");
			d[1] = new Dialog("Employee","/CharacterBusts/3rdSouthOffices-1.png",1,"They're probably tired all the time because of all the late-night partying they do./");
			super.Dialog(d, 1, this.getId(), true);
			this.setSelfswitch1(true);
		}
		else{
			Dialog[] d = new Dialog[1];
			d[0] = new Dialog("Employee","/CharacterBusts/3rdSouthOffices-1.png",1,"Man, they even locked the door so we can't disturb their fun./");	
			super.Dialog(d, 0, this.getId(), true);
		}
	}
	
	
	public boolean isSolid(int i){
		return true;
	}
	
}
