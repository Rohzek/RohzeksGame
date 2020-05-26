package cf.rohzek.rpg.game;

import java.util.Scanner;

import cf.rohzek.rpg.RPGGame;
import cf.rohzek.rpg.game.character.Character;
import cf.rohzek.rpg.game.dice.Dice;
import cf.rohzek.rpg.game.enemies.Enemy;
import cf.rohzek.rpg.game.enemies.actions.EAction;
import cf.rohzek.rpg.game.items.Items;

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
		System.out.println("\nRolling for " + character.name + "'s initiative.");
		character.stats.core.initiative = character.stats.core.GetInitiative();
		System.out.println("Got: " + character.stats.core.initiative + "\n");
		
		System.out.println("Rolling for " + enemy.name + "'s initiative.");
		enemy.stats.initiative = enemy.stats.GetInitiative();
		System.out.println("Got: " + enemy.stats.initiative + "\n");
		
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
			}
		}
	}
	
	private void PlayerTurn() 
	{
		System.out.println("\nWhat would you like to do?");
		System.out.println("[Attack, Heal, Run]");
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
				System.out.println("\nInvalid action. Try again.");
				System.out.println("What would you like to do?");
				System.out.println("[Attack, Heal, Run]");
				pi = scanner.nextLine().trim().toLowerCase();
			}
		}
		
		if("attack".equals(pi)) 
		{
			System.out.println("\nRolling for attack.");
			int roll = character.stats.core.GetAttackRoll();
			System.out.println("Got: " + roll);
			
			if(roll > enemy.ac) 
			{
				System.out.println("\nAttacking " + enemy.name + " with " + Items.LONGSWORD);
				System.out.println("Rolling for damage.");
				roll = dice.Roll(Items.LONGSWORD.damage);
				System.out.println("Got: " + roll);
				
				enemy.hp -= roll;
				
				CheckEnemyHP();
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
		
		System.out.println("\nRolling for attack.");
		int roll = dice.Roll(act.hit);
		System.out.println("Got: " + roll);
		
		if(roll > character.ac) 
		{
			System.out.println(enemy.name + " attacks with " + act.name);
			character.health.Remove(roll);
			System.out.println("Hits you for " + roll);
			
			CheckPlayerHP();
		}
		else
		{
			System.out.println(enemy.name + " misses with " + act.name);
		}
	}
	
	private void CheckPlayerHP() 
	{
		if(character.health.current < 1) 
		{
			System.out.println("You have died.");
		}
		else
		{
			System.out.println("You have " + character.health.current + " HP left.");
		}
	}
	
	private void CheckEnemyHP() 
	{
		if(enemy.hp < 1) 
		{
			enemy.hp = 0;
			System.out.println("Enemy has died.");
			character.GainEXP(enemy.xp);
			LootDrops();
		}
		
		else
		{
			System.out.println("Enemy has " + enemy.hp + " HP left.");
		}
	}
	
	private void LootDrops() {}
}
