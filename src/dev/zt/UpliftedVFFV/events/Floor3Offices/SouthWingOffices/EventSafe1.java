package dev.zt.UpliftedVFFV.events.Floor3Offices.SouthWingOffices;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.inventory.consumables.Charcoal;
import dev.zt.UpliftedVFFV.inventory.consumables.MedPak;
import dev.zt.UpliftedVFFV.states.GameState;

public class EventSafe1 extends Event {


	static BufferedImage img = Assets.SafeClosed;
	public static int stagenum = 0;
	public EventSafe1(float x, float y, int idnum) {
		super(img,idnum,x, y, stagenum);
	}
	
	public void run(){
		if(!this.isSelfswitch1()){
			Dialog[] d = new Dialog[4];
			d[0] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"You found some MedPaks inside the safe!/Always handy in case of Officeplace accidents!");
			d[1] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"Found some Charcoal too!/Looks like someone in the offices likes alternative medicine.");
			d[2] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"Medpaks and other items can be used from the menu ('Z') under the Consumable tab of your Inventory! They can also be used in combat under 'Items'!");
			d[3] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"They can also be used in combat under 'Items'!");
			super.Dialog(d, 3, this.getId(), true);
			super.loot(new MedPak(), 3);
			super.loot(new Charcoal(), 2);
			this.setTex(Assets.SafeOpened);
			this.setSelfswitch1(true);
		}
	}
	
	public void tick(GameState gs){
		if(!this.isSelfswitch1()){
			this.setFrames(this.getFrames()+1);
			if(this.getFrames()>=50){
				this.setFrames(0);
				if(this.isOpen()){
					this.setTex(Assets.SafeClosed);
					this.setOpen(false);
				}
				else{
					this.setTex(Assets.SafeClosed2);
					this.setOpen(true);
				}
			}
		}
		else{
			this.setTex(Assets.SafeOpened);
		}
	}
	
	public boolean isSolid(int i){
		return true;
	}
}
