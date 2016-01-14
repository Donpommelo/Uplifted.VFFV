package dev.zt.UpliftedVFFV.states;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.gfx.ImageLoader;
import dev.zt.UpliftedVFFV.party.PartyManager;
import dev.zt.UpliftedVFFV.utils.Utils;

//State for when the player must choose an option from a list of any size
public class SaveFileState extends State {
	
	private static final long serialVersionUID = 1L;
	
	private BufferedImage window;
	private GameState gs;
	private int numFiles;
	public int mode;
	/*
	  0: "Continue": Load file chosen
	  1: "Save Game": Overwrite file chosen
	  */
	 
	public String[] num;
	public GameState[] gamestates;
	public int currentchoice, choicelocation,firstchoice, yesno;
	public boolean selected,exit;
	public boolean fileNotFound;
	
	public int boxSize = 3;
	
	public int eventId;
	
	//KeyListener delay variables.
	private int delayCursor = 120;
	private int delaySelection = 200;
		
	public SaveFileState(Game game, GameState gs, StateManager sm,  int eventId, int mode){
		super(game,sm);
		this.gs = gs;
		this.eventId = eventId;
		setStateType("choice");
		window = ImageLoader.loadImage("/ui/Window/WindowBlue.png");
		currentchoice=0;				//which item is selected
		choicelocation=0;				//where does the item show up on the menu
		firstchoice=0;					//where out of all the options is the list currently looking at
		yesno = 0;						//whether selected yes or no after choosing file
		selected=false;			
		exit=false;						//pressed when exiting. back button
		fileNotFound = false;
		this.mode = mode;					//whether state is called when saving or loading a file.
		
		numFiles = 0;
		for(int i = 0; i < 999; i++){
			try {
				new FileInputStream("res/Saves/" + (i+1) + ".save");
			} catch (FileNotFoundException e) {
				break;
			}
			numFiles++;
		}
		
		
		num = new String[numFiles+1];
		gamestates = new GameState[numFiles];
		for(int i = 0; i < num.length-1; i++){
			num[i] = "File: "+(i+1);
			try {
				FileInputStream fis = new FileInputStream("res/Saves/" + (i+1)+ ".save");
				ObjectInputStream ois = new ObjectInputStream(fis);
				gamestates[i] = new GameState(game, sm);
				gamestates[i].readObject(ois);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		switch(mode){
		case 0:
			if(numFiles == 0){
				num[num.length-1] = "No Save Files Found!";
			}
			break;
		case 1:
			num[num.length-1] = "Create New Save File!";
			numFiles++; 
			break;
		}
		

	}

	public void tick() {
		if(game.getKeyManager().isActive()){
			//pressing x goes back
			if(game.getKeyManager().x){
				exit=true;
				game.getKeyManager().disable(delayCursor);
			}
			
			//pressing space runs the currently selected option
			if(game.getKeyManager().space){
				if(!selected){
					if(num.length == 1 && mode == 0){
						exit = true;
					}
					else{
						selected=true;
					}
				}
				else {
					switch(yesno){
					case 1:
						exit = true;
						break;
					case 0:
						switch(mode){
						case 0:
							try {
								StateManager.getStates().pop();
								StateManager.states.push(Utils.loadState(game, statemanager, currentchoice+1));
							} catch (FileNotFoundException e) {
								StateManager.states.push(this);
								StateManager.states.push(new NotificationState(gs.getGame(),gs, gs.getStateManager(), "File Not Found!", eventId));
								selected = false;
							} catch (IOException e) {
								e.printStackTrace();
							} catch (ClassNotFoundException e) {
								StateManager.states.push(this);
								StateManager.states.push(new NotificationState(gs.getGame(),gs, gs.getStateManager(), "File Not Found!", eventId));
								selected = false;
							}
							break;
						case 1:
							try {
								StateManager.getStates().pop();
								Utils.saveState(gs,eventId,currentchoice+1);
								SaveFileState newSFS = new SaveFileState(game,gs,statemanager, 0,1);
								newSFS.setVariables(currentchoice, firstchoice, choicelocation);
								StateManager.states.push(newSFS);
								StateManager.states.push(new NotificationState(game,gs, statemanager, "Game Saved", 0));
								selected = false;
							} catch (IOException e) {
								e.printStackTrace();
							}
							break;
						}
					}
					
				}
				game.getKeyManager().disable(delaySelection);
			}
			
			//up and down choose options
			if(game.getKeyManager().up){
				if(!selected){
					if(currentchoice>0){
						game.getAudiomanager().playSound("/Audio/tutorial_ui_click_01.wav", false);
						currentchoice--;
						if(choicelocation==0){
							firstchoice--;
						}
						else{
							choicelocation--;
						}
					}
				}
				else{
					yesno=0;
				}
				game.getKeyManager().disable(delayCursor);

			}
			if(game.getKeyManager().down){
				if(!selected){
					if(currentchoice<numFiles-1){
						game.getAudiomanager().playSound("/Audio/tutorial_ui_click_01.wav", false);
						currentchoice++;
						if(choicelocation==boxSize-1){
							firstchoice++;
						}
						else{
							choicelocation++;
						}
					}
				}
				else{
					yesno = 1;
				}
				game.getKeyManager().disable(delayCursor);

			}
		}			
	}
			

	public void render(Graphics g) {
		if(exit){
			if(selected){
				selected = false;
				exit = false;
			}
			else{
				StateManager.getStates().pop();
				exit=false;
			}
		}
		
//		Utils.drawMenu(g, window, num, Color.black, 18, currentchoice, 5, 5, 630, 406,1,numFiles+1,firstchoice,16, true);
		int boxNum = 0;
		int lastbox = firstchoice+boxSize;
		if(num.length<3){
			lastbox = firstchoice+num.length;
		}
		for(int i = firstchoice; i <lastbox; i++){
			if(num[i] != null){
				Utils.drawDialogueBox(g, window, "", 18, Color.black, 0, 9+134*boxNum, 630, 125, 16, true);
				if(i == num.length-1){
					g.setFont(new Font("Chewy", Font.PLAIN, 30));
					g.drawString(num[i], 150, 134*boxNum+60);
				}
				else{
					g.setFont(new Font("Chewy", Font.PLAIN, 18));
					g.drawString(num[i], 10, 134*boxNum+41);
					PartyManager pm = gamestates[i].getPartymanager();
					g.setFont(new Font("Chewy", Font.PLAIN, 12));
					for(int j = 0; j < pm.getParty().size(); j++){
						g.drawString(pm.getParty().get(j).getName(), 70 + 60 * j, 30+134*boxNum);
						g.drawImage(pm.getParty().get(j).getMenuSprite(), 70 + 60 * j, 20+134*boxNum, 60, 90, null);
						g.drawString("Lvl :   "+pm.getParty().get(j).getLvl(), 70 + 60 * j, 125+134*boxNum);
					}
				}
				boxNum++;
			}
		}
		Utils.drawCursor(g, window, 0, 9+choicelocation * 134, 630, 125, false);
		
		
		if(selected){
			String[] choices = {"Load File?","Never Mind"};
			switch(mode){
			case 0:
				choices[0] = "Load File";
				break;
			case 1:
				choices[0] = "Save File";
				break;
			}
			if(mode == 1 && currentchoice != numFiles-1){
				Utils.drawDialogueBox(g, window, "Overwrite Saved Data?", 18, Color.black, 430, 10+currentchoice*134, 200, 32, 16, true);
			}
			Utils.drawMenu(g, window, choices, Color.black, 18, yesno, 527, 57+currentchoice*134, 100, 64, true);
			
		}
		
		if(firstchoice != 0){
			g.drawImage(Assets.Uparrow, 310, 0, null);
		}
		if(firstchoice+boxSize != numFiles && numFiles > 3){
			g.drawImage(Assets.Downarrow, 310, 390, null);
		}
	
	}
	
	public void setVariables(int selected, int location, int pointer){
		this.currentchoice = selected;
		this.firstchoice = location;
		this.choicelocation = pointer;
	}

	@Override
	public void init() {
		
	}
	

}
