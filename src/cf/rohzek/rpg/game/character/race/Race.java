package cf.rohzek.rpg.game.character.race;

import java.util.ArrayList;
import java.util.List;

import cf.rohzek.rpg.game.character.traits.Trait;

public class Race 
{
	public enum RaceSize
	{
		SMALL,
		MEDIUM,
		LARGE,
	}
	
	public String name;
	public int age;
	public float weight;
	public String description;
	public RaceSize size;
	public int speed;
	int heightFeet;
	int heightInches;
	float heightCentimeters;
	public List<Trait> traits;
	public ArrayList<String> languages = new ArrayList<String>();
	public ArrayList<String> languages_original = new ArrayList<String>();
	
	public Race(String name, String description, float cm, int speed, List<Trait> traits, List<String> languages) 
	{
		this.name = name;
		this.description = description;
		this.traits = traits;

		for(String string : languages) 
		{
			this.languages.add(string);
		}
		
		for(String string : languages) 
		{
			this.languages_original.add(string);
		}
		
		centimetersToFeetInches(cm);
	}
	
	public Race(String name, String description, int feet, int inches, int speed, List<Trait> traits, List<String> languages) 
	{
		this.name = name;
		this.description = description;
		this.traits = traits;

		for(String string : languages) 
		{
			this.languages.add(string);
		}
		
		for(String string : languages) 
		{
			this.languages_original.add(string);
		}
		
		feetInchesToCentimeters(feet, inches);
	}
	
	public String getHeight(String way) 
	{
		if(way.toLowerCase().equals("imperial")) 
		{
			return heightFeet + "'" + heightInches + "\"";
		}
		else
		{
			return heightCentimeters + "cm";
		}
	}
	
	public void centimetersToFeetInches(float cm) 
	{
		float inches = (cm/2.54f);
		float feet = (inches/12f);
		inches = (inches % 12f);
		
		this.heightFeet = (int) feet;
		this.heightInches = (int) inches;
	}
	
	public void feetInchesToCentimeters(int feet, int inches) 
	{
		float totalInches = ((feet * 12f) + inches);
		float cm = (totalInches * 2.54f);
		
		this.heightCentimeters = cm;
	}
	
	public void resetLanguages() 
	{
		this.languages.clear();
		
		for(String language : this.languages_original) 
		{
			this.languages.add(language);
		}
	}
	
	@Override
	public String toString() 
	{
		return this.name;
	}
}
