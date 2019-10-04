package com.example.Gestiontransfert.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name = "compte")
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private long solde;
    private  String numbcompte;
    @JoinColumn(name = "idpartenaire_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @JsonManagedReference
    private Partenaire partenaire ;

    public Partenaire getPartenaire() {
        return partenaire;
    }

    public void setPartenaire(Partenaire partenaire) {
        this.partenaire = partenaire;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getSolde() {
        return solde;
    }

    public void setSolde(long solde) {
        this.solde = solde;
    }

    public String getNumbcompte() {
        return numbcompte;
    }

    public void setNumbcompte(String numbcompte) {
        this.numbcompte = numbcompte;
    }
}
