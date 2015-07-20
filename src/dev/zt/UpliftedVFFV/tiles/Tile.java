package dev.zt.UpliftedVFFV.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;


//Controls tiles. Sets up every tile in the game. Tiles consist of an image and a id that is called whenever we want to use that tile
//each individual type of tile extends this class.
//tiles are all 32 x 32 pixels, but most of the images are 64 x 96.
//This is why each tile in the list below takes 2 variables. The first is the aforementioned id and the second is region of the larger 
//image that we actually want. This is done through the TileSorter.
public class Tile {
	
	//When each of these tiles are created, they each run super(their image,their id)
	//This not only creates them, but also adds them to the list of tiles
	public static Tile[] tiles = new Tile[512];
	public static Tile white = new White(0);
	public static Tile black = new Black(1);
	public static Tile Void = new VoidTile(2);
	public static Tile BlackTile0 = new BlackTile(3,0);
	public static Tile BlackTile1 = new BlackTile(4,1);
	public static Tile BlackTile2 = new BlackTile(5,2);
	public static Tile BlackTile3 = new BlackTile(6,3);
	public static Tile BlackTile4 = new BlackTile(7,4);
	public static Tile BlackTile5 = new BlackTile(8,5);
	public static Tile BlackTile6 = new BlackTile(9,6);
	public static Tile BlackTile7 = new BlackTile(10,7);
	public static Tile BlackTile8 = new BlackTile(11,8);
	public static Tile BlackTile9 = new BlackTile(12,9);
	public static Tile BlackTile10 = new BlackTile(13,10);
	public static Tile CheckerTile0 = new CheckerTile(14,0);
	public static Tile CheckerTile1 = new CheckerTile(15,1);
	public static Tile CheckerTile2 = new CheckerTile(16,2);
	public static Tile CheckerTile3 = new CheckerTile(17,3);
	public static Tile CheckerTile4 = new CheckerTile(18,4);
	public static Tile CheckerTile5 = new CheckerTile(19,5);
	public static Tile CheckerTile6 = new CheckerTile(20,6);
	public static Tile CheckerTile7 = new CheckerTile(21,7);
	public static Tile CheckerTile8 = new CheckerTile(22,8);
	public static Tile CheckerTile9 = new CheckerTile(23,9);
	public static Tile CheckerTile10 = new CheckerTile(24,10);
	public static Tile RedCarpet0 = new RedCarpet(25,0);
	public static Tile RedCarpet1 = new RedCarpet(26,1);
	public static Tile RedCarpet2 = new RedCarpet(27,2);
	public static Tile RedCarpet3 = new RedCarpet(28,3);
	public static Tile RedCarpet4 = new RedCarpet(29,4);
	public static Tile RedCarpet5 = new RedCarpet(30,5);
	public static Tile RedCarpet6 = new RedCarpet(31,6);
	public static Tile RedCarpet7 = new RedCarpet(32,7);
	public static Tile RedCarpet8 = new RedCarpet(33,8);
	public static Tile RedCarpet9 = new RedCarpet(34,9);
	public static Tile RedCarpet10 = new RedCarpet(35,10);
	public static Tile WoodBoard0 = new WoodBoard(36,0);
	public static Tile WoodBoard1 = new WoodBoard(37,1);
	public static Tile WoodBoard2 = new WoodBoard(38,2);
	public static Tile WoodBoard3 = new WoodBoard(39,3);
	public static Tile WoodBoard4 = new WoodBoard(40,4);
	public static Tile WoodBoard5 = new WoodBoard(41,5);
	public static Tile WoodBoard6 = new WoodBoard(42,6);
	public static Tile WoodBoard7 = new WoodBoard(43,7);
	public static Tile WoodBoard8 = new WoodBoard(44,8);
	public static Tile WoodBoard9 = new WoodBoard(45,9);
	public static Tile WoodBoard10 = new WoodBoard(46,10);
	public static Tile BlueCarpet0 = new BlueCarpet(47,0);
	public static Tile BlueCarpet1 = new BlueCarpet(48,1);
	public static Tile BlueCarpet2 = new BlueCarpet(49,2);
	public static Tile BlueCarpet3 = new BlueCarpet(50,3);
	public static Tile BlueCarpet4 = new BlueCarpet(51,4);
	public static Tile BlueCarpet5 = new BlueCarpet(52,5);
	public static Tile BlueCarpet6 = new BlueCarpet(53,6);
	public static Tile BlueCarpet7 = new BlueCarpet(54,7);
	public static Tile BlueCarpet8 = new BlueCarpet(55,8);
	public static Tile BlueCarpet9 = new BlueCarpet(56,9);
	public static Tile BlueCarpet10 = new BlueCarpet(57,10);
	public static Tile RowCarpet0 = new RowCarpet(58,0);
	public static Tile RowCarpet1 = new RowCarpet(59,1);
	public static Tile RowCarpet2 = new RowCarpet(60,2);
	public static Tile RowCarpet3 = new RowCarpet(61,3);
	public static Tile RowCarpet4 = new RowCarpet(62,4);
	public static Tile RowCarpet5 = new RowCarpet(63,5);
	public static Tile RowCarpet6 = new RowCarpet(64,6);
	public static Tile RowCarpet7 = new RowCarpet(65,7);
	public static Tile RowCarpet8 = new RowCarpet(66,8);
	public static Tile RowCarpet9 = new RowCarpet(67,9);
	public static Tile RowCarpet10 = new RowCarpet(68,10);
	public static Tile StoneFloor0 = new StoneFloor(69,0);
	public static Tile StoneFloor1 = new StoneFloor(70,1);
	public static Tile StoneFloor2 = new StoneFloor(71,2);
	public static Tile StoneFloor3 = new StoneFloor(72,3);
	public static Tile StoneFloor4 = new StoneFloor(73,4);
	public static Tile StoneFloor5 = new StoneFloor(74,5);
	public static Tile StoneFloor6 = new StoneFloor(75,6);
	public static Tile StoneFloor7 = new StoneFloor(76,7);
	public static Tile StoneFloor8 = new StoneFloor(77,8);
	public static Tile StoneFloor9 = new StoneFloor(78,9);
	public static Tile StoneFloor10 = new StoneFloor(79,10);
	public static Tile GlassTile0 = new GlassTile(80,0);
	public static Tile GlassTile1 = new GlassTile(81,1);
	public static Tile GlassTile2 = new GlassTile(82,2);
	public static Tile GlassTile3 = new GlassTile(83,3);
	public static Tile GlassTile4 = new GlassTile(84,4);
	public static Tile GlassTile5 = new GlassTile(85,5);
	public static Tile GlassTile6 = new GlassTile(86,6);
	public static Tile GlassTile7 = new GlassTile(87,7);
	public static Tile GlassTile8 = new GlassTile(88,8);
	public static Tile GlassTile9 = new GlassTile(89,9);
	public static Tile GlassTile10 = new GlassTile(90,10);
	
	public static Tile DiagCarpet1 = new DiagCarpet(91,0);
	public static Tile DiagCarpet2 = new DiagCarpet(92,1);
	
	public static Tile AquaTile0 = new AquaTile(93,0);
	public static Tile AquaTile1 = new AquaTile(94,1);
	public static Tile AquaTile2 = new AquaTile(95,2);
	public static Tile AquaTile3 = new AquaTile(96,3);
	public static Tile AquaTile4 = new AquaTile(97,4);
	public static Tile AquaTile5 = new AquaTile(98,5);
	public static Tile AquaTile6 = new AquaTile(99,6);
	public static Tile AquaTile7 = new AquaTile(100,7);
	public static Tile AquaTile8 = new AquaTile(101,8);
	public static Tile AquaTile9 = new AquaTile(102,9);
	public static Tile AquaTile10 = new AquaTile(103,10);
	
	public static Tile Wall10 = new Wall1(113,0);
	public static Tile Wall11 = new Wall1(114,1);
	public static Tile Wall12 = new Wall1(115,2);
	public static Tile Wall13 = new Wall1(116,3);
	public static Tile Wall14 = new Wall1(117,4);
	public static Tile Wall15 = new Wall1(118,5);
	public static Tile Wall16 = new Wall1(119,6);
	public static Tile Wall17 = new Wall1(120,7);
	public static Tile Wall18 = new Wall1(121,8);
	public static Tile Wall19 = new Wall1(122,9);
	public static Tile Wall110 = new Wall1(123,10);
	public static Tile Ceiling10 = new Ceiling1(124,0);
	public static Tile Ceiling11 = new Ceiling1(125,1);
	public static Tile Ceiling12 = new Ceiling1(126,2);
	public static Tile Ceiling13 = new Ceiling1(127,3);
	public static Tile Ceiling14 = new Ceiling1(128,4);
	public static Tile Ceiling15 = new Ceiling1(129,5);
	public static Tile Ceiling16 = new Ceiling1(130,6);
	public static Tile Ceiling17 = new Ceiling1(131,7);
	public static Tile Ceiling18 = new Ceiling1(132,8);
	public static Tile Ceiling19 = new Ceiling1(133,9);
	public static Tile Ceiling110 = new Ceiling1(134,10);
	public static Tile ElevatorWall0 = new ElevatorWall(135,0);
	public static Tile ElevatorWall1 = new ElevatorWall(136,1);
	public static Tile ElevatorWall2 = new ElevatorWall(137,2);
	public static Tile ElevatorWall3 = new ElevatorWall(138,3);
	public static Tile ElevatorWall4 = new ElevatorWall(139,4);
	public static Tile ElevatorWall5 = new ElevatorWall(140,5);
	public static Tile ElevatorWall6 = new ElevatorWall(141,6);
	public static Tile ElevatorWall7 = new ElevatorWall(142,7);
	public static Tile ElevatorWall8 = new ElevatorWall(143,8);
	public static Tile ElevatorWall9 = new ElevatorWall(144,9);
	public static Tile ElevatorWall10 = new ElevatorWall(145,10);
	public static Tile ElevatorCeiling0 = new ElevatorCeiling(146,0);
	public static Tile ElevatorCeiling1 = new ElevatorCeiling(147,1);
	public static Tile ElevatorCeiling2 = new ElevatorCeiling(148,2);
	public static Tile ElevatorCeiling3 = new ElevatorCeiling(149,3);
	public static Tile ElevatorCeiling4 = new ElevatorCeiling(150,4);
	public static Tile ElevatorCeiling5 = new ElevatorCeiling(151,5);
	public static Tile ElevatorCeiling6 = new ElevatorCeiling(152,6);
	public static Tile ElevatorCeiling7 = new ElevatorCeiling(153,7);
	public static Tile ElevatorCeiling8 = new ElevatorCeiling(154,8);
	public static Tile ElevatorCeiling9 = new ElevatorCeiling(155,9);
	public static Tile ElevatorCeiling10 = new ElevatorCeiling(156,10);
	public static Tile ElevatorDoorWall0 = new ElevatorDoorWall(157,0);
	public static Tile ElevatorDoorWall1 = new ElevatorDoorWall(158,1);
	public static Tile ElevatorDoorWall2 = new ElevatorDoorWall(159,2);
	public static Tile ElevatorDoorWall3 = new ElevatorDoorWall(160,3);
	public static Tile ElevatorDoorWall4 = new ElevatorDoorWall(161,4);
	public static Tile ElevatorDoorWall5 = new ElevatorDoorWall(162,5);
	public static Tile ElevatorDoorWall6 = new ElevatorDoorWall(163,6);
	public static Tile ElevatorDoorWall7 = new ElevatorDoorWall(164,7);
	public static Tile ElevatorDoorWall8 = new ElevatorDoorWall(165,8);
	public static Tile ElevatorDoorWall9 = new ElevatorDoorWall(166,9);
	public static Tile ElevatorDoorWall10 = new ElevatorDoorWall(167,10);
	public static Tile Wall20 = new Wall2(168,0);
	public static Tile Wall21 = new Wall2(169,1);
	public static Tile Wall22 = new Wall2(170,2);
	public static Tile Wall23 = new Wall2(171,3);
	public static Tile Wall24 = new Wall2(172,4);
	public static Tile Wall25 = new Wall2(173,5);
	public static Tile Wall26 = new Wall2(174,6);
	public static Tile Wall27 = new Wall2(175,7);
	public static Tile Wall28 = new Wall2(176,8);
	public static Tile Wall29 = new Wall2(177,9);
	public static Tile Wall210 = new Wall2(178,10);
	public static Tile Ceiling20 = new Ceiling2(179,0);
	public static Tile Ceiling21 = new Ceiling2(180,1);
	public static Tile Ceiling22 = new Ceiling2(181,2);
	public static Tile Ceiling23 = new Ceiling2(182,3);
	public static Tile Ceiling24 = new Ceiling2(183,4);
	public static Tile Ceiling25 = new Ceiling2(184,5);
	public static Tile Ceiling26 = new Ceiling2(185,6);
	public static Tile Ceiling27 = new Ceiling2(186,7);
	public static Tile Ceiling28 = new Ceiling2(187,8);
	public static Tile Ceiling29 = new Ceiling2(188,9);
	public static Tile Ceiling210 = new Ceiling2(189,9);
	public static Tile ActuallyWhite = new ActuallyWhite(190);
	
	public static Tile CircleTile = new CircleCarpet(191,0);
	public static Tile Stairs = new StairsTile(192,0);
	public static Tile StairsDown = new StairsDownTile(193,0);
	public static Tile WhiteTile = new WhiteTile(194,0);
	public static Tile StairsSide1 = new StairsSide1(195,0);
	public static Tile StairsSide2 = new StairsSide2(196,0);

	public static final int TILEWIDTH = 32, TILEHEIGHT = 32;
	
	protected BufferedImage texture;
	protected final int id;
	
	//this is run every time a type of tile is created. They are added to the tiles array. Their index in the list=their id
	public Tile(BufferedImage texture, int id){
		this.texture = texture;
		this.id = id;
		
		tiles[id] = this;
	}
	
	public void tick(){
		
	}
	
	public void render(Graphics g, int x, int y){
		g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
	}
	
	//determines if a tile can be walked through or not. default is no.
	public boolean isSolid(){
		return false;
	}
	
	public int getId(){
		return id;
	}
	
	public int isDiagMove(){
		return 0;
	}
	

}
