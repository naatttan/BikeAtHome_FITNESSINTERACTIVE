package fr.example.bikeathome.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import fr.example.bikeathome.Bloc;
import fr.example.bikeathome.Difficulte;
import fr.example.bikeathome.Item;
import fr.example.bikeathome.MainActivity;
import fr.example.bikeathome.PopupCreerSeance;
import fr.example.bikeathome.R;
import fr.example.bikeathome.Session;
import fr.example.bikeathome.adapter.ItemSeanceAdapter;

public class HomeFragment extends Fragment {
    private MainActivity context;
    private ImageView addButton;

    public HomeFragment(MainActivity context) {
        this.context = context;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View homeView = inflater.inflate(R.layout.fragment_home, container, false);



        //recuperer recycler view
        RecyclerView itemSeanceRecyclerView = homeView.findViewById(R.id.item_seance_recyclerview);
        itemSeanceRecyclerView.setAdapter(new ItemSeanceAdapter(context, context.sessionList));

        //utilisation bouton add

        addButton = (ImageView) homeView.findViewById(R.id.button_add);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new PopupCreerSeance( (ItemSeanceAdapter) itemSeanceRecyclerView.getAdapter(), context, context.sessionList).show();
            }
        });



        return homeView;
    }


}
