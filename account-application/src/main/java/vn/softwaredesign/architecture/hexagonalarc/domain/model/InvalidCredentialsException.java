package vn.softwaredesign.architecture.hexagonalarc.domain.model;

public class InvalidCredentialsException extends Exception {
    public InvalidCredentialsException(String message) {
        super(message);
    }
}
