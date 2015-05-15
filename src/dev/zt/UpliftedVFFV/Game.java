package dev.zt.UpliftedVFFV;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.audio.AudioManager;
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
	private AudioManager audiomanager;
	
	//Input
	private KeyManager keyManager;
	private WorldManager worldmanager;
	
	
	private GameCamera gameCamera;
	
	public Game(String title, int width, int height){			//created by launcher. automatically runs init(), then tick and render
		this.width = width;
		this.height = height;
		this.title = title;
		keyManager = new KeyManager();							//controls keyboard inputs

	}
	
	private void init(){
	
		display =new Display(title, width, height);				//creates canvas. Stuff is drawn in this window
		display.getFrame().addKeyListener(keyManager);			//this makes window respond to keyboard commands set up in keymanager
		Assets.init();											//preloads all textures and other art assets
		
		gameCamera = new GameCamera(this,0,0);					//creates a gameCamera. This tracks movement of player to center the screen
		
		audiomanager = new AudioManager(this);
//		audiomanager.playSound();
		
		statemanager=new StateManager(this);							//creates statemanager. This manages the states of the game
		statemanager.states.push(new TitleState(this,statemanager));	//upon initializing, the first state should be the TitleState 
		
		worldmanager=new WorldManager(this);					//creates a worldmanager. This manages the world.
	//	statemanager.init();
		
	}
	
	

	int x=0;													
																
	private void tick(){										//Every tick, the game runs the tick() of the current state
		keyManager.tick();
		
		if(statemanager.states.peek() != null)
			statemanager.states.peek().tick();
	}
	
	private void render(){										//Every render, the game runs the render() of the current state
		bs = display.getCanvas().getBufferStrategy();			//bufferStrategy used to load smoother.
		if(bs == null){
			display.getCanvas().createBufferStrategy(3);		//Sorta an assembly line of 3 images. This way, they'll always be ready to display
			return;
		}
		g = bs.getDrawGraphics();								
		g.clearRect(0, 0, width, height);
		
		
		if(statemanager.states.peek() != null)
			statemanager.states.peek().render(g);
		
		bs.show();
		g.dispose();
		
	}
	
	public void run(){											//first thing run after launching
		
		init();													//runs own init() method
		
		int fps = 60;											//all this stuff controls tick intervals
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
		
	public AudioManager getAudiomanager() {
		return audiomanager;
	}

	public void setAudiomanager(AudioManager audiomanager) {
		this.audiomanager = audiomanager;
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
