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
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.gfx.ImageLoader;
import dev.zt.UpliftedVFFV.utils.Utils;


public class BattleState extends State {
	
	private BufferedImage testImage;
	public int currentlySelected;
	public int currentlyTargeted;
	public int actionSelected;
	public Boolean playerSelected=false;
	public Boolean moveSelected=false;
	public Character[] allies, enemy;
	//public BattleState(Game game, StateManager sm, Character[] party,int troopId){
		public BattleState(Game game, StateManager sm){
			
		super(game,sm);
//		this.allies = party;
		testImage = ImageLoader.loadImage("/textures/title.png");
		currentlySelected=0;
		actionSelected=0;

	}

	public void tick() {
		if(playerSelected==false){
			if(game.getKeyManager().right){
				if(currentlySelected<2){
					currentlySelected++;
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			if(game.getKeyManager().left){
				if(currentlySelected>0){
					currentlySelected--;
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			if(game.getKeyManager().space){
				playerSelected=true;
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
		else{
			if(game.getKeyManager().down){
				if(actionSelected<3){
					actionSelected++;
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			if(game.getKeyManager().up){
				if(actionSelected>0){
					actionSelected--;
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			if(game.getKeyManager().space){
				moveSelected=true;
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
			

	}
			

	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 640, 416);
		g.drawImage(testImage, 48, 0, null);
		for(int i=0;i<3;i++){
			g.drawImage(ImageLoader.loadImage("/CharacterBusts/Player-1.png"), i*150, 200,null);
		}
		g.drawImage(Assets.Downarrow,100+currentlySelected*150,200,null);
		if(playerSelected==true){
			g.setColor(new Color(102, 178,255));
			g.fillRect(540, 316,100,100);
			g.setColor(new Color(200, 200,200));
			g.fillRect(540,316+25*actionSelected, 100, 25);
			g.setFont(new Font("Chewy", Font.PLAIN, 18));
			g.setColor(new Color(255, 255,255));
			g.drawString("Attack", 540, 335);
			g.drawString("Argleblargh", 540, 360);
			g.drawString("Item", 540, 385);
			g.drawString("Run", 540, 410);
			if(moveSelected==true){
				if(actionSelected==3){
					actionSelected=0;
					playerSelected=false;
					moveSelected=false;
				}
			}
		}
		
	}

	@Override
	public void init() {
		
	}
	

}
