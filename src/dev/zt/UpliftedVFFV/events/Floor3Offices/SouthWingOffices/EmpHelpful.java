package dev.zt.UpliftedVFFV.events.Floor3Offices.SouthWingOffices;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.entities.creatures.Player;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.events.SpriteSorter;
import dev.zt.UpliftedVFFV.gfx.Assets;


public class EmpHelpful extends Event {

	public static int stagenum = 1;			
	public static BufferedImage img=SpriteSorter.SpriteSort(1,Assets.EmployeeF);
	public EmpHelpful(float x, float y, int idnum) {
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
				Dialog[] d = new Dialog[2];
				d[0] = new Dialog("Employee","/CharacterBusts/3rdSouthOffices-3.png",1,"That hallway to the West leads to the West Wing Offices./");
				d[1] = new Dialog("Employee","/CharacterBusts/3rdSouthOffices-3.png",1,"That advice was helpful, right? Right./Well, that's enough work for the day. Time to go back to/staring off into space./");
				super.Dialog(d, 1, this.getId(), true);
				this.setSelfswitch1(true);
			}
			else{
				Dialog[] d = new Dialog[1];
				d[0] = new Dialog("Employee","/CharacterBusts/3rdSouthOffices-3.png",1,"I gave you directions, so any work you do is vicariously done by me too./");
				super.Dialog(d, 0, this.getId(), true);
			}
			
			break;
		case 1:
			this.setTex(SpriteSorter.SpriteSort(1,Assets.EmployeeF));
			this.setstage(0);
			break;
			
		}
	}
	
	public boolean isSolid(int i){
		return true;
	}
	
}
