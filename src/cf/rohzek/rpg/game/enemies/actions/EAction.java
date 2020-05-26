package cf.rohzek.rpg.game.enemies.actions;

import cf.rohzek.rpg.game.items.Weapon.DamageType;

public class EAction 
{
	public enum ActionType
	{
		MELEE_WEAPON_ATTACK,
		RANGED_WEAPON_ATTACK
	}
	
	public String name;
	public String hit;
	public ActionType type;
	DamageType damageType;
	public int reach;
	public int targetCount;
	
	public EAction(String name, String hit, ActionType type, DamageType dtype, int reach, int targets) 
	{
		this.name = name;
		this.hit = hit;
		this.type = type;
		this.damageType = dtype;
		this.reach = reach;
		this.targetCount = targets;
	}
	
	@Override
	public String toString() 
	{
		return name;
	}
}
