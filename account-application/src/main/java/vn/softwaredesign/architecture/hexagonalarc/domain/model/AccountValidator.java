package vn.softwaredesign.architecture.hexagonalarc.domain.model;

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
        try {
            if (this.emailAlreadyExist(this.account)) {
                this.validationNotificationHandler.handleError("The Email is already exist.");
            }
        } catch (Exception e) {
            this.validationNotificationHandler.handleError(e.getMessage());
        }
    }

    private boolean emailAlreadyExist(Account account) throws InvalidCredentialsException {
        if (this.accountRepository.findByEmail(account.email()).isPresent()) {
            return true;
        } else {
            return false;
        }
    }
}
