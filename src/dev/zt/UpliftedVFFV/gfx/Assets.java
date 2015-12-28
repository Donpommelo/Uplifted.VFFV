package dev.zt.UpliftedVFFV.gfx;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.io.IOException;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.utils.Utils;


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
	,RowCarpet,	WhiteCarpet, GlassTile;
	
	public static BufferedImage ElevatorPanel, ElevatorFloorMark, ElevatorWave, Smudge1, Smudge2;
	public static BufferedImage Operator,PenPal,EmployeeM1,EmployeeM2,EmployeeF;
	public static BufferedImage Jorge1;
	public static BufferedImage ElevatorDoor1,ElevatorDoor2,ElevatorDoor3,ElevatorDoor4;
	
	public static BufferedImage WritingDesk1, Bed1,Tv, Trashcan, Calendar, WelcomeMat,Dresser, HatRack, Sign, StairsUp, StairsDown,
		HorizRug, VertiRug, Cupboard, Fridge, KitchenCounter, FlowerTable, Monolith, notPenPal, Cuidado, InfoPanel, Board, Projector,
		StairsRight0, StairsRight1, StairsRight2, StairsRight3, StairsLeft0, StairsLeft1, StairsLeft2, StairsLeft3,
		Poster1, Poster2;
	public static BufferedImage WorkDesk1, WorkDesk2, FilingCabinet, Sofa1,Sofa2, MoverSofa1,MoverSofa2,MoverGag, SafeClosed, SafeOpened, WaterCooler,Clock, VendingMachine;
	public static BufferedImage Table0,Table1,Table2,Table3,Table4,Table5,Table6,Table7, Table8, Table9;
	public static BufferedImage Mirror, Toilet, Sink, MaleSign, FemaleSign, SinkMirror;
	
	//New Stuff
	
	public static BufferedImage ElevatorCeiling, ElevatorWalls, OfficeCeiling, OfficeWalls, LobbyCeiling, LobbyWalls;
		
	
	public static Dialog[] dialog;
	
	public static void init(){
		
		//spritesheets loaded from files
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/WalkingSprites.png"));
		SpriteSheet floor = new SpriteSheet(ImageLoader.loadImage("/textures/ElevatorFloor.png"));
		SpriteSheet prop=new SpriteSheet(ImageLoader.loadImage("/textures/ElevatorProps.png"));
		SpriteSheet arrowup = new SpriteSheet(ImageLoader.loadImage("/ui/Arrow.png"));
		SpriteSheet arrowdown = new SpriteSheet(ImageLoader.loadImage("/ui/ArrowDown.png"));
		SpriteSheet door =new SpriteSheet(ImageLoader.loadImage("/textures/BlueElevatorDoor.png"));
		SpriteSheet Jorge = new SpriteSheet(ImageLoader.loadImage("/textures/JorgeRough.png"));
		SpriteSheet ActionIcons = new SpriteSheet(ImageLoader.loadImage("/textures/SkillIcon.png"));
		SpriteSheet FurnitureBackroom = new SpriteSheet(ImageLoader.loadImage("/textures/FurnitureBackroom.png"));
		SpriteSheet Furniture3rdFloor = new SpriteSheet(ImageLoader.loadImage("/textures/Furniture3rd.png"));
		
		//Newer Spritesheets
		SpriteSheet TilesetBackroom = new SpriteSheet(ImageLoader.loadImage("/textures/ElevatorsAndBackroom.png"));
		SpriteSheet TilesetBackroomWalls = new SpriteSheet(ImageLoader.loadImage("/textures/ElevatorsAndBackroomWalls.png"));
		SpriteSheet ThirdFloorTiles = new SpriteSheet(ImageLoader.loadImage("/textures/3rdFloor.png"));
		SpriteSheet ThirdFloorWalls = new SpriteSheet(ImageLoader.loadImage("/textures/3rdFloorWalls.png"));

		
		//Load system resources, reused resources and stuff.
		//Character walking Sprites.
		Operator=sheet.crop(0, 0, 3*width, 4*height);
		PenPal=sheet.crop(3*width, 0, 3*width, 4*height);
		EmployeeM1=sheet.crop(6*width, 0, 3*width, 4*height);
		EmployeeF=sheet.crop(9*width, 0, 3*width, 4*height);
		EmployeeM2=sheet.crop(0, 4*height, 3*width, 4*height);
		
		Jorge1=Jorge.crop(0,0,128,64);
		
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
		int numSprites = 16;
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
		StoneFloor = TilesetBackroom.crop(6*width, 3*height, 2*width, 3*height);
		GlassTile = ThirdFloorTiles.crop(12*width,0,2*width,3*height);

		RowCarpet = ThirdFloorTiles.crop(0, 0, 2*width, 3*height);
		WhiteCarpet = ThirdFloorTiles.crop(2*width, 0, 2*width, 3*height);
		StairsUp = ThirdFloorTiles.crop(4*width,0,2*width,2*height);
		StairsDown = ThirdFloorTiles.crop(6*width,0,2*width,2*height);
		StairsRight0 = ThirdFloorTiles.crop(9*width,0,width,height);
		StairsRight1 = ThirdFloorTiles.crop(9*width,height,width,height);
		StairsRight2 = ThirdFloorTiles.crop(9*width,2*height,width,height);
		StairsRight3 = ThirdFloorTiles.crop(9*width,3*height,width,height);
		StairsLeft0 = ThirdFloorTiles.crop(10*width,0,width,height);
		StairsLeft1 = ThirdFloorTiles.crop(10*width,height,width,height);
		StairsLeft2 = ThirdFloorTiles.crop(10*width,2*height,width,height);
		StairsLeft3 = ThirdFloorTiles.crop(10*width,3*height,width,height);
		
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
		InfoPanel = Furniture3rdFloor.crop(14*width, 0, width, height);
		Poster1 = Furniture3rdFloor.crop(0, 2*height, width, height);
		Poster2 = Furniture3rdFloor.crop(width, 2*height, width, height);
		Board = Furniture3rdFloor.crop(6*width, 5*height, 2*width, height);
		Projector = Furniture3rdFloor.crop(8*width, 5*height, 2*width, 2*height);


		WorkDesk1 = Furniture3rdFloor.crop(0, 0, width*2, height);
		FilingCabinet = Furniture3rdFloor.crop(64, 0, width, height);
		Sofa1 = Furniture3rdFloor.crop(96, 0, width*2, height);
		Sofa2 = Furniture3rdFloor.crop(288, 0, width, height*2); 
		SafeClosed = Furniture3rdFloor.crop(160, 0, width, height);
		SafeOpened = Furniture3rdFloor.crop(160, 32, width, height);
		WaterCooler = Furniture3rdFloor.crop(192, 0, width, height*2);
		Clock = Furniture3rdFloor.crop(224, 0, width, height);
		VendingMachine = Furniture3rdFloor.crop(256, 0, width, height*2);
		MoverSofa1 = Furniture3rdFloor.crop(288, 0, width, height);
		MoverSofa2 = Furniture3rdFloor.crop(288, 32, width, height);
		
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
		
		//Dialog loaded from text files.
		//TODO: Relocate to world asset loader? Only load dialogue for specific area.
		//File consists of first, a number equal to the number of dialog lines. update this when adding new lines
		//next, a long list of quadruplets containing the character's name that shows up in text boxes ("meep"=no name box)
		//then an image that serves as their talking sprite
		//after that,  a 1 or 0 to determine whether they stand on the left or right respectively
		//finally, the actual dialog of what they say. / indicates a skipping of line
		String file = Utils.loadFileAsString("/Text/DialogV2.txt");
		String[] tokens = file.split("\\r?\\n");
		dialog=new Dialog[Utils.parseInt(tokens[0])];
		for(int i = 0;i<Utils.parseInt(tokens[0]);i++){
			dialog[i]=new Dialog((tokens[4*i+1]),"/CharacterBusts/"+tokens[4*i+2],Utils.parseInt(tokens[4*i+3]),tokens[4*i+4]);
		}
	}

}
