package vn.softwaredesign.architecture.hexagonalarc.application.usecases;

import lombok.RequiredArgsConstructor;
import vn.softwaredesign.architecture.hexagonalarc.application.ports.inbound.AccountLogin;
import vn.softwaredesign.architecture.hexagonalarc.application.ports.inbound.LoginInput;
import vn.softwaredesign.architecture.hexagonalarc.application.ports.inbound.LoginOutput;
import vn.softwaredesign.architecture.hexagonalarc.domain.model.Account;
import vn.softwaredesign.architecture.hexagonalarc.domain.model.AccountRepository;
import vn.softwaredesign.architecture.hexagonalarc.domain.model.InvalidCredentialsException;

import java.util.Optional;


@RequiredArgsConstructor
public class AccountLoginImpl implements AccountLogin {

    private final AccountRepository accountRepository;

    @Override
    public LoginOutput login(LoginInput loginInput) throws InvalidCredentialsException {
        Optional<Account> optionalAccount = accountRepository.findByEmail(loginInput.email());
        if (optionalAccount.isPresent()) {
            Account account = optionalAccount.get();
            if (account.verifyPassword(loginInput.password())) {
                return new LoginOutput(true, null);
            } else {
                return new LoginOutput(false, "Password is incorrect");
            }
        } else {
            return new LoginOutput(false, "Email not found");
        }
    }
}
