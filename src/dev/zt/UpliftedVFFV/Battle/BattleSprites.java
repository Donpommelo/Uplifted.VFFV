package dev.zt.UpliftedVFFV.Battle;

import java.awt.Color;
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
	public ArrayList<Schmuck>alliesTargets=new ArrayList<Schmuck>();
	public ArrayList<Schmuck> enemyTargets=new ArrayList<Schmuck>();
	public BattleState bs;
	private BufferedImage uihealth;
	
	public BattleSprites(Game game, StateManager sm, ArrayList<Schmuck>party,ArrayList<Schmuck>enemy,BattleState bs){
		this.game=game;
		this.sm=sm;
		this.allies = party;
		this.enemy=enemy;
		this.bs=bs;
		int sumSize1 = 0;
		
		// Load UI elements.
		uihealth = ImageLoader.loadImage("/ui/PlayerGauge.png");
		
		for(int i=0;i<allies.size();i++){
			if(allies.get(i).getX()==0){
				sumSize1 += (allies.get(i).BattleSprite.getWidth()-40);
				allies.get(i).setX(sumSize1-80);
			}
			if(allies.get(i).getY()==0){
				allies.get(i).setY(250 + (25 * i) - allies.size() * 15);
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
		g.setColor(new Color(200,200,0));
		if(!alliesTargets.isEmpty()){
			g.fillOval(alliesTargets.get(bs.bp.currentlySelected).getX()+15,alliesTargets.get(bs.bp.currentlySelected).getY()+150,90,45);
		}
		
		for(int i=0;i<allies.size();i++){
			if(allies.get(i).visible){
				g.drawImage(allies.get(i).getBattleSprite(), allies.get(i).getX(),allies.get(i).getY(),allies.get(i).getBattleSprite().getWidth(),allies.get(i).getBattleSprite().getHeight(),null);
			}
			//g.setColor(new Color(204,0,0));
			//g.fillRect(allies.get(i).getX()+20, allies.get(i).getY()-20, 80, 5);		
			g.setColor(new Color(0,204,0));
			g.fillRect(allies.get(i).getX() + 48 + 10 * i, allies.get(i).getY() - 49, 65 * allies.get(i).getCurrentHp()/allies.get(i).getMaxHp(), 7);
			g.setColor(new Color(0,0,204));
			g.fillRect(allies.get(i).getX() + 52 + 10 * i, allies.get(i).getY() - 41, 52*allies.get(i).getCurrentBp()/allies.get(i).getMaxBp(), 4);	
			
			g.drawImage(uihealth, allies.get(i).getX() - 10 + 10 * i, allies.get(i).getY() - allies.get(i).getBattleSprite().getHeight() / 3, uihealth.getWidth(), uihealth.getHeight(), null);

			g.setColor(new Color(255,255,0));
			g.drawString("Hp: "+allies.get(i).getCurrentHp()+"/"+allies.get(i).getMaxHp(), allies.get(i).getX() + 55 + 10 * i, allies.get(i).getY() - 48);
			g.drawString("Mp: "+allies.get(i).getCurrentBp()+"/"+allies.get(i).getMaxBp(), allies.get(i).getX() + 55 + 10 * i, allies.get(i).getY() - 38);
		
		}
		 
		for(Action a :bs.bp.TurnOrderQueue){
			if(a!=null){
				if(allies.contains(a.user)){
					g.drawImage(a.skill.icon,allies.get(allies.indexOf(a.user)).getX() + 6 + 10 * allies.indexOf(a.user), allies.get(allies.indexOf(a.user)).getY() - allies.get((allies.indexOf(a.user))).getBattleSprite().getHeight() / 3 + 16, null);
				}
			}
			g.setColor(new Color(0,0,0));
			if(a != null){
				g.drawString(a.user.getName()+" "+a.skill.getName(),110, 45+25*bs.bp.TurnOrderQueue.indexOf(a));
			}
			else{
				g.drawString("null",110,45+25*bs.bp.TurnOrderQueue.indexOf(a));
			}
		}
		for(int i=0;i<enemyTargets.size();i++){
			Schmuck temp = enemyTargets.get(i);
				if(temp.visible){
					g.drawImage(temp.getBattleSprite(), temp.getX(),temp.getY(),temp.getBattleSprite().getWidth(),temp.getBattleSprite().getHeight(),null);
				}
				if(bs.bp.stm.checkStatus(temp, new Queried(temp))){
					g.setColor(new Color(204,0,0));
					g.fillRect(temp.getX(), temp.getY(), 80, 5);
					g.setColor(new Color(0,204,0));
					g.fillRect(temp.getX(), temp.getY(), 80*temp.getCurrentHp()/temp.getMaxHp(), 5);
				}		
		}

	}
	
	public void targetUpdate(){
		alliesTargets.clear();
		for(Schmuck s : allies){
			if(!bs.bp.stm.checkStatus(s, new incapacitate(s)) && !bs.bp.stm.checkStatus(s, new Untouchable(1,s))){
				alliesTargets.add(s);
			}
			
		}
		enemyTargets.clear();
		for(Schmuck s : enemy){
			if(!bs.bp.stm.checkStatus(s, new incapacitate(s)) && !bs.bp.stm.checkStatus(s, new Untouchable(1, s))){
				enemyTargets.add(s);
			}
		}
		bs.bp.currentlySelected = 0;
	}
	
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
