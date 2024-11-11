package vn.softwaredesign.architecture.hexagonalarc.application.ports.inbound;

import vn.softwaredesign.architecture.hexagonalarc.domain.model.InvalidCredentialsException;

public interface AccountCreation {
    void createAccount(AccountDto accountDto) throws InvalidCredentialsException;
}
