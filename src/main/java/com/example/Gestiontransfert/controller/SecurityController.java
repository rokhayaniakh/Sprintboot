package com.example.Gestiontransfert.controller;

import com.example.Gestiontransfert.services.UserDetailsServiceImpl;
import com.example.Gestiontransfert.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

public class SecurityController {
    @Autowired
    UserService userService;
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    UserDetailsServiceImpl userDetailsService;
}
