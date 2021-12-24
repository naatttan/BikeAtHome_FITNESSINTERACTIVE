package fr.example.bikeathome.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import fr.example.bikeathome.MainActivity;
import fr.example.bikeathome.PopupMoreOptionSeance;
import fr.example.bikeathome.R;
import fr.example.bikeathome.Session;

public class ItemSeanceAdapter extends RecyclerView.Adapter<ItemSeanceAdapter.itemSeanceViewHolder>{

    public MainActivity context;
    private List<Session> sessionList;


    public ItemSeanceAdapter(MainActivity context, List<Session> sessionList) {
        this.context = context;
        this.sessionList = sessionList;
    }


    public class itemSeanceViewHolder extends RecyclerView.ViewHolder {
        private View itemSeance;
        public TextView nomSeance;
        public TextView dureeSeance;
        public TextView difficulteSeance;
        public ImageView moreOption;


        public itemSeanceViewHolder(@NonNull View itemView) {
            super(itemView);
            this.nomSeance = itemView.findViewById(R.id.nom_seance_mainpage);
            this.itemSeance = itemView.findViewById(R.id.item_seance);
            this.dureeSeance = itemView.findViewById(R.id.temps_seance_mainpage);
            this.difficulteSeance = itemView.findViewById(R.id.difficulte_seance_mainpage);
            this.moreOption = itemView.findViewById(R.id.moreoption);
        }
    }



    @NonNull
    @Override
    public itemSeanceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_seance, parent, false);
        return new itemSeanceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull itemSeanceViewHolder holder, int position) {
        //mettre a jour plante
        Session currentSession = this.sessionList.get(position);
        holder.nomSeance.setText(currentSession.getNom());
        holder.dureeSeance.setText(String.valueOf(currentSession.getDuree() / 60));
        holder.difficulteSeance.setText(currentSession.getDifficulte());

        holder.moreOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPopup(currentSession);
            }
        });

    }

    @Override
    public int getItemCount() {
        return this.sessionList.size();
    }

    public void openPopup(Session session1){
        new PopupMoreOptionSeance(this, this.sessionList, session1).show();
    }

}
