package cf.rohzek.rpg.game.enemies;

import java.util.Arrays;
import java.util.List;

import cf.rohzek.rpg.game.character.alignment.Alignments;
import cf.rohzek.rpg.game.enemies.Enemy.EnemyType;
import cf.rohzek.rpg.game.enemies.actions.EAction;
import cf.rohzek.rpg.game.enemies.actions.EActions;

public class Enemies 
{
	public static Enemy kobold = new Enemy("Kobold", EnemyType.KOBOLD, Alignments.lawful_evil, "2d6-2", 12, 25, new int[] {7, 15, 9, 8, 7, 8} , 30, new EAction[] {EActions.dagger, EActions.sling});
	public static Enemy goblin = new Enemy("Goblin", EnemyType.GOBLINOID, Alignments.neutral_evil, "2d6", 15, 50, new int[] {8, 14, 10, 10, 8, 8} , 30, new EAction[] {EActions.scimitar, EActions.short_bow});
	public static Enemy hobgoblin = new Enemy("Hobgoblin", EnemyType.GOBLINOID, Alignments.lawful_evil, "2d8+2", 18, 100, new int[] {13, 12, 12, 10, 10, 9} , 30, new EAction[] {EActions.longsword, EActions.long_bow});
	public static Enemy gnoll = new Enemy("Gnoll", EnemyType.GNOLL, Alignments.chaotic_evil, "5d8", 15, 100, new int[] {14, 12, 11, 6, 10, 7} , 30, new EAction[] {EActions.bite, EActions.spear, EActions.long_bow});
	public static Enemy mimic = new Enemy("Treasure Chest", EnemyType.SHAPECHANGER, Alignments.neutral_neutral, "9d8+18", 12, 450, new int[] {17, 12, 15, 5, 13, 8} , 15, new EAction[] {EActions.bite, EActions.pseudopod});
	
	private static Enemy[] enemies = 
	{
		kobold,
		goblin,
		hobgoblin,
		gnoll,
		mimic,
	};
	
	public static List<Enemy> ENEMIES = Arrays.asList(enemies);
}
