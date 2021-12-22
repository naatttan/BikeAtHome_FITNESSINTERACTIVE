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

        //test liste de seances
        List<Session> sessionList = new ArrayList<Session>();
        sessionList.add(new Session("seance le sang", 2) );
        Bloc bloc1 = new Bloc("Echauffement", 2);
        Bloc bloc2 = new Bloc("", 2);
        Item item1 = new Item(60, 150, 200);
        Item item2 = new Item(60, 250, 600);
        Item item3 = new Item(60, 450, 300);
        bloc1.addItem(item1);
        bloc2.addItem(item2);
        bloc2.addItem(item3);
        bloc2.addItem(item1);
        sessionList.get(0).addBloc(bloc1);
        sessionList.get(0).addBloc(bloc2);

        sessionList.add(new Session("seance ert", 0) );
        bloc1 = new Bloc("Echauffement", 2);
        bloc2 = new Bloc("", 2);
        item1 = new Item(450, 150, 200);
        item2 = new Item(8520, 250, 600);
        item3 = new Item(456320, 450, 300);
        bloc1.addItem(item1);
        bloc2.addItem(item2);
        bloc2.addItem(item3);
        bloc2.addItem(item1);
        sessionList.get(1).addBloc(bloc1);
        sessionList.get(1).addBloc(bloc2);

        sessionList.add(new Session("seancqdsfdg", 1) );
        bloc1 = new Bloc("Echauffement", 2);
        bloc2 = new Bloc("", 2);
        item1 = new Item(60, 150, 200);
        item2 = new Item(60, 250, 600);
        item3 = new Item(60, 450, 300);
        bloc1.addItem(item1);
        bloc2.addItem(item2);
        bloc2.addItem(item3);
        bloc2.addItem(item1);
        sessionList.get(2).addBloc(bloc1);
        sessionList.get(2).addBloc(bloc2);
        //////////////////////////////////////////////



        //recuperer recycler view
        RecyclerView itemSeanceRecyclerView = homeView.findViewById(R.id.item_seance_recyclerview);
        itemSeanceRecyclerView.setAdapter(new ItemSeanceAdapter(context, sessionList));

        //utilisation bouton add

        addButton = (ImageView) homeView.findViewById(R.id.button_add);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new PopupCreerSeance( (ItemSeanceAdapter) itemSeanceRecyclerView.getAdapter()).show();
            }
        });



        return homeView;
    }


}
