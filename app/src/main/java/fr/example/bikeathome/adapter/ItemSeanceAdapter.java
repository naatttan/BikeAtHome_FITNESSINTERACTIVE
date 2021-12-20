package fr.example.bikeathome.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.zip.Inflater;

import fr.example.bikeathome.R;

public class ItemSeanceAdapter extends RecyclerView.Adapter<ItemSeanceAdapter.itemSeanceViewHolder>{


    public class itemSeanceViewHolder extends RecyclerView.ViewHolder {
        private View itemSeance;
        public itemSeanceViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemSeance = itemView.findViewById(R.id.item_seance);
        }
    }



    @NonNull
    @Override
    public itemSeanceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_seance, parent, false);
        return new itemSeanceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull itemSeanceViewHolder holder, int position) {    }

    @Override
    public int getItemCount() {
        return 5;
    }

}
