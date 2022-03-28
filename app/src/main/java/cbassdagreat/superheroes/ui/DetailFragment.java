package cbassdagreat.superheroes.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cbassdagreat.superheroes.R;
import cbassdagreat.superheroes.databinding.FragmentDetailBinding;
import cbassdagreat.superheroes.viewmodel.HeroeVM;
import com.squareup.picasso.Picasso;

import cbassdagreat.superheroes.databinding.FragmentDetailBinding;
import cbassdagreat.superheroes.viewmodel.HeroeVM;


public class DetailFragment extends Fragment {

    private FragmentDetailBinding binding;
    private HeroeVM viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentDetailBinding.inflate(inflater,container,false);
        binding.setLifecycleOwner(getViewLifecycleOwner());
        viewModel = new ViewModelProvider(getActivity()).get(HeroeVM.class);

        viewModel.getMiSuperHeroe().observe(getViewLifecycleOwner(),superHeroe -> {
            binding.setSuperheroe(superHeroe);
            Picasso.get().load(superHeroe.getImages().getMd()).into(binding.ivPicSH);
        });
        return binding.getRoot();
    }
}