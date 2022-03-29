package cbassdagreat.superheroes.service;

import java.util.List;

import cbassdagreat.superheroes.modelo.SuperHeroe;
import cbassdagreat.superheroes.modelo.SuperHeroes;
import retrofit2.Call;
import retrofit2.http.GET;

public interface SHService {

    @GET("all.json")
    public Call<List<SuperHeroe>> getSuperHeroes();

}
