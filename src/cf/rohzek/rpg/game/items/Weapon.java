package cf.rohzek.rpg.game.items;

public class Weapon extends Item
{
	public enum DamageType
	{
		NONE,
		BLUDGEONING,
		PIERCING,
		POISON,
		SLASHING
	}
	
	public enum Enchantment
	{
		NONE
	}
	
	public String damage;
	public int handedness;
	public boolean offhand;
	public DamageType type;
	Enchantment enchantment;
	
	public Weapon(String name, double value, float weight, String damage, DamageType type, Enchantment enchantment, int handedness, boolean offhand) 
	{
		super(name, value, weight);
		this.damage = damage;
		this.type = type;
		this.enchantment = enchantment;
		this.handedness = handedness;
		this.offhand = offhand;
	}
}