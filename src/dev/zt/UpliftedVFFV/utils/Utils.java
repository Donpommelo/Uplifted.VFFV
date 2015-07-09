package dev.zt.UpliftedVFFV.utils;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

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
	
/*****UTILS FOR MENU DRAWING*****/	

	//Wrapper for drawImage that draws a scalable menu background.
	/* Parameters:
	 * 	g - Graphics object
	 * 	window - Name of menu texture. Texture should be a 128 x 160 image divided into 4 64 x 64 sections 
	 * 		and with a 128 x 32 cursor texture at the bottom.
	 *  options - List of menu options to display. Size/font not currently adjustable (Default font size 18).
	 *  fontColor - Color of options.
	 *  cursor - Integer index of cursor.
	 *  x - x coordinate of upper right menu corner.
	 *  y - y coordinate of upper right menu corner.
	 * 	width - Width of window to be drawn.
	 * 	height - Height of window to be drawn.
	 * 	priority - Window focus. If not in focus, the menu is drawn transparently.
	 */
	public static void drawMenu(Graphics g, BufferedImage window, String[] options, Color fontColor, int cursor, 
			int x, int y, int width, int height, boolean priority){
		
		Graphics2D g2d = (Graphics2D) g;
		//Load texture and cut into subsections.
		SpriteSheet texture = new SpriteSheet(window);		
		BufferedImage upperleft = texture.crop(0, 0, 64, 64);
		BufferedImage centerleft = texture.crop(0, 32, 64, 64);
		BufferedImage lowerleft = texture.crop(0, 64, 64, 64);
		BufferedImage uppercenter = texture.crop(32, 0, 64, 64);
		BufferedImage centercenter = texture.crop(32, 32, 64, 64);
		BufferedImage lowercenter = texture.crop(32, 64, 64, 64);
		BufferedImage upperright = texture.crop(64, 0, 64, 64);
		BufferedImage centerright = texture.crop(64, 32, 64, 64);
		BufferedImage lowerright = texture.crop(64, 64, 64, 64);
		BufferedImage cursorLeft = texture.crop(0, 128, 64, 32);
		BufferedImage cursorCenter = texture.crop(32, 128, 64, 32);
		BufferedImage cursorRight = texture.crop(64, 128, 64, 32);
		
		//Calculate menu size from width and height (round up).
		int xsquares = (width / 64) + 1;
		int ysquares = (height / 64) + 1;
		
		//Set transparency according to priority.
		if(!priority){
			 g2d.setComposite(AlphaComposite.SrcOver.derive(0.5f));
		}
		
		//Draw menu.
		for(int i = 0; i < xsquares; i++){
			for(int j = 0; j < ysquares; j++){
				//Determine subsection to draw.
				if(i == 0 && j == 0){
					//Upper Left.
					g2d.drawImage(upperleft, x + i * 64, y + j * 64, null);
				} else if(i == xsquares - 1 && j == 0){
					//Upper Right.
					g2d.drawImage(upperright, x + i * 64, y + j * 64, null);
				} else if(i == 0 && j == ysquares - 1){
					//Lower Left.
					g2d.drawImage(lowerleft, x + i * 64, y + j * 64, null);
				} else if(i == xsquares - 1 && j == ysquares - 1){
					//Lower Right.
					g2d.drawImage(lowerright, x + i * 64, y + j * 64, null);
				} else if(j == 0){
					//Upper edge.
					g2d.drawImage(uppercenter, x + i * 64, y + j * 64, null);
				} else if (j == ysquares - 1){
					//Lower edge.
					g2d.drawImage(lowercenter, x + i * 64, y + j * 64, null);
				} else if (i == 0){
					//Left edge.
					g2d.drawImage(centerleft, x + i * 64, y + j * 64, null);
				} else if(i == xsquares - 1){
					//Right edge.
					g2d.drawImage(centerright, x + i * 64, y + j * 64, null);
				} else{
					//Interior.
					g2d.drawImage(centercenter, x + i * 64, y + j * 64, null);
				}
			}
		}
		
		//Draw Cursor at index cursor.
		for(int i = 0; i < xsquares; i++){
			if(i == 0){
				g2d.drawImage(cursorLeft, x, y + 12 + 25 * cursor, null);
			} else if(i == xsquares - 1){
				g2d.drawImage(cursorRight, x + 128, y + 12 + 25 * cursor, null);
			} else{
				g2d.drawImage(cursorCenter, x + 64, y + 12 + 25 * cursor, null);
			}
		}
		
		//Draw menu options.
		g2d.setFont(new Font("Chewy", Font.PLAIN, 18));
		g2d.setColor(fontColor);
		for(int i = 0; i< options.length; i++){
			g2d.drawString(options[i], x + 25, y + 35 + (25 * i));
		}		
		//Reset transparency.
		g2d.setComposite(AlphaComposite.SrcOver.derive(1.0f));
	}
	
	//Wrapper for drawImage that draws a custom menu background (for Elevator panels?).
	/* Parameters:
	 * 	g - Graphics object
	 *	window - Name of menu texture. Texture should be an image of fixed size.
	 *	window2 - Texture of window to use for secondary display.
	 *	cursorTexture - Texture of cursor to draw.
	 *  options - List of menu options to display. Size/font not currently adjustable (Default font size 18).
	 *  fontColor - Color of options.
	 *  cursor - Integer index of cursor.
	 *  x - x coordinate of upper right menu corner.
	 *  y - y coordinate of upper right menu corner.
	 * 	width - Width of image to be drawn.
	 * 	height - Height of image to be drawn.
	 */
	public static void drawElevatorMenu(Graphics g, BufferedImage window, BufferedImage window2, BufferedImage cursorTexture, 
				String[] options, Color fontColor, int cursor, int x, int y, int width, int height){
		
	}
	
	//Wrapper for drawImage that draws a dialogue box.
	/* Parameters:
	 * 	g - Graphics object
	 *	window - Name of menu texture. Texture should be a 128 x 128 image divided into 4 64 x 64 sections.
	 *	textSource - ?
	 *  fontColor - Color of text.
	 *  x - x coordinate of upper right box corner.
	 *  y - y coordinate of upper right box corner.
	 * 	width - Width of box to be drawn.
	 * 	height - Height of box to be drawn.
	 */
	public static void drawDialogue(Graphics g, BufferedImage window, String[] options, Color fontColor, int x, int y, int width, int height){
		
	}
	
	//Wrapper for drawImage that draws a menu for the shop interface.
	/* Parameters:
	 * 	g - Graphics object
	 *	window - Name of menu texture. Texture should be an image of fixed size.
	 *	window2 - Texture of window to use for secondary display.
	 *	cursorTexture - Texture of cursor to draw.
	 *  options - List of menu options to display. Size/font not currently adjustable (Default font size 18).
	 *  fontColor - Color of options.
	 *  cursor - Integer index of cursor.
	 *  x - x coordinate of upper right menu corner.
	 *  y - y coordinate of upper right menu corner.
	 * 	width - Width of image to be drawn.
	 * 	height - Height of image to be drawn.
	 */
	public static void drawShopMenu(Graphics g, BufferedImage window, BufferedImage window2, BufferedImage cursorTexture, 
				String[] options, Color fontColor, int cursor, int x, int y, int width, int height){
		
	}

/*****END MENU DRAWING UTILS*****/

}
