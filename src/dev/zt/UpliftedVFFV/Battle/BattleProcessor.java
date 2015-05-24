package dev.zt.UpliftedVFFV.Battle;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Set;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.ablities.ActuallyNothing;
import dev.zt.UpliftedVFFV.ablities.StandardAttack;
import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.states.GameState;
import dev.zt.UpliftedVFFV.states.StateManager;
import dev.zt.UpliftedVFFV.statusEffects.StatusManager;
import dev.zt.UpliftedVFFV.statusEffects.incapacitate;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class BattleProcessor {
	public ArrayList<Schmuck>allies = new ArrayList<Schmuck>();
	public ArrayList<Schmuck> enemy = new ArrayList<Schmuck>();
	public ArrayList<Schmuck> battlers = new ArrayList<Schmuck>();
	public int troop;
	public int phase;
	public int currentlySelected;
	public boolean selected;
	public boolean ranAway = false;
	public boolean pauseTOQ;
	public boolean allReady = false;;
	public Game game;
	public BattleMenu bm;
	public StateManager sm;
	public StatusManager stm;
	public BattleState bs;
	public BattleText bt;
	public GameState gs;
	public EffectManager em;
	public ArrayList<Action> TurnOrderQueue = new ArrayList<Action>();
	
	public BattleProcessor(Game game,StateManager sm,ArrayList<Schmuck> party,ArrayList<Schmuck> enemy,GameState gs,BattleState bs){
		this.game=game;
		this.sm=sm;
		this.bs=bs;
		this.gs=gs;
		this.allies = party;
		this.enemy = enemy;
		phase=1;
		currentlySelected=0;
			
		bt = new BattleText(game,sm,allies,enemy, bs);
		em = new EffectManager(game,bs,gs);
		stm = new StatusManager(game,bs,gs, this);
		bm = new BattleMenu(game,sm,allies,enemy,bs,allies.get(currentlySelected),gs);
		TurnOrderQueue = new ArrayList<Action>();
//		initiate();
		for(int i=0 ; i<enemy.size()+allies.size();i++){
			TurnOrderQueue.add(null);
		}
		for(Schmuck s : allies){
			battlers.add(s);
		}
		for(Schmuck s : enemy){
			battlers.add(s);
		}
		for(Schmuck s: battlers){
			s.calcBuffs();
		}
		if(enemy.size()>1){
			bt.textList.add(enemy.get(0).getName()+" and co attack.");
		}
		else{
			bt.textList.add(enemy.get(0).getName()+" attacks you.");
		}
				
	}
	
	public void tick() {
		
		if(!bt.textList.isEmpty()){
			bt.tick();
		}
		else{
			switch(phase){
			case 0:
				for(int i=0 ; i<enemy.size()+allies.size();i++){
					TurnOrderQueue.add(null);
				}
				phase++;
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
						if(fightlost() || enemyded()){
							bs.end(!fightlost());
							try {
								Thread.sleep(200);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						if(!allies.get(currentlySelected).statuses.contains(allies.get(currentlySelected).i)){	
							selected=true;
							bm = new BattleMenu(game,sm,allies,enemy,bs,allies.get(currentlySelected),gs);
						}
						else{
							bt.textList.add("he ded");
						}
						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					if(game.getKeyManager().enter){
						if(allReady){
						if(fightlost() || enemyded()){
							bs.end(!fightlost());
							try {
								Thread.sleep(200);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						
							for(int i=0 ; i<enemy.size();i++){
								if(!enemy.get(i).statuses.contains(enemy.get(i).i)){
									TurnOrderQueue.set(allies.size()+i,enemy.get(i).getAction(bs));
								}
								else{
									
									TurnOrderQueue.set(allies.size()+i,new Action(enemy.get(i),allies.get((int)(Math.random()*allies.size())),new ActuallyNothing(0),bs));
								}
							}
							sort(TurnOrderQueue);
							
							ArrayList<Action> TempTurnOrderQueue = new ArrayList<Action>();
//							TempTurnOrderQueue = TurnOrderQueue;
							for(Action a : TurnOrderQueue){
								TempTurnOrderQueue.add(a);
							}
							for(int i = TempTurnOrderQueue.size()-1; i>=0; i--){
								if(TempTurnOrderQueue.get(i) != null){
									
									TempTurnOrderQueue.get(i).skill.TOQChange(TempTurnOrderQueue.get(i), bs);
//									System.out.print(TurnOrderQueue.get(i).user.getName()+" "); //
								}				
							}
						
							phase++;
							allReady = false;
						}
						
						
					}
				}
				break;
			case 2:
				if(pauseTOQ == true){ 				//for the purpose of dillydallying
					bm.tick();
				}				
				if(game.getKeyManager().space){
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				if(fightlost() || enemyded()){
					phase++;
				}

				else if(!TurnOrderQueue.isEmpty()){
					if(TurnOrderQueue.get(0) != null && pauseTOQ == false){
						if(!TurnOrderQueue.get(0).skill.useText(TurnOrderQueue.get(0).user,TurnOrderQueue.get(0).target).equals("DillyDally")){
							if(TurnOrderQueue.get(0).skill.getCost()<TurnOrderQueue.get(0).user.getCurrentBp()){
								em.bpChange(-TurnOrderQueue.get(0).skill.getCost(), TurnOrderQueue.get(0).user);
								TurnOrderQueue.get(0).skill.run(TurnOrderQueue.get(0).user,TurnOrderQueue.get(0).target,bs);
							}
							else{
								bt.textList.add(TurnOrderQueue.get(0).user.getName()+" didn't have the Motivation to "+TurnOrderQueue.get(0).skill.getName());
							}
							bs.bs.targetUpdate();
						}
						else{
							pauseTOQ = true;
							currentlySelected=allies.indexOf(TurnOrderQueue.get(0).user);
							bm = new BattleMenu(game,sm,allies,enemy,bs,TurnOrderQueue.get(0).user,gs);
			
						}
					}
					if(pauseTOQ == false){
						TurnOrderQueue.remove(0);
						for(Schmuck s: battlers){
							s.calcBuffs();
						}
					}
					
				}
				else{					
					stm.endofRound(bs);
					phase++;
				}
				break;
				
			case 3:
				if(fightlost()){
					bt.textList.add("Everything goes black.");
				}
				if(enemyded()){
					bt.textList.add("You won");
					int exp = 0;
					int script = 0;
					for(Schmuck s : enemy){
						exp += s.getExpDrop();
						script += s.getScrDrop();
					}
					for(Schmuck s : allies){
						bt.textList.add(s.getName()+" gains "+exp/allies.size()+" exp!");
						if(s.exp+exp/allies.size()>=Math.pow(s.Lvl,2)*10){
							bt.textList.add(s.getName()+" received a raise!");
							bt.textList.add(s.getName()+" is now level "+ (s.Lvl+1)+"!");
							if(s.getLevelSkills().containsKey(s.Lvl+1)){
								bt.textList.add(s.getName()+" learned "+ s.getLevelSkills().get(s.Lvl+1).getName()+"!");	
							}
						}
						s.expGain(s.getStartStats(),s.getStatGrowths(),exp/allies.size());
					}					
					bt.textList.add(script+" Company Script looted!");
					gs.scriptChange(script);
					for(Schmuck s : enemy){
						Set<Item> temp = s.getItemdrops().keySet();
						Item[] itemDisplay = temp.toArray(new Item[999]);
						for(int i=0; i<s.getItemdrops().size();i++){		
							if(Math.random()<=s.getItemdrops().get(itemDisplay[i])){
								bt.textList.add("Looted a "+itemDisplay[i].getName()+"!");
								gs.inventorymanager.loot(itemDisplay[i], 1);
							}
						}
					}
					stm.endofFite();
				}
				phase=0;
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

		
		

	public void render(Graphics g) {
		
		if(!bt.textList.isEmpty()){
			bt.render(g);
		}
		else{
			switch(phase){
			case 0:
				
			case 1:
				int numReady = 0;
				for(Action a :TurnOrderQueue){
					if(a!=null){
						if(allies.contains(a.user)){
							numReady++;
						}
					}
				}
				if(numReady == allies.size()){ 
					allReady = true;
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
				if(pauseTOQ == true){
					bm.render(g);
				}	
				break;
			case 3:
				
				break;
			}
		}
	}
	

	
	public void sort(ArrayList<Action> a){
		int j;
		boolean flag = true;
		Action temp;
		while (flag){
			flag=false;
			for(j=0; j<a.size()-1; j++){
				if(a.get(j) != null && a.get(j+1) != null){
					if(a.get(j).user.buffedStats[4] < a.get(j+1).user.buffedStats[4]){
						temp = a.get(j);
						a.set(j,a.get(j+1));
						a.set(j+1,temp);
						flag = true;
					}
				}
			}
		}
		
	}
	
	public Boolean fightlost(){
		Boolean teamdead=true;
		for(Schmuck s : allies){
			if(s.getCurrentHp()!=0){
				teamdead=false;
			}
		}
		return teamdead;
	}
	
	public Boolean enemyded(){
		Boolean theydead=true;
		for(Schmuck s : enemy){
			if(s.getCurrentHp()!=0){
				theydead=false;
			}
		}
		return theydead;
	}
}
