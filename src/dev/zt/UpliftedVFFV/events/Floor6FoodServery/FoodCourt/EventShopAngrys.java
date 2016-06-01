package dev.zt.UpliftedVFFV.events.Floor6FoodServery.FoodCourt;



import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.TreeMap;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.gfx.ImageLoader;
import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.inventory.consumables.AngryBeef;
import dev.zt.UpliftedVFFV.inventory.consumables.BeefBoyle;
import dev.zt.UpliftedVFFV.inventory.consumables.BeefUnwell;
import dev.zt.UpliftedVFFV.party.Schmuck;



public class EventShopAngrys extends Event {

	public BufferedImage shopKeeper = ImageLoader.loadImage("/CharacterBusts/ServeryMRedsmall.png");
	public TreeMap<Item, Integer> selection = new TreeMap<>();
	public ArrayList<Item> stuff = new ArrayList<Item>();
	public static int stagenum = 0;
	public EventShopAngrys(float x, float y, int idnum) {
		super(Assets.Table8,idnum,x, y, stagenum);
		
	}
	
	public void run(){
		getGoods();
		super.shop(this.getId(),selection,shopKeeper,3);
	}

	public boolean isSolid(int i){
		return true;
	}
	
	public void getGoods(){
		double discount = 0;
		for(Schmuck s : gamestate.partymanager.party){
			discount += s.getDiscountBonus();
		}
		stuff.add(new AngryBeef());
		stuff.add(new BeefUnwell());
		stuff.add(new BeefBoyle());

		
		for(Item i : stuff){
			selection.put(i, (int)(i.value * (1 - discount)));
		}
	}
	
	public String shopOpen(){
		return "Welcome to Angry's!";
	}
}
