package dev.zt.UpliftedVFFV.Decorations.decor;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.states.GameState;
import dev.zt.UpliftedVFFV.world.WorldManager;

//This manages Decorations. Decorations are cosmetic things that can be drawn anywhere and cannot be interacted with.
//Unlike events and tiles, the locations of Decorations are specified by the pixel for more precision.
//Decorations never block a player's path. If you want one to be solid, overlay it with a solid, invisible event (event0)


public class Decor {
	int id;
	static WorldManager world;
	protected static Game game;
	protected static GameState gamestate;
	protected BufferedImage tex;

	public static Decor[] decors = new Decor[256];
	public static Decor decorclock = new DecorClock(0);
	public static Decor decorbed = new DecorBed(1);
	public static Decor decorwritingdesk = new DecorWritingDesk(2);
	public static Decor decorkitchencounter = new DecorKitchenCounter(3);
	public static Decor decorcalendar = new DecorCalender(4);
	public static Decor decorpelicanfloor = new DecorElevatorPelican(5);
	public static Decor decorwallpanel = new DecorWallPanel(6);
	public static Decor decorsofa1 = new DecorSofa1(7);
	public static Decor decorsofa2 = new DecorSofa1(8);
	public static Decor table0 = new DecorTable0(9);
	public static Decor table1 = new DecorTable1(10);
	public static Decor table2 = new DecorTable2(11);
	public static Decor table3 = new DecorTable3(12);
	public static Decor table4 = new DecorTable4(13);
	public static Decor table5 = new DecorTable5(14);
	public static Decor table6 = new DecorTable6(15);
	public static Decor table7 = new DecorTable7(16);
	public static Decor table8 = new DecorTable8(17);
	public static Decor table9 = new DecorTable9(18);
	public static Decor trashcan = new DecorTrashCan(19);
	public static Decor horizrug = new DecorHorizRug(20);
	public static Decor welcomemat = new DecorWelcomeMat(21);
	public static Decor dresser = new DecorDresser(22);
	public static Decor hatrack = new DecorHatRack(23);
	public static Decor sign = new DecorSign(24);
	public static Decor vertirug = new DecorVertiRug(25);
	public static Decor fridge= new DecorFridge(26);
	public static Decor flowertable = new DecorFlowerTable(27);
	public static Decor cupboard = new DecorCupboard(28);
	public static Decor monolith= new DecorMonolith(29);
	public static Decor tallplant = new DecorTallPlant(30);
	public static Decor cautionsign = new DecorCuidadoSign(31);
	public static Decor stairsright0 = new DecorStairsRight0(32);
	public static Decor stairsright1 = new DecorStairsRight1(33);
	public static Decor stairsright2 = new DecorStairsRight2(34);
	public static Decor stairsright3 = new DecorStairsRight3(35);
	public static Decor stairsleft0 = new DecorStairsLeft0(36);
	public static Decor stairsleft1 = new DecorStairsLeft1(37);
	public static Decor stairsleft2 = new DecorStairsLeft2(38);
	public static Decor stairsleft3 = new DecorStairsLeft3(39);
	public static Decor announcementboard = new DecorAnnouncementBoard(40);
	public static Decor infopanel = new DecorInfoPanel(41);
	public static Decor poster1 = new DecorPoster1(42);
	public static Decor poster2 = new DecorPoster2(43);
	public static Decor projector = new DecorProjectorScreen(44);



	public Decor(Game g, GameState gs){
		game=g;
		gamestate=gs;
	}
	
	
	public Decor(BufferedImage texture, int idnum) {
		this.tex = texture;
		this.id = idnum;
		decors[id] = this;
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g, int x, int y) {
		g.drawImage(tex,x, y, tex.getWidth(), tex.getHeight(), null);
	}

	//Tex is the image that the Decoration is represented by.
	public BufferedImage getTex() {
		return tex;
	}
	
	public void setTex(BufferedImage tex) {
		this.tex = tex;
	}
	
	//Returns whether a decoration is rendered below the player. Most events are. Otherwise, override and return false to draw above player
	//as well as other events.
	public boolean renderBelow(){
		return true;
	}
}