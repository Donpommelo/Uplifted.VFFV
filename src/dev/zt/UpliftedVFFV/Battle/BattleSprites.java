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
import dev.zt.UpliftedVFFV.statusEffects.incapacitate;

public class BattleSprites {
	
	public StateManager sm;
	public Game game;
	public ArrayList<Schmuck>allies=new ArrayList<Schmuck>();
	public ArrayList<Schmuck> enemy=new ArrayList<Schmuck>();
	public ArrayList<Schmuck>alliesTargets=new ArrayList<Schmuck>();
	public ArrayList<Schmuck> enemyTargets=new ArrayList<Schmuck>();
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
		targetUpdate();
	}
	
	public void tick() {

	}
			

	public void render(Graphics g) {
		g.setColor(new Color(200,200,0));
		g.fillOval(allies.get(bs.bp.currentlySelected).getX()+15,allies.get(bs.bp.currentlySelected).getY()+60,75,75);
		for(int i=0;i<allies.size();i++){
			g.setColor(new Color(255,255,0));
			g.drawString("Hp: "+allies.get(i).getCurrentHp()+"/"+allies.get(i).getMaxHp(), allies.get(i).getX()+20, allies.get(i).getY()-20);
			g.drawString("Mp: "+allies.get(i).getCurrentBp()+"/"+allies.get(i).getMaxBp(), allies.get(i).getX()+20, allies.get(i).getY());
			if(!bs.bp.stm.checkStatus(allies.get(i), new incapacitate())){
				g.drawImage(allies.get(i).getBattleSprite(), allies.get(i).getX(),allies.get(i).getY(),allies.get(i).getBattleSprite().getWidth(),allies.get(i).getBattleSprite().getHeight(),null);
			}
			g.setColor(new Color(204,0,0));
			g.fillRect(allies.get(i).getX()+20, allies.get(i).getY()-20, 80, 5);
			g.setColor(new Color(0,204,0));
			g.fillRect(allies.get(i).getX()+20, allies.get(i).getY()-20, 80*allies.get(i).getCurrentHp()/allies.get(i).getMaxHp(), 5);
			g.setColor(new Color(0,0,204));
			g.fillRect(allies.get(i).getX()+20, allies.get(i).getY()-15, 80*allies.get(i).getCurrentBp()/allies.get(i).getMaxBp(), 5);
/*			if(bs.bp.TurnOrderQueue.contains(allies.get(i))){
				if(bs.bp.TurnOrderQueue.get(bs.bp.TurnOrderQueue.indexOf(allies.get(i))) != null){
					g.drawImage(bs.bp.TurnOrderQueue.get(bs.bp.TurnOrderQueue.indexOf(allies.get(i))).skill.icon, allies.get(i).getX(), allies.get(i).getY(), null);
				}
			}*/			
		}
		for(Action a :bs.bp.TurnOrderQueue){
			if(a!=null){
				if(allies.contains(a.user)){
					g.drawImage(a.skill.icon,allies.get(allies.indexOf(a.user)).getX(),allies.get(allies.indexOf(a.user)).getY(),null);
				}
			}
		}
		for(int i=0;i<enemy.size();i++){
			if(!bs.bp.stm.checkStatus(enemy.get(i), new incapacitate())){
				g.drawImage(enemy.get(i).getBattleSprite(), enemy.get(i).getX(),enemy.get(i).getY(),enemy.get(i).getBattleSprite().getWidth(),enemy.get(i).getBattleSprite().getHeight(),null);
				g.setColor(new Color(204,0,0));
				g.fillRect(enemy.get(i).getX(), enemy.get(i).getY(), 80, 5);
				g.setColor(new Color(0,204,0));
				g.fillRect(enemy.get(i).getX(), enemy.get(i).getY(), 80*enemy.get(i).getCurrentHp()/enemy.get(i).getMaxHp(), 5);
			}
		
		}

	}
	
	public void targetUpdate(){
		alliesTargets.clear();
		for(Schmuck s : allies){
			if(!bs.bp.stm.checkStatus(s, new incapacitate())){
				alliesTargets.add(s);
			}
			
		}
		for(Schmuck s : enemy){
			if(!bs.bp.stm.checkStatus(s, new incapacitate())){
				enemyTargets.add(s);
			}
		}
	}

}
