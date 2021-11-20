package com.example.hmrc.mealtrackerboot.security;

import com.example.hmrc.mealtrackerboot.repository.UserRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class MyUserDetailsService implements UserDetailsService {

    private UserRepo repo;

    public MyUserDetailsService(UserRepo repo) {
        this.repo = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = repo.findByUsername(username);
        if (user.isPresent()) {
            return new MyUserDetails(user.get());
        } else {
            throw new UsernameNotFoundException("No such user: " + username);
        }
    }
}
