package cf.rohzek.rpg.util;

import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;

import cf.rohzek.rpg.RPGGame;
import cf.rohzek.rpg.game.character.Character;
import cf.rohzek.rpg.game.character.race.Race;
import cf.rohzek.rpg.game.character.stats.Abilities;
import cf.rohzek.rpg.game.character.stats.Core;
import cf.rohzek.rpg.game.character.traits.Trait;
import cf.rohzek.rpg.game.items.Armor;
import cf.rohzek.rpg.game.items.Item;

public class Save 
{
	public static void Write(Character character, String path) 
	{	    
		path = RPGGame.directory + "\\" + path;
		
		Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
		
		JsonObject json = new JsonObject();
		
		json.addProperty("name", character.name);
		json.addProperty("gender", character.gender);
		json.add("health", health(character));
		json.add("mana", mana(character));
		json.addProperty("ac", character.ac);
		json.addProperty("level", character.level);
		json.addProperty("experience", character.experience);
		json.add("stats", stats(character));
		json.add("race", race(character));
		json.add("class", classs(character));
		json.add("magicks", magicks(character));
		json.add("inventory", inventory(character));
		json.addProperty("battles", character.battles);
		
		FileWriter writer;
		try 
		{
			writer = new FileWriter(path, false);
			
			gson.toJson(json, writer);
			
			writer.flush();
			writer.close();
		} 
		catch (JsonIOException | IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	private static JsonObject health(Character character) 
	{
		JsonObject health = new JsonObject();
		health.addProperty("current", character.health.current);
		health.addProperty("max", character.health.max);
		
		return health;
	}
	
	private static JsonObject mana(Character character) 
	{
		JsonObject mana = new JsonObject();
		mana.addProperty("current", character.health.current);
		mana.addProperty("max", character.health.max);
		
		return mana;
	}
	
	private static JsonObject stats (Character character) 
	{
		JsonObject stats = new JsonObject();
		stats.add("core", core(character.stats.core));
		stats.add("abilities", abilites(character.stats.abilities));
		
		return stats;
	}
	
	private static JsonObject core (Core core) 
	{
		JsonObject coreObj = new JsonObject();
		coreObj.addProperty("strength", core.strength);
		coreObj.addProperty("dexterity", core.dexterity);
		coreObj.addProperty("constitution", core.constitution);
		coreObj.addProperty("intelligence", core.intelligence);
		coreObj.addProperty("wisdom", core.wisdom);
		coreObj.addProperty("charisma", core.charisma);
		coreObj.addProperty("initiative", core.initiative);
		
		return coreObj;
	}
	
	private static JsonObject abilites (Abilities abilities) 
	{
		JsonObject abilitiesObj = new JsonObject();
		abilitiesObj.addProperty("firstAid", abilities.firstAid);
		
		return abilitiesObj;
	}
	
	private static JsonObject race (Character character) 
	{
		JsonObject race = new JsonObject();
		race.addProperty("name", character.race.name);
		race.addProperty("age", character.race.age);
		race.addProperty("weight", character.race.weight);
		race.addProperty("heightCentimeters", character.race.heightCentimeters);
		race.add("traits", traits(character.race));
		race.add("languages", languages(character.race));
		
		return race;
	}
	
	private static JsonArray traits(Race race) 
	{
		JsonArray traits = new JsonArray();
		
		for(Trait trait : race.traits) 
		{
			traits.add(trait.name);
		}
		
		return traits;
	}
	
	private static JsonArray languages(Race race) 
	{
		JsonArray languages = new JsonArray();
		
		for(String l : race.languages) 
		{
			languages.add(l);
		}
		
		return languages;
	}
	
	private static JsonObject classs (Character character) 
	{
		JsonObject classs = new JsonObject();
		classs.addProperty("name", character.character_class.getName());
		classs.addProperty("god", character.character_class.getGod().name);
		classs.addProperty("alignment", character.character_class.getAlignment().name);
		
		return classs;
	}
	
	private static JsonArray magicks (Character character) 
	{
		JsonArray magicks = new JsonArray();
		
		return magicks;
	}
	
	private static JsonObject inventory (Character character) 
	{
		JsonObject inventory = new JsonObject();
		inventory.addProperty("platinum", character.inventory.platinum);
		inventory.addProperty("gold", character.inventory.gold);
		inventory.addProperty("silver", character.inventory.silver);
		inventory.addProperty("copper", character.inventory.copper);
		
		JsonArray items = new JsonArray();
		
		for(Item item : character.inventory.items) 
		{
			items.add(item.name);
		}
		
		inventory.add("items", items);
		
		inventory.addProperty("main_hand", character.inventory.main_hand.name);
		inventory.addProperty("off_hand", character.inventory.off_hand.name);
		
		JsonArray armors = new JsonArray();
		
		for(Armor item : character.inventory.armor) 
		{
			armors.add(item.name);
		}
		
		inventory.add("armor", armors);
		
		return inventory;
	}
}
