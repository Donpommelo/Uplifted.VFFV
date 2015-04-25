package dev.zt.UpliftedVFFV.events;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.concurrent.TimeUnit;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.entities.creatures.Player;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.states.ChoiceBranchState;
import dev.zt.UpliftedVFFV.states.DialogState;
import dev.zt.UpliftedVFFV.states.GameState;
import dev.zt.UpliftedVFFV.states.MenuState;
import dev.zt.UpliftedVFFV.states.StateManager;
import dev.zt.UpliftedVFFV.world.EventManager;
import dev.zt.UpliftedVFFV.world.World;


//This manages all events. it can be compared to the Tile class. 
//instead of taking an id and a Tilesorter number, events contain 3 variables, an x-y location and an id number
//besides that, the process of loading in all the events is just like the Tile class.
public class Event{

	int id;
	static World world;
	static EventManager eventmanager;
	static StateManager statemanager;
	static Game game;
	static GameState gamestate;
	float x;
	float y;
	public static Event[] events = new Event[256];
	public static Event event0 = new Event0(0,0,0);
	public static Event event1 = new Event1(3,2,1);
	public static Event event2 = new Event2(3,7,2);
	public static Event event3 = new Event3(3,3,3);
	public static Event event4 = new Event4(7,11,4);
	public static Event event5 = new Event5(0,4,5);
	public static Event event6 = new Event6(14,4,6);
	public static Event event7 = new Event7(13,21,7);
	public static Event event8 = new Event8(0,23,8);
	public static Event event9 = new Event9(0,7,9);
	public static Event event10 = new Event10(2,5,10);
	public static Event event11 = new Event11(0,15,11);
	public static Event event12 = new Event12(5,4,12);
	public static Event event13 = new Event13(2,7,13);
	public static Event event14 = new Event14(0,8,14);
	public static Event event15 = new Event15(6,8,15);
	public static Event event16 = new Event16(19 ,4,16);
	public static Event event17 = new Event17(3 ,1,17);
	public static Event event18 = new Event18(3 ,15,18);
	public static Event event19 = new Event19(3 ,1,19);
	public static Event event20 = new Event20(3, 14,20);
	public static Event event21 = new Event21(38, 42,21);
	public static Event event22 = new Event22(0, 8,22);
	public static Event event23 = new Event23(0, 17,23);
	public static Event event24 = new Event24(6, 17,24);
	public static Event event25 = new Event25(10, 7,25);
	public static Event event26 = new Event26(10, 30,26);
	public static Event event27 = new Event27(20, 7,27);
	public static Event event28 = new Event28(18, 0,28);
	public static Event event29 = new Event29(26, 0,29);
	public static Event event30 = new Event30(6, 10,30);
	public static Event event31 = new Event31(23, 10,31);
	
	public static Event eventpenpal = new EventPenPal(2,4,40);
	public static Event eventreceptionist = new EventReceptionist(7,4,41);
	public static Event eventreceptionistdesk = new EventReceptionistDesk(7,5,42);
	
	public static Event eventemployee1 = new EventEmployee1(3,7,43);
	public static Event eventemployee2 = new EventEmployee2(11,3,44);
	public static Event eventelevatorpanel = new EventElevatorPanel(4,3,45);
	public static Event eventemployee3 = new EventEmployee3(8,19,46);
	public static Event eventemployee4 = new EventEmployee4(4,26,47);
	public static Event eventemployee5 = new EventEmployee5(3,30,48);
	public static Event eventemployee6 = new EventEmployee6(6,9,49);
	
	public static Event eventemployee10 = new EventEmployee10(12,12,53);
	public static Event eventemployee11 = new EventEmployee11(12,8,54);
	public static Event eventemployee12 = new EventEmployee12(12,4,55);
	public static Event eventemployee13 = new EventEmployee13(16,4,56);
	public static Event eventemployee14 = new EventEmployee14(16,8,57);
	public static Event eventemployee15 = new EventEmployee15(8,12,58);
	public static Event eventemployee16 = new EventEmployee16(8,8,59);
	public static Event eventemployee17 = new EventEmployee17(8,8,60);
	public static Event eventemployee18 = new EventEmployee18(8,8,61);
	public static Event eventemployee19 = new EventEmployee19(8,4,62);
	public static Event eventemployee20 = new EventEmployee20(8,21,63);
	public static Event eventemployee21 = new EventEmployee21(12,21,64);
	
	public static Event fitemeh = new EventTestBattle(0,0,100);
	
	public Event(Game g, StateManager sm,GameState gamestate) {
		this.game=g;
		this.statemanager=sm;
		this.gamestate=gamestate;
//		this.id=idnum;
//		this.x=x;
//		this.y=y;

	}
	

	
	public static final int TILEWIDTH = 32, TILEHEIGHT = 32;
	BufferedImage tex;
	

	public Event(BufferedImage texture, int idnum, float x, float y) {
		this.tex = texture;
		this.id = idnum;
		this.x=x;
		this.y=y;
		events[id] = this;
		
	}
	public void tick() {
		
		
	}

	public void render(Graphics g, int x, int y) {
		
		g.drawImage(tex,x, y, TILEWIDTH, TILEHEIGHT, null);
	}
	

	public float getX() {
		return x;
	}
	public void setX(float x) {
		this.x = x;
	}
	public float getY() {
		return y;
	}
	public void setY(float y) {
		this.y = y;
	}
	
	public BufferedImage getTex() {
		return tex;
	}
	public void setTex(BufferedImage tex) {
		this.tex = tex;
	}
	public boolean isSolid(){
		return false;
	}
	
	//Below this is all the stuff that events can call.
	//This includes transporting, opening up dialog, combat and literally everything else.
	
	//If an events running calls this, the player is transported to the given x-y location of the world corresponding to the path name
	public static void transport(String path, int x, int y,String name){
		world = new World(game, path,name);
		eventmanager = new EventManager(game, path);
		GameState.setWorld(world);
		GameState.setEventmanager(eventmanager);
		Player.setX(x*32);
		Player.setY(y*32);
		
	}
	
	//when ran, this opens combat with a given troop corresponding with the enemyId
	public static void fite(int enemyId){
		StateManager.states.push(new BattleState(game,statemanager,gamestate.partymanager.party,enemyId,gamestate));
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	//when ran, opens a DialogState that goes through firstline-lastline in the dialog text file.
	//consider adding multiple text files later that will need to be specified
	public static void Dialog(int firstline, int lastline,int eventId){
		StateManager.states.push(new DialogState(game,statemanager,firstline,lastline,eventId));
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	
	//opens up a choice branch state with the list of string choices.
	public static void ChoiceBranch(int EventId,String[] choices){
		StateManager.states.push(new ChoiceBranchState(game,statemanager,EventId,choices));
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();			
		}
		

	}
	
	public void recruit(Schmuck recruit){
		if(gamestate.partymanager.party.size()<5){
		gamestate.partymanager.party.add(recruit);
		}
	}
	


	public void unrecruit(Schmuck unrecruit){
		if(gamestate.partymanager.party.contains(unrecruit)){
			gamestate.partymanager.party.remove(unrecruit);
		}
	}
	
	public void loot(Item i,int num){
		if(gamestate.inventorymanager.backpack.containsKey(i)){
			int temp = gamestate.inventorymanager.backpack.get(i);
			gamestate.inventorymanager.backpack.put(i, temp += num);
		}
		else{
			gamestate.inventorymanager.backpack.put(i, num);
		}
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	//overrode by individual events. This is called whenever the event is interacted with
	public void run() {
		
	}
	
	//overrode by individual events. This is called when a choicebranch is called and a choice is made.
	//The choice will be made and, if thevent is not done running, will increment the event stage
	//This was sorta poorly explained. look at EventEmployee20 for an example
	public void ChoiceMade(int i) {
		
		
	}
	
	public int getfinalstage() {
		return 1;
		
	}
	
	public int getstage() {
		return 1;		
	}
	
	public void setstage(int i) {
				
	}


}
