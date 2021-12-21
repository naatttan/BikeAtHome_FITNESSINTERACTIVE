package fr.example.bikeathome;

import java.util.ArrayList;
import java.util.List;

public class Bloc {
    private int place;
    private String nom;
    private int nbRepetition;
    private int duree;
    private List<Item> items;


    public Bloc(String nom, int nbRepetition) {
        this.nom = nom;
        this.nbRepetition = nbRepetition;
        this.items = new ArrayList<Item>();
    }

    ///////////////// Methodes /////////////////////

    public void addItem(Item item) {
        if(this.items.size() >= 0)
            item.setPlace(this.items.size());
        this.items.add(item);
        this.duree += item.getDuree();
    }

    public void removeItem(Item item){
        int placeItem = this.items.indexOf(item);
        for(int i = placeItem; i >= this.items.size()-2; i++ ){
            this.items.set(i, this.items.get(i+1));
        }
        this.items.remove(this.items.size()-1);
        this.duree -= item.getDuree();
    }


    ///////////////// getter / setter /////////////////

    public int getNbRepetition() {
        return nbRepetition;
    }

    public void setNbRepetition(int nbRepetition) {
        this.nbRepetition = nbRepetition;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }
}
