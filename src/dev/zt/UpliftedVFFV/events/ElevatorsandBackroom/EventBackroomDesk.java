package dev.zt.UpliftedVFFV.events.ElevatorsandBackroom;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.inventory.misc.PostageStamp;

public class EventBackroomDesk extends Event {

	public boolean selfswitch1=false;
	public String[] Choices={"Yes","No"};
	public static int stagenum = 0;
	public EventBackroomDesk(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y, stagenum);
	}
	
	public void run(){
			if(super.getSwitch(3)){
				Dialog[] d = new Dialog[1];
				if(super.itemNumCheck(new PostageStamp()) == 0){
					d[0] = new Dialog("meep","/CharacterBusts/Arturo.png",0,"You don't have any Postage Stamps./");
					super.Dialog(d,0, this.getId(),true);
				}
				else{
					d[0] = new Dialog("meep","/CharacterBusts/Arturo.png", 0, "Write to your Pen Pal?/" +
					"Stamps Remaining: " + super.itemNumCheck(new PostageStamp()) + "/");
					super.Dialog(d, 0, this.getId(), true);
					super.ChoiceBranch(this.getId(), Choices);
				}	
			}
			else{
				Dialog[] d = new Dialog[1];
				d[0] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"An old Writing Desk./But you have nothing to write and no one to write to./");
				super.Dialog(d, 0, this.getId(), true);
//				super.ChoiceBranch(this.getId(), Choices);
			}
		
	}
	
	public void ChoiceMade(int i){
		switch(i){
		case 0:
			super.PenPalState();
			break;
		case 1:
			this.setstage(0);		
			break;
		}
	}
	
	public boolean isSolid(int i){
		return true;
	}
	
}
