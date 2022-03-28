package cbassdagreat.superheroes.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import cbassdagreat.superheroes.R;
import cbassdagreat.superheroes.adapter.HeroeAdapter;
import cbassdagreat.superheroes.databinding.FragmentListBinding;
import cbassdagreat.superheroes.modelo.SuperHeroe;
import cbassdagreat.superheroes.viewmodel.HeroeVM;


public class ListFragment extends Fragment {

    private FragmentListBinding binding;
    private HeroeVM viewModel;
    private HeroeAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentListBinding.inflate(inflater,container,false);
        viewModel = new ViewModelProvider(getActivity()).get(HeroeVM.class);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        adapter = new HeroeAdapter();
        GridLayoutManager manager = new GridLayoutManager(getContext(),1);
        binding.rvList.setAdapter(adapter);
        binding.rvList.setLayoutManager(manager);

        adapter.setListener(new HeroeAdapter.MiOnClickListener() {
            @Override
            public void onClickListener(SuperHeroe superHeroe) {
                viewModel.obtenerSuperHeroe(superHeroe);
                Navigation.findNavController(getView()).navigate(R.id.action_listFragment_to_detailFragment);
                                }



       });

        viewModel.getMiSuperHeroes().observe(getViewLifecycleOwner(), superHeroes -> {
            Log.i("SUPERHEROES",superHeroes.toString());
            adapter.setList(superHeroes.getSuperHeroes());
        });


    }
}