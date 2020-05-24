package cf.rohzek.rpg.game.items;

public class Armor extends Item
{
	public enum ArmorSlot
	{
		HEAD,
		SHOULDERS,
		CHEST,
		ARMS,
		WRISTS,
		HANDS,
		LEGS,
		FEET
	}
	
	public enum ArmorMaterial
	{
		LEATHER,
		LEATHER_STUDDED,
		IRON
	}
	
	public int armorClass;
	public ArmorMaterial material;
	public ArmorSlot slot;
	
	public Armor(String name, double value, float weight, int ac, ArmorMaterial material, ArmorSlot slot) 
	{
		super(name, value, weight);
		this.armorClass = ac;
		this.material = material;
		this.slot = slot;
	}
}
