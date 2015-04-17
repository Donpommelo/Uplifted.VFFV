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


public class ChoiceBranchState extends State {
	
	public int EventId;
	public String[] num;
	public int currentchoice, choicelocation,firstchoice, boxsize;
	public boolean selected,exit;
	public ChoiceBranchState(Game game, StateManager sm, int eventId,String[] choices){
		super(game,sm);
		this.EventId=eventId;
		this.num=choices;
		currentchoice=0;
		choicelocation=0;
		firstchoice=0;
		selected=false;
		exit=false;
		if(num.length>5){
			boxsize=5;
		}
		else{
			boxsize=num.length;
		}
	}

	public void tick() {
		if(game.getKeyManager().x){
			exit=true;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if(game.getKeyManager().space){
			selected=true;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if(game.getKeyManager().up){
			if(currentchoice>0){
				currentchoice--;
				if(choicelocation==0){
					firstchoice--;
				}
				else{
					choicelocation--;
				}
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
		if(game.getKeyManager().down){
			if(currentchoice<num.length-1){
				currentchoice++;
				if(choicelocation==boxsize-1){
					firstchoice++;
				}
				else{
					choicelocation++;
				}
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

			
	}
			

	public void render(Graphics g) {
	
		statemanager.states.pop();
		statemanager.states.peek().render(g);
		statemanager.states.push(this);
		if(exit==true){
			statemanager.states.pop();
			Event.events[this.EventId].ChoiceMade(currentchoice);
/*			if(Event.events[this.EventId].getstage()!=Event.events[this.EventId].getfinalstage()){
				Event.events[this.EventId].setstage(Event.events[this.EventId].getstage()+1);
				Event.events[this.EventId].run();
			}*/
			statemanager.states.pop();
			exit=false;
		}
		if(selected==true){
			statemanager.states.pop();
			statemanager.states.pop();
			Event.events[this.EventId].ChoiceMade(currentchoice);
/*			if(Event.events[this.EventId].getstage()!=Event.events[this.EventId].getfinalstage()){
				Event.events[this.EventId].setstage(Event.events[this.EventId].getstage()+1);
				Event.events[this.EventId].run();
			}*/

		}
		else{
			g.setColor(new Color(102, 178,255, 200));
			g.fillRect(5, 30, 100, 25*boxsize);
			g.setColor(new Color(200, 200,200, 200));
			g.fillRect(5, 30+25*choicelocation, 100, 25);
			g.setFont(new Font("Chewy", Font.PLAIN, 18));
			g.setColor(Color.BLACK);
			for(int i=0;i<boxsize;i++){
				g.drawString(num[firstchoice+i], 5, 50+25*i);
			}

		}
		if(firstchoice!=0){
			g.drawImage(Assets.Uparrow,50,25,null);
		}
		if(firstchoice!=num.length-boxsize){
			g.drawImage(Assets.Downarrow,50,20+25*boxsize,null);
		}
	
	}

	@Override
	public void init() {
		
	}
	

}
