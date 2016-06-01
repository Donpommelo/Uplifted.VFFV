package dev.zt.UpliftedVFFV.events.Floor6FoodServery.FoodCourt;



import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.TreeMap;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.gfx.ImageLoader;
import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.inventory.misc.SummonSauce;
import dev.zt.UpliftedVFFV.party.Schmuck;



public class EventShopSauce extends Event {

	public BufferedImage shopKeeper = ImageLoader.loadImage("/CharacterBusts/ServeryFBluesmall.png");
	public TreeMap<Item, Integer> selection = new TreeMap<>();
	public ArrayList<Item> stuff = new ArrayList<Item>();
	public static int stagenum = 0;
	public EventShopSauce(float x, float y, int idnum) {
		super(Assets.Table6,idnum,x, y, stagenum);
		
	}
	
	public void run(){
//		super.Dialog(168, 168,this.getId());
		if(super.getQuest(10) == 3){
			//Set Waitress event to loaded and visible
			//Transport self to same square
			//Run waitress event
			super.setQuest(10, 4);
			super.setQuest(11, 1);
		}
		else{
			getGoods();
			super.shop(this.getId(),selection,shopKeeper,9);
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
		
		stuff.add(new SummonSauce());
		
		
		for(Item i : stuff){
			selection.put(i, (int)(i.value * (1 - discount)));
		}
	}
}
