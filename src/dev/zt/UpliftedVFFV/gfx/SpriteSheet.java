package dev.zt.UpliftedVFFV.gfx;

import java.awt.image.BufferedImage;

public class SpriteSheet {
	
	private BufferedImage sheet;
	
	//This is pretty much a bufferedimage that can be cropped.
	public SpriteSheet(BufferedImage sheet){
		this.sheet = sheet;
	}
	
	public BufferedImage crop(int x, int y, int width, int height){
			return sheet.getSubimage(x, y, width, height);

		
	}

}
