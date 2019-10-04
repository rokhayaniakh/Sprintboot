package com.example.Gestiontransfert.controller;

import com.example.Gestiontransfert.model.*;
import com.example.Gestiontransfert.repository.UserRepository;
import com.example.Gestiontransfert.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@CrossOrigin
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    UserDetailsServiceImpl userDetailsService;
   @Autowired
    PasswordEncoder encoder;
    @Autowired
    UserRepository userRepository;


    @GetMapping(value = "/liste")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<User> liste()
    {
        return userRepository.findAll();
    }


    @PostMapping(value = "/add"/*,consumes = {MediaType.APPLICATION_JSON_VALUE}*/)
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public User add(/*@RequestBody(required = false) */User u ) {
        User ucon = userDetailsService.getUserconnecte();
        u.setTel(u.getTel());
        u.setAdresse(u.getAdresse());
        u.setEmail(u.getEmail());
        u.setStatus("debloquer");
        u.setNomcomplet(u.getNomcomplet());
        u.setUsername(u.getUsername());
        u.setPassword(encoder.encode(u.getPassword()));
        Set<Role> roles = new HashSet<>();
        Role role = new Role();
        role.setId((long) 2);
        roles.add(role);
        u.setRoles(roles);
        ucon.getPartenaire();
        u.setPartenaire(ucon.getPartenaire());
        return userRepository.save(u);
    }
        @PreAuthorize("hasAuthority('ROLE_ADMIN')")
        @PutMapping(value = "/bloquerUser/{id}")
        public ResponseEntity<String> bloquerUser(@PathVariable long id ) throws Exception{
            User user = userRepository.findUserById(id);
            if(user.getStatus().equals("debloquer")){
                user.setStatus("bloquer");
                userRepository.save(user);
                return new ResponseEntity( "utilisateur bloque",
                        HttpStatus.OK);
            }
            if (user.getStatus().equals("bloquer")){
                user.setStatus("debloquer");
                userRepository.save(user);
                return new ResponseEntity( "utilisateur debloquer",
                        HttpStatus.OK);
            }
            return null;
    }
}


