package dev.zt.UpliftedVFFV.events.Floor3Offices.SouthWingOffices;



import java.awt.image.BufferedImage;
import java.util.TreeMap;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.entities.creatures.Player;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.events.SpriteSorter;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.gfx.ImageLoader;
import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.inventory.consumables.CaffeinePatch;
import dev.zt.UpliftedVFFV.inventory.consumables.MedPak;
import dev.zt.UpliftedVFFV.inventory.consumables.SmellingSalt;
import dev.zt.UpliftedVFFV.inventory.misc.SleepingPills;
import dev.zt.UpliftedVFFV.inventory.misc.SummonSauce;



public class EventJanitor1 extends Event {

	public String[] Choices={"Save","Shop","Never Mind"};
	public static int stagenum = 2;
	public BufferedImage shopKeeper = ImageLoader.loadImage("/CharacterBusts/Janitor1small.png");
	public TreeMap<Item, Integer> selection = new TreeMap<>();
	public static BufferedImage img=SpriteSorter.SpriteSort(1,Assets.Wiper);
	public EventJanitor1(float x, float y, int idnum) {
		super(img,idnum,x, y, stagenum);

					
	}
	
	public void run(){
		if (Player.runlast==0){
			Event.events[this.getId()].setTex(SpriteSorter.SpriteSort(1,Assets.Wiper));
		}
		if (Player.runlast==1){
			Event.events[this.getId()].setTex(SpriteSorter.SpriteSort(10,Assets.Wiper));
		}
		if (Player.runlast==2){
			Event.events[this.getId()].setTex(SpriteSorter.SpriteSort(7,Assets.Wiper));
		}
		if (Player.runlast==3){
			Event.events[this.getId()].setTex(SpriteSorter.SpriteSort(4,Assets.Wiper));
		}
		switch(this.getstage()){
		case 0: 
			if(!this.isSelfswitch1()){
				Dialog[] d = new Dialog[7];
				d[0] = new Dialog("Janitor","/CharacterBusts/Janitor1small.png",1,"Hmm? I don't believe we've met before./");
				d[1] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"Hello. I am the Operator. I was looking for Suite 521./");
				d[2] = new Dialog("Janitor","/CharacterBusts/Janitor1small.png",1,"Oh. Sadly I've never heard of the place before./But maybe I can provide you some other services. . ./");
				d[3] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"What sort of . . .services?/");
				d[4] = new Dialog("Janitor","/CharacterBusts/Janitor1small.png",1,"I am the humble janitor of this facility, but I also do all manner of odd jobs too./");
				d[5] = new Dialog("Janitor","/CharacterBusts/Janitor1small.png",1,"Well, mostly I run my own little business. Y'know, just to make a bit of money on the side./Feel free to purchase anything that interests you./Just don't mention anything to Management./");
				d[6] = new Dialog("Janitor","/CharacterBusts/Janitor1small.png",1,"Oh, and if you ever need your game saved, come to me and I can help./Free of charge!/");
				super.Dialog(d, 6, this.getId(), true);
				this.setSelfswitch1(true);
			}
			else{
				Dialog[] d = new Dialog[1];
				d[0] = new Dialog("Janitor","/CharacterBusts/Janitor1small.png",1,"Well, if it isn't my favorite customer./");
				super.Dialog(d, 0, this.getId(), true);
				}
			break;
		case 1:
			Dialog[] d = new Dialog[1];
			d[0] = new Dialog("Janitor","/CharacterBusts/Janitor1small.png",1,"So, what'll it be?/");
			super.Dialog(d, 0, this.getId(), true);
			super.ChoiceBranch(this.getId(), Choices);
			break;
		case 2:
			this.setstage(0);
			break;
		}
	}
	
	public boolean isSolid(int i){
		return true;
	}

	public void ChoiceMade(int i){
		switch(i){
		case 0:
			this.setstage(2);
			break;
		case 1:
			getGoods();
			super.shop(this.getId(),selection,shopKeeper);
			this.setstage(2);
			break;
		case 2:
			Dialog[] d = new Dialog[1];
			d[0] = new Dialog("Janitor","/CharacterBusts/Janitor1small.png",1,"See you again soon./");
			super.Dialog(d, 0, this.getId(), true);
			this.setstage(2);
			break;
		}
	}
	
	public void getGoods(){
		if(super.getVar(12) >= 1){
			selection.put(new MedPak(), 1);
			selection.put(new CaffeinePatch(),2);
			selection.put(new SmellingSalt(), 5);
			
		}
		if(super.getVar(12) >= 3){
			selection.put(new SummonSauce(), 5);
			selection.put(new SleepingPills(), 6);
		}
	}
}
