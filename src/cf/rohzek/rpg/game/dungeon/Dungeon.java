package cf.rohzek.rpg.game.dungeon;

import java.util.Arrays;

import cf.rohzek.rpg.RPGGame;

public class Dungeon 
{
	int x, y, id = 0;
	Room[][] layout;
	
	public Dungeon(int size) 
	{
		this.x = size;
		this.y = size;
		this.layout = new Room[x][y];
	}
	
	public void GenerateDungeon() 
	{
		Generate();
		
		System.out.println(FormatPrint());
		
		ConnectRooms();
		
		Room boss = ChooseBossRoom();
		System.out.println("Chose room: " + boss.x + ", " + boss.y + " as boss room.");
		
		Room start = ChooseStartingRoom(boss);
		System.out.println("Chose room: " + start.x + ", " + start.y + " as starting room.");
		
		System.out.println(FormatPrint());
	}
	
	private Room[][] Generate() 
	{
		for(int i = 0; i < x; i++) 
		{
			for(int j = 0; j < y; j++) 
			{
				layout[i][j] = new Room(id, i, j);
				id++;
			}
		}
		
		return layout;
	}
	
	private Room[][] ConnectRooms()
	{
		ConnectRoomsSE();
		ConnectRoomsNW();
		CheckAllRooms();
		
		return layout;
	}
	
	private void CheckAllRooms() 
	{
		Room current;
		
		for(int i = 10; i < x; i++) 
		{
			for(int j = 0; j < y; j++) 
			{
				current = layout[i][j];
			}
		}
		
		return;
	}
	
	private Room[][] ConnectRoomsSE()
	{
		Room current, eval;
		
		for(int i = 0; i < x; i++) 
		{
			for(int j = 0; j < x; j++) 
			{
				current = layout[i][j];
				
				if(current.active == 1) 
				{	
					if(j < 9) 
					{
						eval = layout[i][j+1];
						
						if(eval.active == 1) 
						{
							current.east = eval;
						}
						
					}
					
					if(i < 9) 
					{
						eval = layout[i+1][j];
						
						if(eval.active == 1) 
						{
							current.south = eval;
						}
					}
				}
			}
		}
		
		return layout;
	}
	
	private Room[][] ConnectRoomsNW()
	{	
		Room current, eval;
		
		for(int i = (x-1); i >= 0; i--) 
		{
			for(int j = (y-1); j >= 0; j--) 
			{
				current = layout[i][j];
				
				if(current.active == 1) 
				{
					if(j > 0) 
					{
						eval = layout[i][j-1];
						
						if(eval.active == 1) 
						{
							current.west = eval;
						}
					}
					
					if(i > 0) 
					{
						eval = layout[i-1][j];
						
						if(eval.active == 1) 
						{
							current.north = eval;
						}
					}
				}
			}
		}
		
		return layout;
	}
	
	private Room ChooseBossRoom() 
	{
		int bossRoomNumber, minimum = id - (id / 3), maximum = id - minimum;
		boolean bossChosen = false;
		Room bossRoom = null;
		
		while(!bossChosen) 
		{
			bossRoomNumber = RPGGame.random.nextInt(maximum) + minimum;
			
			for(int i = 0; i < x; i++) 
			{
				for(int j = 0; j < y; j++) 
				{
					Room current = layout[i][j];
					
					if(current.id == bossRoomNumber) 
					{
						if(current.active == 1) 
						{
							current.active = 2;
							bossChosen = true;
							bossRoom = current;
						}
					}
				}
			}
		}
		
		return bossRoom;
	}
	
	private Room ChooseStartingRoom(Room room) 
	{
		boolean chosen = false;
		Room start = room;
		
		while(!chosen) 
		{
			System.out.println(start.x + ", " + start.y);
			
			if(start.north != null) 
			{
				if(start.north.active == 1) 
				{
					System.out.println("Hey, we could move north!");
					start = start.north;
				}
			}
			
			else if(start.west != null) 
			{
				if(start.west.active == 1) 
				{
					System.out.println("Hey, we could move west!");
					start = start.west;
				}
			}
			
			else if(start.east != null) 
			{
				if(start.east.active == 1) 
				{
					System.out.println("Hey, we could move east!");
					start = start.east;
				}
			}
			
			else if(start.south != null) 
			{
				if(start.south.active == 1) 
				{
					System.out.println("Hey, we could move south!");
					start = start.south;
				}
			}
			
			else 
			{
				chosen = true;
			}
		}
		
		return start;
	}
	
	private String FormatPrint() 
	{
		String output = "\n";
		output += Arrays.deepToString(layout).replace("[", "");
		output = output.replace("], ", "\n");
		output = output.replace("]]", "\n");
		
		return output;
	}
}
