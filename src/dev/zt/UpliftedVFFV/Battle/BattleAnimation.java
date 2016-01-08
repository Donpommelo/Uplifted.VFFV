package dev.zt.UpliftedVFFV.Battle;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.Serializable;


public class BattleAnimation implements Serializable{
	
	int frames;
	public BattleAnimation(int frames){
		this.frames = frames;
	}
	
	public void animate(int frame, Action a, Graphics g){
		g.setColor(new Color(255, 255, 0));
		g.setFont(new Font("Chewy", Font.PLAIN, 50));
		g.drawString(a.skill.getName(), frame*8, 208);
	}
}
