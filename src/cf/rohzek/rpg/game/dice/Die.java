package cf.rohzek.rpg.game.dice;

import cf.rohzek.rpg.RPGGame;

public class Die 
{
	public int size,
	    	   count,
	    	   multiplication,
	    	   division,
	    	   addition,
	    	   subtraction,
	    	   last_roll,
	    	   last_total;
	
	// Empty constructor so that creating a Dice object without parameters is possible
	public Die() {}
	
	// Constructor that sets numbers
	public Die(int si, int c, int m, int d, int a, int su) 
	{
		this.size = si;
		this.count = c;
		this.multiplication = m;
		this.division = d;
		this.addition = a;
		this.subtraction = su;
	}
	
	public int[] Roll() 
	{	
		int[] results = new int[2];
		int rolls = 0;
		
		int number = 0;
		int total = 0;
		
		for (int i = 0; i < this.count; i++) 
		{
			number = 1 + RPGGame.random.nextInt(this.size);
			rolls += number;
		}
		
		total = rolls;
		
		if(this.multiplication > 1) 
		{
			total = number * this.multiplication;
		}
		
		if(this.division > 1) 
		{
			total = total / this.division;
		}
		
		if(this.addition > 0) 
		{
			total = total + this.addition;
		}
		
		if(this.subtraction > 0) 
		{
			total = total - this.subtraction;
		}
		
		results[0] = rolls;
		results[1] = total;
		
		last_roll = rolls;
		last_total = total;
		
		return results;
	}
	
	@Override
	public String toString() 
	{
		return String.format("Die Params: %sd%s*%s/%s+%s-%s Last Roll: %s Last Total: %s", count, size, multiplication, division, addition, subtraction, last_roll, last_total);
	}
}

