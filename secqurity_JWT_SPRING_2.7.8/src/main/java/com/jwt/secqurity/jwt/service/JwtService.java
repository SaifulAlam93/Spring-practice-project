package com.jwt.secqurity.jwt.service;



import com.jwt.secqurity.jwt.entity.JwtRequest;
import com.jwt.secqurity.jwt.entity.JwtResponse;
import com.jwt.secqurity.jwt.entity.User;
import com.jwt.secqurity.jwt.repository.UserDao;
import com.jwt.secqurity.jwt.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class JwtService implements UserDetailsService {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserDao userDao;

    @Autowired
    private AuthenticationManager authenticationManager;

    public JwtResponse createJwtToken(JwtRequest jwtRequest) throws Exception {
        String userName = jwtRequest.getUserName();
        String userPassword = jwtRequest.getUserPassword();
        authenticate(userName, userPassword);
//        UserDetails userDetails = loadUserByUsername(userName);
        User user = userDao.findById(userName).get();

//        String newGeneratedToken = jwtUtil.generateToken(userDetails);
        String newGeneratedToken = jwtUtil.generateToken(user);

        return new JwtResponse(user, newGeneratedToken);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userDao.findById(username);

        if (user.isPresent()) {
            return new org.springframework.security.core.userdetails.User(
                    user.get().getUsername(),
                    user.get().getPassword(),
                    getAuthority(user.get())
            );
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }

    private Set<SimpleGrantedAuthority> getAuthority(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        user.getRole().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        });
        return authorities;
    }

    private void authenticate(String userName, String userPassword) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, userPassword));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
