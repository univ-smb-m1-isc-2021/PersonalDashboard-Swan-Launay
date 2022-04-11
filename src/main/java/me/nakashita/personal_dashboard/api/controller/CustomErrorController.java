package me.nakashita.personal_dashboard.api.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@RestController
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public ModelAndView handleError(HttpServletRequest request, ModelAndView modelAndView) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        modelAndView.setViewName("error");
        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());
            modelAndView.addObject("statusCode", statusCode);
        } else {
            modelAndView.addObject("statusCode", "Error");
        }
        return modelAndView;
    }

}
