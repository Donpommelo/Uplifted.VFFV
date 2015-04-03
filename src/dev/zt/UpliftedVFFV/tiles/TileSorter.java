package dev.zt.UpliftedVFFV.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.gfx.SpriteSheet;

public class TileSorter {
	
	static SpriteSheet meep;
	static BufferedImage merp;
	
	public TileSorter(){
		
	}
	
	public static BufferedImage TileSort(int num, BufferedImage img){
		meep=new SpriteSheet(img);
		switch(num){
		case 0:
			merp=meep.crop(0,0,32,32);
			break;
		case 1:
			merp=meep.crop(32,0,32,32);
			break;
		case 2:
			merp=meep.crop(0,32,32,32);
			break;
		case 3:
			merp=meep.crop(16,32,32,32);
			break;
		case 4:
			merp=meep.crop(32,32,32,32);
			break;
		case 5:
			merp=meep.crop(0,48,32,32);
			break;
		case 6:
			merp=meep.crop(16,48,32,32);
			break;
		case 7:
			merp=meep.crop(32,48,32,32);
			break;
		case 8:
			merp=meep.crop(0,64,32,32);
			break;
		case 9:
			merp=meep.crop(16,64,32,32);
			break;
		case 10:
			merp=meep.crop(32,64,32,32);
			break;
		
		
		}
	
		return merp;
	}

}
