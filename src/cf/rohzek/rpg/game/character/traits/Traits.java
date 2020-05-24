package cf.rohzek.rpg.game.character.traits;

import java.util.Arrays;
import java.util.List;

// http://www.d20srd.org/srd/variant/buildingCharacters/characterTraits.htm
public class Traits 
{
	public static Trait brave = new Trait("Brave", "");
	public static Trait breath_weapon = new Trait("Breath Weapon", "");
	public static Trait damage_resistance = new Trait("Damage Resistance", "");
	public static Trait darkvision = new Trait("Darkvision", "");
	public static Trait draconic_ancestry = new Trait("Draconic Ancestry", "");
	public static Trait dwarven_resilience = new Trait("Dwarven Resilience", "");
	public static Trait dwarven_combat_training = new Trait("Dwarven Combat Training", "");
	public static Trait fey_ancestory = new Trait("Fey Ancestory", "");
	public static Trait gnome_cunning = new Trait("Gnome Cunning", "");
	public static Trait halfling_nimbleness = new Trait("Halfling Nimbleness", "");
	public static Trait hellish_resistance = new Trait("Hellish Resilience", "");
	public static Trait infernal_legacy = new Trait("Infernal Legacy", "");
	public static Trait keen_senses = new Trait("Keen Senses", "");
	public static Trait lucky = new Trait("Lucky", "");
	public static Trait menacing = new Trait("Menacing", "");
	public static Trait relentless_endurance = new Trait("Relentless Endurance", "");
	public static Trait savage_attacks = new Trait("Savage Attacks", "");
	public static Trait skill_versatility = new Trait("Skill Versatility", "");
	public static Trait stonecunning = new Trait("Stonecunning", "");
	public static Trait trance = new Trait("Trance", "");
	
	private static Trait[] traits = 
	{
			brave,
			breath_weapon,
			damage_resistance,
			darkvision,
			draconic_ancestry,
			dwarven_resilience,
			dwarven_combat_training,
			fey_ancestory,
			gnome_cunning,
			halfling_nimbleness,
			hellish_resistance,
			infernal_legacy,
			keen_senses,
			lucky,
			menacing,
			relentless_endurance,
			savage_attacks,
			skill_versatility,
			stonecunning,
			trance,
	};
	
	public static List<Trait> TRAITS = Arrays.asList(traits);
}
