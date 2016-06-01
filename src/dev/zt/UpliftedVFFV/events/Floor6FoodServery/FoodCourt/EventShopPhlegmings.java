package dev.zt.UpliftedVFFV.events.Floor6FoodServery.FoodCourt;



import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.TreeMap;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.gfx.ImageLoader;
import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.inventory.consumables.Plopcorn;
import dev.zt.UpliftedVFFV.inventory.misc.BrokenGlasserole;
import dev.zt.UpliftedVFFV.inventory.misc.ChalkHockolate;
import dev.zt.UpliftedVFFV.inventory.misc.MediOkra;
import dev.zt.UpliftedVFFV.party.Schmuck;



public class EventShopPhlegmings extends Event {

	public BufferedImage shopKeeper = ImageLoader.loadImage("/CharacterBusts/Arturo.png");
	public TreeMap<Item, Integer> selection = new TreeMap<>();
	public ArrayList<Item> stuff = new ArrayList<Item>();
	public static int stagenum = 0;
	public EventShopPhlegmings(float x, float y, int idnum) {
		super(Assets.Table8,idnum,x, y, stagenum);
		
	}
	
	public void run(){
		getGoods();
		super.shop(this.getId(),selection,shopKeeper,5);
	}

	public boolean isSolid(int i){
		return true;
	}
	
	public void getGoods(){
		double discount = 0;
		for(Schmuck s : gamestate.partymanager.party){
			discount += s.getDiscountBonus();
		}

		stuff.add(new BrokenGlasserole());
		stuff.add(new ChalkHockolate());
		stuff.add(new Plopcorn());
		stuff.add(new MediOkra());

		
		for(Item i : stuff){
			selection.put(i, (int)(i.value * (1 - discount)));
		}
	}
}
