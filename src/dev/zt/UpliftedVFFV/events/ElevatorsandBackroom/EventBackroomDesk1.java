package dev.zt.UpliftedVFFV.events.ElevatorsandBackroom;



import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.inventory.FishWater;



public class EventBackroomDesk1 extends Event {

	public boolean selfswitch1=false;
	public String[] Choices={"Yes","No"};			
	public EventBackroomDesk1(float x, float y, int idnum) {
		super(Assets.WritingDesk1,idnum,x, y);
	}
	

	
	public void run(){
		if(super.getSwitch(3)){
			super.ChoiceBranch(this.getId(), Choices);
		}
		else{
			super.Dialog(164, 164,this.getId());
		}
	}
	
	public void ChoiceMade(int i){
		switch(i){
		case 0:
			super.PenPalState();
			break;
		case 1:
			super.Dialog(93,93,this.getId());
			break;
		}
	}
	
	public boolean isSolid(int i){
		return true;
	}
}
