package dev.zt.UpliftedVFFV.events.Floor3Offices.WestWingOffices;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.entities.creatures.Player;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.events.SpriteSorter;
import dev.zt.UpliftedVFFV.gfx.Assets;


public class EmpAshli extends Event {

	public static int stagenum = 1;			
	public static BufferedImage img=SpriteSorter.SpriteSort(10,Assets.EmployeeF);
	public EmpAshli(float x, float y, int idnum) {
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
				this.setSelfswitch1(true);
				Dialog[] d = new Dialog[4];
				d[0] = new Dialog("Employee","/CharacterBusts/3rdWestOffices-3.png",1,"When your work gets hard, remember that your coworkers are here to lend support./Have faith in Management who have never let us employees astray./");
				d[1] = new Dialog("Employee","/CharacterBusts/3rdWestOffices-3.png",1,"On behalf of the Company, always persevere in times of hardship./Like the sturdy . . . er . . . what was it again . . ./");
				d[2] = new Dialog("Employee","/CharacterBusts/3rdWestOffices-3.png",1,"Anyways, you should take this./We will all need constitution to weather the coming storms./");
				d[3] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"You obtained the Loamskin Talisman!/");
				super.Dialog(d, 3, this.getId(), true);
			}
			else{
				Dialog[] d = new Dialog[1];
				d[0] = new Dialog("Employee","/CharacterBusts/3rdWestOffices-3.png",1,"The resiliency to withstand the toils of daily routine . . ./What else could an employee possibly need?/");
				super.Dialog(d, 0, this.getId(), true);
			}
			
			break;
		case 1:
			this.setTex(SpriteSorter.SpriteSort(10,Assets.EmployeeF));
			this.setstage(0);
			break;
			
		}
	}


	public boolean isSolid(int i){
		return true;
	}
	
}
