package dev.zt.UpliftedVFFV.events;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.concurrent.TimeUnit;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.entities.creatures.Player;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.ChoiceBranchState;
import dev.zt.UpliftedVFFV.states.DialogState;
import dev.zt.UpliftedVFFV.states.GameState;
import dev.zt.UpliftedVFFV.states.MenuState;
import dev.zt.UpliftedVFFV.states.StateManager;
import dev.zt.UpliftedVFFV.world.EventManager;
import dev.zt.UpliftedVFFV.world.World;

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
	public static Event event11 = new Event11(5,21,11);
	public static Event event12 = new Event12(5,4,12);
	public static Event event13 = new Event13(2,7,13);
	public static Event event14 = new Event14(0,8,14);
	
	
	public static Event eventpenpal = new EventPenPal(2,4,21);
	public static Event eventreceptionist = new EventReceptionist(7,4,22);
	public static Event eventreceptionistdesk = new EventReceptionistDesk(7,5,23);
	
	public static Event eventemployee1 = new EventEmployee1(3,7,24);
	public static Event eventemployee2 = new EventEmployee2(11,3,25);
	public static Event eventelevatorpanel = new EventElevatorPanel(4,3,26);
	public static Event eventemployee3 = new EventEmployee3(8,19,27);
	public static Event eventemployee4 = new EventEmployee4(4,26,28);
	
	
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
	
	public static void transport(String path, int x, int y,String name){
		world = new World(game, path,name);
		eventmanager = new EventManager(game, path);
		GameState.setWorld(world);
		GameState.setEventmanager(eventmanager);
		Player.setX(x*32);
		Player.setY(y*32);
		
	}
	
	public static void Dialog(int firstline, int lastline){
		
		StateManager.states.push(new DialogState(game,statemanager,firstline,lastline));
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	
	public static void ChoiceBranch(int EventId,String[] choices){
		
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();			
		}
		StateManager.states.push(new ChoiceBranchState(game,statemanager,EventId,choices));

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
	
	public void run() {
		
	}
	public void ChoiceMade(int i) {
		
		
	}


}
