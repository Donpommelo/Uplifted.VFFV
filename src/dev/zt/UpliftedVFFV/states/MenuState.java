package dev.zt.UpliftedVFFV.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Set;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.gfx.ImageLoader;
import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;


public class MenuState extends State {
	
	private BufferedImage testImage;
	private GameState gamestate;
	private int optionSelected,characterSelected,itemSelected,itemPointer,backpackLocation;
	private int itemnum;
	private boolean optionChosen,characterChosen,itemChosen,exit;
	StateManager statemanager;
	ArrayList<Character> party= new ArrayList<Character>();
	public MenuState(Game game, StateManager sm, GameState gs){
		super(game, sm);
		testImage = ImageLoader.loadImage("/textures/title.png");
		this.gamestate=gs;
		optionSelected=0;
		optionChosen=false;
		exit=false;
		characterSelected=0;
		itemSelected=0;
		itemPointer=0;
		backpackLocation=0;
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
		if(optionChosen==false){
			if(game.getKeyManager().space){
				optionChosen=true;
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			if(game.getKeyManager().up){
				if(optionSelected>0){
					optionSelected--;
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			if(game.getKeyManager().down){
				if(optionSelected<2){
					optionSelected++;
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
		else{
			switch(optionSelected){
			case 0: 
				if(game.getKeyManager().space){
					characterChosen=true;
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				if(game.getKeyManager().right){
				if(characterSelected<gamestate.partymanager.party.size()-1){
					characterSelected++;
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
						}
				}
				if(game.getKeyManager().left){
					if(characterSelected>0){
						characterSelected--;
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
				break;
			case 1:
				if(game.getKeyManager().space){
					itemChosen=true;
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				if(game.getKeyManager().right){
					if(itemSelected<gamestate.inventorymanager.backpack.size()-1){
					itemSelected++;
					if(itemPointer==26){
						backpackLocation+=3;
						itemPointer=24;
					}
					else{
						itemPointer++;
					}
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
						}
				}
				if(game.getKeyManager().left){
					if(itemSelected>0){
						itemSelected--;
					if(itemPointer==0){
						backpackLocation-=3;
						itemPointer=2;
					}
					else{
						itemPointer--;
					}
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
				if(game.getKeyManager().down){
					if(itemSelected<gamestate.inventorymanager.backpack.size()-3){
					itemSelected+=3;
					if(26-itemPointer<3){
						backpackLocation+=3;
					}
					else{
						itemPointer+=3;
					}
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
						}
				}
				if(game.getKeyManager().up){
					if(itemSelected>2){
						itemSelected-=3;
					if(itemPointer<3){
						backpackLocation-=3;
					}
					else{
						itemPointer-=3;
					}
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
				break;
				
				}
		}
	
		
	}


	public void render(Graphics g) {
		if(exit==true){
			if(characterChosen==true){
				characterChosen=false;
			}
			else if(itemChosen==true){
				itemChosen=false;
			}
			else if(optionChosen==true){
				optionChosen=false;
			}
			else{
				statemanager.states.pop();
			}
			exit=false;
		}
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 640, 416);
		g.drawImage(testImage, 48, 0, null);
		if(optionChosen==true){
			g.setColor(new Color(160,160,160));
		}
		else{
			g.setColor(new Color(255, 255,51));
		}
		g.fillRect(5, 5,125,406);
		g.setColor(new Color(102, 178,255));
		g.fillRect(5,5+25*optionSelected, 125, 25);
		g.setFont(new Font("Chewy", Font.PLAIN, 18));
		g.setColor(new Color(0, 0,0));
		g.drawString("Party", 10, 25);
		g.drawString("Inventory", 10, 50);
		g.drawString("Iunno", 10, 75);
			switch(optionSelected){
			case 0:
				if(optionChosen==false){
					g.setColor(new Color(160, 160,160));
				}
				else{
					g.setColor(new Color(255, 255,51));
				}
				g.fillRect(135, 5,500,160);
				g.fillRect(135, 170, 500, 240);
				for(int i=0;i<gamestate.partymanager.party.size();i++){
				g.setFont(new Font("Chewy", Font.PLAIN, 18));
				g.setColor(new Color(0, 0,0));
				g.drawString(gamestate.partymanager.party.get(i).getName(), 150+100*i, 30);
				g.drawImage(gamestate.partymanager.party.get(i).getBattleSprite(),130+100*i,15,100,150,null);
				}
				g.drawImage(Assets.Downarrow,180+characterSelected*100,5,null);
				if(characterChosen==true){
					
				}
				
				break;
			case 1:
				if(optionChosen==false){
					g.setColor(new Color(160, 160,160));
				}
				else{
					g.setColor(new Color(255, 255,51));
				}
				g.fillRect(135, 5,500,160);
				g.fillRect(135, 170, 500, 240);
				Set<Item> temp= gamestate.inventorymanager.backpack.keySet();
				Item[] itemDisplay= temp.toArray(new Item[27]);
				if(itemDisplay[itemSelected]!=null){
				g.setColor(new Color(102, 178,255));
				g.fillRect(136+166*(itemPointer%3), 180+25*(itemPointer/3), 166, 25);
				}
				g.setFont(new Font("Chewy", Font.PLAIN, 12));
				itemnum=0;
//				for(Item current : temp){
				for(int i=backpackLocation;i<=backpackLocation+26 && i<gamestate.inventorymanager.backpack.size();i++){			
					g.setColor(new Color(0, 0,0));
					g.drawString(itemDisplay[i].getName()+"  x"+gamestate.inventorymanager.backpack.get(itemDisplay[i]), 140+175*(itemnum%3), 200+25*(itemnum/3));
					itemnum++;
				}

				if(itemDisplay[itemSelected]!=null){
					g.setColor(new Color(102, 178,255));
					g.fillRect(140, 10, 150, 150);
					g.setFont(new Font("Chewy", Font.PLAIN, 18));
					g.setColor(new Color(0, 0,0));
					g.drawString(itemDisplay[itemSelected].getName(),295,30);
					g.setFont(new Font("Chewy", Font.PLAIN, 12));
					if(itemDisplay[itemSelected].getDescr()!=null){
//						g.drawString(itemDisplay[itemSelected].getDescr(), 295, 60);
						int y=60;
						for (String line : itemDisplay[itemSelected].getDescr().split("\n"))
					        g.drawString(line, 295, y += g.getFontMetrics().getHeight());
					}
				}
				else{
					g.setColor(new Color(0, 0,0));
					g.setFont(new Font("Chewy", Font.PLAIN, 50));
					g.drawString("Your Inventory is Empty", 145, 115);
					g.setFont(new Font("Chewy", Font.PLAIN, 130));
					g.drawString("Get a Job", 150, 320);
				}
				
				if(backpackLocation>2){
					g.drawImage(Assets.Uparrow,385,165,null);
				}
				if((backpackLocation+27)/3!=(gamestate.inventorymanager.backpack.size()+2)/3){
					g.drawImage(Assets.Downarrow,385,405,null);
				}
				
				break;
			}


		
//		g.drawImage(testImage, 0, 0, null);
//		if(optionChosen){
//			statemanager.states.pop();
//			optionChosen=false;
//			StateManager.states.push(new DialogState(game,statemanager,0,2));
//		}
		
	}

	@Override
	public void init() {
		
	}
	

}
