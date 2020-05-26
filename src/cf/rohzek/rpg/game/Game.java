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
import cf.rohzek.rpg.game.dungeon.Dungeon;
import cf.rohzek.rpg.game.enemies.Enemies;
import cf.rohzek.rpg.game.enemies.Enemy;
import cf.rohzek.rpg.game.items.Armor;
import cf.rohzek.rpg.game.items.Items;

@SuppressWarnings("unused")
public class Game 
{
	Scanner scanner;
	Character character;
	Dungeon dungeon;
	Combat combat;
	
	private boolean gameRunning = false;
	private boolean gameLoaded = false;
	
	public Game() 
	{
		scanner = RPGGame.scanner;
		character = RPGGame.character;
		dungeon = RPGGame.dungeon;
		combat = RPGGame.combat;
		
		gameRunning = true;
		
		StartGame();
	}
	
	/**
	 * Starts the setup process as soon as the game is created.
	 * Will attempt to load a game in progress, failing that begins a new game.
	 */
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
			//GenerateDungeon();
			RunGame();
		}
		
		while(gameRunning && gameLoaded) 
		{
			RunGame();
		}
	}
	
	/**
	 * Dialogue for the player to generate their character
	 */
	public void GenerateCharacter() 
	{
		boolean genChar = true;
		
		while(genChar) 
		{
			character = new Character();
			
			System.out.println("\nWhat is your character's gender? (Leave blank for random gender)");
			character.ChooseGender(scanner.nextLine());
			
			
			System.out.println("\nWhat is your character's name? (Leave blank for random name)");
			character.ChooseName(scanner.nextLine());
			
			
			System.out.println("\nWhat is your character's race? (Leave blank for random race)");
			System.out.println(Races.RACES);
			character.ChooseRace(scanner.nextLine());
			
			character.AddRacialStats(character.race);
			
			if(character.race.name.toLowerCase().equals("human") || character.race.name.toLowerCase().equals("half-elf") || character.race.name.toLowerCase().equals("half elf")) 
			{
				System.out.println("\nAs a " + character.race.name + " you get a language selection. What language would you like? (Leave blank for random language)");
				character.race.resetLanguages();
				System.out.println(Languages.LANGUAGES);
				System.out.println("(Please keep in mind that you already speak: " + character.race.languages + ")");
				character.AddLanguage(scanner.nextLine());
			}
			
			if(character.race.name.toLowerCase().equals("half-elf") || character.race.name.toLowerCase().equals("half elf")) 
			{
				System.out.println("\nAs a " + character.race.name + " you get a +1 to two ability scores. Which two would you like? (Leave blank for random selection)");
				System.out.println(character.stats.core.STATS);
				System.out.println("(Please separate your choices with a space)");
				character.AddBonusStats(scanner.nextLine());
			}
			
			System.out.println("\nWhat is your character's class? (Leave blank for random class)");
			System.out.println(Classes.CLASSES);
			
			character.ChooseClass(scanner.nextLine());
			character.GenerateStats();
			
			System.out.println("\nWhat is your character's god or goddess? (Leave blank for random god)");
			System.out.println(Gods.GODS);
			
			character.setGod(scanner.nextLine());
			
			System.out.println("\nWhat is your character's alignment? (Leave blank for random alignment)");
			System.out.println(Alignments.ALIGNMENTS);
			
			character.setAlignment(scanner.nextLine());
			
			RPGGame.clrscr();
			System.out.println("\nCharacter Information:");
			System.out.println(character);
			
			System.out.println("\nStart game with this character? [yes/no]");
			boolean acceptCharacter = (scanner.nextLine().toLowerCase().contains("yes") ? true : false);
			
			if(acceptCharacter) 
			{
				genChar = false;
			}
			
			RPGGame.clrscr();
		}
	}
	
	/**
	 * Generates the dungeon to play in
	 */
	public void GenerateDungeon() 
	{
		dungeon = new Dungeon(10);
		dungeon.Generate();
	}
	
	/**
	 * Begins playing the game
	 */
	public void RunGame() 
	{
		combat = new Combat(character);
		CombatTest();
		gameRunning = false;
	}
	
	public void CombatTest() 
	{
		RPGGame.clrscr();
		System.out.println("Combat Test 0.0.2-alpha");
		System.out.println("Which enemy would you like to spawn?");
		System.out.println(Enemies.ENEMIES);
		String enemyName = scanner.nextLine().trim().toLowerCase();
		Enemy enemy = null;
		
		
		boolean temp = true;
		while(temp) 
		{
			if("kobold".equals(enemyName) || "goblin".equals(enemyName) || "hobgoblin".equals(enemyName) || "gnoll".equals(enemyName) || "treasure chest".equals(enemyName)) 
			{
				temp = false;
			}
			else 
			{
				System.out.println("\nEnemy type not found. Please try again.\n");
				System.out.println("\nWhich enemy would you like to spawn?");
				System.out.println(Enemies.ENEMIES);
				enemyName = scanner.nextLine().trim().toLowerCase();
			}
		}
		
		for(Enemy e : Enemies.ENEMIES) 
		{
			if(e.name.toLowerCase().equals(enemyName))
			{
				enemy = e.copy();
			}
		}
		
		int ac = 0;
		
		for(Armor armor : Items.LEATHER_SET) 
		{
			ac += armor.armorClass;
		}
		
		ac += Items.IRON_KITE.armorClass;
		
		RPGGame.clrscr();
		
		character.ac = ac;
		System.out.println("\nCharacter information:");
		System.out.println("Name: " + character.name);
		System.out.println("HP: " + character.health.current);
		System.out.println("AC: " + character.ac);
		System.out.println("Weapon: " + Items.LONGSWORD.name);
		System.out.println("Shield: " + Items.IRON_KITE.name);
		System.out.println("Armor: " + Items.LEATHER_SET + "\n");
		
		System.out.println("\nEnemy information:");
		System.out.println("Name: " + enemy.name);
		System.out.println("HP: " + enemy.hp);
		System.out.println("AC: " + enemy.ac);
		System.out.println("Actions: " + enemy.actions + "\n");
		
		System.out.println("\nPress Enter to continue...\n");
		scanner.nextLine();
		
		RPGGame.clrscr();
		
		combat.Encounter(enemy);
	}
}
