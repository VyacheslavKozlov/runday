package ru.vyacheslavkozlov.firstrunday.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.vyacheslavkozlov.firstrunday.config.security.SecurityAccount;
import ru.vyacheslavkozlov.firstrunday.entity.Account;
import ru.vyacheslavkozlov.firstrunday.entity.Role;
import ru.vyacheslavkozlov.firstrunday.entity.Status;
import ru.vyacheslavkozlov.firstrunday.repository.AccountRepository;

import java.util.List;
import java.util.Optional;

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

    public void update(Account account){
        Account byId = accountRepository.findById(account.getId()).get();
        byId.setFirstName(account.getFirstName());
        byId.setLastName(account.getLastName());
        byId.setRole(account.getRole());
        byId.setStatus(account.getStatus());
        accountRepository.save(byId);
    }

    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    public Account findById(int id){
        return accountRepository.findById(id).get();
    }

}
