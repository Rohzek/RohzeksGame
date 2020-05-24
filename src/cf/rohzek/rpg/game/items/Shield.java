package cf.rohzek.rpg.game.items;

public class Shield extends Item
{
	public enum ShieldMaterial
	{
		IRON,
		LEATHER,
		WOODEN
	}
	
	public ShieldMaterial type;
	public int armorClass;
	
	public Shield(String name, double value, float weight, ShieldMaterial type, int ac) 
	{
		super(name, value, weight);
		this.type = type;
		this.armorClass = ac;
	}

}
