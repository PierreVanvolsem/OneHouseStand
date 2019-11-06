package com.example.demo.service;

import com.example.demo.dao.UserRepository;
import com.example.demo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;


@Primary  // if there would be any confusion with InMemory implementation, this one should be chosen
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username);
        if (user != null) return user;
        throw new UsernameNotFoundException("User " + username + " not found!");
    }

    private User addUser(User u) {
        userRepository.save(u);
        return u;
    }

    public User getUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userName = auth.getName();
        User user = userRepository.findByUsername(userName);
        return user;
    }

    public void verwerkRegistratie(User u) {
        u.setRole("KLANT");
        u.setPassword("{bcrypt}" + BCrypt.hashpw(u.getPassword(), BCrypt.gensalt()));
        addUser(u);
    }
}
