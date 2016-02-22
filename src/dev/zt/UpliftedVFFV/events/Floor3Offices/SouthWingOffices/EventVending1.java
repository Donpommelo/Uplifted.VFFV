package dev.zt.UpliftedVFFV.events.Floor3Offices.SouthWingOffices;



import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.TreeMap;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.gfx.ImageLoader;
import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.inventory.consumables.CarrotJuice;
import dev.zt.UpliftedVFFV.inventory.consumables.CoffeedIce;
import dev.zt.UpliftedVFFV.inventory.consumables.LemonyFresh;
import dev.zt.UpliftedVFFV.inventory.consumables.MeltedIcecream;

import dev.zt.UpliftedVFFV.party.Schmuck;



public class EventVending1 extends Event {

	public BufferedImage shopKeeper = ImageLoader.loadImage("/CharacterBusts/Arturo.png");
	public TreeMap<Item, Integer> selection = new TreeMap<>();
	public ArrayList<Item> stuff = new ArrayList<Item>();
	public static int stagenum = 0;
	public EventVending1(float x, float y, int idnum) {
		super(Assets.VendingMachine,idnum,x, y, stagenum);
		
	}
	
	public void run(){
//		super.Dialog(168, 168,this.getId());
		getGoods();
		super.shop(this.getId(),selection,shopKeeper);
	}

	public boolean isSolid(int i){
		return true;
	}
	
	public void getGoods(){
		double discount = 0;
		for(Schmuck s : gamestate.partymanager.party){
			discount += s.getDiscountBonus();
		}
		stuff.add(new CoffeedIce());
		stuff.add(new CarrotJuice());
		stuff.add(new MeltedIcecream());
		stuff.add(new LemonyFresh());

		for(Item i : stuff){
			selection.put(i, (int)(i.value * (1 - discount)));
		}
	}
}
