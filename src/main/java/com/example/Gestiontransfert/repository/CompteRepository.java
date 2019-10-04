package com.example.Gestiontransfert.repository;

import com.example.Gestiontransfert.model.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
    public interface CompteRepository extends JpaRepository<Compte, Integer> {
    Optional<Compte> findCompteByNumbcompte (String numbcompte);
    }

