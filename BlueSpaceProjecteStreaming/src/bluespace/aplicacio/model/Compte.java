package bluespace.aplicacio.model;

import java.time.LocalDate;

public class Compte extends Client{
    
    private int idCompte;
    private String usuari;
    private String contrasenya;
    private LocalDate dataAlta;
    private int idClient;
    private String email;
    
    private int idModalitat;
    
    public int getIdCompte() {
        return idCompte;
    }

    public void setIdCompte(int idCompte) {
        this.idCompte = idCompte;
    }

    public String getUsuari() {
        return usuari;
    }

    public void setUsuari(String usuari) {
        this.usuari = usuari;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    public LocalDate getDataAlta() {
        return dataAlta;
    }

    public void setDataAlta(LocalDate dataAlta) {
        this.dataAlta = dataAlta;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdModalitat() {
        return idModalitat;
    }

    public void setIdModalitat(int idModalitat) {
        this.idModalitat = idModalitat;
    }
    
    
    
    
}
