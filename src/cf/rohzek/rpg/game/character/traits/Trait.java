package cf.rohzek.rpg.game.character.traits;

public class Trait 
{
	public String name;
	public String description;
	
	public Trait(String name, String description) 
	{
		this.name = name;
		this.description = description;
	}
	
	@Override
	public String toString() 
	{
		return this.name;
	}
}
