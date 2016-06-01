package dev.zt.UpliftedVFFV.gfx;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.io.IOException;

import dev.zt.UpliftedVFFV.dialog.Dialog;


//This is initialized upon opening the game
//This prepares all the art assets of the game, chops 'em up and attaches 'em to names that can be easily called anywhere else in the game
public class Assets {
	
	//TODO: Recategorize assets. Load only global assets, leave world assets to be loaded with respective worlds.
	private static final int width = 32, height = 32;
	
	//Item icons big/small.
	public static BufferedImage[] itemIcons;
	public static BufferedImage[] itemSprites;

	//Character stickers.
	public static BufferedImage[] stickers;
	
	//Global UI elements.
	public static BufferedImage Uparrow, Downarrow;
	
	//Battle sprites and skill icons.
	public static BufferedImage[] battleSprites;
	public static BufferedImage[] skillIcons;
	
	//Tilesets
	
	public static BufferedImage Wall1, Wall2, Ceiling1, Ceiling2, ElevatorDoorWall,ElevatorWall;
	public static BufferedImage White, ActuallyWhite, Black, Void,RedCarpet,WoodBoard, BlueCarpet, StoneFloor, AquaTile,WhiteTile
	,RowCarpet,	WhiteCarpet, GlassTile, BlueSquareCarpet, BlueDiagCarpet, CircleCarpet, SandTile, DarkSandTile
	,GreySquareCarpet,DarkRowCarpet, Steel,Asphalt,BlueGreyCarpet,WeirdCarpet,PaleMarble,AlternatingTile,GreyGroutTile,
	Brick,YellowCarpet,Grass,PurpleElevator,GreenElevator,RedElevator,YellowElevator;
	
	public static BufferedImage ElevatorPanel, ElevatorFloorMark, ElevatorWave, Smudge1, Smudge2;
	public static BufferedImage Operator,PenPal,EmployeeM1,EmployeeM2,EmployeeF, Mover, Wiper, Emaudeline, Informant;
	public static BufferedImage Jorge1, Jorge2, Jorge3, Jorge4;
	public static BufferedImage Speros1, Speros2, Speros3, Speros4, Speros5, Speros6;
	public static BufferedImage Carloc1;
	public static BufferedImage ElevatorDoor1,ElevatorDoor2,ElevatorDoor3,ElevatorDoor4;
	public static BufferedImage WoodDoor1,WoodDoor2,WoodDoor3,WoodDoor4, ClearDoor1, ClearDoor2, ClearDoor3, ClearDoor4,
	 PushDoor1, PushDoor2, PushDoor3, PushDoor4;

	public static BufferedImage WritingDesk1, Bed1,Tv, Trashcan, Calendar, WelcomeMat,Dresser, HatRack, Sign, StairsUp, StairsDown,
		HorizRug, VertiRug, Cupboard, Fridge, KitchenCounter, FlowerTable, Monolith, notPenPal, Cuidado, InfoPanel, Board, Projector,
		StairsRight0, StairsRight1, StairsRight2, StairsRight3,StairsRight3Diag,StairsRight3Alt, StairsLeft0,
		StairsLeft1, StairsLeft2, StairsLeft3,StairsLeft3Diag,StairsLeft3Alt,
		Poster1, Poster2, Poster3, TransparentTable, SmallPokerTable, SnookerTable, BigPokerTable, JanitorBench, JanitorCart,
		JanitorShelves,	VertTunnelArch1, VertTunnelArch2, VertTunnelArch3, HorzTunnelArch1, HorzTunnelArch2, HorzTunnelArch3,
		TunnelArchCorner, RightArrowSign, LeftArrowSign, BigScreenTv, Vidya, Puddle,ExitSign, AirVent, BigMailThing,
		RailLeft, RailMiddle, RailRight, BlackDoor, Grafitti1,Grafitti2, LadderDown,LadderUp,PosterRed,PosterBlue,
		PosterGreen,PosterLong;
	
	public static BufferedImage WestClocksDigital330,WestClocksDigital315,WestClocksDigital900,WestClocksDigital600,
	WestClocksDigital645, WestClocksAnalogE,WestClocksAnalogW,WestClocksAnalogN,WestClocksAnalogS,WestClocksAnalogR,
	WestClocksAnalogL,WestClocksAnalogF,WestClocksAnalogB,WestClocksDigital300,WestClocksDigital915;
	
	public static BufferedImage WorkDesk1, WorkDesk2, FilingCabinet, Sofa1,Sofa2, Sofa3, Sofa4, SafeClosed, SafeOpened,SafeClosed2,
	WaterCooler,Clock, VendingMachine;
	public static BufferedImage Table0,Table1,Table2,Table3,Table4,Table5,Table6,Table7, Table8, Table9;
	public static BufferedImage Mirror, Toilet, Sink, MaleSign, FemaleSign, SinkMirror;
	
	//New Stuff
	
	public static BufferedImage ElevatorCeiling, ElevatorWalls, OfficeCeiling, OfficeWalls, LobbyCeiling, LobbyWalls;
	public static BufferedImage BlackWall, BlackCeiling, AquariumWall, AquariumCeiling, GreyWall, GreyCeiling;	
	public static BufferedImage UnderwaterFilter, FogFilter, DarkFilter0,DarkFilter1,DarkFilter2,DarkFilter3,DarkFilter4;
	
	public static BufferedImage southMonolith,BluePosterExamine;
	
	public static Dialog[] dialog;
	
	public static void init(){
		
		//spritesheets loaded from files
//		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/WalkingSprites.png"));
		SpriteSheet WalkingSprites1 = new SpriteSheet(ImageLoader.loadImage("/textures/Sheet2.png"));
		SpriteSheet WalkingSprites2 = new SpriteSheet(ImageLoader.loadImage("/textures/Sheet3.png"));

		SpriteSheet floor = new SpriteSheet(ImageLoader.loadImage("/textures/ElevatorFloor.png"));
		SpriteSheet prop=new SpriteSheet(ImageLoader.loadImage("/textures/ElevatorProps.png"));
		SpriteSheet arrowup = new SpriteSheet(ImageLoader.loadImage("/ui/Arrow.png"));
		SpriteSheet arrowdown = new SpriteSheet(ImageLoader.loadImage("/ui/ArrowDown.png"));
		SpriteSheet door =new SpriteSheet(ImageLoader.loadImage("/textures/BlueElevatorDoor.png"));
		SpriteSheet Jorge = new SpriteSheet(ImageLoader.loadImage("/textures/Jorge.png"));
		SpriteSheet Carloc = new SpriteSheet(ImageLoader.loadImage("/textures/Carloc.png"));
		SpriteSheet Speros = new SpriteSheet(ImageLoader.loadImage("/textures/Speros.png"));

		SpriteSheet ActionIcons = new SpriteSheet(ImageLoader.loadImage("/textures/SkillIcon.png"));
		SpriteSheet FurnitureBackroom = new SpriteSheet(ImageLoader.loadImage("/textures/FurnitureBackroom.png"));
		SpriteSheet Furniture3rdFloor = new SpriteSheet(ImageLoader.loadImage("/textures/Furniture3rd.png"));
		SpriteSheet ItemIcons1 = new SpriteSheet(ImageLoader.loadImage("/Items/ItemSheet1.png"));

		//Newer Spritesheets
		SpriteSheet TilesetBackroom = new SpriteSheet(ImageLoader.loadImage("/textures/ElevatorsAndBackroom.png"));
		SpriteSheet TilesetBackroomWalls = new SpriteSheet(ImageLoader.loadImage("/textures/ElevatorsAndBackroomWalls.png"));
		SpriteSheet ThirdFloorTiles = new SpriteSheet(ImageLoader.loadImage("/textures/3rdFloor.png"));
		SpriteSheet ThirdFloorWalls = new SpriteSheet(ImageLoader.loadImage("/textures/3rdFloorWalls.png"));
		SpriteSheet ThirdFloorMisc = new SpriteSheet(ImageLoader.loadImage("/textures/3rdFloorMisc.png"));
		SpriteSheet Doors = new SpriteSheet(ImageLoader.loadImage("/textures/Doors1.png"));
		SpriteSheet WestClocks = new SpriteSheet(ImageLoader.loadImage("/textures/WestClocks.png"));
		southMonolith = ImageLoader.loadImage("/textures/SouthMonolith.png");
		BluePosterExamine = ImageLoader.loadImage("/textures/consolation constellation.png");

		//Load system resources, reused resources and stuff.
		//Character walking Sprites.
		Operator=WalkingSprites1.crop(0, 0, 3*width, 8*height);
		
		PenPal=WalkingSprites1.crop(3*width, 0, 3*width, 8*height);//=sheet.crop(3*width, 0, 3*width, 4*height);
		EmployeeM1=WalkingSprites1.crop(6*width, 0, 3*width, 8*height);//=sheet.crop(6*width, 0, 3*width, 4*height);
		EmployeeF=WalkingSprites1.crop(9*width, 0, 3*width, 8*height);//=sheet.crop(9*width, 0, 3*width, 4*height);
		EmployeeM2=WalkingSprites1.crop(6*width, 0, 3*width, 8*height);//=sheet.crop(0, 4*height, 3*width, 4*height);
		Mover = WalkingSprites2.crop(0, 0, 3*width, 8*height);
		Wiper = WalkingSprites2.crop(3*width, 0, 3*width, 8*height);
		Emaudeline = WalkingSprites2.crop(6*width, 0, 3*width, 8*height);
		Informant = WalkingSprites2.crop(9*width, 0, 3*width, 8*height);

		
		Jorge1=Jorge.crop(0,0,5*width,4*height);
		Jorge2=Jorge.crop(0,4*height,5*width,4*height);
		Jorge3=Jorge.crop(5*width,0,5*width,4*height);
		Jorge4=Jorge.crop(5*width,4*height,5*width,4*height);

		Carloc1 = Carloc.crop(0, 0, 2*width, 4*height);
				
		Speros1 = Speros.crop(0, 0, 4*width, 3*height);
		Speros2 = Speros.crop(0, 3*height, 4*width, 3*height);
		Speros3 = Speros.crop(4*width, 0, 4*width, 3*height);
		Speros4 = Speros.crop(4*width, 3*height, 4*width, 3*height);
		Speros5 = Speros.crop(8*width, 0, 4*width, 3*height);
		Speros6 = Speros.crop(8*width, 3*height, 4*width, 3*height);

		
		
		//Dialogue and character portraits.
		//TODO: Load character stickers from individual images to global array.
		int numImages = 5;
		stickers = new BufferedImage[numImages];
		stickers[0] = ImageLoader.loadImage("/CharacterBusts/Arturo.png");		//0 - Empty.
		stickers[1] = ImageLoader.loadImage("/CharacterBusts/Player-1.png");	//1 - Operator.
		stickers[2] = ImageLoader.loadImage("/CharacterBusts/Player-5.png");	//2 - Pen Pal.
		
		//Item icons.
		int numItems = 500;
		int itemSize = 128;
		itemIcons = new BufferedImage[numItems];
		itemIcons[0] = ItemIcons1.crop(0,0,itemSize,itemSize);						//Misc Food Item
		itemIcons[1] = ItemIcons1.crop(itemSize,0,itemSize,itemSize);				//Donut
		itemIcons[2] = ItemIcons1.crop(2*itemSize,0,itemSize,itemSize);				//Laser Pointer
		itemIcons[3] = ItemIcons1.crop(3*itemSize,0,itemSize,itemSize);				//Fishwater
		itemIcons[4] = ItemIcons1.crop(4*itemSize,0,itemSize,itemSize);				//Paperweight
		itemIcons[5] = ItemIcons1.crop(5*itemSize,0,itemSize,itemSize);				//Slacks
		itemIcons[6] = ItemIcons1.crop(6*itemSize,0,itemSize,itemSize);				//Medpak
		itemIcons[7] = ItemIcons1.crop(7*itemSize,0,itemSize,itemSize);				//Caffeine Patch
		itemIcons[8] = ItemIcons1.crop(8*itemSize,0,itemSize,itemSize);				//Melted Ice-Cream
		itemIcons[9] = ItemIcons1.crop(9*itemSize,0,itemSize,itemSize);				//Carrot Juice
		itemIcons[10] = ItemIcons1.crop(0,itemSize,itemSize,itemSize);				//Lemony Fresh
		itemIcons[11] = ItemIcons1.crop(itemSize,itemSize,itemSize,itemSize);		//Coffee'd Ice
		itemIcons[12] = ItemIcons1.crop(2*itemSize,itemSize,itemSize,itemSize);		//SmellingSalt
		itemIcons[13] = ItemIcons1.crop(3*itemSize,itemSize,itemSize,itemSize);		//Letter Opener
		itemIcons[14] = ItemIcons1.crop(4*itemSize,itemSize,itemSize,itemSize);		//Postage Stamp
		itemIcons[15] = ItemIcons1.crop(5*itemSize,itemSize,itemSize,itemSize);		//Mental Leakage
		itemIcons[16] = ItemIcons1.crop(6*itemSize,itemSize,itemSize,itemSize);		//Midge Proboscis
		itemIcons[17] = ItemIcons1.crop(7*itemSize,itemSize,itemSize,itemSize);		//Midge Blood
		itemIcons[18] = ItemIcons1.crop(8*itemSize,itemSize,itemSize,itemSize);		//Bad Yolk
		itemIcons[19] = ItemIcons1.crop(9*itemSize,itemSize,itemSize,itemSize);		//Bad Shell
		itemIcons[20] = ItemIcons1.crop(0,2*itemSize,itemSize,itemSize);			//Rattail
		itemIcons[21] = ItemIcons1.crop(itemSize,2*itemSize,itemSize,itemSize);		//Disease
		itemIcons[22] = ItemIcons1.crop(2*itemSize,2*itemSize,itemSize,itemSize);	//Catcher's Mitt
		itemIcons[23] = ItemIcons1.crop(3*itemSize,2*itemSize,itemSize,itemSize);	//Catcher's Mask
		itemIcons[24] = ItemIcons1.crop(4*itemSize,2*itemSize,itemSize,itemSize);	//Seeing Eye
		itemIcons[25] = ItemIcons1.crop(5*itemSize,2*itemSize,itemSize,itemSize);	//#1 Boss Mug
		itemIcons[26] = ItemIcons1.crop(6*itemSize,2*itemSize,itemSize,itemSize);	//Roasted Coffee Bean
		itemIcons[27] = ItemIcons1.crop(7*itemSize,2*itemSize,itemSize,itemSize);	//8-Ball
		itemIcons[28] = ItemIcons1.crop(8*itemSize,2*itemSize,itemSize,itemSize);	//Manila Folder
		itemIcons[29] = ItemIcons1.crop(9*itemSize,2*itemSize,itemSize,itemSize);	//Basement Key Card
		itemIcons[30] = ItemIcons1.crop(0,3*itemSize,itemSize,itemSize);			//Summoning Conch
		itemIcons[31] = ItemIcons1.crop(itemSize,3*itemSize,itemSize,itemSize);		//Summoning Sauce
		itemIcons[32] = ItemIcons1.crop(2*itemSize,3*itemSize,itemSize,itemSize);	//Aether Feather
		itemIcons[33] = ItemIcons1.crop(3*itemSize,3*itemSize,itemSize,itemSize);	//Curse Coat
		itemIcons[34] = ItemIcons1.crop(4*itemSize,3*itemSize,itemSize,itemSize);	//Voodoo Pin
		itemIcons[35] = ItemIcons1.crop(5*itemSize,3*itemSize,itemSize,itemSize);	//Bag of Curses
		itemIcons[36] = ItemIcons1.crop(6*itemSize,3*itemSize,itemSize,itemSize);	//Dripping Fang
		itemIcons[37] = ItemIcons1.crop(7*itemSize,3*itemSize,itemSize,itemSize);	//Black Printer Toner
		itemIcons[38] = ItemIcons1.crop(8*itemSize,3*itemSize,itemSize,itemSize);	//Cyan Printer Toner
		itemIcons[39] = ItemIcons1.crop(9*itemSize,3*itemSize,itemSize,itemSize);	//Magenta Printer Toner
		itemIcons[40] = ItemIcons1.crop(0,4*itemSize,itemSize,itemSize);			//Yellow Printer Toner
		itemIcons[41] = ItemIcons1.crop(itemSize,4*itemSize,itemSize,itemSize);		//Cationic Cannon
		itemIcons[42] = ItemIcons1.crop(2*itemSize,4*itemSize,itemSize,itemSize);	//Unheard Word
		itemIcons[43] = ItemIcons1.crop(3*itemSize,4*itemSize,itemSize,itemSize);	//Reverberator
		itemIcons[44] = ItemIcons1.crop(4*itemSize,4*itemSize,itemSize,itemSize);	//Thought Fluid
		itemIcons[45] = ItemIcons1.crop(5*itemSize,4*itemSize,itemSize,itemSize);	//Glimpse of the End
		itemIcons[46] = ItemIcons1.crop(6*itemSize,4*itemSize,itemSize,itemSize);	//Usurper's Chem Set
		itemIcons[47] = ItemIcons1.crop(7*itemSize,4*itemSize,itemSize,itemSize);	//Faithless Cloak
		itemIcons[48] = ItemIcons1.crop(8*itemSize,4*itemSize,itemSize,itemSize);	//Newton's Cradle
		itemIcons[49] = ItemIcons1.crop(9*itemSize,4*itemSize,itemSize,itemSize);	//Envenomed Earth
		itemIcons[50] = ItemIcons1.crop(0,5*itemSize,itemSize,itemSize);			//Magnum
		itemIcons[51] = ItemIcons1.crop(itemSize,5*itemSize,itemSize,itemSize);		//Metal Ration
		itemIcons[52] = ItemIcons1.crop(2*itemSize,5*itemSize,itemSize,itemSize);	//Summoning Twofish
		itemIcons[53] = ItemIcons1.crop(3*itemSize,5*itemSize,itemSize,itemSize);	//Summoning Lotus
		itemIcons[54] = ItemIcons1.crop(4*itemSize,5*itemSize,itemSize,itemSize);	//Charcoal
		itemIcons[55] = ItemIcons1.crop(5*itemSize,5*itemSize,itemSize,itemSize);	//Antiinflammatory
		itemIcons[56] = ItemIcons1.crop(6*itemSize,5*itemSize,itemSize,itemSize);	//Bettergent
		itemIcons[57] = ItemIcons1.crop(7*itemSize,5*itemSize,itemSize,itemSize);	//Cold Medicine
		itemIcons[58] = ItemIcons1.crop(8*itemSize,5*itemSize,itemSize,itemSize);	//Cough Drops
		itemIcons[59] = ItemIcons1.crop(9*itemSize,5*itemSize,itemSize,itemSize);	//Lachiplatre
		itemIcons[60] = ItemIcons1.crop(0,6*itemSize,itemSize,itemSize);			//Muscle Relaxant
		itemIcons[61] = ItemIcons1.crop(itemSize,6*itemSize,itemSize,itemSize);		//Random Potion
		itemIcons[62] = ItemIcons1.crop(2*itemSize,6*itemSize,itemSize,itemSize);	//Stat Scrubber
		itemIcons[63] = ItemIcons1.crop(3*itemSize,6*itemSize,itemSize,itemSize);	//Stimulant
		itemIcons[64] = ItemIcons1.crop(4*itemSize,6*itemSize,itemSize,itemSize);	//Janitor Donation Form
		itemIcons[65] = ItemIcons1.crop(5*itemSize,6*itemSize,itemSize,itemSize);	//Magic Bottle
		itemIcons[66] = ItemIcons1.crop(6*itemSize,6*itemSize,itemSize,itemSize);	//Sleeping Pills
		itemIcons[67] = ItemIcons1.crop(7*itemSize,6*itemSize,itemSize,itemSize);	//Z-Drug
		itemIcons[68] = ItemIcons1.crop(8*itemSize,6*itemSize,itemSize,itemSize);	//Proof of Will
		itemIcons[69] = ItemIcons1.crop(9*itemSize,6*itemSize,itemSize,itemSize);	//Simmering Resentment
		itemIcons[70] = ItemIcons1.crop(0,7*itemSize,itemSize,itemSize);			//Genius Malignus
		itemIcons[71] = ItemIcons1.crop(itemSize,7*itemSize,itemSize,itemSize);		//Loamskin Talisman
		itemIcons[72] = ItemIcons1.crop(2*itemSize,7*itemSize,itemSize,itemSize);	//Anchor Talisman
		itemIcons[73] = ItemIcons1.crop(3*itemSize,7*itemSize,itemSize,itemSize);	//Sleepytime Surprise
		itemIcons[74] = ItemIcons1.crop(4*itemSize,7*itemSize,itemSize,itemSize);	//Aquarium Pass
		itemIcons[75] = ItemIcons1.crop(5*itemSize,7*itemSize,itemSize,itemSize);	//Aquarium Souvenir T-shirt
		itemIcons[76] = ItemIcons1.crop(6*itemSize,7*itemSize,itemSize,itemSize);	//Souvenir Coin
		itemIcons[77] = ItemIcons1.crop(7*itemSize,7*itemSize,itemSize,itemSize);	//Fishbowl Helmet
		itemIcons[78] = ItemIcons1.crop(8*itemSize,7*itemSize,itemSize,itemSize);	//Salvager's Helmet
		itemIcons[79] = ItemIcons1.crop(9*itemSize,7*itemSize,itemSize,itemSize);	//Salvager's Scrap-Ripper
		itemIcons[80] = ItemIcons1.crop(0,8*itemSize,itemSize,itemSize);			//Salvager's Toolbelt
		itemIcons[81] = ItemIcons1.crop(itemSize,8*itemSize,itemSize,itemSize);		//Fish Food
		itemIcons[82] = ItemIcons1.crop(2*itemSize,8*itemSize,itemSize,itemSize);	//Mangrove Talisman
		itemIcons[83] = ItemIcons1.crop(3*itemSize,8*itemSize,itemSize,itemSize);	//False Face
		itemIcons[84] = ItemIcons1.crop(4*itemSize,8*itemSize,itemSize,itemSize);	//Monster Coffee
		itemIcons[85] = ItemIcons1.crop(5*itemSize,8*itemSize,itemSize,itemSize);	//Conduit
		itemIcons[86] = ItemIcons1.crop(6*itemSize,8*itemSize,itemSize,itemSize);	//Auto-Querier
		itemIcons[87] = ItemIcons1.crop(7*itemSize,8*itemSize,itemSize,itemSize);	//Lucky Hoof
		itemIcons[88] = ItemIcons1.crop(8*itemSize,8*itemSize,itemSize,itemSize);	//Rainbow Scale
		itemIcons[89] = ItemIcons1.crop(9*itemSize,8*itemSize,itemSize,itemSize);	//Sweetish Fish
		itemIcons[90] = ItemIcons1.crop(0,9*itemSize,itemSize,itemSize);			//Pelican Plush Toy
		itemIcons[91] = ItemIcons1.crop(itemSize,9*itemSize,itemSize,itemSize);		//Stick-On Gills
		itemIcons[92] = ItemIcons1.crop(2*itemSize,9*itemSize,itemSize,itemSize);	//Torchlight
		itemIcons[93] = ItemIcons1.crop(3*itemSize,9*itemSize,itemSize,itemSize);	//Beluga Bubblegum
		itemIcons[94] = ItemIcons1.crop(4*itemSize,9*itemSize,itemSize,itemSize);	//Salted Nori
		itemIcons[95] = ItemIcons1.crop(5*itemSize,9*itemSize,itemSize,itemSize);	//Placeholder
		itemIcons[96] = ItemIcons1.crop(6*itemSize,9*itemSize,itemSize,itemSize);	//
		itemIcons[97] = ItemIcons1.crop(7*itemSize,9*itemSize,itemSize,itemSize);	//
		itemIcons[98] = ItemIcons1.crop(8*itemSize,9*itemSize,itemSize,itemSize);	//
		itemIcons[99] = ItemIcons1.crop(9*itemSize,9*itemSize,itemSize,itemSize);	//
		
		//Skill Icons.
		int numSkills = 10;
		skillIcons = new BufferedImage[numSkills];
		skillIcons[0] = ActionIcons.crop(0,0,32,32);			//0 - Attack.
		skillIcons[1] = ActionIcons.crop(32,0,32,32);			//1 - Skill.
		skillIcons[2] = ActionIcons.crop(64,0,32,32);			//2 - Nothing.
		skillIcons[3] = ActionIcons.crop(96,0,32,32);			//3 - Wait.
		skillIcons[4] = ActionIcons.crop(128,0,32,32);			//4 - Item.
		skillIcons[5] = ActionIcons.crop(160,0,32,32);			//5 - Run.
		
		//Battle Sprites.
		int numSprites = 50;
		battleSprites = new BufferedImage[numSprites];
		battleSprites[0] = ImageLoader.loadImage("/BattleSprites/Operator.png");			//0 - Operator.
		battleSprites[1] = ImageLoader.loadImage("/BattleSprites/PenPal.png");				//1 - Pen Pal.
		battleSprites[2] = ImageLoader.loadImage("/BattleSprites/Midge.png");				//2 - Midge.
		battleSprites[3] = ImageLoader.loadImage("/BattleSprites/Augur.png");				//3 - Augur.
		battleSprites[4] = ImageLoader.loadImage("/BattleSprites/Rot Thought.png");			//4 - Rot Thought.
		battleSprites[5] = ImageLoader.loadImage("/BattleSprites/Ill Rat.png");				//5 - Ill Rat.
		battleSprites[6] = ImageLoader.loadImage("/BattleSprites/Bad Egg.png");				//6 - Bad Egg.
		battleSprites[7] = ImageLoader.loadImage("/BattleSprites/Coffee Elemental.png");	//7 - Coffee Elemental.
		battleSprites[8] = ImageLoader.loadImage("/BattleSprites/Eye Catcher.png");			//8 - Eye Catcher.
		battleSprites[9] = ImageLoader.loadImage("/BattleSprites/Jorge.png");				//9 - Jorge.
		battleSprites[10] = ImageLoader.loadImage("/BattleSprites/Midgeon.png");			//10 - Midgeon.
		battleSprites[11] = ImageLoader.loadImage("/BattleSprites/Portent.png");			//11 - Portent.
		battleSprites[12] = ImageLoader.loadImage("/BattleSprites/Screamer.png");			//12 - Screamer.
		battleSprites[13] = ImageLoader.loadImage("/BattleSprites/Shirley.png");			//13 - Shirley.
		battleSprites[14] = ImageLoader.loadImage("/BattleSprites/WanderingMind.png");		//14 - Wandering Mind.
		battleSprites[15] = ImageLoader.loadImage("/BattleSprites/Lunk.png");				//15 - Lunk.
//		battleSprites[16] = ImageLoader.loadImage("/BattleSprites/Auger.png");				//16 - Auger.
		battleSprites[17] = ImageLoader.loadImage("/BattleSprites/Chameleon.png");			//17 - Chameleon.
		battleSprites[18] = ImageLoader.loadImage("/BattleSprites/Copy Cat.png");			//18 - Copy Cat.
		battleSprites[19] = ImageLoader.loadImage("/BattleSprites/KillingTime.png");		//19 - Killing Time.
		battleSprites[20] = ImageLoader.loadImage("/BattleSprites/Floater.png");			//20 - Floater.
		battleSprites[21] = ImageLoader.loadImage("/BattleSprites/Feeling of Being Watched.png");		//21 - Feeling of Being Watched.
		battleSprites[22] = ImageLoader.loadImage("/BattleSprites/Feeling of Having Taken a Wrong Turn.png");		//22 - Feeling you took a Wrong turn
		battleSprites[23] = ImageLoader.loadImage("/BattleSprites/Nothing But a Feeling.png");			//23 - Just a Feeling
		battleSprites[24] = ImageLoader.loadImage("/BattleSprites/Plated Ghost.png");			//24 - Plated Ghost
		battleSprites[25] = ImageLoader.loadImage("/BattleSprites/Pleated Ghost.png");			//25 - Pleated Ghost
		battleSprites[26] = ImageLoader.loadImage("/BattleSprites/Midgiraffe.png");			//26 - Midgiraffe
		battleSprites[27] = ImageLoader.loadImage("/BattleSprites/Stilts.png");				//27 - Stilts
		battleSprites[28] = ImageLoader.loadImage("/BattleSprites/Man's Best Friend.png");	//28 - Men's Best Friends
		battleSprites[29] = ImageLoader.loadImage("/BattleSprites/Harbinger.png");			//29 - Harbinger
		battleSprites[30] = ImageLoader.loadImage("/BattleSprites/Fortress Mindspace.png");	//30 - Fortress Mindspace
		battleSprites[31] = ImageLoader.loadImage("/BattleSprites/Mindspace Overseer.png");	//31 - Mindspace Overseer
		battleSprites[32] = ImageLoader.loadImage("/BattleSprites/Panopticon.png");			//32 - Panopticon


		//UI elements and other icons.
		Uparrow = arrowup.crop(0, 0 ,32, 32);
		Downarrow = arrowdown.crop(0, 0 ,32, 32);
		
		//System Fonts.
		try {
            //Create the font to use. Specify the size!
            Font customFont1 = Font.createFont(Font.TRUETYPE_FONT, Assets.class.getResourceAsStream("/Font/Chewy.ttf")).deriveFont(27f);
            Font customFont2 = Font.createFont(Font.TRUETYPE_FONT, Assets.class.getResourceAsStream("/Font/nunito.bold.ttf")).deriveFont(18f);
            Font customFont3 = Font.createFont(Font.TRUETYPE_FONT, Assets.class.getResourceAsStream("/Font/Signika-Semibold.otf")).deriveFont(12f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            //Register the font
            ge.registerFont(customFont1);
            ge.registerFont(customFont2);
            ge.registerFont(customFont3);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch(FontFormatException e)
        {
            e.printStackTrace();
        }
		
		
		//Props and Tiles.
		//TODO: Relocated to world asset loader. Only load tiles for one world at a time.
		//prop sprites
		ElevatorDoor1=door.crop(16, 0, 96, 64);
		ElevatorDoor2=door.crop(16, 64, 96, 64);
		ElevatorDoor3=door.crop(16, 128, 96, 64);
		ElevatorDoor4=door.crop(16, 192, 96, 64);
		
		WoodDoor1=Doors.crop(0, 0, width, 2*height);
		WoodDoor2=Doors.crop(0, 2*height, width, 2*height);
		WoodDoor3=Doors.crop(0, 4*height, width, 2*height);
		WoodDoor4=Doors.crop(0, 6*height, width, 2*height);
		
		ClearDoor1=Doors.crop(width, 0, width, 2*height);
		ClearDoor2=Doors.crop(width, 2*height, width, 2*height);
		ClearDoor3=Doors.crop(width, 4*height, width, 2*height);
		ClearDoor4=Doors.crop(width, 6*height, width, 2*height);
		
		PushDoor1=Doors.crop(2*width, 0, width, 2*height);
		PushDoor2=Doors.crop(2*width, 2*height, width, 2*height);
		PushDoor3=Doors.crop(2*width, 4*height, width, 2*height);
		PushDoor4=Doors.crop(2*width, 6*height, width, 2*height);
		
		BlackDoor = Furniture3rdFloor.crop(width*14, height*2, width, height*2);
		
		ElevatorPanel = prop.crop(7*width,0,width,height);
		ElevatorFloorMark = prop.crop(width, 0 , 3*width, 3*height);
		ElevatorWave = prop.crop(5*width, 0 , width, height);
		Smudge1 = prop.crop(8*width, 0 , width, height);
		Smudge2 = prop.crop(9*width, 0 , width, height);
		
		//Tile textures
		White = floor.crop(0, 0, 2*width, 3*height);
		ActuallyWhite = FurnitureBackroom.crop(160, 0, 2*width, 3*height);
		Black = floor.crop(2*width, 0, 2*width, 3*height);
		Void = floor.crop(2*width, 0, 2*width, 3*height);
		
		
		//New Tilesets
		
		WoodBoard = TilesetBackroom.crop(0, 0, 2*width, 3*height);
		WhiteTile = TilesetBackroom.crop(2*width, 0, 2*width, 3*height);
		RedCarpet = TilesetBackroom.crop(4*width, 0, 2*width, 3*height);
		BlueCarpet = TilesetBackroom.crop(6*width, 0, 2*width, 3*height);
		AquaTile = TilesetBackroom.crop(8*width, 0, 2*width, 3*height);
		GreyGroutTile = TilesetBackroom.crop(10*width, 0, 2*width, 3*height);
		PurpleElevator = TilesetBackroom.crop(12*width, 0, 2*width, 3*height);
		GreenElevator = TilesetBackroom.crop(0, 3*height, 2*width, 3*height);
		RedElevator = TilesetBackroom.crop(2*width, 3*height, 2*width, 3*height);

		StoneFloor = TilesetBackroom.crop(6*width, 3*height, 2*width, 3*height);
		YellowElevator = TilesetBackroom.crop(8*width, 3*height, 2*width, 3*height);

		RowCarpet = ThirdFloorTiles.crop(0, 0, 2*width, 3*height);
		WhiteCarpet = ThirdFloorTiles.crop(2*width, 0, 2*width, 3*height);
		StairsUp = ThirdFloorTiles.crop(4*width,0,2*width,2*height);
		StairsDown = ThirdFloorTiles.crop(6*width,0,2*width,2*height);
		GlassTile = ThirdFloorTiles.crop(12*width,0,2*width,3*height);
		BlueSquareCarpet = ThirdFloorTiles.crop(14*width, 0, 2*width, 3*height);
		BlueDiagCarpet = ThirdFloorTiles.crop(0, 3*height, 2*width, 3*height);
		CircleCarpet = ThirdFloorTiles.crop(2*width, 3*height, 2*width, 3*height);
		SandTile = ThirdFloorTiles.crop(4*width, 3*height, 2*width, 3*height);
		DarkSandTile = ThirdFloorTiles.crop(6*width, 3*height, 2*width, 3*height);
		GreySquareCarpet = ThirdFloorTiles.crop(12*width, 3*height, 2*width, 3*height);
		DarkRowCarpet = ThirdFloorTiles.crop(14*width, 3*height, 2*width, 3*height);

		Steel = ThirdFloorTiles.crop(0, 6*height, 2*width, 3*height);
		Asphalt = ThirdFloorTiles.crop(2*width, 6*height, 2*width, 3*height);
		BlueGreyCarpet = ThirdFloorTiles.crop(4*width, 6*height, 2*width, 3*height);
		WeirdCarpet = ThirdFloorTiles.crop(6*width, 6*height, 2*width, 3*height);
		PaleMarble = ThirdFloorTiles.crop(12*width, 6*height, 2*width, 3*height);
		AlternatingTile = ThirdFloorTiles.crop(14*width, 6*height, 2*width, 3*height);
		Brick = ThirdFloorTiles.crop(0, 9*height, 2*width, 3*height);
		YellowCarpet = ThirdFloorTiles.crop(2*width, 9*height, 2*width, 3*height);
		Grass = ThirdFloorTiles.crop(4*width, 9*height, 2*width, 3*height);


		StairsRight0 = ThirdFloorTiles.crop((int) (8.5*width),(int)(0.5*width),width,height);
		StairsRight1 = ThirdFloorTiles.crop((int) (8.5*width),(int)(1.5*width),width,height);
		StairsRight2 = ThirdFloorTiles.crop((int) (8.5*width),(int)(2.5*width),width,height);
		StairsRight3 = ThirdFloorTiles.crop((int) (8.5*width),(int)(3.5*width),width,height);
		StairsRight3Diag = ThirdFloorTiles.crop((int) (8.5*width),(int)(8.5*width),width,height);
		StairsRight3Alt = ThirdFloorTiles.crop(8*width,5*width,width,height);

		
		StairsLeft0 = ThirdFloorTiles.crop((int) (10.5*width),(int)(0.5*width),width,height);
		StairsLeft1 = ThirdFloorTiles.crop((int) (10.5*width),(int)(1.5*width),width,height);
		StairsLeft2 = ThirdFloorTiles.crop((int) (10.5*width),(int)(2.5*width),width,height);
		StairsLeft3 = ThirdFloorTiles.crop((int) (10.5*width),(int)(3.5*width),width,height);
		StairsLeft3Diag = ThirdFloorTiles.crop((int) (10.5*width),(int)(8.5*width),width,height);
		StairsLeft3Alt = ThirdFloorTiles.crop(11*width,5*width,width,height);

		
		Ceiling1 = TilesetBackroomWalls.crop(0, 0, 2*width, 3*height);
		Wall1 = TilesetBackroomWalls.crop(0, 3*height, 2*width, 2*height);
		Ceiling2 = TilesetBackroomWalls.crop(2*width, 0, 2*width, 3*height);
		Wall2 = TilesetBackroomWalls.crop(2*width, 3*height, 2*width, 2*height);
		ElevatorCeiling = TilesetBackroomWalls.crop(4*width, 0, 2*width, 3*height);
		ElevatorWalls = TilesetBackroomWalls.crop(4*width, 3*height, 2*width, 2*height);
		LobbyCeiling = TilesetBackroomWalls.crop(6*width, 0, 2*width, 3*height);
		LobbyWalls = TilesetBackroomWalls.crop(6*width, 3*height, 2*width, 2*height);
		
		OfficeCeiling = ThirdFloorWalls.crop(0, 0, 2*width, 3*height);
		OfficeWalls = ThirdFloorWalls.crop(0, 3*height, 2*width, 2*height);
		BlackCeiling = ThirdFloorWalls.crop(2*width, 0, 2*width, 3*height);
		BlackWall = ThirdFloorWalls.crop(2*width, 3*height, 2*width, 2*height);
		AquariumCeiling = ThirdFloorWalls.crop(4*width, 0, 2*width, 3*height);
		AquariumWall = ThirdFloorWalls.crop(4*width, 3*height, 2*width, 2*height);
		GreyCeiling = ThirdFloorWalls.crop(6*width, 0, 2*width, 3*height);
		GreyWall = ThirdFloorWalls.crop(6*width, 3*height, 2*width, 2*height);
		
		//Furniture
		
		WritingDesk1 = FurnitureBackroom.crop(0,0,2*width,2*height);
		Bed1 = FurnitureBackroom.crop(2*width,0,width,3*height);
		Calendar = FurnitureBackroom.crop(4*width,0,width,height);
		Trashcan = FurnitureBackroom.crop(3*width,0,width,height);
		WelcomeMat = FurnitureBackroom.crop(7*width,0,2*width,height);
		Dresser = FurnitureBackroom.crop(9*width,0,width,3*height);
		HatRack = FurnitureBackroom.crop(10*width,0,width,3*height);
		Sign =  FurnitureBackroom.crop(11*width,0,width,height);
		HorizRug = FurnitureBackroom.crop(5*width,0,2*width,height);
		VertiRug = FurnitureBackroom.crop(12*width,0,2*width,3*height);
		Cupboard = FurnitureBackroom.crop(0,3*height,2*width,2*height);
		Fridge = FurnitureBackroom.crop(2*width,3*height,width,2*height);
		KitchenCounter = FurnitureBackroom.crop(3*width,3*height,3*width,2*height);
		FlowerTable = FurnitureBackroom.crop(14*width,0,2*width,2*height);
		Monolith = FurnitureBackroom.crop(6*width,4*height,width,height);
		notPenPal = FurnitureBackroom.crop(7*width,3*height,width,2*height);
		Cuidado = FurnitureBackroom.crop(8*width,4*height,width,height);
		JanitorBench = FurnitureBackroom.crop(12*width,3*height,width,height);
		JanitorCart = FurnitureBackroom.crop(13*width,3*height,2*width,2*height);
		JanitorShelves = FurnitureBackroom.crop(15*width,3*height,width,2*height);

		InfoPanel = Furniture3rdFloor.crop(14*width, 0, width, height);
		Poster1 = Furniture3rdFloor.crop(0, 2*height, width, height);
		Poster2 = Furniture3rdFloor.crop(width, 2*height, width, height);
		Poster3 = Furniture3rdFloor.crop(2*width, 2*height, width, height);
		Board = Furniture3rdFloor.crop(6*width, 5*height, 2*width, height);
		Projector = Furniture3rdFloor.crop(8*width, 5*height, 2*width, 2*height);
		TransparentTable = Furniture3rdFloor.crop(10*width, 5*height, 2*width, height);
		SmallPokerTable = Furniture3rdFloor.crop(12*width, 5*height, 2*width, height);
		SnookerTable = Furniture3rdFloor.crop(14*width, 4*height, 2*width, 2*height);
		BigPokerTable = Furniture3rdFloor.crop(0, 6*height, 3*width, 6*height);
		
		
		WorkDesk1 = Furniture3rdFloor.crop(0, 3*height, width*2, height*2);
		WorkDesk2 = Furniture3rdFloor.crop(0, 0, width*2, height*2);

		FilingCabinet = Furniture3rdFloor.crop(2*width, 0, width, 2*height);
		Sofa1 = Furniture3rdFloor.crop(3*width, 0, width*2, 2*height);
		Sofa2 = Furniture3rdFloor.crop(9*width, 0, width, height*2); 
		Sofa3 = Furniture3rdFloor.crop(3*width, 2*height, width*2, 2*height);
		Sofa4 = Furniture3rdFloor.crop(9*width, 2*height, width, height*2); 
		SafeClosed = Furniture3rdFloor.crop(5*width, 0, width, height);
		SafeClosed2 = Furniture3rdFloor.crop(5*width, 2*height, width, height);
		SafeOpened = Furniture3rdFloor.crop(5*width, height, width, height);
		WaterCooler = Furniture3rdFloor.crop(6*width, 0, width, height*2);
		Clock = Furniture3rdFloor.crop(7*width, 0, width, height);
		VendingMachine = Furniture3rdFloor.crop(8*width, 0, width, height*2);
		LeftArrowSign = Furniture3rdFloor.crop(2*width, 4*height, width, height);
		RightArrowSign = Furniture3rdFloor.crop(3*width, 4*height, width, height);
		Grafitti1= Furniture3rdFloor.crop(4*width, 4*height, width, height);
		Grafitti2 = Furniture3rdFloor.crop(5*width, 4*height, width, height);
		BigScreenTv = Furniture3rdFloor.crop(6*width, 2*height, 2*width, 2*height);
		Vidya = Furniture3rdFloor.crop(6*width, 4*height, width, height);
		ExitSign = Furniture3rdFloor.crop(2*width, 3*height, width, height);
		AirVent = Furniture3rdFloor.crop(5*width, 3*height, width, height);
		BigMailThing = Furniture3rdFloor.crop(3*width, 7*height, 2*width, 3*height);
		Puddle = Furniture3rdFloor.crop(10*width, 3*height, 2*width, 2*height);
		LadderDown = Furniture3rdFloor.crop(6*width, 8*height, 1*width, 2*height);
		LadderUp = Furniture3rdFloor.crop(5*width, 7*height, 1*width, 3*height);
		PosterRed = Furniture3rdFloor.crop(0, 6*height, width, height);
		PosterBlue = Furniture3rdFloor.crop(1*width, 6*height, width, height);
		PosterGreen = Furniture3rdFloor.crop(2*width, 6*height, width, height);
		PosterLong = Furniture3rdFloor.crop(3*width, 6*height, 2*width, height);

		
		VertTunnelArch1 = ThirdFloorMisc.crop(0, 0, 7*width, height);
		VertTunnelArch2 = ThirdFloorMisc.crop(0,1*height, 7*width, 3*height);
		VertTunnelArch3 = ThirdFloorMisc.crop(0, 4*height, 7*width, height);
		HorzTunnelArch1 = ThirdFloorMisc.crop(7*width, 0, width, 7*height);
		HorzTunnelArch2 = ThirdFloorMisc.crop(8*width, 0, 3*width, 7*height);
		HorzTunnelArch3 = ThirdFloorMisc.crop(11*width, 0, width, 7*height);
		TunnelArchCorner = ThirdFloorMisc.crop(0, 5*height, 7*width, 7*height);
		
		RailLeft = Furniture3rdFloor.crop(14*width, height, width/2, height);
		RailMiddle = Furniture3rdFloor.crop((int)(14.5*width), height, width, height);
		RailRight = Furniture3rdFloor.crop((int)(15.5*width), height, width/2, height);

		Table0 = FurnitureBackroom.crop(8*width, 3*height, width, height);
		Table1 = FurnitureBackroom.crop(9*width, 3*height, width, height);
		Table2 = FurnitureBackroom.crop(10*width, 3*height, width, height);
		Table3 = FurnitureBackroom.crop(11*width, 3*height, width, height);
		Table4 = FurnitureBackroom.crop(9*width, 4*height, width, height);
		Table5 = FurnitureBackroom.crop(10*width, 4*height, width, height);
		Table6 = FurnitureBackroom.crop(11*width, 4*height, width, height);
		Table7 = FurnitureBackroom.crop(9*width, 5*height, width, height);
		Table8 = FurnitureBackroom.crop(10*width, 5*height, width, height);
		Table9 = FurnitureBackroom.crop(11*width, 5*height, width, height);
		
		Mirror = Furniture3rdFloor.crop(0, 5*height, width, height);
		Toilet = Furniture3rdFloor.crop(width, 5*height, width, height);
		Sink = Furniture3rdFloor.crop(2*width, 5*height, width, height);
		MaleSign = Furniture3rdFloor.crop(3*width, 5*height, width, height);
		FemaleSign = Furniture3rdFloor.crop(4*width, 5*height, width, height);
		SinkMirror = Furniture3rdFloor.crop(5*width, 5*height, width, height*2);
		
		WestClocksDigital330 = WestClocks.crop(0, 0, 3*width, 3*height);
		WestClocksDigital315 = WestClocks.crop(3*width, 0, 3*width, 3*height);
		WestClocksDigital900 = WestClocks.crop(0, 3*height, 3*width, 3*height);
		WestClocksDigital600 = WestClocks.crop(0, 6*height, 3*width, 3*height);
		WestClocksDigital645 = WestClocks.crop(0, 9*height, 3*width, 3*height);
		WestClocksDigital300 = WestClocks.crop(3*width, 6*height, 3*width, 3*height);
		WestClocksDigital915 = WestClocks.crop(3*width, 9*height, 3*width, 3*height);
		WestClocksAnalogE = WestClocks.crop(6*width, 0, 3*width, 3*height);
		WestClocksAnalogW = WestClocks.crop(6*width, 3*height, 3*width, 3*height);
		WestClocksAnalogN = WestClocks.crop(6*width, 6*height, 3*width, 3*height);
		WestClocksAnalogS = WestClocks.crop(6*width, 9*height, 3*width, 3*height);
		WestClocksAnalogR = WestClocks.crop(9*width, 0, 3*width, 3*height);
		WestClocksAnalogL = WestClocks.crop(9*width, 3*height, 3*width, 3*height);
		WestClocksAnalogF = WestClocks.crop(9*width, 6*height, 3*width, 3*height);
		WestClocksAnalogB = WestClocks.crop(9*width, 9*height, 3*width, 3*height);
		UnderwaterFilter = ImageLoader.loadImage("/textures/UnderwaterFilter.png");
		DarkFilter3 = ImageLoader.loadImage("/textures/DarkFilter0.png");
		DarkFilter2 = ImageLoader.loadImage("/textures/DarkFilter1.png");
		DarkFilter1 = ImageLoader.loadImage("/textures/DarkFilter2.png");
		DarkFilter0 = ImageLoader.loadImage("/textures/DarkFilter3.png");

		FogFilter = ImageLoader.loadImage("/textures/FogFilter.png");

	}

}
