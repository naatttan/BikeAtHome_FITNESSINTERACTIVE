package fr.example.bikeathome;

public class Item {
    private int place;
    private int duree;
    private int puissance;
    private int frequence;

    public Item(int duree, int puissance, int frequence){
        this.duree = duree;
        this.puissance = puissance;
        this.frequence = frequence;
    }






    ///////////////// getter / setter /////////////////

    public int getFrequence() {
        return frequence;
    }

    public void setFrequence(int frequence) {
        this.frequence = frequence;
    }

    public int getPuissance() {
        return puissance;
    }

    public void setPuissance(int puissance) {
        this.puissance = puissance;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }


    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }
}
