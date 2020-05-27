package cf.rohzek.rpg.game.enemies;

import java.util.Arrays;
import java.util.List;

import cf.rohzek.rpg.game.character.Inventory;
import cf.rohzek.rpg.game.character.alignment.Alignments;
import cf.rohzek.rpg.game.enemies.Enemy.EnemyType;
import cf.rohzek.rpg.game.enemies.actions.EAction;
import cf.rohzek.rpg.game.enemies.actions.EActions;

public class Enemies 
{
	public static Enemy KOBOLD = new Enemy("Kobold", EnemyType.KOBOLD, Alignments.LAWFUL_EVIL, "2d6-2", 12, 25, new int[] {7, 15, 9, 8, 7, 8} , 30, new Inventory(), new EAction[] {EActions.DAGGER, EActions.SLING});
	public static Enemy GOBLIN = new Enemy("Goblin", EnemyType.GOBLINOID, Alignments.NEUTRAL_EVIL, "2d6", 15, 50, new int[] {8, 14, 10, 10, 8, 8} , 30, new Inventory(), new EAction[] {EActions.SCIMITAR, EActions.SHORT_BOW});
	public static Enemy HOBGOBLIN = new Enemy("Hobgoblin", EnemyType.GOBLINOID, Alignments.LAWFUL_EVIL, "2d8+2", 18, 100, new int[] {13, 12, 12, 10, 10, 9} , 30, new Inventory(), new EAction[] {EActions.LONGSWORD, EActions.LONG_BOW});
	public static Enemy GNOLL = new Enemy("Gnoll", EnemyType.GNOLL, Alignments.CHAOTIC_EVIL, "5d8", 15, 100, new int[] {14, 12, 11, 6, 10, 7} , 30, new Inventory(), new EAction[] {EActions.BITE, EActions.SPEAR, EActions.LONG_BOW});
	public static Enemy MIMIC = new Enemy("Treasure Chest", EnemyType.SHAPECHANGER, Alignments.NEUTRAL_NEUTRAL, "9d8+18", 12, 450, new int[] {17, 12, 15, 5, 13, 8} , 15, new Inventory(), new EAction[] {EActions.BITE, EActions.PSEUDOPOD});
	
	private static Enemy[] enemies = 
	{
		KOBOLD,
		GOBLIN,
		HOBGOBLIN,
		GNOLL,
		MIMIC,
	};
	
	public static List<Enemy> ENEMIES = Arrays.asList(enemies);
}
