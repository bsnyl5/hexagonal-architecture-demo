package vn.softwaredesign.architecture.hexagonalarc.application.usecases;

import lombok.RequiredArgsConstructor;
import vn.softwaredesign.architecture.hexagonalarc.application.ports.inbound.AccountCreation;
import vn.softwaredesign.architecture.hexagonalarc.application.ports.inbound.AccountDto;
import vn.softwaredesign.architecture.hexagonalarc.application.ports.outbound.AccountRepository;
import vn.softwaredesign.architecture.hexagonalarc.domain.model.Account;
import vn.softwaredesign.architecture.hexagonalarc.domain.model.AccountCreationService;
import vn.softwaredesign.architecture.hexagonalarc.domain.model.InvalidCredentialsException;


@RequiredArgsConstructor
public class AccountCreationImpl implements AccountCreation {

    private final AccountCreationService accountCreationService;
    private final AccountRepository accountRepository;

    @Override
    public void createAccount(AccountDto accountDto) throws InvalidCredentialsException {
        Account account = accountCreationService.createAccount(accountDto.email(), accountDto.name(), accountDto.password());
        accountRepository.save(account);
    }
}
