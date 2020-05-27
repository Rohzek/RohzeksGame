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
import cf.rohzek.rpg.util.Load;
import cf.rohzek.rpg.util.Save;
import cf.rohzek.rpg.util.Typewriter;

@SuppressWarnings("unused")
public class Game 
{
	Scanner scanner;
	Character character;
	Dungeon dungeon;
	Combat combat;
	
	public Game() 
	{
		scanner = RPGGame.scanner;
		character = RPGGame.character;
		dungeon = RPGGame.dungeon;
		combat = RPGGame.combat;
		
		StartGame();
	}
	
	/**
	 * Starts the setup process as soon as the game is created.
	 * Will attempt to load a game in progress, failing that begins a new game.
	 */
	public void StartGame() 
	{
		Typewriter.Type("Hello, and welcome to " + RPGGame.game_name);
		Typewriter.Type(RPGGame.game_name + " is a fantasy RPG dungeon crawler.");
		
		if(RPGGame.saves.size() > 0)
		{
			Typewriter.Type("\nI notice you have a character saved. Would you like to load it? [yes/no]");
			String loadresponse = scanner.nextLine();
			
			if(loadresponse.toLowerCase().contains("yes")) 
			{
				Typewriter.Type("\nWhich game would you like to load?");
				Typewriter.Type(RPGGame.saves.toString());
				String saveToLoad = scanner.nextLine();
				
				for(File name : RPGGame.saves) 
				{
					if(name.getName().toLowerCase().contains(saveToLoad.toLowerCase())) 
					{
						Typewriter.Type("\nLoading " + name.getName() + "\n");
						character = Load.Read(name.getName());
						break;
					}
				}
				
				if(character == null) 
				{
					Typewriter.Type("\nLoad character failed! Loading character generation...");
					GenerateCharacter();
				}
			}
			else 
			{
				GenerateCharacter();
			}
		}
		else 
		{
			Typewriter.Type("\nNo saved characters found. Generating a new one.");
			GenerateCharacter();
		}

		GenerateDungeon();
		RunGame();
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
			
			Typewriter.Type("\nWhat is your character's gender? (Leave blank for random gender)");
			character.ChooseGender(scanner.nextLine());
			
			
			Typewriter.Type("\nWhat is your character's name? (Leave blank for random name)");
			character.ChooseName(scanner.nextLine());
			
			
			Typewriter.Type("\nWhat is your character's race? (Leave blank for random race)");
			Typewriter.Type(Races.RACES.toString());
			character.ChooseRace(scanner.nextLine());
			
			character.AddRacialStats(character.race);
			
			if(character.race.name.toLowerCase().equals("human") || character.race.name.toLowerCase().equals("half-elf") || character.race.name.toLowerCase().equals("half elf")) 
			{
				Typewriter.Type("\nAs a " + character.race.name + " you get a language selection. What language would you like? (Leave blank for random language)");
				Typewriter.Type(Languages.LANGUAGES.toString());
				Typewriter.Type("(Please keep in mind that you already speak: " + character.race.languages + ")");
				character.AddLanguage(scanner.nextLine());
			}
			
			if(character.race.name.toLowerCase().equals("half-elf") || character.race.name.toLowerCase().equals("half elf")) 
			{
				Typewriter.Type("\nAs a " + character.race.name + " you get a +1 to two ability scores. Which two would you like? (Leave blank for random selection)");
				Typewriter.Type(character.stats.core.STATS.toString());
				Typewriter.Type("(Please separate your choices with a space)");
				character.AddBonusStats(scanner.nextLine());
			}
			
			Typewriter.Type("\nWhat is your character's class? (Leave blank for random class)");
			Typewriter.Type(Classes.CLASSES.toString());
			
			character.ChooseClass(scanner.nextLine());
			character.GenerateStats();
			
			Typewriter.Type("\nWhat is your character's god or goddess? (Leave blank for random god)");
			Typewriter.Type(Gods.GODS.toString());
			
			character.setGod(scanner.nextLine());
			
			Typewriter.Type("\nWhat is your character's alignment? (Leave blank for random alignment)");
			Typewriter.Type(Alignments.ALIGNMENTS.toString());
			
			character.setAlignment(scanner.nextLine());
			
			RPGGame.clrscr();
			Typewriter.Type("\nCharacter Information:");
			Typewriter.Type(character.toString());
			
			Typewriter.Type("\nStart game with this character? [yes/no]");
			boolean acceptCharacter = (scanner.nextLine().toLowerCase().contains("yes") ? true : false);
			
			if(acceptCharacter) 
			{
				genChar = false;
				Save.Write(character, character.name + ".char");
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
		// DungeonExplorationTest();
	}
	
	public void CombatTest() 
	{
		boolean runTest = true;
		
		while(runTest) 
		{
			RPGGame.clrscr();
			Typewriter.Type("Combat Test 0.0.5-alpha");
			Typewriter.Type("Which enemy would you like to spawn?");
			Typewriter.Type(Enemies.ENEMIES.toString());
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
					Typewriter.Type("\nEnemy type not found. Please try again.\n");
					Typewriter.Type("\nWhich enemy would you like to spawn?");
					Typewriter.Type(Enemies.ENEMIES.toString());
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
			Typewriter.Type("\nCharacter information:");
			Typewriter.Type("Name: " + character.name);
			Typewriter.Type("HP: " + character.health.current);
			Typewriter.Type("AC: " + character.ac);
			Typewriter.Type("Weapon: " + Items.LONGSWORD.name);
			Typewriter.Type("Shield: " + Items.IRON_KITE.name);
			Typewriter.Type("Armor: " + Items.LEATHER_SET + "\n");
			
			Typewriter.Type("\nEnemy information:");
			Typewriter.Type("Name: " + enemy.name);
			Typewriter.Type("HP: " + enemy.hp);
			Typewriter.Type("AC: " + enemy.ac);
			Typewriter.Type("Actions: " + enemy.actions + "\n");
			
			Typewriter.Type("\nPress Enter to continue...\n");
			scanner.nextLine();
			
			RPGGame.clrscr();
			
			combat.Encounter(enemy);
		}
	}
}
