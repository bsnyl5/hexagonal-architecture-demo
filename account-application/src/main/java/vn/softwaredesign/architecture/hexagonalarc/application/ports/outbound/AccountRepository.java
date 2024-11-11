package vn.softwaredesign.architecture.hexagonalarc.application.ports.outbound;

import vn.softwaredesign.architecture.hexagonalarc.domain.model.Account;

import java.util.Optional;


public interface AccountRepository {
    Optional<Account> findByEmail(String email);

    void save(Account user);
}
