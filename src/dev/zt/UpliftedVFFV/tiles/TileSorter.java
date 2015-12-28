package dev.zt.UpliftedVFFV.tiles;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.gfx.SpriteSheet;
import dev.zt.UpliftedVFFV.world.WorldManager;

public class TileSorter {
	
	static SpriteSheet meep;
	static BufferedImage merp;
	static SpriteSheet spritesheet;
	static int miniLength = 16;
	//this cuts a 64 x 96 spritesheet into a single 32 x32 tile.
	//the numbers input, 0-10 correspond to specific regions of the larger spritesheet
	
	public TileSorter(){
		
	}
	
	public static void adjacencyCheck(Tile tile, WorldManager world, int x, int y){
		if(tile.texture != Assets.Void){
			spritesheet = new SpriteSheet(tile.texture);
			if(world.getTile(x-1, y).id != tile.id && world.getTile(x, y-1).id != tile.id){
				tile.setTex1(spritesheet.crop(0, 2*miniLength, miniLength, miniLength));
			}
			else{
				if(world.getTile(x-1, y).id != world.getTile(x, y-1).id){
					if(world.getTile(x-1, y).id == tile.id){
						tile.setTex1(spritesheet.crop(2*miniLength, 2*miniLength, miniLength, miniLength));
					}
					else{
						tile.setTex1(spritesheet.crop(0, 4*miniLength, miniLength, miniLength));
					}
				}
				else{
					if(world.getTile(x-1, y-1).id == tile.id){
						tile.setTex1(spritesheet.crop(2*miniLength, 4*miniLength, miniLength, miniLength));
					}
					else{
						tile.setTex1(spritesheet.crop(2*miniLength, 0, miniLength, miniLength));
					}
				}
			}
			
			if(world.getTile(x+1, y).id != tile.id && world.getTile(x, y-1).id != tile.id){
				tile.setTex2(spritesheet.crop(3*miniLength, 2*miniLength, miniLength, miniLength));
			}
			else{
				if(world.getTile(x+1, y).id != world.getTile(x, y-1).id){
					if(world.getTile(x+1, y).id == tile.id){
						tile.setTex2(spritesheet.crop(miniLength, 2*miniLength, miniLength, miniLength));
					}
					else{
						tile.setTex2(spritesheet.crop(3*miniLength, 4*miniLength, miniLength, miniLength));
					}
				}
				else{
					if(world.getTile(x+1, y-1).id == tile.id){
						tile.setTex2(spritesheet.crop(1*miniLength, 4*miniLength, miniLength, miniLength));
					}
					else{
						tile.setTex2(spritesheet.crop(3*miniLength, 0, miniLength, miniLength));
					}
				}
			}
			
			if(world.getTile(x-1, y).id != tile.id && world.getTile(x, y+1).id != tile.id){
				tile.setTex3(spritesheet.crop(0, 5*miniLength, miniLength, miniLength));
			}
			else{
				if(world.getTile(x-1, y).id != world.getTile(x, y+1).id){
					if(world.getTile(x-1, y).id == tile.id){
						tile.setTex3(spritesheet.crop(2*miniLength, 5*miniLength, miniLength, miniLength));
					}
					else{
						tile.setTex3(spritesheet.crop(0, 3*miniLength, miniLength, miniLength));
					}
				}
				else{
					if(world.getTile(x-1, y+1).id == tile.id){
						tile.setTex3(spritesheet.crop(2*miniLength, 3*miniLength, miniLength, miniLength));
					}
					else{
						tile.setTex3(spritesheet.crop(2*miniLength, miniLength, miniLength, miniLength));
					}
				}
			}
			
			if(world.getTile(x+1, y).id != tile.id && world.getTile(x, y+1).id != tile.id){
				tile.setTex4(spritesheet.crop(3*miniLength, 5*miniLength, miniLength, miniLength));
			}
			else{
				if(world.getTile(x+1, y).id != world.getTile(x, y+1).id){
					if(world.getTile(x+1, y).id == tile.id){
						tile.setTex4(spritesheet.crop(miniLength, 5*miniLength, miniLength, miniLength));
					}
					else{
						tile.setTex4(spritesheet.crop(3*miniLength, 3*miniLength, miniLength, miniLength));
					}
				}
				else{
					if(world.getTile(x+1, y+1).id == tile.id){
						tile.setTex4(spritesheet.crop(miniLength, 3*miniLength, miniLength, miniLength));
					}
					else{
						tile.setTex4(spritesheet.crop(3*miniLength, miniLength, miniLength, miniLength));
					}
				}
			}
	
		}
	}
	
	public static void adjacencyWallCheck(Tile tile, WorldManager world, int x, int y){
		if(tile.texture != Assets.Void){
			spritesheet = new SpriteSheet(tile.texture);
			int height = y;
			while(world.getTile(x, height-1).id == tile.id){
				height--;
			}
			
			if(world.getTile(x-1, height).id == tile.id){
				if(world.getTile(x, y-1).isWall()){
					tile.setTex1(spritesheet.crop(2*miniLength, 2*miniLength, miniLength, miniLength));
				}
				else{
					tile.setTex1(spritesheet.crop(2*miniLength, 0, miniLength, miniLength));
				}
			}
			else{
				if(world.getTile(x, y-1).isWall()){
					tile.setTex1(spritesheet.crop(0, 2*miniLength, miniLength, miniLength));
				}
				else{
					tile.setTex1(spritesheet.crop(0, 0, miniLength, miniLength));
				}
			}
			
			if(world.getTile(x+1, height).id == tile.id){
				if(world.getTile(x, y-1).isWall()){
					tile.setTex2(spritesheet.crop(1*miniLength, 2*miniLength, miniLength, miniLength));
				}
				else{
					tile.setTex2(spritesheet.crop(1*miniLength, 0, miniLength, miniLength));
				}
			}
			else{
				if(world.getTile(x, y-1).isWall()){
					tile.setTex2(spritesheet.crop(3*miniLength, 2*miniLength, miniLength, miniLength));
				}
				else{
					tile.setTex2(spritesheet.crop(3*miniLength, 0, miniLength, miniLength));
				}
			}
			
			if(world.getTile(x-1, height).id == tile.id){
				if(world.getTile(x, y+1).isWall()){
					tile.setTex3(spritesheet.crop(2*miniLength, 1*miniLength, miniLength, miniLength));
				}
				else{
					tile.setTex3(spritesheet.crop(2*miniLength, 3*miniLength, miniLength, miniLength));
				}
			}
			else{
				if(world.getTile(x, y+1).isWall()){
					tile.setTex3(spritesheet.crop(0, 1*miniLength, miniLength, miniLength));
				}
				else{
					tile.setTex3(spritesheet.crop(0, 3*miniLength, miniLength, miniLength));
				}
			}
			
			if(world.getTile(x+1, height).id == tile.id){
				if(world.getTile(x, y+1).isWall()){
					tile.setTex4(spritesheet.crop(1*miniLength, 1*miniLength, miniLength, miniLength));
				}
				else{
					tile.setTex4(spritesheet.crop(1*miniLength, 3*miniLength, miniLength, miniLength));
				}
			}
			else{
				if(world.getTile(x, y+1).isWall()){
					tile.setTex4(spritesheet.crop(3*miniLength, 1*miniLength, miniLength, miniLength));
				}
				else{
					tile.setTex4(spritesheet.crop(3*miniLength, 3*miniLength, miniLength, miniLength));
				}
			}		
			
		}
	}
}
