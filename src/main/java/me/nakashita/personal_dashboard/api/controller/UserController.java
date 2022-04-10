package me.nakashita.personal_dashboard.api.controller;


import me.nakashita.personal_dashboard.api.exception.IncorrectPasswordException;
import me.nakashita.personal_dashboard.api.exception.UserNotFoundException;
import me.nakashita.personal_dashboard.api.exception.UsernameAlreadyTakenException;
import me.nakashita.personal_dashboard.api.model.User;
import me.nakashita.personal_dashboard.api.service.UserService;
import me.nakashita.personal_dashboard.security.AuthenticationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;

@RestController
public class UserController extends ResponseEntityExceptionHandler {

    @Autowired
    private UserService userService;

    private Principal principal;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/register")
    public RedirectView register(@RequestParam(name = "email") String email,
                           @RequestParam(name = "pass") String password,
                           @RequestParam(name = "name") String displayname){
                           /*
                           RedirectAttributes redirectAttributes) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        header
        */

        if(!userService.isExist(email)) {
            userService.saveUser(
                    email,
                    new BCryptPasswordEncoder().encode(password),
                    displayname
            );
            /*
            redirectAttributes.addAttribute("email", email);
            redirectAttributes.addAttribute("pass", password);
            return new RedirectView("/login");

             */
        }
        //redirectAttributes.addAttribute("error", true);
        return new RedirectView("/login");
    }

    @GetMapping("/api/get-name")
    public Map<String, String> getName() {
        User user = userService.getCurrentUser();
        return Collections.singletonMap("name", user.getName());
    }


    @ExceptionHandler(UsernameAlreadyTakenException.class)
    public ResponseEntity<Object> handleUsernameAlreadyTaken() {
        return new ResponseEntity<>("Username already taken", HttpStatus.CONFLICT);
    }
}
