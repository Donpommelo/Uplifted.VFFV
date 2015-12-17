package dev.zt.UpliftedVFFV.Decorations.decor;

import dev.zt.UpliftedVFFV.events.SpriteSorter;
import dev.zt.UpliftedVFFV.gfx.Assets;

public class DecorEmployeePlant extends Decor{

	public DecorEmployeePlant(int idnum) {
		super(SpriteSorter.SpriteSort(10,Assets.PenPal), idnum);
	}

}
