package dev.zt.UpliftedVFFV.Battle;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.gfx.ImageLoader;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.states.StateManager;
import dev.zt.UpliftedVFFV.statusEffects.Queried;
import dev.zt.UpliftedVFFV.statusEffects.Untouchable;
import dev.zt.UpliftedVFFV.statusEffects.incapacitate;

public class BattleSprites {
	
	public StateManager sm;
	public Game game;
	public ArrayList<Schmuck>allies=new ArrayList<Schmuck>();
	public ArrayList<Schmuck> enemy=new ArrayList<Schmuck>();
	public ArrayList<Schmuck> alliesTargets=new ArrayList<Schmuck>();
	public ArrayList<Schmuck> alliesSelectable=new ArrayList<Schmuck>();
	public ArrayList<Schmuck> enemyTargets=new ArrayList<Schmuck>();
	public ArrayList<Schmuck> enemySelectable=new ArrayList<Schmuck>();
	public BattleState bs;
	private BufferedImage uihealth, enemyhealth;
	
	public BattleSprites(Game game, StateManager sm, ArrayList<Schmuck>party,ArrayList<Schmuck>enemy,BattleState bs){
		this.game=game;
		this.sm=sm;
		this.allies = party;
		this.enemy=enemy;
		this.bs=bs;
		int sumSize1 = 0;
		
		// Load UI elements.
		uihealth = ImageLoader.loadImage("/ui/PlayerGauge.png");
		enemyhealth = ImageLoader.loadImage("/ui/EnemyGaugeQueried.png");
		//Place allies.
		for(int i=0;i<allies.size();i++){
			if(allies.get(i).getX()==0){
				sumSize1 += (allies.get(i).BattleSprite.getWidth()-30);
				allies.get(i).setX(sumSize1-80);
			}
			if(allies.get(i).getY()==0){
				allies.get(i).setY(250 + (25 * i) - allies.size() * 15);
			}
		}
		//Place enemies.
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
		targetUpdate();
	}
	
	public void tick() {
		for(Schmuck s : allies){
			if(s.getFlashDuration()>0){
				flash(s,s.getFlashDuration()-1);
			}
		}
		for(Schmuck s : enemy){
			if(s.getFlashDuration()>0){
				flash(s,s.getFlashDuration()-1);
			}
		}
	}
	
	public void render(Graphics g) {
		//Draw players and player bars.
		for(int i = 0; i < allies.size(); i++){
			if(allies.get(i).visible){
				g.drawImage(allies.get(i).getBattleSprite(), allies.get(i).getX(), allies.get(i).getY(), allies.get(i).getBattleSprite().getWidth(), allies.get(i).getBattleSprite().getHeight(), null);
			}
			drawPlayerBar(g, allies.get(i), i);
		}
		
		//Draw action icons.
		for(Action a : bs.bp.TurnOrderQueue){
			if(a != null){
				if(allies.contains(a.user)){
					g.drawImage(a.skill.icon, allies.get(allies.indexOf(a.user)).getX() + 9, allies.get(allies.indexOf(a.user)).getY() - 44, null);
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
		
		//Draw enemy bars.
		for(int i = 0; i < enemySelectable.size(); i++){
			Schmuck temp = enemySelectable.get(i);
			//Draw sprite.
			if(temp.visible){
				g.drawImage(temp.getBattleSprite(), temp.getX(), temp.getY(), temp.getBattleSprite().getWidth(), temp.getBattleSprite().getHeight(), null);
			}
			//Draw enemy gauge if foe has been queried.
			if(bs.bp.stm.checkStatus(temp, new Queried(temp))){
				drawEnemyBar(g, temp);
			}		
		}
	}
	
	public void targetUpdate(){
		alliesTargets.clear();
		alliesSelectable.clear();
		for(Schmuck s : allies){
			if(!bs.bp.stm.checkStatus(s, new incapacitate(s))){
				alliesSelectable.add(s);
				if(!bs.bp.stm.checkStatus(s, new Untouchable(1,s))){
					alliesTargets.add(s);
				}				
			}
			
		}
		enemyTargets.clear();
		enemySelectable.clear();
		for(Schmuck s : enemy){
			if(!bs.bp.stm.checkStatus(s, new incapacitate(s))){
				enemySelectable.add(s);
				if(!bs.bp.stm.checkStatus(s, new Untouchable(1, s))){
					enemyTargets.add(s);
				}
			}
		}
		bs.bp.currentlySelected = 0;
	}
	
	
	//Helper method for drawing Status Gauge for player characters.
	private void drawPlayerBar(Graphics g, Schmuck s, int index){
		//Draw status circle.
		g.setColor(Color.white);
		g.fillOval(s.getX() - 5, s.getY() - 58, 59, 59);
		if(bs.bp.currentlySelected == index){
			g.setColor(Color.green);
			g.fillOval(s.getX() - 5, s.getY() - 58, 59, 59);
		}
		
		//Draw health bar.
		g.setColor(Color.green);
		g.fillRect(s.getX() + 50, s.getY() - 44, 60 * s.getCurrentHp() / s.getMaxHp(), 7);
		//Draw meter.
		g.setColor(Color.blue);
		g.fillRect(s.getX() + 54, s.getY() - 35, 58 * s.getCurrentBp() / s.getMaxBp(), 4);	
		
		//Draw overlay.
		g.drawImage(uihealth, s.getX() - 5, s.getY() - 60, uihealth.getWidth(), uihealth.getHeight(), null);
		
		//Draw health and meter numbers.
		g.setColor(Color.white);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 11));
		g.drawString(s.getCurrentHp() + "", s.getX() + 109, s.getY() - 37);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 9));
		g.drawString(s.getCurrentBp() + "", s.getX() + 104, s.getY() - 30);
		
		//Draw status icons.
	}
	
	//Helper method for drawing Status Gauge for enemy characters.
	private void drawEnemyBar(Graphics g, Schmuck s){
		//Draw overlay.
		g.drawImage(enemyhealth, s.getX() + (s.getBattleSprite().getWidth() - enemyhealth.getWidth()) / 2, s.getY() - 10, enemyhealth.getWidth(), enemyhealth.getHeight(), null);
		//Draw HP Bar.
		g.setColor(Color.red);
		g.fillRect(s.getX() + 6 + (s.getBattleSprite().getWidth() - enemyhealth.getWidth()) / 2, s.getY() + 12, (s.getCurrentHp() / s.getMaxHp()) * 53, 2);
	}
	
	//Blinks battle sprite. Used when Schmuck is taking damage.
	public void flash(Schmuck s, int duration){
		s.setFlashDuration(duration-1);
		if(s.isVisible()){
			s.setVisible(false);
		}
		else{
			s.setVisible(true);
		}
		if(s.getFlashDuration()<=0){
			s.setVisible(true);
		}
	}
}
