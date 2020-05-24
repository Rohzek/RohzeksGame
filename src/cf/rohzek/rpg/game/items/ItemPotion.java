package cf.rohzek.rpg.game.items;

import cf.rohzek.rpg.RPGGame;
import cf.rohzek.rpg.game.character.Character;

public class ItemPotion extends Item
{
	public enum PotionType
	{
		HEALTH_POTION,
		MANA_POTION,
	}
	
	public enum PotionLevel
	{
		LESSER("1d4+1"),
		SMALL("2d4+2"),
		MEDIUM("4d4+4"),
		LARGE("8d8+4"),
		GREATER("10d4+20");
		
		private final String value;

		PotionLevel(final String newValue) 
		{
            value = newValue;
        }

        public String getValue() 
        { 
        	return value; 
        }
	}
	
	public PotionType type;
	public PotionLevel level;
	
	public ItemPotion(String name, double value, float weight, PotionType type, PotionLevel level) 
	{
		super(name, value, weight);
		this.type = type;
		this.level = level;
	}
	
	public void onUse(Character character) 
	{
		switch(this.type) 
		{
			case HEALTH_POTION:
				Heal(character, this.level.getValue());
				break;
			case MANA_POTION:
				Restore(character, this.level.getValue());
				break;
			default:
				break;
		}
	}
	
	private void Heal(Character character, String amount) 
	{
		character.health.current += RPGGame.dice.Roll(amount);
		
		if(character.health.current > character.health.max) 
		{
			character.health.current = character.health.max;
		}
	}
	
	private void Restore(Character character, String amount) 
	{
		character.mana.current += RPGGame.dice.Roll(amount);
		
		if(character.mana.current > character.mana.max) 
		{
			character.mana.current = character.mana.max;
		}
	}
}
