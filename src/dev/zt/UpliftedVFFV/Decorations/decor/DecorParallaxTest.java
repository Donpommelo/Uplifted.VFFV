package dev.zt.UpliftedVFFV.Decorations.decor;

import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.gfx.ImageLoader;

public class DecorParallaxTest extends Decor{

	public DecorParallaxTest(int idnum) {
		super(ImageLoader.loadImage("/CharacterBusts/3rdSouthOffices-5.png"), idnum);
	}
	
	public int renderBelow(){
		return -2;
	}
	
	public double parallaxMultX(){
		return 0.9;
	}

}
