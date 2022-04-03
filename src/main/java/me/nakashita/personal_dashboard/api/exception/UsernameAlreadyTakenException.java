package me.nakashita.personal_dashboard.api.exception;

public class UsernameAlreadyTakenException extends RuntimeException {
    public UsernameAlreadyTakenException() {
        super("Username already taken");
    }
}
