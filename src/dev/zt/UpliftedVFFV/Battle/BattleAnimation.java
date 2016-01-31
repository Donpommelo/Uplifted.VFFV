package dev.zt.UpliftedVFFV.Battle;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.Serializable;


public class BattleAnimation implements Serializable{
	

	private static final long serialVersionUID = 1L;
	int frames;
	public BattleAnimation(int frames){
		this.frames = frames;
	}
	
	public void animateAction(int frame, Action a, Graphics g){
		g.setColor(new Color(255, 255, 0));
		g.setFont(new Font("Chewy", Font.PLAIN, 50));
		g.drawString(a.skill.getName(), frame*8, 208);
	}
	
	public void animateEffect(int frame, Graphics g){
		
	}
}
