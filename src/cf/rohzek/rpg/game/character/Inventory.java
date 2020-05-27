package cf.rohzek.rpg.game.character;

import java.util.ArrayList;
import java.util.List;

import cf.rohzek.rpg.game.items.Armor;
import cf.rohzek.rpg.game.items.Item;
import cf.rohzek.rpg.game.items.Items;

public class Inventory 
{
	public int platinum = 0,
			   gold = 0,
			   silver = 0,
			   copper = 0;
	
	public List<Item> items = new ArrayList<Item>();
	
	public Item main_hand = Items.NOTHING;
	public Item off_hand = Items.NOTHING;
	public List<Armor> armor = new ArrayList<Armor>();
	
	public Inventory() {}
	
	public Inventory(int pp, int gp, int sp, int cp, List<Item> items, Item main_hand, Item off_hand, List<Armor> armor) 
	{
		this.platinum = pp;
		this.gold = gp;
		this.silver = sp;
		this.copper = cp;
		
		this.items = items;
	}
	
	public Inventory copy() 
	{
		return new Inventory(this.platinum, this.gold, this.silver, this.copper, this.items, this.main_hand, this.off_hand, this.armor);
	}
	
	public void EquipMainHand() {}
	public void EquipOffHand() {}
	public void EquipArmor() {}
}
