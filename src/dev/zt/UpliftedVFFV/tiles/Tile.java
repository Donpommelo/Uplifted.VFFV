package dev.zt.UpliftedVFFV.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;


//Controls tiles. Sets up every tile in the game. Tiles consist of an image and a id that is called whenever we want to use that tile
//each individual type of tile extends this class.
//tiles are all 32 x 32 pixels, but most of the images are 64 x 96.
//This is why each tile in the list below takes 2 variables. The first is the aforementioned id and the second is region of the larger 
//image that we actually want. This is done through the TileSorter.
public class Tile {
		
	public static final int TILEWIDTH = 32, TILEHEIGHT = 32;
	
	//texture is the 64 by 96 spritesheet for the tile
	protected BufferedImage texture;
	
	//tex1,2,3,4 are the 4 16 by 16  squares that make up the 32 by 32 tile that is displayed.
	public BufferedImage tex1, tex2, tex3, tex4;
	
	protected final int id;
		
	public Tile(BufferedImage texture, int id){
		this.texture = texture;
		this.id = id;
	}
	
	public static Tile getTile(int tileId){
		Tile t = new White();
		switch(tileId){
		case 0:
			t = new Black();
			break;
		case 1:
			t = new VoidTile();
			break;
		case 2:
			t = new WoodBoard();
			break;
		case 3:
			t = new WhiteSquareTile();
			break;
		case 4:
			t = new RedLobbyCarpet();
			break;
		case 5:
			t = new BlueCarpet();
			break;
		case 6:
			t = new AquaTile();
			break;
		case 7:
			t = new StoneFloor();
			break;
		case 8:
			t = new ElevatorCeiling();
			break;
		case 9:
			t = new ElevatorWalls();
			break;
		case 10:
			t = new Ceiling1();
			break;
		case 11:
			t = new Wall1();
			break;
		case 12:
			t = new Ceiling2();
			break;
		case 13:
			t = new Wall2();
			break;
		case 14:
			t = new GreyRowCarpet();
			break;
		case 15:
			t = new WhiteCarpet();
			break;
		case 16:
			t = new OfficeCeiling();
			break;
		case 17:
			t = new OfficeWalls();
			break;
		case 18:
			t = new StairsUp();
			break;
		case 19:
			t = new StairsDown();
			break;
		case 20:
			t = new StairsRight();
			break;
		case 21:
			t = new StairsLeft();
			break;
		case 22:
			t = new LobbyCeiling();
			break;
		case 23:
			t = new LobbyWalls();
			break;
		case 24:
			t = new GlassTile();
			break;
		case 25:
			t = new BlueSquareCarpet();
			break;
		case 26:
			t = new BlueDiagCarpet();
			break;
		case 27:
			t = new CircleCarpet();
			break;
		case 28:
			t = new SandTile();
			break;
		case 29:
			t = new DarkSandTile();
			break;
		case 30:
			t = new BlackCeiling();
			break;
		case 31:
			t = new BlackWalls();
			break;
		case 32:
			t = new AquariumCeiling();
			break;
		case 33:
			t = new AquariumWalls();
			break;
		case 34:
			t = new GreyCeiling();
			break;
		case 35:
			t = new GreyWalls();
			break;
		case 36:
			t = new SandGroundTile();
			break;
		case 37:
			t = new DarkSandGroundTile();
			break;
		case 38:
			t = new BlueSquareSolidCarpet();
			break;
		case 39:
			t = new GreyGroutTile();
			break;
		case 40:
			t = new GreySquareCarpet();
			break;
		case 41:
			t = new DarkRowCarpet();
			break;
		case 42:
			t = new White();
			break;
		case 43:
			t = new Steel();
			break;
		case 44:
			t = new Asphalt();
			break;
		case 45:
			t = new BlueGreyCarpet();
			break;
		case 46:
			t = new WeirdCarpet();
			break;
		case 47:
			t = new PaleMarble();
			break;
		case 48:
			t = new AlternatingTile();
			break;
		case 49:
			t = new Brick();
			break;
		case 50:
			t = new YellowCarpet();
			break;
		case 51:
			t = new Grass();
			break;
		case 52:
			t = new PurpleElevator();
			break;
		case 53:
			t = new GreenElevator();
			break;
		case 54:
			t = new RedElevator();
			break;
		case 55:
			t = new YellowElevator();
			break;
		}
		return t;
	}
	
	public void tick(){
		
	}
	
	public void render(Graphics g, int x, int y){
		g.drawImage(this.tex1, x, y, TILEWIDTH/2, TILEHEIGHT/2, null);
		g.drawImage(this.tex2, x+TILEWIDTH/2, y, TILEWIDTH/2, TILEHEIGHT/2, null);
		g.drawImage(this.tex3, x, y+TILEWIDTH/2, TILEWIDTH/2, TILEHEIGHT/2, null);
		g.drawImage(this.tex4, x+TILEWIDTH/2, y+TILEWIDTH/2, TILEWIDTH/2, TILEHEIGHT/2, null);

	}
	
	public Boolean equals(Tile otherTile){
		if(otherTile.id == this.id){
			return true;
		}
		return false;
	}
		
	//determines if a tile can be walked through or not. default is no.
	public boolean isSolid(){
		return false;
	}
	
	//returns whether the tile is a wall tile or not.
	public boolean isWall(){
		return false;
	}
	
	//returns whether enemies can be encountered on this square or not. Default is yes.
	public boolean enemyEncounter(){
		return true;
	}
	
	public int getId(){
		return id;
	}
	
	//Returns whether a square will make the player walked across diagonally (Used in side stairs)
	// 1: Side Stairs with positive slope
	// -1: Side Stairs with negative slope.
	public int isDiagMove(){
		return 0;
	}
	
	//Sound played when stepping into this tile.
	public String stepSound(){
		return "i'll finish coding this later";
	}	

	public BufferedImage getTex1() {
		return tex1;
	}

	public void setTex1(BufferedImage tex1) {
		this.tex1 = tex1;
	}

	public BufferedImage getTex2() {
		return tex2;
	}

	public void setTex2(BufferedImage tex2) {
		this.tex2 = tex2;
	}

	public BufferedImage getTex3() {
		return tex3;
	}

	public void setTex3(BufferedImage tex3) {
		this.tex3 = tex3;
	}

	public BufferedImage getTex4() {
		return tex4;
	}

	public void setTex4(BufferedImage tex4) {
		this.tex4 = tex4;
	}

}
