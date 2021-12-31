package fr.example.bikeathome.fragments;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import fr.example.bikeathome.MainActivity;
import fr.example.bikeathome.PopupQuitterSession;
import fr.example.bikeathome.R;
import fr.example.bikeathome.Session;

import static java.lang.Thread.sleep;

public class EntrainementFragment extends Fragment {
    MainActivity context;
    Session session;

    TextView timerText;
    TextView currentPower;
    TextView currentTrmin;

    TextView nomSeance;
    TextView entrainementSuivant;

    ImageButton pauseButton;
    ImageButton playButton;
    ImageButton stopButton;
    CountDownTimer countDownTimer;
    Boolean isRunning;
    Boolean isFinish = false;
    long milli;
    int currentTimerId;
    long currentMilli = 0;


    public EntrainementFragment(MainActivity context, Session session1) {
        this.context = context;
        this.session = session1;
    }
    

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View entrainementView = inflater.inflate(R.layout.fragment_entrainement_encours, container, false);


        this.pauseButton = entrainementView.findViewById(R.id.pause_button);
        this.playButton = entrainementView.findViewById(R.id.play_button);
        this.stopButton = entrainementView.findViewById(R.id.stop_button);

        this.stopButton.setClipToOutline(true);
        this.timerText = entrainementView.findViewById(R.id.timerText);

        this.nomSeance = entrainementView.findViewById(R.id.text_nom_seance);
        this.entrainementSuivant = entrainementView.findViewById(R.id.text_entrainement_suivant);

        this.currentTrmin = entrainementView.findViewById(R.id.trmin_text);
        this.currentPower = entrainementView.findViewById(R.id.power_text);

        this.playButton.setEnabled(false);
        this.playButton.setVisibility(View.GONE);
        this.stopButton.setEnabled(false);
        this.stopButton.setVisibility(View.GONE);
        this.pauseButton.setEnabled(true);
        this.pauseButton.setVisibility(View.VISIBLE);
        this.nomSeance.setText(this.session.getNom());

        timer1(this.session, 0);

        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                desactivePauseButton();
                pauseTimer();
            }
        });

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activePauseButton();
                timer1(session, currentTimerId);
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //new PopupQuitterSession(context);
                getParentFragmentManager().popBackStack();
            }
        });

        return entrainementView;
    }


    /////////////////methodes///////////////////////


    public void activePauseButton() {
        this.playButton.setEnabled(false);
        this.playButton.setVisibility(View.GONE);
        this.stopButton.setEnabled(false);
        this.stopButton.setVisibility(View.GONE);

        this.pauseButton.setEnabled(true);
        this.pauseButton.setVisibility(View.VISIBLE);
    }

    public void desactivePauseButton() {
        this.pauseButton.setEnabled(false);
        this.pauseButton.setVisibility(View.GONE);

        this.playButton.setEnabled(true);
        this.playButton.setVisibility(View.VISIBLE);
        this.stopButton.setEnabled(true);
        this.stopButton.setVisibility(View.VISIBLE);
    }


    public void updateTimer() {
        int minutes = (int) this.milli / 60000;
        int secondes = (int) this.milli % 60000 / 1000;

        String text;
        text = "" + minutes + ":";
        if (secondes < 10) text += "0";
        text += secondes;

        timerText.setText(text);
    }

    public void pauseTimer() {
        this.countDownTimer.cancel();
        isRunning = false;
    }

    public void timer1(Session mySessions, int cpt) {
        int nbItems = mySessions.getItems().size();
        if (nbItems < 1) {
            return;
        }
        long[] tps1 = {mySessions.getItems().get(cpt).getDuree() * 1000};
        currentPower.setText("" + session.getItems().get(cpt).getPuissance());
        currentTrmin.setText("" + session.getItems().get(cpt).getFrequence());
        if(cpt + 1 < session.getItems().size()) {
            entrainementSuivant.setText("" + session.getItems().get(cpt + 1).getPuissance() + "w @ "+ session.getItems().get(cpt + 1).getFrequence()+"tr/m");
        }else{
            entrainementSuivant.setText("FIN");
        }
        this.currentTimerId = cpt;
        long tpstimer;
        if (currentMilli == 0) {
            tpstimer = tps1[0];
        } else {
            tpstimer = currentMilli;
        }
        this.countDownTimer = new CountDownTimer(tpstimer, 1000){

            public void onTick(long millisUntilFinished){
                currentMilli = millisUntilFinished;
                int minutes = (int) millisUntilFinished / 60000;
                int secondes = (int) millisUntilFinished % 60000 / 1000;

                String text;
                text = "" + minutes + ":";
                if (secondes < 10) text += "0";
                text += secondes;

                timerText.setText(text);
            }
            public  void onFinish(){
                currentMilli = 0;
                if (cpt < nbItems-1) {
                    timer1(mySessions,cpt+1);
                } else {
                    timerText.setText("FIN !!");
                }
            }

        }.start();
    }



}
