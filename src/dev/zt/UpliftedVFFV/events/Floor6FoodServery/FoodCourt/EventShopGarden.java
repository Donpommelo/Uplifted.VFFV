package dev.zt.UpliftedVFFV.events.Floor6FoodServery.FoodCourt;



import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.TreeMap;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.gfx.ImageLoader;
import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.inventory.consumables.WatercressSoup;
import dev.zt.UpliftedVFFV.party.Schmuck;



public class EventShopGarden extends Event {

	public BufferedImage shopKeeper = ImageLoader.loadImage("/CharacterBusts/ServeryFGreensmall.png");
	public TreeMap<Item, Integer> selection = new TreeMap<>();
	public ArrayList<Item> stuff = new ArrayList<Item>();
	public static int stagenum = 0;
	public EventShopGarden(float x, float y, int idnum) {
		super(Assets.Table8,idnum,x, y, stagenum);
		
	}
	
	public void run(){
		if(super.getQuest(10) == 2){
			if(super.getGamestate().Script >= 20){
				super.setQuest(10, 3);
				super.scriptChange(-20);
				Dialog[] d = new Dialog[8];
				d[0] = new Dialog("Employee","/CharacterBusts/3rdSouthOffices-1.png",1,"Hey, pal./What can I get you?");
				d[1] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"One bowl of Watercress Soup, please.");
				d[2] = new Dialog("Employee","/CharacterBusts/3rdSouthOffices-1.png",1,"Alrighty, that'll be 20 Script!/Here ya go!");
				d[3] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",0,"Excellent!");
				d[4] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",0,"Well.../I hate to ask so much but ...");
				d[5] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",0,"Well, I could really use a Blue Fruit Juice./I’ve been adrift for so long and I think the saltwater has been taxing on my liver.");
				d[6] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"And then we're done, right?");
				d[7] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",0,"I guarantee it!");
				super.Dialog(d, 7, this.getId(), true);
			}
			else{
				Dialog[] d = new Dialog[4];
				d[0] = new Dialog("Employee","/CharacterBusts/3rdSouthOffices-1.png",1,"Hey, pal./What can I get you?");
				d[1] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"One bowl of Watercress Soup, please.");
				d[2] = new Dialog("Employee","/CharacterBusts/3rdSouthOffices-1.png",1,"Alrighty, that'll be 20 Script!/Here ya go!");
				d[3] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"Oh drat. I don't have enough./I better come back later.");
				super.Dialog(d, 3, this.getId(), true);
			}
		}
		else{
			getGoods();
			super.shop(this.getId(),selection,shopKeeper,11);
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

		stuff.add(new WatercressSoup());
		
		for(Item i : stuff){
			selection.put(i, (int)(i.value * (1 - discount)));
		}
	}
}
