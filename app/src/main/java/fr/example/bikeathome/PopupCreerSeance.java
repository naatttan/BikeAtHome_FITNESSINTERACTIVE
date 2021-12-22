package fr.example.bikeathome;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import fr.example.bikeathome.adapter.ItemSeanceAdapter;

public class PopupCreerSeance extends Dialog /*implements AdapterView.OnItemSelectedListener*/ {
    private ItemSeanceAdapter adapter;
    private Spinner spinnerDifficulte;

    //contexte ?
    public PopupCreerSeance( ItemSeanceAdapter adapter){
        super(adapter.context);
        this.spinnerDifficulte = (Spinner) findViewById(R.id.spinner_difficulte_seance);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.popup_creer_session);

        /*
        ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(adapter.context, R.array.difficultes, android.R.layout.simple_spinner_item);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDifficulte.setAdapter(spinnerAdapter);
        spinnerDifficulte.setOnItemSelectedListener(this);

         */
    }

    /*
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

     */
}
