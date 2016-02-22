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
	public ArrayList<Schmuck>allies=new ArrayList<Schmuck>();
	public ArrayList<Schmuck> enemy=new ArrayList<Schmuck>();
	public ArrayList<BattleScene> scenes=new ArrayList<BattleScene>();

	public BattleState bs;
	
	public int charIndex;
	public boolean scrolling, actionRun;
	public int autoscroll = 120;
	
	public int frame, autoWait;
	
	public BattleText(Game game, StateManager sm, ArrayList<Schmuck>party,ArrayList<Schmuck>enemy, BattleState bs){
		this.game=game;
		this.sm=sm;
		this.allies = party;
		this.enemy=enemy;
		this.bs = bs;
		this.charIndex = 0;
		this.scrolling = false;
		this.actionRun = false;
		this.frame = 0;
		this.autoWait = 0;
	}
	
	public void tick() {
		if(!scenes.isEmpty()){
			if(scenes.get(0).getText().contains("Everything goes black.")){
				bs.end(false);
			}
			if(scenes.get(0).isAuto() && !scrolling && actionRun){
				if(this.autoWait <= autoscroll){
					this.autoWait++;
				}
				else{
					charIndex = 0;
					autoWait = 0;
					scenes.remove(0);
					actionRun = false;
				}
			}
		}
		if(!scenes.isEmpty()){
			if(scenes.get(0).getA() == null){
				actionRun = true;
			}	
		}
		if(game.getKeyManager().space){
			if(!scenes.isEmpty()){
				
				//Indicates that battle is lost.
				if(scenes.get(0).getText().contains("Everything goes black.")){
					bs.end(false);
				}
				else{
					if(!scrolling && actionRun){
						charIndex = 0;
						scenes.remove(0);
						actionRun = false;
						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
			
		}
	}
			

	public void render(Graphics g) {
		if(charIndex > scenes.get(0).getText().length()){				//controls how much of the dialog is rendered. 
			charIndex = scenes.get(0).getText().length();				//charIndex increases as time passes, causing text to scroll
		}	
		g.setColor(new Color(160, 160, 160, 200));
		g.setFont(new Font("Chewy", Font.PLAIN, 18));
		g.fillRect(0, 0, 640, 28);
		g.setColor(new Color(0,0,0));
		
		for(int i = 1; i <= charIndex; i++){
			g.drawString(scenes.get(0).getText().substring(0, i), 6, 24);		//causes text to form new lines

		}
		
		if(charIndex < scenes.get(0).getText().length()){			//charIndex increases each time it is rendered so text scrolls
			scrolling=true;
			charIndex+=2;
		}
		else{					
			scrolling=false;					//if the text is done scrolling, charIndex stops increasing
		}
		
		if(scenes.get(0).getA() != null){
			if(!actionRun){
				if(frame < scenes.get(0).getA().skill.ba.frames){
					scenes.get(0).getA().skill.ba.animateAction(frame, scenes.get(0).getA(), g);
					frame++;
				}
				else{
					frame = 0;
					actionRun = true;
					bs.bp.runAction(scenes.get(0).getA());
				}
			}
		}
		
		if(scenes.get(0).getBa() != null){
//			if(!actionRun){
				if(frame < scenes.get(0).getBa().frames){
					scenes.get(0).getBa().animateEffect(frame, g);
					frame++;
				}
				else{
					frame = 0;
					actionRun = true;
				}
//			}
		}
		
	}
	
	//Animate Actions
	public void addScene(String text, Action a, Boolean auto){
		this.scenes.add(new BattleScene(text,a, true));
	}
	
	//Animate non-action effects
	public void addScene(String text, BattleAnimation ba, Boolean auto){
		this.scenes.add(new BattleScene(text,ba, true));
	}
	
	//Text without animations
	public void addScene(String text){
		this.scenes.add(new BattleScene(text, true));
	}

}
