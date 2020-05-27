package cf.rohzek.rpg.game.character;

import java.util.List;

import cf.rohzek.rpg.RPGGame;
import cf.rohzek.rpg.game.character.alignment.Alignment;
import cf.rohzek.rpg.game.character.alignment.Alignments;
import cf.rohzek.rpg.game.character.classes.Classes;
import cf.rohzek.rpg.game.character.classes.IClass;
import cf.rohzek.rpg.game.character.health.Health;
import cf.rohzek.rpg.game.character.language.Languages;
import cf.rohzek.rpg.game.character.mana.Mana;
import cf.rohzek.rpg.game.character.race.Race;
import cf.rohzek.rpg.game.character.race.Races;
import cf.rohzek.rpg.game.character.religion.God;
import cf.rohzek.rpg.game.character.religion.Gods;
import cf.rohzek.rpg.game.character.stats.Stats;
import cf.rohzek.rpg.util.Settings;
import cf.rohzek.rpg.util.Typewriter;

public class Character
{
	public String name = "";
	public String gender = "";
	public Health health;
	public Mana mana;
	public int ac = 0;
	public int level = 0;
	public int experience = 0;
	public Stats stats;
	public Race race;
	public IClass character_class;
	public List<Magic> magicks;
	
	public Inventory inventory;
	
	public int battles = 0;
	
	public Character() 
	{
		stats = new Stats(this);
		health = new Health();
		mana = new Mana();
		race = null;
		inventory = new Inventory();
	}
	
	public Character(String name, String gender, Health health, Mana mana, int ac, int level, int experience, Stats stats, Race race, IClass character_class, List<Magic> magicks, Inventory inventory, int battles) 
	{
		this.name = name;
		this.gender = gender;
		this.health = health;
		this.ac = ac;
		this.mana = mana;
		this.level = level;
		this.experience = experience;
		this.stats = stats;
		this.race = race;
		this.character_class = character_class;
		this.magicks = magicks;
		this.inventory = inventory;
		this.battles = battles;
	}
	
	public Character copy() 
	{
		return new Character(this.name, this.gender, this.health, this.mana, this.ac, this.level, this.experience, this.stats, this.race, this.character_class, this.magicks, this.inventory, this.battles);
	}
	
	public void GainEXP(int xp) 
	{
		this.experience += xp;
		
		if(this.experience >= CalculateExperience()) 
		{
			LevelUp();
		}
	}
	
	private int CalculateExperience() 
	{
		int scale = 150;
		return (int) (scale * Math.pow((this.level + 1), 2) - (scale * (this.level + 1)));
	}
	
	public void LevelUp() 
	{
		this.level += 1;
		int increase = RPGGame.dice.Roll(this.character_class.getHitDice());
		this.health.max += increase;
		this.health.Restore(increase);
		Typewriter.Type(this.name + " has leveled up!");
		Typewriter.Type(this.name + " is now level " + this.level);
	}
	
	public int CalculateProficiency() 
	{
		return (int)(Math.floor(2 + (.25 * (level - 2))));
	}
	
	public void CalculateBaseAC() 
	{
		this.ac = 10 + this.stats.core.GetDexterityMod();
	}
	
	public void ChooseClass(String className) 
	{
		for(IClass cls : Classes.CLASSES) 
		{
			if(cls.getName().toLowerCase().equals(className.toLowerCase()))
			{
				this.character_class = cls;
				
				return;
			}
		}
		
		// If player can't type or didn't want to choose, assign random
		this.character_class = Classes.CLASSES.get(RPGGame.random.nextInt(Classes.CLASSES.size()));
	}
	
	public void ChooseName(String name) 
	{
		if(name.length() < 1) 
		{
			String[] randomMaleNames = {"Alexandre", "Rey", "Kyle", "Normas", "Gunter", "Guy", "Conrad", "Gilbert", "Chad", "Jean"};
			String[] randomFemaleNames = {"Heather", "Oriel", "Katherine", "Juliana", "Eloise", "Eleanor", "Griella", "Emma", "Eva", "Elizabeth"};
			
			if(this.gender.toLowerCase().equals("male")) 
			{
				this.name = randomMaleNames[RPGGame.random.nextInt(randomMaleNames.length)];
			}
			
			else if(this.gender.toLowerCase().equals("female")) 
			{
				this.name = randomFemaleNames[RPGGame.random.nextInt(randomFemaleNames.length)];
			}
			
			else 
			{
				this.name = "Special Little Snowflake";
			}
		}
		else
		{
			this.name = name;
		}
	}
	
	public void ChooseGender(String name) 
	{
		if(name.length() < 1) 
		{
			int number = RPGGame.random.nextInt(100) + 1;
			
			if(number < 51) 
			{
				this.gender = "Female";
			}
			else 
			{
				this.gender = "Male";
			}
		}
		
		else 
		{
			if(name.toLowerCase().contains("f")) 
			{
				this.gender = "Female";
			}
			
			else if (name.toLowerCase().contains("m")) 
			{
				this.gender = "Male";
			}
			
			else 
			{
				int number = RPGGame.random.nextInt(100) + 1;
				String g;
				if(number < 51) 
				{
					g = "Female";
				}
				else 
				{
					g = "Male";
				}
				
				this.gender = "Delusional Liberal (" + g + ")";
			}
		}
	}
	
	public void ChooseRace(String name) 
	{
		for(Race race : Races.RACES) 
		{
			if(name.toLowerCase().equals("half elf") && race.name.toLowerCase().equals("half-elf") ||
			   name.toLowerCase().equals("half orc") && race.name.toLowerCase().equals("half-orc") ||
			   race.name.toLowerCase().equals(name.toLowerCase()))
			{
				this.race = race.copy();
				Races.GeneratePhysicalProperties(this.race);
				return;
			}
		}
		
		this.GenerateRandomRace();
		
	}
	
	public void AddRacialStats(Race race) 
	{
		if(race == Races.DRAGONBORN) 
		{
			AddBonusStats("strength", 2);
			AddBonusStats("charisma", 1);
		}
		
		if(race == Races.DWARF) 
		{
			AddBonusStats("constitution", 2);
		}
		
		if(race == Races.ELF || race == Races.HALFLING) 
		{
			AddBonusStats("dexterity", 2);
		}
		
		if(race == Races.GNOME) 
		{
			AddBonusStats("intelligence", 2);
		}
		
		if(race == Races.HALF_ORC) 
		{
			AddBonusStats("strength", 2);
			AddBonusStats("constitution", 1);
		}
		
		if(race == Races.HUMAN) 
		{
			AddBonusStats("strength", 1);
			AddBonusStats("dexterity", 1);
			AddBonusStats("constitution", 1);
			AddBonusStats("intelligence", 1);
			AddBonusStats("wisdom", 1);
			AddBonusStats("charisma", 1);
		}
		
		if(race == Races.TIEFLING) 
		{
			AddBonusStats("charisma", 2);
			AddBonusStats("intelligence", 1);
		}
	}
	
	public void AddLanguage(String name) 
	{
		for(String language : Languages.LANGUAGES) 
		{
			for(String lng : race.languages) 
			{
				if(lng.toLowerCase().equals(name.toLowerCase())) 
				{
					// Language is already on the list.
					this.GenerateRandomLanguage();
					return;
				}
			}
			
			if(language.toLowerCase().equals(name.toLowerCase())) 
			{
				this.race.languages.add(language);
				return;
			}
		}
		
		this.GenerateRandomLanguage();
	}
	
	public void AddBonusStats(String names) 
	{
		String[] statList = names.toLowerCase().split("\\s+");
		
		for(String stat : statList) 
		{
			switch(stat) 
			{
				case "strength":
					stats.core.strength += 1;
					break;
				case "dexterity":
					stats.core.dexterity += 1;
					break;
				case "constitution":
					stats.core.constitution += 1;
					break;
				case "intelligence":
					stats.core.intelligence += 1;
					break;
				case "wisdom":
					stats.core.wisdom += 1;
					break;
				case "charisma":
					stats.core.charisma += 1;
					break;
				default:
					break;
			}
		}
	}
	
	public void AddBonusStats(String names, int amount) 
	{
		String[] statList = names.toLowerCase().split("\\s+");
		
		for(String stat : statList) 
		{
			switch(stat) 
			{
				case "strength":
					stats.core.strength += amount;
					break;
				case "dexterity":
					stats.core.dexterity += amount;
					break;
				case "constitution":
					stats.core.constitution += amount;
					break;
				case "intelligence":
					stats.core.intelligence += amount;
					break;
				case "wisdom":
					stats.core.wisdom += amount;
					break;
				case "charisma":
					stats.core.charisma += amount;
					break;
				default:
					break;
			}
		}
	}
	
	public void setGod(String name) 
	{
		for(God god : Gods.GODS) 
		{
			if(god.name.toLowerCase().equals(name.toLowerCase())) 
			{
				this.character_class.setGod(god);
				return;
			}
		}
		
		this.GenerateRandomGod();
	}
	
	public void setAlignment(String name) 
	{
		for(Alignment alignment : Alignments.ALIGNMENTS) 
		{
			if(alignment.name.toLowerCase().equals(name.toLowerCase())) 
			{
				this.character_class.setAlignment(alignment);
				return;
			}
		}
		
		this.GenerateRandomAlignment();
	}
	
	private void GenerateRandomGod() 
	{
		if(this.character_class.getName().toLowerCase().equals("paladin")) 
		{
			int number = RPGGame.random.nextInt(100) + 1;
			
			if(number >= 50) 
			{
				this.character_class.setGod(Gods.PELOR);
			}
			else
			{
				this.character_class.setGod(Gods.WEE_JAS);
			}
		}
		else 
		{
			this.character_class.setGod(Gods.GODS.get(RPGGame.random.nextInt(Gods.GODS.size())));
		}
	}
	
	private void GenerateRandomAlignment() 
	{
		if(this.character_class.getName().toLowerCase().equals("paladin")) 
		{
			this.character_class.setAlignment(Alignments.LAWFUL_GOOD);
		}
		else 
		{
			this.character_class.setAlignment(Alignments.ALIGNMENTS.get(RPGGame.random.nextInt(Alignments.ALIGNMENTS.size())));
		}
	}
	
	private void GenerateRandomRace() 
	{		
		this.race = Races.RACES.get(RPGGame.random.nextInt(Races.RACES.size())).copy();
		Races.GeneratePhysicalProperties(race);
	}
	
	public void GenerateRandomLanguage() 
	{
		String language = Languages.LANGUAGES.get(RPGGame.random.nextInt(Languages.LANGUAGES.size()));
		
		for(String lang : race.languages) 
		{
			if(language == lang) 
			{
				// Try again, this is the same language.
				while(language == lang) 
				{
					language = Languages.LANGUAGES.get(RPGGame.random.nextInt(Languages.LANGUAGES.size()));
				}
			}
		}
		
		this.race.languages.add(language);
	}
	
	public void GenerateStats() 
	{
		level = 1;
		experience = 0;
		
		this.stats.core.strength = RPGGame.dice.Roll("d20");
		this.stats.core.dexterity = RPGGame.dice.Roll("d20");
		this.stats.core.constitution = RPGGame.dice.Roll("d20");
		this.stats.core.intelligence = RPGGame.dice.Roll("d20");
		this.stats.core.wisdom = RPGGame.dice.Roll("d20");
		this.stats.core.charisma = RPGGame.dice.Roll("d20");
		
		GenerateVitality();
		CalculateBaseAC();
	}
	
	public void GenerateVitality() 
	{
		int value = this.character_class.getBaseHP() + this.stats.core.GetConstitutionMod();
		this.health.max = value < 1 ? 1 : value;
		this.health.current = this.health.max;
		
		value = this.character_class.getBaseMP() + this.stats.core.GetIntelligenceMod();
		this.mana.max = value < 1 ? 1 : value;
		this.mana.current = this.mana.max;
	}
	
	@Override
	public String toString() {
		String output = "\nName: " + name + '\n' +
						"Gender: " + gender + '\n' +
						"Race: " + race + '\n' +
				        "Class: " + character_class + "\n" +
						"Age: " + race.age + "\n" +
						"Height: " + race.getHeight(Settings.measurements) + "\n" +
						"Weight: " + race.getWeight(Settings.measurements) + "\n" +
						"\n" +
						"Languages: " + race.languages +
				        "\n" +
				        "HP: " + health.current + "\n" + 
				        "MP: " + mana.current + "\n" +
				        "Level: " + level + "\n" +
				        "Experience: " + experience + "\n" +
				        stats;
		return output;
	}
}
