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

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.Battle.BattleMenu;
import dev.zt.UpliftedVFFV.Battle.BattleProcessor;
import dev.zt.UpliftedVFFV.Battle.BattleSprites;
import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.events.Event;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.gfx.ImageLoader;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.party.TroopManager;
import dev.zt.UpliftedVFFV.utils.Utils;


public class BattleState extends State {
	
	private BufferedImage floor, wall;
	public int currentlySelected;
	public int currentlyTargeted;
	public int actionSelected;
	public int EventId;
	public Boolean playerSelected=false;
	public Boolean moveSelected=false;
	public Boolean runnable;
	public GameState gs;
	public BattleMenu bm;
	public BattleSprites bs;
	public TroopManager tm;
	public BattleProcessor bp;
	public ArrayList<Schmuck>allies=new ArrayList<Schmuck>();
	public ArrayList<Schmuck> enemy=new ArrayList<Schmuck>();
	public ArrayList<Schmuck> all=new ArrayList<Schmuck>();
	public BattleState(Game game, StateManager sm, ArrayList<Schmuck>party,int troopId, int eventId,boolean runnable,GameState gs){
		super(game,sm);
		this.gs=gs;
		this.EventId = eventId;
		this.runnable = runnable;
		tm= new TroopManager(game);
//		bm = new BattleMenu(game,sm,party,tm.Troop(troopId),this);
		bp = new BattleProcessor(game,sm,party,tm.Troop(troopId),gs,this);
		bs = new BattleSprites(game,sm,party,tm.Troop(troopId),this);
		this.allies = party;
		this.enemy = tm.Troop(troopId);
		floor = ImageLoader.loadImage("/Backgrounds/OfficeFloor.png");
		wall = ImageLoader.loadImage("/Backgrounds/OfficeWall.png");

//		currentlySelected=0;
//		actionSelected=0;

	}

	public void tick() {
		bs.tick();
		bp.tick();	
//		bm.tick();

	}
			

	public void render(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 640, 416);
		g.drawImage(floor, 0, 0,null);
		g.drawImage(wall, 0, 0, null);
		
		bs.render(g);
		bp.render(g);
//		bm.render(g);
	

		
	}
	
	public void end(boolean victory){
		statemanager.states.pop();
		
		//This is used for multistage event processing. If there are multiple stages in the event being run, the stage will
		//increment and the event will be rerrun with the new stage.
		if(victory){
			Event.events[this.EventId].setFightwon(true);
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
