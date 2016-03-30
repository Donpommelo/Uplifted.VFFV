package dev.zt.UpliftedVFFV.events.Floor2Bathhouse;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.input.KeyManager;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class EventBathhouseManager extends Event {

	public String[] Choices={"Yeah, sure","Nah, I'm good"};			//list of choices used in the choicebranch
	public static int stagenum = 6;
	//Change texture later
	public static BufferedImage img=Assets.White;
	public EventBathhouseManager(float x, float y, int idnum) {
		super(img,idnum,x, y, stagenum);
	}
	
	public void run(){	
		switch(this.getstage()){
		case 0: 
			if(!this.isSelfswitch1()){
				this.setSelfswitch1(true);
				Dialog[] d1 = new Dialog[5];
				d1[0] = new Dialog("Bathhouse Manager","/CharacterBusts/BathManagersmall.png",1,"Welcome to the Bathhouse, fellow employee!/Is this your first time visiting?");
				d1[1] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"I believe so . . .");
				d1[2] = new Dialog("Bathhouse Manager","/CharacterBusts/BathManagersmall.png",1,"Our company has a free spa usage policy for Employees! I'm sure you remember it from when you first applied for this job!");
				d1[3] = new Dialog("Bathhouse Manager","/CharacterBusts/BathManagersmall.png",1,"Whenever you're feeling down or stressed out, stop by and enjoy the regenerative properties of a hot bath!");
				d1[4] = new Dialog("Bathhouse Manager","/CharacterBusts/BathManagersmall.png",1,"So then, feel the need to unwind?");
				super.Dialog(d1, 4, this.getId(), true);
			}
			else{
				Dialog[] d1 = new Dialog[1];
				d1[0] = new Dialog("Bathhouse Manager","/CharacterBusts/BathManagersmall.png",1,"Hey, Operator. Here for the Spa?");
				super.Dialog(d1, 0, this.getId(), true);
			}
			break;		
		case 1:
			Dialog[] d1 = new Dialog[1];
			d1[0] = new Dialog("Bathhouse Manager","/CharacterBusts/BathManagersmall.png",1,"Use Bath? (Fully restore party)");
			super.Dialog(d1, 0, this.getId(), true);
			super.ChoiceBranch(this.getId(), Choices, 180);
			break;
		case 2:
			super.fade(-1, this.getId());
			break;
		case 3:
			super.Timer(this.getId(), 50);
			break;
		case 4:
			this.fade(1, this.getId());
			break;
		case 5:
			KeyManager.setCutsceneMode(false);
			Dialog[] d2 = new Dialog[1];
			d2[0] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"Your party feels healthy and refreshed.");
			super.Dialog(d2, 0, this.getId(), true);
			this.setstage(5);
			break;
		case 6:
			this.setstage(0);
			break;
		}
	}

	public void ChoiceMade(int i){
		if(i == 0){
			for(Schmuck s : super.getGamestate().getPartymanager().getParty()){
				s.setCurrentHp(s.getMaxHp());
				s.setCurrentBp(s.getMaxBp());
				for(status st: s.statuses){
					if(!st.perm){
						s.statuses.remove(st);
					}
				}
			}
			KeyManager.setCutsceneMode(true);
			this.setstage(2);
			this.run();
		}
		else{
			Dialog[] d1 = new Dialog[1];
			d1[0] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"Maybe next time.");
			super.Dialog(d1, 0, this.getId(), true);
			this.setstage(5);
		}
		
	}
	
	public boolean isSolid(int i){
		return true;
	}
}
