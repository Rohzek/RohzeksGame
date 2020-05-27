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
	
	public Trait copy() 
	{
		return new Trait(this.name, this.description);
	}
	
	@Override
	public String toString() 
	{
		return this.name;
	}
}
