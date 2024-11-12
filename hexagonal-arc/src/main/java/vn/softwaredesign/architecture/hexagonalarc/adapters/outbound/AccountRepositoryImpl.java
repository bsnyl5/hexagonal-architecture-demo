package vn.softwaredesign.architecture.hexagonalarc.adapters.outbound;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import vn.softwaredesign.architecture.hexagonalarc.adapters.outbound.persistence.JpaAccount;
import vn.softwaredesign.architecture.hexagonalarc.adapters.outbound.persistence.JpaAccountRepository;
import vn.softwaredesign.architecture.hexagonalarc.domain.model.Account;
import vn.softwaredesign.architecture.hexagonalarc.domain.model.AccountRepository;
import vn.softwaredesign.architecture.hexagonalarc.domain.model.InvalidCredentialsException;

import java.util.Optional;


@RequiredArgsConstructor
@Component
public class AccountRepositoryImpl implements AccountRepository {
    private final JpaAccountRepository jpaAccountRepository;

    @Override
    public Optional<Account> findByEmail(String email) throws InvalidCredentialsException {
        Optional<JpaAccount> jpaAccount = jpaAccountRepository.findByEmail(email);
        return convertToDomainModel(jpaAccount);
    }

    @Override
    public void save(Account account) {
        JpaAccount jpaAccount = convertToDatabaseModel(account);
        jpaAccountRepository.save(jpaAccount);
    }

    private JpaAccount convertToDatabaseModel(Account account) {
        Account.AccountMemento memento = account.createSnapshot();

        JpaAccount jpaAccount = new JpaAccount();
        jpaAccount.setEmail(memento.email());
        jpaAccount.setName(memento.name());
        jpaAccount.setPassword(memento.password());

        return jpaAccount;
    }

    private Optional<Account> convertToDomainModel(Optional<JpaAccount> optionalJpaAccount) throws InvalidCredentialsException {
        if (optionalJpaAccount.isPresent()) {
            JpaAccount jpaAccount = optionalJpaAccount.get();
            Account.AccountMemento accountMemento = new Account.AccountMemento(jpaAccount.getEmail(), jpaAccount.getName(), jpaAccount.getPassword());
            return Optional.ofNullable(accountMemento.restore());
        } else {
            return Optional.empty();
        }
    }


}
