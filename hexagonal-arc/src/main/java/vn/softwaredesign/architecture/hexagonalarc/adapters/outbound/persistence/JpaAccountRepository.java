package vn.softwaredesign.architecture.hexagonalarc.adapters.outbound.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaAccountRepository extends JpaRepository<JpaAccount, Integer> {
    Optional<JpaAccount> findByEmail(String email);
}
