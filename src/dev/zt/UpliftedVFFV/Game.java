package dev.zt.UpliftedVFFV;


import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.io.Serializable;

import dev.zt.UpliftedVFFV.audio.AudioManager;
import dev.zt.UpliftedVFFV.display.Display;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.gfx.GameCamera;
import dev.zt.UpliftedVFFV.input.KeyManager;
import dev.zt.UpliftedVFFV.states.StateManager;
import dev.zt.UpliftedVFFV.states.TitleState;
import dev.zt.UpliftedVFFV.world.WorldManager;

public class Game implements Runnable, Serializable{
	
	private static final long serialVersionUID = 8L;

	//Determines method of fps control. (0 - Skip when ahead, 1 - Sleep when ahead, 2 - Render when ahead) 
	private int runMethod = 1;
	
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
	
	//Print frames?
	private boolean showFPS = false;
	
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
		getAudiomanager().playMusic(0, false);
		
		statemanager=new StateManager(this);							//creates statemanager. This manages the states of the game
		StateManager.getStates().push(new TitleState(this,statemanager));	//upon initializing, the first state should be the TitleState 
		
		worldmanager=new WorldManager(this);					//creates a worldmanager. This manages the world.
	//	statemanager.init();
		
	}
	
	

	int x=0;													
																
	private void tick(){										//Every tick, the game runs the tick() of the current state
		keyManager.tick();
		
		if(StateManager.getStates().peek() != null)
			StateManager.getStates().peek().tick();

			keyManager.setFocus(display.getFocus());
	}
	
	private void render(){										//Every render, the game runs the render() of the current state
		bs = display.getCanvas().getBufferStrategy();			//bufferStrategy used to load smoother.
		if(bs == null){
			display.getCanvas().createBufferStrategy(3);		//Sorta an assembly line of 3 images. This way, they'll always be ready to display
			return;
		}
		g = bs.getDrawGraphics();								
		g.clearRect(0, 0, width, height);
		
		
		if(StateManager.getStates().peek() != null)
			StateManager.getStates().peek().render(g);
		
		bs.show();
		g.dispose();
		
	}
	
	public void run(){											//first thing run after launching
		
		init();	
		
		int ticks = 0;

		int frames = 0;
		
		long start_time = 0;
		long end_time = 0;
		long elapsed_time = 0;
		
		if(runMethod == 0){
			//all this stuff controls tick intervals
			final int ticks_per_second = 80;	
			final int max_skip = 5;
			int tick_skip = 1000 / ticks_per_second;
			
			int loops = 0;
			
			long next_tick = 0;
			
			next_tick = System.currentTimeMillis();
			while(running){
				//Run game loop;
				start_time = System.currentTimeMillis();
				
				//Don't Tick until next_tick is reached or loop cap is reached.
				if(System.currentTimeMillis() < next_tick && loops < max_skip){
					loops++;
				} else{
					//System.out.println(System.currentTimeMillis());
					tick();
					ticks++;
					//Calc next tick time.
					loops = 0;
					next_tick = next_tick + tick_skip;
					//System.out.println("next: " + next_tick);
				}
				render();
				frames++;
				
				end_time = System.currentTimeMillis();
				elapsed_time = elapsed_time + (end_time - start_time);
				//System.out.println(elapsed_time);
				if(elapsed_time >= 1000 && showFPS){
					System.out.println("Frames: " + frames);
					System.out.println("Ticks: " + ticks);
					System.out.println("");
					frames = 0;
					ticks = 0;
					elapsed_time = 0;
				}
			}
		} else if(runMethod == 1){
			int fps = 80;
			int frameSkip = 1000 / fps;
			
			while(running){
				start_time = System.currentTimeMillis();
				tick();
				++ticks;
				render();
				++frames;
				
				//Wait for next update if needed.
				while(frameSkip - (System.currentTimeMillis() - start_time) > 0){
					try{
						Thread.sleep(1);
					} catch(Exception e){
						System.out.println(e.getStackTrace());
					}
				}
				
				end_time = System.currentTimeMillis();
				elapsed_time = elapsed_time + (end_time - start_time);
				//System.out.println(elapsed_time);
				if(elapsed_time >= 1000 && showFPS){
					System.out.println("Frames: " + frames);
					System.out.println("Ticks: " + ticks);
					System.out.println("");
					frames = 0;
					ticks = 0;
					elapsed_time = 0;
				}
			}
		} else if(runMethod == 2){
			//TODO: Find a way to render that doesn't suck.
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
	
	public Display getDisplay(){
		return display;
	}

}
