package bluespace.aplicacio.model;

import java.util.ArrayList;

public class Series extends Produccions{
    
    private int numCapitols;
    private double duradaTotal;
    
    private ArrayList<String> categories;
    private ArrayList<String> directors;
    private ArrayList<String> actors;
    
    public Series(){
        this.actors = new ArrayList();
        this.directors = new ArrayList();
        this.categories = new ArrayList();
    }

    public Series(int numCapitols, double duradaTotal, String nom, int any, String genere, String categoria, String director, String actor) {
        super(nom, any, genere, categoria, director, actor);
        this.numCapitols = numCapitols;
        this.duradaTotal = duradaTotal;
        
        this.actors = new ArrayList();
        this.directors = new ArrayList();
        this.categories = new ArrayList();
    }
    
    public void afegirDirector(String director){
        this.directors.add(director);
    }
    
    public void afegirActor(String actor){
        this.actors.add(actor);
    }
    
    public void afegirCategoria(String categoria){
        this.categories.add(categoria);
    }
    
    public int getNumCapitols() {
        return numCapitols;
    }

    public void setNumCapitols(int numCapitols) {
        this.numCapitols = numCapitols;
    }

    public double getDuradaTotal() {
        return duradaTotal;
    }

    public void setDuradaTotal(double duradaTotal) {
        this.duradaTotal = duradaTotal;
    }
    
    public String getDirector(int pos) {
        if (pos <= directors.size() -1) return this.directors.get(pos);
        return "";
    }

    public void setDirectors(ArrayList<String> directors) {
        this.directors = directors;
    }

    public String getCategories(int pos) {
        if (pos <= categories.size() -1) return this.categories.get(pos);
        return "";
    }

    public void setCategories(ArrayList<String> categories) {
        this.categories = categories;
    }

    public String getActors(int pos) {
        if (pos <= actors.size() -1) return this.actors.get(pos);
        return " ";
    }

    public void setActors(ArrayList<String> actors) {
        this.actors = actors;
    }
    
    
    
    
}
