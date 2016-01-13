package dev.zt.UpliftedVFFV.events.Floor3Offices.SouthWingOffices;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.inventory.consumables.FireExtinguisher;
import dev.zt.UpliftedVFFV.states.GameState;

public class EventSafe2 extends Event {


	static BufferedImage img = Assets.SafeClosed;
	public static int frame;
	public static boolean blinking;
	public static int stagenum = 0;
	public EventSafe2(float x, float y, int idnum) {
		super(img,idnum,x, y, stagenum);
		frame = 0;
		blinking = false;
	}
	
	public void run(){
		if(!this.isSelfswitch1()){
			Dialog[] d = new Dialog[1];
			d[0] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"Found a couple of Fire Extinguishers inside!/Surely that violates some sort of safety regulation. . ./");
			super.Dialog(d, 0, this.getId(), true);
			super.loot(new FireExtinguisher(), 2);
			this.setTex(Assets.SafeOpened);
			this.setSelfswitch1(true);
		}
	}
	
	public void tick(GameState gs){
		if(!this.isSelfswitch1()){
			frame++;
			if(frame>=50){
				frame = 0;
				if(blinking){
					this.setTex(Assets.SafeClosed);
					blinking = false;
				}
				else{
					this.setTex(Assets.SafeClosed2);
					blinking = true;
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
