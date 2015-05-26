package dev.zt.UpliftedVFFV.gfx;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.utils.Utils;


//This is initialized upon opening the game
//This prepares all the art assets of the game, chops 'em up and attaches 'em to names that can be easily called anywhere else in the game
public class Assets {
	
	private static final int width = 32, height = 32;
	
	public static BufferedImage Wall1, Wall2, Ceiling1, Ceiling2, ElevatorCeiling, ElevatorDoorWall,ElevatorWall;
	public static BufferedImage White, ActuallyWhite, Black, Void, BlackTile,CheckerTile,AquaTile,RedCarpet,WoodBoard,StoneFloor,BlueDiagonal,PelicanPlate,WhiteTile, GlassTile,BlueCarpet,CheckerCarpet, DiagCarpet,CircleCarpet,RowCarpet;
	public static BufferedImage ElevatorPanel, ElevatorFloorMark, ElevatorWave, Smudge1, Smudge2;
	public static BufferedImage Operator,PenPal,EmployeeM1,EmployeeM2,EmployeeF;
	public static BufferedImage Jorge1;
	public static BufferedImage ElevatorDoor1,ElevatorDoor2,ElevatorDoor3,ElevatorDoor4;
	
	public static BufferedImage WritingDesk1, WritingDesk2, Bed1,Bed2,Tv,Calendar, Stairs, StairsDown;
	public static BufferedImage WorkDesk1, WorkDesk2, FilingCabinet, Sofa1,Sofa2, MoverSofa1,MoverSofa2,MoverGag, SafeClosed, SafeOpened, WaterCooler,Clock, VendingMachine;
	public static BufferedImage Table0,Table1,Table2,Table3,Table4,Table5,Table6,Table7, Table8, Table9;
	public static BufferedImage Mirror, Toilet, Sink, MaleSign, FemaleSign, SinkMirror;
	
	public static BufferedImage Uparrow,Downarrow;
	
	public static BufferedImage attack, skill, nothing, wait, item, run, pointer;
	
	public static Dialog[] dialog;
	

	
	public static void init(){
		
		//spritesheets loaded from files
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/WalkingSprites.png"));
		SpriteSheet floor = new SpriteSheet(ImageLoader.loadImage("/textures/ElevatorFloor.png"));
		SpriteSheet walls = new SpriteSheet(ImageLoader.loadImage("/textures/ElevatorWalls.png"));
		SpriteSheet prop=new SpriteSheet(ImageLoader.loadImage("/textures/ElevatorProps.png"));
		SpriteSheet arrows=new SpriteSheet(ImageLoader.loadImage("/textures/WindowPaper.png"));
		SpriteSheet door =new SpriteSheet(ImageLoader.loadImage("/textures/BlueElevatorDoor.png"));
		SpriteSheet Jorge = new SpriteSheet(ImageLoader.loadImage("/textures/JorgeRough.png"));
		SpriteSheet ActionIcons = new SpriteSheet(ImageLoader.loadImage("/textures/SkillIcon.png"));
		SpriteSheet FurnitureBackroom = new SpriteSheet(ImageLoader.loadImage("/textures/FurnitureBackroom.png"));
		SpriteSheet Furniture3rdFloor = new SpriteSheet(ImageLoader.loadImage("/textures/Furniture3rd.png"));
		
		//character walking sprites
		Operator=sheet.crop(0, 0, 3*width, 4*height);
		PenPal=sheet.crop(3*width, 0, 3*width, 4*height);
		EmployeeM1=sheet.crop(6*width, 0, 3*width, 4*height);
		EmployeeF=sheet.crop(9*width, 0, 3*width, 4*height);
		EmployeeM2=sheet.crop(0, 4*height, 3*width, 4*height);
		
		Jorge1=Jorge.crop(0,0,128,64);
		
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
		White = floor.crop(0, 0, width, height);
		ActuallyWhite = FurnitureBackroom.crop(480, 0, width, height);
		Black = floor.crop(2*width, 0, width, height);
		Void = floor.crop(2*width, 0, width, height);
		BlackTile = floor.crop(4*width, 0, 2*width, 3*height);
		CheckerTile = floor.crop(6*width, 0, 2*width, 3*height);
		AquaTile = floor.crop(8*width, 0, 2*width, 3*height);
		RedCarpet = floor.crop(10*width, 0, 2*width, 3*height);
		WoodBoard = floor.crop(12*width, 0, 2*width, 3*height);
		StoneFloor = floor.crop(14*width, 0, 2*width, 3*height);
		BlueDiagonal = floor.crop(0, 3*height, 2*width, 3*height);
		PelicanPlate = floor.crop(2*width, 3*height, 2*width, 3*height);
		WhiteTile = floor.crop(4*width, 3*height, 2*width, 3*height);
		GlassTile = floor.crop(6*width, 3*height, 2*width, 3*height);
		BlueCarpet = floor.crop(8*width, 3*height, 2*width, 3*height);
		CheckerCarpet = floor.crop(10*width, 3*height, 2*width, 3*height);
		DiagCarpet = floor.crop(12*width, 3*height, 2*width, 3*height);
		CircleCarpet = floor.crop(14*width, 3*height, 2*width, 3*height);
		RowCarpet = floor.crop(0, 6*height, 2*width, 3*height);
		
		Wall1 = walls.crop(4*width, 2*height, 2*width, 3*height);
		Wall2 = walls.crop(6*width, 2*height, 2*width, 3*height);
		
		Ceiling1 = walls.crop(4*width, 0, 2*width, 3*height);
		Ceiling2 = walls.crop(6*width, 0, 2*width, 3*height);
		ElevatorCeiling = walls.crop(8*width, 0, 2*width, 3*height);
		ElevatorDoorWall = walls.crop(8*width, 2*width, 2*width, 3*height);
		ElevatorWall = walls.crop(10*width, 2*height, 2*width, 3*height);
		
		WritingDesk1 = FurnitureBackroom.crop(0,0,32,32);
		WritingDesk2 = FurnitureBackroom.crop(32,0,32,32);
		Bed1 = FurnitureBackroom.crop(64,0,32,32);
		Bed2 = FurnitureBackroom.crop(64,32,32,32);
		Tv = FurnitureBackroom.crop(96,0,32,64);
		Calendar = FurnitureBackroom.crop(128,0,32,32);
		Stairs = FurnitureBackroom.crop(0,288,32,32);
		StairsDown = FurnitureBackroom.crop(32,288,32,32);
		
		WorkDesk1 = Furniture3rdFloor.crop(0, 0, width*2, height);
//		WorkDesk2 = Furniture3rdFloor.crop(32, 0, width, height);
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
		MoverGag = walls.crop(5*width, 2*height, width, 3*height);
		
		Table0 = Furniture3rdFloor.crop(10*width, 0, width, height);
		Table1 = Furniture3rdFloor.crop(11*width, 0, width, height);
		Table2 = Furniture3rdFloor.crop(12*width, 0, width, height);
		Table3 = Furniture3rdFloor.crop(13*width, 0, width, height);
		Table4 = Furniture3rdFloor.crop(11*width, height, width, height);
		Table5 = Furniture3rdFloor.crop(12*width, height, width, height);
		Table6 = Furniture3rdFloor.crop(13*width, height, width, height);
		Table7 = Furniture3rdFloor.crop(11*width, 2*height, width, height);
		Table8 = Furniture3rdFloor.crop(12*width, 2*height, width, height);
		Table9 = Furniture3rdFloor.crop(13*width, 2*height, width, height);
		
		Mirror = Furniture3rdFloor.crop(0, 5*height, width, height);
		Toilet = Furniture3rdFloor.crop(width, 5*height, width, height);
		Sink = Furniture3rdFloor.crop(2*width, 5*height, width, height);
		MaleSign = Furniture3rdFloor.crop(3*width, 5*height, width, height);
		FemaleSign = Furniture3rdFloor.crop(4*width, 5*height, width, height);
		SinkMirror = Furniture3rdFloor.crop(5*width, 5*height, width, height*2);
		
		//arrows and stuff
		Uparrow=arrows.crop(90,12,12,12);
		Downarrow=arrows.crop(90,40,12,12);
		
		//skill+item mini-icons
		
		attack = ActionIcons.crop(0,0,32,32);
		skill = ActionIcons.crop(32,0,32,32);
		nothing = ActionIcons.crop(64,0,32,32);
		wait = ActionIcons.crop(96,0,32,32);
		item = ActionIcons.crop(128,0,32,32);
		run = ActionIcons.crop(160,0,32,32);
		pointer = ActionIcons.crop(256, 0, 32, 32);
		
		
		//Dialog loaded from text files.
		//File consists of first, a number equal to the number of dialog lines. update this when adding new lines
		//next, a long list of quadruplets containing the character's name that shows up in text boxes ("meep"=no name box)
		//then an image that serves as their talking sprite
		//after that,  a 1 or 0 to determine whether they stand on the left or right respectively
		//finally, the actual dialog of what they say. / indicates a skipping of line
		String file = Utils.loadFileAsString("/Text/DialogV2.txt");
		String[] tokens = file.split("\\r?\\n");
		dialog=new Dialog[Utils.parseInt(tokens[0])];
		for(int i = 0;i<Utils.parseInt(tokens[0]);i++){
			dialog[i]=new Dialog((tokens[4*i+1]),ImageLoader.loadImage("/CharacterBusts/"+tokens[4*i+2]),Utils.parseInt(tokens[4*i+3]),tokens[4*i+4]);
		}
		
		//Fonts
		try {
            //create the font to use. Specify the size!
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, Assets.class.getResourceAsStream("/Fonts/Chewy.ttf")).deriveFont(12f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            //register the font
            ge.registerFont(customFont);
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch(FontFormatException e)
        {
            e.printStackTrace();
        }
	}

}
