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
import dev.zt.UpliftedVFFV.inventory.consumables.Lachiplatre;
import dev.zt.UpliftedVFFV.party.Schmuck;



public class EventShopLachiplatre extends Event {

	public static int stagenum = 0;
	public EventShopLachiplatre(float x, float y, int idnum) {
		super(Assets.Table8,idnum,x, y, stagenum);
		
	}
	
	public void run(){
		if(super.getQuest(12) != 3){
			Dialog[] d = new Dialog[2];
			d[0] = new Dialog("Employee","/CharacterBusts/ServeryMRedsmall.png",1,"Sorry, the Servery currently has a shortage of Lachiplatre.");
			d[1] = new Dialog("Employee","/CharacterBusts/ServeryMRedsmall.png",1,"Please have patience as we try to sort this issue out in a timely manner.");
			super.Dialog(d, 1, this.getId(), true);
		}
		else{
			Dialog[] d = new Dialog[1];
			d[0] = new Dialog("Employee","/CharacterBusts/ServeryMRedsmall.png",1,"Did you want a Lachiplatre?/Here! Take one!/They're free!");
			super.Dialog(d, 0, this.getId(), true);
			super.loot(new Lachiplatre(), 1);
		}
		
		
	}

	public boolean isSolid(int i){
		return true;
	}
	
	
}
