package cf.rohzek.rpg.game.enemies.actions;

import java.util.Arrays;
import java.util.List;

import cf.rohzek.rpg.game.enemies.actions.EAction.ActionType;
import cf.rohzek.rpg.game.items.Weapon.DamageType;

public class EActions 
{
	public static EAction ACID = new EAction("Acid", "1d8", ActionType.MELEE_WEAPON_ATTACK, DamageType.POISON, 5, 1);
	public static EAction BITE= new EAction("Bite", "1d4+2", ActionType.MELEE_WEAPON_ATTACK, DamageType.PIERCING, 5, 1);
	public static EAction BITE_MIMIC = new EAction("Bite", "1d8+3", ActionType.MELEE_WEAPON_ATTACK, DamageType.PIERCING, 5, 1);
	public static EAction DAGGER = new EAction("Dagger", "1d4+2", ActionType.MELEE_WEAPON_ATTACK, DamageType.PIERCING, 5, 1);
	public static EAction LONGSWORD = new EAction("Longsword", "1d8+1", ActionType.MELEE_WEAPON_ATTACK, DamageType.SLASHING, 5, 1);
	public static EAction LONG_BOW = new EAction("Longbow", "1d8+1", ActionType.RANGED_WEAPON_ATTACK, DamageType.PIERCING, 150, 1);
	public static EAction PSEUDOPOD = new EAction("Pseudopod", "1d8+3", ActionType.MELEE_WEAPON_ATTACK, DamageType.BLUDGEONING, 5, 1);
	public static EAction SCIMITAR = new EAction("Scimitar", "1d6+2", ActionType.MELEE_WEAPON_ATTACK, DamageType.SLASHING, 5, 1);
	public static EAction SHORT_BOW = new EAction("Short Bow", "1d6+2", ActionType.RANGED_WEAPON_ATTACK, DamageType.PIERCING, 80, 1);
	public static EAction SLING = new EAction("Sling", "1d4+2", ActionType.RANGED_WEAPON_ATTACK, DamageType.BLUDGEONING, 30, 1);
	public static EAction SPEAR = new EAction("Spear", "1d6+2", ActionType.MELEE_WEAPON_ATTACK, DamageType.PIERCING, 5, 1);
	public static EAction SPEAR_RANGED = new EAction("Spear", "1d6+2", ActionType.RANGED_WEAPON_ATTACK, DamageType.PIERCING, 20, 1);
	
	private static EAction[] actions = 
	{
			ACID,
			BITE,
			BITE_MIMIC,
			DAGGER,
			LONGSWORD,
			LONG_BOW,
			PSEUDOPOD,
			SCIMITAR,
			SHORT_BOW,
			SLING,
			SPEAR,
			SPEAR_RANGED,
	};
	
	public static List<EAction> ACTIONS = Arrays.asList(actions);
}
