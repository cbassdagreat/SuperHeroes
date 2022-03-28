package cbassdagreat.superheroes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import cbassdagreat.superheroes.cliente.ClienteRetrofit;
import cbassdagreat.superheroes.databinding.ActivityMainBinding;
import cbassdagreat.superheroes.service.SHService;
import cbassdagreat.superheroes.viewmodel.HeroeVM;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private HeroeVM viewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        viewModel = new ViewModelProvider(this).get(HeroeVM.class);

        viewModel.llamarApi();
    }
}