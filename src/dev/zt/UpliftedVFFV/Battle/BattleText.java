package dev.zt.UpliftedVFFV.Battle;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.gfx.Assets;
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
	public BattleText(Game game, StateManager sm, ArrayList<Schmuck>party,ArrayList<Schmuck>enemy, BattleState bs){
		this.game=game;
		this.sm=sm;
		this.allies = party;
		this.enemy=enemy;
		this.bs = bs;

	}
	
	public void tick() {
		if(game.getKeyManager().space){
			
			if(!textList.isEmpty()){
			textList.remove(0);
			}
			if(ranAway){
				bs.end(false);
			}
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
			

	public void render(Graphics g) {
			g.setColor(new Color(160, 160,160, 200));
			g.setFont(new Font("Chewy", Font.PLAIN, 18));
			g.fillRect(0, 0, 640, 25);
			g.setColor(new Color(0,0,0));
			g.drawString(textList.get(0),0,20);	

	}

}
