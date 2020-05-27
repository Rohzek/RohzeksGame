package cf.rohzek.rpg.game.character.alignment;

public class Alignment 
{
	public String name;
	public String label;
	public String description;
	
	public Alignment(String name, String label, String description) 
	{
		this.name = name;
		this.label = label;
		this.description = description;
	}
	
	public Alignment copy() 
	{
		return new Alignment(this.name, this.label, this.description);
	}
	
	@Override
	public String toString() 
	{
		return this.name;
	}
}
