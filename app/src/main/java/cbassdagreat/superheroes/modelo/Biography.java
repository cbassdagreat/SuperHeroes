package cbassdagreat.superheroes.modelo;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Biography{

	@SerializedName("firstAppearance")
	private String firstAppearance;

	@SerializedName("placeOfBirth")
	private String placeOfBirth;

	@SerializedName("aliases")
	private List<String> aliases;

	@SerializedName("fullName")
	private String fullName;

	@SerializedName("publisher")
	private String publisher;

	@SerializedName("alterEgos")
	private String alterEgos;

	@SerializedName("alignment")
	private String alignment;

	public String getFirstAppearance(){
		return firstAppearance;
	}

	public String getPlaceOfBirth(){
		return placeOfBirth;
	}

	public List<String> getAliases(){
		return aliases;
	}

	public String getFullName(){
		return fullName;
	}

	public String getPublisher(){
		return publisher;
	}

	public String getAlterEgos(){
		return alterEgos;
	}

	public String getAlignment(){
		return alignment;
	}
}