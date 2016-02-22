package dev.zt.UpliftedVFFV.events.Floor2Bathhouse;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.statusEffects.Special.BathHouseIntrinsic;

public class EventAvery extends Event {

	public String[] Choices={"Never Mind","<Choice1>","<Choice2>","<Choice3>","<Choice4>","<Choice5>"};			//list of choices used in the choicebranch
	public String[] Descriptions={"","+Hp/Mp Regen","+Monster Level","-Combat Frequency","+15 All Stats. -90% Drops","Remove Current Aura"};
	public static int stagenum = 1;
	//Change texture later
	public static BufferedImage img=Assets.Monolith;
	public EventAvery(float x, float y, int idnum) {
		super(img,idnum,x, y, stagenum);
	}
	
	public void run(){	
		switch(this.getstage()){
		case 0: 
			if(!this.isSelfswitch1()){
				this.setSelfswitch1(true);
				Dialog[] d1 = new Dialog[1];
				d1[0] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"<Text>/");
				super.Dialog(d1, 0, this.getId(), true);
				super.getGamestate().getPartymanager().getParty().get(0).statuses.add(new BathHouseIntrinsic(50));
			}
			else{
				Dialog[] d1 = new Dialog[1];
				d1[0] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"<more text>./");
				super.Dialog(d1, 0, this.getId(), true);
			}
			break;		
		case 1:
			int current = super.getVar(15);
			Dialog[] d1 = new Dialog[1];
			d1[0] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"Get Bathhouse aura? Current: "+current+".");
			super.Dialog(d1, 0, this.getId(), true);
			super.ChoiceBranch(this.getId(), Choices, Descriptions, 100);
			break;
		}
	}

	public void ChoiceMade(int i){
		if(i == 5){
			super.setVar(15, 0);
			Dialog[] d1 = new Dialog[1];
			d1[0] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"You feel cleansed of any Bathhouse Aura!/");
			super.Dialog(d1, 0, this.getId(), true);
			
		}
		else if(i == super.getVar(5) || i == 0){
			Dialog[] d1 = new Dialog[1];
			d1[0] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"You are content with the way things are now./");
			super.Dialog(d1, 0, this.getId(), true);
		}
		else{
			super.setVar(15, i);
			Dialog[] d1 = new Dialog[1];
			d1[0] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"New Bathouse Aura given!/");
			super.Dialog(d1, 0, this.getId(), true);
		}
	}
	
	public boolean isSolid(int i){
		return true;
	}
}
