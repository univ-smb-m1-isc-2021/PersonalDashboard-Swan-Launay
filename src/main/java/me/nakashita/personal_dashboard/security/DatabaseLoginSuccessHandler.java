package me.nakashita.personal_dashboard.security;

import me.nakashita.personal_dashboard.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class DatabaseLoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Autowired
    UserService userService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws ServletException, IOException {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        userService.updateAuthenticationType(userDetails.getUsername(), "database");
        super.onAuthenticationSuccess(request, response, authentication);
    }

}

