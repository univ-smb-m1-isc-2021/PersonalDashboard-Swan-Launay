package me.nakashita.personal_dashboard.api.controller;


import me.nakashita.personal_dashboard.api.exception.IncorrectPasswordException;
import me.nakashita.personal_dashboard.api.exception.UserNotFoundException;
import me.nakashita.personal_dashboard.api.exception.UsernameAlreadyTakenException;
import me.nakashita.personal_dashboard.api.model.User;
import me.nakashita.personal_dashboard.api.service.UserService;
import me.nakashita.personal_dashboard.security.AuthenticationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;

@RestController
public class UserController extends ResponseEntityExceptionHandler {

    @Autowired
    private UserService userService;

    @GetMapping("/register/{email}/{password}")
    public User register(@PathVariable String email, @PathVariable String password) {
        if(!userService.isExist(email)) {
            User user = new User();
            user.setUsername(email);
            user.setPassword(new BCryptPasswordEncoder().encode(password));
            user.setAuthType(AuthenticationType.DATABASE);
            userService.saveUser(user);
            return user;
        }
        return null;
    }



    /*
    @GetMapping("/api/get-user/{id}")

    public Iterable<User> getUsers() {
        return userService.getUsers();
    }
    */

    /*
    @GetMapping("/api/create-user/{name}/{username}/{password}")
    public User addUser(@PathVariable String name, @PathVariable String password, @PathVariable String username) {
        if(userService.isExist(username)) {
            throw new UsernameAlreadyTakenException();
        } else {
            return userService.saveUser(new User(name, username, password));
        }
    }
    */



    @GetMapping("/api/delete-user/{id}/{password}")
    public void deleteUser(@PathVariable Long id, @PathVariable String password) {
        /*
        Optional<User> opUser = userService.getUser(id);
        if(opUser.isPresent()) {
            User user = opUser.get();
            if (user.passwordEquals(password)) {
                userService.deleteUser(user.getId());
            } else {
                throw new IncorrectPasswordException();
            }
        } else {
            throw new UserNotFoundException(id);
        }
        */

    }

    @GetMapping("/api/get-current-user")
    public String getCurrentUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).toString();
        } else {
            username = principal.toString();
        }
        return username;
    }











    /*
    @GetMapping("/api/reset")
    public void reset() {
        userService.deleteAll();
    }
    */


    @ExceptionHandler(UsernameAlreadyTakenException.class)
    public ResponseEntity<Object> handleUsernameAlreadyTaken() {
        return new ResponseEntity<>("Username already taken", HttpStatus.CONFLICT);
    }
}
