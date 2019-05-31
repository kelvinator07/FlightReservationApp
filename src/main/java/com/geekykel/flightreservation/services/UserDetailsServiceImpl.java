package com.geekykel.flightreservation.services;

import com.geekykel.flightreservation.entities.User;
import com.geekykel.flightreservation.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by GeekyKel on 5/29/2019
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(userEmail);

        if (user == null) {
            throw new UsernameNotFoundException("User not found for email " + userEmail);
        }

        return new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getPassword(), user.getRoles());
    }
}
