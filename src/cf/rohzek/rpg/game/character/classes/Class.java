package cf.rohzek.rpg.game.character.classes;

import cf.rohzek.rpg.game.character.alignment.Alignment;
import cf.rohzek.rpg.game.character.religion.God;

public class Class implements IClass
{
	private String name;
	private String description;
	private Alignment alignment;
	private God god;
	
	private String hitDice;
	private int baseHP;
	private String manaDice;
	private int baseMP;
	
	public Class(String name, String hd, int base, String md, int basem, String description) 
	{
		this.name = name;
		this.hitDice = hd;
		this.baseHP = base;
		this.manaDice = md;
		this.baseMP = basem;
		this.description = description;
	}
	
	public Class copy() 
	{
		return new Class(this.name, this.hitDice, this.baseHP, this.manaDice, this.baseMP, this.description);
	}

	@Override
	public String getName() 
	{
		return name;
	}

	@Override
	public String getHitDice() 
	{
		return hitDice;
	}

	@Override
	public String getManaDice() 
	{
		return manaDice;
	}

	@Override
	public int getBaseHP() 
	{
		return baseHP;
	}

	@Override
	public int getBaseMP() 
	{
		return baseMP;
	}

	@Override
	public String getDescription() 
	{
		return description;
	}

	@Override
	public God getGod() 
	{
		return god;
	}

	@Override
	public Alignment getAlignment() 
	{
		return alignment;
	}

	@Override
	public void setDescription(String description) 
	{
		this.description = description;
		
	}

	@Override
	public void setGod(God god) 
	{
		this.god = god;
		
	}

	@Override
	public void setAlignment(Alignment alignment)
	{
		this.alignment = alignment;
	}
	
	@Override
	public String toString() 
	{
		return this.getName();
	}
}
