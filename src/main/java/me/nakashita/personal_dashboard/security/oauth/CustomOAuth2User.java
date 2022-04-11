package me.nakashita.personal_dashboard.security.oauth;

import me.nakashita.personal_dashboard.security.AuthenticationType;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.Locale;
import java.util.Map;

public class CustomOAuth2User implements OAuth2User {
    private final String oauth2ClientName;
    private final OAuth2User oauth2User;

    public CustomOAuth2User(OAuth2User oauth2User, String oauth2ClientName) {
        this.oauth2User = oauth2User;
        this.oauth2ClientName = oauth2ClientName;
    }

    @Override
    public Map<String, Object> getAttributes() {
        return oauth2User.getAttributes();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return oauth2User.getAuthorities();
    }

    @Override
    public String getName() {
        if (oauth2ClientName.equalsIgnoreCase("GITHUB")) {
            return oauth2User.getAttribute("login");
        } else {
            return oauth2User.getAttribute("email");
        }
    }

    public String getFullName() {
        if (oauth2ClientName.equalsIgnoreCase("GITHUB")) {
            return oauth2User.getAttribute("login");
        } else {
            return oauth2User.getAttribute("name");
        }
    }

    public AuthenticationType getOauth2ClientName() {
        switch (oauth2ClientName.toUpperCase(Locale.ROOT)) {
            case "GITHUB":
                return AuthenticationType.GITHUB;
            case "GOOGLE":
                return AuthenticationType.GOOGLE;
            default:
                return AuthenticationType.DATABASE;
        }
    }

}
