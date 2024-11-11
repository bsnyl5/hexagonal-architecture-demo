package vn.softwaredesign.architecture.hexagonalarc.domain.model;

import vn.softwaredesign.architecture.hexagonalarc.application.ports.outbound.AccountRepository;

public class AccountValidator extends Validator {
    private Account account;
    private AccountRepository accountRepository;

    public AccountValidator(Account account,
                            AccountRepository accountRepository,
                            ValidationNotificationHandler validationNotificationHandler) {
        super(validationNotificationHandler);
        this.account = account;
        this.accountRepository = accountRepository;
    }

    @Override
    public void validate() {
        if (this.emailAlreadyExist(this.account)) {
            this.validationNotificationHandler.handleError("The Email is already exist.");
        }
    }

    private boolean emailAlreadyExist(Account account) {
        if (this.accountRepository.findByEmail(account.email()).isPresent()) {
            return true;
        } else {
            return false;
        }
    }
}
