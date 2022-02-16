package ru.vyacheslavkozlov.firstrunday.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.vyacheslavkozlov.firstrunday.config.security.SecurityAccount;
import ru.vyacheslavkozlov.firstrunday.entity.Account;
import ru.vyacheslavkozlov.firstrunday.repository.AccountRepository;

@Service("accountDetailsServiceImpl")
@AllArgsConstructor
public class AccountDetailsServiceImpl implements UserDetailsService {

    private final AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        System.out.println("AccountDetailsServiceImpl loadUserByUsername email = " + email);
        Account account = accountRepository.findByEmail(email).
                orElseThrow(() -> new UsernameNotFoundException("Account not found!"));
        return SecurityAccount.fromUser(account);
    }
}
