package dev.zt.UpliftedVFFV.entities.creatures;

import java.awt.Graphics;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.events.SpriteSorter;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.world.EventManager;
import dev.zt.UpliftedVFFV.world.WorldManager;

public class Player extends Creature{
	
	protected boolean runup,runleft,runright,rundown=false;
	protected int rightleft;
	protected int step=0;
	public static int runlast=1;

	public Player(Game game, float x, float y) {
		super(game, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
	} 

	public void tick() {
				
		
		Event e=Event.events[EventManager.events[(int)((x+16)/32)][(int)((y+16)/32)]];
		if(e!=Event.event0){

			e.run();
			step=16;
		}
		else {
			
			getInput();
			if(!WorldManager.getWorld().getTile((int)((x+31/2+xMove/2+ 8*xMove)/32),(int)((y+31/2+yMove/2 + 8*yMove)/32)).isSolid()&&!EventManager.getEvent((int)((x+31/2+xMove/2+ 8*xMove)/32),(int)((y+31/2+yMove/2 + 8*yMove)/32)).isSolid()){
				move();			
			}
		}
		

		game.getGameCamera().centerOnEntity(this);
	
	}
	
	private void getInput(){
	
		xMove = 0;
		yMove = 0;
		if(step==16){
			runup=false; runleft=false; runright=false; rundown=false;
			step=0;
		}
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
