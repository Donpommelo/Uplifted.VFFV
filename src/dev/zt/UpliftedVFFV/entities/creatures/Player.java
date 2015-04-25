package dev.zt.UpliftedVFFV.entities.creatures;

import java.awt.Graphics;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.events.SpriteSorter;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.world.EventManager;
import dev.zt.UpliftedVFFV.world.WorldManager;


//player is the controlled character that walks around in the overworld. 
//ignore entities and creatures for now.
public class Player extends Creature{
	
	protected boolean runup,runleft,runright,rundown=false;
	protected int rightleft;
	protected int step=0;
	public static int runlast=1;

	public Player(Game game, float x, float y) {
		super(game, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
	} 

	public void tick() {
				
		//First, checks whether the player is standing on an event
		Event e=Event.events[EventManager.events[(int)((x+16)/32)][(int)((y+16)/32)]];
		if(e!=Event.event0){		//if the player is on top of a square containing an event, the event is run

			e.run();
			step=16;				//when an event is run, the player step count is reset so avoid getting stuck between squares
		}
		else {
			
			//if the player isn't on top of an event, the player checks for input and runs move()
			getInput();			
			if(!WorldManager.getWorld().getTile((int)((x+31/2+xMove/2+ 8*xMove)/32),(int)((y+31/2+yMove/2 + 8*yMove)/32)).isSolid()&&!EventManager.getEvent((int)((x+31/2+xMove/2+ 8*xMove)/32),(int)((y+31/2+yMove/2 + 8*yMove)/32)).isSolid()){
				move();			
			}
		}
		

		game.getGameCamera().centerOnEntity(this);			//centers the gameCamera object so that the player is constantly in the center of the screen
	
	}
	
	//this is run every tick, provided the player is not running an event
	private void getInput(){
	
		xMove = 0;			//xMove and yMove dictate how much the player should move. they should are set at 0 so that no movement occurs
		yMove = 0;			// with no input. This way, each input only registers a single movement
		
		//if step is 16, that means the player has successfully moved 32 pixels in whatever direction. The player stops moving and step is reset
		if(step==16){
			runup=false; runleft=false; runright=false; rundown=false;
			step=0;
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
			step++;
		}
		else if(runright==true){
			xMove = speed;
			step++;
		}
		
		//input is not accepted if the player is already walking in a direction
		//These check for directional input. if input is given, the player is set to walk in whatever direction
		//rightleft determines the walk cycle of the player. This cause the player sprite to alternate stepping with either foot
		//runlast determines the direction the player is facing. This is used to check for events as well as set npc directions
		else if(game.getKeyManager().up){
			runup = true;
			rightleft++;
			runlast=0;
		}
		else if(game.getKeyManager().down){
			rundown = true;
			rightleft++;
			runlast=1;
		}
		else if(game.getKeyManager().left){
			runleft = true;
			rightleft++;
			runlast=2;
		}
		else if(game.getKeyManager().right){
			runright = true;
			rightleft++;
			runlast=3;
		}
		
		//space checks for events. depending on the orientation of the player, the event in an adjacent square is checked and ran.
		//also step is reset again
		else if(game.getKeyManager().space){
			Event e;
			switch(runlast){
			case 0: 
				e=Event.events[EventManager.events[(int)((x+16)/32)][(int)((y-16)/32)]];
				if(e!=Event.event0){
					e.run();
					step=16;}
				break;
			case 1:
				e=Event.events[EventManager.events[(int)((x+16)/32)][(int)((y+48)/32)]];
				if(e!=Event.event0){
					e.run();
					step=16;}
				break;
			case 2:
				e=Event.events[EventManager.events[(int)((x-16)/32)][(int)((y+16)/32)]];
				if(e!=Event.event0){
					e.run();
					step=16;}
				break;
			case 3:
				e=Event.events[EventManager.events[(int)((x+48)/32)][(int)((y+16)/32)]];
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
		if(runup==false && rundown==false && runleft==false && runright==false){
			if(runlast==0){
				g.drawImage(SpriteSorter.SpriteSort(10,Assets.Operator), (int) (x- game.getGameCamera().getxOffset()),(int)(y- game.getGameCamera().getyOffset()), width, height, null);
			}
			if(runlast==1){
				g.drawImage(SpriteSorter.SpriteSort(1,Assets.Operator), (int) (x- game.getGameCamera().getxOffset()),(int)(y- game.getGameCamera().getyOffset()), width, height, null);
			}
			if(runlast==2){
				g.drawImage(SpriteSorter.SpriteSort(4,Assets.Operator), (int) (x- game.getGameCamera().getxOffset()),(int)(y- game.getGameCamera().getyOffset()), width, height, null);
			}
			if(runlast==3){
				g.drawImage(SpriteSorter.SpriteSort(7,Assets.Operator), (int) (x- game.getGameCamera().getxOffset()),(int)(y- game.getGameCamera().getyOffset()), width, height, null);
			}
		}
		
		//if the player is currently in the process of walking, its sprite cycles through the frames of its walk animation
		//consider adding a separate animationmanager later for all animations
		if(runup==true){
			if(step==9||step==10||step==11||step==12||step==13||step==14||step==15||step==16){
				g.drawImage(SpriteSorter.SpriteSort(10,Assets.Operator), (int) (x- game.getGameCamera().getxOffset()),(int)(y- game.getGameCamera().getyOffset()), width, height, null);
			}
			else if(rightleft%2==0){
				g.drawImage(SpriteSorter.SpriteSort(9,Assets.Operator), (int) (x- game.getGameCamera().getxOffset()),(int)(y- game.getGameCamera().getyOffset()), width, height, null);
			}
			
			else if(rightleft%2==1){
				g.drawImage(SpriteSorter.SpriteSort(11,Assets.Operator), (int) (x- game.getGameCamera().getxOffset()),(int)(y- game.getGameCamera().getyOffset()), width, height, null);
			}				
		}
		if(rundown==true){
			if(step==9||step==10||step==11||step==12||step==13||step==14||step==15||step==16){
				g.drawImage(SpriteSorter.SpriteSort(1,Assets.Operator), (int) (x- game.getGameCamera().getxOffset()),(int)(y- game.getGameCamera().getyOffset()), width, height, null);
			}
			else if(rightleft%2==0){
				g.drawImage(SpriteSorter.SpriteSort(0,Assets.Operator), (int) (x- game.getGameCamera().getxOffset()),(int)(y- game.getGameCamera().getyOffset()), width, height, null);
			}
			
			else if(rightleft%2==1){
				g.drawImage(SpriteSorter.SpriteSort(2,Assets.Operator), (int) (x- game.getGameCamera().getxOffset()),(int)(y- game.getGameCamera().getyOffset()), width, height, null);
			}	
				
		}
		if(runleft==true){
			if(step==9||step==10||step==11||step==12||step==13||step==14||step==15||step==16){
				g.drawImage(SpriteSorter.SpriteSort(4,Assets.Operator), (int) (x- game.getGameCamera().getxOffset()),(int)(y- game.getGameCamera().getyOffset()), width, height, null);
			}
			else if(rightleft%2==0){
				g.drawImage(SpriteSorter.SpriteSort(3,Assets.Operator), (int) (x- game.getGameCamera().getxOffset()),(int)(y- game.getGameCamera().getyOffset()), width, height, null);
			}
			
			else if(rightleft%2==1){
				g.drawImage(SpriteSorter.SpriteSort(5,Assets.Operator), (int) (x- game.getGameCamera().getxOffset()),(int)(y- game.getGameCamera().getyOffset()), width, height, null);
			}	
		}
		if(runright==true){
			if(step==9||step==10||step==11||step==12||step==13||step==14||step==15||step==16){
				g.drawImage(SpriteSorter.SpriteSort(7,Assets.Operator), (int) (x- game.getGameCamera().getxOffset()),(int)(y- game.getGameCamera().getyOffset()), width, height, null);
			}
			else if(rightleft%2==0){
				g.drawImage(SpriteSorter.SpriteSort(6,Assets.Operator), (int) (x- game.getGameCamera().getxOffset()),(int)(y- game.getGameCamera().getyOffset()), width, height, null);
			}
			
			else if(rightleft%2==1){
				g.drawImage(SpriteSorter.SpriteSort(8,Assets.Operator), (int) (x- game.getGameCamera().getxOffset()),(int)(y- game.getGameCamera().getyOffset()), width, height, null);
			}	
		}
					
		
		
	}
	
}
