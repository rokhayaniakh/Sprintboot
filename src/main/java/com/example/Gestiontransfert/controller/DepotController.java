package com.example.Gestiontransfert.controller;

import com.example.Gestiontransfert.model.Compte;
import com.example.Gestiontransfert.model.Depot;
import com.example.Gestiontransfert.model.DepotCompte;
import com.example.Gestiontransfert.model.User;
import com.example.Gestiontransfert.repository.CompteRepository;
import com.example.Gestiontransfert.repository.DepotRepository;
import com.example.Gestiontransfert.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import java.util.Date;

@RestController
@CrossOrigin
@RequestMapping(value = "/depot")
public class DepotController {
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Autowired
    private DepotRepository depotRepository;
    @Autowired
    private CompteRepository compteRepository;
    @PostMapping( "/add")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String add(DepotCompte s) throws Exception{
        Depot d = new Depot();

        d.setDate(new Date());
        d.setMontant(s.getMontant());
        //User ucon = userDetailsService.getUserconnecte();
       // d.setUser(ucon);
        Compte compte = compteRepository.findCompteByNumbcompte(s.getNumbcompte()).orElseThrow(
                ()-> new Exception("Compte invalide!!!" ));
        d.setCompte(compte);
        compte.setSolde(s.getMontant()+compte.getSolde());
        compteRepository.save(compte);
        depotRepository.save(d);
        return "Depot effectuer !!";
    }
}
