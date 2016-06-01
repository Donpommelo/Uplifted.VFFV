package dev.zt.UpliftedVFFV.ablities;

public class ActuallyNothing extends Skills {
	
	//This move does actually nothing, not even give a message.
	//This move is used by enemies if the enemy is incapacitated or if the player party has no valid targets.
	//The aforementioned scenario shouldn't ever really happen, but oh well.
	
	public ActuallyNothing(int index) {
		super(index, 1,6, "", "", "", 0,0,0,false,false);

	}
	
}
