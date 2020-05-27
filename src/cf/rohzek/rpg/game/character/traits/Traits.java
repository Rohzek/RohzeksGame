package cf.rohzek.rpg.game.character.traits;

import java.util.Arrays;
import java.util.List;

// http://www.d20srd.org/srd/variant/buildingCharacters/characterTraits.htm
public class Traits 
{
	public static Trait BRAVE = new Trait("Brave", "");
	public static Trait BREATH_WEAPON = new Trait("Breath Weapon", "");
	public static Trait DAMAGE_RESISTANCE = new Trait("Damage Resistance", "");
	public static Trait DARKVISION = new Trait("Darkvision", "");
	public static Trait DRACONIC_ANCESTRY = new Trait("Draconic Ancestry", "");
	public static Trait DWARVEN_RESILIENCE = new Trait("Dwarven Resilience", "");
	public static Trait DWARVEN_COMBAT_TRAINING = new Trait("Dwarven Combat Training", "");
	public static Trait FEY_ANCESTORY = new Trait("Fey Ancestory", "");
	public static Trait GNOME_CUNNING = new Trait("Gnome Cunning", "");
	public static Trait HALFLING_NIMBLENESS = new Trait("Halfling Nimbleness", "");
	public static Trait HELLISH_RESISTANCE = new Trait("Hellish Resilience", "");
	public static Trait INFERNAL_LEGACY = new Trait("Infernal Legacy", "");
	public static Trait KEEN_SENSES = new Trait("Keen Senses", "");
	public static Trait LUCKY = new Trait("Lucky", "");
	public static Trait MENACING = new Trait("Menacing", "");
	public static Trait RELENTLESS_ENDURANCE = new Trait("Relentless Endurance", "");
	public static Trait SAVAGE_ATTACKS = new Trait("Savage Attacks", "");
	public static Trait SKILL_VERSATILITY = new Trait("Skill Versatility", "");
	public static Trait STONECUNNING = new Trait("Stonecunning", "");
	public static Trait TRANCE = new Trait("Trance", "");
	
	private static Trait[] traits = 
	{
			BRAVE,
			BREATH_WEAPON,
			DAMAGE_RESISTANCE,
			DARKVISION,
			DRACONIC_ANCESTRY,
			DWARVEN_RESILIENCE,
			DWARVEN_COMBAT_TRAINING,
			FEY_ANCESTORY,
			GNOME_CUNNING,
			HALFLING_NIMBLENESS,
			HELLISH_RESISTANCE,
			INFERNAL_LEGACY,
			KEEN_SENSES,
			LUCKY,
			MENACING,
			RELENTLESS_ENDURANCE,
			SAVAGE_ATTACKS,
			SKILL_VERSATILITY,
			STONECUNNING,
			TRANCE,
	};
	
	public static List<Trait> TRAITS = Arrays.asList(traits);
}
