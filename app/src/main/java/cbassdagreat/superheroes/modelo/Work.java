package cbassdagreat.superheroes.modelo;

import com.google.gson.annotations.SerializedName;

public class Work{

	@SerializedName("occupation")
	private String occupation;

	@SerializedName("base")
	private String base;

	public String getOccupation(){
		return occupation;
	}

	public String getBase(){
		return base;
	}
}