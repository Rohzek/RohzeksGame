package cf.rohzek.rpg.game.enemies;

import java.util.Arrays;
import java.util.List;

import cf.rohzek.rpg.RPGGame;
import cf.rohzek.rpg.game.character.Inventory;
import cf.rohzek.rpg.game.character.alignment.Alignment;
import cf.rohzek.rpg.game.character.stats.Core;
import cf.rohzek.rpg.game.enemies.actions.EAction;

public class Enemy 
{
	public enum EnemyType
	{
		SHAPECHANGER,
		GOBLINOID,
		KOBOLD,
		GNOLL
	}
	
	public String name = "";
	public EnemyType type;
	Alignment alignment;
	public int hp = 0;
	public String hitDie = "";
	public int ac = 0;
	public int xp = 0;
	public Core stats;
	public int speed = 30;
	public List<EAction> actions;
	public Inventory inventory;
	
	public Enemy(String name, EnemyType type, Alignment alignment, String hp, int ac, int xp, int[] stats, int speed, Inventory inventory, EAction[] actions)
	{
		this.name = name;
		this.type = type;
		this.alignment = alignment;
		this.hitDie = hp;
		
		while(this.hp < 1) 
		{
			this.hp = RPGGame.dice.Roll(this.hitDie);
		}
		
		this.ac = ac;
		this.xp = xp;
		this.stats = new Core(stats);
		this.speed = speed;
		this.actions = Arrays.asList(actions);
	}
	
	public Enemy(String name, EnemyType type, Alignment alignment, String hp, int ac, int xp, Core stats, int speed, Inventory inventory, List<EAction> actions)
	{
		this.name = name;
		this.type = type;
		this.alignment = alignment;
		this.hitDie = hp;

		while(this.hp < 1) 
		{
			this.hp = RPGGame.dice.Roll(this.hitDie);
		}
		
		this.ac = ac;
		this.xp = xp;
		this.stats = stats;
		this.speed = speed;
		this.actions = actions;
	}
	
	public Enemy copy() 
	{
		return new Enemy(this.name, this.type, this.alignment, this.hitDie, this.ac, this.xp, this.stats.copy(), this.speed, this.inventory, this.actions);
	}
	
	@Override
	public String toString() 
	{
		return name;
	}
}
