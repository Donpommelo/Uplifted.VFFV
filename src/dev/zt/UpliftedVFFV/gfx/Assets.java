package dev.zt.UpliftedVFFV.gfx;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.utils.Utils;

public class Assets {
	
	private static final int width = 32, height = 32;
	
	public static BufferedImage Wall1, Wall2, Ceiling1, Ceiling2, ElevatorCeiling, ElevatorDoorWall,ElevatorWall;
	public static BufferedImage White, Black, Void, BlackTile,CheckerTile,AquaTile,RedCarpet,WoodBoard,StoneFloor,BlueDiagonal,PelicanPlate,WhiteTile, GlassTile,BlueCarpet,CheckerCarpet, DiagCarpet,CircleCarpet,RowCarpet;
	public static BufferedImage ElevatorPanel;
	public static BufferedImage Operator,PenPal,EmployeeM1,EmployeeM2,EmployeeF;
	public static BufferedImage ElevatorDoor1,ElevatorDoor2,ElevatorDoor3,ElevatorDoor4;
	public static BufferedImage Uparrow,Downarrow;
	public static Dialog[] dialog;
	
	
	
	
	public static void init(){
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/WalkingSprites.png"));
		SpriteSheet floor = new SpriteSheet(ImageLoader.loadImage("/textures/ElevatorFloor.png"));
		SpriteSheet walls = new SpriteSheet(ImageLoader.loadImage("/textures/ElevatorWalls.png"));
		SpriteSheet prop=new SpriteSheet(ImageLoader.loadImage("/textures/ElevatorProps.png"));
		SpriteSheet arrows=new SpriteSheet(ImageLoader.loadImage("/textures/WindowPaper.png"));
		SpriteSheet door =new SpriteSheet(ImageLoader.loadImage("/textures/BlueElevatorDoor.png"));
	
		Operator=sheet.crop(0, 0, 3*width, 4*height);
		PenPal=sheet.crop(3*width, 0, 3*width, 4*height);
		EmployeeM1=sheet.crop(6*width, 0, 3*width, 4*height);
		EmployeeF=sheet.crop(9*width, 0, 3*width, 4*height);
		EmployeeM2=sheet.crop(0, 4*height, 3*width, 4*height);
		
		ElevatorDoor1=door.crop(16, 0, 64, 64);
		ElevatorDoor2=door.crop(16, 64, 64, 64);
		ElevatorDoor3=door.crop(16, 128, 64, 64);
		ElevatorDoor4=door.crop(16, 192, 64, 64);
		
		ElevatorPanel = prop.crop(7*width,0,width,height);
	
		White = floor.crop(0, 0, width, height);
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
		
		Uparrow=arrows.crop(90,12,12,12);
		Downarrow=arrows.crop(90,40,12,12);
		
		String file = Utils.loadFileAsString("res/Text/DialogV2.txt");
		String[] tokens = file.split("\\r?\\n");
		dialog=new Dialog[Utils.parseInt(tokens[0])];
		for(int i = 0;i<Utils.parseInt(tokens[0]);i++){
			dialog[i]=new Dialog((tokens[4*i+1]),ImageLoader.loadImage("/CharacterBusts/"+tokens[4*i+2]),Utils.parseInt(tokens[4*i+3]),tokens[4*i+4]);
		}
	}

}
