package dev.zt.UpliftedVFFV.events.Floor3Offices.WestWingOffices;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.inventory.equipables.AnchorTalisman;
import dev.zt.UpliftedVFFV.states.GameState;

public class EventSafe12 extends Event {


	static BufferedImage img = Assets.SafeClosed;
	public static int stagenum = 0;
	public EventSafe12(float x, float y, int idnum) {
		super(img,idnum,x, y, stagenum);
	}
	
	public void run(){
		if(!this.isSelfswitch1()){
			Dialog[] d = new Dialog[4];
			d[0] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"You open the safe. . ./");
			d[1] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"The crate is filled with . . . water?/");
			d[2] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"You find a strange pendant submerged at the bottom./");
			d[3] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"Obtained Anchor Talisman!/");
			super.Dialog(d, 3, this.getId(), true);
			super.loot(new AnchorTalisman(), 1);
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
