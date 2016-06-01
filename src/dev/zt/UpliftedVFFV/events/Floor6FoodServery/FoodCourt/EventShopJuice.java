package dev.zt.UpliftedVFFV.events.Floor6FoodServery.FoodCourt;



import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.TreeMap;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.gfx.ImageLoader;
import dev.zt.UpliftedVFFV.input.KeyManager;
import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.inventory.consumables.FruitJuiceBlue;
import dev.zt.UpliftedVFFV.inventory.consumables.FruitJuiceGreen;
import dev.zt.UpliftedVFFV.inventory.consumables.FruitJuicePurple;
import dev.zt.UpliftedVFFV.inventory.consumables.FruitJuiceRed;
import dev.zt.UpliftedVFFV.inventory.consumables.FruitJuiceYellow;
import dev.zt.UpliftedVFFV.party.Schmuck;



public class EventShopJuice extends Event {

	public BufferedImage shopKeeper = ImageLoader.loadImage("/CharacterBusts/ServeryMRedsmall.png");
	public TreeMap<Item, Integer> selection = new TreeMap<>();
	public ArrayList<Item> stuff = new ArrayList<Item>();
	public static int stagenum = 1;
	public EventShopJuice(float x, float y, int idnum) {
		super(Assets.Table6,idnum,x, y, stagenum);
		
	}
	
	public void run(){
		switch(this.getstage()){
		case 0:
			if(super.getQuest(10) == 3){
				Dialog[] d = new Dialog[5];
				d[0] = new Dialog("Employee","/CharacterBusts/ServeryMRedsmall.png",1,"Hello, would you like a ...");
				d[1] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"Blue Fruit Juice. Please.");
				d[2] = new Dialog("Operator","/CharacterBusts/Player-1.png",0,"Well, that should do it.");
				d[3] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",0,"Yes. I am grateful beyond words.");
				d[4] = new Dialog("Pen Pal","/CharacterBusts/Player-5.png",0,"Wait!/Look there!/Do you see that?");
				super.Dialog(d, 4, this.getId(), true);
			}
			else{
				getGoods();
				super.shop(this.getId(),selection,shopKeeper,7);
				this.setstage(0);
			}
			break;
		case 1:
			KeyManager.setCutsceneMode(true);
			super.getGamestate().getEvents()[752].setSelfswitch1(true);
			super.transport("/Worlds/Floor6FoodServery/FoodCourt/Eatery.txt",29,21,"");
			super.getGamestate().getEvents()[752].run();
			super.setQuest(10, 4);
			super.setQuest(11, 1);
			this.setstage(0);
			break;
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

		stuff.add(new FruitJuiceRed());
		stuff.add(new FruitJuiceBlue());
		stuff.add(new FruitJuiceGreen());
		stuff.add(new FruitJuiceYellow());
		stuff.add(new FruitJuicePurple());
		
		for(Item i : stuff){
			selection.put(i, (int)(i.value * (1 - discount)));
		}
	}
}
