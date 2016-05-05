package dev.zt.UpliftedVFFV.events.EventsCommon;



import java.awt.image.BufferedImage;
import java.util.ArrayList;
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
import dev.zt.UpliftedVFFV.party.Schmuck;



public class EventJanitor1 extends Event {

	public String[] Choices={"Save","Shop","Never Mind"};
	public static int stagenum = 2;
	public BufferedImage shopKeeper = ImageLoader.loadImage("/CharacterBusts/Janitor2small.png");
	public TreeMap<Item, Integer> selection = new TreeMap<>();
	public ArrayList<Item> stuff = new ArrayList<Item>();
	public static BufferedImage img=SpriteSorter.SpriteSort(1,Assets.Wiper);
	public EventJanitor1(float x, float y, int idnum) {
		super(img,idnum,x, y, stagenum);
					
	}
	
	public void run(){
		if (Player.runlast==0){
			this.setTex(SpriteSorter.SpriteSort(1,Assets.Wiper));
		}
		if (Player.runlast==1){
			this.setTex(SpriteSorter.SpriteSort(10,Assets.Wiper));
		}
		if (Player.runlast==2){
			this.setTex(SpriteSorter.SpriteSort(7,Assets.Wiper));
		}
		if (Player.runlast==3){
			this.setTex(SpriteSorter.SpriteSort(4,Assets.Wiper));
		}
		switch(this.getstage()){
		case 0: 
			if(!this.isSelfswitch1()){
				Dialog[] d = new Dialog[8];
				d[0] = new Dialog("Janitor","/CharacterBusts/Janitor2small.png",1,"Hmm? I don't believe we've met before.");
				d[1] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"Hello. I am the Operator. I was looking for Suite 521.");
				d[2] = new Dialog("Janitor","/CharacterBusts/Janitor2small.png",1,"Oh. Sadly I've never heard of the place before./But maybe I can provide you some other services . . .");
				d[3] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"What sort of . . . services?");
				d[4] = new Dialog("Janitor","/CharacterBusts/Janitor2small.png",1,"I am the humble janitor of this facility, but I also do all manner of odd jobs too.");
				d[5] = new Dialog("Janitor","/CharacterBusts/Janitor2small.png",1,"Well, mostly I run my own little business. Y'know, just to make a bit of money on the side. Feel free to purchase anything that interests you.");
				d[6] = new Dialog("Janitor","/CharacterBusts/Janitor2small.png",1,"Just don't mention anything to Management.");
				d[7] = new Dialog("Janitor","/CharacterBusts/Janitor2small.png",1,"Oh, and if you ever need your game saved, come to me and I can help./Free of charge!");
				super.Dialog(d, 7, this.getId(), true);
				this.setSelfswitch1(true);
			}
			else{
				Dialog[] d = new Dialog[1];
				d[0] = new Dialog("Janitor","/CharacterBusts/Janitor2small.png",1,"Well, if it isn't my favorite customer.");
				super.Dialog(d, 0, this.getId(), true);
				}
			break;
		case 1:
			Dialog[] d = new Dialog[1];
			d[0] = new Dialog("Janitor","/CharacterBusts/Janitor2small.png",1,"So, what'll it be?");
			super.Dialog(d, 0, this.getId(), true);
			super.ChoiceBranch(this.getId(), Choices, 150);
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
			super.Save(this.getId());
			this.setstage(2);
			break;
		case 1:
			getGoods();
			super.shop(this.getId(),selection,shopKeeper);
			this.setstage(2);
			break;
		case 2:
			Dialog[] d = new Dialog[1];
			d[0] = new Dialog("Janitor","/CharacterBusts/Janitor2small.png",1,"See you again soon.");
			super.Dialog(d, 0, this.getId(), true);
			this.setstage(2);
			break;
		}
	}
	
	public void getGoods(){
		double discount = 0;
		for(Schmuck s : gamestate.partymanager.party){
			discount += s.getDiscountBonus();
		}
		if(super.getVar(12) >= 1){
			stuff.add(new MedPak());
			stuff.add(new CaffeinePatch());
			stuff.add(new SmellingSalt());
			
		}
		if(super.getVar(12) >= 3){
			stuff.add(new SummonSauce());
			stuff.add(new SleepingPills());
		}
		for(Item i : stuff){
			selection.put(i, (int)(i.value * (1 - discount)));
		}
	}
}
