package cf.rohzek.rpg.game.character.race;

import java.util.Arrays;
import java.util.List;

import cf.rohzek.rpg.RPGGame;
import cf.rohzek.rpg.game.character.language.Languages;
import cf.rohzek.rpg.game.character.race.Race.RaceSize;
import cf.rohzek.rpg.game.character.traits.Trait;
import cf.rohzek.rpg.game.character.traits.Traits;

// https://www.dndbeyond.com/races
public class Races 
{
	public static Race DRAGONBORN = new Race("Dragonborn", 0, 0f, "", RaceSize.MEDIUM, 0f, 30, Arrays.asList(new Trait[]{Traits.DRACONIC_ANCESTRY, Traits.BREATH_WEAPON, Traits.DAMAGE_RESISTANCE}), Arrays.asList(new String[]{Languages.COMMON, Languages.DRACONIC}));
	public static Race DWARF = new Race("Dwarf", 0, 0f, "", RaceSize.MEDIUM, 0f,  25, Arrays.asList(new Trait[]{Traits.DARKVISION, Traits.DWARVEN_COMBAT_TRAINING, Traits.DWARVEN_RESILIENCE}), Arrays.asList(new String[]{Languages.COMMON, Languages.DWARVISH}));
	public static Race ELF = new Race("Elf", 0, 0f, "", RaceSize.MEDIUM, 0f, 30, Arrays.asList(new Trait[]{Traits.DARKVISION, Traits.KEEN_SENSES, Traits.FEY_ANCESTORY, Traits.TRANCE}), Arrays.asList(new String[]{Languages.COMMON, Languages.ELVISH}));
	public static Race GNOME = new Race("Gnome", 0, 0f, "", RaceSize.MEDIUM, 0f, 25, Arrays.asList(new Trait[]{Traits.DARKVISION, Traits.GNOME_CUNNING}), Arrays.asList(new String[]{Languages.COMMON, Languages.GNOMISH}));
	public static Race HALF_ELF = new Race("Half-Elf", 0, 0f, "", RaceSize.MEDIUM, 0f, 30, Arrays.asList(new Trait[]{Traits.DARKVISION, Traits.FEY_ANCESTORY, Traits.SKILL_VERSATILITY}), Arrays.asList(new String[]{Languages.COMMON, Languages.ELVISH}));
	public static Race HALFLING = new Race("Halfling", 0, 0f, "", RaceSize.MEDIUM, 0f, 25, Arrays.asList(new Trait[]{Traits.LUCKY, Traits.BRAVE, Traits.HALFLING_NIMBLENESS}), Arrays.asList(new String[]{Languages.COMMON, Languages.HALFLING}));
	public static Race HALF_ORC = new Race("Half-Orc", 0, 0f, "", RaceSize.MEDIUM, 0f, 30, Arrays.asList(new Trait[]{Traits.DARKVISION, Traits.MENACING, Traits.RELENTLESS_ENDURANCE, Traits.SAVAGE_ATTACKS}), Arrays.asList(new String[]{Languages.COMMON, Languages.ORC}));
	public static Race HUMAN = new Race("Human", 0, 0f, "", RaceSize.MEDIUM, 0f, 0, Arrays.asList(new Trait[]{}), Arrays.asList(new String[]{Languages.COMMON}));
	public static Race TIEFLING = new Race("Tiefling", 0, 0f, "", RaceSize.MEDIUM, 0f, 30, Arrays.asList(new Trait[]{Traits.DARKVISION, Traits.HELLISH_RESISTANCE, Traits.INFERNAL_LEGACY}), Arrays.asList(new String[]{Languages.COMMON, Languages.INFERNAL}));
	
	
	private static Race[] races = 
	{
		DRAGONBORN,
		DWARF,
		ELF,
		GNOME,
		HALF_ELF,
		HALFLING,
		HALF_ORC,
		HUMAN,
		TIEFLING,
	};
	
	public static List<Race> RACES = Arrays.asList(races);
	
	public static void GeneratePhysicalProperties(Race race) 
	{
		float minimum, maximum;
		int aMin, aMax;
		
		switch(race.name.toLowerCase()) 
		{
			case "dragonborn":
				minimum = 198.12f;
				maximum = 274.32f - minimum;
				race.heightCentimeters = Generate(minimum, maximum);
				minimum = 200f;
				maximum = 250f - minimum;
				race.weight = Generate(minimum, maximum);
				aMin = 13;
				aMax = 25 - aMin;
				race.age = RPGGame.random.nextInt(aMax) + aMin;
				break;
			case "dwarf":
				minimum = 121.92f;
				maximum = 152.4f - minimum;
				race.heightCentimeters = Generate(minimum, maximum);
				minimum = 100f;
				maximum = 250f - minimum;
				race.weight = Generate(minimum, maximum);
				aMin = 18;
				aMax = 75 - aMin;
				race.age = RPGGame.random.nextInt(aMax) + aMin;
				break;
			case "elf":
				minimum = 137.16f;
				maximum = 198.12f - minimum;
				race.heightCentimeters = Generate(minimum, maximum);
				minimum = 100f;
				maximum = 250f - minimum;
				race.weight = Generate(minimum, maximum);
				aMin = 18;
				aMax = 135 - aMin;
				race.age = RPGGame.random.nextInt(aMax) + aMin;
				break;
			case "gnome":
				minimum = 91.44f;
				maximum = 121.92f - minimum;
				race.heightCentimeters = Generate(minimum, maximum);
				race.size = RaceSize.SMALL;
				minimum = 15f;
				maximum = 250f - minimum;
				race.weight = Generate(minimum, maximum);
				aMin = 18;
				aMax = 170 - aMin;
				race.age = RPGGame.random.nextInt(aMax) + aMin;
				break;
			case "half elf":
				minimum = 152.4f;
				maximum = 182.88f - minimum;
				race.heightCentimeters = Generate(minimum, maximum);
				minimum = 90f;
				maximum = 250f - minimum;
				race.weight = Generate(minimum, maximum);
				aMin = 18;
				aMax = 35 - aMin;
				race.age = RPGGame.random.nextInt(aMax) + aMin;
				break;
			case "halfling":
				minimum = 76.2f;
				maximum = 106.68f - minimum;
				race.heightCentimeters = Generate(minimum, maximum);
				race.size = RaceSize.SMALL;
				minimum = 15f;
				maximum = 250f - minimum;
				race.weight = Generate(minimum, maximum);
				aMin = 18;
				aMax = 100 - aMin;
				race.age = RPGGame.random.nextInt(aMax) + aMin;
				break;
			case "half orc":
				minimum = 152.40f;
				maximum = 250f - minimum;
				race.heightCentimeters = Generate(minimum, maximum);
				minimum = 150f;
				maximum = 250f - minimum;
				race.weight = Generate(minimum, maximum);
				aMin = 12;
				aMax = 27 - aMin;
				race.age = RPGGame.random.nextInt(aMax) + aMin;
				break;
			case "human":
				minimum = 152.40f;
				maximum = 182.88f - minimum;
				race.heightCentimeters = Generate(minimum, maximum);
				minimum = 90f;
				maximum = 250f - minimum;
				race.weight = Generate(minimum, maximum);
				aMin = 16;
				aMax = 35 - aMin;
				race.age = RPGGame.random.nextInt(aMax) + aMin;
				break;
			case "tiefling":
				minimum = 152.40f;
				maximum = 182.88f - minimum;
				race.heightCentimeters = Generate(minimum, maximum);
				minimum = 90f;
				maximum = 250f - minimum;
				race.weight = Generate(minimum, maximum);
				aMin = 16;
				aMax = 35 - aMin;
				race.age = RPGGame.random.nextInt(aMax) + aMin;
				break;
			default:
				minimum = 152.40f;
				maximum = 182.88f - minimum;
				race.heightCentimeters = Generate(minimum, maximum);
				minimum = 90f;
				maximum = 250f - minimum;
				race.weight = Generate(minimum, maximum);
				aMin = 16;
				aMax = 35 - aMin;
				race.age = RPGGame.random.nextInt(aMax) + aMin;
				break;
		}
		
		race.centimetersToFeetInches(race.heightCentimeters);
	}
	
	public static float Generate(float minimum, float maximum) 
	{
		return Float.valueOf("" + (RPGGame.random.nextInt((int) maximum) + (int) minimum) + "." + (RPGGame.random.nextInt(100)));
	}
}
