package cbassdagreat.superheroes.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.resources.TextAppearance;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import  cbassdagreat.superheroes.R;
import cbassdagreat.superheroes.databinding.ItemLayoutBinding;
import cbassdagreat.superheroes.modelo.SuperHeroe;

public class HeroeAdapter extends RecyclerView.Adapter<HeroeAdapter.CustomViewHolder> {

    private List<SuperHeroe> list = new ArrayList<>();
    private MiOnClickListener listener;

    public void setList(List<SuperHeroe> list){
        this.list = list;
        notifyDataSetChanged();
    }

    public void setListener(MiOnClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.bindData(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class CustomViewHolder extends RecyclerView.ViewHolder{
        private ItemLayoutBinding binding;


        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = ItemLayoutBinding.bind(itemView);
        }

        public void bindData(SuperHeroe superHeroe) {

            Picasso.get().load(superHeroe.getImages().getMd()).into(binding.ivCard);
            binding.tvNombre.setText(superHeroe.getName());
            itemView.setOnClickListener(v -> {
                listener.onClickListener(superHeroe);
            });


            };
        }
        public interface MiOnClickListener {
        void onClickListener(SuperHeroe superHeroe);

    }
    }

