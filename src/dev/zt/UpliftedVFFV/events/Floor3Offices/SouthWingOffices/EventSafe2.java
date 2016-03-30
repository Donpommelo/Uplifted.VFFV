package dev.zt.UpliftedVFFV.events.Floor3Offices.SouthWingOffices;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.inventory.misc.LaserPointer;
import dev.zt.UpliftedVFFV.states.GameState;

public class EventSafe2 extends Event {

	public String[] Choices={"Yes","No"};			//list of choices used in the choicebranch
	static BufferedImage img = Assets.SafeClosed;
	public static int stagenum = 0;
	public EventSafe2(float x, float y, int idnum) {
		super(img,idnum,x, y, stagenum);
	}
	
	public void run(){
		if(!this.isSelfswitch1()){
			Dialog[] d = new Dialog[2];
			d[0] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"The safe is filled with confiscated distractions.");
			d[1] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"You grab a Laser Pointer before anyone notices.");
			super.Dialog(d, 1, this.getId(), true);
			super.loot(new LaserPointer(), 1);
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
