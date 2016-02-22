package dev.zt.UpliftedVFFV.events.Floor2Bathhouse;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.Special.BathHouseIntrinsic;

public class EventAda extends Event {

	public String[] Choices={"Yeah, sure","Nah, I'm good"};			//list of choices used in the choicebranch
	public static int stagenum = 1;
	//Change texture later
	public static BufferedImage img=Assets.Monolith;
	public EventAda(float x, float y, int idnum) {
		super(img,idnum,x, y, stagenum);
	}
	
	public void run(){	
		switch(this.getstage()){
		case 0: 
			if(!this.isSelfswitch1()){
				this.setSelfswitch1(true);
				Dialog[] d1 = new Dialog[1];
				d1[0] = new Dialog("Ada","/CharacterBusts/Adasmall.png",1,"Welcome to the Bathhouse, fellow employee!/Is this your first time visiting?/");
				d1[1] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"/");
				super.Dialog(d1, 0, this.getId(), true);
			}
			else{
				Dialog[] d1 = new Dialog[1];
				d1[0] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"<more text>./");
				super.Dialog(d1, 0, this.getId(), true);
			}
			break;		
		case 1:
			Dialog[] d1 = new Dialog[1];
			d1[0] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"<TEMP>");
			super.Dialog(d1, 0, this.getId(), true);
			super.ChoiceBranch(this.getId(), Choices, 100);
			break;
		}
	}

	public void ChoiceMade(int i){
		if(i == 0){
			for(Schmuck s : super.getGamestate().getPartymanager().getParty()){
				s.setCurrentHp(s.getMaxHp());
				s.setCurrentBp(s.getMaxBp());
			}
			Dialog[] d1 = new Dialog[1];
			d1[0] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"Your party feels healthy and refreshed.");
			super.Dialog(d1, 0, this.getId(), true);
		}
	}
	
	public boolean isSolid(int i){
		return true;
	}
}
