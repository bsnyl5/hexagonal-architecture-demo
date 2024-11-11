package vn.softwaredesign.architecture.layeredarc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.softwaredesign.architecture.layeredarc.entity.Account;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Integer> {
    // Custom query method to find an account by email
    Optional<Account> findByEmail(String email);
}
