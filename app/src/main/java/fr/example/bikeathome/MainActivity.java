package fr.example.bikeathome;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import fr.example.bikeathome.fragments.HomeFragment;
import fr.example.bikeathome.fragments.SeanceCreationFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Session> sessionList = new ArrayList<>();
        sessionList.add(new Session("seance ert", Difficulte.FACILE) );
        Item item1 = new Item(450, 150, 200);
        Item item2 = new Item(8520, 250, 600);
        Item item3 = new Item(456320, 450, 300);
        sessionList.get(0).addItem(item1);
        sessionList.get(0).addItem(item2);
        sessionList.get(0).addItem(item3);

       // loadFragment(new SeanceCreationFragment(this, sessionList.get(0)));
        loadFragment(new HomeFragment(this));




    }

   public void loadFragment(Fragment fragment) {
        final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}