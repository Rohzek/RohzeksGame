package cf.rohzek.rpg.game.character.race;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import cf.rohzek.rpg.game.character.traits.Trait;

public class Race implements Serializable
{
	private static final long serialVersionUID = 6876484013751776063L;

	public enum RaceSize
	{
		SMALL,
		MEDIUM,
		LARGE,
	}
	
	public String name = "";
	public int age = 0;
	public float weight = 0f;
	public String description = "";
	public RaceSize size;
	public int speed = 30;
	public int heightFeet = 0;
	public int heightInches = 0;
	public float heightCentimeters = 0;
	public List<Trait> traits;
	public ArrayList<String> languages = new ArrayList<String>();
	
	public Race(String name, int age, float weight, String description, RaceSize size, float cm, int speed, List<Trait> traits, List<String> languages) 
	{
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.description = description;
		this.traits = traits;

		for(String string : languages) 
		{
			this.languages.add(string);
		}
		
		centimetersToFeetInches(cm);
	}
	
	public Race(String name, int age, float weight, String description, RaceSize size, int feet, int inches, int speed, List<Trait> traits, List<String> languages) 
	{
		this.name = name;
		this.description = description;
		this.traits = traits;

		for(String string : languages) 
		{
			this.languages.add(string);
		}
		
		feetInchesToCentimeters(feet, inches);
	}

	public Race copy()
	{
		return new Race(this.name, this.age, this.weight, this.description, this.size, this.heightCentimeters, this.speed, this.traits, this.languages);
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
	
	public String getWeight(String way) 
	{
		if(way.toLowerCase().equals("imperial")) 
		{
			return "" + weight + "lbs";
		}
		else
		{
			return "" + (weight / 2.205f) + "kgs";
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
	
	@Override
	public String toString() 
	{
		return this.name;
	}
}
