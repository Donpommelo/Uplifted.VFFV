package dev.zt.UpliftedVFFV;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.display.Display;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.gfx.GameCamera;
import dev.zt.UpliftedVFFV.gfx.ImageLoader;
import dev.zt.UpliftedVFFV.gfx.SpriteSheet;
import dev.zt.UpliftedVFFV.input.KeyManager;
import dev.zt.UpliftedVFFV.states.GameState;
import dev.zt.UpliftedVFFV.states.MenuState;
import dev.zt.UpliftedVFFV.states.State;
import dev.zt.UpliftedVFFV.states.StateManager;
import dev.zt.UpliftedVFFV.states.TitleState;
import dev.zt.UpliftedVFFV.world.WorldManager;

public class Game implements Runnable{
	
	private Display display;
	private int width, height;
	public String title;
	
	private boolean running = false;
	private Thread thread;
	
	private BufferStrategy bs;
	private Graphics g;
	
	private StateManager statemanager;

	//States
//	private State gameState;
//	private State menuState;
//	private State titleState;
	
	//Input
	private KeyManager keyManager;
	private WorldManager worldmanager;
	
	private GameCamera gameCamera;
	
	public Game(String title, int width, int height){
		this.width = width;
		this.height = height;
		this.title = title;
		keyManager = new KeyManager();

	}
	
	private void init(){
	
		display =new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);
		Assets.init();
		
		gameCamera = new GameCamera(this,0,0);
		
	//	gameState = new GameState(this, statemanager);
	//	menuState = new MenuState(this, statemanager);
	//	titleState = new TitleState(this, statemanager);
		
	//	State.setState(gameState);
	//	State.setState(titleState);
		statemanager=new StateManager(this);
		statemanager.states.push(new TitleState(this,statemanager));
		
		worldmanager=new WorldManager(this);
	//	statemanager.init();
		
	}
	
	

	int x=0;
	
	private void tick(){
		keyManager.tick();
		
		if(statemanager.states.peek() != null)
			statemanager.states.peek().tick();
	}
	
	private void render(){
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null){
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		g.clearRect(0, 0, width, height);
		
		
		if(statemanager.states.peek() != null)
			statemanager.states.peek().render(g);
		
		bs.show();
		g.dispose();
		
	}
	
	public void run(){
		
		init();
		
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		while(running){
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >=1){
				tick();
				render();
				ticks++;
				delta--;
			}
			
			if(timer>=1000000000){
				ticks = 0;
				timer = 0;
			}
			
		}
		
		stop();
		
	}
	
	public KeyManager getKeyManager(){
		return keyManager;
	}
	
	public GameCamera getGameCamera(){
		return gameCamera;
	}
	
	public StateManager getStatemanager() {
		return statemanager;
	}

	public WorldManager getWorldManager(){
		return worldmanager;
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
	
	public synchronized void start(){
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop(){
		if(!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
