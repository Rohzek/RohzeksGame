package cf.rohzek.rpg.util;

public class Typewriter
{
	public static void Type(String message) 
	{
		for(int i = 0; i < message.length(); i++) 
		{
			System.out.print(message.charAt(i));

			try 
			{
				Thread.sleep(Settings.type_speed);
			} 
			
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
		
		System.out.println();
	}
}
