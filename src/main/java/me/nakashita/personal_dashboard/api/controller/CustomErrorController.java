package me.nakashita.personal_dashboard.api.controller;

import me.nakashita.personal_dashboard.api.exception.UsernameAlreadyTakenException;
import me.nakashita.personal_dashboard.api.model.User;
import me.nakashita.personal_dashboard.api.service.UserService;
import me.nakashita.personal_dashboard.security.AuthenticationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@RestController
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public ModelAndView handleError(HttpServletRequest request, ModelAndView modelAndView) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        modelAndView.setViewName("error.html");
        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());
            modelAndView.addObject("statusCode", statusCode);
        } else {
            modelAndView.addObject("statusCode", "Error");
        }
        return modelAndView;
    }
}
