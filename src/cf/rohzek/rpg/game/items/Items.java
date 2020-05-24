package cf.rohzek.rpg.game.items;

import java.util.Arrays;
import java.util.List;

import cf.rohzek.rpg.game.items.Armor.ArmorMaterial;
import cf.rohzek.rpg.game.items.Armor.ArmorSlot;
import cf.rohzek.rpg.game.items.ItemPotion.PotionLevel;
import cf.rohzek.rpg.game.items.ItemPotion.PotionType;
import cf.rohzek.rpg.game.items.Shield.ShieldMaterial;
import cf.rohzek.rpg.game.items.Weapon.DamageType;
import cf.rohzek.rpg.game.items.Weapon.Enchantment;

public class Items 
{	
	// https://www.dndbeyond.com/items
	private static Item[] items = 
	{
			// Misc Items
			
			// Food
			
			// Armor
			new Armor("Leather Helmet", 3d, 2f, 1, ArmorMaterial.LEATHER, ArmorSlot.HEAD),
			new Armor("Leather Pauldrons", 3d, 2f, 1, ArmorMaterial.LEATHER, ArmorSlot.SHOULDERS),
			new Armor("Leather Breastplate", 8d, 10f, 1, ArmorMaterial.LEATHER, ArmorSlot.CHEST),
			new Armor("Leather Couter", 3d, 2f, 1, ArmorMaterial.LEATHER, ArmorSlot.ARMS),
			new Armor("Leather Bracers", 3d, 1f, 1, ArmorMaterial.LEATHER, ArmorSlot.WRISTS),
			new Armor("Leather Gloves", 3d, 1f, 1, ArmorMaterial.LEATHER, ArmorSlot.HANDS),
			new Armor("Leather Greaves", 6d, 5f, 1, ArmorMaterial.LEATHER, ArmorSlot.LEGS),
			new Armor("Leather Boots", 3d, 2f, 1, ArmorMaterial.LEATHER, ArmorSlot.FEET),
			
			new Armor("Studded Leather Helmet", 6d, 3f, 2, ArmorMaterial.LEATHER_STUDDED, ArmorSlot.HEAD),
			new Armor("Studded Leather Pauldrons", 6d, 3f, 2, ArmorMaterial.LEATHER_STUDDED, ArmorSlot.SHOULDERS),
			new Armor("Studded Leather Breastplate", 16d, 16f, 2, ArmorMaterial.LEATHER_STUDDED, ArmorSlot.CHEST),
			new Armor("Studded Leather Couter", 6d, 3f, 2, ArmorMaterial.LEATHER_STUDDED, ArmorSlot.ARMS),
			new Armor("Studded Leather Bracers", 6d, 2f, 2, ArmorMaterial.LEATHER_STUDDED, ArmorSlot.WRISTS),
			new Armor("Studded Leather Gloves", 6d, 2f, 2, ArmorMaterial.LEATHER_STUDDED, ArmorSlot.HANDS),
			new Armor("Studded Leather Greaves", 12d, 8f, 2, ArmorMaterial.LEATHER_STUDDED, ArmorSlot.LEGS),
			new Armor("Studded Leather Boots", 6d, 3f, 2, ArmorMaterial.LEATHER_STUDDED, ArmorSlot.FEET),
			
			new Armor("Iron Helmet", 12d, 5f, 5, ArmorMaterial.IRON, ArmorSlot.HEAD),
			new Armor("Iron Pauldrons", 12d, 5f, 5, ArmorMaterial.IRON, ArmorSlot.SHOULDERS),
			new Armor("Iron Breastplate", 32d, 20f, 5, ArmorMaterial.IRON, ArmorSlot.CHEST),
			new Armor("Iron Couter", 12d, 5f, 5, ArmorMaterial.IRON, ArmorSlot.ARMS),
			new Armor("Iron Bracers", 12d, 3f, 5, ArmorMaterial.IRON, ArmorSlot.WRISTS),
			new Armor("Iron Gauntlets", 12d, 3f, 5, ArmorMaterial.IRON, ArmorSlot.HANDS),
			new Armor("Iron Greaves", 24d, 10f, 5, ArmorMaterial.IRON, ArmorSlot.LEGS),
			new Armor("Iron Sabaton", 12d, 5f, 5, ArmorMaterial.IRON, ArmorSlot.FEET),
			
			// Weapons
			new Weapon("Shortsword", 10d, 2f, "d6", DamageType.PIERCING, Enchantment.NONE, 1, true),
			new Weapon("Shortsword+1", 12d, 2f, "d6+1", DamageType.PIERCING, Enchantment.NONE, 1, true),
			new Weapon("Shortsword+2", 14d, 2f, "d6+2", DamageType.PIERCING, Enchantment.NONE, 1, true),
			new Weapon("Shortsword+3", 18d, 2f, "d6+3", DamageType.PIERCING, Enchantment.NONE, 1, true),
			
			new Weapon("Longsword", 15d, 3f, "d8", DamageType.SLASHING, Enchantment.NONE, 1, false),
			new Weapon("Longsword+1", 20d, 3f, "d8+1", DamageType.SLASHING, Enchantment.NONE, 1, false),
			new Weapon("Longsword+2", 25d, 3f, "d8+2", DamageType.SLASHING, Enchantment.NONE, 1, false),
			new Weapon("Longsword+3", 30d, 3f, "d8+3", DamageType.SLASHING, Enchantment.NONE, 1, false),
			
			new Weapon("Greatsword", 50d, 6f, "2d6", DamageType.SLASHING, Enchantment.NONE, 2, false),
			new Weapon("Greatsword+1", 75d, 6f, "2d6+1", DamageType.SLASHING, Enchantment.NONE, 2, false),
			new Weapon("Greatsword+2", 100d, 6f, "2d6+2", DamageType.SLASHING, Enchantment.NONE, 2, false),
			new Weapon("Greatsword+3", 150d, 6f, "2d6+3", DamageType.SLASHING, Enchantment.NONE, 2, false),
			
			new Weapon("Quarterstaff", 2d, 6f, "1d6", DamageType.BLUDGEONING, Enchantment.NONE, 2, false),
			new Weapon("Quarterstaff+1", 5d, 6f, "1d6+1", DamageType.BLUDGEONING, Enchantment.NONE, 2, false),
			new Weapon("Quarterstaff+2", 10d, 6f, "1d6+2", DamageType.BLUDGEONING, Enchantment.NONE, 2, false),
			new Weapon("Quarterstaff+3", 15d, 6f, "1d6+3", DamageType.BLUDGEONING, Enchantment.NONE, 2, false),
			
			new Weapon("Mace", 5d, 4f, "1d6", DamageType.BLUDGEONING, Enchantment.NONE, 1, false),
			new Weapon("Mace+1", 7d, 4f, "1d6+1", DamageType.BLUDGEONING, Enchantment.NONE, 1, false),
			new Weapon("Mace+2", 10d, 4f, "1d6+2", DamageType.BLUDGEONING, Enchantment.NONE, 1, false),
			new Weapon("Mace+3", 15d, 4f, "1d6+3", DamageType.BLUDGEONING, Enchantment.NONE, 1, false),
			
			new Weapon("Light Hammer", 2d, 2f, "1d4", DamageType.BLUDGEONING, Enchantment.NONE, 1, false),
			new Weapon("Light Hammer+1", 4d, 2f, "1d4+1", DamageType.BLUDGEONING, Enchantment.NONE, 1, false),
			new Weapon("Light Hammer+2", 6d, 2f, "1d4+2", DamageType.BLUDGEONING, Enchantment.NONE, 1, false),
			new Weapon("Light Hammer+3", 8d, 2f, "1d4+3", DamageType.BLUDGEONING, Enchantment.NONE, 1, false),
			
			new Weapon("Warhammer", 2d, 2f, "1d8", DamageType.BLUDGEONING, Enchantment.NONE, 2, false),
			new Weapon("Warhammer+1", 4d, 2f, "1d8+1", DamageType.BLUDGEONING, Enchantment.NONE, 2, false),
			new Weapon("Warhammer+2", 6d, 2f, "1d8+2", DamageType.BLUDGEONING, Enchantment.NONE, 2, false),
			new Weapon("Warhammer+3", 8d, 2f, "1d8+3", DamageType.BLUDGEONING, Enchantment.NONE, 2, false),
			
			// Shields
			new Shield("Iron Buckler", 10d, 8f, ShieldMaterial.IRON, 3),
			new Shield("Leather Buckler", 5d, 6f, ShieldMaterial.LEATHER, 2),
			new Shield("Wooden Buckler", 2d, 4f, ShieldMaterial.WOODEN, 1),
			
			new Shield("Iron Heater Shield", 15d, 15f, ShieldMaterial.IRON, 4),
			new Shield("Leather Heater Shield", 10d, 9f, ShieldMaterial.LEATHER, 3),
			new Shield("Wooden Heater Shield", 8d, 10f, ShieldMaterial.WOODEN, 2),
			
			new Shield("Iron Kite Shield", 20d, 20f, ShieldMaterial.IRON, 5),
			new Shield("Leather Kite Shield", 15d, 14f, ShieldMaterial.LEATHER, 4),
			new Shield("Wooden Kite Shield", 10d, 15f, ShieldMaterial.WOODEN, 3),
			
			new Shield("Iron Greatshield", 50d, 25f, ShieldMaterial.IRON, 8),
			new Shield("Leather Greatshield", 45d, 15f, ShieldMaterial.LEATHER, 7),
			new Shield("Wooden Greatshield", 40d, 20f, ShieldMaterial.WOODEN, 6),
			
			// Potions
			new ItemPotion("Lesser Potion of Healing", 3d, 1f, PotionType.HEALTH_POTION, PotionLevel.LESSER),
			new ItemPotion("Small Potion of Healing", 3d, 1f, PotionType.HEALTH_POTION, PotionLevel.SMALL),
			new ItemPotion("Potion of Healing", 3d, 1f, PotionType.HEALTH_POTION, PotionLevel.MEDIUM),
			new ItemPotion("Large Potion of Healing", 3d, 1f, PotionType.HEALTH_POTION, PotionLevel.LARGE),
			new ItemPotion("Greater Potion of Healing", 3d, 1f, PotionType.HEALTH_POTION, PotionLevel.GREATER),
			
			new ItemPotion("Lesser Potion of Mana", 3d, 1f, PotionType.MANA_POTION, PotionLevel.LESSER),
			new ItemPotion("Small Potion of Mana", 3d, 1f, PotionType.MANA_POTION, PotionLevel.SMALL),
			new ItemPotion("Potion of Mana", 3d, 1f, PotionType.MANA_POTION, PotionLevel.MEDIUM),
			new ItemPotion("Large Potion of Mana", 3d, 1f, PotionType.MANA_POTION, PotionLevel.LARGE),
			new ItemPotion("Greater Potion of Mana", 3d, 1f, PotionType.MANA_POTION, PotionLevel.GREATER),
	};
	
	public static List<Item> ITEMS = Arrays.asList(items);
	
	public static Item Get(String name) 
	{
		for(Item item : ITEMS) 
		{
			if(item.name.toLowerCase().contains(name)) 
			{
				return item;
			}
		}
		
		return null;
	}
}
