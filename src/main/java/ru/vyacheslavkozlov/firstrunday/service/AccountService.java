package ru.vyacheslavkozlov.firstrunday.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.vyacheslavkozlov.firstrunday.entity.Account;

import java.util.List;

public interface AccountService extends UserDetailsService {
    public Account findByLogin(String login);

    public List<Account> findAll();
}
