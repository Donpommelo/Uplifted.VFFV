package dev.zt.UpliftedVFFV.PenPalLetters;

public class Letter1Lachiplatre extends Letter{
	
	protected static String[] prompts = {"Lachiplatre","Lachiplatres"};
	boolean found;
	int id;
	public static String text = "Oh those things? The little bun-things, right? You have them too, right?"
			+ " I’ve always been under the impression that they’ve existed since the beginning of time. They’ve "
			+ "been everywhere for as long as I can remember. And when I say “been everywhere”, I mean, quite "
			+ "literally everywhere. Hell, I’m stranded in the middle of the ocean and I can’t throw a rock "
			+ "without hitting one or two. Not that there are any rocks in the middle of the ocean; just more"
			+ " lachiplatres.\nNormally, they just lie around, cluttering up the ground, and I’ve been stricken"
			+ " more than once by Lachiplatres falling from the sky. Eventually, though, the rain always comes"
			+ " to turn the lachiplatre into mush to be washed away.\nAnyways, a lachiplatre is a sort of folded"
			+ " bread-like food, stuffed with some kind of bland, dry paste. They are digestible, I guess, but "
			+ "I can’t really give them any more than that. And they are very nutritious, I assume, seeing as I"
			+ " have eaten nothing else for months and haven’t died yet.\nEach lachiplatre is precisely six"
			+ " inches in both width and length. Every specimen I’ve seen shared those exact measurements"
			+ " besides those that have been nibbled on by fishes. To see such artificial uniformity fall from"
			+ " the sky like cascades of rain or snow . . . I take it as divine will that starvation is not my"
			+ " intended method of dying.";
	public Letter1Lachiplatre(int id){
		super(prompts,id, text);
	}	

}
