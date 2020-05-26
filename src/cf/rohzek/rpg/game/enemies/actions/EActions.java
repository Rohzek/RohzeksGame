package cf.rohzek.rpg.game.enemies.actions;

import java.util.Arrays;
import java.util.List;

import cf.rohzek.rpg.game.enemies.actions.EAction.ActionType;
import cf.rohzek.rpg.game.items.Weapon.DamageType;

public class EActions 
{
	public static EAction acid = new EAction("Acid", "1d8", ActionType.MELEE_WEAPON_ATTACK, DamageType.POISON, 5, 1);
	public static EAction bite= new EAction("Bite", "1d4+2", ActionType.MELEE_WEAPON_ATTACK, DamageType.PIERCING, 5, 1);
	public static EAction bite_mimic = new EAction("Bite", "1d8+3", ActionType.MELEE_WEAPON_ATTACK, DamageType.PIERCING, 5, 1);
	public static EAction dagger = new EAction("Dagger", "1d4+2", ActionType.MELEE_WEAPON_ATTACK, DamageType.PIERCING, 5, 1);
	public static EAction longsword = new EAction("Longsword", "1d8+1", ActionType.MELEE_WEAPON_ATTACK, DamageType.SLASHING, 5, 1);
	public static EAction long_bow = new EAction("Longbow", "1d8+1", ActionType.RANGED_WEAPON_ATTACK, DamageType.PIERCING, 150, 1);
	public static EAction pseudopod = new EAction("Pseudopod", "1d8+3", ActionType.MELEE_WEAPON_ATTACK, DamageType.BLUDGEONING, 5, 1);
	public static EAction scimitar = new EAction("Scimitar", "1d6+2", ActionType.MELEE_WEAPON_ATTACK, DamageType.SLASHING, 5, 1);
	public static EAction short_bow = new EAction("Short Bow", "1d6+2", ActionType.RANGED_WEAPON_ATTACK, DamageType.PIERCING, 80, 1);
	public static EAction sling = new EAction("Sling", "1d4+2", ActionType.RANGED_WEAPON_ATTACK, DamageType.BLUDGEONING, 30, 1);
	public static EAction spear = new EAction("Spear", "1d6+2", ActionType.MELEE_WEAPON_ATTACK, DamageType.PIERCING, 5, 1);
	public static EAction spear_ranged = new EAction("Spear", "1d6+2", ActionType.RANGED_WEAPON_ATTACK, DamageType.PIERCING, 20, 1);
	
	private static EAction[] actions = 
	{
			acid,
			bite,
			bite_mimic,
			dagger,
			longsword,
			long_bow,
			pseudopod,
			scimitar,
			short_bow,
			sling,
			spear,
			spear_ranged,
	};
	
	public static List<EAction> ACTIONS = Arrays.asList(actions);
}
