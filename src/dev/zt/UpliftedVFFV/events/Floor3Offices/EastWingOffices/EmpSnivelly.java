package dev.zt.UpliftedVFFV.events.Floor3Offices.EastWingOffices;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.entities.creatures.Player;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.events.SpriteSorter;
import dev.zt.UpliftedVFFV.gfx.Assets;


public class EmpSnivelly extends Event {
	
	public static int stagenum = 1;
	public static BufferedImage img=SpriteSorter.SpriteSort(4,Assets.EmployeeM1);
	public EmpSnivelly(float x, float y, int idnum) {
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
			Dialog[] d = new Dialog[1];
			d[0] = new Dialog("Employee","/CharacterBusts/3rdEastOffices-1.png",1,"Heh, I hope you aren't upset or anything./Don't be a poor sport./");
			switch(super.getQuest(5)){
			case 0:
				d[0] = new Dialog("Employee","/CharacterBusts/3rdEastOffices-1.png",1,"Hmm? Haven't seen you before./I think. Probably wouldn't remember if I did./");
				break;
			case 1:
				d[0] = new Dialog("Employee","/CharacterBusts/3rdEastOffices-1.png",1,"Oh, I'm pretty sure we've never met before in my life./Nah, this is a brand new lobby./Same interior designer. That's all./");
				break;
			case 2:
				d[0] = new Dialog("Employee","/CharacterBusts/3rdEastOffices-1.png",1,"Not that I've ever seen you before, but you should keep pluggin' along./Whatever it is you're doing./");
				break;
			case 3:
				d[0] = new Dialog("Employee","/CharacterBusts/3rdEastOffices-1.png",1,"Hehehehe./Can't stop now. You've already made it so far./");
				break;
			}
			super.Dialog(d, 0, this.getId(), true);
			break;
		case 1:
			this.setTex(SpriteSorter.SpriteSort(4,Assets.EmployeeM1));
			this.setstage(0);
			break;
			
		}
	}
	
	public boolean isSolid(int i){
		return true;
	}

}
