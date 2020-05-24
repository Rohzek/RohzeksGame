package cf.rohzek.rpg.game.character.language;

import java.util.Arrays;
import java.util.List;

public class Languages 
{
	public static String COMMON = "Common",
			       DRACONIC = "Draconic",
			       DWARVISH = "Dwarvish",
			       ELVISH = "Elvish",
			       GNOMISH = "Gnomish",
			       HALFLING = "Halfling",
			       ORC = "Orc",
			       INFERNAL = "Infernal";
	
	private static String[] languages = 
		{
			COMMON,
			DRACONIC,
			DWARVISH,
			ELVISH,
			GNOMISH,
			HALFLING,
			ORC,
			INFERNAL,
		};
		
		public static List<String> LANGUAGES = Arrays.asList(languages);
}
