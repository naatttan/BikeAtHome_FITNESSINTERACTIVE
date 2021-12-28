package fr.example.bikeathome;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fr.example.bikeathome.adapter.ItemSeanceAdapter;
import fr.example.bikeathome.fragments.SeanceCreationFragment;


public class PopupCreerSeance extends Dialog /*implements AdapterView.OnItemSelectedListener*/ {
    private ItemSeanceAdapter adapter;
    private Spinner spinnerDifficulte;
    List<Session> sessions;
    EditText editNomSeance;
    MainActivity context;

    //contexte ?
    public PopupCreerSeance( ItemSeanceAdapter adapter, MainActivity context, List<Session> sessions){
        super(context);
        this.context = context;
        this.sessions = sessions;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.popup_creer_session);

        this.editNomSeance = (EditText) findViewById(R.id.champ_nom_seance);
        this.spinnerDifficulte = (Spinner) findViewById(R.id.spinner_difficulte_seance);

        String[] difficultes = this.context.getResources().getStringArray(R.array.difficultes);

        ArrayAdapter<String> adapterSpinner = new ArrayAdapter<>(this.context, android.R.layout.simple_spinner_item, difficultes);
        adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spinnerDifficulte.setAdapter(adapterSpinner);


        findViewById(R.id.valider_creer_session).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                creerSeance();
            }
        });

        findViewById(R.id.annuler_creer_session).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

    }

    private void creerSeance(){
        Difficulte difficulte = Difficulte.MOYEN;
        switch(this.spinnerDifficulte.getSelectedItemPosition()){
            case 0:
                difficulte = Difficulte.FACILE;
                break;
            case 1:
                difficulte = Difficulte.MOYEN;
                break;
            case 2:
                difficulte = Difficulte.DIFFICILE;
                break;
            default:
                break;
        }
        String nom = this.editNomSeance.getText().toString();
        Session session = new Session(nom, difficulte);
        //this.sessions.add(session);
        this.dismiss();
        context.loadFragment(new SeanceCreationFragment(this.context,this.sessions ,session));
    }

}
