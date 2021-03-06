package dev.zt.UpliftedVFFV.dialog;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.gfx.ImageLoader;
import dev.zt.UpliftedVFFV.utils.Utils;

//Dialog. Every time someone says a thing, that's a dialog. Pressing space moves on to the next dialog
//each dialog consists of the name of the speaker, the text, the character bust, and the direction faced
public class Dialog {

	public String text;
	public String[] lines;
	public BufferedImage window;
	public int position;
	public BufferedImage speaker;
	public Color myColor;
	public int charIndex;
	public String SpeakerName;
	public int currentLine, lastIndex;
	public static boolean scrolling;
	
	public Dialog(String name, String path, int pos, String text){
		this.speaker = ImageLoader.loadImage(path);
		this.position = pos;
		this.text = text;
		this.charIndex=0;
		this.lastIndex=0;
		this.currentLine=1;
		scrolling=false;
		this.SpeakerName=name;
		//if the person is facing the right, this mirrors and flips the image
		if(position!=0){
			AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
			tx.translate(-speaker.getWidth(null), 0);
			AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
			speaker = op.filter(speaker, null);
		}
		
		window = ImageLoader.loadImage("/ui/Window/WindowBlue2.png");

		lines = text.split("/");

	}
	
	public void tick(){
	
	}
	
	//dialog is rendered here. 
	public void render(Graphics g, int width, int height){
		if(charIndex>text.length()){				//controls how much of the dialog is rendered. 
			charIndex=text.length();				//charIndex increases as time passes, causing text to scroll
		}
		if(position==0){
			g.drawImage(speaker, 0, height-speaker.getHeight(), null);
		}
		else{		
			g.drawImage(speaker, width-speaker.getWidth(), height-speaker.getHeight(), null);
		}
		Utils.drawDialogueBox(g, window, "", 18, Color.black, 0, height - 100, width - 15, 80, 16, true);
		
		if(!SpeakerName.equals("meep"))				//displays speaker's name in a box.
		{
			Utils.drawDialogueBox(g, window, SpeakerName, 18, Color.black, 5, height - 136, g.getFontMetrics().stringWidth(SpeakerName)+15, 32, 16, true);
		}
		/*Graphics2D g2 = (Graphics2D)g;
	    RenderingHints rh = new RenderingHints(
	             RenderingHints.KEY_TEXT_ANTIALIASING,
	             RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
	    g2.setRenderingHints(rh);*/
		
		g.setFont(new Font("Courier", Font.PLAIN, 16));
		g.setColor(Color.black);					//displays text. / indicates a new line
		
		
/*		for(int i = 1; i < charIndex; i++){
			int y = height - 96;
			String temp = text.substring(0, i);
			for (String line : temp.split("/"))
		        g.drawString(line, 10, y += g.getFontMetrics().getHeight());		//causes text to form new lines
		}*/
		int charsPrinted = 0;
		int hardCodedLine = 0;
		int currentY = height - 96 +  g.getFontMetrics().getHeight();
		int currentX = 10;
		while(charsPrinted < charIndex){
			for(String word : lines[hardCodedLine].split(" ")){
				if(charsPrinted + word.length() > charIndex && currentX + g.getFontMetrics().stringWidth(word) < width-10){
					 g.drawString(word.substring(0,charIndex - charsPrinted), currentX, currentY);
				}
				else{
					if(currentX + g.getFontMetrics().stringWidth(word) < width-10){
						 g.drawString(word, currentX, currentY);
					}
					else{
						currentX = 10;
						g.drawString(word, 10, currentY += g.getFontMetrics().getHeight());
					}
				}
				currentX += g.getFontMetrics().stringWidth(word+" ");
				charsPrinted += (word.length()+1);
				if(charsPrinted >= charIndex){
					break;
				}
			}
			hardCodedLine++;
			currentX = 10;
			currentY += g.getFontMetrics().getHeight();
		}
		
		if(charIndex<text.length()){			//charIndex increases each time it is rendered so text scrolls
			scrolling=true;
				charIndex++;
		}
		else{					
			scrolling=false;					//if the text is done scrolling, charIndex stops increasing
		}
	}
}
