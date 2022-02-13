package ru.vyacheslavkozlov.firstrunday.service.impl;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.vyacheslavkozlov.firstrunday.entity.Account;
import ru.vyacheslavkozlov.firstrunday.repository.AccountRepository;
import ru.vyacheslavkozlov.firstrunday.service.AccountService;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account findByLogin(String login) {
        return accountRepository.findByLogin(login);
    }

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Account account = accountRepository.findByLogin(login);
        if(account == null) {
            throw new UsernameNotFoundException("Unknown user: " + login);
        }
        UserDetails user = User.builder()
                .username(account.getLogin())
                .password(account.getPassword())
                .roles(account.getRole().name())
                .build();
        return user;
    }
}
