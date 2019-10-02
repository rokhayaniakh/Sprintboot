package com.example.Gestiontransfert.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user", uniqueConstraints = {
        @UniqueConstraint(columnNames = {

                "username"
        }),

})
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min=3, max = 50)
    private String nomcomplet;

    @NotBlank
    @Size(min=3, max = 50)
    private String username;


    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    @Size(min=6, max = 100)
    private String password;

    @NotBlank
    @Size(max = 9)
    private int tel;
    @NotBlank
    @Size(max = 50)
    private String adresse;

    @NotBlank
    @Size(max = 50)
    private String status;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
          private Set<Role> roles = new HashSet<>();
    @JoinColumn(name = "idpartenaire_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @JsonManagedReference
    private Partenaire partenaire ;
    @JoinColumn(name = "idcompte_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @JsonManagedReference
    private Compte compte ;

    public User() {
    }

    public User(String nomcomplet, String username, String email, String password, int tel, String adresse , String status) {
        this.nomcomplet = nomcomplet;
        this.username = username;
        this.email = email;
        this.password = password;
        this.tel = tel;
        this.adresse = adresse;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomcomplet() {
        return nomcomplet;
    }

    public void setNomcomplet(String nomcomplet) {
        this.nomcomplet = nomcomplet;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}