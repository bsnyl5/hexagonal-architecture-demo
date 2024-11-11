package vn.softwaredesign.architecture.hexagonalarc.domain.model;

import vn.softwaredesign.architecture.hexagonalarc.application.ports.outbound.AccountRepository;

import java.util.Objects;

public class Account {
    private String email;
    private String name;
    private String password;

    Account(String email, String name, String password) throws InvalidCredentialsException {
        if (validateEmail(email)) {
            this.email = email;
        } else {
            throw new InvalidCredentialsException("Email is invalid.");
        }

        if (name.equalsIgnoreCase(email)) {
            throw new IllegalArgumentException("Name and email must be different");
        }

        this.name = name;
        this.password = password;
    }

    public void validate(AccountRepository accountRepository, ValidationNotificationHandler validationNotificationHandler) {
        (new AccountValidator(this, accountRepository, validationNotificationHandler)).validate();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(email, account.email);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(email);
    }

    private final String EMAIL_PATTERN =
            "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";

    private boolean validateEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            return false;
        }
        return email.matches(EMAIL_PATTERN);
    }

    String email() {
        return email;
    }
}
