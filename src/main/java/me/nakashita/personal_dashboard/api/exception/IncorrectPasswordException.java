package me.nakashita.personal_dashboard.api.exception;

public class IncorrectPasswordException extends RuntimeException {
    public IncorrectPasswordException() {
        super("Incrorrect password");
    }
}
