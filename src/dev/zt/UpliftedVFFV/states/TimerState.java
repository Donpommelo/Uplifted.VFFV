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
public class TimerState extends State {
	
	private StateManager statemanager;
	public int time;
	public int EventId;
	public int timer;
	
	//Dialogstates require an arraylist of BufferedImages
	public TimerState(Game game, StateManager sm,int eventId, int time){
		super(game,sm);
		this.EventId=eventId;
		this.time = time;

	}

	public void tick() {
		if(timer>=time){
			statemanager.states.pop();
			if(Event.events[this.EventId].getstage()!=Event.events[this.EventId].getfinalstage()){
				Event.events[this.EventId].setstage(Event.events[this.EventId].getstage()+1);
				Event.events[this.EventId].run();
			}
		}
		else{
			timer++;
		}
		
			
	}
			
	
	public void render(Graphics g) {
		statemanager.states.pop();
		statemanager.states.peek().render(g);
		statemanager.states.push(this);
	}

	@Override
	public void init() {
		
	}
	

}
