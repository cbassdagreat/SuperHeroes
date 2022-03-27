package cbassdagreat.superheroes.modelo;

import com.google.gson.annotations.SerializedName;

public class Connections{

	@SerializedName("groupAffiliation")
	private String groupAffiliation;

	@SerializedName("relatives")
	private String relatives;

	public String getGroupAffiliation(){
		return groupAffiliation;
	}

	public String getRelatives(){
		return relatives;
	}
}