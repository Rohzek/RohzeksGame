package cf.rohzek.rpg.game.character.stats;

import java.util.Arrays;
import java.util.List;

import cf.rohzek.rpg.RPGGame;
import cf.rohzek.rpg.game.character.Character;

public class Core
{
	Character character;
	
	public List<String> STATS = Arrays.asList(new String[]{"Strength", "Dexterity", "Constitution", "Intelligence", "Wisdom", "Charisma"});
	
	public int strength = 0;
	public int dexterity = 0;
	public int constitution = 0;
	public int intelligence = 0;
	public int wisdom = 0;
	public int charisma = 0;
	
	public int initiative = 0;
	
	public Core(Character character) 
	{
		this.character = character;
	}
	
	public Core(int[] arr) 
	{
		this.strength = arr[0];
		this.dexterity = arr[1];
		this.constitution = arr[2];
		this.intelligence = arr[3];
		this.wisdom = arr[4];
		this.charisma = arr[5];
	}
	
	public Core(int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma) 
	{
		this.strength = strength;
		this.dexterity = dexterity;
		this.constitution = constitution;
		this.intelligence = intelligence;
		this.wisdom = wisdom;
		this.charisma = charisma;
	}
	
	public Core copy() 
	{
		return new Core(this.strength, this.dexterity, this.constitution, this.intelligence, this.wisdom, this.charisma);
	}
	
	public int GetInitiative() 
	{
		int dex = GetDexterityMod();
		this.initiative = RPGGame.dice.Roll("d20") + dex;
		
		return this.initiative;
	}
	
	public int GetAttackRoll() 
	{
		int str = GetStrengthMod();
		if(this.character == null) 
		{
			return RPGGame.dice.Roll("d20") + str;
		}
		
		return RPGGame.dice.Roll("d20") + str + character.CalculateProficiency();
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
