package cf.rohzek.rpg.game.character.stats;

public class Abilities
{
	public int firstAid = 0;
	
	public Abilities() {}
	
	public Abilities(int firstAid) 
	{
		this.firstAid = firstAid;
	}
	
	public Abilities Copy() 
	{
		return new Abilities(this.firstAid);
	}
}
