package ru.vyacheslavkozlov.firstrunday.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vyacheslavkozlov.firstrunday.entity.Account;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Integer> {

    public Optional<Account> findByEmail(String email);

    public Optional<Account> findById(int id);

}
