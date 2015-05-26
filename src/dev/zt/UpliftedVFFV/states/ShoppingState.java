package dev.zt.UpliftedVFFV.states;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.gfx.ImageLoader;
import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.utils.Utils;

//State for when the player is shoppin'. Modified version of ChoiceBranchState.
public class ShoppingState extends State {
	
	public int EventId;
	public TreeMap<Item, Integer> selection = new TreeMap<>();
	public int currentchoice, choicelocation,firstchoice, boxsize;
	public int amount;
	public Item[] itemDisplay;
	public boolean selected,exit;
	public BufferedImage shopKeeper;
	public GameState gs;
	public String text;
	public ShoppingState(Game game, GameState gs, StateManager sm, int eventId,TreeMap<Item, Integer> choices, BufferedImage sk){
		super(game,sm);
		this.EventId=eventId;
		this.selection=choices;
		this.gs = gs;
		this.shopKeeper = sk;
		currentchoice=0;				//which item is selected
		choicelocation=0;				//where does the item show up on the menu
		firstchoice=0;					//where out of all the options is the list currently looking at
		amount = 0;
		selected=false;					
		exit=false;						//pressed when exiting. back button
		if(selection.size()>8){				//list is 5 items long. Any longer and the list will scroll
			boxsize=8;
		}
		else{
			boxsize=selection.size();
		}
		AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
		tx.translate(-shopKeeper.getWidth(null), 0);
		AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
		shopKeeper = op.filter(shopKeeper, null);
		Set<Item> temp = selection.keySet();
		itemDisplay = temp.toArray(new Item[999]);
		text = itemDisplay[choicelocation].getDescr();
	}

	public void tick() {
		
		//pressing x goes back
		if(game.getKeyManager().x){
			exit=true;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		//pressing space runs the currently selected option
		if(!selected){
			if(game.getKeyManager().space){
				selected=true;
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			//up and down choose options
			if(game.getKeyManager().up){
				if(currentchoice>0){
					game.getAudiomanager().playSound("/Audio/tutorial_ui_click_01.wav", false);
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
					text = itemDisplay[choicelocation].getDescr();
				}
				
			}
			if(game.getKeyManager().down){
				if(currentchoice<selection.size()-1){
					game.getAudiomanager().playSound("/Audio/tutorial_ui_click_01.wav", false);
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
					text = itemDisplay[choicelocation].getDescr();
				}
			}
		}
		else{
			if(game.getKeyManager().space){
				game.getAudiomanager().playSound("/Audio/buy.wav", false);
				gs.scriptChange(-amount*selection.get(itemDisplay[choicelocation]));
				gs.inventorymanager.loot(itemDisplay[choicelocation], amount);
				text = "Bought "+amount+" "+itemDisplay[choicelocation].getName()+" for "+amount*selection.get(itemDisplay[choicelocation])+" Script!";
				exit = true;
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			//up and down choose options
			if(game.getKeyManager().up){
				if((amount+1)*selection.get(itemDisplay[choicelocation])<=gs.Script){
					game.getAudiomanager().playSound("/Audio/tutorial_ui_click_01.wav", false);
					amount++;
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
			}
			if(game.getKeyManager().down){
				if(amount>0){
					game.getAudiomanager().playSound("/Audio/tutorial_ui_click_01.wav", false);
					amount--;
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
		

			
	}
			

	public void render(Graphics g) {
		
		//ChoiceBranches do not take up the entire screen. The state underneath it should be rendered as well
		statemanager.states.pop();
		statemanager.states.peek().render(g);
		statemanager.states.push(this);
		
		//if x is pressed, the state is popped
		if(exit==true){
			if(selected){
				selected = false;
				amount = 0;
				exit = false;
			}
			else{
				statemanager.states.pop();
				exit=false;
			}
			
		}
		g.drawImage(shopKeeper, 640-shopKeeper.getWidth(), 416-shopKeeper.getHeight(), null);
		g.setColor(new Color(102, 178,255, 200));
		g.fillRect(5, 5, 100, 50);
		g.fillRect(0, 316, 640, 100);
		g.fillRect(360, 5, 275, 25*boxsize);
		g.setColor(new Color(200, 200,200, 200));
		g.fillRect(360, 5+25*choicelocation, 275, 25);
		g.setFont(new Font("Chewy", Font.PLAIN, 18));
		g.setColor(Color.BLACK);
		g.drawString("Script: "+gs.Script,10,25);
		for(int i=0;i<boxsize;i++){
			g.drawString(itemDisplay[firstchoice+i].getName(), 365, 25+25*i);
			g.drawString(selection.get(itemDisplay[firstchoice+i])+" Script", 575,25+25*i);
		}
		g.setColor(new Color(255, 255,255));
		g.fillRect(210, 5, 150, 150);
		g.setFont(new Font("Chewy", Font.PLAIN, 18));
		g.setColor(new Color(0,0,0));
		if(itemDisplay[choicelocation].getDescr()!=null){
			int y=320;
			for (String line : text.split("\n"))
		        g.drawString(line, 5, y += g.getFontMetrics().getHeight());
		}
		if(selected){
			g.setColor(new Color(102, 178,255, 200));
			g.fillRect(180, 200, 275, 50);
			g.setFont(new Font("Chewy", Font.PLAIN, 18));
			g.setColor(new Color(0,0,0));
			g.drawString(itemDisplay[choicelocation].getName()+" x "+amount+" :",185,225);
			g.drawString(amount*selection.get(itemDisplay[choicelocation])+" Script",400, 225);
			if(amount>0){
				g.drawImage(Assets.Downarrow,300,255,null);
			}
			if((amount+1)*selection.get(itemDisplay[choicelocation])<=gs.Script){
				g.drawImage(Assets.Uparrow,300,180,null);
			}
		}

	}

	@Override
	public void init() {
		
	}
	

}
