package com.example.Gestiontransfert.model;
import javax.persistence.*;

@Entity
@Table(name = "partenaire")
public class Partenaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    @Column(length = 50)
    private String rs;
    @Column(length = 15)
    private int ninea;
    @Column(length = 30)
    private String adresse;
    @Column(length = 10)
    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRs() {
        return rs;
    }

    public void setRs(String rs) {
        this.rs = rs;
    }

    public int getNinea() {
        return ninea;
    }

    public void setNinea(int ninea) {
        this.ninea = ninea;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
