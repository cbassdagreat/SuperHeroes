package cbassdagreat.superheroes.modelo;

import com.google.gson.annotations.SerializedName;

public class Response{

	@SerializedName("images")
	private Images images;

	@SerializedName("appearance")
	private Appearance appearance;

	@SerializedName("work")
	private Work work;

	@SerializedName("name")
	private String name;

	@SerializedName("powerstats")
	private Powerstats powerstats;

	@SerializedName("id")
	private int id;

	@SerializedName("biography")
	private Biography biography;

	@SerializedName("slug")
	private String slug;

	@SerializedName("connections")
	private Connections connections;

	public Images getImages(){
		return images;
	}

	public Appearance getAppearance(){
		return appearance;
	}

	public Work getWork(){
		return work;
	}

	public String getName(){
		return name;
	}

	public Powerstats getPowerstats(){
		return powerstats;
	}

	public int getId(){
		return id;
	}

	public Biography getBiography(){
		return biography;
	}

	public String getSlug(){
		return slug;
	}

	public Connections getConnections(){
		return connections;
	}
}