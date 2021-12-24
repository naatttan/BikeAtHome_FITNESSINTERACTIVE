package fr.example.bikeathome;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.List;

import fr.example.bikeathome.adapter.ItemCreationAdapter;
import fr.example.bikeathome.adapter.ItemSeanceAdapter;

public class PopupMoreOptionSeance extends Dialog {
    ItemSeanceAdapter adapter;
    Session seance;
    List<Session> sessions;

    public PopupMoreOptionSeance(ItemSeanceAdapter adapter, List<Session> sessions, Session session) {
        super(adapter.context);
        this.adapter = adapter;
        this.seance = session;
        this.sessions = sessions;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.more_option_seance);



        findViewById(R.id.valider_supprimer_session).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                supprimerSeance();
            }
        });

        findViewById(R.id.annuler_supprimer_session).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

    }

    public void supprimerSeance(){
        int a = this.sessions.indexOf(this.seance);
        this.sessions.remove(this.seance);
        adapter.notifyItemRemoved(a);
        dismiss();
    }

}