package cf.rohzek.rpg.game.character.classes;

import cf.rohzek.rpg.game.character.alignment.Alignment;
import cf.rohzek.rpg.game.character.religion.God;

public interface IClass 
{
	public String getName();
	
	public String getDescription();
	public void setDescription(String description);
	public God getGod();
	public void setGod(God god);
	public Alignment getAlignment();
	public void setAlignment(Alignment alignment);
	
	public String getHitDice();
	public String getManaDice();
	public int getBaseHP();
	public int getBaseMP();
}
