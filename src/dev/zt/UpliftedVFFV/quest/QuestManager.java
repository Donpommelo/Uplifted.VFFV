package dev.zt.UpliftedVFFV.quest;

import dev.zt.UpliftedVFFV.Game;

public class QuestManager {

	public Game game;
	public int[] quests= new int[50];
	
/*
 0: Find Suite 521
 1: Tutorial Quest
 2: Explore
 3: Informant's Quest
 4: Emaudeline's Quest
 5: Carloc's Quest
 6: <>
 7: Floor Manager's Quest
 8: Ringmaster's Quest
 9: Central Elevator Quest
 10: Pen Pal's Food reQuest
 11: Lachiplatreland Quest
 12: Foreman's Quest
 13: Processing Plant Quest
 14: Premium Examination Quest
 15: 
 16: 
 17: 
 
 */
	
	public QuestManager(Game g){
		this.game = g;
		for(int i = 0; i < quests.length; i++){
			quests[i] = 0;
		}
	}
	
	public int getQuest(int i){
		return quests[i];
	}
	
	public void setQuest(int i, int set){
		quests[i] = set;
	}
	
	public String getObjective(int quest, int stage){
		switch(quest){
		case 0:
			return "Find Suite 521.";
		case 1:
			switch(stage){
			case 1:
				return "Look for someone knowledgeable in the Offices.";
			case 2:
				return "Look for Jorge, in the Mailroom.";
			case 4:
				return "Explore the rest of the Offices.";
			}
		case 2:
			return "Explore the building in search of clues.";
		case 3:
			switch(stage){
			case 1:
				return "Return to the Informant.";
			case 2:
				return "";
			case 3:
				return "Find the Old Greeter Machine in Lachiplatre Land.";
			case 4:
				return "Bring the Umbrella to the Informant.";
			case 5:
				return "";
			}
		case 4:
			switch(stage){
			case 1:
				return "Help Emaudeline find the Central Light.";
			}
		case 5:
			switch(stage){
			case 1:
				return "Find the Informant in the East Offices";
			case 2:
				return "Find the Informant in the East Offices";
			case 3:
				return "Find the Informant in the East Offices";
			case 4:
				return "Return the Envelope to Carloc";
			case 5:
				return "Deliver the Envelope to Speros in the West Offices.";
			case 6:
				return "Return to Carloc in the East Offices for your reward.";
			}
		case 7:
			switch(stage){
			case 1:
				return "Fetch Floor manager his Coffee.";
			case 2:
				return "Bring the 'Coffee' back to Floor Manager.";
			}
		case 8:
			switch(stage){
			case 1:
				return "Find the Dolphin Strikebreaker.";
			case 2:
				return "Return to the Ringmaster for your reward.";
			}
		case 9:
			switch(stage){
			case 1:
				return "Rebuild the central elevator";
			}
		case 10:
			switch(stage){
			case 1:
				return "Get your Pen Pal some Crystal Dumplings";
			case 2:
				return "Get your Pen Pal some Watercress Soup";
			case 3:
				return "Get your Pen Pal a Blue Fruit Juice";
			}
		case 11:
			switch(stage){
			case 1:
				return "Find a Lachiplatre to get into the Backroom.";
			case 2:
				return "Return to the Security Guard with the Lachiplatre";
			}
		case 12:
			switch(stage){
			case 1:
				return "Look for the Tainted Lachiplatre.";
			case 2:
				return "Return to the Foreman with the Tainted Lachiplatre";
			}
		case 13:
			switch(stage){
			case 1:
				return "Finish your tour of the Processing Plant in the 6th Floor Food Servery.";
			case 2:
				return "Finish your tour of the Processing Plant in the 6th Floor Food Servery.";
			case 3:
				return "Make that Processing Guy a sandwich or whatever.";
			}
			
		}
		
		return "";
	}
	
}
