package dev.zt.UpliftedVFFV.events.ElevatorsandBackroom;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.entities.creatures.Player;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.events.SpriteSorter;
import dev.zt.UpliftedVFFV.gfx.Assets;



public class EventPenPal extends Event {

	public boolean solid;
	public boolean drawn = false;
	public static int stagenum = 0;
	public static BufferedImage img=SpriteSorter.SpriteSort(10,Assets.PenPal);
	public EventPenPal(float x, float y, int idnum) {
		super(img,idnum,x, y, stagenum);
		
	}
		
	public void run(){
		if (Player.runlast==0){
			this.setTex(SpriteSorter.SpriteSort(1,Assets.PenPal));
		}
		if (Player.runlast==1){
			this.setTex(SpriteSorter.SpriteSort(10,Assets.PenPal));
		}
		if (Player.runlast==2){
			this.setTex(SpriteSorter.SpriteSort(7,Assets.PenPal));
		}
		if (Player.runlast==3){
			this.setTex(SpriteSorter.SpriteSort(4,Assets.PenPal));
		}
		if(this.isSelfswitch1()==false){
			Dialog[] d = new Dialog[13];
			d[0] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"Good morning¡K er¡K mam?/");
			d[1] = new Dialog("Operator", "/CharacterBusts/Player-1.png",0,"What floor for you?/");
			d[2] = new Dialog("???","/CharacterBusts/Player-5.png",1,". . ./");
			d[3] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"Are those . . . envelopes?/");
			d[4] = new Dialog("???","/CharacterBusts/Player-5.png",1,"Dear Coworker!/I write to you in times of dire need!/");
			d[5] = new Dialog("???","/CharacterBusts/Player-5.png",1,"It is imperative that this plant be delivered to Suite 521!/Immediately!/");
			d[6] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",1,"Sincerely, Your Pen Pal <3/");
			d[7] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"I . . . I have a Pen Pal?/");
			d[8] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",1,"Please, Operator, do not make me further question my own existence./Can you help me or not?/");
			d[9] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"Er¡K I¡¦m afraid I don¡¦t know where Suite 521 is . . ./");
			d[10] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",1,"What? But. . . but you work here!/");
			d[11] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"Well, I guess I don't leave the Elevator often. . ./");
			d[12] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",1,"Drat! We must find the location of Suite 521. Take me to Floor 3./I use to work there, so its a good place to start looking./");
			super.Dialog(d, 12, this.getId(), true);
			super.setSwitch(1, true);
			super.setQuest(0, 1);
			this.setSelfswitch1(true);
		}
		else{
			Dialog[] d = new Dialog[1];
			d[0] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",1,"Well, are we going to Room 521 or not? Remember, we were going to check Floor 3./");
			super.Dialog(d, 0, this.getId(), true);
		}

	}
	
	public boolean isSolid(int i){
		return true;
	}
	
	public boolean drawn(){
		return drawn;
	}
	
	public void setDrawn(boolean drawn) {
		this.drawn = drawn;
	}
	
}
