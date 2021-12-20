package fr.example.bikeathome.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import fr.example.bikeathome.R;
import fr.example.bikeathome.adapter.ItemSeanceAdapter;

public class HomeFragment extends Fragment {



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View seanceView = inflater.inflate(R.layout.fragment_home, container, false);

        //recuperer recycler view
        RecyclerView itemSeanceRecyclerView = seanceView.findViewById(R.id.item_seance_recyclerview);
        itemSeanceRecyclerView.setAdapter(new ItemSeanceAdapter());

        return seanceView;
    }
}
