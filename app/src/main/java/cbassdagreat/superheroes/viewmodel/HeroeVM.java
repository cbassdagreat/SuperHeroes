package cbassdagreat.superheroes.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import cbassdagreat.superheroes.cliente.ClienteRetrofit;
import cbassdagreat.superheroes.modelo.SuperHeroe;
import cbassdagreat.superheroes.modelo.SuperHeroes;
import cbassdagreat.superheroes.service.SHService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HeroeVM extends ViewModel {


    private SHService service = ClienteRetrofit.getInstance(ClienteRetrofit.BASE_URL);
    private MutableLiveData<List<SuperHeroe>> miSuperHeroes= new MutableLiveData<List<SuperHeroe>>();
    private MutableLiveData<SuperHeroe> miSuperHeroe = new MutableLiveData<>();
    public void llamarApi(){

        service.getSuperHeroes().enqueue(new Callback<List<SuperHeroe>>() {
            @Override
            public void onResponse(Call<List<SuperHeroe>> call, Response<List<SuperHeroe>> response) {
                miSuperHeroes.postValue(response.body());

            }

            @Override
            public void onFailure(Call<List<SuperHeroe>> call, Throwable t) {
                Log.i("API", t.getMessage());
                call.cancel();
            }
        });
    }
    public void obtenerSuperHeroe(SuperHeroe superHeroe){
        miSuperHeroe.setValue(superHeroe);
    }

    public MutableLiveData<List<SuperHeroe>> getMiSuperHeroes() {
        return miSuperHeroes;
    }

    public MutableLiveData<SuperHeroe> getMiSuperHeroe(){
        return miSuperHeroe;
    }
}
