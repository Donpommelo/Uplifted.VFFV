package dev.zt.UpliftedVFFV.utils;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import dev.zt.UpliftedVFFV.gfx.ImageLoader;
import dev.zt.UpliftedVFFV.gfx.SpriteSheet;

public class Utils {
	
	//this is used to turn strings into files
	public static String loadFileAsString(String path){
		StringBuilder builder = new StringBuilder();
		
		try{
			InputStream resource = Utils.class.getResourceAsStream(path);
			InputStreamReader inpr = new InputStreamReader(resource);
			BufferedReader br = new BufferedReader(inpr);
			String line;
			while((line = br.readLine()) != null)
				builder.append(line +"\n");
			
			br.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		
		return builder.toString();
	}
	
	public static int parseInt(String number){
		try{
			return Integer.parseInt(number);
		}catch(NumberFormatException e){
			e.printStackTrace();
			return 0;
		}
	}
	
	//Wrapper for drawImage that draws a scalable menu background.
	/* Parameters:
	 * 	g - Graphics object
	 * 	frame - Name of menu texture. Texture should be a 192 x 192 image divided into 9 64 x 64 sections.	
	 * 	width - Width of window to be drawn.
	 * 	height - Height of window to be drawn.
	 * 	x - x coordinate of upper right menu corner.
	 *  y - y coordinate of upper right menu corner.
	 */
	public static void drawMenu(Graphics g, String frame, int x, int y, int width, int height){
		//Load texture and cut into subsections.
		SpriteSheet texture = new SpriteSheet(ImageLoader.loadImage("/ui/Window/" + frame));
		BufferedImage upperleft = texture.crop(0, 0, 64, 64);
		BufferedImage centerleft = texture.crop(0, 64, 64, 64);
		BufferedImage lowerleft = texture.crop(0, 128, 64, 64);
		BufferedImage uppercenter = texture.crop(64, 0, 64, 64);
		BufferedImage centercenter = texture.crop(64, 64, 64, 64);
		BufferedImage lowercenter = texture.crop(64, 128, 64, 64);
		BufferedImage upperright = texture.crop(128, 0, 64, 64);
		BufferedImage centerright = texture.crop(128, 64, 64, 64);
		BufferedImage lowerright = texture.crop(128, 128, 64, 64);
		
		//Calculate menu size from width and height (round up).
		int xsquares = (width / 64) + 1;
		int ysquares = (height / 64) + 1;
		
		//Draw menu.
		for(int i = 0; i < xsquares; i ++){
			for(int j = 0; j < ysquares; j++){
				//Determine subsection to draw.
				if(i == 0 && j == 0){
					//Upper Left.
					g.drawImage(upperleft, x + i * 64, y + j * 64, null);
				} else if(i == xsquares - 1 && j == 0){
					//Upper Right.
					g.drawImage(upperright, x + i * 64, y + j * 64, null);
				} else if(i == 0 && j == ysquares - 1){
					//Lower Left.
					g.drawImage(lowerleft, x + i * 64, y + j * 64, null);
				} else if(i == xsquares - 1 && j == ysquares - 1){
					//Lower Right.
					g.drawImage(lowerright, x + i * 64, y + j * 64, null);
				} else if(j == 0){
					//Upper edge.
					g.drawImage(uppercenter, x + i * 64, y + j * 64, null);
				} else if (j == ysquares - 1){
					//Lower edge.
					g.drawImage(lowercenter, x + i * 64, y + j * 64, null);
				} else if (i == 0){
					//Left edge.
					g.drawImage(centerleft, x + i * 64, y + j * 64, null);
				} else if(i == xsquares - 1){
					//Right edge.
					g.drawImage(centerright, x + i * 64, y + j * 64, null);
				} else{
					//Interior.
					g.drawImage(centercenter, x + i * 64, y + j * 64, null);
				}
			}
		}
	}

}
