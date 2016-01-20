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
 6: Floor Manager's Quest
 7: Aquarium Tank Quest
 8: Central Elevator Quest
 9: Pen Pal's Food reQuest
 10: Lachiplatreland Quest
 11: Foreman's Quest
 12: 
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
				return "";
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
			
		}
		return "";
	}
	
}
