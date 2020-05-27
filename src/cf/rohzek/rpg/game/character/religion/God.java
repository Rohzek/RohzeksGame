package cf.rohzek.rpg.game.character.religion;

public class God 
{
	public String name;
	public String title;
	
	public God(String name, String title) 
	{
		this.name = name;
		this.title = title;
	}
	
	public God copy() 
	{
		return new God(this.name, this.title);
	}
	
	@Override
	public String toString() 
	{
		return this.name;
	}
}
