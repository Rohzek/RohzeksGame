package cf.rohzek.rpg.game.enemies;

import java.util.Arrays;
import java.util.List;

import cf.rohzek.rpg.RPGGame;
import cf.rohzek.rpg.game.character.alignment.Alignment;
import cf.rohzek.rpg.game.enemies.combat.EAction;

public class Enemy 
{
	public enum EnemyType
	{
		SHAPECHANGER,
		GOBLINOID,
		KOBOLD,
		GNOLL
	}
	
	public String name;
	public EnemyType type;
	Alignment alignment;
	public int hp;
	public String hitDie;
	public int ac;
	public float xp;
	public Stats stats;
	public int speed;
	public EAction[] actions;
	
	public Enemy(String name, EnemyType type, Alignment alignment, String hp, int ac, float xp, int[] stats, int speed, EAction[] actions)
	{
		this.name = name;
		this.type = type;
		this.alignment = alignment;
		this.hitDie = hp;
		this.hp = RPGGame.dice.Roll(this.hitDie);
		this.ac = ac;
		this.xp = xp;
		this.stats = new Stats(stats);
		this.speed = speed;
		this.actions = actions;
	}
	
	public Enemy(String name, EnemyType type, Alignment alignment, String hp, int ac, float xp, Stats stats, int speed, EAction[] actions)
	{
		this.name = name;
		this.type = type;
		this.alignment = alignment;
		this.hitDie = hp;
		this.hp = RPGGame.dice.Roll(this.hitDie);
		this.ac = ac;
		this.xp = xp;
		this.stats = stats;
		this.speed = speed;
		this.actions = actions;
	}
	
	public Enemy copy() 
	{
		return new Enemy(this.name, this.type, this.alignment, this.hitDie, this.ac, this.xp, this.stats.copy(), this.speed, this.actions);
	}
	
	@Override
	public String toString() 
	{
		return name;
	}
	
	public class Stats
	{
		public List<String> STATS = Arrays.asList(new String[]{"Strength", "Dexterity", "Constitution", "Intelligence", "Wisdom", "Charisma"});
		
		public int strength;
		public int dexterity;
		public int constitution;
		public int intelligence;
		public int wisdom;
		public int charisma;
		
		public int initiative;
		
		public Stats(int[] arr) 
		{
			this.strength = arr[0];
			this.dexterity = arr[1];
			this.constitution = arr[2];
			this.intelligence = arr[3];
			this.wisdom = arr[4];
			this.charisma = arr[5];
		}
		
		public Stats(int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma)
		{
			this.strength = strength;
			this.dexterity = dexterity;
			this.constitution = constitution;
			this.intelligence = intelligence;
			this.wisdom = wisdom;
			this.charisma = charisma;
		}
		
		public Stats copy() 
		{
			return new Stats(this.strength, this.dexterity, this.constitution, this.intelligence, this.wisdom, this.charisma);
		}
		
		public int GetInitiative() 
		{
			int dex = GetDexterityMod();
			this.initiative = RPGGame.dice.Roll("d20") + dex;
			
			return this.initiative;
		}
		
		public int GetStrengthMod() 
		{
			return GetMod(this.strength);
		}
		
		public int GetDexterityMod() 
		{
			return GetMod(this.dexterity);
		}
		
		public int GetConstitutionMod() 
		{
			return GetMod(this.constitution);
		}
		
		public int GetIntelligenceMod() 
		{
			return GetMod(this.intelligence);
		}
		
		public int GetWisdomMod() 
		{
			return GetMod(this.wisdom);
		}
		
		public int GetCharismaMod() 
		{
			return GetMod(this.charisma);
		}
		
		private int GetMod(int level) 
		{
			switch(level) 
			{
				case 1:
					return -5;
					
				case 2:
				case 3:
					return -4;
					
				case 4:
				case 5:
					return -3;
					
				case 6:
				case 7:
					return -2;
					
				case 8:
				case 9:
					return -1;
					
				case 10:
				case 11:
					return 0;
					
				case 12:
				case 13:
					return 1;
					
				case 14:
				case 15:
					return 2;
					
				case 16:
				case 17:
					return 3;
					
				case 18:
				case 19:
					return 4;
					
				case 20:
				case 21:
					return 5;
					
				case 22:
				case 23:
					return 6;
					
				case 24:
				case 25:
					return 7;
					
				case 26:
				case 27:
					return 8;
					
				case 28:
				case 29:
					return 9;
					
				case 30:
					return 10;
					
				default:
					return 0;
			}
		}
	}
}
