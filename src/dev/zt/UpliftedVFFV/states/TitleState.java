package dev.zt.UpliftedVFFV.states;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.gfx.ImageLoader;
import dev.zt.UpliftedVFFV.utils.Utils;

//First state ran. This is a title screen
public class TitleState extends State {
	
	private BufferedImage testImage, window;
	private boolean controls, about;
	private boolean exit;
	private StateManager statemanager;
	private int optionChosen;
	
	public TitleState(Game game, StateManager sm){
		super(game,sm);
		testImage = ImageLoader.loadImage("/textures/title.png");
		window = ImageLoader.loadImage("/ui/Window/WindowBlack.png");
		controls = false;
		about = false;
		exit = false;
	}

	//receives input command to either begin or exit the game
	public void tick() {
		
		if(game.getKeyManager().x){
			exit=true;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		if(game.getKeyManager().down){
			if(optionChosen<3){
				game.getAudiomanager().playSound("/Audio/tutorial_ui_click_01.wav", false);
				optionChosen++;
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if(game.getKeyManager().up){
			if(optionChosen>0){
				game.getAudiomanager().playSound("/Audio/tutorial_ui_click_01.wav", false);
				optionChosen--;
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		if(game.getKeyManager().space){
			if(about || controls){
				exit = true;
			}
			else{
				switch(optionChosen){
				case 0:
					StateManager.states.push(new GameState(game,statemanager));			//This pushes on a gamestate. The game begins.	
					break;
				case 1:
					controls = true;
					break;
				case 2:
					about = true;
					break;
				case 3:
					System.exit(0);														//this exits the game
					break;
				}
			}	
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}


	public void render(Graphics g) {
		if(exit){
			exit = false;
			controls = false;
			about = false;
		}
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 640, 416);
		g.drawImage(testImage, 48, 0, null);
		//g.setColor(new Color(102, 178,255));
		//g.fillRect(360,200, 150, 100);

		String[] options = {"New Game", "Controls", "About", "Quit"};
		Utils.drawMenu(g, window, options, Color.white, 25, optionChosen, 360, 200, 150, 120, true, true);
		
		if(controls){
			g.setColor(new Color(102, 178,255));
			g.fillRect(5,5, 630, 406);
			g.setColor(new Color(255, 255,255));
			g.fillRect(15, 15, 600, 386);
			g.setFont(new Font("Chewy", Font.PLAIN, 24));
			g.setColor(new Color(0, 0,0));
			g.drawString("Controls", 270, 40);
			g.setFont(new Font("Chewy", Font.PLAIN, 18));
			g.drawString("Arrow Keys: Movement and menu navigation.", 200, 100);
			g.drawString("Spacebar: Interact with objects and select menu options.", 200, 140);
			g.drawString("Z: Pull up main menu", 200, 180);
			g.drawString("X: Cancel or go back", 200, 220);
			g.drawString("ENTER: Confirm combat decision", 200, 260);
			g.drawImage(ImageLoader.loadImage("/CharacterBusts/Player-1.png"), 0, 41, null);			
		}
		if(about){
			g.setColor(new Color(102, 178,255));
			g.fillRect(5,5, 630, 406);
			g.setColor(new Color(255, 255,255));
			g.fillRect(15, 15, 600, 386);
			g.setFont(new Font("Chewy", Font.PLAIN, 24));
			g.setColor(new Color(0, 0,0));
			g.drawString("About", 270, 40);
			g.setFont(new Font("Chewy", Font.PLAIN, 18));
			g.drawString("Welcome to the Uplifted Demo", 315, 100);
			g.drawString("Uplifted is a 2D, turn-based, rpg game.", 315, 125);
			g.drawString("All content is subject to change.", 315, 150);
			g.drawString("Special Thanks to Mrs Lorena.", 315, 175);
			g.drawString("Michael Cheng: Opening Theme.", 315, 200);
			g.drawString("youtube.com/user/symphony9711.", 315, 225);
			g.drawString("Iwilldevouryourkittens: Battle Theme.", 315, 250);
			g.drawString("soundcloud.com/iwilldevouryourkittens", 315, 275);
			g.drawString("And everyone who supported and playtested.", 315, 300);
			g.drawString("Send comments to donpommelo@gmail.com", 315, 325);			
			g.drawImage(ImageLoader.loadImage("/CharacterBusts/Player-5.png"), -40, -139, null);
			
		}
	}

	@Override
	public void init() {
		
	}
	

}
