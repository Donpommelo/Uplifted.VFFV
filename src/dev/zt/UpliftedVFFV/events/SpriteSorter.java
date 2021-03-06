package dev.zt.UpliftedVFFV.events;

import java.awt.image.BufferedImage;
import dev.zt.UpliftedVFFV.gfx.SpriteSheet;

//this is pretty much tilesorter except with a different cutting pattern meant for processing character sprite sheets
public class SpriteSorter {
	
	static SpriteSheet meep;
	static BufferedImage merp;
	
	public SpriteSorter(){
		
	}
	
	public static BufferedImage SpriteSort(int num, BufferedImage img){
		meep=new SpriteSheet(img);
		if(meep == null){

		}
		switch(num){
		case 0:
			merp=meep.crop(0,0,32,64);
			break;
		case 1:
			merp=meep.crop(32,0,32,64);
			break;
		case 2:
			merp=meep.crop(64,0,32,64);
			break;
		case 3:
			merp=meep.crop(0,64,32,64);
			break;
		case 4:
			merp=meep.crop(32,64,32,64);
			break;
		case 5:
			merp=meep.crop(64,64,32,64);
			break;
		case 6:
			merp=meep.crop(0,128,32,64);
			break;
		case 7:
			merp=meep.crop(32,128,32,64);
			break;
		case 8:
			merp=meep.crop(64,128,32,64);
			break;
		case 9:
			merp=meep.crop(0,192,32,64);
			break;
		case 10:
			merp=meep.crop(32,192,32,64);
			break;
		case 11:
			merp=meep.crop(64,192,32,64);
			break;		
		}
	
		return merp;
	}


}
