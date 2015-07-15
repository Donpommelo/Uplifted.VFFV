package dev.zt.UpliftedVFFV.Battle;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.states.StateManager;

public class BattleText {
	
	public StateManager sm;
	public Game game;
	public boolean ranAway;
	public ArrayList<Schmuck>allies=new ArrayList<Schmuck>();
	public ArrayList<Schmuck> enemy=new ArrayList<Schmuck>();
	public ArrayList<String> textList=new ArrayList<String>();
	public BattleState bs;
	
	public int  charIndex;
	public boolean scrolling;

	public BattleText(Game game, StateManager sm, ArrayList<Schmuck>party,ArrayList<Schmuck>enemy, BattleState bs){
		this.game=game;
		this.sm=sm;
		this.allies = party;
		this.enemy=enemy;
		this.bs = bs;
		this.charIndex = 0;
		this.scrolling = false;

	}
	
	public void tick() {
		if(game.getKeyManager().space){
			
			if(!textList.isEmpty()){
				if(textList.get(0).contains("You and everyone you care about are dead.")){
					bs.end(false);
				}
				if(scrolling){
//					charIndex+=5;
				}
				else{
					charIndex = 0;
					textList.remove(0);
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			if(ranAway){
				bs.bp.stm.endofFite();
				bs.end(false);
			}
			
		}
	}
			

	public void render(Graphics g) {
		if(charIndex>textList.get(0).length()){				//controls how much of the dialog is rendered. 
			charIndex=textList.get(0).length();				//charIndex increases as time passes, causing text to scroll
		}	
		g.setColor(new Color(160, 160, 160, 200));
		g.setFont(new Font("Chewy", Font.PLAIN, 18));
		g.fillRect(0, 0, 640, 28);
		g.setColor(new Color(0,0,0));
//		g.drawString(textList.get(0),0,20);	
//		g.drawString(textList.get(1),0,45);	
		
		for(int i = 1; i <= charIndex; i++){
			g.drawString(textList.get(0).substring(0, i), 6, 24);		//causes text to form new lines

		}
		
		if(charIndex < textList.get(0).length()){			//charIndex increases each time it is rendered so text scrolls
			scrolling=true;
			charIndex+=2;
		}
		else{					
			scrolling=false;					//if the text is done scrolling, charIndex stops increasing
		}
	}

}
