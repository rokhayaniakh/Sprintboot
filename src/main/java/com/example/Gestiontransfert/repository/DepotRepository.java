package com.example.Gestiontransfert.repository;
import com.example.Gestiontransfert.model.Depot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
    public interface DepotRepository extends JpaRepository<Depot, Integer> {
    }