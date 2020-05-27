package cf.rohzek.rpg.game.character.stats;

import cf.rohzek.rpg.game.character.Character;

public class Stats
{
	Character character;
	
	public Core core;
	public Abilities abilities;
	
	public Stats(Character character) 
	{
		this.character = character;
		core = new Core(this.character);
		abilities = new Abilities();
	}
	
	public Stats(Core core, Abilities abilities) 
	{
		this.core = core;
		this.abilities = abilities;
	}
	
	public Stats copy() 
	{
		return new Stats(this.core, this.abilities);
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
}
