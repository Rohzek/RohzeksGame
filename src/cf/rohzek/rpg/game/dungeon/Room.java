package cf.rohzek.rpg.game.dungeon;

import cf.rohzek.rpg.RPGGame;

public class Room 
{
	int id;
	int x, y;
	int active;
	Room north, south, east, west;
	
	public Room(int id, int x, int y) 
	{
		this.id = id;
		this.x = x;
		this.y = y;
		
		Generate();
	}
	
	/**
	 * Randomly determines if the room should be active or not
	 */
	private void Generate() 
	{
		int number = RPGGame.random.nextInt(100) + 1;
		
		if(number < 65) 
		{
			this.active = 1;
		}
		else
		{
			this.active = 0;
		}
	}
	
	@Override
	public String toString() 
	{
		return active + "";
	}
}
