package dev.zt.UpliftedVFFV.Battle;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.states.StateManager;
import dev.zt.UpliftedVFFV.statusEffects.Invisible;
import dev.zt.UpliftedVFFV.statusEffects.incapacitate;

public class BattleSprites {
	
	//Battle Sprites manages the various sprites of player and enemy Schmucks

	//All allies/enemies
	public ArrayList<Schmuck>allies=new ArrayList<Schmuck>();
	public ArrayList<Schmuck> enemy=new ArrayList<Schmuck>();
	
	//All allies/enemies that are not Invisible
	public ArrayList<Schmuck> alliesTargets=new ArrayList<Schmuck>();
	public ArrayList<Schmuck> enemyTargets=new ArrayList<Schmuck>();

	//All allies/enemies that are not Incapacitated
	public ArrayList<Schmuck> alliesSelectable=new ArrayList<Schmuck>();
	public ArrayList<Schmuck> enemySelectable=new ArrayList<Schmuck>();
	
	public BattleState bs;
	public StateManager sm;
	public Game game;
	
	public BattleSprites(Game game, StateManager sm, ArrayList<Schmuck>party,ArrayList<Schmuck>enemy,BattleState bs){
		this.game=game;
		this.sm=sm;
		this.allies = party;
		this.enemy=enemy;
		this.bs=bs;
		
		
		// Load UI elements.
		
		//place allies/enemies in their positions
		locationUpdate();
		
		//Update valid selectable/targetable allies + enemies.
		targetUpdate();
	}
	
	public void tick() {
		
		
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
		
		//Causes Schmucks to flash.
		for(Schmuck s : allies){
			if(s.getFlashDuration()>0){
				flashContinue(s,s.getFlashDuration()-1,g);
			}
		}
		for(Schmuck s : enemy){
			if(s.getFlashDuration()>0){
				flashContinue(s,s.getFlashDuration()-1,g);
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
				if(!bs.bp.stm.checkStatus(s, new Invisible(1,s,50))){
					alliesTargets.add(s);
				}				
			}
		}
		enemyTargets.clear();
		enemySelectable.clear();
		for(Schmuck s : enemy){
			if(!bs.bp.stm.checkStatus(s, new incapacitate(s))){
				enemySelectable.add(s);
				if(!bs.bp.stm.checkStatus(s, new Invisible(1, s, 50))){
					enemyTargets.add(s);
				}
			}
		}
		bs.bp.currentlySelected = 0;
	}
	
	//Sets Schmucks' locations  
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
	
	//Initiates blinking battle sprite. Used when Schmuck is taking damage.
	//Also causes number to appear.
	public void flash(Schmuck s, int duration, int damage, int element){
		s.setFlashDuration(duration-1);
		s.setDamageTaken(damage);
		s.setColorDamage(element);
	}
	
	//Blinks battle sprite. Used when Schmuck is taking damage.
	//Also makes animated damage thing appear.
	public void flashContinue(Schmuck s, int duration, Graphics g){
		s.setFlashDuration(duration-1);
		if(s.getDamageTaken() > 0){
			if(s.isVisible()){
				s.setVisible(false);
			}
			else{
				s.setVisible(true);
			}
		}
		if(s.getFlashDuration()<=0){
			s.setVisible(true);
		}
		g.setFont(new Font("Chewy", Font.PLAIN, 26));
		switch(s.getColorDamage()){
		case 0:
			g.setColor(Color.RED);
			break;
		case 1:
			g.setColor(Color.BLUE);
			break;
		case 2:
			g.setColor(Color.GREEN);
			break;
		case 3:
			g.setColor(Color.YELLOW);
			break;
		case 4:
			g.setColor(Color.PINK);
			break;
		case 5:
			g.setColor(Color.BLACK);
			break;
		case 6:
			g.setColor(Color.BLACK);
			break;
		}
		int fdura = 120-s.getFlashDuration();
		if(s.getDamageTaken() > 0){
			if(fdura < 10){
				g.drawString("-"+s.getDamageTaken()+" HP", s.getX()+s.getBattleSprite().getWidth()/2, s.getY()-3*fdura + 30);
			}
			else if(fdura < 40){
				g.drawString("-"+s.getDamageTaken()+" HP", s.getX()+s.getBattleSprite().getWidth()/2, s.getY()+fdura);
			}
			else{
				g.drawString("-"+s.getDamageTaken()+" HP", s.getX()+s.getBattleSprite().getWidth()/2, s.getY() + 30);
			}
		}
		else{
			if(fdura < 40){
				g.drawString("+"+-s.getDamageTaken()+" HP", s.getX()+s.getBattleSprite().getWidth()/2, s.getY()-fdura + 70);
			}
			else {
				g.drawString("+"+-s.getDamageTaken()+" HP", s.getX()+s.getBattleSprite().getWidth()/2, s.getY()+30);
			}

		}
		
	}
}
