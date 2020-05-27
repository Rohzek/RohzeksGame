package cf.rohzek.rpg.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;

import cf.rohzek.rpg.RPGGame;

public class Settings 
{
	public static String measurements = "imperial";
	public static long type_speed = 20;
	
	static File settings;
	
	public static void Check() 
	{
		settings = new File(RPGGame.directory.getName());
		
		if(!settings.exists()) 
		{
			settings.mkdirs();
		}
		
		settings = new File(RPGGame.directory + "\\settings.json");
		
		if(settings.exists()) 
		{
			Load();
		}
		else 
		{
			Save();
		}
	}
	
	public static void Save() 
	{
		Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
		JsonObject json = new JsonObject();
		json.addProperty("measurements", measurements);
		json.addProperty("type_speed", type_speed);
		
		FileWriter writer;
		try 
		{
			writer = new FileWriter(settings, false);
			
			gson.toJson(json, writer);
			
			writer.flush();
			writer.close();
		} 
		catch (JsonIOException | IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void Load() 
	{
		String text;
		try 
		{
			text = new String(Files.readAllBytes(Paths.get(settings.getAbsolutePath())), StandardCharsets.UTF_8);
			JSONObject json = new JSONObject(text);
			measurements = json.getString("measurements");
			type_speed = json.getLong("type_speed");
			
			if(!measurements.toLowerCase().equals("imperial") && !measurements.toLowerCase().equals("metric")) 
			{
				measurements = "imperial";
			}
		} 
		catch (IOException | JSONException e) 
		{
			e.printStackTrace();
		}
	}
}
