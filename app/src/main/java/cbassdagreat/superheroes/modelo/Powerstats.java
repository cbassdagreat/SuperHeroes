package cbassdagreat.superheroes.modelo;

import com.google.gson.annotations.SerializedName;

public class Powerstats{

	@SerializedName("strength")
	private int strength;

	@SerializedName("durability")
	private int durability;

	@SerializedName("combat")
	private int combat;

	@SerializedName("power")
	private int power;

	@SerializedName("speed")
	private int speed;

	@SerializedName("intelligence")
	private int intelligence;

	public int getStrength(){
		return strength;
	}

	public int getDurability(){
		return durability;
	}

	public int getCombat(){
		return combat;
	}

	public int getPower(){
		return power;
	}

	public int getSpeed(){
		return speed;
	}

	public int getIntelligence(){
		return intelligence;
	}
}