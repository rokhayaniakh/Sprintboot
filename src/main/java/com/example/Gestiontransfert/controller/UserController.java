package com.example.Gestiontransfert.controller;

import com.example.Gestiontransfert.model.Compte;
import com.example.Gestiontransfert.model.Partenaire;
import com.example.Gestiontransfert.model.User;
import com.example.Gestiontransfert.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping(value = "/liste")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<User> liste()
    {
        return userRepository.findAll();
    }

    @Autowired
    PasswordEncoder encoder;
    @PostMapping(value = "/add",consumes = {MediaType.APPLICATION_JSON_VALUE})
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public User add(@RequestBody(required = false) User u){
        Partenaire partenaire=new Partenaire();
        Compte compte=new Compte();
        u.setPassword(u.getPassword());
        u.setStatus("debloquer");
        u.setPartenaire(partenaire);
        u.setCompte(compte);
        return userRepository.save(u);
    }
}


