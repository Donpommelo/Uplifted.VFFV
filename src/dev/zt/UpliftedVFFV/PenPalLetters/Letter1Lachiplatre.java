package dev.zt.UpliftedVFFV.PenPalLetters;

public class Letter1Lachiplatre extends Letter{
	
	protected static String[] prompts = {"Lachiplatre","Lachiplatres"};
	boolean found;
	int id;
	public static String text = "Oh those things? The little bun-things, right? You don・t have them there? That・s odd. They・ve been everywhere for as "
			+ "long as I can remember. And when I say ：been everywhere；, I mean, quite literally everywhere. Hell, I・m in the middle of "
			+ "the ocean and I can・t throw a rock without hitting one or two. Not that there are any rocks in the middle of the ocean; "
			+ "only more lachiplatres. Anyways, a lachiplatre is a sort of folded bread-like food, stuffed with some kind of bland paste. "
			+ "They・re digestible, I guess, but I can・t really give them any more than that. Normally, they just lie around, cluttering up"
			+ "the streets, but I・ve been stricken more than once by Lachiplatres falling from the sky. Sometimes it get so bad whole "
			+ "streets get buried and people can・t leave their houses. Eventually, though, the rain always comes to turn the lachiplatre"
			+ " into mush to be washed away. I guess I always took it for granted. Y・know, you got your rain and snow and then you got "
			+ "your Lachiplatre; it never really stuck out to me as strange. I don・t really know where all the Lachiplatre came from."
			+ " And nobody ever bothers to question it. It is taboo, I suppose, to question something that has supposedly done a lot of"
			+ " good in the past.";
	public Letter1Lachiplatre(int id){
		super(prompts,id, text);
	}	

}
