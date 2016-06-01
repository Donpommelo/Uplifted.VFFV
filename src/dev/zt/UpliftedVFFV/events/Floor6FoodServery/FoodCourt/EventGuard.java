package dev.zt.UpliftedVFFV.events.Floor6FoodServery.FoodCourt;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.entities.creatures.Player;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.events.SpriteSorter;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.inventory.consumables.Lachiplatre;
import dev.zt.UpliftedVFFV.inventory.keyitems.WaiterTray;

public class EventGuard extends Event {

	public static int stagenum = 1;
	public static BufferedImage img=SpriteSorter.SpriteSort(7,Assets.EmployeeM1);
	public EventGuard(float x, float y, int idnum) {
		super(img,idnum,x, y, stagenum);
	}
	
	public void run(){
		if (Player.runlast==0){
			this.setTex(SpriteSorter.SpriteSort(1,Assets.EmployeeM1));
		}
		if (Player.runlast==1){
			this.setTex(SpriteSorter.SpriteSort(10,Assets.EmployeeM1));
		}
		if (Player.runlast==2){
			this.setTex(SpriteSorter.SpriteSort(7,Assets.EmployeeM1));
		}
		if (Player.runlast==3){
			this.setTex(SpriteSorter.SpriteSort(4,Assets.EmployeeM1));
		}
		switch(this.getstage()){
		case 0:
			if(super.getQuest(11) == 0){
				Dialog[] d = new Dialog[1];
				d[0] = new Dialog("Guard","/CharacterBusts/SecurityGuardsmall.png",1,"Only authorized personnel are allowed beyond that door behind me.");
				super.Dialog(d, 0, this.getId(), true);
			}
			else{
				if(super.itemNumCheck(new Lachiplatre()) == 0){
					Dialog[] d = new Dialog[5];
					d[0] = new Dialog("Guard","/CharacterBusts/SecurityGuardsmall.png",1,"What room are you delivering to?");
					d[1] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"Suite 521.");
					d[2] = new Dialog("Guard","/CharacterBusts/SecurityGuardsmall.png",1,"Hmm, alright./Let me check your order.");
					d[3] = new Dialog("Guard","/CharacterBusts/SecurityGuardsmall.png",1,"Huh. You must have gotten mixed up./Suite 521 doesn't order anything except Lachiplatre.");
					d[4] = new Dialog("Guard","/CharacterBusts/SecurityGuardsmall.png",1,"Why don't you check with your superiors to get that order sorted out?");
					super.Dialog(d, 4, this.getId(), true);
				}
				else{
					if(!this.isSelfswitch1()){
						Dialog[] d = new Dialog[6];
						d[0] = new Dialog("Guard","/CharacterBusts/SecurityGuardsmall.png",1,"What room are you delivering to?");
						d[1] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"Suite 521.");
						d[2] = new Dialog("Guard","/CharacterBusts/SecurityGuardsmall.png",1,"Hmm, alright./Let me check your order.");
						d[3] = new Dialog("Guard","/CharacterBusts/SecurityGuardsmall.png",1,"Yeah, more Lachiplatre./Sounds about right./Well, go right on ahead.");
						d[4] = new Dialog("Guard","/CharacterBusts/SecurityGuardsmall.png",1,"Oh yeah, you forgot your Waiter Tray./Lucky you. I have a spare.");
						d[5] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"Obtained Waiter's Tray!");
						super.Dialog(d, 5, this.getId(), true);
						this.setSelfswitch1(true);
						super.loot(new WaiterTray(), 1);

					}
					else{
						Dialog[] d = new Dialog[1];
						d[0] = new Dialog("Guard","/CharacterBusts/SecurityGuardsmall.png",1,"Hey!/Don't you have a delivery to be making?");
						super.Dialog(d, 0, this.getId(), true);
					}
				}
			}
			
			break;
		case 1:
			this.setTex(SpriteSorter.SpriteSort(7,Assets.EmployeeM1));
			this.setstage(0);
			break;
			
		}
	}
	
	
	public boolean isSolid(int i){
		return true;
	}
		
}
