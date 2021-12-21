package fr.example.bikeathome;

import java.util.ArrayList;
import java.util.List;

public class Session {
    private String nom;
    private int difficulte;
    private int duree;
    private List<Bloc> blocs;





    public Session(String nom, int difficulte){
        this.nom = nom;
        this.difficulte = difficulte;
        this.blocs = new ArrayList<Bloc>();
    }

    ///////////////// Methodes /////////////////////

    public void addBloc(Bloc bloc){
        if(this.blocs.size() >= 0)
            bloc.setPlace(this.blocs.size());
        this.blocs.add(bloc);
        this.duree += bloc.getDuree();
    }

    public void removeBloc(Bloc bloc){
        int placeBloc = this.blocs.indexOf(bloc);
        for(int i = placeBloc; i >= this.blocs.size()-2; i++ ){
            this.blocs.set(i, this.blocs.get(i+1));
        }
        this.blocs.remove(this.blocs.size()-1);
        this.duree -= bloc.getDuree();
    }


    ///////////////// getter / setter /////////////////

    public String getDifficulte() {
        switch(this.difficulte){
            case 0:
                return "FACILE";
            case 2:
                return "DIFFICILE";
            default:
                return "MOYEN";
        }
    }

    public void setDifficulte(int difficulteSession) {
        this.difficulte = difficulteSession;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Bloc> getBlocs() {
        return blocs;
    }

    public void setBlocs(List<Bloc> blocs) {
        this.blocs = blocs;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }
}
