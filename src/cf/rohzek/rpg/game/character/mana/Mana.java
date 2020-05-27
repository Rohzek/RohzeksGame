package cf.rohzek.rpg.game.character.mana;

public class Mana
{
	public int current = 0;
	public int max = 0;
	
	public Mana() {}
	
	public Mana(int current, int max) 
	{
		this.current = current;
		this.max = max;
	}
	
	public Mana copy() 
	{
		return new Mana(this.current, this.max);
	}
	
	public int Restore(int gain) 
	{
		current += gain;
		
		if(current > max) 
		{
			current = max;
		}
		
		return current;
	}
	
	public int Remove(int loss) 
	{
		current -= loss;
		
		if(current < 0) 
		{
			current = 0;
		}
		
		return current;
	}
}
