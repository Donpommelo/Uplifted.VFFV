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
		
		
		// Load UI elements.
		
		locationUpdate();
		//Update valid selectable/targetable allies + enemies.
		targetUpdate();
	}
	
	public void tick() {
		
		//Causes Schmucks to flash.
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
			
		//Draw enemy bars. Only selectable(not incapacitated) enemies are drawn.
		for(int i = 0; i < enemySelectable.size(); i++){
			Schmuck temp = enemySelectable.get(i);
			//Draw sprite.
			if(temp.visible){
				g.drawImage(temp.getBattleSprite(), temp.getX(), temp.getY(), temp.getBattleSprite().getWidth(), temp.getBattleSprite().getHeight(), null);
			}	
		}
	}
	
	//Updates lists of targetable and selectable allies and enemies. 
	//This should be called whenever a schmuck is incapacitated or becomes untargetable.
	//This is called after every action in the Battle Processor as well as in the EffectManager upon incapacitation.
	//Call this whenever you change a Schmuck's Hp in battle without using the EffectManager.
	public void targetUpdate(){
		alliesTargets.clear();
		alliesSelectable.clear();
		for(Schmuck s : allies){
			if(!bs.bp.stm.checkStatus(s, new incapacitate(s))){
				alliesSelectable.add(s);
				if(!bs.bp.stm.checkStatus(s, new Untouchable(1,s,50))){
					alliesTargets.add(s);
				}				
			}
		}
		enemyTargets.clear();
		enemySelectable.clear();
		for(Schmuck s : enemy){
			if(!bs.bp.stm.checkStatus(s, new incapacitate(s))){
				enemySelectable.add(s);
				if(!bs.bp.stm.checkStatus(s, new Untouchable(1, s, 50))){
					enemyTargets.add(s);
				}
			}
		}
		bs.bp.currentlySelected = 0;
	}
	
	public void locationUpdate(){
		int sumSize1 = -20;
		//Place allies.
		for(int i=0;i<allies.size();i++){
			if(allies.get(i).defaultLocation()){
				sumSize1 += (allies.get(i).getBattleSprite().getWidth() - 28);
				allies.get(i).setX(sumSize1-80);
				allies.get(i).setY(250 + ((25 - allies.size() * 2) * i) - allies.size() * 12);
			}
			
		}
		//Place enemies.
		int sumSize2 = 0;
		for(int i=0;i<enemy.size();i++){
			if(enemy.get(i).defaultLocation()){
				sumSize2 += (enemy.get(i).getBattleSprite().getWidth()-40);
				enemy.get(i).setX(610-sumSize2);			
				enemy.get(i).setY(10-15*i+enemy.size()*15);
			}
		}
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
