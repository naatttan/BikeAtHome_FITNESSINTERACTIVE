package fr.example.bikeathome.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import fr.example.bikeathome.Bloc;
import fr.example.bikeathome.Item;
import fr.example.bikeathome.MainActivity;
import fr.example.bikeathome.PopupCreerItem;
import fr.example.bikeathome.PopupCreerSeance;
import fr.example.bikeathome.R;
import fr.example.bikeathome.Session;
import fr.example.bikeathome.adapter.ItemCreationAdapter;
import fr.example.bikeathome.adapter.ItemSeanceAdapter;

public class SeanceCreationFragment extends Fragment {
    private MainActivity context;
    private Session seance;

    private ImageView addButton;
    private TextView nomSeance;
    TextView difficulteSeance;

    public SeanceCreationFragment(MainActivity context, Session session){
        this.context = context;
        this.seance = session;
    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View creationView = inflater.inflate(R.layout.fragment_seance_creation, container, false);


        this.nomSeance = (TextView) creationView.findViewById(R.id.text_name_seance);
        this.nomSeance.setText(this.seance.getNom());

        this.difficulteSeance = (TextView) creationView.findViewById(R.id.text_difficulte_seance);
        this.difficulteSeance.setText(this.seance.getDifficulte());

        RecyclerView itemCreationRecylclerView = creationView.findViewById(R.id.item_creation_recyclerview);
        itemCreationRecylclerView.setAdapter(new ItemCreationAdapter(this.context, this.seance));




        addButton = (ImageView) creationView.findViewById(R.id.button_add);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new PopupCreerItem( (ItemCreationAdapter) itemCreationRecylclerView.getAdapter(), seance).show();
            }
        });

        itemCreationRecylclerView.getAdapter().notifyDataSetChanged();

        return creationView;
    }

}