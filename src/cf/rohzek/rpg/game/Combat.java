package cf.rohzek.rpg.game;

import java.util.Scanner;

import cf.rohzek.rpg.RPGGame;
import cf.rohzek.rpg.game.character.Character;
import cf.rohzek.rpg.game.dice.Dice;
import cf.rohzek.rpg.game.enemies.Enemy;
import cf.rohzek.rpg.game.enemies.actions.EAction;
import cf.rohzek.rpg.game.items.Items;
import cf.rohzek.rpg.util.Save;
import cf.rohzek.rpg.util.Typewriter;

@SuppressWarnings("unused")
public class Combat 
{
	Scanner scanner;
	
	Dice dice;
	Character character;
	Enemy enemy;
	
	public Combat(Character character) 
	{
		scanner = RPGGame.scanner;
		dice = RPGGame.dice;
		this.character = character;
	}
	
	public void Encounter(Enemy enemy) 
	{
		this.enemy = enemy;
		
		InitiativePhase();
		
		if(character.stats.core.initiative > enemy.stats.initiative) 
		{
			PlayerStart();
		}
		
		else 
		{
			EnemyStart();
		}
	}
	
	private void InitiativePhase() 
	{
		Typewriter.Type("\nRolling for " + character.name + "'s initiative.");
		character.stats.core.initiative = character.stats.core.GetInitiative();
		Typewriter.Type("Got: " + character.stats.core.initiative + "\n");
		
		Typewriter.Type("Rolling for " + enemy.name + "'s initiative.");
		enemy.stats.initiative = enemy.stats.GetInitiative();
		Typewriter.Type("Got: " + enemy.stats.initiative + "\n");
		
		Typewriter.Type("\n\nPress Enter to start...");
		scanner.nextLine();
		RPGGame.clrscr();
	}
	
	private void PlayerStart() 
	{
		while(character.health.current > 0 && enemy.hp > 0) 
		{
			
			PlayerTurn();
			
			// Enemy could have died during player's combat phase
			// If so, he doesn't get to play.
			if(enemy.hp > 0) 
			{
				EnemyTurn();
				Typewriter.Type("\n\nPress Enter to continue...");
				scanner.nextLine();
				RPGGame.clrscr();
			}
		}
	}
	
	private void EnemyStart() 
	{
		while(enemy.hp > 0 && character.health.current > 0) 
		{
			EnemyTurn();
			
			// Player could have died during enemy's combat phase
			// If so, he/she doesn't get to play.
			if(character.health.current > 0) 
			{
				PlayerTurn();
				Typewriter.Type("\n\nPress Enter to continue...");
				scanner.nextLine();
				RPGGame.clrscr();
			}
		}
	}
	
	private void PlayerTurn() 
	{
		Typewriter.Type("\nWhat would you like to do?");
		Typewriter.Type("[Attack, Heal, Run]");
		String pi = scanner.nextLine().trim().toLowerCase();
		
		boolean temp = true;
		while(temp)
		{
			if("attack".equals(pi) || "heal".equals(pi) || "run".equals(pi)) 
			{
				temp = false;
			}
			
			else 
			{
				Typewriter.Type("\nInvalid action. Try again.");
				Typewriter.Type("What would you like to do?");
				Typewriter.Type("[Attack, Heal, Run]");
				pi = scanner.nextLine().trim().toLowerCase();
			}
		}
		
		if("attack".equals(pi)) 
		{
			Typewriter.Type("\nRolling for attack.");
			int roll = character.stats.core.GetAttackRoll();
			Typewriter.Type("Got: " + roll);
			
			if(roll >= enemy.ac) 
			{
				Typewriter.Type("\nAttacking " + enemy.name + " with " + Items.LONGSWORD);
				Typewriter.Type("Rolling for damage");
				roll = dice.Roll(Items.LONGSWORD.damage);
				Typewriter.Type("Hit " + enemy.name + " for " + roll + " damage");
				
				enemy.hp -= roll;
				
				CheckEnemyHP();
			}
			
			else 
			{
				Typewriter.Type("\nYou missed with " + Items.LONGSWORD.name);
			}
		}
		
		if("heal".equals(pi)) 
		{
			character.health.Restore(dice.Roll(Items.LESSER_POTION_OF_HEALING.level.getValue()));
		}
		
		if("run".equals(pi)) 
		{
			enemy.hp = 0;
		}
	}
	
	private void EnemyTurn() 
	{
		EAction act = enemy.actions.get(RPGGame.random.nextInt(enemy.actions.size()));
		
		Typewriter.Type("\n" + enemy.name + " readies to use " + act.name);
		Typewriter.Type("\nRolling for attack.");
		int roll = dice.Roll(act.hit);
		Typewriter.Type("Got: " + roll);
		
		if(roll >= character.ac) 
		{
			Typewriter.Type("\n" + enemy.name + " attacks with " + act.name);
			character.health.Remove(roll);
			Typewriter.Type("Hits you for " + roll);
			
			CheckPlayerHP();
		}
		else
		{
			Typewriter.Type("\n" + enemy.name + " misses with " + act.name);
		}
	}
	
	private void CheckPlayerHP() 
	{
		if(character.health.current < 1) 
		{
			Typewriter.Type("\nYou have died.");
		}
		else
		{
			Typewriter.Type("\nYou have " + character.health.current + " HP left.");
		}
	}
	
	private void CheckEnemyHP() 
	{
		if(enemy.hp < 1) 
		{
			enemy.hp = 0;
			Typewriter.Type("\nEnemy has died.");
			character.GainEXP(enemy.xp);
			LootDrops();
			
			Save.Write(character, character.name + ".char");
		}
		
		else
		{
			Typewriter.Type("\nEnemy has " + enemy.hp + " HP left.");
		}
	}
	
	private void LootDrops() 
	{
		//enemy.inventory;
	}
}
