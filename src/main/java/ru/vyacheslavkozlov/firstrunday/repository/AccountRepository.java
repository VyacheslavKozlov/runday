package ru.vyacheslavkozlov.firstrunday.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vyacheslavkozlov.firstrunday.entity.Account;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

    public Account findByLogin(String login);

}
