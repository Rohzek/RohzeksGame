package cf.rohzek.rpg.util;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cf.rohzek.rpg.RPGGame;
import cf.rohzek.rpg.game.character.Character;
import cf.rohzek.rpg.game.character.Inventory;
import cf.rohzek.rpg.game.character.Magic;
import cf.rohzek.rpg.game.character.alignment.Alignment;
import cf.rohzek.rpg.game.character.alignment.Alignments;
import cf.rohzek.rpg.game.character.classes.Classes;
import cf.rohzek.rpg.game.character.classes.IClass;
import cf.rohzek.rpg.game.character.health.Health;
import cf.rohzek.rpg.game.character.mana.Mana;
import cf.rohzek.rpg.game.character.race.Race;
import cf.rohzek.rpg.game.character.race.Races;
import cf.rohzek.rpg.game.character.religion.God;
import cf.rohzek.rpg.game.character.religion.Gods;
import cf.rohzek.rpg.game.character.stats.Abilities;
import cf.rohzek.rpg.game.character.stats.Core;
import cf.rohzek.rpg.game.character.stats.Stats;
import cf.rohzek.rpg.game.character.traits.Trait;
import cf.rohzek.rpg.game.character.traits.Traits;
import cf.rohzek.rpg.game.items.Armor;
import cf.rohzek.rpg.game.items.Item;
import cf.rohzek.rpg.game.items.Items;

public class Load 
{
	public static Character Read(String path) 
	{
		Character character = new Character();
		
		path = RPGGame.directory + "\\" + path;
		
		try 
		{
			String text = new String(Files.readAllBytes(Paths.get(path)), StandardCharsets.UTF_8);
			
			JSONObject json = new JSONObject(text);
			
			String name = json.getString("name");
			String gender = json.getString("gender");
			Health health = health(json.getJSONObject("health"));
			Mana mana = mana(json.getJSONObject("mana"));
			int ac = json.getInt("ac");
			int level = json.getInt("level");
			int experience = json.getInt("experience");
			Stats stats = stats(json.getJSONObject("stats"));
			Race race = race(json.getJSONObject("race"));
			IClass character_class = classs(json.getJSONObject("class"));
			List<Magic> magicks = magicks(json.getJSONArray("magicks"));
			Inventory inventory = inventory(json.getJSONObject("inventory"));
			int battles = json.getInt("battles");
			
			character = new Character(name, gender, health, mana, ac, level, experience, stats, race, character_class, magicks, inventory, battles);
		} 
		catch (IOException | JSONException e) 
		{
			e.printStackTrace();
		}
		
		return character;
	}
	
	private static Health health(JSONObject json) throws JSONException 
	{
		int current = json.getInt("current");
		int max = json.getInt("max");
		
		return new Health(current, max);
	}
	
	private static Mana mana(JSONObject json) throws JSONException 
	{
		int current = json.getInt("current");
		int max = json.getInt("max");
		
		return new Mana(current, max);
	}
	
	private static Stats stats(JSONObject json) throws JSONException 
	{
		return new Stats(core(json.getJSONObject("core")), abilities(json.getJSONObject("abilities")));
	}
	
	private static Core core(JSONObject json) throws JSONException 
	{
		Core core = new Core(json.getInt("strength"), json.getInt("dexterity"), json.getInt("constitution"), json.getInt("intelligence"), json.getInt("wisdom"), json.getInt("charisma"));
		core.initiative = json.getInt("initiative");
		
		return core;
	}
	
	private static Abilities abilities(JSONObject json) throws JSONException 
	{
		return new Abilities(json.getInt("firstAid"));
	}
	
	private static Race race(JSONObject json) throws JSONException 
	{
		Race race = null;
		
		String name = json.getString("name");
		
		for(Race rce : Races.RACES) 
		{
			if(rce.name.toLowerCase().equals(name.toLowerCase())) 
			{
				race = rce.copy();
			}
		}
		
		race.age = json.getInt("age");
		race.weight = (float) json.getDouble("weight");
		race.heightCentimeters = (float) json.getDouble("heightCentimeters");
		race.centimetersToFeetInches(race.heightCentimeters);
		
		JSONArray traitz = json.getJSONArray("traits");
		List<Trait> traits = new ArrayList<Trait>();
		
		for(int i = 0; i < traitz.length(); i++) 
		{
			for(Trait trait : Traits.TRAITS) 
			{
				if(trait.name.toLowerCase().equals(traitz.getString(i).toLowerCase())) 
				{
					traits.add(trait);
				}
			}
		}
		
		JSONArray lang = json.getJSONArray("languages");
		ArrayList<String> languages = new ArrayList<String>();
		
		for(int i = 0; i < lang.length(); i++) 
		{
			languages.add(lang.getString(i));
		}
		
		race.traits = traits;
		race.languages = languages;
		
		return race;
	}
	
	private static IClass classs(JSONObject json) throws JSONException 
	{
		IClass character_class = null;
		String name = json.getString("name");
		
		for(IClass c : Classes.CLASSES) 
		{
			if(c.getName().toLowerCase().equals(name.toLowerCase())) 
			{
				character_class = c.copy();
			}
		}
		
		God god = null;
		String godn = json.getString("god");
		
		for(God g : Gods.GODS) 
		{
			if(g.name.toLowerCase().equals(godn.toLowerCase())) 
			{
				god = g.copy();
			}
		}
		
		
		Alignment alignment = null;
		String align = json.getString("alignment");
		
		for(Alignment a : Alignments.ALIGNMENTS) 
		{
			if(a.name.toLowerCase().equals(align.toLowerCase())) 
			{
				alignment = a.copy();
			}
		}
		
		character_class.setGod(god);
		character_class.setAlignment(alignment);
		
		return character_class;
	}
	
	private static List<Magic> magicks(JSONArray json) 
	{
		List<Magic> magicks = new ArrayList<Magic>();
		
		return magicks;
	}
	
	private static Inventory inventory(JSONObject json) throws JSONException 
	{
		int platinum = json.getInt("platinum");
		int gold = json.getInt("gold");
		int silver = json.getInt("silver");
		int copper = json.getInt("copper");
		
		JSONArray itms = json.getJSONArray("items");
		List<Item> items = new ArrayList<Item>();
		
		for(int i = 0; i < itms.length(); i++) 
		{
			for(Item item : Items.ITEMS) 
			{
				if(item.name.toLowerCase().equals(itms.getString(i).toLowerCase())) 
				{
					items.add(item);
				}
			}
		}
		
		String main_hand_name = json.getString("main_hand");
		Item main_hand = Items.NOTHING;
		
		for(Item item : Items.ITEMS) 
		{
			if(item.name.toLowerCase().equals(main_hand_name.toLowerCase())) 
			{
				main_hand = item;
			}
		}
		
		String off_hand_name = json.getString("off_hand");
		Item off_hand = Items.NOTHING;
		
		for(Item item : Items.ITEMS) 
		{
			if(item.name.toLowerCase().equals(off_hand_name.toLowerCase())) 
			{
				off_hand = item;
			}
		}
		
		JSONArray armr = json.getJSONArray("armor");
		List<Armor> armors = new ArrayList<Armor>();
		
		for(int i = 0; i < itms.length(); i++) 
		{
			for(Armor armor : Items.ARMORS) 
			{
				if(armor.name.toLowerCase().equals(armr.getString(i).toLowerCase())) 
				{
					armors.add(armor);
				}
			}
		}
		
		return new Inventory(platinum, gold, silver, copper, items, main_hand, off_hand, armors);
	}
}
