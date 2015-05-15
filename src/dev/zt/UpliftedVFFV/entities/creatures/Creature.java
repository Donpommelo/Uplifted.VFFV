package dev.zt.UpliftedVFFV.entities.creatures;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.entities.Entity;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.events.SpriteSorter;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.world.EventManager;
import dev.zt.UpliftedVFFV.world.WorldManager;


public class Creature extends Entity {
	
	public static final float DEFAULT_SPEED = 2.0f;
	public static final int DEFAULT_CREATURE_WIDTH = 32;
	public static final int DEFAULT_CREATURE_HEIGHT = 32;
	public BufferedImage img;
	public BufferedImage imgShown;
	protected boolean runup,runleft,runright,rundown=false;
	protected float speed;
	protected float xMove, yMove;
	protected int rightleft;
	protected int step=0;
	public static int runlast=1;
	public Game game;
	
	
	public Creature(Game game, float x, float y, int width, int height, BufferedImage img) {
		super(game, x, y, width, height);
		speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
		this.img=img;
		this.imgShown = SpriteSorter.SpriteSort(10,img);
		this.game = game;
//		System.out.print(this+" "+x+" "+y+"  ");
//		System.out.print(this+" "+this.getX()+" "+this.getY());
	}
	
	public void move(){
//		if(!WorldManager.getWorld().getTile((int)((x+31/2+xMove/2+ 8*xMove)/32),(int)((y+31/2+yMove/2 + 8*yMove)/32)).isSolid()&&!EventManager.getEvent((int)((x+31/2+xMove/2+ 8*xMove)/32),(int)((y+31/2+yMove/2 + 8*yMove)/32)).isSolid()){
			setX(getX() + xMove/32);
			setY(getY() + yMove/32);
//		}

	}
	
	public void tick() {
//		System.out.print(this+" "+this.getX()+" "+this.getY());
		this.getInput();			
//		if(!WorldManager.getWorld().getTile((int)((x+31/2+xMove/2+ 8*xMove)/32),(int)((y+31/2+yMove/2 + 8*yMove)/32)).isSolid()&&!EventManager.getEvent((int)((x+31/2+xMove/2+ 8*xMove)/32),(int)((y+31/2+yMove/2 + 8*yMove)/32)).isSolid()){
			this.move();			
//		}
	}
	
	private void getInput(){
		this.xMove = 0;			//xMove and yMove dictate how much the player should move. they should are set at 0 so that no movement occurs
		this.yMove = 0;			// with no input. This way, each input only registers a single movement
		
		//if step is 16, that means the player has successfully moved 32 pixels in whatever direction. The player stops moving and step is reset
		if(step==16){
			this.runup=false; this.runleft=false; this.runright=false; this.rundown=false;
			this.step=0;
//			System.out.print(this.x+" "+this.y);
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
	}
	
	public void getMove(int dir){
		switch(dir){
		case 0:
			this.runup = true;
			this.rightleft++;
			this.runlast=0;
			break;
		case 1:
			rundown = true;
			rightleft++;
			runlast=1;
			break;
		case 2:
			runleft = true;
			rightleft++;
			runlast=2;
			break;
		case 3:
			runright = true;
			rightleft++;
			runlast=3;
			break;
		}
	}


	public void render(Graphics g) {
		if(runup==false && rundown==false && runleft==false && runright==false){
			if(runlast==0){
				imgShown = SpriteSorter.SpriteSort(10,img);
//				g.drawImage(SpriteSorter.SpriteSort(10,img), (int) (x- game.getGameCamera().getxOffset()),(int)(y- game.getGameCamera().getyOffset()), width, height, null);
			}
			if(runlast==1){
				imgShown = SpriteSorter.SpriteSort(1,img);
//				g.drawImage(SpriteSorter.SpriteSort(1,img), (int) (x- game.getGameCamera().getxOffset()),(int)(y- game.getGameCamera().getyOffset()), width, height, null);
			}
			if(runlast==2){
				imgShown = SpriteSorter.SpriteSort(4,img);
//				g.drawImage(SpriteSorter.SpriteSort(4,img), (int) (x- game.getGameCamera().getxOffset()),(int)(y- game.getGameCamera().getyOffset()), width, height, null);
			}
			if(runlast==3){
				imgShown = SpriteSorter.SpriteSort(7,img);
//				g.drawImage(SpriteSorter.SpriteSort(7,img), (int) (x- game.getGameCamera().getxOffset()),(int)(y- game.getGameCamera().getyOffset()), width, height, null);
			}
		}
		
		//if the player is currently in the process of walking, its sprite cycles through the frames of its walk animation
		//consider adding a separate animationmanager later for all animations
		if(runup==true){
			if(step==9||step==10||step==11||step==12||step==13||step==14||step==15||step==16){
				imgShown = SpriteSorter.SpriteSort(7,img);
//				g.drawImage(SpriteSorter.SpriteSort(10,img), (int) (x- game.getGameCamera().getxOffset()),(int)(y- game.getGameCamera().getyOffset()), width, height, null);
			}
			else if(rightleft%2==0){
				imgShown = SpriteSorter.SpriteSort(9,img);
//				g.drawImage(SpriteSorter.SpriteSort(9,img), (int) (x- game.getGameCamera().getxOffset()),(int)(y- game.getGameCamera().getyOffset()), width, height, null);
			}
			
			else if(rightleft%2==1){
				imgShown = SpriteSorter.SpriteSort(11,img);
//				g.drawImage(SpriteSorter.SpriteSort(11,img), (int) (x- game.getGameCamera().getxOffset()),(int)(y- game.getGameCamera().getyOffset()), width, height, null);
			}				
		}
		if(rundown==true){
			if(step==9||step==10||step==11||step==12||step==13||step==14||step==15||step==16){
				imgShown = SpriteSorter.SpriteSort(1,img);
//				g.drawImage(SpriteSorter.SpriteSort(1,img), (int) (x- game.getGameCamera().getxOffset()),(int)(y- game.getGameCamera().getyOffset()), width, height, null);
			}
			else if(rightleft%2==0){
				imgShown = SpriteSorter.SpriteSort(0,img);
//				g.drawImage(SpriteSorter.SpriteSort(0,img), (int) (x- game.getGameCamera().getxOffset()),(int)(y- game.getGameCamera().getyOffset()), width, height, null);
			}
			
			else if(rightleft%2==1){
				imgShown = SpriteSorter.SpriteSort(2,img);
//				g.drawImage(SpriteSorter.SpriteSort(2,img), (int) (x- game.getGameCamera().getxOffset()),(int)(y- game.getGameCamera().getyOffset()), width, height, null);
			}	
				
		}
		if(runleft==true){
			if(step==9||step==10||step==11||step==12||step==13||step==14||step==15||step==16){
				imgShown = SpriteSorter.SpriteSort(4,img);
//				g.drawImage(SpriteSorter.SpriteSort(4,img), (int) (x- game.getGameCamera().getxOffset()),(int)(y- game.getGameCamera().getyOffset()), width, height, null);
			}
			else if(rightleft%2==0){
				imgShown = SpriteSorter.SpriteSort(3,img);
//				g.drawImage(SpriteSorter.SpriteSort(3,img), (int) (x- game.getGameCamera().getxOffset()),(int)(y- game.getGameCamera().getyOffset()), width, height, null);
			}
			
			else if(rightleft%2==1){
				imgShown = SpriteSorter.SpriteSort(5,img);
//				g.drawImage(SpriteSorter.SpriteSort(5,img), (int) (x- game.getGameCamera().getxOffset()),(int)(y- game.getGameCamera().getyOffset()), width, height, null);
			}	
		}
		if(runright==true){
			if(step==9||step==10||step==11||step==12||step==13||step==14||step==15||step==16){
				imgShown = SpriteSorter.SpriteSort(7,img);
//				g.drawImage(SpriteSorter.SpriteSort(7,img), (int) (x- game.getGameCamera().getxOffset()),(int)(y- game.getGameCamera().getyOffset()), width, height, null);
			}
			else if(rightleft%2==0){
				imgShown = SpriteSorter.SpriteSort(6,img);
//				g.drawImage(SpriteSorter.SpriteSort(6,img), (int) (x- game.getGameCamera().getxOffset()),(int)(y- game.getGameCamera().getyOffset()), width, height, null);
			}
			
			else if(rightleft%2==1){
				imgShown = SpriteSorter.SpriteSort(8,img);
//				g.drawImage(SpriteSorter.SpriteSort(8,img), (int) (x- game.getGameCamera().getxOffset()),(int)(y- game.getGameCamera().getyOffset()), width, height, null);
			}	
		}
					
		
		
	}
	
	public float getxMove() {
		return xMove;
	}

	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	public float getyMove() {
		return yMove;
	}

	public void setyMove(float yMove) {
		this.yMove = yMove;
	}

	
	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}
	
	
	 

}
