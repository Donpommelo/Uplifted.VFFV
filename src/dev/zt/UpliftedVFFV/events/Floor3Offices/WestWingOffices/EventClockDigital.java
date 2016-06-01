package dev.zt.UpliftedVFFV.events.Floor3Offices.WestWingOffices;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.entities.creatures.Player;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.events.SpriteSorter;
import dev.zt.UpliftedVFFV.gfx.Assets;


public class EventClockDigital extends Event {

	public static int stagenum = 0;			
	public static BufferedImage img = Assets.WestClocksDigital330;
	public EventClockDigital(float x, float y, int idnum) {
		super(img,idnum,x, y, stagenum);
	}

	public void render(Graphics g, int x, int y) {
		
		switch(super.getVar(16)){
		case 1:
			switch(super.getVar(17)){
			case 0:
				img = Assets.WestClocksDigital300;
				break;
			case 1:
				img = Assets.WestClocksDigital915;
				break;
			case 2:
				img = Assets.WestClocksDigital315;
				break;
			case 3:
				img = Assets.WestClocksDigital330;
				break;
			}
			break;
		case 2:
			img = Assets.WestClocksDigital900;
			break;
		case 3:
			img = Assets.WestClocksDigital600;
			break;
		case 4:
			img = Assets.WestClocksDigital645;
			break;
		case 5:
			img = Assets.WestClocksDigital315;
			break;
		}
		g.drawImage(img, x, y-32, 96, 96, null);			
	}
	
}
