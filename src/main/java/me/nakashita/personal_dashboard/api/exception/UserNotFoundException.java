package me.nakashita.personal_dashboard.api.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long id) {
        super("Could not find user " + id);
    }
}
