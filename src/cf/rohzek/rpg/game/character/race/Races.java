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
	public static Race dragonborn = new Race("Dragonborn", "", 0f, 30, Arrays.asList(new Trait[]{Traits.draconic_ancestry, Traits.breath_weapon, Traits.damage_resistance}), Arrays.asList(new String[]{Languages.COMMON, Languages.DRACONIC}));
	public static Race dwarf = new Race("Dwarf", "", 0f, 25, Arrays.asList(new Trait[]{Traits.darkvision, Traits.dwarven_combat_training, Traits.dwarven_resilience}), Arrays.asList(new String[]{Languages.COMMON, Languages.DWARVISH}));
	public static Race elf = new Race("Elf", "", 0f, 30, Arrays.asList(new Trait[]{Traits.darkvision, Traits.keen_senses, Traits.fey_ancestory, Traits.trance}), Arrays.asList(new String[]{Languages.COMMON, Languages.ELVISH}));
	public static Race gnome = new Race("Gnome", "", 0f, 25, Arrays.asList(new Trait[]{Traits.darkvision, Traits.gnome_cunning}), Arrays.asList(new String[]{Languages.COMMON, Languages.GNOMISH}));
	public static Race half_elf = new Race("Half-Elf", "", 0f, 30, Arrays.asList(new Trait[]{Traits.darkvision, Traits.fey_ancestory, Traits.skill_versatility}), Arrays.asList(new String[]{Languages.COMMON, Languages.ELVISH}));
	public static Race halfling = new Race("Halfling", "", 0f, 25, Arrays.asList(new Trait[]{Traits.lucky, Traits.brave, Traits.halfling_nimbleness}), Arrays.asList(new String[]{Languages.COMMON, Languages.HALFLING}));
	public static Race half_orc = new Race("Half-Orc", "", 0f, 30, Arrays.asList(new Trait[]{Traits.darkvision, Traits.menacing, Traits.relentless_endurance, Traits.savage_attacks}), Arrays.asList(new String[]{Languages.COMMON, Languages.ORC}));
	public static Race human = new Race("Human", "", 0f, 30, Arrays.asList(new Trait[]{}), Arrays.asList(new String[]{Languages.COMMON}));
	public static Race tiefling = new Race("Tiefling", "", 0f, 30, Arrays.asList(new Trait[]{Traits.darkvision, Traits.hellish_resistance, Traits.infernal_legacy}), Arrays.asList(new String[]{Languages.COMMON, Languages.INFERNAL}));
	
	
	private static Race[] races = 
	{
		dragonborn,
		dwarf,
		elf,
		gnome,
		half_elf,
		halfling,
		half_orc,
		human,
		tiefling,
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
				race.centimetersToFeetInches(race.heightCentimeters);
				race.size = RaceSize.MEDIUM;
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
				race.centimetersToFeetInches(race.heightCentimeters);
				race.size = RaceSize.MEDIUM;
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
				race.centimetersToFeetInches(race.heightCentimeters);
				race.size = RaceSize.MEDIUM;
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
				race.centimetersToFeetInches(race.heightCentimeters);
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
				race.centimetersToFeetInches(race.heightCentimeters);
				race.size = RaceSize.MEDIUM;
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
				race.centimetersToFeetInches(race.heightCentimeters);
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
				race.centimetersToFeetInches(race.heightCentimeters);
				race.size = RaceSize.MEDIUM;
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
				race.centimetersToFeetInches(race.heightCentimeters);
				race.size = RaceSize.MEDIUM;
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
				race.centimetersToFeetInches(race.heightCentimeters);
				race.size = RaceSize.MEDIUM;
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
				race.centimetersToFeetInches(race.heightCentimeters);
				race.size = RaceSize.MEDIUM;
				minimum = 90f;
				maximum = 250f - minimum;
				race.weight = Generate(minimum, maximum);
				aMin = 16;
				aMax = 35 - aMin;
				race.age = RPGGame.random.nextInt(aMax) + aMin;
				break;
		}
	}
	
	public static float Generate(float minimum, float maximum) 
	{
		return Float.valueOf("" + (RPGGame.random.nextInt((int) maximum) + (int) minimum) + "." + (RPGGame.random.nextInt(100)));
	}
}
