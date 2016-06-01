package dev.zt.UpliftedVFFV.PenPalLetters;

public class Letter0Test extends Letter{
	
	protected static String[] prompts = {"BODARDUSTHEBIGNIFICANTSBARGAINBAGELBODEGA"};
	boolean found;
	int id;
	public static String text = "Letter Testing";
	public Letter0Test(int id){
		super(prompts,id, text);
	}
	
	public String getLetter(){
		int meep  = (int)(Math.random()*9);
		switch (meep){
		case 0:
			return "Sorry, but I don't have enough to say about that topic to warrant sending a whole letter.";
		case 1:
			return "Sorry, but I think if I talked to you about that, I might create some sort of terrible time paradox.";
		case 2:
			return "Sorry, but whatever you're talking about, it has probably been abolished by my time.";
		case 3:
			return "Sorry, but I don't really know what you mean. Maybe it doens't exist anymore.";
		case 4:
			return "Sorry, but whatever you're talking about, it has probably been abolished by my time.";
		case 5:
			return "Sorry, but I don't what that is. Must've gone extinct or something.";
		case 6:
			return "Hmm. That sounds familiar, but I can't quite remember what it is.";
		case 7:
			return "Two gallons of milk, one dozen eggs, asparagus, cuttlefish, one pack of Lachiplatre.";
		case 8:
			return "I'm pretty sure some of those words you are using have been abolished so I can't understand you.";
		}
		return "Eh. . . What's that?";
	}

}
