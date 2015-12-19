package dev.zt.UpliftedVFFV.Battle;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;
import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.ablities.ActuallyNothing;
import dev.zt.UpliftedVFFV.ablities.Skills;
import dev.zt.UpliftedVFFV.gfx.ImageLoader;
import dev.zt.UpliftedVFFV.ablities.DillyDally;
import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.party.troops.Troop;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.states.GameState;
import dev.zt.UpliftedVFFV.states.StateManager;
import dev.zt.UpliftedVFFV.statusEffects.Misaligned;
import dev.zt.UpliftedVFFV.statusEffects.StatusManager;
import dev.zt.UpliftedVFFV.statusEffects.TrueSight;
import dev.zt.UpliftedVFFV.statusEffects.incapacitate;
import dev.zt.UpliftedVFFV.utils.Utils;

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
	private BufferedImage window;
	
	//KeyListener delay variables.
	private int delaySelection = 200;
	private int delayCursor = 100;
	
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
		
		//Initialize Fight
		bt = new BattleText(game,sm,allies,enemy, bs);
		em = new EffectManager(game,bs,gs);
		stm = new StatusManager(game,bs,gs, this);
		TurnOrderQueue = new ArrayList<Action>();
		window = ImageLoader.loadImage("/ui/Window/WindowBlack.png");

		bt.textList.add(t.encounterText());
		for(Schmuck s : allies){
			battlers.add(s);
		}
		for(Schmuck s : enemy){
			battlers.add(s);
		}
		for(Schmuck s: battlers){
			s.calcBuffs(bs);
		}
						
	}
	
	public void tick() {
		
		//Display text if any is queued up
		if(!bt.textList.isEmpty()){
			bt.tick();
		}
		
		//Otherwise, proceed with battle processing
		else{
			switch(phase){
			
			//Phase 0: Pre-Selection Processing
			case 0:
				
				//On the first round of battle, run all start-of-fight effects
				if(roundNum == 1){
					for(Schmuck s : battlers){
						s.startofFightEffects(bs);
					}
				}
				
				currentlySelected=0;		//Index of ally selected to make an action. Starts at 0.
				//Starts out with menu selected for selected ally if there are still enemies left.
				bm = new BattleMenu(game,sm,allies,enemy,bs,allies.get(currentlySelected),gs);
				if(!enemyded()){					
					selected=true;					
				}
				
				phase++;
			
			//Phase 1: Ally selection.	
			case 1:
				
				//If a character is selected, a menu for their options pops up.
				if(selected==true){
					bm.tick();
				}
				
				//Otherwise, use left/right to select a character out of all allies.
				else{					
					if(game.getKeyManager().right && game.getKeyManager().isActive()){
						if(currentlySelected<allies.size()-1){
							currentlySelected++;
							game.getKeyManager().disable(delayCursor);
						}
					}
					if(game.getKeyManager().left && game.getKeyManager().isActive()){
						if(currentlySelected>0){
							currentlySelected--;
							game.getKeyManager().disable(delayCursor);
						}
					}
					
					//Space either exits fight if one team is all incapacitated or pulls up a menu for selected ally otherwise
					if(game.getKeyManager().space && game.getKeyManager().isActive()){
						if(fightlost() || enemyded()){
							bs.end(!fightlost());
						}
						
						//Pulls up battle menu for selectable ally, displays message if they are not selectable.
						if(bs.bs.alliesSelectable.contains(allies.get(currentlySelected))){	
							selected=true;
							bm = new BattleMenu(game,sm,allies,enemy,bs,allies.get(currentlySelected),gs);
						}
						else{
							bt.textList.add(allies.get(currentlySelected).getName()+" is Incapacitated!");
						}
						game.getKeyManager().disable(delaySelection);
					}
					
					//Enter will either end battle if one team is defeated of begin the round if all allies have planned actions.
					if(game.getKeyManager().enter && game.getKeyManager().isActive()){
						if(allReady){
							if(fightlost() || enemyded()){
								bs.end(!fightlost());
							}
							
							//Enemy actions are decided. All selectable (not incapacitated) enemies mae actions
							for(int i=0 ; i<bs.bs.enemySelectable.size();i++){
								
								//Enemy actions found using getAction function under Schmuck if enemy is not incapacitated and player team is not empty.
								if(!stm.checkStatus(bs.bs.enemySelectable.get(i), new incapacitate(bs.bs.enemySelectable.get(i))) && !bs.bs.alliesSelectable.isEmpty()){
									TurnOrderQueue.add(bs.bs.enemySelectable.get(i).getAction(bs));
								}
								else{
									TurnOrderQueue.add(new Action(bs.bs.enemySelectable.get(i),bs.bs.alliesSelectable.get((int)(Math.random()*bs.bs.alliesSelectable.size())),new ActuallyNothing(0),bs));
								}
							}
							
							//After decisions are made, pre-battle statuses activate.
							for(Schmuck s : battlers){
								s.preBattlePhaseEffects(bs);
							}
							
							//TOQ sorted
							sort(TurnOrderQueue);
								
							//For TOQ modifying abilities. tempTOQ
							ArrayList<Action> TempTurnOrderQueue = new ArrayList<Action>();
							for(Action a : TurnOrderQueue){
								TempTurnOrderQueue.add(a);
							}
							
							//TempTOQ is in reverse order so slower TOQ-modifiers activate first.
							for(int i = TempTurnOrderQueue.size()-1; i>=0; i--){ 
								if(TempTurnOrderQueue.get(i) != null){									
									TempTurnOrderQueue.get(i).skill.TOQChange(TempTurnOrderQueue.get(i), bs);
								}				
							}
							
							//The first character in the sorted TOQ may get an extra turn if they are fast enough.
							if(TurnOrderQueue.size() >= 2 && TurnOrderQueue.get(0).user != null && TurnOrderQueue.get(1).user != null){
								if(TurnOrderQueue.get(0).user.getBuffedSpd() >= (1.5)*(TurnOrderQueue.get(1).user.getBuffedSpd())){	//null pointer here sometimes
									bt.textList.add(TurnOrderQueue.get(0).user.getName()+"'s speed grants an extra turn!");
									TurnOrderQueue.add(new Action(TurnOrderQueue.get(0).user,TurnOrderQueue.get(0).user,new DillyDally(0),bs));
								}
							}
							
							//Next phase begins. Variables reset.
							phase++;
							allReady = false;
							game.getKeyManager().disable(delaySelection);
						}
					}
				}
				break;
			
			//Phase 2: TOQ actions occur.
			case 2:
				
				//If an allied character chose to wait, the battle menu appears.
				if(pauseTOQ == true){ 				
					bm.tick();
				}				
				if(game.getKeyManager().space && game.getKeyManager().isActive()){
					game.getKeyManager().disable(delaySelection);
				}
				
				//If either team is defeated, proceed to Phase 3.
				if(fightlost() || enemyded()){
					phase++;
				}
				
				//Otherwise, perform the next action on the TOQ. (if it exists)
				else if(!TurnOrderQueue.isEmpty()){
					if(TurnOrderQueue.get(0) != null && pauseTOQ == false){
						Action tempAction = TurnOrderQueue.get(0);			//Current Action being processed.
						Skills tempSkill = TurnOrderQueue.get(0).skill;		//Skill being performed
						Schmuck tempPerp = TurnOrderQueue.get(0).user;		//Schmuck that performs the above action
						Schmuck tempVic = TurnOrderQueue.get(0).target;		//Schmuck being targeted
						
						//Before action happens, tempPerp's status restrictions activate.
						tempPerp.restrictEffects(tempAction, bs);
						
						//If action is neither "Wait" nor null, run action
						if(!tempAction.skill.getName().equals("Dilly Dally") && tempAction != null){
							
							//Check if schmuck has adequate Mp to use ability. If so, deduct Mp and perform action.
							if((int)(tempSkill.getCost()*(1-tempPerp.getMpCost())) <= tempPerp.getCurrentBp()){
								em.bpChange((int)(-tempSkill.getCost()*(1-tempPerp.getMpCost())), tempPerp);
								
								//Check if the action was a Critical Hit
								if(calcCrit(tempAction)){
									tempSkill.runCrit(tempPerp,tempVic,bs);
									
									//If a critical hit occurred, run the perp's on-crit status effects.
									tempPerp.onCritEffects(tempVic, bs);
								}
								
								//Otherwise, check if the action missed or not.
								else{
									if(!calcHit(tempAction)){
										bt.textList.add(tempPerp.getName() + " tried to use " + tempSkill.getName() + " but missed!");
										
										//If the ability missed, activate perp's on-miss effects
										tempPerp.onMissEffects(tempAction, bs);
									}
									//Otherwise, run the action normally.
									else{
										tempSkill.run(tempPerp,tempVic,bs);
									}
								}
								
								//Extra check of TOQ emptiness in case it becomes empty as a result of skill being run.
								if(!TurnOrderQueue.isEmpty()){		
									if(tempAction != null){
										
										//After action, run all of the perp's on-action effects.
										tempPerp.onActionEffects(tempAction, bs);
										
										//Also, run everyone's on-any-action effects
										for(Schmuck s : battlers){
											s.afterEveryActionEffects(s, tempAction, bs); 
										}
									}
								}
								
								//Update targets for good measure.
								bs.bs.targetUpdate();

							}
							
							//No Mp gives this message.
							else{
								bt.textList.add(tempPerp.getName()+" didn't have the Motivation to use "+tempSkill.getName()+"!");
							}
						}
						
						//Else, the action being processed is a dilly-dally used by an ally, pull up the battle menu.
						else{
							if(allies.contains(tempPerp)){
								pauseTOQ = true;				//Indicates that an wait was selected.
								currentlySelected = bs.bs.alliesSelectable.indexOf(tempPerp);
								bm = new BattleMenu(game,sm,allies,enemy,bs,tempPerp,gs);
							}
							
							//if enemies dilly dally, they just re-get a move the same way but with updated info
							//Because actions are processed instantly, do the crit/miss calculations here.
							else{
								tempAction = tempPerp.getAction(bs);
								tempSkill = tempAction.skill;		
								tempPerp = tempAction.user;		
								tempVic = tempAction.target;		
								if(calcCrit(tempAction)){
									tempSkill.runCrit(tempPerp,tempVic,bs);
									
									//If a critical hit occurred, run the perp's on-crit status effects.
									tempPerp.onCritEffects(tempVic, bs);
								}
								else {
									if(!calcHit(tempAction)){
										bt.textList.add(tempPerp.getName() + " tried to use " + tempSkill.getName() + " but missed!");
										
										//If the ability missed, activate perp's on-miss effects
										tempPerp.onMissEffects(tempAction, bs);
										
									}
									else{
										tempSkill.run(tempPerp,tempVic,bs);
									}
								}
								
							}
						}
					}
					
					//After the action is done processing, remove it, recalculate buffs
					if(pauseTOQ == false){
						if(!TurnOrderQueue.isEmpty()){
							TurnOrderQueue.remove(0);
							for(Schmuck s: battlers){
								s.calcBuffs(bs);
							}
						}					
					}				
				}
				
				//If the TOQ is empty at the start of Phase 2, run end-of-round calculations, regen Mp, and proceed to next stage.
				//Otherwise, Phase 2 will be run again as the processor is ticked.
				else{					
					stm.endofRound(bs);
					for(Schmuck s : battlers){
						s.bpChange(s.getBuffedInt()/5); //mp regen gain. Tweak numbers later
					}
					phase++;
				}
				break;
			
			//Phase 3: Post-round processing
			case 3:
				
				//If all allies are defeated, display losing text.
				if(fightlost()){
					bt.textList.add("The fight was lost.");
					bt.textList.add("Everything goes black.");
				}
				
				//If all enemies are defeated, get loot and stuff.
				else if(enemyded()){
					bt.textList.add("You won!");
					double exp = 0;
					double script = 0;
					double expMult = 0;
					double scriptMult = 0;
					double itemMult = 0;
					
					//Apply allied +Item, Script and Exp modifiers
					for(Schmuck s : allies){
						expMult += s.getBonusExp();
						scriptMult += s.getBonusScrip();
						itemMult += s.getBonusItem();
					}
					for(Schmuck s : enemy){
						exp += (s.getExpDrop()*(1+expMult));
						script += (s.getScrDrop()*(1+scriptMult));
					}
					
					//Gain Exp. Level up and gain new skills accordingly.
					for(Schmuck s : allies){
						bt.textList.add(s.getName()+" gains "+(int)(exp/allies.size())+" exp!");
						if(s.exp+(int)(exp/allies.size())>=Math.pow(s.Lvl,2)*10){
							bt.textList.add(s.getName()+" received a raise!");
							bt.textList.add(s.getName()+" is now level "+ (s.Lvl+1)+"!");
							if(s.getLevelSkills().containsKey(s.Lvl+1)){
								bt.textList.add(s.getName()+" learned "+ s.getLevelSkills().get(s.Lvl+1).getName()+"!");	
							}
						}
						s.expGain(s.getStartStats(),s.getStatGrowths(),(int)(exp/allies.size()));
						s.calcBuffs(bs);
					}
					
					//Gain Script
					bt.textList.add((int)script+" Company Script looted!");
					gs.scriptChange((int)script);
					
					
					//Gain items
					TreeMap<Item, Integer> drops = t.getDrops(itemMult);					
					Set<Item> temp = drops.keySet();
					Item[] itemDisplay = temp.toArray(new Item[999]);
					
					for(int i=0; i<drops.size();i++){		
						if(drops.get(itemDisplay[i]) == 1){		
							bt.textList.add("Looted a(n) "+itemDisplay[i].getName()+"!");
						}
						else{
							bt.textList.add("Looted "+drops.get(itemDisplay[i])+" "+itemDisplay[i].getName()+"(s)!");
						}				
						gs.inventorymanager.loot(itemDisplay[i], drops.get(itemDisplay[i]));
					}
					
					//Do endoffite processing
					stm.endofFite();
					
				}
				
				//If fight is not yet over, increase round number and go back to phase 0.
				roundNum++;
				phase=0;
				game.getKeyManager().disable(delaySelection);
			}
		}
	}

	//Render method. 
	public void render(Graphics g) {
		Utils.drawDialogueBox(g, window, "Round: " + roundNum, 16, Color.white, 0, 30, 75, 28, 16, true);
		if(!bt.textList.isEmpty()){
			bt.render(g);
		}
		else{
			switch(phase){
			case 0:
				
			case 1:
				
				//Check of all allies are ready.
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
					Utils.drawDialogueBox(g, window, "Ready (ENTER)", 18, Color.white, 0, 65, 120, 40, 16, true);
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
	
	//Returns true if an input action hits and false otherwise
	public Boolean calcHit(Action a){
		if(em.getAcc(a.user, a.target, a.skill.getBaseAcc()) || !a.skill.canMiss() || stm.checkStatus(a.user, new TrueSight(50))){
			return true;
		}
		else{
			return false;
		}
	}
	
	//Returns true if an input action crits and false otherwise
	public Boolean calcCrit(Action a){
		if(em.getCrit(a.user, a.target, a.skill) && a.skill.canCrit){
			return true;
		}
		else{
			return false;
		}
	}
	
	
	//getSelectableEmenies/Allies is used in untargetable AOE of buffs that target a user's allies or enemies.
	//Given an input Schmuck, they return an arraylist of that Schmuck's enemies or allies.
	//Unaligned status causes Schmucks to count as the opposite team.
	public ArrayList<Schmuck> getSelectableEnemies(Schmuck s){
		ArrayList<Schmuck> selectables = new ArrayList<Schmuck>();
		if(allies.contains(s)){
			for(Schmuck m : bs.bs.enemySelectable){
				if(!stm.checkStatus(m,new Misaligned(0, m, 50))){
					selectables.add(m);
				}
			}
			for(Schmuck m : bs.bs.alliesSelectable){
				if(stm.checkStatus(m,new Misaligned(0, m, 50))){
					selectables.add(m);
				}
			}
		}
		else{
			for(Schmuck m : bs.bs.enemySelectable){
				if(stm.checkStatus(m,new Misaligned(0, m, 50))){
					selectables.add(m);
				}
			}
			for(Schmuck m : bs.bs.alliesSelectable){
				if(!stm.checkStatus(m,new Misaligned(0, m, 50))){
					selectables.add(m);
				}
			}
		}
		return selectables;
	}
	
	public ArrayList<Schmuck> getSelectableAllies(Schmuck s){
		ArrayList<Schmuck> selectables = new ArrayList<Schmuck>();
		if(allies.contains(s)){
			for(Schmuck m : bs.bs.enemySelectable){
				if(stm.checkStatus(m,new Misaligned(0, m, 50))){
					selectables.add(m);
				}
			}
			for(Schmuck m : bs.bs.alliesSelectable){
				if(!stm.checkStatus(m,new Misaligned(0, m, 50))){
					selectables.add(m);
				}
			}
		}
		else{
			for(Schmuck m : bs.bs.enemySelectable){
				if(!stm.checkStatus(m,new Misaligned(0, m, 50))){
					selectables.add(m);
				}
			}
			for(Schmuck m : bs.bs.alliesSelectable){
				if(stm.checkStatus(m,new Misaligned(0, m, 50))){
					selectables.add(m);
				}
			}
		}
		return selectables;
	}
	
	//Sorts TOQ in order of speed with Combat Initiative Modifier.
	public void sort(ArrayList<Action> a){
		int j;
		boolean flag = true;
		Action temp;
		while (flag){
			flag=false;
			for(j=0; j<a.size()-1; j++){
				if(a.get(j) != null && a.get(j+1) != null){
					if(a.get(j).user.getBuffedSpd()*(1+a.get(j).user.getBonusInit()) < a.get(j+1).user.getBuffedSpd()*(1+a.get(j).user.getBonusInit())){
						temp = a.get(j);
						a.set(j,a.get(j+1));
						a.set(j+1,temp);
						flag = true;
					}
				}
			}
		}
		
	}
	
	//Returns true if all player-controlled Schmucks are incapacitated and false otherwise.
	public Boolean fightlost(){
		Boolean teamdead=true;
		for(Schmuck s : allies){
			if(s.getCurrentHp()!=0){
				teamdead=false;
			}
		}
		return teamdead;
	}
	
	//Returns true if all enemies are incapacitated.
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
