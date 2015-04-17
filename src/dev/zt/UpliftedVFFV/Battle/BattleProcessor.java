package dev.zt.UpliftedVFFV.Battle;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.ablities.ItemNothing;
import dev.zt.UpliftedVFFV.ablities.StandardAttack;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.states.DialogState;
import dev.zt.UpliftedVFFV.states.GameState;
import dev.zt.UpliftedVFFV.states.StateManager;

public class BattleProcessor {
	public ArrayList<Schmuck>allies = new ArrayList<Schmuck>();
	public ArrayList<Schmuck> enemy = new ArrayList<Schmuck>();
	public ArrayList<Schmuck> battlers = new ArrayList<Schmuck>();
	public int troop;
	public int phase;
	public int currentlySelected;
	public boolean selected;
	public boolean fightEnd;
	public Game game;
	public BattleMenu bm;
	public StateManager sm;
	public BattleState bs;
	public GameState gs;
	public ArrayList<Action> TurnOrderQueue = new ArrayList<Action>();
//	public Action[] TurnOrderQueue;
	public BattleProcessor(Game game,StateManager sm,ArrayList<Schmuck> party,ArrayList<Schmuck> enemy,GameState gs,BattleState bs){
		this.game=game;
		this.sm=sm;
		this.bs=bs;
		this.gs=gs;
		this.allies = party;
		this.enemy = enemy;
		phase=1;
		currentlySelected=0;
		selected=false;
		bm = new BattleMenu(game,sm,allies,enemy,bs,allies.get(currentlySelected),gs);
//		TurnOrderQueue = new Action[allies.size()+enemy.size()];
		TurnOrderQueue = new ArrayList<Action>(5);
//		initiate();
		for(int i=0 ; i<enemy.size()+allies.size();i++){
			TurnOrderQueue.add(null);
		}
		
	}
	
	public void tick() {
		
		switch(phase){
		case 0:
			
		case 1:
			if(selected==true){
				bm.tick();
			}
			else{
				
				if(game.getKeyManager().right){
					if(currentlySelected<allies.size()-1){
						currentlySelected++;
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
				if(game.getKeyManager().left){
					if(currentlySelected>0){
						currentlySelected--;
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
				if(game.getKeyManager().space){
					selected=true;
					bm = new BattleMenu(game,sm,allies,enemy,bs,allies.get(currentlySelected),gs);
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				if(game.getKeyManager().enter){
					if(TurnOrderQueue.get(0)!=null && TurnOrderQueue.get(1)!=null){
						for(int i=0 ; i<enemy.size();i++){
							TurnOrderQueue.add(allies.size()+i,new Action(enemy.get(i),allies.get(0),new StandardAttack(0)));
						}
						phase++;
					}
					
					
				}
			}
			break;
		case 2:

			if(game.getKeyManager().space){
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			if(TurnOrderQueue.get(0)!=null){
				System.out.print("meep");
				TurnOrderQueue.get(0).skill.run(TurnOrderQueue.get(0).user,TurnOrderQueue.get(0).target);
				TurnOrderQueue.remove(0);
			}
			else{
				phase++;
			}
			break;
			
		case 3:
			if(game.getKeyManager().space){
				for (int i = 0; i < TurnOrderQueue.size(); i++) {
					TurnOrderQueue.set(i,null);
					currentlySelected=0;
				}
				phase=1;
				}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			}
		}

		
		

	public void render(Graphics g) {
		switch(phase){
		case 0:
			
		case 1:
			if(TurnOrderQueue.get(0)!=null && TurnOrderQueue.get(1)!=null){ 
				g.setColor(new Color(102, 178,255));
				g.fillRect(0, 0,120,40);
				g.setFont(new Font("Chewy", Font.PLAIN, 18));
				g.setColor(new Color(255, 255,255));
				g.drawString("Ready (Enter)",0,25);
			}
			if(selected==true){
				bm.render(g);
			}
			break;
			
		case 2:
			
			break;
		case 3:
			
			break;
		}
	}
	
	public void initiate(){
		
		
		phase++;
		prePhase();
	}
	
	public void prePhase(){
		phase++;
		BattlePhase();
	}
	
	public void BattlePhase(){
		phase++;
		transition();
	}
	
	public void transition(){
		
		phase=0;
		prePhase();
	}
	
	public void sort(){
		
	}
}
