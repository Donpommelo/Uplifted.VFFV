package dev.zt.UpliftedVFFV.Battle;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.gfx.ImageLoader;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.states.StateManager;
import dev.zt.UpliftedVFFV.statusEffects.Queried;



public class BattleUI {
	
	private BufferedImage uihealth, enemyhealth;
	public StateManager sm;
	public Game game;
	public ArrayList<Schmuck> allies = new ArrayList<Schmuck>();
	public ArrayList<Schmuck> enemy = new ArrayList<Schmuck>();
	public BattleState bs;
	
	public BattleUI(Game game, StateManager sm, ArrayList<Schmuck> party, ArrayList<Schmuck> enemy, BattleState bs){
		this.game = game;
		this.sm = sm;
		this.allies = party;
		this.enemy=enemy;
		this.bs = bs;
		
		uihealth = ImageLoader.loadImage("/ui/PlayerGauge.png");
		enemyhealth = ImageLoader.loadImage("/ui/EnemyGaugeQueried.png");
	}
	
	public void tick(){
		
	}
	
	public void render(Graphics g){
		for(int i = 0; i < allies.size(); i++){
			drawPlayerBar(g, allies.get(i), i);
		}
		
		//Draw action icons.
		for(Action a : bs.bp.TurnOrderQueue){
			if(a != null){
				if(allies.contains(a.user)){
					g.drawImage(a.skill.icon, allies.get(allies.indexOf(a.user)).getX() + 9, allies.get(allies.indexOf(a.user)).getY() + 121, null);
				}
			}
			
			//Write out skills for debugging.
			g.setColor(new Color(0,0,0));
			g.setFont(new Font("TimesRoman", Font.PLAIN, 16));
			if(a != null){
				g.drawString(a.user.getName()+" "+a.skill.getName(),110, 45+25*bs.bp.TurnOrderQueue.indexOf(a));
			}
			else{
				g.drawString("null",110,45+25*bs.bp.TurnOrderQueue.indexOf(a));
			}
		}
		
		//Draw enemy gauge if foe has been queried.
		for(int i = 0; i < bs.bs.enemySelectable.size(); i++){
			Schmuck temp = bs.bs.enemySelectable.get(i);				
			if(bs.bp.stm.checkStatus(temp, new Queried(temp, 50))){
				drawEnemyBar(g, temp);
			}
		}
		
		//Draw pointer.
		if(bs.bp.bm != null && bs.bp.bm.phase == 3){
			int yoffset = 2;
			if(bs.bs.alliesTargets.contains(bs.bp.bm.pointed)){
				g.drawImage(Assets.Crosshair1, bs.bp.bm.pointed.getX() +(bs.bp.bm.pointed.getBattleSprite().getWidth() - Assets.Crosshair1.getWidth()) / 2, 
						bs.bp.bm.pointed.getY() + bs.bp.bm.pointed.getBattleSprite().getHeight() / yoffset, null);
			} else if(bs.bs.enemyTargets.contains(bs.bp.bm.pointed)){
				g.drawImage(Assets.Crosshair1, bs.bp.bm.pointed.getX() +(bs.bp.bm.pointed.getBattleSprite().getWidth() - Assets.Crosshair1.getWidth()) / 2, 
						bs.bp.bm.pointed.getY() + bs.bp.bm.pointed.getBattleSprite().getHeight() / yoffset, null);
			}
			
			//Draw target name.
			g.setColor(new Color(0, 0, 0, 150));
			FontMetrics metric = g.getFontMetrics(new Font("Chewy", Font.PLAIN, 16));
			
//			if(bs.bs.alliesTargets.contains(bs.bp.bm.pointed)){
//				yoffset = 2;			
//			} else if(bs.bs.enemyTargets.contains(bs.bp.bm.pointed)){
//				yoffset = 2;
//			}
			g.fillRect(bs.bp.bm.pointed.getX() + (bs.bp.bm.pointed.getBattleSprite().getWidth() - metric.stringWidth(bs.bp.bm.pointed.getName()) - 8) / 2 , 
					bs.bp.bm.pointed.getY() + bs.bp.bm.pointed.getBattleSprite().getHeight() / yoffset + 50, metric.stringWidth(bs.bp.bm.pointed.getName()) + 8, 25);
			g.setFont(new Font("Chewy", Font.PLAIN, 16));
			g.setColor(Color.white);
			g.drawString(bs.bp.bm.pointed.getName() + " ", bs.bp.bm.pointed.getX() + (bs.bp.bm.pointed.getBattleSprite().getWidth() - metric.stringWidth(bs.bp.bm.pointed.getName())) / 2, 
					bs.bp.bm.pointed.getY() + bs.bp.bm.pointed.getBattleSprite().getHeight() / yoffset + 64);
		}
		
	}
	
	//Helper method for drawing Status Gauge for player characters.
		private void drawPlayerBar(Graphics g, Schmuck s, int index){
			//Draw status circle.
			g.setColor(Color.white);
			g.fillOval(s.getX() - 5, s.getY() + 107, 59, 59);
			if(bs.bs.alliesSelectable.size() > 0){
				if(bs.bs.alliesSelectable.get(bs.bp.currentlySelected).equals(s)){
					g.setColor(Color.green);
					g.fillOval(bs.bs.alliesSelectable.get(bs.bp.currentlySelected).getX() - 5, 
							bs.bs.alliesSelectable.get(bs.bp.currentlySelected).getY() + 107, 59, 59);
				}
			}
			if(!bs.bs.alliesSelectable.contains(s)){
				g.setColor(Color.red);
				g.fillOval(s.getX() - 5, s.getY() + 107, 59, 59);
			}
			//Draw health bar.
			g.setColor(Color.green);
			g.fillRect(s.getX() + 50, s.getY() + 121, 60 * s.getCurrentHp() / s.getMaxHp(), 7);
			//Draw meter.
			g.setColor(Color.blue);
			g.fillRect(s.getX() + 54, s.getY() + 130, 58 * s.getCurrentBp() / s.getMaxBp(), 4);	
			
			//Draw overlay.
			g.drawImage(uihealth, s.getX() - 5, s.getY() + 105, uihealth.getWidth(), uihealth.getHeight(), null);
			
			//Draw health and meter numbers.
			g.setColor(Color.white);
			g.setFont(new Font("TimesRoman", Font.PLAIN, 11));
			g.drawString(s.getCurrentHp() + "", s.getX() + 109, s.getY() + 128);
			g.setFont(new Font("TimesRoman", Font.PLAIN, 9));
			g.drawString(s.getCurrentBp() + "", s.getX() + 104, s.getY() + 135);
			
			//Draw status icons.
		}
		
		//Helper method for drawing Status Gauge for enemy characters.
		private void drawEnemyBar(Graphics g, Schmuck s){
			//Draw overlay.
			g.drawImage(enemyhealth, s.getX() + (s.getBattleSprite().getWidth() - enemyhealth.getWidth()) / 2, s.getY() - 10, enemyhealth.getWidth(), enemyhealth.getHeight(), null);
			//Draw HP Bar.
			g.setColor(Color.red);
			g.fillRect(s.getX() + 6 + (s.getBattleSprite().getWidth() - enemyhealth.getWidth()) / 2, s.getY() + 12, 53 * s.getCurrentHp() / s.getMaxHp(), 2);
		}	
}
