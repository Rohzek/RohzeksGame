package cf.rohzek.rpg;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import cf.rohzek.rpg.game.Game;
import cf.rohzek.rpg.game.character.Character;
import cf.rohzek.rpg.game.dice.Dice;

@SuppressWarnings("unused")
public class RPGGame 
{
	public static Scanner scanner = new Scanner(System.in);
	public static Random random = new Random();
	public static Dice dice = new Dice();
	
	public static String game_name = "RPG";
	public static File directory = new File(System.getProperty("user.dir"));
	public static List<File> saves = new ArrayList<File>();
	
	public static Character character;
	
	public static void main(String[] args) 
	{
		String[] contents = directory.list();
		
		for(String entry : contents) 
		{	
			if(entry.contains(".sav")) 
			{
				saves.add(new File(entry));
			}
		}
		
		Game game = new Game();
		
		System.out.println("Thanks for playing!");
	}
	
	public static void clrscr(){
		System.out.println("\n");
	    //Clears Screen in java
	    try 
	    {
	        if (System.getProperty("os.name").contains("Windows"))
	        {
	        	new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	        	
	        	//for(int i = 0; i < 80*300; i++) 
	        	//{
	        		//System.out.print("\b"); // Prints a backspace
	        	//}
	        }
	        else
	        {
	        	Runtime.getRuntime().exec("clear");
	        }
	    } 
	    catch (IOException | InterruptedException ex) {}
	}
}
