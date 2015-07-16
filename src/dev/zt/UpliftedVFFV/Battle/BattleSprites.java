package dev.zt.UpliftedVFFV.Battle;

import java.awt.Graphics;
import java.util.ArrayList;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.states.StateManager;
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
	
	
	public BattleSprites(Game game, StateManager sm, ArrayList<Schmuck>party,ArrayList<Schmuck>enemy,BattleState bs){
		this.game=game;
		this.sm=sm;
		this.allies = party;
		this.enemy=enemy;
		this.bs=bs;
		int sumSize1 = -20;
		
		// Load UI elements.
		
		//Place allies.
		for(int i=0;i<allies.size();i++){
			if(allies.get(i).getX()==0){
				sumSize1 += (allies.get(i).BattleSprite.getWidth() - 28);
				allies.get(i).setX(sumSize1-80);
			}
			if(allies.get(i).getY()==0){
				allies.get(i).setY(250 + ((25 - allies.size() * 2) * i) - allies.size() * 12);
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
		}
		
		
		
		//Draw enemy bars.
		for(int i = 0; i < enemySelectable.size(); i++){
			Schmuck temp = enemySelectable.get(i);
			//Draw sprite.
			if(temp.visible){
				g.drawImage(temp.getBattleSprite(), temp.getX(), temp.getY(), temp.getBattleSprite().getWidth(), temp.getBattleSprite().getHeight(), null);
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
