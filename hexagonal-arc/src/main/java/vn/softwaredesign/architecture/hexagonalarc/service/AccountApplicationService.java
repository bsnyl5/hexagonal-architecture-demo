package vn.softwaredesign.architecture.hexagonalarc.service;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.softwaredesign.architecture.hexagonalarc.application.ports.inbound.*;
import vn.softwaredesign.architecture.hexagonalarc.domain.model.InvalidCredentialsException;

@Service
@RequiredArgsConstructor
public class AccountApplicationService {
    private final AccountCreation accountCreation;
    private final AccountLogin accountLogin;

    @Transactional
    public void createAccount(AccountDto accountDto) throws InvalidCredentialsException {
        this.accountCreation.createAccount(accountDto);
    }

    public void login(String email, String encodedPassword) throws InvalidCredentialsException {
        LoginInput loginInput = new LoginInput(email, encodedPassword);
        LoginOutput loginOutput = this.accountLogin.login(loginInput);
        if (!loginOutput.isSuccess()) {
            throw new InvalidCredentialsException(loginOutput.message());
        }
    }
}
