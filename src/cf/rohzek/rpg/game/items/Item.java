package cf.rohzek.rpg.game.items;

public class Item 
{
	public String name;
	public double value;
	public float weight;
	
	public Item(String name, double value, float weight) 
	{
		this.name = name;
		this.value = value;
		this.weight = weight;
	}
	
	public Item copy() 
	{
		return new Item(this.name, this.value, this.weight);
	}
	
	@Override
	public String toString() 
	{
		return this.name;
	}
}
