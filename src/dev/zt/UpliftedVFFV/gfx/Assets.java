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
	,GreySquareCarpet,DarkRowCarpet, GreyGroutTile;
	
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
		StairsRight0, StairsRight1, StairsRight2, StairsRight3, StairsLeft0, StairsLeft1, StairsLeft2, StairsLeft3,
		Poster1, Poster2, Poster3, TransparentTable, SmallPokerTable, SnookerTable, BigPokerTable, JanitorBench, JanitorCart,
		JanitorShelves,	VertTunnelArch1, VertTunnelArch2, VertTunnelArch3, HorzTunnelArch1, HorzTunnelArch2, HorzTunnelArch3,
		TunnelArchCorner, RightArrowSign, LeftArrowSign, BigScreenTv, Vidya, Puddle,ExitSign, AirVent, BigMailThing,
		RailLeft, RailMiddle, RailRight, BlackDoor;
	public static BufferedImage WorkDesk1, WorkDesk2, FilingCabinet, Sofa1,Sofa2, Sofa3, Sofa4, SafeClosed, SafeOpened,SafeClosed2,
	WaterCooler,Clock, VendingMachine;
	public static BufferedImage Table0,Table1,Table2,Table3,Table4,Table5,Table6,Table7, Table8, Table9;
	public static BufferedImage Mirror, Toilet, Sink, MaleSign, FemaleSign, SinkMirror;
	
	//New Stuff
	
	public static BufferedImage ElevatorCeiling, ElevatorWalls, OfficeCeiling, OfficeWalls, LobbyCeiling, LobbyWalls;
	public static BufferedImage BlackWall, BlackCeiling, AquariumWall, AquariumCeiling, GreyWall, GreyCeiling;	
	public static BufferedImage UnderwaterFilter, FogFilter, DarkFilter;
	
	public static BufferedImage southMonolith;
	
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
		
		//Newer Spritesheets
		SpriteSheet TilesetBackroom = new SpriteSheet(ImageLoader.loadImage("/textures/ElevatorsAndBackroom.png"));
		SpriteSheet TilesetBackroomWalls = new SpriteSheet(ImageLoader.loadImage("/textures/ElevatorsAndBackroomWalls.png"));
		SpriteSheet ThirdFloorTiles = new SpriteSheet(ImageLoader.loadImage("/textures/3rdFloor.png"));
		SpriteSheet ThirdFloorWalls = new SpriteSheet(ImageLoader.loadImage("/textures/3rdFloorWalls.png"));
		SpriteSheet ThirdFloorMisc = new SpriteSheet(ImageLoader.loadImage("/textures/3rdFloorMisc.png"));
		SpriteSheet Doors = new SpriteSheet(ImageLoader.loadImage("/textures/Doors1.png"));

		southMonolith = ImageLoader.loadImage("/textures/SouthMonolith.png");

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
		//TODO: Load item and skill icons from icon sheet.
//		int numItems = 100;
//		itemIcons = new BufferedImage[numItems];
//		itemSprites = new BufferedImage[numItems];
		itemIcons = null;
		itemSprites = null;		
		
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
		int numSprites = 19;
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
		StoneFloor = TilesetBackroom.crop(6*width, 3*height, 2*width, 3*height);
		GlassTile = ThirdFloorTiles.crop(12*width,0,2*width,3*height);

		RowCarpet = ThirdFloorTiles.crop(0, 0, 2*width, 3*height);
		WhiteCarpet = ThirdFloorTiles.crop(2*width, 0, 2*width, 3*height);
		StairsUp = ThirdFloorTiles.crop(4*width,0,2*width,2*height);
		StairsDown = ThirdFloorTiles.crop(6*width,0,2*width,2*height);
		BlueSquareCarpet = ThirdFloorTiles.crop(14*width, 0, 2*width, 3*height);
		BlueDiagCarpet = ThirdFloorTiles.crop(0, 3*height, 2*width, 3*height);
		CircleCarpet = ThirdFloorTiles.crop(2*width, 3*height, 2*width, 3*height);
		SandTile = ThirdFloorTiles.crop(4*width, 3*height, 2*width, 3*height);
		DarkSandTile = ThirdFloorTiles.crop(6*width, 3*height, 2*width, 3*height);
		GreySquareCarpet = ThirdFloorTiles.crop(12*width, 3*height, 2*width, 3*height);
		DarkRowCarpet = ThirdFloorTiles.crop(14*width, 3*height, 2*width, 3*height);

		StairsRight0 = ThirdFloorTiles.crop((int) (8.5*width),(int)(0.5*width),width,height);
		StairsRight1 = ThirdFloorTiles.crop((int) (8.5*width),(int)(1.5*width),width,height);
		StairsRight2 = ThirdFloorTiles.crop((int) (8.5*width),(int)(2.5*width),width,height);
		StairsRight3 = ThirdFloorTiles.crop((int) (8.5*width),(int)(3.5*width),width,height);
		StairsLeft0 = ThirdFloorTiles.crop((int) (10.5*width),(int)(0.5*width),width,height);
		StairsLeft1 = ThirdFloorTiles.crop((int) (10.5*width),(int)(1.5*width),width,height);
		StairsLeft2 = ThirdFloorTiles.crop((int) (10.5*width),(int)(2.5*width),width,height);
		StairsLeft3 = ThirdFloorTiles.crop((int) (10.5*width),(int)(3.5*width),width,height);
		
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
		LeftArrowSign = Furniture3rdFloor.crop(2*width, 3*height, width, height);
		RightArrowSign = Furniture3rdFloor.crop(3*width, 3*height, width, height);
		BigScreenTv = Furniture3rdFloor.crop(6*width, 2*height, 2*width, 2*height);
		Vidya = Furniture3rdFloor.crop(6*width, 4*height, width, height);
		ExitSign = Furniture3rdFloor.crop(2*width, 3*height, width, height);
		AirVent = Furniture3rdFloor.crop(5*width, 3*height, width, height);
		BigMailThing = Furniture3rdFloor.crop(3*width, 7*height, 2*width, 3*height);
		Puddle = Furniture3rdFloor.crop(10*width, 3*height, 2*width, 2*height);
		
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

		Table0 = FurnitureBackroom.crop(9*width, 3*height, width, height);
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
			
		UnderwaterFilter = ImageLoader.loadImage("/textures/UnderwaterFilter.png");
		DarkFilter = ImageLoader.loadImage("/textures/DarkFilter.png");
		FogFilter = ImageLoader.loadImage("/textures/FogFilter.png");

	}

}
