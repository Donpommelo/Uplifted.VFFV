package dev.zt.UpliftedVFFV.states;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.Battle.BattleBackground;
import dev.zt.UpliftedVFFV.Battle.BattleMenu;
import dev.zt.UpliftedVFFV.Battle.BattleProcessor;
import dev.zt.UpliftedVFFV.Battle.BattleSprites;
import dev.zt.UpliftedVFFV.Battle.BattleUI;
import dev.zt.UpliftedVFFV.gfx.ImageLoader;
import dev.zt.UpliftedVFFV.gfx.SpriteSheet;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.party.TroopManager;
import dev.zt.UpliftedVFFV.party.troops.Troop;


public class BattleState extends State {
	
	private static final long serialVersionUID = 1L;
	
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
	public BattleUI bui;
	public ArrayList<Schmuck>allies=new ArrayList<Schmuck>();
	public ArrayList<Schmuck> enemy=new ArrayList<Schmuck>();
	public ArrayList<Schmuck> all=new ArrayList<Schmuck>();
	public Troop t;
	public int bonusML;
	public BattleState(Game game, StateManager sm, ArrayList<Schmuck>party,int troopId, int eventId,boolean runnable, boolean music,GameState gs, int ML){
		super(game,sm);
//		game.getAudiomanager().playMusic(3);
		this.gs=gs;
		this.EventId = eventId;
		this.runnable = runnable;
		this.musicReplace = music;
		tm= new TroopManager(game);
//		bm = new BattleMenu(game,sm,party,tm.Troop(troopId),this);
		this.allies = party;
		this.bonusML = ML;
		t = Troop.troops[troopId];
		this.enemy = tm.Troop(troopId,bonusML);
		bp = new BattleProcessor(game,sm,party,enemy,t,gs,this);
		bs = new BattleSprites(game,sm,party,enemy,this);
		bb = new BattleBackground(game,sm,this);
		bui = new BattleUI(game,sm,party,enemy,this);
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
				StateManager.getStates().pop();
				StateManager.getStates().peek().render(g);
				StateManager.getStates().push(this);
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
				bui.render(g);
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
				bui.render(g);
				introScene = false;
			}
			
		}
		else{
//			g.drawImage(floor, 0, 0,null);
//			g.drawImage(wall, 0, -32, null);	
			bb.render(g);
			bs.render(g);
			bp.render(g);
			bui.render(g);
//			bm.render(g);
		}

		
	}
	
	public void end(boolean victory){
		System.out.println(StateManager.getStates());
		StateManager.getStates().pop();
		game.getAudiomanager().playMusic(2, true);
		//This is used for multistage event processing. If there are multiple stages in the event being run, the stage will
		//increment and the event will be rerrun with the new stage.
		if(victory){
			gs.getEvents()[this.EventId].setFightwon(true);
		}
		else if(bp.fightlost()){
			StateManager.getStates().pop();
		}
		if(gs.getEvents()[this.EventId].getstage()!=gs.getEvents()[this.EventId].getfinalstage()){
			gs.getEvents()[this.EventId].setstage(gs.getEvents()[this.EventId].getstage()+1);
			gs.getEvents()[this.EventId].run();
		}
	}

	@Override
	public void init() {
		
	}
	

}
