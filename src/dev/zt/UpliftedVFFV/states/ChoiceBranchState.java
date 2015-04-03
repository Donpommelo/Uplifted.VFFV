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
	public int currentchoice, choicelocation,firstchoice;
	public boolean selected;
	public ChoiceBranchState(Game game, StateManager sm, int eventId,String[] choices){
		super(game,sm);
		this.EventId=eventId;
		this.num=choices;
		currentchoice=0;
		choicelocation=0;
		firstchoice=0;
		selected=false;
	}

	public void tick() {
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
				if(choicelocation==4){
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
		if(selected==true){
			statemanager.states.pop();
			statemanager.states.pop();
			Event.events[this.EventId].ChoiceMade(currentchoice);

		}
		else{
			g.setColor(new Color(102, 178,255, 200));
			g.fillRect(5, 30, 100, 125);
			g.setColor(new Color(200, 200,200, 200));
			g.fillRect(5, 30+25*choicelocation, 100, 25);
			g.setFont(new Font("Chewy", Font.PLAIN, 18));
			g.setColor(Color.BLACK);
			for(int i=0;i<5;i++){
				g.drawString(num[firstchoice+i], 5, 50+25*i);
			}

		}
		if(firstchoice!=0){
			g.drawImage(Assets.Uparrow,50,25,null);
		}
		if(firstchoice!=num.length-5){
			g.drawImage(Assets.Downarrow,50,145,null);
		}
	
	}

	@Override
	public void init() {
		
	}
	

}
