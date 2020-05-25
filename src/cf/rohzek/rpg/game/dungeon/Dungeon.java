package cf.rohzek.rpg.game.dungeon;

import java.util.Arrays;

import cf.rohzek.rpg.RPGGame;

public class Dungeon 
{
	int x, y, id = 0;
	// 2D array is backwards than you'd expect. First box is Y, second box is X
	//  X  Y
	Room[][] layout;
	Room start, boss;
	
	/**
	 * Constructor that sets x and y to be the same value
	 * @param size The amount of rows and columns of the grid
	 */
	public Dungeon(int size) 
	{
		this.x = size;
		this.y = size;
		this.layout = new Room[this.x][this.y];
	}
	
	/**
	 * Constructor that sets x and y to independant values
	 * @param x The amount of rows in the grid
	 * @param y The amount of columns in the grid
	 */
	public Dungeon(int x, int y) 
	{
		this.x = x;
		this.y = y;
		this.layout = new Room[this.x][this.y];
	}
	
	/**
	 * Runs through all of the functions to generate the full dungeon
	 */
	public void Generate() 
	{
		GenerateLayout();
		ConnectRooms();
		this.boss = ChooseBossRoom();
		this.start = ChooseStartingRoom();
		MakePath(start, boss);
		
		System.out.println(FormatPrint());
	}
	
	/**
	 * Generates the Room[][] array with initial values
	 * @return
	 */
	private Room[][] GenerateLayout() 
	{
		for(int i = 0; i < x; i++) 
		{
			for(int j = 0; j < y; j++) 
			{
				layout[i][j] = new Room(id, j, i);
				id++;
			}
		}
		
		return layout;
	}
	
	/**
	 * Calls both functions to connect all of the active rooms together.
	 * @return
	 */
	private Room[][] ConnectRooms()
	{
		ConnectRoomsSE();
		ConnectRoomsNW();
		
		return layout;
	}
	
	/**
	 * Connects the active rooms together from top left to bottom right
	 * @return
	 */
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
	
	/**
	 * Connects the active rooms together from bottom right to top left
	 * @return
	 */
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
	
	/**
	 * Iterates through the Room[][] and locates a suitable position for the boss room
	 * @return
	 */
	private Room ChooseBossRoom() 
	{
		int bossRoomNumber, minimum = id - (id / 3), maximum = id - minimum;
		boolean bossChosen = false;
		Room bossRoom = null;
		
		while(!bossChosen) 
		{
			bossRoomNumber = RPGGame.random.nextInt(maximum) + minimum;
			
			for(int i = (x-1); i > 0; i--) 
			{
				for(int j = (y-1); j > 0; j--) 
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
	
	/**
	 * Iterates through the Room[][] and locates a suitable position for the starting room.
	 * @return
	 */
	private Room ChooseStartingRoom() 
	{
		int startRoomNumber, minimum = 0, maximum = (id / 4);
		boolean chosen = false;
		Room start = null;
		
		while(!chosen) 
		{
			startRoomNumber = RPGGame.random.nextInt(maximum) + minimum;
			
			for(int i = 0; i < x; i++) 
			{
				for(int j = 0; j < y; j++) 
				{
					Room current = layout[i][j];
					
					if(current.id == startRoomNumber) 
					{
						if(current.active == 1) 
						{
							current.active = 3;
							chosen = true;
							start = current;
						}
					}
				}
			}
		}
		
		return start;
	}
	
	/**
	 * Attempts to connect the starting room and boss room together.
	 * @param start The starting room
	 * @param boss The boss room
	 * @return
	 */
	private Room[][] MakePath(Room start, Room boss)
	{
		Room current = null, last = null, next = null;
		
		// We're north west of the boss room
		if(start.x < boss.x) 
		{
			current = layout[start.y][start.x];
			
			while(current.x < boss.x) 
			{
				// Move down 1
				next = layout[current.y+1][current.x];
				current.south = next;
				last = current;
				current = next;
				current.north = last;
				current.active = 1;
				
				// Move right 1
				next = layout[current.y][current.x+1];
				current.east = next;
				last = current;
				current = next;
				current.west = last;
				current.active = 1;
			}
		}

		// We're north east of the boss room
		if(start.x > boss.x) 
		{
			current = layout[start.y][start.x];
			
			while(current.x > boss.x) 
			{
				// Move down 1
				next = layout[current.y+1][current.x];
				current.south = next;
				last = current;
				current = next;
				current.north = last;
				current.active = 1;
				
				// Move left 1
				next = layout[current.y][current.x-1];
				current.west = next;
				last = current;
				current = next;
				current.east = last;
				current.active = 1;
			}
		}
		
		/* 
		 * We need to be able to move straight down on the other options too
		 * So just in case we started already straight above the target we
		 * should adapter to current anyway.
		 */
		if(current == null) 
		{
			current = layout[start.y][start.x];
		}
		
		// We're straight north of the boss room
		if(current.x == boss.x) 
		{
			// Move straight down
			for(int i = current.y; i < boss.y; i++) 
			{
				current = layout[i][current.x];
				next = layout[i+1][current.x];
				
				last = current;
				current.south = next;
				current.north = last;
				
				if(next.active == 0) 
				{
					next.active = 1;
				}
			}
		}
		
		return layout;
	}
	
	/**
	 * Prints the Room[][] as a string in a grid fashion
	 * @return
	 */
	private String FormatPrint() 
	{
		String output = "\n";
		output += Arrays.deepToString(layout).replace("[", "");
		output = output.replace("], ", "\n");
		output = output.replace("]]", "\n");
		
		return output;
	}
}
