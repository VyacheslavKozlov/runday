package ru.vyacheslavkozlov.firstrunday.config.security;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import ru.vyacheslavkozlov.firstrunday.entity.Permission;
import ru.vyacheslavkozlov.firstrunday.entity.Role;
import ru.vyacheslavkozlov.firstrunday.service.AccountService;

@EnableWebSecurity
@AllArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/runday").permitAll()
                .antMatchers("/runday/registration").permitAll()
                .antMatchers(HttpMethod.GET, "/runday/admin").hasAuthority(Permission.ACCOUNT_READ.getPermission())
                .antMatchers(HttpMethod.POST, "/runday/admin").hasAuthority(Permission.ACCOUNT_WRITE.getPermission())
                .antMatchers(HttpMethod.DELETE, "/runday/admin").hasAuthority(Permission.ACCOUNT_WRITE.getPermission())
                .antMatchers(HttpMethod.GET, "/runday/runner").hasAuthority(Permission.ACCOUNT_READ.getPermission())
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/runday/auth/login").permitAll()
                .defaultSuccessUrl("/runday/auth/success");
    }

    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        return new InMemoryUserDetailsManager(
                User.builder()
                        .username("admin")
                        .password(passwordEncoder().encode("admin"))
                        .authorities(Role.ADMIN.getAuthorityes())
                        .build(),
                User.builder()
                        .username("user")
                        .password(passwordEncoder().encode("user"))
                        .authorities(Role.USER.getAuthorityes())
                        .build()

        );
    }

    @Bean
    protected PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(12);
    }


}
