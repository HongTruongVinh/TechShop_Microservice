package com.nhom1.userservice.util;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nhom1.userservice.command.data.User;
import com.nhom1.userservice.command.data.UserRepository;


@Service
@Primary
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepo.findFirstByEmail(s);
        if (user == null)
            throw new UsernameNotFoundException("Username not found",null);
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPswd(), new ArrayList<>());
    }

}