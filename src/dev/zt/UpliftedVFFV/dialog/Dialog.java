package dev.zt.UpliftedVFFV.dialog;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.gfx.ImageLoader;
import dev.zt.UpliftedVFFV.utils.Utils;

//Dialog. Every time someone says a thing, that's a dialog. Pressing space moves on to the next dialog
//each dialog consists of the name of the speaker, the text, the character bust, and the direction faced
public class Dialog {

	public String text;
	public BufferedImage window;
	public int position;
	public BufferedImage speaker;
	public Color myColor;
	public int charIndex;
	public String SpeakerName;
	public int currentLine, lastIndex;
	public static boolean scrolling;
	public Dialog(String name,BufferedImage img, int pos, String text){
		this.speaker = img;
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
		
		window = ImageLoader.loadImage("/ui/Window/WindowBlue.png");

	}
	
	public void tick(){
	
	}
	
	//dialog is rendered here. 
	public void render(Graphics g){
		if(charIndex>text.length()){				//controls how much of the dialog is rendered. 
			charIndex=text.length();				//charIndex increases as time passes, causing text to scroll
		}
		if(position==0){
			g.drawImage(speaker, 0, 416-speaker.getHeight(), null);
		}
		else{		
			g.drawImage(speaker, 640-speaker.getWidth(), 416-speaker.getHeight(), null);
		}
//		g.setColor(new Color(102, 178,255, 200));
//		g.setFont(new Font("Chewy", Font.PLAIN, 18));
//		g.fillRect(0, 316, 640, 100);
		Utils.drawDialogueBox(g, window, "", 18, Color.black, 0, 316, 625, 80, 16, true);
		
		if(!SpeakerName.equals("meep"))				//displays speaker's name in a box.
		{
//			g.fillRect(5, 286,6+SpeakerName.length()*8, 25);
//			g.setColor(Color.BLACK);
//			g.drawString(SpeakerName, 8, 304);
			Utils.drawDialogueBox(g, window, SpeakerName, 18, Color.black, 5, 280, 25 + SpeakerName.length() * 8, 32, 16, true);
		}
		g.setColor(Color.black);					//displays text. / indicates a new line
		for(int i = 1; i < charIndex; i++){
			int y = 320;
			String temp = text.substring(0, i);
			for (String line : temp.split("/"))
		        g.drawString(line, 10, y += g.getFontMetrics().getHeight());		//causes text to form new lines
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
