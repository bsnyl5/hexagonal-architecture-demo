package vn.softwaredesign.architecture.hexagonalarc.domain.model;

import java.util.Optional;


public interface AccountRepository {
    Optional<Account> findByEmail(String email) throws InvalidCredentialsException;

    void save(Account user);
}
