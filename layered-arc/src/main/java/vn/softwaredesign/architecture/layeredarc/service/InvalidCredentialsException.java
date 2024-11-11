package vn.softwaredesign.architecture.layeredarc.service;

public class InvalidCredentialsException extends Exception {
    public InvalidCredentialsException(String message) {
        super(message);
    }
}
