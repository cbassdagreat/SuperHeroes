package cbassdagreat.superheroes.modelo;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Appearance{

	@SerializedName("gender")
	private String gender;

	@SerializedName("race")
	private String race;

	@SerializedName("eyeColor")
	private String eyeColor;

	@SerializedName("weight")
	private List<String> weight;

	@SerializedName("hairColor")
	private String hairColor;

	@SerializedName("height")
	private List<String> height;

	public String getGender(){
		return gender;
	}

	public String getRace(){
		return race;
	}

	public String getEyeColor(){
		return eyeColor;
	}

	public List<String> getWeight(){
		return weight;
	}

	public String getHairColor(){
		return hairColor;
	}

	public List<String> getHeight(){
		return height;
	}
}