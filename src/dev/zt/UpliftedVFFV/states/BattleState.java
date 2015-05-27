package dev.zt.UpliftedVFFV.states;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.sound.sampled.Clip;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.Battle.BattleBackground;
import dev.zt.UpliftedVFFV.Battle.BattleMenu;
import dev.zt.UpliftedVFFV.Battle.BattleProcessor;
import dev.zt.UpliftedVFFV.Battle.BattleSprites;
import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.gfx.ImageLoader;
import dev.zt.UpliftedVFFV.gfx.SpriteSheet;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.party.TroopManager;
import dev.zt.UpliftedVFFV.utils.Utils;


public class BattleState extends State {
	
	public String prevSong;
	private BufferedImage elevatorDoors;
	private SpriteSheet animatedDoors;
	private int introX,introY;
	public int currentlySelected;
	public int currentlyTargeted;
	public int actionSelected;
	public int EventId;
	public int frame;
	public Boolean playerSelected=false;
	public Boolean moveSelected=false;
	public Boolean runnable;
	public Boolean introScene;
	public Boolean musicReplace;
	public GameState gs;
	public BattleMenu bm;
	public BattleSprites bs;
	public BattleBackground bb;
	public TroopManager tm;
	public BattleProcessor bp;
	public ArrayList<Schmuck>allies=new ArrayList<Schmuck>();
	public ArrayList<Schmuck> enemy=new ArrayList<Schmuck>();
	public ArrayList<Schmuck> all=new ArrayList<Schmuck>();
	public BattleState(Game game, StateManager sm, ArrayList<Schmuck>party,int troopId, int eventId,boolean runnable, boolean music,GameState gs){
		super(game,sm);
//		game.getAudiomanager().playMusic(3);
		this.gs=gs;
		this.EventId = eventId;
		this.runnable = runnable;
		this.musicReplace = music;
		tm= new TroopManager(game);
//		bm = new BattleMenu(game,sm,party,tm.Troop(troopId),this);
		bp = new BattleProcessor(game,sm,party,tm.Troop(troopId),gs,this);
		bs = new BattleSprites(game,sm,party,tm.Troop(troopId),this);
		bb = new BattleBackground(game,sm,this);
		this.allies = party;
		this.enemy = tm.Troop(troopId);
		animatedDoors = new SpriteSheet(ImageLoader.loadImage("/textures/BattleIntro1.png"));
		introScene = true;
		introX = 0;
		introY = 0;
		frame = 0;
//		currentlySelected=0;
//		actionSelected=0;

	}

	public void tick() {
		if(introScene){
			frame++;			
		}
		else{
			bs.tick();
			bp.tick();	
		}
//		bm.tick();

	}
			

	public void render(Graphics g) {
		if(introScene){
			if(frame<=54){
				introY = 416*(int)(frame/3);
				statemanager.states.pop();
				statemanager.states.peek().render(g);
				statemanager.states.push(this);
				elevatorDoors = animatedDoors.crop(introX, introY, 640, 416);
				g.drawImage(elevatorDoors,0,0,null);
			}
			else if (frame<=100){
				
				g.drawImage(elevatorDoors,0,0,null);
			}
			else if(frame<=154){
//				g.drawImage(floor, 0, 0,null);
//				g.drawImage(wall, 0, -32, null);					
				bb.render(g);
				bs.render(g);
				bp.render(g);
				introY = 416*(int)((frame-100)/3);
				elevatorDoors = animatedDoors.crop(introX,7488-introY, 640, 416);
				g.drawImage(elevatorDoors,0,0,null);
			}
			else{
				if(musicReplace){
					game.getAudiomanager().playMusic(3,true);
				}
				bb.render(g);
				bs.render(g);
				bp.render(g);
				introScene = false;
			}
			
		}
		else{
//			g.drawImage(floor, 0, 0,null);
//			g.drawImage(wall, 0, -32, null);	
			bb.render(g);
			bs.render(g);
			bp.render(g);
//			bm.render(g);
		}

		
	}
	
	public void end(boolean victory){
		statemanager.states.pop();
		game.getAudiomanager().playMusic(2, true);
		//This is used for multistage event processing. If there are multiple stages in the event being run, the stage will
		//increment and the event will be rerrun with the new stage.
		if(victory){
			Event.events[this.EventId].setFightwon(true);
		}
		else if(bp.fightlost()){
			statemanager.states.pop();
		}
		if(Event.events[this.EventId].getstage()!=Event.events[this.EventId].getfinalstage()){
			Event.events[this.EventId].setstage(Event.events[this.EventId].getstage()+1);
			Event.events[this.EventId].run();
		}
	}

	@Override
	public void init() {
		
	}
	

}
