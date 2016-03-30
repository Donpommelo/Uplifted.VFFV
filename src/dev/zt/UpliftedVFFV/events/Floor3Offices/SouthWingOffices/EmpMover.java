package dev.zt.UpliftedVFFV.events.Floor3Offices.SouthWingOffices;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.entities.creatures.Player;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.events.SpriteSorter;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class EmpMover extends Event {

	public static int stagenum = 0;
	public static BufferedImage img=SpriteSorter.SpriteSort(7,Assets.Mover);
	public EmpMover(float x, float y, int idnum) {
		super(img,idnum,x, y, stagenum);
	}
		
	public void run(){
		if (Player.runlast==0){
			this.setTex(SpriteSorter.SpriteSort(1,Assets.Mover));
		}
		if (Player.runlast==1){
			this.setTex(SpriteSorter.SpriteSort(10,Assets.Mover));
		}
		if (Player.runlast==2){
			this.setTex(SpriteSorter.SpriteSort(7,Assets.Mover));
		}
		if (Player.runlast==3){
			this.setTex(SpriteSorter.SpriteSort(4,Assets.Mover));
		}
		if(!this.isSelfswitch1()){
			Dialog[] d = new Dialog[7];
			d[0] = new Dialog("Mr. Mover","/CharacterBusts/3rdSouthOffices-7.png",1,"Arrrh. Darn sofa won't fit through the door.");
			d[1] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"Sir . . . do you need any help with that?");
			d[2] = new Dialog("Mr. Mover","/CharacterBusts/3rdSouthOffices-7.png",1,"Just go the other way. I got this under control.");
			d[3] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"Maybe if you turned it . . .");
			d[4] = new Dialog("Mr. Mover","/CharacterBusts/3rdSouthOffices-7.png",1,"Bugger off! Who d'ya think you are? Some kinda furniture moving expert? That's MY job! Y'hear me? That's what they PAY me for! Moving furniture!");
			d[5] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,". . . Say, perhaps you could help me move this potted plant . . . I really need to get back to my elevator.");
			d[6] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",0,"No! Absolutely not! I forbid it! Operator, this job can be done by you and no one else.");
			super.Dialog(d, 6, this.getId(), true);	
			this.setSelfswitch1(true);
		}
		else{
			Dialog[] d = new Dialog[1];
			d[0] = new Dialog("Mr. Mover","/CharacterBusts/3rdSouthOffices-7.png",1,"Arrrgh. Maybe I should try pushing it from the other direction.");
			super.Dialog(d, 0, this.getId(), true);	
		}

	}
	
	public boolean isSolid(int i){
		return true;
	}
	
	public boolean drawn(){
		return !super.getSwitch(2);
	}
}
