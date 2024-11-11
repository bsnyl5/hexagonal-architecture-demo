//package vn.softwaredesign.architecture.hexagonalarc.application.usecases;
//
//import lombok.RequiredArgsConstructor;
//import vn.softwaredesign.architecture.hexagonalarc.application.ports.inbound.AccountCreation;
//import vn.softwaredesign.architecture.hexagonalarc.application.ports.inbound.AccountDto;
//import vn.softwaredesign.architecture.hexagonalarc.application.ports.outbound.AccountRepository;
//import vn.softwaredesign.architecture.hexagonalarc.domain.model.Account;
//import vn.softwaredesign.architecture.hexagonalarc.domain.model.InvalidCredentialsException;
//
//
//@RequiredArgsConstructor
//public class AccountCreationImplV1 implements AccountCreation {
//
//    private final AccountRepository accountRepository;
//
//    @Override
//    public void createAccount(AccountDto accountDto) throws InvalidCredentialsException {
//        isEmailAlreadyUsed(accountDto.email());
//        var user = new Account(accountDto.name(), accountDto.password(), accountDto.email());
//        accountRepository.save(user);
//    }
//
//    private void isEmailAlreadyUsed(String email) throws InvalidCredentialsException {
//        if (accountRepository.findByEmail(email).isPresent()) {
//            throw new InvalidCredentialsException("Email address already exists");
//        }
//    }
//}
