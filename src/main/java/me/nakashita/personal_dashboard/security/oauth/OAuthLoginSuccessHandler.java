package me.nakashita.personal_dashboard.security.oauth;


import me.nakashita.personal_dashboard.api.model.User;
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
public class OAuthLoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Autowired
    UserService userService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws ServletException, IOException {

        CustomOAuth2User oAuth2User = (CustomOAuth2User) authentication.getPrincipal();

        User user = userService.getUserByUsername(oAuth2User.getName());

        if(user == null) {
            userService.saveUser(
                    oAuth2User.getName(),
                    null,
                    oAuth2User.getFullName(),
                    oAuth2User.getOauth2ClientName()
                    );
        } else {
            user.setUsername(oAuth2User.getName());
            user.setName(oAuth2User.getFullName());
            userService.saveUser(user);
        }



        super.onAuthenticationSuccess(request, response, authentication);
    }

}
