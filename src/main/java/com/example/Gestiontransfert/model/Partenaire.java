package com.example.Gestiontransfert.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.util.List;

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
    private String adresseP;
    @Column(length = 10)
    private String status;

    public  Partenaire(){

    }
    public Partenaire(String rs, int ninea, String adresseP) {
        this.rs = rs;
        this.ninea = ninea;
        this.adresseP = adresseP;

    }
    @OneToMany(mappedBy ="partenaire")
    @JsonIgnoreProperties(value = "partenaire")
   /* private List <User> user;

    public List<User> getUser() {
        return user;
    }
    public void setUser(List<User> user) {
        this.user = user;
    }
*/

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

    public String getAdresseP() {
        return adresseP;
    }

    public void setAdresse(String adresse) {
        this.adresseP = adresse;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
