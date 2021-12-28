package fr.example.bikeathome;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;

import fr.example.bikeathome.adapter.ItemCreationAdapter;

public class PopupCreerItem extends Dialog {
    ItemCreationAdapter adapter;
    Session seance;

    EditText saisieDuree;
    EditText saisiePower;
    EditText saisieTrmin;

    public PopupCreerItem(ItemCreationAdapter adapter, Session session) {
        super(adapter.context);
        this.seance = session;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.popup_creer_item);

        this.saisieDuree = (EditText) findViewById(R.id.saisie_duree_item);
        this.saisiePower = (EditText) findViewById(R.id.saisie_power_item);
        this.saisieTrmin = (EditText) findViewById(R.id.saisie_trmin_item);

        findViewById(R.id.valider_creer_item).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                creerItem();
            }
        });

        findViewById(R.id.annuler_creer_item).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }



    private void creerItem(){
        int duree,power,trmin;
        duree = Integer.parseInt(saisieDuree.getText().toString());
        power = Integer.parseInt(saisiePower.getText().toString());
        trmin = Integer.parseInt(saisieTrmin.getText().toString());
        seance.addItem(new Item(duree, power, trmin));
        this.dismiss();
    }

}
