package cbassdagreat.superheroes.modelo;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class SuperHeroes{

	@SerializedName("SuperHeroes")
	private List<SuperHeroe> superHeroes;

	public List<SuperHeroe> getSuperHeroes(){
		return superHeroes;
	}
}