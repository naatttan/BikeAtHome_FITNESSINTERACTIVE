package fr.example.bikeathome;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;

import fr.example.bikeathome.adapter.ItemSeanceAdapter;

public class PopupCreerSeance extends Dialog {
    private ItemSeanceAdapter adapter;

    //contexte ?
    public PopupCreerSeance(ItemSeanceAdapter adapter){
        super(adapter.context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.popup_creer_session);
    }
}
