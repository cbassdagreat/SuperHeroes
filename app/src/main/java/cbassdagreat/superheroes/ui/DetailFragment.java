package cbassdagreat.superheroes.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cbassdagreat.superheroes.R;
import cbassdagreat.superheroes.databinding.FragmentDetailBinding;
import cbassdagreat.superheroes.viewmodel.HeroeVM;
import com.squareup.picasso.Picasso;

import java.util.List;

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
            binding.tvNomDetail.setText(superHeroe.getName());
            binding.tvIntelligenceData.setText(Integer.toString(superHeroe.getPowerstats().getIntelligence()));
            binding.tvStrengthData.setText(Integer.toString(superHeroe.getPowerstats().getStrength()));
            binding.tvSpeedData.setText(Integer.toString(superHeroe.getPowerstats().getSpeed()));
            binding.tvDurabilityData.setText(Integer.toString(superHeroe.getPowerstats().getDurability()));
            binding.tvPowerData.setText(Integer.toString(superHeroe.getPowerstats().getPower()));
            binding.tvCombatData.setText(Integer.toString(superHeroe.getPowerstats().getCombat()));
            binding.tvGenderData.setText(superHeroe.getAppearance().getGender());
            binding.tvRaceData.setText(superHeroe.getAppearance().getRace());
            binding.tvHairData.setText(superHeroe.getAppearance().getHairColor());
            binding.tvHeightData.setText(superHeroe.getAppearance().getHeight().get(1));
            binding.tvWeightData.setText(superHeroe.getAppearance().getWeight().get(1));
            binding.tvEyeData.setText(superHeroe.getAppearance().getEyeColor());
            binding.tvFullNameData.setText(superHeroe.getBiography().getFullName());
            binding.tvAliasData.setText(superHeroe.getBiography().getAliases().toString());
            binding.tvPobData.setText(superHeroe.getBiography().getPlaceOfBirth());
            binding.tvWorkData.setText(superHeroe.getWork().getOccupation());
            binding.tvPublisherData.setText(superHeroe.getBiography().getPublisher());
            binding.tvAlignData.setText(superHeroe.getBiography().getAlignment());
            binding.tvFullNameData.setText(superHeroe.getBiography().getFullName());
            binding.btnVolver.setOnClickListener(v -> {
                Navigation.findNavController(v).navigate(R.id.action_detailFragment_to_listFragment);
            });




        });
        return binding.getRoot();
    }
}