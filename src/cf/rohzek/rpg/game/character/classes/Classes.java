package cf.rohzek.rpg.game.character.classes;

import java.util.Arrays;
import java.util.List;

public class Classes
{
	public static IClass barbarian = new ClassBarbarian("Barbarian", "d12", 12, "d4", 4, "");
	public static IClass fighter = new ClassFighter("Fighter", "d10", 10, "d6", 6, "");
	public static IClass monk = new ClassMonk("Monk", "d8", 8, "d6", 6, "");
	public static IClass paladin = new ClassPaladin("Paladin", "d10", 10, "d10", 10, "");
	public static IClass rogue = new ClassRogue("Rogue", "d8", 8, "d8", 8, "");
	
	private static IClass[] classes = 
	{
			barbarian,
			fighter,
			monk,
			paladin,
			rogue,
	};
	
	public static List<IClass> CLASSES = Arrays.asList(classes);
}
