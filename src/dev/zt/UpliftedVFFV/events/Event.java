package dev.zt.UpliftedVFFV.events;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.TreeMap;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.Decorations.DecorManager;
import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.entities.creatures.Creature;
import dev.zt.UpliftedVFFV.events.Floor3Offices.*;
import dev.zt.UpliftedVFFV.events.Floor3Offices.SouthWingOffices.*;
import dev.zt.UpliftedVFFV.events.ElevatorsandBackroom.*;
import dev.zt.UpliftedVFFV.events.EventsCommon.*;
import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.*;
import dev.zt.UpliftedVFFV.world.EventManager;
import dev.zt.UpliftedVFFV.world.WorldManager;


//This manages all events. it can be compared to the Tile class. 
//instead of taking an id and a Tilesorter number, events contain 3 variables, an x-y location and an id number
//besides that, the process of loading in all the events is just like the Tile class.

//Events are anything that can be interacted with. Each event occupies one square in the map grid. Only one event can exist in a square
//at once. 

public class Event{

	int id;
	static WorldManager worldmanager;
	static EventManager eventmanager;
	static StateManager statemanager;
	static DecorManager decormanager;
	protected static Game game;
	protected static GameState gamestate;
	protected float x;
	protected float y;
	public static Event[] events = new Event[256];
	public static Event event0 = new Event0(0,0,0);
	public static Event event1 = new WarpBackroomtoElevator(10,5,1);
	public static Event event2 = new WarpSElevatortoBackroom(5,10,2);
	public static Event event3 = new WarpSElevatortoLobby(5,6,3);
	public static Event event4 = new WarpLobbytoSElevator(9,15,4);
	public static Event event5 = new WarpLobbytoSouthOffice1(2,8,5);
	public static Event event6 = new WarpLobbytoSouthOfficeHall(16,8,6);
	public static Event event7 = new WarpSouthOfficetoLobby(25,8,7);
	public static Event event8 = new WarpSouthOfficetoSouthCubicles(3,27,8);
	public static Event event9 = new WarpSouthOfficestoSouthWestHall(3,10,9);
	public static Event event10 = new WarpSouthOfficetoBoardroom(10,15,10);
	public static Event event11 = new WarpSouthOfficestoJCloset(13,15,11);
	public static Event event12 = new WarpSouthCubiclestoSouthHallSmall(3,21,12);
	public static Event event13 = new WarpSouthCubiclestoSouthOffices(23,21,13);
	public static Event event14 = new WarpSouthWestHalltoSouthOffices(19,9,14);
	public static Event event15 = new WarpSouthWestHalltoWestOffices(3,9,15);
	public static Event event16 = new WarpBoardroom1toSouthOffices(5,19,16);
	public static Event event17 = new WarpJClosettoSouthOffices(5,19,17);
	public static Event event18 = new WarpSouthHallSmalltoSouthCubicles(11,24,18);
	public static Event event19 = new WarpSouthHallSmalltoGameRoom(13,17,19);
	public static Event event20 = new WarpSouthHallSmalltoWorkRoom1(3,24,20);
	public static Event event21 = new WarpSouthHallSmalltoWorkRoom2(3,17,21);
	//Event 22: South Small Hall to Bath house
	public static Event event23 = new WarpSouthHallSmalltoAquaHall(13,7,23);
	
	public static Event event24 = new WarpGameRoomtoSouthHallSmall(3,14,24);
	public static Event event25 = new WarpWorkRoom1toSouthHallSmall(13,13,25);
	public static Event event26 = new WarpWorkRoom2toSouthHallSmall(13,13,26);
	
	//Event 27: Bath House to South Small Hall
	public static Event event28 = new WarpAquaHalltoSouthHallShort(15,26,28);
	public static Event event29 = new WarpAquaHalltoSouthHallLong(29,15,29);

	
	public static Event event30 = new WarpSouthHallLongtoAquaHall(7,21,30);
	public static Event event31 = new WarpSouthHallLongtoStorageRoom(3,12,31);
	public static Event event32 = new WarpSouthHallLongtoBathroomMens(13, 25,32);
	public static Event event33 = new WarpSouthHallLongtoBathroomWomens(23,25,33);
	public static Event event34 = new WarpSouthHallLongtoJCloset(26,10,34);
	public static Event event35 = new WarpSouthHallLongtoMailroom(30,11,35);
	public static Event event36 = new WarpSouthHallLongtoLobby(26,37,36);
	public static Event event37 = new WarpSouthHallLongtoEastFacade(34,37,37);
	public static Event event38 = new WarpStorageRoomtoSouthHallLong(14,11,38);
	public static Event event39 = new WarpBathroomMenstoSouthHallLong(14,9,39);
	public static Event event40 = new WarpBathroomWomenstoSouthHallLong(3,9,40);
	public static Event event41 = new WarpJClosettoSouthHallLong(5,11,41);
	public static Event event42 = new WarpMailroomtoSouthHallLong(3,12,42);	
	public static Event eventBed = new EventBackroomBed(7,8,43);
	public static Event eventDesk = new EventBackroomDesk(5,7,44);
	public static Event eventCalandar = new EventBackroomCalendar(12,9,45);
	public static Event eventAward = new EventBackroomAward(13,9,46);
	public static Event eventDresser = new EventBackroomDresser(4,10,47);
	public static Event eventHatrack = new EventBackroomHatrack(8,10,48);
	public static Event eventTrashcan = new EventBackroomTrashcan(4,7,49);
	public static Event eventTv = new EventBackroomTv(16,7,50);
	public static Event eventstory3 = new EventStory3(6,7,51);

	public static Event eventpenpal = new EventPenPal(5,7,52);
	public static Event eventelevatorpanel = new EventElevatorPanel(6,6,53);
	public static Event eventemployeeIntro = new EventEmployeeIntro(4,9,54);
	//Event 55: Elevator Conversations?

	public static Event eventreceptionist = new EmpReceptionist(9,9,56);
	public static Event eventreceptionistdesk = new EventReceptionistDesk(9,10,57);
	public static Event eventempCarto = new EmpCartographer(5,12,58);
	public static Event eventempMover = new EmpMover(13,7,59);
	public static Event eventMoverSofa1 = new EventMoverSofa1(12,3,60);
	public static Event eventMoverSofa2 = new EventMoverSofa2(12,4,61);
	public static Event eventstory1 = new EventStory1(9,13,62);

	//Event 63: Tutorial Fight
	
	public static Event empJack = new EmpJack1(20,16,64);
	public static Event empEmily = new EmpEmily1(16,12,65);
	public static Event empJerome = new EmpJerome1(20,30,66);
	public static Event empAndre = new EmpAndretheTall(14,21,67);
	public static Event empHelpful = new EmpHelpful(6,10,68);
	public static Event empVenda = new EmpVenda(8,25,69);
	public static Event eventVending1 = new EventVending1(0,0,70);
	//Event 71: 2nd Vending Machine?
	public static Event empLocksley = new EmpLocksley(5,8,72);
	public static Event empRussell = new EmpRussell(6,16,73);
	public static Event empAnderson = new EmpAnderson(8,16,74);
	public static Event empBrown = new EmpBrown(5,15,75);
	public static Event empGladys = new EmpGladys(5,13,76);
	public static Event empTaylor = new EmpTaylor(5,11,77);
	public static Event empIvan = new EmpIvan(5,7,78);
	public static Event empSleepy = new EmpSleepy(11,15,79);
	public static Event empLin = new EmpLin(6,8,80);
	public static Event empLance = new EmpLance(10,16,81);

	public static Event empAccountant = new EmpAccountant(14,18,82);
	public static Event empBlottley= new EmpBlottley(14,14,83);
	public static Event empChester = new EmpChester(14,10,84);
	public static Event empDonutGuy = new EmpDonutGuy(20,1,85);
	public static Event empHero = new EmpHero(20,10,86);
	public static Event empNepo = new EmpNepotist(12,18,87);
	public static Event empPlum = new EmpPlum(12,14,88);
	public static Event empQuiddity= new EmpQuiddity(12,10,89);
	public static Event empSaneone = new EmpSaneone(6,14,90);
	public static Event empShivers = new EmpShivers(6,10,91);
	public static Event empVane = new EmpVane(20,27,92);
	//93: I feel like adding another employee
	public static Event empWade = new EmpWade(11,27,94);
	public static Event empCooley = new EmpCooley(6,18,95);

	public static Event empNorm = new EmpNorm(10,15,96);
	public static Event empPaprika = new EmpPaprika(5,10,97);	
	public static Event eventfridge = new EventBackroomFridge(14,7,98);	
	public static Event eventemployeeJorgeInvisible = new EventJorgeInvisible(0,0,99);
	public static Event eventemployeeJorge = new EventJorge(8,8,100);
	public static Event eventInvisWall = new EventInvisWall(0,0,101);
	public static Event empJanitor1 = new EventJanitor1(5,8,102);

	public static Event empGuilliot = new EmpGuilliot(6,10,103);
	public static Event empHobbes = new EmpHobbes(7,12,104);
	public static Event empLateNeet = new EmpLateNeet(12,14,105);
	public static Event empSalty = new EmpSalty(8,10,106);
	public static Event empWalker = new EmpWalker(5,10,107);
	public static Event empZ = new EmpZ(7,10,108);

	public static Event empVitor = new EmpVitor(11,16,109);
	public static Event empFlammable = new EmpFlammable(15,9,110);
	public static Event empGymnist = new EmpGymnist(17,28,111);
	
	public static Event empDowner = new EmpDowner(34,30,112);
	public static Event empFearful = new EmpFearful(34,27,113);
	public static Event empHavingaBadDay = new EmpHavinaBadDay(34,24,114);
	public static Event empJade = new EmpJade(34,21,115);
	public static Event empNostalgic= new EmpNostalgic(30,21,116);
	public static Event empTuck = new EmpTuck(30,24,117);
	public static Event empWeAllKnowOne = new EmpWeAllKnowOne(30,27,118);
	public static Event empBallpitGuy= new EmpBallpitGuy(9,11,119);

	


/*		
		
	public static Event eventWaterCoolerInvisible = new EventWaterCoolerInvisible(0,0,98);
	
	public static Event fitemeh = new EventTestBattle(0,0,100);
			
	public static Event safe1 = new EventSafe1(10,30,117);
	public static Event safe2 = new EventSafe2(16,13,118);
	public static Event safe3 = new EventSafe3(6,3,119);
	public static Event safe4 = new EventSafe4(5,3,120);
	public static Event safe5 = new EventSafe5(3,3,121);
	public static Event safe6 = new EventSafe6(0,0,122);
	
	public static Event eventstory2 = new EventStory2(40,3,138);
*/
	
	
	public static final int TILEWIDTH = 32, TILEHEIGHT = 32;
	protected BufferedImage tex;
	public Creature test;
	boolean open;
	boolean drawn;
	boolean fightwon;
	boolean selfswitch1,selfswitch2,selfswitch3,selfswitch4;
	int stage;						
	int finalstage;
	
	public Event(BufferedImage texture, int idnum, float x, float y) {
		if(texture.getHeight() == 128 && texture.getWidth() == 96){ // maybe replace later with "moveable" boolean?
			this.test = new Creature(game, x ,y, 32, 32, texture, idnum);		
		}
		else{
			this.tex = texture;
		}
		this.id = idnum;
		this.x = x;
		this.y = y;
		this.selfswitch1 = false;
		this.selfswitch2 = false;
		this.selfswitch3 = false;
		this.selfswitch4 = false;
		events[id] = this;
	}
	
	public Event(BufferedImage texture, int idnum, float x, float y, int stageNum) {
		if(texture.getHeight() == 128 && texture.getWidth() == 96){ // maybe replace later with "moveable" boolean?
			this.test = new Creature(game, x ,y, 32, 32, texture, idnum);		
		}
		else{
			this.tex = texture;
		}
		this.id = idnum;
		this.x = x;
		this.y = y;
		this.selfswitch1 = false;
		this.selfswitch2 = false;
		this.selfswitch3 = false;
		this.selfswitch4 = false;
		events[id] = this;
		this.stage = 0;
		this.finalstage = stageNum;
	}
	
	public Event(Game g, StateManager sm,GameState gs) {
		game=g;
		statemanager=sm;
		gamestate=gs;
	}
	
	//If the event is attached to a Creature object, tick the Creature and make it walk around.
	public void tick() {
		if(test!=null){
			test.tick();		
		}
		walkCycle();
	}
	
	public void render(Graphics g, int x, int y) {
		if(test==null){
			g.drawImage(tex,x, y, tex.getWidth(), tex.getHeight(), null);
		}
		//If the event is attached to a Creature object, render it and draw the image attached to it. Rendering creature does not
		//draw anything. It only changes test.imgShown to match the creature's walk cycle.
		if(test!=null){
			test.render(g);
			g.drawImage(test.imgShown, x, y, TILEWIDTH, TILEHEIGHT, null);			
		}
	}
	
	//Affects the x,y coordinate of the event. 
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
	
	//Tex is the image that the event is represented by.
	public BufferedImage getTex() {
		return tex;
	}
	
	public void setTex(BufferedImage tex) {
		this.tex = tex;
	}
	
	//test is a creature that may be tied to the event such as an npc. This is relevant for npcs that walk around like the player.
	public Creature getTest() {
		return test;
	}
	
	public void setTest(Creature test) {
		this.test = test;
	}
	
	//Returns whether the event can be walked through or not.
	public boolean isSolid(int direction){
		return false;
	}
	
	//Returns whether the event is visible and existent.
	public boolean drawn(){
		return true;
	}
	
	//Returns whether the event will be run when stepped on or not.
	public boolean runnable(){
		return true;
	}
	
	//Below this is all the stuff that events can call.
	//This includes transporting, opening up dialog, combat and literally everything else.
	
	//If an events running calls this, the player is transported to the given x-y location of the world corresponding to the path name
	public static void transport(String path, int x, int y,String name){
		worldmanager = new WorldManager(game, path,name);
		eventmanager = new EventManager(game, path);
		decormanager = new DecorManager(game, path);
		GameState.setWorld(worldmanager);
		GameState.setEventmanager(eventmanager);
		GameState.setDecormanager(decormanager);
		gamestate.getPlayer().setPlayerX(x*32);
		gamestate.getPlayer().setPlayerY(y*32);
		
	}
	
	//when ran, this opens combat with a given troop corresponding with the enemyId
	public static void fite(int enemyId, int eventId, boolean runnable, boolean music){
		game.getAudiomanager().playSound("/Audio/Elevator Sound Effect.wav", false);
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//change last int for bonus ML
		int bonusML = 0;
		for(Schmuck s : gamestate.partymanager.party){
			bonusML += s.getBonusML();
		}
		StateManager.states.push(new BattleState(game,statemanager,gamestate.partymanager.party,enemyId,eventId,runnable, music,gamestate,bonusML));
	}
	
	//when ran, opens a DialogState that goes through firstline-lastline in the dialog text file.
	//consider adding multiple text files later that will need to be specified
	public static void Dialog(int firstline, int lastline, int eventId){
		StateManager.states.push(new DialogState(game, statemanager, firstline, lastline, eventId));
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void Dialog(int firstline, int lastline, int eventId, boolean arrow){
		StateManager.states.push(new DialogState(game, statemanager, firstline, lastline, eventId, arrow));
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void Dialog(Dialog[] d, int dialoglength, int eventId, boolean arrow){
		StateManager.states.push(new DialogState(game, statemanager, d, dialoglength, eventId, arrow));
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	//Pushes a simple notification window.
	public static void Notification(String message, int eventId){
		StateManager.states.push(new NotificationState(game, statemanager, message, eventId));
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	//Simple cutscene state that goes through multiple pictures.
	public static void Cutscene(BufferedImage[] scenes,int eventId){
		StateManager.states.push(new CutsceneState(game,statemanager,scenes,eventId));
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	//Causes screen to shake for a duration
	public void screenShake(int shake){
		game.getGameCamera().screenShake(shake);
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
	
	//Choicebranch state, lets player make decision between a list of choices.
	public static void ChoiceBranch(int EventId, String[] choices, int width){
		StateManager.states.push(new ChoiceBranchState(game,statemanager,EventId,choices,width));
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();			
		}

	}
	
	//Special version of choicebranch state with special art.
	public static void ElevatorChoiceBranch(int EventId,String[] choices, int width){
		StateManager.states.push(new ElevatorChoiceBranchState(game,statemanager,EventId,choices));
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();			
		}
	}
	
	//State for exchanging letters with your Pen Pal
	public static void PenPalState(){
		StateManager.states.push(new PenPalLetterState(game,statemanager));
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();			
		}
	}
	
	//State that just exists for a certain time than stops.
	public static void Timer(int EventId,int time){
		StateManager.states.push(new TimerState(game,statemanager,EventId,time));
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();			
		}
	}
	
	//Shopping state with list of items and prices.
	public static void shop(int EventId,TreeMap<Item, Integer> choices, BufferedImage sk){
		StateManager.states.push(new ShoppingState(game,gamestate,statemanager,EventId,choices,sk));
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();			
		}
	}
	
	//Moves schmucks to and from your party.
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
	
	//Adds num items i to your inventory
	public void loot(Item i,int num){
		if(gamestate.inventorymanager.backpack.containsKey(i)){
			int temp = gamestate.inventorymanager.backpack.get(i);
			gamestate.inventorymanager.backpack.put(i, temp += num);
		}
		else{
			gamestate.inventorymanager.backpack.put(i, num);
		}
	}
	
	//Return how much of a given item you have.
	public int itemNumCheck(Item i){
		if(gamestate.inventorymanager.backpack.containsKey(i)){
			return gamestate.inventorymanager.backpack.get(i);
		}
		else{
			return 0;
		}
	}
	
	//Add/remove currency
	public void scriptChange(int i){
		gamestate.scriptChange(i);
	}
	
	//Look at or change any global variable or switch
	public void setVar(int i, int set){
		gamestate.setVar(i, set);
	}
	
	public int getVar(int i){
		return gamestate.getVar(i);
	}
	
	public void setSwitch(int i, boolean set){
		gamestate.setSwitch(i, set);
	}
	
	public boolean getSwitch(int i){
		return gamestate.getSwitch(i);
	}
	
	//checks id of event.
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	//is the event a door. probably not.
	public boolean isDoor(){
		return false;
	}
	
	//overrode by individual events. This is called whenever the event is interacted with
	public void run() {
		
	}
	
	//Used for events that have a creature attached. 
	//Overridden by events like the above where it contains walking patters of a given creature.
	public void walkCycle(){

	}
	
	//Used for animated events.
	//Will be overridden in these cases.
	public void animate(BufferedImage[] frames, int framenum){
		
	}
	
	//overrode by individual events. This is called when a choicebranch is called and a choice is made.
	//The choice will be made and, if the event is not done running, will increment the event stage
	//This was sorta poorly explained. look at EventEmployee20 for an example
	public void ChoiceMade(int i) {
		
		
	}
	
	//Returns game. not used as of now.
	public Game getGame(){
		return game;
	}
	
	//stage is used for multi-stage events that contain transitions between multiple different states.
	//Events that use this override these methods.
	public int getfinalstage() {
		return finalstage;
	}

	public int getstage() {
		return stage;
	}
	
	
	public void setstage(int st) {
		this.stage = st;
	}

	//drawn determines whether an event is drawn to the world map or not.
	public boolean isDrawn() {
		return drawn;
	}

	public void setDrawn(boolean drawn) {
		this.drawn = drawn;
	}
	
	//If the event is a door, the open boolean determines whether the door is open or closed.
	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}
	
	//If an event leads to a Battle State, fightwon determines whether the fight was won or not when the fight ends.
	public boolean isFightwon() {
		return fightwon;
	}

	public void setFightwon(boolean fightwon) {
		this.fightwon = fightwon;
	}
	
	//used to make events walk around. change the x,y coordinates of an event and play their walking animation
	//First, checks of the tile being walked into is solid or not, then whether the event would be walking into the Player
	//Then, it moves its event to the square designated and updates x-y coordinates.
	//Finally, if a creature is attached to the event, update its walk cycle in the given direction.
	public void moveUp(){
		if(!gamestate.getWorld().getTile((int)x,(int)(y-1)).isSolid() && !EventManager.getEvent((int)x,(int)(y-1)).isSolid(0)){
			if(gamestate.getPlayer().getPlayerX()<=(x-1)*32 || gamestate.getPlayer().getPlayerX()>=(x+1)*32 || gamestate.getPlayer().getPlayerY()>=(y)*32 || gamestate.getPlayer().getPlayerY()<=(y-2)*32){				
				EventManager.getEvents()[(int)(this.getX())][(int)(this.getY())]=0;
				EventManager.getEvents()[(int)(this.getX())][(int)(this.getY())-1]=this.getId();
				this.setX(this.getX());this.setY(this.getY()-1);
				if(test!=null){
					this.test.getMove(0);
				}
			}		
		}
	}

	public void moveDown(){
		if(!gamestate.getWorld().getTile((int)x,(int)(y+1)).isSolid() && !EventManager.getEvent((int)x,(int)(y+1)).isSolid(1)){
			if(gamestate.getPlayer().getPlayerX()<=(x-1)*32 || gamestate.getPlayer().getPlayerX()>=(x+1)*32 || gamestate.getPlayer().getPlayerY()>=(y+2)*32 || gamestate.getPlayer().getPlayerY()<=(y)*32){	
				EventManager.getEvents()[(int)(this.getX())][(int)(this.getY())]=0;
				EventManager.getEvents()[(int)(this.getX())][(int)(this.getY()+1)]=this.getId();
				this.setX(this.getX());this.setY(this.getY()+1);
				if(test!=null){
					this.test.getMove(1);
				}
			}
		}
		
	}

	public void moveLeft(){
		if(!gamestate.getWorld().getTile((int)x-1,(int)(y)).isSolid()&&!EventManager.getEvent((int)x-1,(int)(y)).isSolid(2)){
			if(gamestate.getPlayer().getPlayerX()<=(x-2)*32 || gamestate.getPlayer().getPlayerX()>=(x)*32 || gamestate.getPlayer().getPlayerY()>=(y+1)*32 || gamestate.getPlayer().getPlayerY()<=(y-1)*32){
				EventManager.getEvents()[(int)(this.getX())][(int)(this.getY())]=0;
				EventManager.getEvents()[(int)(this.getX()-1)][(int)(this.getY())]=this.getId();
				this.setX(this.getX()-1);this.setY(this.getY());
				if(test!=null){
					this.test.getMove(2);
				}
			}
		}
	}
	public void moveRight(){
		if(!gamestate.getWorld().getTile((int)x+1,(int)(y)).isSolid()&&!EventManager.getEvent((int)x+1,(int)(y)).isSolid(3)){
			if(gamestate.getPlayer().getPlayerX()<=(x)*32 || gamestate.getPlayer().getPlayerX()>=(x+2)*32 || gamestate.getPlayer().getPlayerY()>=(y+1)*32 || gamestate.getPlayer().getPlayerY()<=(y-1)*32){
				EventManager.getEvents()[(int)(this.getX())][(int)(this.getY())]=0;
				EventManager.getEvents()[(int)(this.getX()+1)][(int)(this.getY())]=this.getId();
				this.setX(this.getX()+1);this.setY(this.getY());
				if(test!=null){
					this.test.getMove(3);
				}
			}
		}
	}
	
	//Moves event to new coordinates
	public void moveTo(int x, int y){
		EventManager.getEvents()[x][y]=this.getId();
		this.setX(x);this.setY(y);
	}

	//These affect each events individual self switches.
	public boolean isSelfswitch1() {
		return selfswitch1;
	}

	public void setSelfswitch1(boolean selfswitch1) {
		this.selfswitch1 = selfswitch1;
	}

	public boolean isSelfswitch2() {
		return selfswitch2;
	}

	public void setSelfswitch2(boolean selfswitch2) {
		this.selfswitch2 = selfswitch2;
	}

	public boolean isSelfswitch3() {
		return selfswitch3;
	}

	public void setSelfswitch3(boolean selfswitch3) {
		this.selfswitch3 = selfswitch3;
	}

	public boolean isSelfswitch4() {
		return selfswitch4;
	}

	public void setSelfswitch4(boolean selfswitch4) {
		this.selfswitch4 = selfswitch4;
	}
	
	
}
