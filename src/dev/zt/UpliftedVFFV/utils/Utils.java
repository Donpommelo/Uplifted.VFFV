package dev.zt.UpliftedVFFV.utils;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.*;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.gfx.SpriteSheet;
import dev.zt.UpliftedVFFV.states.GameState;
import dev.zt.UpliftedVFFV.states.StateManager;

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
	
	public static double parseDouble(String number){
		try{
			return Double.parseDouble(number);
		}catch(NumberFormatException e){
			e.printStackTrace();
			return 0.0;
		}
	}
	
/*****UTILS FOR MENU DRAWING (NOT PROCESSING)*****/	

	//Size of cuts, make smaller for more precision. Values <16 or >64 will probably break things.
	private static int squareSize = 16;
	
	//Wrapper for drawImage that draws a scalable menu background.
	/* Parameters:
	 * 	g - Graphics object
	 * 	window - Name of menu texture. Texture should be a 128 x 160 image divided into 4 squareSize x squareSize sections 
	 * 		and with a 128 x 32 cursor texture at the bottom.
	 *  options - List of menu options to display. Size/font not currently adjustable (Default font size 18).
	 *  fontColor - Color of options.
	 *  fontHeight - Height of cursor.
	 *  cursorIndex - Integer index of cursor.
	 *  x - x coordinate of upper right menu corner.
	 *  y - y coordinate of upper right menu corner.
	 * 	width - Width of window to be drawn.
	 * 	height - Height of window to be drawn.
	 * 	priority - Window focus. If not in focus, the menu is drawn transparently.
	 */
	public static void drawMenu(Graphics g, BufferedImage window, String[] options, Color fontColor, int fontHeight,
			int cursorIndex, int x, int y, int width, int height, boolean priority){
		
		Graphics2D g2d = (Graphics2D) g;
		drawDialogueBox(g2d, window, "", 18, fontColor, x, y, width, height, squareSize, priority);
		
		//Set transparency according to priority.
		if(!priority){
			 g2d.setComposite(AlphaComposite.SrcOver.derive(0.5f));
		}
		
		drawCursor(g2d, window, x, y + (25 * cursorIndex) + 12, width, fontHeight, priority);

		//Draw menu options.
		g2d.setFont(new Font("Chewy", Font.PLAIN, 18));
		g2d.setColor(fontColor);
		for(int i = 0; i < options.length; i++){
			g2d.drawString(options[i], x + 21, y + 35 + (25 * i));
		}		
		//Reset transparency.
		g2d.setComposite(AlphaComposite.SrcOver.derive(1.0f));
	}
	
	//Wrapper for drawImage that draws a scrolling menu with a controllable number of x and y options.
		/* Parameters:
		 g - Graphics object
		 * 	window - Name of menu texture. Texture should be a 128 x 160 image divided into 4 squareSize x squareSize sections 
		 * 		and with a 128 x 32 cursor texture at the bottom.
		 *  options - List of menu options to display with toString(). Size/font not currently adjustable (Default font size 18).
		 *  fontColor - Color of options.
		 *  fontHeight - Height of cursor.
		 *  cursorIndex - Integer index of cursor.
		 *  x - x coordinate of upper right menu corner.
		 *  y - y coordinate of upper right menu corner.
		 * 	width - Width of window to be drawn.
		 * 	height - Height of window to be drawn.
		 *  optionx - Number of options displayed horizontally.
		 *  optiony - number of options displayed vertically.
		 *  frame - Reference location for displaying observable list.
		 *  squareSize - Size of texture to be sampled. Larger values: More detail, less precision in size.
		 * 	priority - Window focus. If not in focus, the menu is drawn transparently.
		 * 	drawCursor - Determines whether to draw the cursor or not (For custom menus).
		 */
		public static void drawMenu(Graphics g, BufferedImage window, Object[] options, Color fontColor, int fontHeight,
				int cursorIndex, int x, int y, int width, int height, int optionx, int optiony, int frame, int customSquareSize,
				boolean priority){
			Graphics2D g2d = (Graphics2D) g;
			drawDialogueBox(g2d, window, "", 18, fontColor, x, y, width, height, customSquareSize, priority);
			
			//Set transparency according to priority.
			if(!priority){
				 g2d.setComposite(AlphaComposite.SrcOver.derive(0.5f));
			}
			
			//Draw cursor.
			drawCursor(g2d, window, x + (width / optionx - 2) * (cursorIndex % optionx), y + (25 * (cursorIndex / optionx)) + 8, width / optionx + 5, fontHeight, priority);
			//Draw menu options.
			g2d.setFont(new Font("Chewy", Font.PLAIN, 18));
			g2d.setColor(fontColor);
			if(options.length > 0){	
				int listPosition = 0;
				g2d.setFont(new Font("Chewy", Font.PLAIN, fontHeight));
				for(int i = frame * optionx; i < optionx * (frame + optiony) && i < options.length; i++){
					if(options[i] != null){
						g2d.drawString(options[i].toString(), x + 15 + (width / optionx) * (listPosition % optionx), y + 28 + (25 * (listPosition / optionx)));
						listPosition++;
					} else{
						break;
					}
				}
			} else{
				g2d.drawString("EMPTY", x + 15, y + 28);
			}
			
			//Reset transparency.
			g2d.setComposite(AlphaComposite.SrcOver.derive(1.0f));
		}
	
	//Wrapper for drawImage that draws a dialogue box.
	/* Parameters:
	 * 	g - Graphics object
	 *	window - Name of menu texture. Texture should be a 128 x 128 image divided into 4 squareSize x squareSize sections.
	 *	text - Text to display inside the box.
	 *  fontSize - Size of text.
	 *  fontColor - Color of text.
	 *  x - x coordinate of upper right box corner.
	 *  y - y coordinate of upper right box corner.
	 * 	width - Width of box to be drawn.
	 * 	height - Height of box to be drawn.
	 *  squareSize - Size of texture to be sampled. Larger values: More detail, less precision in size.
	 * 	priority - Window focus. If not in focus, the box is drawn transparently.
	 */
	public static int drawDialogueBox(Graphics g, BufferedImage window, String text, int fontSize, Color fontColor, int x, int y, int width, int height, 
			int squareSize, boolean priority){
		Graphics2D g2d = (Graphics2D) g;
		//Load texture and cut into subsections.
		SpriteSheet texture = new SpriteSheet(window);		
		BufferedImage upperleft = texture.crop(0, 0, squareSize, squareSize);
		BufferedImage centerleft = texture.crop(0, 32, squareSize, squareSize);
		BufferedImage lowerleft = texture.crop(0, 128 - squareSize, squareSize, squareSize);
		BufferedImage uppercenter = texture.crop(32, 0, squareSize, squareSize);
		BufferedImage centercenter = texture.crop(32, 32, squareSize, squareSize);
		BufferedImage lowercenter = texture.crop(32, 128 - squareSize, squareSize, squareSize);
		BufferedImage upperright = texture.crop(128 - squareSize, 0, squareSize, squareSize);
		BufferedImage centerright = texture.crop(128 - squareSize, 32, squareSize, squareSize);
		BufferedImage lowerright = texture.crop(128 - squareSize, 128 - squareSize, squareSize, squareSize);
		
		//Calculate menu size from width and height (round up).
		int xsquares = (width / squareSize) + 1;
		int ysquares = (height / squareSize) + 1;
		
		//Set transparency according to priority.
		if(!priority){
			 g2d.setComposite(AlphaComposite.SrcOver.derive(0.5f));
		}
		
		//Draw box.
		for(int i = 0; i < xsquares; i++){
			for(int j = 0; j < ysquares; j++){
				//Determine subsection to draw.
				if(i == 0 && j == 0){
					//Upper Left.
					g2d.drawImage(upperleft, x + i * squareSize, y + j * squareSize, null);
				} else if(i == xsquares - 1 && j == 0){
					//Upper Right.
					g2d.drawImage(upperright, x + i * squareSize, y + j * squareSize, null);
				} else if(i == 0 && j == ysquares - 1){
					//Lower Left.
					g2d.drawImage(lowerleft, x + i * squareSize, y + j * squareSize, null);
				} else if(i == xsquares - 1 && j == ysquares - 1){
					//Lower Right.
					g2d.drawImage(lowerright, x + i * squareSize, y + j * squareSize, null);
				} else if(j == 0){
					//Upper edge.
					g2d.drawImage(uppercenter, x + i * squareSize, y + j * squareSize, null);
				} else if (j == ysquares - 1){
					//Lower edge.
					g2d.drawImage(lowercenter, x + i * squareSize, y + j * squareSize, null);
				} else if (i == 0){
					//Left edge.
					g2d.drawImage(centerleft, x + i * squareSize, y + j * squareSize, null);
				} else if(i == xsquares - 1){
					//Right edge.
					g2d.drawImage(centerright, x + i * squareSize, y + j * squareSize, null);
				} else{
					//Interior.
					g2d.drawImage(centercenter, x + i * squareSize, y + j * squareSize, null);
				}
			}
		}
		
		//Account for small boxes.
		if(xsquares == 1){
			//Lower Left.
			g2d.drawImage(lowerleft, x + squareSize, y, null);
			//Lower Right.
			g2d.drawImage(lowerright, x + squareSize, y + squareSize * (ysquares - 1), null);
			//Right edge.
			for(int i = 1; i < ysquares - 1; i++){
				g2d.drawImage(centerright, x + squareSize, y + squareSize * i, null);
			}
		}
		if(ysquares == 1){
			//Lower Left.
			g2d.drawImage(lowerleft, x, y + squareSize, null);
			//Lower edge.
			g2d.drawImage(lowerright, x + squareSize * (xsquares - 1), y + squareSize, null);
			//Lower Right.
			for(int j = 1; j < xsquares - 1; j++){
				g2d.drawImage(lowercenter, x + squareSize * j, y + squareSize, null);
			}
		}
		
		//Draw text.
		g2d.setFont(new Font("Chewy", Font.PLAIN, fontSize));
		g2d.setColor(fontColor);
//		g2d.drawString(text, x + 12, y + 25);
		//Wrapping text
		int yLine = y;
		int xLoc = 0;
		for (String line : text.split("\n")){
	        yLine += g.getFontMetrics().getHeight();
	        xLoc = 0;
			for(String word : line.split(" ")){
				if(xLoc + g.getFontMetrics().stringWidth(word) < width-10){
					 g2d.drawString(word, x+12+xLoc, yLine);
				}
				else{
					xLoc = 0;
					g2d.drawString(word, x+12, yLine += g.getFontMetrics().getHeight());
				}
				xLoc += g.getFontMetrics().stringWidth(word+" ");
			}
		}
		//Reset transparency.
		g2d.setComposite(AlphaComposite.SrcOver.derive(1.0f));
		return yLine;
	}
	
	//Wrapper for drawImage that draws a cursor. Pretty much like drawDialogueBox.
	/* Parameters:
	 * 	g - Graphics object
	 *	window - Name of menu texture. Texture should be a 128 x 128 image divided into 4 squareSize x squareSize sections.
	 *  x - x coordinate of upper right box corner.
	 *  y - y coordinate of upper right box corner.
	 * 	width - Width of box to be drawn.
	 * 	height - Height of box to be drawn.
	 *	priority - Window focus. If not in focus, the box is drawn transparently.
	 */
	public static void drawCursor(Graphics g, BufferedImage window, int x, int y, int width, int height, boolean priority){
		
		Graphics2D g2d = (Graphics2D) g;
		//Load texture and cut into subsections.
		SpriteSheet texture = new SpriteSheet(window);		
		BufferedImage upperleft = texture.crop(0, 128, squareSize, 16);
		BufferedImage centerleft = texture.crop(0, 136, squareSize, 16);
		BufferedImage lowerleft = texture.crop(0, 144, squareSize, 16);
		BufferedImage uppercenter = texture.crop(32, 128, squareSize, 16);
		BufferedImage centercenter = texture.crop(32, 136, squareSize, 16);
		BufferedImage lowercenter = texture.crop(32, 144, squareSize, 16);
		BufferedImage upperright = texture.crop(128 - squareSize, 128, squareSize, 16);
		BufferedImage centerright = texture.crop(128 - squareSize, 136, squareSize, 16);
		BufferedImage lowerright = texture.crop(128 - squareSize, 144, squareSize, 16);
		
		//Calculate menu size from width and height (round up).
		int xsquares = (width / squareSize) + 1;
		int ysquares = (height / 16) + 1;
		
		//Set transparency according to priority.
		if(!priority){
			 g2d.setComposite(AlphaComposite.SrcOver.derive(0.5f));
		}
		
		//Draw Cursor at index cursor.
		for(int i = 0; i < xsquares; i++){
			for(int j = 0; j < ysquares; j++){
				//Determine subsection to draw.
				if(i == 0 && j == 0){
					//Upper Left.
					g2d.drawImage(upperleft, x + i * squareSize, y + j * 16, null);
				} else if(i == xsquares - 1 && j == 0){
					//Upper Right.
					g2d.drawImage(upperright, x + i * squareSize, y + j * 16, null);
				} else if(i == 0 && j == ysquares - 1){
					//Lower Left.
					g2d.drawImage(lowerleft, x + i * squareSize, y + j * 16, null);
				} else if(i == xsquares - 1 && j == ysquares - 1){
					//Lower Right.
					g2d.drawImage(lowerright, x + i * squareSize, y + j * 16, null);
				} else if(j == 0){
					//Upper edge.
					g2d.drawImage(uppercenter, x + i * squareSize, y + j * 16, null);
				} else if (j == ysquares - 1){
					//Lower edge.
					g2d.drawImage(lowercenter, x + i * squareSize, y + j * 16, null);
				} else if (i == 0){
					//Left edge.
					g2d.drawImage(centerleft, x + i * squareSize, y + j * 16, null);
				} else if(i == xsquares - 1){
					//Right edge.
					g2d.drawImage(centerright, x + i * squareSize, y + j * 16, null);
				} else{
					//Interior.
					g2d.drawImage(centercenter, x + i * squareSize, y + j * 16, null);
				}
			}
		}
		
		//Account for small cursors.
		if(xsquares == 1){
			//Lower Left.
			g2d.drawImage(lowerleft, x + squareSize, y, null);
			//Lower Right.
			g2d.drawImage(lowerright, x + squareSize, y + 16 * (ysquares - 1), null);
			//Right edge.
			for(int i = 1; i < ysquares - 1; i++){
				g2d.drawImage(centerright, x + squareSize, y + 16 * i, null);
			}
		}
		if(ysquares == 1){
			//Lower Left.
			g2d.drawImage(lowerleft, x, y + squareSize, null);
			//Lower edge.
			g2d.drawImage(lowerright, x + squareSize * (xsquares - 1), y + 16, null);
			//Lower Right.
			for(int j = 1; j < xsquares - 1; j++){
				g2d.drawImage(lowercenter, x + squareSize * j, y + 16, null);
			}
		}
		
		//Reset transparency.
		g2d.setComposite(AlphaComposite.SrcOver.derive(1.0f));
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
	
/*****GAME SAVING AND LOADING******/
	//Function that saves state to file.
	/* Parameters:
	 * 	saveSlot - Number of file to save gamestate to.
	 * 	gamestate - Object containing game information. 
	 */
	public static void saveState(GameState gamestate, int eventID, int saveFile) throws IOException{
		FileOutputStream fos = new FileOutputStream("res/Saves/" + saveFile + ".save");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		gamestate.writeObject(oos);
		oos.close();
	}
	 
	//Function that loads state from file.
	/* Parameters:
	 * game - Current game existing object.
	 * sm - Current existing StateManager object. Along with "game", needed to construct new GameState.	
	 * saveSlot - Number of file to load gamestate from.
	 */
	public static GameState loadState(Game game, StateManager sm, int saveSlot) throws IOException, ClassNotFoundException{
		FileInputStream fis = new FileInputStream("res/Saves/" + saveSlot + ".save");
		ObjectInputStream ois = new ObjectInputStream(fis);
		GameState loadState = new GameState(game, sm);
		loadState.readObject(ois);
		ois.close();
		return loadState;
	}	

/*****GAME SAVING AND LOADING******/

/*****ANIMATIONS*****/
	//Function that returns an array of frames from an image for animations.
	/* Parameters:
	 * g - Graphics object
	 * image - Image file containing animation frames with dimensions as specified by sheetWidth and numFrames.
	 * width - Width of each frame.
	 * height -Height of each frame.
	 * numFrames - Total number of frames in the animation.
	 * frameSkip - Numer of render cycles to spend on each frame. Affects animation speed and smoothness.
	 */
	
	//Constants.
	private static int sheetWidth = 1;		//Number of frames horizontally in each image.
	
	public static BufferedImage[] getFrames(Graphics g, BufferedImage image, int width, int height, int numFrames, int frameSkip){
		//Create array of frames.
		BufferedImage[] frames = new BufferedImage[numFrames];
		SpriteSheet animation = new SpriteSheet(image);	
		for(int i = 0; i < numFrames; i++){
			frames[i] = animation.crop(i % sheetWidth, i / sheetWidth, width, height);
		}
		
		return frames;
	}

/*****ANIMATIONS*****/
}