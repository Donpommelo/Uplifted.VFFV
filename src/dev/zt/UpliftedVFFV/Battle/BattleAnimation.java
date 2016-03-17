package dev.zt.UpliftedVFFV.Battle;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.Serializable;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;


public class BattleAnimation implements Serializable{
	
	//Battle Animations are the things that play whenever things happen in battle.
	
	private static final long serialVersionUID = 1L;
	
	//frames: the number of frames in a specific animation.
	public int frames;
	public Schmuck target;
	public BattleAnimation(int frames){
		this.frames = frames;
	}
	
	//This is run when a skill is animated.
	//Default animation has the skill name moving from user to target.
	public void animateAction(int frame, Action a, Graphics g){
		g.setColor(new Color(255, 255, 0));
		g.setFont(new Font("Chewy", Font.PLAIN, 50));
		g.drawString(a.skill.getName(), frame*8, 208);
	}
	
	//This will be run for non-action effects, often the result of statuses.
	public void animateEffect(int frame, Graphics g, BattleState bs){
		
	}
	
	public Schmuck getTarget(){
		return target;
	}
}
