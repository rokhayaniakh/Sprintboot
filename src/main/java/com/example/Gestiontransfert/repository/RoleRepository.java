package com.example.Gestiontransfert.repository;


import com.example.Gestiontransfert.model.Role;
import com.example.Gestiontransfert.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}
