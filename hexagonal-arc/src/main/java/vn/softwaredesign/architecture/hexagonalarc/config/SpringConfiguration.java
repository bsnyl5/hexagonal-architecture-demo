package vn.softwaredesign.architecture.hexagonalarc.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import vn.softwaredesign.architecture.hexagonalarc.application.ports.inbound.AccountCreation;
import vn.softwaredesign.architecture.hexagonalarc.application.ports.inbound.AccountLogin;
import vn.softwaredesign.architecture.hexagonalarc.application.usecases.AccountCreationImpl;
import vn.softwaredesign.architecture.hexagonalarc.application.usecases.AccountLoginImpl;
import vn.softwaredesign.architecture.hexagonalarc.domain.model.AccountCreationService;
import vn.softwaredesign.architecture.hexagonalarc.domain.model.AccountRepository;

@Configuration
public class SpringConfiguration {

    @Bean
    public AccountCreationService accountCreationService(AccountRepository accountRepository) {
        return new AccountCreationService(accountRepository);
    }

    @Bean
    public AccountCreation accountCreation(AccountRepository accountRepository, AccountCreationService accountCreationService) {
        return new AccountCreationImpl(accountCreationService, accountRepository);
    }

    @Bean
    public AccountLogin accountLogin(AccountRepository accountRepository) {
        return new AccountLoginImpl(accountRepository);
    }
}
