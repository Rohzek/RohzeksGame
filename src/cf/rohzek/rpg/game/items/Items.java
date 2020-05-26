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

//https://www.dndbeyond.com/items
public class Items 
{	
	// Armor
	public static Armor LEATHER_HELMET = new Armor("Leather Helmet", 3d, 2f, 2, ArmorMaterial.LEATHER, ArmorSlot.HEAD);
	public static Armor LEATHER_PAULDRONS = new Armor("Leather Pauldrons", 3d, 2f, 2, ArmorMaterial.LEATHER, ArmorSlot.SHOULDERS);
	public static Armor LEATHER_BREASTPLATE = new Armor("Leather Breastplate", 8d, 10f, 2, ArmorMaterial.LEATHER, ArmorSlot.CHEST);
	public static Armor LEATHER_COUTER= new Armor("Leather Couter", 3d, 2f, 2, ArmorMaterial.LEATHER, ArmorSlot.ARMS);
	public static Armor LEATHER_BRACERS = new Armor("Leather Bracers", 3d, 1f, 2, ArmorMaterial.LEATHER, ArmorSlot.WRISTS);
	public static Armor LEATHER_GLOVES = new Armor("Leather Gloves", 3d, 1f, 2, ArmorMaterial.LEATHER, ArmorSlot.HANDS);
	public static Armor LEATHER_GREAVES = new Armor("Leather Greaves", 6d, 5f, 2, ArmorMaterial.LEATHER, ArmorSlot.LEGS);
	public static Armor LEATHER_BOOTS = new Armor("Leather Boots", 3d, 2f, 2, ArmorMaterial.LEATHER, ArmorSlot.FEET);
	
	public static List<Armor> LEATHER_SET = Arrays.asList(new Armor[] 
	{
		LEATHER_HELMET,
		LEATHER_PAULDRONS,
		LEATHER_BREASTPLATE,
		LEATHER_COUTER,
		LEATHER_BRACERS,
		LEATHER_GLOVES,
		LEATHER_GREAVES,
		LEATHER_BOOTS,
	});
	
	// Weapons
	public static Weapon LONGSWORD = new Weapon("Longsword", 15d, 3f, "d8", DamageType.SLASHING, Enchantment.NONE, 1, false);
	public static Weapon LONGSWORD_1 = new Weapon("Longsword+1", 20d, 3f, "d8+1", DamageType.SLASHING, Enchantment.NONE, 1, false);
	public static Weapon LONGSWORD_2 = new Weapon("Longsword+2", 25d, 3f, "d8+2", DamageType.SLASHING, Enchantment.NONE, 1, false);
	public static Weapon LONGSWORD_3 = new Weapon("Longsword+3", 30d, 3f, "d8+3", DamageType.SLASHING, Enchantment.NONE, 1, false);
	
	// Shields
	public static Shield IRON_BUCKLER = new Shield("Iron Buckler", 10d, 8f, ShieldMaterial.IRON, 3);
	public static Shield LEATHER_BUCKLER = new Shield("Leather Buckler", 5d, 6f, ShieldMaterial.LEATHER, 2);
	public static Shield WOODEN_BUCKLER = new Shield("Wooden Buckler", 2d, 4f, ShieldMaterial.WOODEN, 1);
	
	public static Shield IRON_HEATER = new Shield("Iron Heater Shield", 15d, 15f, ShieldMaterial.IRON, 4);
	public static Shield LEATHER_HEATER = new Shield("Leather Heater Shield", 10d, 9f, ShieldMaterial.LEATHER, 3);
	public static Shield WOODEN_HEATER = new Shield("Wooden Heater Shield", 8d, 10f, ShieldMaterial.WOODEN, 2);
	
	public static Shield IRON_KITE = new Shield("Iron Kite Shield", 20d, 20f, ShieldMaterial.IRON, 5);
	public static Shield LEATHER_KITE = new Shield("Leather Kite Shield", 15d, 14f, ShieldMaterial.LEATHER, 4);
	public static Shield WOODEN_KITE = new Shield("Wooden Kite Shield", 10d, 15f, ShieldMaterial.WOODEN, 3);
				
	public static Shield IRON_GREATSHIELD = new Shield("Iron Greatshield", 50d, 25f, ShieldMaterial.IRON, 8);
	public static Shield LEATHER_GREATSHIELD = new Shield("Leather Greatshield", 45d, 15f, ShieldMaterial.LEATHER, 7);
	public static Shield WOODEN_GREATSHIELD = new Shield("Wooden Greatshield", 40d, 20f, ShieldMaterial.WOODEN, 6);
	
	public static List<Shield> BUCKLER_SET = Arrays.asList(new Shield[] 
	{
		IRON_BUCKLER,
		LEATHER_BUCKLER,
		WOODEN_BUCKLER,
	});
	
	public static List<Shield> HEATER_SET = Arrays.asList(new Shield[] 
	{
		IRON_HEATER,
		LEATHER_HEATER,
		WOODEN_HEATER,
	});
	
	public static List<Shield> KITE_SET = Arrays.asList(new Shield[] 
	{
		IRON_KITE,
		LEATHER_KITE,
		WOODEN_KITE,
	});
	
	public static List<Shield> GREATSHIELD_SET = Arrays.asList(new Shield[] 
	{
		IRON_GREATSHIELD,
		LEATHER_GREATSHIELD,
		WOODEN_GREATSHIELD,
	});
	
	// Potions
	public static ItemPotion LESSER_POTION_OF_HEALING = new ItemPotion("Lesser Potion of Healing", 3d, 1f, PotionType.HEALTH_POTION, PotionLevel.LESSER);
	public static ItemPotion SMALL_POTION_OF_HEALING = new ItemPotion("Small Potion of Healing", 3d, 1f, PotionType.HEALTH_POTION, PotionLevel.SMALL);
	public static ItemPotion POTION_OF_HEALING = new ItemPotion("Potion of Healing", 3d, 1f, PotionType.HEALTH_POTION, PotionLevel.MEDIUM);
	public static ItemPotion LARGE_POTION_OF_HEALING = new ItemPotion("Large Potion of Healing", 3d, 1f, PotionType.HEALTH_POTION, PotionLevel.LARGE);
	public static ItemPotion GREATER_POTION_OF_HEALING = new ItemPotion("Greater Potion of Healing", 3d, 1f, PotionType.HEALTH_POTION, PotionLevel.GREATER);
	
	public static ItemPotion LESSER_POTION_OF_MANA = new ItemPotion("Lesser Potion of Mana", 3d, 1f, PotionType.MANA_POTION, PotionLevel.LESSER);
	public static ItemPotion SMALL_POTION_OF_MANA = new ItemPotion("Small Potion of Mana", 3d, 1f, PotionType.MANA_POTION, PotionLevel.SMALL);
	public static ItemPotion POTION_OF_MANA = new ItemPotion("Potion of Mana", 3d, 1f, PotionType.MANA_POTION, PotionLevel.MEDIUM);
	public static ItemPotion LARGE_POTION_OF_MANA = new ItemPotion("Large Potion of Mana", 3d, 1f, PotionType.MANA_POTION, PotionLevel.LARGE);
	public static ItemPotion GREATER_POTION_OF_MANA = new ItemPotion("Greater Potion of Mana", 3d, 1f, PotionType.MANA_POTION, PotionLevel.GREATER);
	
	private static Item[] items = 
	{
		LEATHER_HELMET,
		LEATHER_PAULDRONS,
		LEATHER_BREASTPLATE,
		LEATHER_COUTER,
		LEATHER_BRACERS,
		LEATHER_GLOVES,
		LEATHER_GREAVES,
		LEATHER_BOOTS,
		
		
		LONGSWORD,
		LONGSWORD_1,
		LONGSWORD_2,
		LONGSWORD_3,
		
		IRON_BUCKLER,
		LEATHER_BUCKLER,
		WOODEN_BUCKLER,

		IRON_HEATER,
		LEATHER_HEATER,
		WOODEN_HEATER,

		IRON_KITE,
		LEATHER_KITE,
		WOODEN_KITE,

		IRON_GREATSHIELD,
		LEATHER_GREATSHIELD,
		WOODEN_GREATSHIELD,
		
		LESSER_POTION_OF_HEALING,
		SMALL_POTION_OF_HEALING,
		POTION_OF_HEALING,
		LARGE_POTION_OF_HEALING,
		GREATER_POTION_OF_HEALING,
		LESSER_POTION_OF_MANA,
		SMALL_POTION_OF_MANA,
		POTION_OF_MANA,
		LARGE_POTION_OF_MANA,
		GREATER_POTION_OF_MANA,
		
		
			// Misc Items
			
			// Food
			
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
