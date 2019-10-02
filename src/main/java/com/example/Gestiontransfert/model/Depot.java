package com.example.Gestiontransfert.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "depot")
public class Depot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int montant;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    @JoinColumn(name = "idcompte_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @JsonManagedReference
    private Compte compte ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

