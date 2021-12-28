package fr.example.bikeathome;

import java.util.ArrayList;
import java.util.List;

public class Session {
    private String nom;
    private Difficulte difficulte;
    private int duree;
    private List<Item> items;


    public Session(String nom, Difficulte difficulte){
        this.nom = nom;
        this.difficulte = difficulte;
        this.items = new ArrayList<>();
    }

    ///////////////// Methodes /////////////////////



    public void addItem(Item item) {
        this.items.add(item);
        this.duree += item.getDuree();
    }

    public void removeItem(Item item){
        this.items.remove(item);
        this.duree -= item.getDuree();
    }

    /*
    public void removeItem(Item item){
        int placeItem = this.items.indexOf(item);
        if(placeItem == this.items.size() - 1){
            this.items.remove(item);
        }else {
            for (int i = placeItem; i >= this.items.size() - 2; i++) {
                this.items.set(i, this.items.get(i + 1));
            }
            this.items.remove(this.items.size()-1);
        }
        this.duree -= item.getDuree();
    }

     */


    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    /*
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

     */


    ///////////////// getter / setter /////////////////

    public String getDifficulte() {
        switch (this.difficulte){
            case FACILE: return "FACILE";
            case DIFFICILE: return "DIFFICILE";
            default: return "MOYEN";
        }
    }

    public void setDifficulte(Difficulte difficulteSession) {
        this.difficulte = difficulteSession;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }
}
