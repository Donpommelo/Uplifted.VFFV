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
		int sumSize1 = 0;
		for(int i=0;i<allies.size();i++){
			if(allies.get(i).getX()==0){
				sumSize1 += (allies.get(i).BattleSprite.getWidth()-40);
				allies.get(i).setX(sumSize1-80);
			}
			if(allies.get(i).getY()==0){
				allies.get(i).setY(250+15*i-allies.size()*15);
			}
		}
		int sumSize2 = 0;
		for(int i=0;i<enemy.size();i++){
			if(enemy.get(i).getX()==0){
				sumSize2 += (enemy.get(i).BattleSprite.getWidth()-40);
				enemy.get(i).setX(610-sumSize2);
			}
			if(enemy.get(i).getY()==0){
				enemy.get(i).setY(10-15*i+enemy.size()*15);
			}

		}

	}
	
	public void tick() {

	}
			

	public void render(Graphics g) {
		g.setColor(new Color(200,200,0));
		g.fillOval(allies.get(bs.bp.currentlySelected).getX()+15,allies.get(bs.bp.currentlySelected).getY()+60,75,75);
		for(int i=0;i<allies.size();i++){
			g.drawImage(allies.get(i).getBattleSprite(), allies.get(i).getX(),allies.get(i).getY(),allies.get(i).getBattleSprite().getWidth(),allies.get(i).getBattleSprite().getHeight(),null);
			g.setColor(new Color(204,0,0));
			g.fillRect(allies.get(i).getX(), allies.get(i).getY(), 80, 5);
			g.setColor(new Color(0,204,0));
			g.fillRect(allies.get(i).getX(), allies.get(i).getY(), 80*allies.get(i).getCurrentHp()/allies.get(i).getMaxHp(), 5);
		}
		for(int i=0;i<enemy.size();i++){
			g.drawImage(enemy.get(i).getBattleSprite(), enemy.get(i).getX(),enemy.get(i).getY(),enemy.get(i).getBattleSprite().getWidth(),enemy.get(i).getBattleSprite().getHeight(),null);
//			g.drawImage(enemy.get(i).getBattleSprite(), enemy.get(i).getX(), enemy.get(i).getY(),100,100,null);
			g.setColor(new Color(204,0,0));
			g.fillRect(enemy.get(i).getX(), enemy.get(i).getY(), 80, 5);
			g.setColor(new Color(0,204,0));
			g.fillRect(enemy.get(i).getX(), enemy.get(i).getY(), 80*enemy.get(i).getCurrentHp()/enemy.get(i).getMaxHp(), 5);
		
		}

	}

}
