package cf.rohzek.rpg.game;

import java.io.File;
import java.util.Scanner;

import cf.rohzek.rpg.RPGGame;
import cf.rohzek.rpg.game.character.Character;
import cf.rohzek.rpg.game.character.alignment.Alignments;
import cf.rohzek.rpg.game.character.classes.Classes;
import cf.rohzek.rpg.game.character.language.Languages;
import cf.rohzek.rpg.game.character.race.Races;
import cf.rohzek.rpg.game.character.religion.Gods;

public class Game 
{
	Scanner scanner;
	Character character;
	private boolean gameRunning = false;
	private boolean gameLoaded = false;
	
	public Game() 
	{
		scanner = RPGGame.scanner;
		character = RPGGame.character;
		
		gameRunning = true;
		
		StartGame();
	}
	
	public void StartGame() 
	{
		System.out.println("Hello, and welcome to " + RPGGame.game_name);
		System.out.println(RPGGame.game_name + " is a fantasy RPG dungeon crawler.");
		
		if(RPGGame.saves.size() > 0)
		{
			System.out.println("\nI notice you have a saved game. Would you like to load it? [yes/no]");
			String loadresponse = scanner.nextLine();
			
			if(loadresponse.toLowerCase().contains("yes")) 
			{
				System.out.println("\nWhich game would you like to load?");
				System.out.println(RPGGame.saves);
				String saveToLoad = scanner.nextLine();
				
				for(File name : RPGGame.saves) 
				{
					if(name.getName().toLowerCase().contains(saveToLoad.toLowerCase())) 
					{
						System.out.println("\nLoading " + name.getName() + "\n");
						gameLoaded = true;
						break;
					}
				}
				
				if(!gameLoaded) 
				{
					System.out.println("\nLoad game failed! Starting new game...");
				}
			}
		}
		else 
		{
			System.out.println("\nNo saved games found. Starting a new game.");
		}
		
		// Attempt to load game here
		if(gameLoaded) 
		{
			
		}
		
		while(gameRunning && !gameLoaded) 
		{
			GenerateCharacter();
			GenerateDungeon();
			RunGame();
		}
		
		while(gameRunning && gameLoaded) 
		{
			RunGame();
		}
	}
	
	public void GenerateCharacter() 
	{
		boolean genChar = true;
		
		while(genChar) 
		{
			character = new Character();
			System.out.println("\nWhat is your character's name?");
			character.name = scanner.nextLine();
			
			System.out.println("\nWhat is your character's race?");
			System.out.println(Races.RACES);
			character.ChooseRace(scanner.nextLine());
			
			character.AddRacialStats(character.race);
			
			if(character.race.name.toLowerCase().equals("human") || character.race.name.toLowerCase().equals("half-elf") || character.race.name.toLowerCase().equals("half elf")) 
			{
				System.out.println("\nAs a " + character.race.name + " you get a language selection. What language would you like? (Leave blank or type something random for random language)");
				character.race.resetLanguages();
				System.out.println(Languages.LANGUAGES);
				System.out.println("(Please keep in mind that you already speak: " + character.race.languages + ")");
				character.AddLanguage(scanner.nextLine());
			}
			
			if(character.race.name.toLowerCase().equals("half-elf") || character.race.name.toLowerCase().equals("half elf")) 
			{
				System.out.println("\nAs a " + character.race.name + " you get a +1 to two ability scores. Which two would you like?");
				System.out.println(character.stats.core.STATS);
				System.out.println("(Please separate your choices with a space)");
				character.AddBonusStats(scanner.nextLine());
			}
			
			System.out.println("\nWhat is your character's class? (Leave blank or type something random for random class)");
			System.out.println(Classes.CLASSES);
			
			character.ChooseClass(scanner.nextLine());
			character.GenerateStats();
			
			System.out.println("\nWhat is your character's god or goddess? (Leave blank or type something random for random god)");
			System.out.println(Gods.GODS);
			
			character.setGod(scanner.nextLine());
			
			System.out.println("\nWhat is your character's alignment? (Leave blank or type something random for random alignment)");
			System.out.println(Alignments.ALIGNMENTS);
			
			character.setAlignment(scanner.nextLine());
			
			RPGGame.clrscr();
			System.out.println("\nCharacter Information:");
			System.out.println(character);
			
			System.out.println("\nStart game with this character?");
			boolean acceptCharacter = (scanner.nextLine().toLowerCase().contains("yes") ? true : false);
			
			if(acceptCharacter) 
			{
				genChar = false;
			}
			
			RPGGame.clrscr();
		}
	}
	
	public void GenerateDungeon() 
	{
		
	}
	
	public void RunGame() 
	{
		gameRunning = false;
	}
}
