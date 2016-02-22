package dev.zt.UpliftedVFFV.events.Floor3Offices.WestWingOffices;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.entities.creatures.Player;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.events.SpriteSorter;
import dev.zt.UpliftedVFFV.gfx.Assets;


public class EventClockAnalog extends Event {

	public static int stagenum = 0;			
	public static BufferedImage img = Assets.WestClocksDigital330;
	public EventClockAnalog(float x, float y, int idnum) {
		super(img,idnum,x, y, stagenum);
	}

	public void render(Graphics g, int x, int y) {
		
		switch(super.getVar(18)){
		case 0:
			img = Assets.WestClocksAnalogS;
			break;
		case 1:
			img = Assets.WestClocksAnalogE;
			break;
		case 2:
			img = Assets.WestClocksAnalogW;
			break;
		case 3:
			img = Assets.WestClocksAnalogN;
			break;
		case 4:
			img = Assets.WestClocksAnalogF;
			break;
		case 5:
			img = Assets.WestClocksAnalogB;
			break;
		case 6:
			img = Assets.WestClocksAnalogL;
			break;
		case 7:
			img = Assets.WestClocksAnalogR;
			break;
		}
		g.drawImage(img, x, y-32, 96, 96, null);			
	}
	
}
