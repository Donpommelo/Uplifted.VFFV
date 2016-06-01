package dev.zt.UpliftedVFFV.events.Floor6FoodServery.FoodCourt;



import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.TreeMap;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.gfx.ImageLoader;
import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.inventory.consumables.IceCreamAzukiBean;
import dev.zt.UpliftedVFFV.inventory.consumables.IceCreamMango;
import dev.zt.UpliftedVFFV.inventory.consumables.IceCreamMatcha;
import dev.zt.UpliftedVFFV.inventory.consumables.IceCreamPlum;
import dev.zt.UpliftedVFFV.inventory.consumables.IceCreamSesame;
import dev.zt.UpliftedVFFV.inventory.consumables.IceCreamTaro;
import dev.zt.UpliftedVFFV.party.Schmuck;



public class EventShopIceCream extends Event {

	public BufferedImage shopKeeper = ImageLoader.loadImage("/CharacterBusts/Arturo.png");
	public TreeMap<Item, Integer> selection = new TreeMap<>();
	public ArrayList<Item> stuff = new ArrayList<Item>();
	public static int stagenum = 0;
	public EventShopIceCream(float x, float y, int idnum) {
		super(Assets.Table8,idnum,x, y, stagenum);
		
	}
	
	public void run(){
		getGoods();
		super.shop(this.getId(),selection,shopKeeper,10);
	}

	public boolean isSolid(int i){
		return true;
	}
	
	public void getGoods(){
		double discount = 0;
		for(Schmuck s : gamestate.partymanager.party){
			discount += s.getDiscountBonus();
		}

		stuff.add(new IceCreamAzukiBean());
		stuff.add(new IceCreamTaro());
		stuff.add(new IceCreamMatcha());
		stuff.add(new IceCreamPlum());
		stuff.add(new IceCreamMango());
		stuff.add(new IceCreamSesame());
		
		for(Item i : stuff){
			selection.put(i, (int)(i.value * (1 - discount)));
		}
	}
}
