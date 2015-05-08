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

public class BattleSprites {
	
	public StateManager sm;
	public Game game;
	public ArrayList<Schmuck>allies=new ArrayList<Schmuck>();
	public ArrayList<Schmuck> enemy=new ArrayList<Schmuck>();
	public BattleState bs;
	public BattleSprites(Game game, StateManager sm, ArrayList<Schmuck>party,ArrayList<Schmuck>enemy,BattleState bs){
		this.game=game;
		this.sm=sm;
		this.allies = party;
		this.enemy=enemy;
		this.bs=bs;

	}
	
	public void tick() {

	}
			

	public void render(Graphics g) {
//		System.out.println(enemy.get(0).baseStats[0]);
		g.setColor(new Color(200,200,0));
		g.fillOval(60+bs.bp.currentlySelected*100,295,75,75);
		for(int i=0;i<allies.size();i++){
			g.drawImage(allies.get(i).getBattleSprite(), 48+i*100, 266,100,150,null);
			g.setColor(new Color(204,0,0));
			g.fillRect(58+i*100, 260, 80, 5);
			g.setColor(new Color(0,204,0));
			g.fillRect(58+i*100, 260, 80*allies.get(i).getCurrentHp()/allies.get(i).getMaxHp(), 5);
		}
		for(int i=0;i<enemy.size();i++){
			g.drawImage(enemy.get(i).getBattleSprite(), 440-i*150,10,200,150,null);
			g.setColor(new Color(204,0,0));
			g.fillRect(490-i*150, 30, 80, 5);
			g.setColor(new Color(0,204,0));
			g.fillRect(490-i*150, 30, 80*enemy.get(i).getCurrentHp()/enemy.get(i).getMaxHp(), 5);
//			System.out.print(enemy.get(i).getCurrentHp());
		
		}

	}

}
