package com.example.Gestiontransfert.services;


import com.example.Gestiontransfert.model.User;
import com.example.Gestiontransfert.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {


    private User userconnecte;

    @Autowired
    UserRepository userRepository;
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username).orElseThrow(
                ()-> new UsernameNotFoundException("User Not Found with -> username or email : " + username));
        this.userconnecte=user;
        return UserPrinciple.build(user);
    }
    public User  getUserconnecte(){
        return userconnecte;
    }
}
