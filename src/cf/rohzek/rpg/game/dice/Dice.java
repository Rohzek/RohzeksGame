package cf.rohzek.rpg.game.dice;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Dice 
{
	public Dice() {}
	
	public int Roll(String input) 
	{	
		Die die = Convert(input);
		int[] numbers = die.Roll();
		return numbers[1];
	}
	
	public List<Die> Roll(String input, int number) 
	{
		String[] inputs = input.split("\\s+");
		List<Die> dice = new ArrayList<Die>();
		
		for (String in : inputs) 
		{
			dice.add(Convert(in));
		}
		
		for(Die die : dice) 
		{
			die.Roll();
		}
		
		return dice;
	}
	
	/**
	 * Used to generate die with specific parameters already applied.
	 * @param input A regex expression to build a die. E.G. 2d4+3
	 * @return Returns the die object
	 */
	private static Die Convert(String input) 
	{
		Matcher match;
		Pattern patternCount = Pattern.compile("\\d+[dD]"),
			   patternSize = Pattern.compile("[dD]\\d+"), 
			   patternAddition = Pattern.compile("\\+\\d+"), 
			   patternSubtraction = Pattern.compile("\\-\\d+"), 
			   patternMultiplication = Pattern.compile("\\*\\d+"), 
			   patternDivision = Pattern.compile("\\/\\d+");
		
		int size = 1,
		 	count = 1,
		 	multiplication = 0,
		 	division = 1,
		 	addition = 0,
		 	subtraction = 0;
		
		match = patternCount.matcher(input);
		while(match.find()) 
		{
			String result = match.group(0);
			result = result.toLowerCase().replaceAll("([a-z])", "");
			count = Integer.parseInt(result);
		}
		
		match = patternSize.matcher(input);
		while(match.find()) 
		{
			String result = match.group(0);
			result = result.toLowerCase().replaceAll("([a-z])", "");
			size = Integer.parseInt(result);
		}
		
		match = patternAddition.matcher(input);
		while(match.find()) 
		{
			String result = match.group(0);
			result = result.replace("+", "");
			addition = Integer.parseInt(result);
		}
		
		match = patternSubtraction.matcher(input);
		while(match.find()) 
		{
			String result = match.group(0);
			result = result.replace("-", "");
			subtraction = Integer.parseInt(result);
		}
		
		match = patternMultiplication.matcher(input);
		while(match.find()) 
		{
			String result = match.group(0);
			result = result.replace("*", "");
			multiplication = Integer.parseInt(result);
		}
		
		match = patternDivision.matcher(input);
		while(match.find()) 
		{
			String result = match.group(0);
			result = result.replace("/", "");
			division = Integer.parseInt(result);
		}
		
		return new Die(size, count, multiplication, division, addition, subtraction);
	}
}
