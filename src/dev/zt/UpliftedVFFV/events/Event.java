package dev.zt.UpliftedVFFV.events;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.TreeMap;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.entities.creatures.Creature;
import dev.zt.UpliftedVFFV.entities.creatures.Player;
import dev.zt.UpliftedVFFV.events.Floor3Offices.*;
import dev.zt.UpliftedVFFV.events.Floor3Offices.SouthWingOffices.*;
import dev.zt.UpliftedVFFV.events.Floor3Offices.EastWingOffices.*;
import dev.zt.UpliftedVFFV.events.ElevatorsandBackroom.Event1;
import dev.zt.UpliftedVFFV.events.ElevatorsandBackroom.Event2;
import dev.zt.UpliftedVFFV.events.ElevatorsandBackroom.Event3;
import dev.zt.UpliftedVFFV.events.ElevatorsandBackroom.EventBackroomBed1;
import dev.zt.UpliftedVFFV.events.ElevatorsandBackroom.EventBackroomBed2;
import dev.zt.UpliftedVFFV.events.ElevatorsandBackroom.EventBackroomCalendar;
import dev.zt.UpliftedVFFV.events.ElevatorsandBackroom.EventBackroomCalendarInvisible;
import dev.zt.UpliftedVFFV.events.ElevatorsandBackroom.EventBackroomDesk1;
import dev.zt.UpliftedVFFV.events.ElevatorsandBackroom.EventBackroomDesk2;
import dev.zt.UpliftedVFFV.events.ElevatorsandBackroom.EventBackroomTv;
import dev.zt.UpliftedVFFV.events.ElevatorsandBackroom.EventElevatorPanel;
import dev.zt.UpliftedVFFV.events.ElevatorsandBackroom.EventPenPal;
import dev.zt.UpliftedVFFV.events.ElevatorsandBackroom.EventStory3;
import dev.zt.UpliftedVFFV.events.ElevatorsandBackroom.EventTvInvisible;
import dev.zt.UpliftedVFFV.events.EventsCommon.EventClock;
import dev.zt.UpliftedVFFV.events.EventsCommon.EventElevatorFloor;
import dev.zt.UpliftedVFFV.events.EventsCommon.EventElevatorWallWave;
import dev.zt.UpliftedVFFV.events.EventsCommon.EventEmployeePlant;
import dev.zt.UpliftedVFFV.events.EventsCommon.EventFemaleSign;
import dev.zt.UpliftedVFFV.events.EventsCommon.EventFilingCabinet;
import dev.zt.UpliftedVFFV.events.EventsCommon.EventInvisWall;
import dev.zt.UpliftedVFFV.events.EventsCommon.EventMaleSign;
import dev.zt.UpliftedVFFV.events.EventsCommon.EventMirror;
import dev.zt.UpliftedVFFV.events.EventsCommon.EventSink;
import dev.zt.UpliftedVFFV.events.EventsCommon.EventSinkMirror;
import dev.zt.UpliftedVFFV.events.EventsCommon.EventSmudge1;
import dev.zt.UpliftedVFFV.events.EventsCommon.EventSmudge2;
import dev.zt.UpliftedVFFV.events.EventsCommon.EventSofa1;
import dev.zt.UpliftedVFFV.events.EventsCommon.EventSofa2;
import dev.zt.UpliftedVFFV.events.EventsCommon.EventTable0;
import dev.zt.UpliftedVFFV.events.EventsCommon.EventTable1;
import dev.zt.UpliftedVFFV.events.EventsCommon.EventTable2;
import dev.zt.UpliftedVFFV.events.EventsCommon.EventTable3;
import dev.zt.UpliftedVFFV.events.EventsCommon.EventTable4;
import dev.zt.UpliftedVFFV.events.EventsCommon.EventTable5;
import dev.zt.UpliftedVFFV.events.EventsCommon.EventTable6;
import dev.zt.UpliftedVFFV.events.EventsCommon.EventTable7;
import dev.zt.UpliftedVFFV.events.EventsCommon.EventTable8;
import dev.zt.UpliftedVFFV.events.EventsCommon.EventTable9;
import dev.zt.UpliftedVFFV.events.EventsCommon.EventToilet;
import dev.zt.UpliftedVFFV.events.EventsCommon.EventWorkDesk1;
import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.states.ChoiceBranchState;
import dev.zt.UpliftedVFFV.states.CutsceneState;
import dev.zt.UpliftedVFFV.states.DialogState;
import dev.zt.UpliftedVFFV.states.ElevatorChoiceBranchState;
import dev.zt.UpliftedVFFV.states.GameState;
import dev.zt.UpliftedVFFV.states.PenPalLetterState;
import dev.zt.UpliftedVFFV.states.ShoppingState;
import dev.zt.UpliftedVFFV.states.StateManager;
import dev.zt.UpliftedVFFV.states.TimerState;
import dev.zt.UpliftedVFFV.world.EventManager;
import dev.zt.UpliftedVFFV.world.World;
import dev.zt.UpliftedVFFV.world.WorldManager;


//This manages all events. it can be compared to the Tile class. 
//instead of taking an id and a Tilesorter number, events contain 3 variables, an x-y location and an id number
//besides that, the process of loading in all the events is just like the Tile class.
public class Event{

	int id;
	static World world;
	static EventManager eventmanager;
	static StateManager statemanager;
	protected static Game game;
	static GameState gamestate;
	static Player killme;
	protected float x;
	protected float y;
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
	public static Event event32 = new Event32(0, 4,32);
	public static Event event33 = new Event33(44, 3,33);
	public static Event event34 = new Event34(11, 6,34);
	public static Event event35 = new Event35(0, 6,35);
	public static Event event36 = new Event36(38, 56,36);
	public static Event event37 = new Event37(0, 4,37);
	public static Event event38 = new Event38(36, 0,38);
	public static Event event39 = new Event39(3, 8,39);
	
	public static Event eventpenpal = new EventPenPal(2,4,40);
	public static Event eventreceptionist = new EventReceptionist(7,4,41);
	public static Event eventreceptionistdesk = new EventReceptionistDesk(7,5,42);
	
	public static Event eventemployee1 = new EventEmployee1(3,7,43);
	public static Event eventemployee2 = new EventEmployee2(11,4,44);
	public static Event eventelevatorpanel = new EventElevatorPanel(4,3,45);
	public static Event eventemployee3 = new EventEmployee3(8,19,46);
	public static Event eventemployee4 = new EventEmployee4(4,26,47);
	public static Event eventemployee5 = new EventEmployee5(3,31,48);
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
	public static Event eventemployeeIntro = new EventEmployeeIntro(2,6,65);
	public static Event eventemployeeJorge = new EventJorge(2,6,66);
	public static Event eventemployeeJorgeInvisible = new EventJorgeInvisible(2,6,67);
	
	public static Event eventemployee22 = new EventEmployee22(3,7,68);
	public static Event eventemployee23 = new EventEmployee23(5,6,69);
	public static Event eventemployee24 = new EventEmployee24(1,6,70);
	public static Event eventemployee25 = new EventEmployee25(1,3,71);
	public static Event eventemployee26 = new EventEmployee26(7,3,72);
	public static Event eventemployee27 = new EventEmployee27(10,5,73);
	public static Event eventemployee28 = new EventEmployee28(3,6,74);
	public static Event eventemployee29 = new EventEmployee29(17,6,75);
	public static Event eventemployee30 = new EventEmployee30(4,3,76);
	public static Event eventemployee31 = new EventEmployee31(4,13,77);
	public static Event eventemployee32 = new EventEmployee32(4,13,78);
	
	public static Event eventemployeeBed1 = new EventBackroomBed1(9,8,79);
	public static Event eventemployeeBed2 = new EventBackroomBed2(9,9,80);
	public static Event eventemployeeDesk1 = new EventBackroomDesk1(2,10,81);
	public static Event eventemployeeDesk2 = new EventBackroomDesk2(3,10,82);
	public static Event eventemployeeTv = new EventBackroomTv(9,2,83);
	public static Event eventemployeeCalandar = new EventBackroomCalendar(3,10,84);
	public static Event eventemployeeCalandarInvisible = new EventBackroomCalendarInvisible(3,11,85);
	
	public static Event eventSmudge1= new EventSmudge1(0,0,86);
	public static Event eventSmudge2= new EventSmudge2(0,0,87);	
	public static Event eventElevatorWave= new EventElevatorWallWave(0,0,88);
	public static Event eventElevatorFloor = new EventElevatorFloor(2,4,89);
	
	public static Event eventClock = new EventClock(0,0,90);
	public static Event eventSofa1 = new EventSofa1(0,0,91);
	public static Event eventSofa2 = new EventSofa2(0,0,92);
	public static Event eventVending1 = new EventVending1(0,0,93);
	public static Event eventVending1Invisible = new EventVending1Invisible(0,0,94);
	public static Event eventWorkDesk1 = new EventWorkDesk1(0,0,95);
	public static Event eventTvInvis = new EventTvInvisible(9,3,96);
	public static Event eventWaterCooler = new EventWaterCooler(0,0,97);
	public static Event eventWaterCoolerInvisible = new EventWaterCoolerInvisible(0,0,98);
	
	public static Event fitemeh = new EventTestBattle(0,0,100);
	
	public static Event eventInvisWall = new EventInvisWall(0,0,101);
	public static Event eventemployeeJanitor1 = new EventJanitor1(3,5,102);
	public static Event eventMoverSofa1 = new EventMoverSofa1(12,3,103);
	public static Event eventMoverSofa2 = new EventMoverSofa2(12,4,104);
	public static Event eventMoverGag = new EventMoverGag(13,1,105);
	
	public static Event eventFilingCabinet = new EventFilingCabinet(0,0,106);
	public static Event table0 = new EventTable0(0,0,107);
	public static Event table1 = new EventTable1(0,0,108);
	public static Event table2 = new EventTable2(0,0,109);
	public static Event table3 = new EventTable3(0,0,110);
	public static Event table4 = new EventTable4(0,0,111);
	public static Event table5 = new EventTable5(0,0,112);
	public static Event table6 = new EventTable6(0,0,113);
	public static Event table7 = new EventTable7(0,0,114);
	public static Event table8 = new EventTable8(0,0,115);
	public static Event table9 = new EventTable9(0,0,116);
	
	public static Event safe1 = new EventSafe1(10,30,117);
	public static Event safe2 = new EventSafe2(16,13,118);
	public static Event safe3 = new EventSafe3(6,3,119);
	public static Event safe4 = new EventSafe4(5,3,120);
	public static Event safe5 = new EventSafe5(3,3,121);
	public static Event safe6 = new EventSafe6(0,0,122);
	
	public static Event eventemployee33 = new EventEmployee33(4,13,123);
	public static Event eventemployee34 = new EventEmployee34(4,13,124);
	public static Event eventemployee35 = new EventEmployee35(4,13,125);
	public static Event eventemployee36 = new EventEmployee36(4,6,126);

	public static Event event40 = new Event40(1,13,127);
	
	public static Event eventemployee37 = new EventEmployee37(7,7,128);
	public static Event eventemployee38 = new EventEmployee38(21,5,129);
	public static Event eventemployeePlant = new EventEmployeePlant(15,9,130);
	public static Event eventemployee39 = new EventEmployee39(21,5,131);
	public static Event eventemployee40 = new EventEmployee40(21,5,132);
	public static Event eventemployee41 = new EventEmployee41(21,5,133);
	public static Event eventemployee42 = new EventEmployee42(21,5,134);
	public static Event eventemployee43 = new EventEmployee43(21,5,135);
	public static Event eventemployee44 = new EventEmployee44(21,5,136);
	
	public static Event eventstory1 = new EventStory1(7,8,137);
	public static Event eventstory2 = new EventStory2(40,3,138);
	public static Event eventstory3 = new EventStory3(21,5,139);
	
	public static Event eventMirror = new EventMirror(21,5,140);
	public static Event eventToilet = new EventToilet(21,5,141);
	public static Event eventSink = new EventSink(21,5,142);
	public static Event eventSinkMirror = new EventSinkMirror(21,5,143);
	public static Event eventMaleSign = new EventMaleSign(17,2,144);
	public static Event eventFemaleSign = new EventFemaleSign(27,2,145);
	
	public static Event eventemployee45 = new EventEmployee45(21,5,146);
	public static Event eventemployee46 = new EventEmployee46(21,5,147);
	public static Event eventemployee47 = new EventEmployee47(21,5,148);
	public static Event eventemployee48 = new EventEmployee48(21,5,149);
	public static Event eventemployee49 = new EventEmployee49(21,5,150);
	public static Event eventemployee50 = new EventEmployee50(21,5,151);
	
	public static Event event41 = new Event41(0,4,160);
	public static Event event42 = new Event42(5,2,161);
	public static Event event43 = new Event43(9,2,162);
	public static Event event44 = new Event44(11,2,163);
	public static Event event45 = new Event45(2,9,164);
	public static Event event46 = new Event46(6,9,165);
	public static Event event47 = new Event47(11,29,166);
	public static Event event48 = new Event48(11,15,167);
	public static Event event49= new Event49(0,0,168);
	public static Event event50 = new Event50(6,18,169);
	public static Event event51 = new Event51(6,1,170);
	public static Event event52 = new Event52(3,11,171);
	public static Event event53 = new Event53(3,2,172);
	public static Event event54 = new Event54(6,2,173);
	//55,56,57 to other bus stops
	
	public static Event event59 = new Event59(3,9,178);
	public static Event event60 = new Event60(6,2,179);
	public static Event event61 = new Event61(7,15,180);
	public static Event event62 = new Event62(7,23,181);
	public static Event event63 = new Event63(7,31,182);
	public static Event event64 = new Event64(27,15,183);
	public static Event event65 = new Event65(27,23,184);
//64,65,66 to right east offices
	public static Event event67 = new Event67(0,42,186);
	public static Event event68 = new Event68(6,42,187);
	public static Event event69 = new Event69(20,5,188);
	public static Event event70 = new Event70(0,5,189);
	public static Event event71 = new Event71(7,20,190);
	public static Event event72 = new Event72(20,20,191);
	
	public static Event event73 = new Event73(14,4,192);
	public static Event event74 = new Event74(14,22,193);
	public static Event event75 = new Event75(5,8,194);
	public static Event event76 = new Event76(5,15,195);
	public static Event event77 = new Event77(4,12,196);
	public static Event event78 = new Event78(14,6,197);
	public static Event event79 = new Event79(4,4,198);
	
	public static Event event80 = new Event80(17,14,199);
	public static Event event81 = new Event81(4,6,200);
	public static Event event82 = new Event82(4,15,201);
	public static Event event83 = new Event83(4,20,202);
	public static Event event84 = new Event84(9,7,203);
	public static Event event85 = new Event85(4,3,204);
	public static Event event86 = new Event86(10,7,205);
	public static Event event87 = new Event87(0,7,206);
	
	public static Event event88 = new Event88(10,34,207);
	
	//events 89-96 east wing left lvl3 rooms
	public static Event event97 = new Event97(0,9,216);
	public static Event event98 = new Event98(7,12,217);
	public static Event event99 = new Event99(14,9,218);
	public static Event event100 = new Event100(4,3,219);
	public static Event event101 = new Event101(13,15,220);
	//event 102 :East Wing right room1 path
	
	public static Event event103 = new Event103(0,11,222);
	public static Event event104 = new Event104(4,24,223);
	public static Event event105 = new Event105(5,7,224);
	public static Event event106 = new Event106(11,17,225);
	public static Event event107 = new Event107(8,21,226);
	public static Event event108 = new Event108(5,17,227);
	public static Event event109 = new Event109(9,8,228);
	public static Event event110 = new Event110(3,8,229);
	public static Event event111 = new Event111(7,5,230);
	public static Event event112 = new Event112(22,5,231);

	
	
	
	public Event(Game g, StateManager sm,GameState gs) {
		game=g;
		statemanager=sm;
		gamestate=gs;
//		this.id=idnum;
//		this.x=x;
//		this.y=y;
		if(Event.game!=null){

		}

	}
	

	
	public static final int TILEWIDTH = 32, TILEHEIGHT = 32;
	protected BufferedImage tex;
	public Creature test;
	boolean open;
	boolean drawn;
	boolean fightwon;
	boolean selfswitch1,selfswitch2,selfswitch3,selfswitch4;

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
		events[id] = this;
		
	}
	
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
		if(test!=null){
			test.render(g);
			g.drawImage(test.imgShown, x, y, TILEWIDTH, TILEHEIGHT, null);			
		}
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
	
	public Creature getTest() {
		return test;
	}
	public void setTest(Creature test) {
		this.test = test;
	}
	
	public boolean isSolid(int direction){
		return false;
	}
	
	public boolean drawn(){
		return true;
	}
	
	public boolean runnable(){
		return true;
	}
	
	//Below this is all the stuff that events can call.
	//This includes transporting, opening up dialog, combat and literally everything else.
	
	//If an events running calls this, the player is transported to the given x-y location of the world corresponding to the path name
	public static void transport(String path, int x, int y,String name){
		world = new World(game, path,name);
		eventmanager = new EventManager(game, path);
		GameState.setWorld(world);
		GameState.setEventmanager(eventmanager);
		Player.setPlayerX(x*32);
		Player.setPlayerY(y*32);
		
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
	public static void Dialog(int firstline, int lastline,int eventId){
		StateManager.states.push(new DialogState(game,statemanager,firstline,lastline,eventId));
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	
	public static void Dialog(Dialog[] d, int dialoglength, int eventId){
		StateManager.states.push(new DialogState(game, statemanager, d, dialoglength ,eventId));
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	
	public static void Cutscene(BufferedImage[] scenes,int eventId){
		StateManager.states.push(new CutsceneState(game,statemanager,scenes,eventId));
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	
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
	
	public static void ChoiceBranch(int EventId,String[] choices, int width){
		StateManager.states.push(new ChoiceBranchState(game,statemanager,EventId,choices,width));
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();			
		}

	}
	
	public static void ElevatorChoiceBranch(int EventId,String[] choices, int width){
		StateManager.states.push(new ElevatorChoiceBranchState(game,statemanager,EventId,choices));
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();			
		}
	}
	
	public static void PenPalState(){
		StateManager.states.push(new PenPalLetterState(game,statemanager));
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();			
		}
	}
	
	public static void Timer(int EventId,int time){
		StateManager.states.push(new TimerState(game,statemanager,EventId,time));
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();			
		}

	}
	
	public static void shop(int EventId,TreeMap<Item, Integer> choices, BufferedImage sk){
		StateManager.states.push(new ShoppingState(game,gamestate,statemanager,EventId,choices,sk));
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
	
	public int itemNumCheck(Item i){
		if(gamestate.inventorymanager.backpack.containsKey(i)){
			return gamestate.inventorymanager.backpack.get(i);
		}
		else{
			return 0;
		}
	}
	
	public void scriptChange(int i){
		gamestate.scriptChange(i);
	}
	
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
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public boolean isDoor(){
		return false;
	}
	
	//overrode by individual events. This is called whenever the event is interacted with
	public void run() {
		
	}
	
	public void walkCycle(){

		
	}
	
	public void animate(BufferedImage[] frames, int framenum){
		
		
	}
	
	//overrode by individual events. This is called when a choicebranch is called and a choice is made.
	//The choice will be made and, if the event is not done running, will increment the event stage
	//This was sorta poorly explained. look at EventEmployee20 for an example
	public void ChoiceMade(int i) {
		
		
	}
	
	public int getfinalstage() {
		return 1;
		
	}
	
	public int getstage() {
		return 1;		
	}
	
	public Game getGame(){
		return game;
	}
	
	public void setstage(int i) {
				
	}
	
	
	public boolean isDrawn() {
		return drawn;
	}

	public void setDrawn(boolean drawn) {
		this.drawn = drawn;
	}
	
	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}
	
	
	
	public boolean isFightwon() {
		return fightwon;
	}

	public void setFightwon(boolean fightwon) {
		this.fightwon = fightwon;
	}
	
	

	//used to make events walk around. change the x,y coordinates of an event and play their walking animation
	public void moveUp(){
		if(!WorldManager.getWorld().getTile((int)x,(int)(y-1)).isSolid() && !EventManager.getEvent((int)x,(int)(y-1)).isSolid(0)){
			if(Player.getPlayerX()<=(x-1)*32 || Player.getPlayerX()>=(x+1)*32 || Player.getPlayerY()>=(y)*32 || Player.getPlayerY()<=(y-2)*32){				
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
		if(!WorldManager.getWorld().getTile((int)x,(int)(y+1)).isSolid() && !EventManager.getEvent((int)x,(int)(y+1)).isSolid(1)){
			if(Player.getPlayerX()<=(x-1)*32 || Player.getPlayerX()>=(x+1)*32 || Player.getPlayerY()>=(y+2)*32 || Player.getPlayerY()<=(y)*32){	
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
		if(!WorldManager.getWorld().getTile((int)x-1,(int)(y)).isSolid()&&!EventManager.getEvent((int)x-1,(int)(y)).isSolid(2)){
			if(Player.getPlayerX()<=(x-2)*32 || Player.getPlayerX()>=(x)*32 || Player.getPlayerY()>=(y+1)*32 || Player.getPlayerY()<=(y-1)*32){
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
		if(!WorldManager.getWorld().getTile((int)x+1,(int)(y)).isSolid()&&!EventManager.getEvent((int)x+1,(int)(y)).isSolid(3)){
			if(Player.getPlayerX()<=(x)*32 || Player.getPlayerX()>=(x+2)*32 || Player.getPlayerY()>=(y+1)*32 || Player.getPlayerY()<=(y-1)*32){
				EventManager.getEvents()[(int)(this.getX())][(int)(this.getY())]=0;
				EventManager.getEvents()[(int)(this.getX()+1)][(int)(this.getY())]=this.getId();
				this.setX(this.getX()+1);this.setY(this.getY());
				if(test!=null){
					this.test.getMove(3);
				}
			}
		}
	}
	
	public void moveTo(int x, int y){
		EventManager.getEvents()[x][y]=this.getId();
		this.setX(x);this.setY(y);
	}

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
