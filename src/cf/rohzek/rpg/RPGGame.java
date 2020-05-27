package cf.rohzek.rpg;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import cf.rohzek.rpg.game.Combat;
import cf.rohzek.rpg.game.Game;
import cf.rohzek.rpg.game.character.Character;
import cf.rohzek.rpg.game.dice.Dice;
import cf.rohzek.rpg.game.dungeon.Dungeon;
import cf.rohzek.rpg.util.Settings;
import cf.rohzek.rpg.util.Typewriter;

@SuppressWarnings("unused")
public class RPGGame 
{
	public static Scanner scanner;
	public static Random random;
	public static Dice dice;
	
	public static String game_name;
	public static File directory;
	public static List<File> saves;
	
	public static Character character = null;
	public static Dungeon dungeon;
	public static Combat combat;
	
	public static void main(String[] args) throws URISyntaxException 
	{
		scanner = new Scanner(System.in);
		random = new Random();
		dice = new Dice();
		
		game_name = "RPG";
		
		File jarFile = new File(RPGGame.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath());
		
		directory = new File(jarFile.getParent() + "\\settings");
		
		Settings.Check();
		
		directory = new File(jarFile.getParent() + "\\characters");
		
		 if (!directory.exists())
		 {
			 directory.mkdirs();
		 }
		 
		 if(directory == null) 
		 {
			 
		 }
		 
		saves = new ArrayList<File>();
		
		String[] contents = directory.list();
		
		for(String entry : contents)
		{	
			if(entry.contains(".char")) 
			{
				saves.add(new File(entry));
			}
		}

		clrscr();
		
		Game game = new Game();
		
		Typewriter.Type("\nThanks for playing!");
	}
	
	public static void clrscr()
	{
		Typewriter.Type("\n");
	    //Clears Screen in terminal or command prompt
	    try 
	    {
	        if (System.getProperty("os.name").contains("Windows"))
	        {
	        	new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	        }
	        else
	        {
	        	Runtime.getRuntime().exec("clear");
	        }
	    } 
	    catch (IOException | InterruptedException ex) {}
	}
}
