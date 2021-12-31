package fr.example.bikeathome;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import java.util.List;

import fr.example.bikeathome.adapter.ItemSeanceAdapter;

public class PopupQuitterSession extends Dialog {

    ItemSeanceAdapter adapter;


    public PopupQuitterSession(ItemSeanceAdapter adapter) {
        super(adapter.context);
        this.adapter = adapter;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.popup_quitter_seance);



        findViewById(R.id.valider_quitter_session).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.context.getFragmentManager().popBackStack();
                dismiss();
            }
        });

        findViewById(R.id.annuler_quitter_session).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

    }
}
