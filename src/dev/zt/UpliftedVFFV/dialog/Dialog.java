package dev.zt.UpliftedVFFV.dialog;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

public class Dialog {

	public String text;
	public int position;
	public BufferedImage speaker;
	public Color myColor;
	public int charIndex;
	public String Line1,Line2,Line3;
	public String SpeakerName;
	public int currentLine, lastIndex;
	public static boolean scrolling;
	public Dialog(String name,BufferedImage img, int pos, String text){
		this.speaker = img;
		this.position = pos;
		this.text = text;
		this.charIndex=1;
		this.lastIndex=0;
		this.currentLine=1;
		this.Line1="";this.Line2="";this.Line3="";
		scrolling=false;
		this.SpeakerName=name;
		if(position!=0){
			AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
			tx.translate(-speaker.getWidth(null), 0);
			AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
			speaker = op.filter(speaker, null);
		}

	}
	
	public void tick(){
	
	}
	
	public void render(Graphics g){
		if(charIndex>text.length()){
			charIndex=text.length();
		}
		if(position==0){
			g.drawImage(speaker, 0, 416-speaker.getHeight(), null);
		}
		else{		
			g.drawImage(speaker, 640-speaker.getWidth(), 416-speaker.getHeight(), null);
		}
		g.setColor(new Color(102, 178,255, 200));
		g.setFont(new Font("Chewy", Font.PLAIN, 18));
		g.fillRect(0, 316, 640, 100);
		g.fillRect(5, 286,6+SpeakerName.length()*8, 25);
		g.setColor(Color.BLACK);
		g.drawString(SpeakerName, 8, 304);
		for(int i=1;i<charIndex;i++){
			if(text.charAt(i)=='/'){
				switch(currentLine){
				case 1:Line1=text.substring(0,i);
					currentLine++;
					lastIndex=i+1;
					break;
				case 2:if(i>lastIndex){
						Line2=text.substring(lastIndex,i);	
						currentLine++;
						lastIndex=i+1;
						}
					
					break;
	/*			case 3:Line3=text.substring(lastIndex, i+1);
					currentLine++;
					lastIndex=i+1;
					break;*/
					}
			}
			else {
				switch(currentLine){
				case 1:
					Line1=text.substring(0,i+1);
					break;
				case 2:
					if(i>lastIndex){
						Line2=text.substring(lastIndex,i);	}
					break;
				case 3:
					if(i>lastIndex){
						Line3=text.substring(lastIndex,i+1);}
					break;
					}
			}
				
		}
		
//		g.drawString(text,8, 340);
		g.drawString(Line1, 8, 345);
		g.drawString(Line2, 8, 370);
		g.drawString(Line3, 8, 395);
		if(charIndex<text.length()){
			scrolling=true;
			charIndex++;
		}
		else{
			scrolling=false;
		}
		
	}
}
