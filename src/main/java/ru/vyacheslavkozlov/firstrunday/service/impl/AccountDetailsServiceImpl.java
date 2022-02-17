package ru.vyacheslavkozlov.firstrunday.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.vyacheslavkozlov.firstrunday.config.security.SecurityAccount;
import ru.vyacheslavkozlov.firstrunday.entity.Account;
import ru.vyacheslavkozlov.firstrunday.entity.Role;
import ru.vyacheslavkozlov.firstrunday.entity.Status;
import ru.vyacheslavkozlov.firstrunday.repository.AccountRepository;

@Service("accountDetailsServiceImpl")
@AllArgsConstructor
public class AccountDetailsServiceImpl implements UserDetailsService {

    private final AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Account account = accountRepository.findByEmail(email).
                orElseThrow(() -> new UsernameNotFoundException("Account not found!"));
        return SecurityAccount.fromUser(account);
    }

    public Account findByEmail(String email){
        return accountRepository.findByEmail(email).get();
    }

    public void save(Account account) {
        account.setPassword(new BCryptPasswordEncoder(12).encode(account.getPassword()));
        account.setEnable(true);
        account.setRole(Role.USER);
        account.setStatus(Status.ACTIVE);
        System.out.println(account);
        accountRepository.save(account);
    }



}
