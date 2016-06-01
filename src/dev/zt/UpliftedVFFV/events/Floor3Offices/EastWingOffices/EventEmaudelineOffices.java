package dev.zt.UpliftedVFFV.events.Floor3Offices.EastWingOffices;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.entities.creatures.Player;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.events.SpriteSorter;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.inventory.keyitems.ManilaFolder;
import dev.zt.UpliftedVFFV.inventory.keyitems.SummonConch;
import dev.zt.UpliftedVFFV.inventory.misc.SummonSauce;



public class EventEmaudelineOffices extends Event {

	public boolean fightwon=false;
	public static int stagenum = 0;
	public static BufferedImage img=SpriteSorter.SpriteSort(1,Assets.Emaudeline);
	public EventEmaudelineOffices(float x, float y, int idnum) {
		super(img,idnum,x, y, stagenum);
	}
	
	public void run(){
		if (Player.runlast==0){
			this.setTex(SpriteSorter.SpriteSort(1,Assets.Emaudeline));
		}
		if (Player.runlast==1){
			this.setTex(SpriteSorter.SpriteSort(10,Assets.Emaudeline));
		}
		if (Player.runlast==2){
			this.setTex(SpriteSorter.SpriteSort(7,Assets.Emaudeline));
		}
		if (Player.runlast==3){
			this.setTex(SpriteSorter.SpriteSort(4,Assets.Emaudeline));
		}
		if(!this.isSelfswitch1()){
			Dialog[] d = new Dialog[14];
			d[0] = new Dialog("Emaudeline","/CharacterBusts/Emaudeline1small.png",1,"Hello there. You are looking for something, right?/Yes, I can see it in your eyes.");
			d[1] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,". . . Yes, we were looking for Suite 521 before we got distracted. Do you know where that is?");
			d[2] = new Dialog("Emaudeline","/CharacterBusts/Emaudeline1small.png",1,"I'm afraid not./I suppose that makes two of us then.");
			d[3] = new Dialog("Emaudeline","/CharacterBusts/Emaudeline1small.png",1,"I too, am in pursuit of that which remains to be found. Perhaps you know of the Central Light?");
			d[4] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,". . .");
			d[5] = new Dialog("Emaudeline","/CharacterBusts/Emaudeline1small.png",1,"No? Hmm. Oh well. It's a wonderful thing, really. The Central Light serves as the source of all the light in the building! The very light we are using right now to see each other!");
			d[6] = new Dialog("Emaudeline","/CharacterBusts/Emaudeline1small.png",1,"Think of it as the building's generator! Every company has one.");
			d[7] = new Dialog("Emaudeline","/CharacterBusts/Emaudeline1small.png",1,"From it, streams of radiance are formed there to be distributed to the rest of the building through millions of intricate prisms!");
			d[8] = new Dialog("Emaudeline","/CharacterBusts/Emaudeline1small.png",1,"That's why this building has no ceilings.");
			d[9] = new Dialog("Emaudeline","/CharacterBusts/Emaudeline1small.png",1,"Say, why don't we cooperate? Yes, us . . . purposeful employees ought to stick together.");
			d[10] = new Dialog("Emaudeline","/CharacterBusts/Emaudeline1small.png",1,"If you find the Light, do find a way to tell me. And if I come across this Suite 521, you will be the first to know.");
			d[11] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,". . .");
			d[12] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,". . . Sure.");
			d[13] = new Dialog("Emaudeline","/CharacterBusts/Emaudeline1small.png",1,"Stellar!/An extra pair of eyes is always appreciated!");
			super.Dialog(d, 13, this.getId(), true);
			super.setQuest(4, 1);
			this.setSelfswitch1(true);
		}
		else{
			Dialog[] d = new Dialog[12];
			d[0] = new Dialog("Emaudeline","/CharacterBusts/Emaudeline1small.png",1,"May good fortune light both our ways.");
			super.Dialog(d, 0, this.getId(), true);
		}
			
	}
	
	public boolean loaded(){
		if(super.getQuest(4) == 0){
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean isSolid(int i){
		return true;
	}
		
}
