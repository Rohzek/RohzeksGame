package cf.rohzek.rpg.game.character.health;

public class Health
{
	public int current = 0;
	public int max = 0;
	
	public Health() {}
	
	public Health(int current, int max) 
	{
		this.current = current;
		this.max = max;
	}
	
	public Health copy() 
	{
		return new Health(this.current, this.max);
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
