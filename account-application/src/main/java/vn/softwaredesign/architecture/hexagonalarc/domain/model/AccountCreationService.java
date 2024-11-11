package vn.softwaredesign.architecture.hexagonalarc.domain.model;

import lombok.RequiredArgsConstructor;
import vn.softwaredesign.architecture.hexagonalarc.application.ports.outbound.AccountRepository;


@RequiredArgsConstructor
public class AccountCreationService {

    private final AccountRepository accountRepository;

    public Account createAccount(String email, String name, String password) throws InvalidCredentialsException {
        Account account = new Account(email, name, password);

        AccountValidationNotificationHandler notificationHandler = new AccountValidationNotificationHandler();
        account.validate(this.accountRepository, notificationHandler);

        if (notificationHandler.messages().isEmpty()) {
            return account;
        } else {
            throw new InvalidCredentialsException("Invalid credentials. Reasons: " + notificationHandler.concatenatedMessage());
        }
    }
}
