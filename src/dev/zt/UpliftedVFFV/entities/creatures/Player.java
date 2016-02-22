package dev.zt.UpliftedVFFV.entities.creatures;

import java.awt.Graphics;
import java.io.Serializable;
import java.util.Set;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.events.SpriteSorter;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.input.KeyManager;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.party.troops.Troop;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.states.GameState;
import dev.zt.UpliftedVFFV.states.StateManager;
import dev.zt.UpliftedVFFV.world.EventManager;

//player is the controlled character that walks around in the overworld. 
//ignore entities and creatures for now.
public class Player extends Creature implements Serializable{
	
	private static final long serialVersionUID = -5988574578443659173L;
	
	protected boolean runup,runleft,runright,rundown=false;
	public boolean wall;
	protected int rightleft;
	protected int step=0;
	public static int enemyCalc=0;
	public static int runlast=1;
	public static double enemyChance = 0.0;
	public static double bonusML;
	public static double combatFreq;
	public GameState gamestate;
	public float playerx, playery;
	
	public Player(Game game, float x, float y, GameState gs) {
		super(game, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT, Assets.Operator, 0);
		this.gamestate = gs;
		this.playerx = x;
		this.playery = y;
		wall = false;
	} 

	public void tick(GameState gs) {
				
		//First, checks whether the player is standing on an event
/*		Event e=Event.events[EventManager.events[(int)((playerx+16)/32)][(int)((playery+16)/32)]];
		if(e!=Event.event0 && e.runnable()){		//if the player is on top of a square containing an event, the event is run

			e.run();
			step=16;				//when an event is run, the player step count is reset so avoid getting stuck between squares
		}
		else */{
			
			//if the player isn't on top of an event, the player checks for input and runs move()
			getInput(gs);	
			int [] tent = {(int)((playerx+31/2+xMove/2+ 8*xMove)/32),(int)((playery+31/2+yMove/2 + 8*yMove)/32)};
			if(!gamestate.getWorld().getTile(tent[0],tent[1]).isSolid() && !gamestate.getEventmanager().getEvent(tent[0],tent[1]).isSolid(runlast)){
				this.move();
			}
			else{
				wall = true;
			}
		}
		

		game.getGameCamera().centerOnEntity(this);			//centers the gameCamera object so that the player is constantly in the center of the screen
	
	}
	
	public void move(){
		if(!wall){
			setPlayerX(getPlayerX() + xMove);
			setPlayerY(getPlayerY() + yMove);
		}			
	}
	
	private void encounter(){
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		int troop=0;
		Set<Integer> temp= gamestate.getWorld().getEnemies().keySet();
		Integer[] troops= temp.toArray(new Integer[gamestate.getWorld().enemynum]);	
		// Compute the total weight of all items together
		double totalWeight = 0.0d;
		for (int t : troops)
		{
			if(Troop.troops[t]!=null){
				totalWeight += gamestate.getWorld().getEnemies().get(t);
		    }
		}
		// Now choose a random item
		int randomIndex = -1;
		double random = Math.random() * totalWeight;
		for (int i = 0; i < troops.length; ++i)
		{
			random -= gamestate.getWorld().getEnemies().get(troops[i]);
		    if (random <= 0.0d)
		    {
		        randomIndex = i;
		        break;
		    }
		}
		if(randomIndex>=0){
			troop = troops[randomIndex];
			game.getAudiomanager().playSound("/Audio/Elevator Sound Effect.wav", false);
			bonusML = 0;
			for(Schmuck s : gamestate.partymanager.party){
				bonusML += s.getBonusML();
			}
			//Adding Mind Control Device Bonus.
			bonusML += gamestate.variablemanager.getVar(13);
			StateManager.states.push(new BattleState(game,game.getStatemanager(),gamestate.partymanager.party,troop,0,true, true,gamestate,(int)bonusML));
		}
	}
	
	//this is run every tick, provided the player is not running an event
	private void getInput(GameState gs){
		xMove = 0;			//xMove and yMove dictate how much the player should move. they should are set at 0 so that no movement occurs
		yMove = 0;			// with no input. This way, each input only registers a single movement
		
		//if step is 16, that means the player has successfully moved 32 pixels in whatever direction. The player stops moving and step is reset
		if(step==16){
			runup=false; runleft=false; runright=false; rundown=false;
			step=0;
			
			Event e=gamestate.getEvents()[EventManager.events[(int)((playerx+16)/32)][(int)((playery+16)/32)]];
			if(e!=Event.event0 && e.runnable()){		//if the player is on top of a square containing an event, the event is run
				e.run();
			}
			double temp = Math.random()*100;
			wall = false;
			
			combatFreq = 0;
			for(Schmuck s : gamestate.partymanager.party){
				combatFreq += s.getCombatFreq();
			}
			if(temp < enemyChance*(1+combatFreq)){			//enemy stuff				
				enemyChance = 0.0;
				encounter();
			}
			else{
				if(enemyChance < gamestate.getWorld().getEnemyrate()){
					enemyChance += 0.1;
				}
			}
		}
		
		//if the player is running in any direction, xMove and yMove are changed and the player begins moving, thus increasing step
		//consider adding a playlist of movements later to buffer player movement for smoother control
		else if(runup==true){
			yMove = -speed;
			step++;
		}
		else if(rundown==true){
			yMove = speed;
			step++;
		}
		else if(runleft==true){
			xMove = -speed;
			if(gamestate.getWorld().getTile((int)((playerx+31/2-17)/32),(int)((playery+31/2+17)/32)).isDiagMove() == 1){
				yMove = speed;
			}
			if(gamestate.getWorld().getTile((int)((playerx+31/2-17)/32),(int)((playery+31/2-17)/32)).isDiagMove() == -1){
				yMove = -speed;
			}
			step++;
		}
		else if(runright==true){
			xMove = speed;
			if(gamestate.getWorld().getTile((int)((playerx+31/2+17)/32),(int)((playery+31/2-17)/32)).isDiagMove() == 1){
				yMove = -speed;
			}
			if(gamestate.getWorld().getTile((int)((playerx+31/2+17)/32),(int)((playery+31/2+17)/32)).isDiagMove() == -1){
				yMove = speed;
			}
			step++;
		}
		
		//input is not accepted if the player is already walking in a direction
		//These check for directional input. if input is given, the player is set to walk in whatever direction
		//rightleft determines the walk cycle of the player. This cause the player sprite to alternate stepping with either foot
		//runlast determines the direction the player is facing. This is used to check for events as well as set npc directions
		else if(game.getKeyManager().up && KeyManager.isCutsceneMode() == false){
			runup = true;
			rightleft++;
			runlast=0;
			if(gamestate.getEvents()[EventManager.events[(int)((playerx+16)/32)][(int)((playery-16)/32)]].isDoor()){
				gamestate.getEvents()[EventManager.events[(int)((playerx+16)/32)][(int)((playery-16)/32)]].run();
				step = 16;
			}
		}
		
		//To each of these, add a check on the tile being walked into to have different stepping sounds for different tiles
		
		
		else if(game.getKeyManager().down && KeyManager.isCutsceneMode() == false){
			rundown = true;
			rightleft++;
			runlast=1;
			if(gamestate.getEvents()[EventManager.events[(int)((playerx+16)/32)][(int)((playery+48)/32)]].isDoor()){
				gamestate.getEvents()[EventManager.events[(int)((playerx+16)/32)][(int)((playery+48)/32)]].run();
				step = 16;
			}
		}
		else if(game.getKeyManager().left && KeyManager.isCutsceneMode() == false){
			runleft = true;
			rightleft++;
			runlast=2;
			if(gamestate.getEvents()[EventManager.events[(int)((playerx-16)/32)][(int)((playery+16)/32)]].isDoor()){
				gamestate.getEvents()[EventManager.events[(int)((playerx-16)/32)][(int)((playery+16)/32)]].run();
				step = 16;
			}
		}
		else if(game.getKeyManager().right && KeyManager.isCutsceneMode() == false){
			runright = true;
			rightleft++;
			runlast=3;
			if(gamestate.getEvents()[EventManager.events[(int)((playerx+48)/32)][(int)((playery+16)/32)]].isDoor()){
				gamestate.getEvents()[EventManager.events[(int)((playerx+48)/32)][(int)((playery+16)/32)]].run();
				step = 16;
			}
		}
		
		//space checks for events. depending on the orientation of the player, the event in an adjacent square is checked and ran.
		//also step is reset again
		else if(game.getKeyManager().space && KeyManager.isCutsceneMode() == false && game.getKeyManager().isActive()){
			Event e;
			switch(runlast){
			case 0: 
				e=gamestate.getEvents()[EventManager.events[(int)((playerx+16)/32)][(int)((playery-16)/32)]];
				if(e!=Event.event0){
					e.run();
					step=16;}
				break;
			case 1:
				e=gamestate.getEvents()[EventManager.events[(int)((playerx+16)/32)][(int)((playery+48)/32)]];
				if(e!=Event.event0){
					e.run();
					step=16;}
				break;
			case 2:
				e=gamestate.getEvents()[EventManager.events[(int)((playerx-16)/32)][(int)((playery+16)/32)]];
				if(e!=Event.event0){
					e.run();
					step=16;}
				break;
			case 3:
				e=gamestate.getEvents()[EventManager.events[(int)((playerx+48)/32)][(int)((playery+16)/32)]];
				if(e!=Event.event0){
					e.run();
					step=16;}
				break;
				
			}
			
			
			}

	}

	//renders the player sprite
	//if the player is not currently walking, a sprite is chosen based on the which direction the player is facing
	public void render(Graphics g) {
//		super.render(g);
				if(runup==false && rundown==false && runleft==false && runright==false){
			if(runlast==0){
				g.drawImage(SpriteSorter.SpriteSort(10,img), (int) (playerx- game.getGameCamera().getxOffset()),(int)(playery- game.getGameCamera().getyOffset()-32), width, height, null);
			}
			if(runlast==1){
				g.drawImage(SpriteSorter.SpriteSort(1,img), (int) (playerx- game.getGameCamera().getxOffset()),(int)(playery- game.getGameCamera().getyOffset()-32), width, height, null);
			}
			if(runlast==2){
				g.drawImage(SpriteSorter.SpriteSort(4,img), (int) (playerx- game.getGameCamera().getxOffset()),(int)(playery- game.getGameCamera().getyOffset()-32), width, height, null);
			}
			if(runlast==3){
				g.drawImage(SpriteSorter.SpriteSort(7,img), (int) (playerx- game.getGameCamera().getxOffset()),(int)(playery- game.getGameCamera().getyOffset()-32), width, height, null);
			}
		}
		
		//if the player is currently in the process of walking, its sprite cycles through the frames of its walk animation
		//consider adding a separate animationmanager later for all animations
		if(runup==true){
			if(step==9||step==10||step==11||step==12||step==13||step==14||step==15||step==16){
				g.drawImage(SpriteSorter.SpriteSort(10,img), (int) (playerx- game.getGameCamera().getxOffset()),(int)(playery- game.getGameCamera().getyOffset()-32), width, height, null);
			}
			else if(rightleft%2==0){
				g.drawImage(SpriteSorter.SpriteSort(9,img), (int) (playerx- game.getGameCamera().getxOffset()),(int)(playery- game.getGameCamera().getyOffset()-32), width, height, null);
			}
			
			else if(rightleft%2==1){
				g.drawImage(SpriteSorter.SpriteSort(11,img), (int) (playerx- game.getGameCamera().getxOffset()),(int)(playery- game.getGameCamera().getyOffset()-32), width, height, null);
			}				
		}
		if(rundown==true){
			if(step==9||step==10||step==11||step==12||step==13||step==14||step==15||step==16){
				g.drawImage(SpriteSorter.SpriteSort(1,img), (int) (playerx- game.getGameCamera().getxOffset()),(int)(playery- game.getGameCamera().getyOffset()-32), width, height, null);
			}
			else if(rightleft%2==0){
				g.drawImage(SpriteSorter.SpriteSort(0,img), (int) (playerx- game.getGameCamera().getxOffset()),(int)(playery- game.getGameCamera().getyOffset()-32), width, height, null);
			}
			
			else if(rightleft%2==1){
				g.drawImage(SpriteSorter.SpriteSort(2,img), (int) (playerx- game.getGameCamera().getxOffset()),(int)(playery- game.getGameCamera().getyOffset()-32), width, height, null);
			}	
				
		}
		if(runleft==true){
			if(step==9||step==10||step==11||step==12||step==13||step==14||step==15||step==16){
				g.drawImage(SpriteSorter.SpriteSort(4,img), (int) (playerx- game.getGameCamera().getxOffset()),(int)(playery- game.getGameCamera().getyOffset()-32), width, height, null);
			}
			else if(rightleft%2==0){
				g.drawImage(SpriteSorter.SpriteSort(3,img), (int) (playerx- game.getGameCamera().getxOffset()),(int)(playery- game.getGameCamera().getyOffset()-32), width, height, null);
			}
			
			else if(rightleft%2==1){
				g.drawImage(SpriteSorter.SpriteSort(5,img), (int) (playerx- game.getGameCamera().getxOffset()),(int)(playery- game.getGameCamera().getyOffset()-32), width, height, null);
			}	
		}
		if(runright==true){
			if(step==9||step==10||step==11||step==12||step==13||step==14||step==15||step==16){
				g.drawImage(SpriteSorter.SpriteSort(7,img), (int) (playerx- game.getGameCamera().getxOffset()),(int)(playery- game.getGameCamera().getyOffset()-32), width, height, null);
			}
			else if(rightleft%2==0){
				g.drawImage(SpriteSorter.SpriteSort(6,img), (int) (playerx- game.getGameCamera().getxOffset()),(int)(playery- game.getGameCamera().getyOffset()-32), width, height, null);
			}
			
			else if(rightleft%2==1){
				g.drawImage(SpriteSorter.SpriteSort(8,img), (int) (playerx- game.getGameCamera().getxOffset()),(int)(playery- game.getGameCamera().getyOffset()-32), width, height, null);
			}	
		}
					
		
		
	}
	
	public float getPlayerX() {
		return playerx;
	}

	public void setPlayerX(float newx) {
		playerx = newx;
	}

	public float getPlayerY() {
		return playery;
	}

	public void setPlayerY(float newy) {
		playery = newy;
	}
	
	public String toString(){
		return "player";
	}
	

	
}
