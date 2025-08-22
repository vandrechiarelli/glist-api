package com.chiarelli.glist.api.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Value("${app.user.name}")
    private String username;

    @Value("${app.user.password}")
    private String encodedPassword;

    @Override
    public UserDetails loadUserByUsername(String inputUsername) throws UsernameNotFoundException {
        if (!inputUsername.equals(username)) {
            throw new UsernameNotFoundException("User not found");
        }
        return new User(username, encodedPassword, List.of(new SimpleGrantedAuthority("ROLE_USER")));
    }
}