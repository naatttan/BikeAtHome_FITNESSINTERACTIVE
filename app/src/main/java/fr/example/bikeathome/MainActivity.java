package fr.example.bikeathome;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import fr.example.bikeathome.fragments.EntrainementFragment;
import fr.example.bikeathome.fragments.HomeFragment;
import fr.example.bikeathome.fragments.SeanceCreationFragment;

public class MainActivity extends AppCompatActivity {
    ImageView button1;
    ImageView button2;
    public List<Session> sessionList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (ImageView) findViewById(R.id.imageView1);
        button2 = (ImageView) findViewById(R.id.imageView2);

        this.sessionList = new ArrayList<>();
        sessionList.add(new Session("seance ert", Difficulte.FACILE) );
        Item item1 = new Item(450, 150, 200);
        Item item2 = new Item(8520, 250, 600);
        Item item3 = new Item(456320, 450, 300);
        sessionList.get(0).addItem(item1);
        sessionList.get(0).addItem(item2);
        sessionList.get(0).addItem(item3);

        sessionList.add(new Session("seance le sang", Difficulte.FACILE) );

        item1 = new Item(60, 150, 200);
        item2 = new Item(60, 250, 600);
        item3 = new Item(60, 450, 300);

        sessionList.get(0).addItem(item3);
        sessionList.get(0).addItem(item2);
        sessionList.get(0).addItem(item3);


        sessionList.add(new Session("seancqdsfdg", Difficulte.MOYEN) );

        item1 = new Item(60, 150, 200);
        item2 = new Item(60, 250, 600);
        item3 = new Item(60, 450, 300);
        sessionList.get(2).addItem(item1);
        sessionList.get(2).addItem(item2);
        sessionList.get(2).addItem(item3);
        /////////////////////////////////////////////

       // loadFragment(new SeanceCreationFragment(this, sessionList.get(0)));
        //loadFragment(new HomeFragment(this));
        loadFragment(new EntrainementFragment(this, sessionList.get(0)));




    }

   public void loadFragment(Fragment fragment) {

        final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
   }
}