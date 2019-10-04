package com.example.Gestiontransfert.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class DepotCompte {
    private Long solde;
    private  String  numbcompte;
    private Long montant;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    private Compte compte ;
    private Partenaire partenaire;
    private User user;

    public Long getSolde() {
        return solde;
    }

    public void setSolde(Long solde) {
        this.solde = solde;
    }

    public String getNumbcompte() {
        return numbcompte;
    }

    public void setNumbcompte(String numbcompte) {
        this.numbcompte = numbcompte;
    }

    public Long getMontant() {
        return montant;
    }

    public void setMontant(Long montant) {
        this.montant = montant;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    public Partenaire getPartenaire() {
        return partenaire;
    }

    public void setPartenaire(Partenaire partenaire) {
        this.partenaire = partenaire;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
