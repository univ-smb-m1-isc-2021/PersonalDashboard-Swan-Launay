package me.nakashita.personal_dashboard.api.service;

import lombok.extern.slf4j.Slf4j;
import me.nakashita.personal_dashboard.api.exception.UsernameAlreadyTakenException;
import me.nakashita.personal_dashboard.api.model.User;
import me.nakashita.personal_dashboard.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Slf4j
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, @Lazy PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Objects.requireNonNull(username);
        User user = userRepository.findUserWithName(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return user;
    }

    public User saveUser(String username, String password) {
        if(isExistUser(username)) {
            throw new UsernameAlreadyTakenException();
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        return userRepository.save(user);
    }

    public boolean isExistUser(String username) {
        return userRepository.findUserWithName(username).isPresent();
    }

}