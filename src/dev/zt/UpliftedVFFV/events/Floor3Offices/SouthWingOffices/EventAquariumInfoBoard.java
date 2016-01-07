package dev.zt.UpliftedVFFV.events.Floor3Offices.SouthWingOffices;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class EventAquariumInfoBoard extends Event {


	static BufferedImage img = Assets.InfoPanel;
	public EventAquariumInfoBoard(float x, float y, int idnum) {
		super(img,idnum,x, y,0);
	}
	
	public void run(){
		Dialog[] d = new Dialog[2];
		d[0] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"'Aquarium exhibits have been temporarily relocated due to unforseen circumstances.'/");
		d[1] = new Dialog("meep","/CharacterBusts/Arturo.png",1,"'-Management'/");
		super.Dialog(d, 1, this.getId(), true);	}
	
	public boolean isSolid(int i){
		return true;
	}
}
