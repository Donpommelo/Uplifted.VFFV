package dev.zt.UpliftedVFFV.events.Floor6FoodServery.FoodCourt;



import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.TreeMap;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.gfx.ImageLoader;
import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.inventory.consumables.CrystalDumplings;
import dev.zt.UpliftedVFFV.party.Schmuck;



public class EventShopRedJujube extends Event {

	public BufferedImage shopKeeper = ImageLoader.loadImage("/CharacterBusts/ServeryFBluesmall.png");
	public TreeMap<Item, Integer> selection = new TreeMap<>();
	public ArrayList<Item> stuff = new ArrayList<Item>();
	public static int stagenum = 0;
	public EventShopRedJujube(float x, float y, int idnum) {
		super(Assets.Table8,idnum,x, y, stagenum);
		
	}
	
	public void run(){
		if(super.getQuest(10) == 1){
			if(super.getGamestate().Script >= 15){
				super.setQuest(10, 2);
				super.scriptChange(-15);
				Dialog[] d = new Dialog[7];
				d[0] = new Dialog("Employee","/CharacterBusts/3rdSouthOffices-1.png",1,"Welcome to the Red Jujube./How may I serve you today?");
				d[1] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"One order of Crystal Dumplings please.");
				d[2] = new Dialog("Employee","/CharacterBusts/3rdSouthOffices-1.png",1,"That will be 15 Script.");
				d[3] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",0,"Mmmmm. I can practically taste it already.");
				d[4] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",0,"Say, now that we are already here, could you get me some Watercress Soup?");
				d[5] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",0,"That has already been invented, right?");
				d[6] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"I think so.");
				super.Dialog(d, 6, this.getId(), true);
			}
			else{
				Dialog[] d = new Dialog[4];
				d[0] = new Dialog("Employee","/CharacterBusts/3rdSouthOffices-1.png",1,"Welcome to the Red Jujube./How may I serve you today?");
				d[1] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"One order of Crystal Dumplings please.");
				d[2] = new Dialog("Employee","/CharacterBusts/3rdSouthOffices-1.png",1,"That will be 15 Script.");
				d[3] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"Oh drat. I don't have enough./I better come back later.");
				super.Dialog(d, 3, this.getId(), true);
			}
		}
		else{
			getGoods();
			super.shop(this.getId(),selection,shopKeeper,8);
		}
	}

	public boolean isSolid(int i){
		return true;
	}
	
	public void getGoods(){
		double discount = 0;
		for(Schmuck s : gamestate.partymanager.party){
			discount += s.getDiscountBonus();
		}

		stuff.add(new CrystalDumplings());
		
		for(Item i : stuff){
			selection.put(i, (int)(i.value * (1 - discount)));
		}
	}
}
