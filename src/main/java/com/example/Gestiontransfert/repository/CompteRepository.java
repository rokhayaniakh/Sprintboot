package com.example.Gestiontransfert.repository;

import com.example.Gestiontransfert.model.Compte;
import com.example.Gestiontransfert.model.Partenaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface CompteRepository extends JpaRepository<Compte, Integer> {

    }

