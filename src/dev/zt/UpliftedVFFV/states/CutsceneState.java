package dev.zt.UpliftedVFFV.states;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.concurrent.TimeUnit;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.gfx.ImageLoader;
import dev.zt.UpliftedVFFV.utils.Utils;

//Cutscene. This plays a series of pictures
public class CutsceneState extends State {
	
	private StateManager statemanager;
	public BufferedImage[] scenes;
	public int image;
	public int EventId;
	public BufferedImage img;
	
	//Dialogstates require an arraylist of BufferedImages
	public CutsceneState(Game game, StateManager sm, BufferedImage[] slides,int eventId){
		super(game,sm);
		this.scenes = slides;
		this.EventId=eventId;
		this.image = 0;
		System.out.print("meep");
	}

	public void tick() {
		
		//if space is pressed and the there re more images in the array, the next one will be displayed
		if(game.getKeyManager().space){
				if(image>=scenes.length-1){
					statemanager.states.pop();
					
					//This is used for multistage event processing. If there are multiple stages in the event being run, the stage will
					//increment and the event will be rerrun with the new stage.
					if(Event.events[this.EventId].getstage()!=Event.events[this.EventId].getfinalstage()){
						Event.events[this.EventId].setstage(Event.events[this.EventId].getstage()+1);
						Event.events[this.EventId].run();
					}
					
					}	
				else{
					image++;
				}
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}	
		}	
			
	}
			
	//rendering the DialogState consists of rendering whatever the current dialog is.
	//Also, because dialog does not take up the whole screen, the state underneath it must be rendered first
	public void render(Graphics g) {
		img = scenes[image];
		g.drawImage(img, 0, 0, null);
	}

	@Override
	public void init() {
		
	}
	

}
