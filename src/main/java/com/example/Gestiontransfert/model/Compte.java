package com.example.Gestiontransfert.model;

import javax.persistence.*;

@Entity
@Table(name = "compte")
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int solde;
    private  int numbcompte;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSolde() {
        return solde;
    }

    public void setSolde(int solde) {
        this.solde = solde;
    }

    public int getNumbcompte() {
        return numbcompte;
    }

    public void setNumbcompte(int numbcompte) {
        this.numbcompte = numbcompte;
    }
}
