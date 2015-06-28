package dev.zt.UpliftedVFFV.Battle;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Set;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.ablities.ActuallyNothing;
import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.party.Troop;
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
	public Troop t;
	public int troop;
	public int phase;
	public int currentlySelected;
	public int roundNum;
	public boolean selected = true;
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
	
	public BattleProcessor(Game game,StateManager sm,ArrayList<Schmuck> party,ArrayList<Schmuck> enemy, Troop t,GameState gs,BattleState bs){
		this.game=game;
		this.sm=sm;
		this.bs=bs;
		this.gs=gs;
		this.allies = party;
		this.enemy = enemy;
		this.t = t;
		phase=0;
		currentlySelected=0;
		roundNum = 1;
		
		bt = new BattleText(game,sm,allies,enemy, bs);
		em = new EffectManager(game,bs,gs);
		stm = new StatusManager(game,bs,gs, this);
//		bm = new BattleMenu(game,sm,allies,enemy,bs,allies.get(0),gs);
		TurnOrderQueue = new ArrayList<Action>();

		for(int i=0 ; i<this.enemy.size()+this.allies.size();i++){
//			TurnOrderQueue.add(null);
		}
		bt.textList.add(t.encounterText());
		for(Schmuck s : allies){
			battlers.add(s);
			for(int i=0; i<s.statuses.size(); i++){
				if(s.statuses.get(i)!=null){
					s.statuses.get(i).startoffightEffect(s,bs);
				}
			}
		}
		for(Schmuck s : enemy){
			battlers.add(s);
			for(int i=0; i<s.statuses.size(); i++){
				if(s.statuses.get(i)!=null){
					s.statuses.get(i).startoffightEffect(s,bs);
				}
			}
		}
		for(Schmuck s: battlers){
			s.calcBuffs();
		}
		
		
				
	}
	
	public void tick() {
		
		if(!bt.textList.isEmpty()){
			bt.tick();
		}
		else{
			switch(phase){
			case 0:
				currentlySelected=0;
				bm = new BattleMenu(game,sm,allies,enemy,bs,bs.bs.alliesTargets.get(currentlySelected),gs);
				if(!enemyded()){					
					selected=true;					
				}
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
						if(currentlySelected<bs.bs.alliesTargets.size()-1){
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
						if(!stm.checkStatus(bs.bs.alliesTargets.get(currentlySelected), new incapacitate(bs.bs.alliesTargets.get(currentlySelected)))){	
							selected=true;
							bm = new BattleMenu(game,sm,allies,enemy,bs,bs.bs.alliesTargets.get(currentlySelected),gs);
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
								if(!stm.checkStatus(enemy.get(i), new incapacitate(enemy.get(i))) && !bs.bs.alliesTargets.isEmpty()){
									TurnOrderQueue.set(allies.size()+i,enemy.get(i).getAction(bs));
								}
								else{
									
									TurnOrderQueue.set(allies.size()+i,new Action(enemy.get(i),allies.get((int)(Math.random()*allies.size())),new ActuallyNothing(0),bs));
								}
							}
							sort(TurnOrderQueue);
							
							//For TOQ modifying abilities. tempTOQ
							ArrayList<Action> TempTurnOrderQueue = new ArrayList<Action>();
							for(Action a : TurnOrderQueue){
								TempTurnOrderQueue.add(a);
							}
							for(int i = TempTurnOrderQueue.size()-1; i>=0; i--){ //reverse order so faster schmucks get last say in TOQ
								if(TempTurnOrderQueue.get(i) != null){									
									TempTurnOrderQueue.get(i).skill.TOQChange(TempTurnOrderQueue.get(i), bs);
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
						for(int i=0; i<TurnOrderQueue.get(0).user.statuses.size(); i++){
							if(TurnOrderQueue.get(0).user.statuses.get(i)!=null){
								TurnOrderQueue.get(0).user.statuses.get(i).restrict(TurnOrderQueue.get(0).user,TurnOrderQueue.get(0),bs);
							}
						}
						if(!TurnOrderQueue.get(0).skill.useText(TurnOrderQueue.get(0).user,TurnOrderQueue.get(0).target).equals("DillyDally") && TurnOrderQueue.get(0) != null){
							if(TurnOrderQueue.get(0).skill.getCost()<=TurnOrderQueue.get(0).user.getCurrentBp()){								
								em.bpChange(-TurnOrderQueue.get(0).skill.getCost(), TurnOrderQueue.get(0).user);
								TurnOrderQueue.get(0).skill.run(TurnOrderQueue.get(0).user,TurnOrderQueue.get(0).target,bs);
								if(TurnOrderQueue.get(0) != null){
									for(int i=0; i<TurnOrderQueue.get(0).user.statuses.size(); i++){
										if(TurnOrderQueue.get(0).user.statuses.get(i)!=null){
											TurnOrderQueue.get(0).user.statuses.get(i).onAction(bs,TurnOrderQueue.get(0));
										}
									}
								}
							}
							else{
								bt.textList.add(TurnOrderQueue.get(0).user.getName()+" didn't have the Motivation to use "+TurnOrderQueue.get(0).skill.getName());
							}
//							bs.bs.targetUpdate();
						}
						else{
							if(allies.contains(TurnOrderQueue.get(0).user)){
								pauseTOQ = true;
								currentlySelected=allies.indexOf(TurnOrderQueue.get(0).user);
								bm = new BattleMenu(game,sm,allies,enemy,bs,TurnOrderQueue.get(0).user,gs);
							}
							//if enemies dilly dally, they just re-get a move the same way but with updated info
							else{
								TurnOrderQueue.set(0,TurnOrderQueue.get(0).user.getAction(bs));
							}

						}
					}
					if(pauseTOQ == false){
						if(!TurnOrderQueue.isEmpty()){
							TurnOrderQueue.remove(0);
							for(Schmuck s: battlers){
								s.calcBuffs();
							}
						}					
					}				
				}
				else{					
					stm.endofRound(bs);
					for(Schmuck s : battlers){
						s.bpChange(s.getBuffedInt()/5); //mp regen gain. Tweak numbers later
					}
					phase++;
				}
				break;
				
			case 3:
				if(fightlost()){
					bt.textList.add("The fight was lost.");
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
					Set<Item> temp = t.getDrops().keySet();
					Item[] itemDisplay = temp.toArray(new Item[999]);
					for(int i=0; i<t.getDrops().size();i++){		
						if(t.getDrops().get(itemDisplay[i]) == 1){
							bt.textList.add("Looted a(n) "+itemDisplay[i].getName()+"!");
						}
						else{
							bt.textList.add("Looted "+t.getDrops().get(itemDisplay[i])+" "+itemDisplay[i].getName()+"(s)!");
						}				
						gs.inventorymanager.loot(itemDisplay[i], t.getDrops().get(itemDisplay[i]));
					}
					stm.endofFite();
					
				}
				roundNum++;
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
		g.setColor(new Color(102, 178,255));
		g.fillRect(0, 25,80,40);
		g.setFont(new Font("Chewy", Font.PLAIN, 18));
		g.setColor(new Color(0, 0,0));
		g.drawString("Round: "+roundNum,0,50);
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
				for(Schmuck s :allies){
					if(stm.checkStatus(s,new incapacitate(s))){
						numReady++;
					}
				}
				if(numReady == allies.size()){ 
					allReady = true;
					g.setColor(new Color(102, 178,255));
					g.fillRect(0, 65,120,40);
					g.setFont(new Font("Chewy", Font.PLAIN, 18));
					g.setColor(new Color(0, 0,0));
					g.drawString("Ready (Enter)",0,90);
				}
				if(selected==true){
					if(bm != null){
						bm.render(g);
					}					
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
	
	public ArrayList<Schmuck> getEnemyTargets(Schmuck s){
		if(allies.contains(s)){
			return bs.bs.enemyTargets;
		}
		else{
			return bs.bs.alliesTargets;
		}
	}
	
	public ArrayList<Schmuck> getAlliedTargets(Schmuck s){
		if(allies.contains(s)){
			return bs.bs.alliesTargets;
		}
		else{
			return bs.bs.enemyTargets;
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
