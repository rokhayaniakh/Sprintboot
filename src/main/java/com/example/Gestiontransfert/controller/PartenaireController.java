package com.example.Gestiontransfert.controller;

import com.example.Gestiontransfert.model.*;
import com.example.Gestiontransfert.repository.CompteRepository;
import com.example.Gestiontransfert.repository.PartenaireRepository;
import com.example.Gestiontransfert.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin
@RequestMapping(value = "/partenaire")
public class PartenaireController {
    @Autowired
    private PartenaireRepository partenaireRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CompteRepository compteRepository;

    @GetMapping(value = "/liste")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<Partenaire> liste()
    {
        return partenaireRepository.findAll();
    }
    @PostMapping(value = "/add",consumes = {MediaType.APPLICATION_JSON_VALUE})
    @PreAuthorize("hasAuthority('ROLE_SUPER_ADMIN')")
    public String add(@RequestBody(required = false) Ajout a){
        User user = new User(a.getNomcomplet(),a.getUsername(),a.getEmail(),a.getPassword(),a.getTel(),a.getAdresse());
        Partenaire partenaire=new Partenaire(a.getRs(),a.getNinea(),a.getAdresseP());
        Compte compte=new Compte();
        user.setStatus("debloquer");
        partenaire.setStatus("debloquer");
        user.setPartenaire(partenaire);
        Set<Role> roles = new HashSet<>();
        Role role= new Role();
        role.setId((long) 1);
        // Adding elements into HashSet usind add()
        roles.add(role);
        user.setRoles(roles);
        user.setCompte(compte);
        compte.setNumbcompte(785554);
        compte.setSolde(0);
        compte.setPartenaire(partenaire);
        partenaireRepository.save(partenaire);
        compteRepository.save(compte);
        userRepository.save(user);
        return "partenaire ajouter";

    }
}
