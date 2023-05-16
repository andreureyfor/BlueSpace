package bluespace.aplicacio.model;

import java.util.ArrayList;

public class Pelis extends Produccions{
    
    private double durada;
    
    private ArrayList<String> categories;
    private ArrayList<String> directors;
    private ArrayList<String> actors;

    public Pelis() {
        this.actors = new ArrayList();
        this.directors = new ArrayList();
        this.categories = new ArrayList();
    }

    public Pelis(double durada, String nom, int any, String genere, String categoria, String director, String actor) {
        super(nom, any, genere, categoria, director, actor);
        this.durada = durada;
        this.actors = new ArrayList();
        this.directors = new ArrayList();
        this.categories = new ArrayList();
        
        this.categories.add(categoria);
        this.directors.add(director);
        this.actors.add(actor);
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

    public double getDurada() {
        return durada;
    }

    public void setDurada(double durada) {
        this.durada = durada;
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
