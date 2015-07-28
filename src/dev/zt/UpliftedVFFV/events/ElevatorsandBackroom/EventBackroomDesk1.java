package dev.zt.UpliftedVFFV.events.ElevatorsandBackroom;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.gfx.ImageLoader;
import dev.zt.UpliftedVFFV.inventory.PostageStamp;
import dev.zt.UpliftedVFFV.states.StateManager;

public class EventBackroomDesk1 extends Event {

	public boolean selfswitch1=false;
	public String[] Choices={"Yes","No"};
	private int stage = 0;
	public EventBackroomDesk1(float x, float y, int idnum) {
		super(Assets.WritingDesk1,idnum,x, y);
		stage = 0;
	}
	
	public void run(){
		switch(stage){
			case 0:
				if(!super.getSwitch(3)){
					Dialog[] d = new Dialog[1];
		/*			if(super.itemNumCheck(new PostageStamp()) == 0){
						d[0] = new Dialog("meep",ImageLoader.loadImage("/CharacterBusts/Arturo.png"),0,"You don't have any Postage Stamps./");
						super.Dialog(d,0, this.getId());
					}*/
		//			else{
						d[0] = new Dialog("meep", ImageLoader.loadImage("/CharacterBusts/Arturo.png"), 0, "Write to your Pen Pal?/" +
						"Stamps Remaining: " + super.itemNumCheck(new PostageStamp()) + "/");
						super.Dialog(d, 0, this.getId(), false);
						super.ChoiceBranch(this.getId(), Choices);
					}	
		//		}
				else{
					super.Dialog(164, 164, this.getId());
				}
				break;
			case 1:
				super.Notification("   You don't have the stamps!  ", this.getId());
				stage = 0;
				break;
		}
	}
	
	public void ChoiceMade(int i){
		switch(i){
		case 0:
			if(super.itemNumCheck(new PostageStamp()) > 0){
				StateManager.getStates().pop();
				super.PenPalState();
			} else{
				stage = 1;
				this.run();
			}
			break;
		case 1:
			//Pop off the dialogue state.
			StateManager.getStates().pop();
			break;
		}
	}
	
	public boolean isSolid(int i){
		return true;
	}
}
