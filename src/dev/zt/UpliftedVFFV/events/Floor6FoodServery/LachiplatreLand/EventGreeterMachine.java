package dev.zt.UpliftedVFFV.events.Floor6FoodServery.LachiplatreLand;


import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.inventory.keyitems.OldUmbrella;

public class EventGreeterMachine extends Event {

	public boolean fightwon=false;
	public static int stagenum = 0;
	public EventGreeterMachine(float x, float y, int idnum) {
		super(Assets.Monolith,idnum,x, y, stagenum);
	}
	
	public void run(){
		if(!this.isSelfswitch1()){
			Dialog[] d = new Dialog[7];
			d[0] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"This must be the Greeter Machine that the Informant was talking about.");
			d[1] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",0,"Greeter Machine?/Why is it so far from the entrance of the area?");
			d[2] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"It looks broken.");
			d[3] = new Dialog("meep","/CharacterBusts/Arturo.png",0,"The machine suddenly whirls to life...");
			d[4] = new Dialog("meep","/CharacterBusts/Arturo.png",0,"Before sputtering and shutting down again!");
			d[5] = new Dialog("meep","/CharacterBusts/Arturo.png",0,"A hidden compartment in the back of the device opens to reveal a hidden item!");
			d[6] = new Dialog("meep","/CharacterBusts/Arturo.png",0,"Obtained the Old Umbrella!");
			super.setQuest(3, 4);
			this.setSelfswitch1(true);
			super.Dialog(d, 6, this.getId(), true);
			super.loot(new OldUmbrella(), 1);
		}
		else{
			Dialog[] d = new Dialog[1];
			d[0] = new Dialog("meep","/CharacterBusts/Arturo.png",0,"A broken Greeter Machine./There is nothing more to do here.");

			super.Dialog(d, 0, this.getId(), true);
			
		}
			
	}
	
	public boolean isSolid(int i){
		return true;
	}
		
}
