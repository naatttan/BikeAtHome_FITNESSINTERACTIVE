package fr.example.bikeathome.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import fr.example.bikeathome.MainActivity;
import fr.example.bikeathome.PopupCreerSeance;
import fr.example.bikeathome.R;
import fr.example.bikeathome.Session;
import fr.example.bikeathome.adapter.ItemSeanceAdapter;

public class EntrainementFragment extends Fragment {
    MainActivity context;
    Session session;
    TextView timer;
    TextView currentPower;
    TextView currentTrmin;

    ImageButton pauseButton;
    ImageButton playButton;
    ImageButton stopButton;

    public EntrainementFragment(MainActivity context, Session session1){
        this.context = context;
        this.session = session1;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View entrainementView = inflater.inflate(R.layout.fragment_entrainement_encours, container, false);

        //recuperer recycler view
        //RecyclerView itemSeanceRecyclerView = entrainementView.findViewById(R.id.item_seance_recyclerview);
        //itemSeanceRecyclerView.setAdapter(new ItemSeanceAdapter(context, context.sessionList));

        this.pauseButton = entrainementView.findViewById(R.id.pause_button);
        this.playButton = entrainementView.findViewById(R.id.play_button);
        this.stopButton = entrainementView.findViewById(R.id.stop_button);

        this.playButton.setEnabled(false);
        this.playButton.setVisibility(View.GONE);
        this.stopButton.setEnabled(false);
        this.stopButton.setVisibility(View.GONE);
        this.pauseButton.setEnabled(true);
        this.pauseButton.setVisibility(View.VISIBLE);

        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                desactivePauseButton();
            }
        });

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activePauseButton();
            }
        });


        return entrainementView;
    }

    public void activePauseButton(){
        this.playButton.setEnabled(false);
        this.playButton.setVisibility(View.GONE);
        this.stopButton.setEnabled(false);
        this.stopButton.setVisibility(View.GONE);

        this.pauseButton.setEnabled(true);
        this.pauseButton.setVisibility(View.VISIBLE);
    }

    public void desactivePauseButton(){
        this.pauseButton.setEnabled(false);
        this.pauseButton.setVisibility(View.GONE);

        this.playButton.setEnabled(true);
        this.playButton.setVisibility(View.VISIBLE);
        this.stopButton.setEnabled(true);
        this.stopButton.setVisibility(View.VISIBLE);
    }

}
