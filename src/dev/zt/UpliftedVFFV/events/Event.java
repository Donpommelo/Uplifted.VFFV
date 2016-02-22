package dev.zt.UpliftedVFFV.events;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.TreeMap;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.Decorations.DecorManager;
import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.entities.creatures.Creature;
import dev.zt.UpliftedVFFV.events.Floor1Reception.*;
import dev.zt.UpliftedVFFV.events.Floor2Bathhouse.*;
import dev.zt.UpliftedVFFV.events.Floor3Offices.EastWingOffices.*;
import dev.zt.UpliftedVFFV.events.Floor3Offices.SouthWingOffices.*;
import dev.zt.UpliftedVFFV.events.Floor3Offices.WestWingOffices.*;
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

public class Event implements Serializable{
	
	private static final long serialVersionUID = 8L;

	int id;
	static WorldManager worldmanager;
	static EventManager eventmanager;
	static StateManager statemanager;
	static DecorManager decormanager;
	protected static Game game;
	protected static GameState gamestate;
	protected float x;
	protected float y;
	public static Event[] events = new Event[1200];
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
	public static Event event10 = new WarpSouthOfficetoBoardroom(15,6,10);
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
	public static Event event28 = new WarpAquaHalltoSouthHallShort(15,25,28);
	public static Event event29 = new WarpAquaHalltoSouthHallLong(29,18,29);
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
	public static Event eventMonolith = new EventMonolith(9,11,51);
	public static Event eventpenpal = new EventPenPal(5,7,52);
	public static Event eventelevatorpanel = new EventElevatorPanel(6,6,53);
	public static Event eventemployeeIntro = new EventEmployeeIntro(4,9,54);
	//Event 55: Elevator Conversations?
	public static Event eventreceptionist = new EmpReceptionist(9,9,56);
	public static Event eventreceptionistdesk = new EventReceptionistDesk(9,10,57);
	public static Event eventempCarto = new EmpCartographer(5,11,58);
	public static Event eventempMover = new EmpMover(13,7,59);
	
	public static Event eventposter1 = new EventPoster1(9,16,60);
	public static Event eventposter2 = new EventPoster2(6,6,61);
	public static Event eventposter3 = new EventPoster3(0,0,62);
	public static Event infopanel = new EventAquariumInfoBoard(21,26,63);

	public static Event empJack = new EmpJack1(20,16,64);
	public static Event empEmily = new EmpEmily1(16,12,65);
	public static Event empJerome = new EmpJerome1(20,30,66);
	public static Event empAndre = new EmpAndretheTall(14,21,67);
	public static Event empHelpful = new EmpHelpful(6,10,68);
	public static Event empVenda = new EmpVenda(8,25,69);
	public static Event eventVending1 = new EventVending1(0,0,70);
	//Event 71: 2nd Vending Machine?
	public static Event empLocksley = new EmpLocksley(5,8,72);
	public static Event empRussell = new EmpRussell(7,14,73);
	public static Event empAnderson = new EmpAnderson(8,14,74);
	public static Event empBrown = new EmpBrown(6,13,75);
	public static Event empGladys = new EmpGladys(6,12,76);
	public static Event empTaylor = new EmpTaylor(6,11,77);
	public static Event empIvan = new EmpIvan(6,10,78);
	public static Event empSleepy = new EmpSleepy(10,13,79);
	public static Event empLin = new EmpLin(7,7,80);
	public static Event empLance = new EmpLance(9,14,81);

	public static Event empAccountant = new EmpAccountant(14,18,82);
	public static Event empBlottley= new EmpBlottley(14,14,83);
	public static Event empChester = new EmpChester(14,10,84);
	public static Event empDonutGuy = new EmpDonutGuy(19,14,85);
	public static Event empHero = new EmpHero(19,10,86);
	public static Event empNepo = new EmpNepotist(11,18,87);
	public static Event empPlum = new EmpPlum(11,14,88);
	public static Event empQuiddity= new EmpQuiddity(11,10,89);
	public static Event empSaneone = new EmpSaneone(6,14,90);
	public static Event empShivers = new EmpShivers(6,10,91);
	public static Event empVane = new EmpVane(19,27,92);
	public static Event eventwatercooler = new EventWaterCooler(7,18,93);
	public static Event empWade = new EmpWade(11,27,94);
	public static Event empCooley = new EmpCooley(6,18,95);

	public static Event empNorm = new EmpNorm(10,15,96);
	public static Event empPaprika = new EmpPaprika(4,13,97);	
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
	public static Event empFlammable = new EmpFlammable(21,7,110);
	public static Event empGymnist = new EmpGymnist(17,28,111);
	
	public static Event empDowner = new EmpDowner(34,30,112);
	public static Event empFearful = new EmpFearful(34,27,113);
	public static Event empHavingaBadDay = new EmpHavinaBadDay(34,24,114);
	public static Event empJade = new EmpJade(34,21,115);
	public static Event empNostalgic= new EmpNostalgic(30,21,116);
	public static Event empTuck = new EmpTuck(30,24,117);
	public static Event empWeAllKnowOne = new EmpWeAllKnowOne(30,27,118);
	public static Event empBallpitGuy= new EmpBallpitGuy(9,11,119);
	public static Event empMrClean = new EmpMrClean(11,7,120);
	public static Event empBothered= new EmpBothered(6,7,121);
	
	public static Event eventcommonsnooker = new EventSnookerTable(0,0,122);
	public static Event eventcommonssofa1 = new EventSofaDown(0,0,123);
	public static Event eventcommonsofa3 = new EventSofaUp(0,0,124);
	public static Event eventcommonplant = new EventTallPlant(0,0,125);
	public static Event eventcommonworkdesk1 = new EventWorkDesk1(0,0,126);
	public static Event eventcommonworkdesk2 = new EventWorkDesk2(0,0,127);
	public static Event eventcommoncuidado = new EventCuidado(0,0,128);

	public static Event eventcontrols = new EventControlIntro(7,9,129);

	
	public static Event safe1 = new EventSafe1(18,23,130);
	public static Event safe2 = new EventSafe2(11,8,131);
	public static Event safe3 = new EventSafe3(0,0,132);
	public static Event safe4 = new EventSafe4(8,7,133);
	public static Event sign1 = new EventSign1(7,10,134);
	public static Event sign2 = new EventSign2(29,32,135);
	
	public static Event event136 = new WarpLobbytoSouthOfficeHallway(3,8,136);
	public static Event event137 = new WarpLobbytoFacade(8,6,137);
	public static Event event138 = new WarpLobbytoActualEast(17,7,138);
	public static Event event139 = new WarpFacadetoLobby(5,13,139);
	public static Event event140 = new WarpActualEasttoLobby(3,12,140);
	public static Event event141 = new WarpActualEasttoEastBreakroom(12,10,141);
	public static Event event142 = new WarpActualEasttoNowhere(6,21,142);
	public static Event event143 = new WarpEastBreakroomtoActualEast(5,19,143);
	public static Event event144 = new WarpEastBreakroomtoBus(5,6,144);
	public static Event event145 = new WarpBustoWherever(5,11,145);
	public static Event event146 = new WarpBustoJCloset(5,5,146);
	public static Event event147 = new WarpBustoCentralLeft(8,5,147);
	public static Event event148 = new WarpBustoCentralRight(11,5,148);
	public static Event event149 = new WarpBustoRightBusStop(14,5,149);
	public static Event event150 = new WarpBustoWestPreDungeon(17,5,150);
	public static Event event151 = new WarpBustoRamp(17,10,151);
	public static Event event152 = new WarpJClosettoBus(5,11,152);
	public static Event event153 = new WarpCentraltoBusLeft1(5,13,153);
	public static Event event154 = new WarpCentraltoBusRight1(33,13,154);
	public static Event event155 = new WarpCentraltoRight1(29,21,155);
	public static Event event156 = new WarpCentraltoRight2(29,29,156);
	public static Event event157 = new WarpCentraltoRight3(29,37,157);
	public static Event event158 = new WarpCentraltoLeft1(9,21,158);
	public static Event event159 = new WarpCentraltoLeft2(9,29,159);
	public static Event event160 = new WarpCentraltoLeft3(9,37,160);
	public static Event event161 = new WarpCentraltoActualLeft2(5,45,161);
	public static Event event162 = new WarpCentraltoActualRight2(33,45,162);
	public static Event event163 = new WarpRightMain1toCentral1(3,8,163);
	public static Event event164 = new WarpRightMain1toCentral2(3,27,164);
	public static Event event165 = new WarpRightMain1toExtraRoom1(12,12,165);
	public static Event event166 = new WarpExtraRoom1toRightMain1(7,16,166);
	public static Event event167 = new WarpInnerRightoCentral(3,9,167);
	public static Event event168 = new WarpInnerRightoRightBasement(13,7,168);
	public static Event event169 = new WarpRightBasementtoInnerRight(23,16,169);
	public static Event event170 = new WarpRightBasementtoRightBusStop(3,8,170);
	public static Event event171 = new WarpRightBasementtoLeftSide(3,16,171);
	public static Event event172 = new WarpRightBasementtoShop(3,25,172);
	public static Event event173 = new WarpRightBusStoptoBasement(12,12,173);
	public static Event event174 = new WarpRightBusStoptoBus(7,16,174);
	public static Event event175 = new WarpBasementTransitiontoBasement(12,13,175);
	public static Event event176 = new WarpBasementTransitiontoStairsRoom(13,6,176);
	public static Event event177 = new WarpShoptoBasement(12,12,177);
	public static Event event178 = new WarpCarlocsHalltoCentral(24,9,178);
	public static Event event179 = new WarpCarlocsHalltoStairsRoom(5,13,179);
	public static Event event180 = new WarpCarlocsOfficetoBusRamp(17,16,180);
	public static Event event181 = new WarpCarlocsOfficetoCentral(24,17,181);
	public static Event event182 = new WarpCarlocsOfficetoEElevator(21,29,182);
	public static Event event183 = new WarpAtriatoCentral(30,17,183);
	public static Event event184 = new WarpAtriatoStairsRoom(6,12,184);
	public static Event event185 = new WarpAtriatoOuterFloor2(25,8,185);
	public static Event event186 = new WarpAtriatoRightFloor2(11,9,186);
	public static Event event187 = new WarpStairsRoomtoAtria(10,15,187);
	public static Event event188 = new WarpStairsRoomtoCarlocsHall(10,6,188);
	public static Event event189 = new WarpStairsRoomStairsDown(3,9,189);
	public static Event event190 = new WarpStairsRoomStairsUp(17,5,190);
	public static Event event191 = new WarpOuterFloor2toAtria(5,16,191);
	public static Event event192 = new WarpOuterFloor2toBalcony(20,22,192);
	public static Event event193 = new WarpBalconytoOuterFloor2(18,28,193);
	public static Event event194 = new WarpBalconytoStairsRoom(3,15,194);
	public static Event event195 = new WarpBalconytoWarehouse(23,19,195);
	public static Event event196 = new WarpWarehousetoBalcony(6,19,196);
	public static Event event197 = new WarpAtriaFloor2toAtriaFloor1(28,10,197);
	public static Event event198 = new WarpAtriaFloor2toBusRamp(6,20,198);
	public static Event event199 = new WarpAtriaFloor2toExtraRoom(20,6,199);
	public static Event event200 = new WarpExtraRoom2toAtriaFloor2(7,15,200);
	public static Event event201 = new WarpBusRamptoAtriaFloor2(25,16,201);
	public static Event event202 = new WarpBusRamptoCarlocsOffice(20,12,202);
	public static Event event203 = new WarpBusRamptoBus(31,38,203);
	public static Event event205 = new WarpBusRamptoWestOffices(3,15,205);

	public static Event eventmcdevice = new EventMindControlDevice(7,10,206);
	public static Event eventcarloclobby = new EventCarlocLobby(10,14,207);
	public static Event eventcarloclobbyinvis = new EventCarlocLobbyInvisible(0,0,208);
	public static Event eventcarlocoffice = new EventCarlocOffice(7,10,209);
	public static Event eventcarlocofficeinvis = new EventCarlocOfficeInvisible(0,0,210);
	public static Event eventinformantbus = new EventInformantOffices(18,9,211);
	public static Event eventinviswall1 = new EventInvis1Loop(0,0,212);
	public static Event eventinviswall2 = new EventInvis2Loop(0,0,213);
	public static Event eventinviswall1and2 = new EventInvis12Loop(0,0,214);

	public static Event event215 = new WarpEElevatortoLobby(3,15,215);
	public static Event event216 = new WarpEElevatortoBackroom(3,15,216);
	public static Event event217 = new WarpWarehousetoGiftshop(12,3,217);

	//220 employees begin here
	public static Event empRubella = new EmpRubella(4,8,220);
	public static Event empNeville = new EmpNeville(9,8,221);
	public static Event empSnivelly = new EmpSnivelly(8,13,222);
	public static Event empHabette = new EmpHabette(6,9,223);
	public static Event empNewt = new EmpNewt(34,21,225);
	public static Event empAbernathy = new EmpAbernathy(34,21,224);
	public static Event empCruikshank = new EmpCruikshank(34,21,226);
	public static Event empDeborah = new EmpDeborah(34,21,227);
	public static Event empFord = new EmpFord(34,21,228);
	public static Event empHaversham= new EmpHaversham(34,21,229);
	public static Event empIvy = new EmpIvy(34,21,230);
	public static Event empLacera = new EmpLacera(34,21,231);
	public static Event empMala = new EmpMala(34,21,232);
	public static Event empLucky = new EmpLucky(34,21,233);
	public static Event empNissa = new EmpNissa(34,21,234);
	public static Event empPrimrose = new EmpPrimrose(34,21,235);
	public static Event empSnyder = new EmpSnyder(34,21,236);
	public static Event empToussant = new EmpToussant(34,21,237);
	public static Event empDinesh = new EmpDinesh(34,21,238);
	public static Event empBilloby = new EmpBilloby(34,21,239);
	public static Event empBob = new EmpBob(34,21,240);
	public static Event empNestle = new EmpNestle(12,33,241);
	public static Event empParanoia = new EmpParanoia(8,12,242);
	public static Event empFlo = new EmpFlo(23,17,243);
	public static Event empUnderminer = new EmpUnderminer(7,10,244);
	public static Event empRory = new EmpRory(15,7,245);
	public static Event empDora = new EmpDora(8,14,246);
	public static Event empNonconformist = new EmpNonconformist(4,8,247);
	public static Event empOkey = new EmpOkey(14,9,248);
	public static Event empLil = new EmpLil(17,9,249);
	public static Event empShoebanfoo = new EmpShoebanfoo(18,27,250);
	public static Event empPillock = new EmpPillock(17,13,251);
	public static Event empBernard = new EmpBernard(18,7,252);
	public static Event empPudding = new EmpPudding(9,46,253);
	public static Event empBusdon = new EmpBusdon(33,39,254);
	public static Event empRevenge = new EmpRevenge(19,8,255);
	public static Event safe5 = new EventSafe5(6,7,256);
	public static Event safe6 = new EventSafe6(8,7,257);
	public static Event safe7 = new EventSafe7(12,40,258);
	public static Event safe8 = new EventSafe8(20,9,259);

	public static Event eventEmaudeline = new EventEmaudelineOffices(6,11,261);
	
	public static Event event270 = new WarpWestOfficestoBusramp(27,7,270);
	public static Event event271 = new WarpWestTransitiontoWestOfficesIntro(7,9,271);
	public static Event event272 = new WarpWestOfficesIntrotoWestTransition(35,36,272);
	public static Event event273 = new WarpWestOfficesIntrotoPredungeon(2,10,273);
	public static Event event274 = new WarpWestCubicleFinaltoBus(13,51,274);
	public static Event event275 = new WarpWestPredungeontoIntroOffices(19,13,275);
	public static Event event276 = new WarpWestPredungeontoTrashChute(3,13,276);
	public static Event event277 = new WarpWestPredungeontoCubicleDungeon(10,6,277);
	public static Event event278 = new WarpLobbytoWestCubicleFinal(3,8,278);
	public static Event event279 = new WarpWestTrashChutetoWestPredungeon(12,7,279);
	public static Event event280 = new WarpCubicleDungeonSouth(15,33,280);
	public static Event event281 = new WarpCubicleDungeonEast(27,18,281);
	public static Event event282 = new WarpCubicleDungeonNorth(15,6,282);
	public static Event event283 = new WarpCubicleDungeonWest(3,18,283);
	public static Event event284 = new WarpCubicleDungeontoTrashChute(15,23,284);
	public static Event event285 = new WarpCubicleFinaltoDungeon(13,6,285);
	public static Event event286 = new WarpCubicleFinaltoSperosOffice(9,47,286);
	public static Event event287 = new WarpCubicleFinaltoSouthOffices(21,48,287);
	public static Event event288 = new WarpSperosOfficetoWestCubicleFinal(14,11,288);
	public static Event event289 = new WarpWestPredungeontoJCloset(8,38,289);
	public static Event event290 = new WarpJClosettoWestPredungeon(5,11,290);
	public static Event event291 = new WarpBonus1toCubicleDungeon(6,13,291);
	public static Event event292 = new WarpBonus2toCubicleDungeon(10,9,292);
	public static Event event293 = new WarpCubicleDungeonSouthEx(15,33,293);
	public static Event event294 = new WarpCubicleDungeonEastEx(27,18,294);
	public static Event event295 = new WarpCubicleDungeonNorthEx(15,6,295);
	public static Event event296 = new WarpCubicleDungeonWestEx(3,18,296);
	public static Event event297 = new WarpCubicleFinaltoDungeonEx(23,16,297);
	public static Event event298 = new WarpCubicleFinalFinaltoLobby(13,21,298);
	public static Event event299 = new WarpCubicleFinalFinaltoNowhere(13,6,299);
	public static Event EventSperos = new EventSperos(6,9,300);
	public static Event EventSperosInvis = new EventSperosInvisible(6,9,301);
	public static Event EventClockDigital = new EventClockDigital(14,17,302);
	public static Event EventClockAnalog = new EventClockAnalog(14,17,303);
	public static Event event304 = new WarpLobbytoWestElevator(9,15,304);
	public static Event event305 = new WarpWElevatortoLobby(5,6,305);
	public static Event event306 = new WarpSouthMaintoSElevator(17,54,306);
	public static Event event307 = new WarpSouthMaintoRoom1(5,16,307);
	public static Event event308 = new WarpSouthMaintoExitHall(17,6,308);
	public static Event event309 = new WarpSouthRoom1toSouthMain(8,17,309);
	public static Event event310 = new WarpExitHalltoSouthMain(8,13,310);
	public static Event event311 = new WarpSouthMaintoNElevator(17,16,311);
	public static Event event312 = new WarpWElevatortoBackroom(5,10,312);
	public static Event event313 = new WarpNElevatortoBackroom(5,10,313);
	public static Event event314 = new WarpNElevatortoLobby(5,6,314);
	public static Event event315 = new WarpSouthBathhousetoElevator(9,22,315);
	public static Event event316 = new WarpEastBathhousetoElevator(11,21,316);
	public static Event event317 = new WarpWestBathhousetoElevator(5,21,317);

	public static Event empPorter = new EmpPorter(12,8,322);
	public static Event empLiang = new EmpLiang(19,16,323);
	public static Event empBoyd = new EmpBoyd(14,25,324);
	public static Event empDamon = new EmpDamon(19,25,325);
	public static Event empValuableCompanyAsset = new EmpJack(24,25,326);
	public static Event empMoloch = new EmpMoloch(13,22,327);
	public static Event empScott = new EmpScott(13,19,328);
	public static Event empLuay = new EmpLuay(13,16,329);
	public static Event empSomeone = new EmpSomeone(23,17,330);
	public static Event empLorena = new EmpLorena(23,14,331);
	public static Event empSpradley = new EmpSpradley(23,11,332);
	public static Event empLite = new EmpLite(22,8,333);
	public static Event empAshli = new EmpAshli(17,8,334);
	public static Event empGarcia = new EmpGarcia(12,8,335);
	public static Event empPality= new EmpPality(9,8,336);
	public static Event EventAmdahlOffices = new EventAmdahlOffices(5,15,337);
	public static Event EventTriviaGuyOffices = new EventTriviaGuyOffices(6,7,338);
	public static Event empCubicleDroneM = new EmpCubicleDroneM(0,0,339);
	public static Event empCubicleDroneF = new EmpCubicleDroneF(0,0,340);
	public static Event empArmstrong = new EmpArmstrong(6,36,341);
	public static Event empSanchez = new EmpSanchez(9,8,342);
	public static Event empGoodman = new EmpGoodman(7,9,343);
	public static Event empMccoun = new EmpMccoun(7,13,344);
	public static Event empMathis = new EmpMathis(7,19,345);
	public static Event empSteger = new EmpSteger(7,23,346);
	public static Event empWeeks = new EmpWeeks(18,9,347);
	public static Event empFurlow = new EmpFurlow(18,13,348);
	public static Event empTurner = new EmpTurner(18,19,349);
	public static Event empHoward = new EmpHoward(18,23,350);

	

	public static Event testBattle = new EventTestBattle(0,0,1000);
	public static Event testItems = new EventTestItems(0,0,1001);
	public static Event testSummon = new SummonSignIntern(0,0,1002);

	public static final int TILEWIDTH = 32, TILEHEIGHT = 64;
	protected BufferedImage tex;
	public Creature test;
	boolean drawn;
	boolean fightwon;
	boolean selfswitch1,selfswitch2,selfswitch3,selfswitch4;
	int stage;						
	int finalstage;
	int frames;		//for animated events
	boolean open;	//for animated doors
	
	public Event(BufferedImage texture, int idnum, float x, float y) {
		if(texture.getHeight() == 256 && texture.getWidth() == 96){ // maybe replace later with "moveable" boolean?
			this.test = new Creature(game, x ,y, 32, 64, texture, idnum);		
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
		getEvents()[id] = this;
		this.frames = 0;
		this.open = false;
	}
	
	public Event(BufferedImage texture, int idnum, float x, float y, int stageNum) {
		if(texture.getHeight() == 256 && texture.getWidth() == 96){ // maybe replace later with "moveable" boolean?
			this.test = new Creature(game, x ,y, 32, 64, texture, idnum);		
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
		getEvents()[id] = this;
		this.stage = 0;
		this.finalstage = stageNum;
		this.frames = 0;
		this.open = false;
	}
	
	public Event(Game g, StateManager sm,GameState gs) {
		game=g;
		statemanager=sm;
		gamestate=gs;
	}
	
	
	
	public static GameState getGamestate() {
		return gamestate;
	}

	//If the event is attached to a Creature object, tick the Creature and make it walk around.
	public void tick(GameState gs) {
		if(test!=null){
			test.tick(gs);		
		}
		walkCycle();
	}
	
	public void render(Graphics g, int x, int y) {
		if(test==null){
			g.drawImage(tex,x, y+32-tex.getHeight(), tex.getWidth(), tex.getHeight(), null);
		}
		//If the event is attached to a Creature object, render it and draw the image attached to it. Rendering creature does not
		//draw anything. It only changes test.imgShown to match the creature's walk cycle.
		if(test!=null){
			test.render(g);
			g.drawImage(test.imgShown, x, y-32, TILEWIDTH, TILEHEIGHT, null);			
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
		
	public int getFrames() {
		return frames;
	}

	public void setFrames(int frames) {
		this.frames = frames;
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
	
	//Returns whether the event is visible.
	public boolean drawn(){
		return true;
	}
	
	//Returns whether the event is to be loaded upon entering a map.
	public boolean loaded(){
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
		eventmanager = new EventManager(game, gamestate,path);
		decormanager = new DecorManager(game, gamestate, path);
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
		StateManager.states.push(new DialogState(game, gamestate, statemanager, firstline, lastline, eventId));
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void Dialog(Dialog[] d, int dialoglength, int eventId, boolean arrow){
		StateManager.states.push(new DialogState(game, gamestate, statemanager, d, dialoglength, eventId, arrow));
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	//Pushes a simple notification window.
	public static void Notification(String message, int eventId){
		StateManager.states.push(new NotificationState(game, gamestate, statemanager, message, eventId));
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	//Pushes a examiniation window.
	public static void Examine(BufferedImage i, int eventId){
		StateManager.states.push(new ExamineState(game, gamestate, statemanager, i, eventId));
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	//Simple cutscene state that goes through multiple pictures.
	public static void Cutscene(BufferedImage[] scenes,int eventId){
		StateManager.states.push(new CutsceneState(game, gamestate, statemanager,scenes,eventId));
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
		
	//Choicebranch state, lets player make decision between a list of choices.
	public static void ChoiceBranch(int EventId, String[] choices, int width){
		StateManager.states.push(new ChoiceBranchState(game, gamestate, statemanager,EventId,choices,width));
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();			
		}

	}
	
	//Choicebranch state, lets player make decision between a list of choices.
	public static void ChoiceBranch(int EventId, String[] choices, String[] descr, int width){
		StateManager.states.push(new ChoiceBranchState(game, gamestate, statemanager,EventId,choices,descr,width));
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();			
		}

	}
	
	//Special version of choicebranch state with special art.
	public static void ElevatorChoiceBranch(int EventId,String[] choices, int width){
		StateManager.states.push(new ElevatorChoiceBranchState(game, gamestate,statemanager,EventId,choices));
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();			
		}
	}
	
	//State for exchanging letters with your Pen Pal
	public static void PenPalState(){
		StateManager.states.push(new PenPalLetterState(game,gamestate,statemanager));
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();			
		}
	}
	
	//State that just exists for a certain time than stops.
	public static void Timer(int EventId,int time){
		StateManager.states.push(new TimerState(game, gamestate, statemanager,EventId,time));
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
	
	//Pushes a summon.
	public static void Summon(Schmuck summon, int eventId){
		StateManager.states.push(new SummoningState(game, gamestate, statemanager, summon));
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	//Pushes a save state window.
	public static void Save(int eventId){
		StateManager.states.push(new SaveFileState(game, gamestate, statemanager, eventId,1));
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
/*		if(gamestate.inventorymanager.backpack.containsKey(i)){
			int temp = gamestate.inventorymanager.backpack.get(i);
			gamestate.inventorymanager.backpack.put(i, temp += num);
		}
		else{
			gamestate.inventorymanager.backpack.put(i, num);
		}*/
		gamestate.inventorymanager.loot(i, num);
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
	
	public int getQuest(int i){
		return gamestate.getQuest(i);
	}
	
	public void setQuest(int i, int stage){
		gamestate.setQuest(i, stage);
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
		if(!gamestate.getWorld().getTile((int)x,(int)(y-1)).isSolid() && !gamestate.getEventmanager().getEvent((int)x,(int)(y-1)).isSolid(0)){
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
		if(!gamestate.getWorld().getTile((int)x,(int)(y+1)).isSolid() && !gamestate.getEventmanager().getEvent((int)x,(int)(y+1)).isSolid(1)){
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
		if(!gamestate.getWorld().getTile((int)x-1,(int)(y)).isSolid()&&!gamestate.getEventmanager().getEvent((int)x-1,(int)(y)).isSolid(2)){
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
		if(!gamestate.getWorld().getTile((int)x+1,(int)(y)).isSolid()&&!gamestate.getEventmanager().getEvent((int)x+1,(int)(y)).isSolid(3)){
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
		if(selfswitch1){
			if(!this.selfswitch1){
				gamestate.getEventselfswitchmanager().setVar(this.getId(), gamestate.getEventselfswitchmanager().getVar(this.getId())+1);
			}
		}
		else{
			if(this.selfswitch1){
				gamestate.getEventselfswitchmanager().setVar(this.getId(), gamestate.getEventselfswitchmanager().getVar(this.getId())-1);
			}
		}
		this.selfswitch1 = selfswitch1;
	}

	public boolean isSelfswitch2() {
		return selfswitch2;
	}

	public void setSelfswitch2(boolean selfswitch2) {
		if(selfswitch2){
			if(!this.selfswitch2){
				gamestate.getEventselfswitchmanager().setVar(this.getId(), gamestate.getEventselfswitchmanager().getVar(this.getId())+2);
			}
		}
		else{
			if(this.selfswitch2){
				gamestate.getEventselfswitchmanager().setVar(this.getId(), gamestate.getEventselfswitchmanager().getVar(this.getId())-2);
			}
		}
		this.selfswitch2 = selfswitch2;
	}

	public boolean isSelfswitch3() {
		return selfswitch3;
	}

	public void setSelfswitch3(boolean selfswitch3) {
		if(selfswitch3){
			if(!this.selfswitch3){
				gamestate.getEventselfswitchmanager().setVar(this.getId(), gamestate.getEventselfswitchmanager().getVar(this.getId())+4);
			}
		}
		else{
			if(this.selfswitch3){
				gamestate.getEventselfswitchmanager().setVar(this.getId(), gamestate.getEventselfswitchmanager().getVar(this.getId())-4);
			}
		}
		this.selfswitch3 = selfswitch3;
	}

	public boolean isSelfswitch4() {
		return selfswitch4;
	}

	public void setSelfswitch4(boolean selfswitch4) {
		if(selfswitch4){
			if(!this.selfswitch4){
				gamestate.getEventselfswitchmanager().setVar(this.getId(), gamestate.getEventselfswitchmanager().getVar(this.getId())+8);
			}
		}
		else{
			if(this.selfswitch4){
				gamestate.getEventselfswitchmanager().setVar(this.getId(), gamestate.getEventselfswitchmanager().getVar(this.getId())-8);
			}
		}
		this.selfswitch4 = selfswitch4;
	}

	public Event[] getEvents() {
		return events;
	}	
	
}
