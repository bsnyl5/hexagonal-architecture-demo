package vn.softwaredesign.architecture.layeredarc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.softwaredesign.architecture.layeredarc.entity.Account;
import vn.softwaredesign.architecture.layeredarc.repository.AccountRepository;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;

    public void createAccount(AccountDto accountDto) throws InvalidCredentialsException {
        isEmailAlreadyUsed(accountDto.email());
        var user = new Account(accountDto.name(), accountDto.password(), accountDto.email());
        accountRepository.save(user);
    }

    public void login(String email, String password) throws InvalidCredentialsException {
        var optionalAccount = accountRepository.findByEmail(email);
        if (optionalAccount.isPresent()) {
            var account = optionalAccount.get();
            var isThePasswordValid = isThePasswordValid(account.getPassword(), password);
            if (!isThePasswordValid) {
                throw new InvalidCredentialsException("Invalid credentials");
            }
        } else {
            throw new InvalidCredentialsException("Invalid credentials");
        }
    }

    private void isEmailAlreadyUsed(String email) throws InvalidCredentialsException {
        if (accountRepository.findByEmail(email).isPresent()) {
            throw new InvalidCredentialsException("Email address already exists");
        }
    }

    private boolean isThePasswordValid(String password, String uiPassword) {
        return password.equals(uiPassword);
    }

}
