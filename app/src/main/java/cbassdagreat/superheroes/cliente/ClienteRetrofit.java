package cbassdagreat.superheroes.cliente;

import cbassdagreat.superheroes.service.SHService;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ClienteRetrofit {

    private static Retrofit instance;
    public final static String BASE_URL = "https://akabab.github.io/superhero-api/api/";

    private ClienteRetrofit(){}

    public static SHService getInstance(String url){
        if (instance == null)
        {
            instance = new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return instance.create(SHService.class);
    }

}
