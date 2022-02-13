package ru.vyacheslavkozlov.firstrunday.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.vyacheslavkozlov.firstrunday.entity.Account;

public interface AccountService {
    public void save(Account account);
}
