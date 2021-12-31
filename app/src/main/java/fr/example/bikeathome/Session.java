package fr.example.bikeathome;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Session implements Serializable {
    private int id_session;
    private String nom;
    private Difficulte difficulte;
    private int duree;
    private List<Item> items;


    public Session(String nom, Difficulte difficulte){
        this.nom = nom;
        this.difficulte = difficulte;
        this.items = new ArrayList<>();
    }

    public Session(String nom, int difficulte){
        this.nom = nom;
        switch (difficulte){
            case 0:
                this.difficulte = Difficulte.FACILE;
                break;
            case 1:
                this.difficulte = Difficulte.MOYEN;
                break;
            case 2:
                this.difficulte = Difficulte.DIFFICILE;
                break;
            default:
                this.difficulte = Difficulte.MOYEN;
        }
        this.items = new ArrayList<>();
    }

    ///////////////// Methodes /////////////////////



    public void addItem(Item item) {
        this.items.add(item);
        this.items.get(this.items.size()-1).setPlace(this.items.indexOf(item));
        this.duree += item.getDuree();
    }

    public void removeItem(Item item){
        this.items.remove(item);
        for(Item i : this.items){
            i.setPlace(this.items.indexOf(i)+ 1);
        }
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
        return this.difficulte.toString();
    }

    public int getNumDifficulte() {
        switch (this.difficulte){
            case FACILE:
                return 0;
            case MOYEN:
                return 1;
            case DIFFICILE:
                return 2;
            default:
                return 1;
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

    public int getId_session() {
        return id_session;
    }

    public void setId_session(int id_session) {
        this.id_session = id_session;
    }
}
