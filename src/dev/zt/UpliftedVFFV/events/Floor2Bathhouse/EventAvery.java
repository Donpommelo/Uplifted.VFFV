package dev.zt.UpliftedVFFV.events.Floor2Bathhouse;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class EventAvery extends Event {

	public String[] Choices={"Never Mind","<Choice1>","<Choice2>","<Choice3>","<Choice4>"};			//list of choices used in the choicebranch

	public static int stagenum = 1;
	//Change texture later
	public static BufferedImage img=Assets.Monolith;
	public EventAvery(float x, float y, int idnum) {
		super(img,idnum,x, y, stagenum);
	}
	
	public void run(){	
		switch(this.getstage()){
		case 0: 
			if(this.isSelfswitch1()){
				this.setSelfswitch1(true);
				Dialog[] d1 = new Dialog[1];
				d1[0] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"<Text>/");
				super.Dialog(d1, 0, this.getId(), true);
				//Give Operator Bathhouse Status
			}
			else{
				Dialog[] d1 = new Dialog[1];
				d1[0] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"A Monster-Angering Device./");
				super.Dialog(d1, 0, this.getId(), true);
			}
			break;		
		case 1:
			int current = super.getVar(15);
			Dialog[] d1 = new Dialog[1];
			d1[0] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"Get Bathhouse aura? Current: "+current+".");
			super.Dialog(d1, 0, this.getId(), true);
			super.ChoiceBranch(this.getId(), Choices);
			break;
		}
	}

	public void ChoiceMade(int i){
		if(i == super.getVar(5)){
			Dialog[] d1 = new Dialog[1];
			d1[0] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"You are content with the way things are now./");
			super.Dialog(d1, 0, this.getId(), true);
		}
		super.setVar(15, i);
	}
	
	public boolean isSolid(int i){
		return true;
	}
}
