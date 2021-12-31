package fr.example.bikeathome;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import fr.example.bikeathome.fragments.EntrainementFragment;
import fr.example.bikeathome.fragments.HomeFragment;
import fr.example.bikeathome.fragments.SeanceCreationFragment;

public class MainActivity extends AppCompatActivity {

    public List<Session> sessionList;
    public DatabaseManager dbM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        dbM = new DatabaseManager(this);

        this.sessionList = new ArrayList<>();
        this.sessionList = dbM.readListSession();

        loadFragment(new HomeFragment(this));

    }

   public void loadFragment(Fragment fragment) {

        final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
   }

}