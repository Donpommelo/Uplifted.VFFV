package dev.zt.UpliftedVFFV.events.Floor3Offices.SouthWingOffices;



import java.awt.image.BufferedImage;
import java.util.TreeMap;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.gfx.ImageLoader;
import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.inventory.consumables.CarrotJuice;
import dev.zt.UpliftedVFFV.inventory.consumables.CoffeedIce;
import dev.zt.UpliftedVFFV.inventory.consumables.LemonyFresh;
import dev.zt.UpliftedVFFV.inventory.consumables.MeltedIcecream;



public class EventVending1 extends Event {

	public BufferedImage shopKeeper = ImageLoader.loadImage("/CharacterBusts/Arturo.png");
	public TreeMap<Item, Integer> selection = new TreeMap<>();
	public static int stagenum = 0;
	public EventVending1(float x, float y, int idnum) {
		super(Assets.VendingMachine,idnum,x, y, stagenum);
		selection.put(new CoffeedIce(), 3);
		selection.put(new CarrotJuice(), 3);
		selection.put(new MeltedIcecream(), 4);
		selection.put(new LemonyFresh(), 5);
	}
	
	public void run(){
//		super.Dialog(168, 168,this.getId());
		super.shop(this.getId(),selection,shopKeeper);
	}

	public boolean isSolid(int i){
		return true;
	}
}
