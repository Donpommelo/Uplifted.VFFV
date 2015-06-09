package dev.zt.UpliftedVFFV.events.Floor3Offices.SouthWingOffices;



import java.awt.image.BufferedImage;
import java.util.TreeMap;

import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.gfx.ImageLoader;
import dev.zt.UpliftedVFFV.inventory.CarrotJuice;
import dev.zt.UpliftedVFFV.inventory.CoffeedIce;
import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.inventory.LemonyFresh;
import dev.zt.UpliftedVFFV.inventory.MeltedIcecream;



public class EventVending1Invisible extends Event {

	public boolean selfswitch1=false;
	public BufferedImage shopKeeper = ImageLoader.loadImage("/CharacterBusts/Arturo.png");
	public TreeMap<Item, Integer> selection = new TreeMap<>();
	public EventVending1Invisible(float x, float y, int idnum) {
		super(Assets.White,idnum,x, y);
		selection.put(new CoffeedIce(), 3);
		selection.put(new CarrotJuice(), 3);
		selection.put(new MeltedIcecream(), 4);
		selection.put(new LemonyFresh(), 5);
	}
	

	
	public void run(){
//		super.Dialog(168, 168,this.getId());
		super.shop(this.getId(),selection,shopKeeper);

	}

	public static void main(String[] args) {
		
	}
	
	public boolean isSolid(){
		return true;
	}



	public static Event event38 = new Event38(34, 0,38);
}
