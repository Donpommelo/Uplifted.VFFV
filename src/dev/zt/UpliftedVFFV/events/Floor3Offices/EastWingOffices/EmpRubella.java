package dev.zt.UpliftedVFFV.events.Floor3Offices.EastWingOffices;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.entities.creatures.Player;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.events.SpriteSorter;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class EmpRubella extends Event {

	public static int stagenum = 1;
	public static BufferedImage img=SpriteSorter.SpriteSort(7,Assets.EmployeeF);
	public EmpRubella(float x, float y, int idnum) {
		super(img,idnum,x, y, stagenum);
	}
	
	public void run(){
		if (Player.runlast==0){
			this.setTex(SpriteSorter.SpriteSort(1,Assets.EmployeeF));
		}
		if (Player.runlast==1){
			this.setTex(SpriteSorter.SpriteSort(10,Assets.EmployeeF));
		}
		if (Player.runlast==2){
			this.setTex(SpriteSorter.SpriteSort(7,Assets.EmployeeF));
		}
		if (Player.runlast==3){
			this.setTex(SpriteSorter.SpriteSort(4,Assets.EmployeeF));
		}
		
		switch(this.getstage()){
		case 0: 
			if(!this.isSelfswitch1()){
				Dialog[] d = new Dialog[5];
				d[0] = new Dialog("Employee","/CharacterBusts/3rdEastOffices-3.png",1,"Heh, you looking for something?/");
				d[1] = new Dialog("Operator","/CharacterBusts/Player-1.png",1,"I was supposed to be looking for Suite 521./Do you know where that is?/");
				d[2] = new Dialog("Employee","/CharacterBusts/3rdEastOffices-3.png",1,"Let me look around to see if it's in East Offices./");
				d[3] = new Dialog("Employee","/CharacterBusts/3rdEastOffices-3.png",1,". . ./");
				d[4] = new Dialog("Employee","/CharacterBusts/3rdEastOffices-3.png",1,"Nope./It ain't here./Sorry pal./");
				super.Dialog(d, 4, this.getId(), true);
			}
			else{
				Dialog[] d = new Dialog[1];
				d[0] = new Dialog("Employee","/CharacterBusts/3rdEastOffices-3.png",1,"You want me to look again or something?/");
				super.Dialog(d, 0, this.getId(), true);

			}
			
			break;
		case 1:
			this.setTex(SpriteSorter.SpriteSort(7,Assets.EmployeeF));
			this.setstage(0);
			break;
			
		}
	}
	
	public boolean isSolid(int i){
		return true;
	}

}