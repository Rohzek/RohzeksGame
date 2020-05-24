package cf.rohzek.rpg.game.dungeon;

public class Dungeon 
{
	int x, y;
	int[][] layout;
	
	public Dungeon(int x, int y) 
	{
		this.x = x;
		this.y = y;
		this.layout= new int[x][y];
	}
}
