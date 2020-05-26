package cf.rohzek.rpg.game.character;

import java.util.Arrays;
import java.util.List;

import cf.rohzek.rpg.RPGGame;

public class Stats 
{
	public Core core;
	public Abilities abilities;
	
	public Stats() 
	{
		core = new Core();
		abilities = new Abilities();
	}
	
	@Override
	public String toString()
	{
		return "\nStrength: " + this.core.strength + 
			   "\nDexterity: " + this.core.dexterity +
			   "\nConstitution: " + this.core.constitution +
			   "\nIntelligence: " + this.core.intelligence +
			   "\nWisdom: " + this.core.wisdom +
			   "\nCharisma: " + this.core.charisma;
	}
	
	public class Core
	{
		public List<String> STATS = Arrays.asList(new String[]{"Strength", "Dexterity", "Constitution", "Intelligence", "Wisdom", "Charisma"});
		
		public int strength;
		public int dexterity;
		public int constitution;
		public int intelligence;
		public int wisdom;
		public int charisma;
		
		public int initiative;
		
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
	
	public class Abilities
	{
		public int firstAid;
	}
}
