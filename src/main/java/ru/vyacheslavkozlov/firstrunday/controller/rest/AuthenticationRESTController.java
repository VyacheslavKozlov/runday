package ru.vyacheslavkozlov.firstrunday.controller.rest;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;
import ru.vyacheslavkozlov.firstrunday.config.dto.AuthRequestDTO;
import ru.vyacheslavkozlov.firstrunday.config.security.JwtTokenProvider;
import ru.vyacheslavkozlov.firstrunday.entity.Account;
import ru.vyacheslavkozlov.firstrunday.repository.AccountRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
@AllArgsConstructor
@RestController
@RequestMapping(value = "/runday/auth")
public class AuthenticationRESTController {

    private final AuthenticationManager authenticationManager;
    private final AccountRepository accountRepository;
    private final JwtTokenProvider jwtTokenProvider;

    @PostMapping(path = "/login")
    public ResponseEntity<?> authenticate(@ModelAttribute AuthRequestDTO authRequestDTO){
        System.out.println("AuthenticationRestController authenticate = " + authRequestDTO.toString());

        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequestDTO.getEmail(), authRequestDTO.getPassword()));
            Account account = accountRepository.findByEmail(authRequestDTO.getEmail()).orElseThrow(() -> new UsernameNotFoundException("user not found"));
            String token = jwtTokenProvider.createToken(authRequestDTO.getEmail(), account.getRole().name());
            Map<Object, Object> response = new HashMap<>();
            response.put("email", authRequestDTO.getEmail());
            response.put("token", token);
            return ResponseEntity.ok(response);
        }
        catch (AuthenticationException e){
            return new ResponseEntity<>("Invalid email/password!", HttpStatus.FORBIDDEN);
        }
    }

    @PostMapping("/logout")
    public void logout(HttpServletRequest httpRequest, HttpServletResponse httpResponse){
        SecurityContextLogoutHandler securityContextLogoutHandler = new SecurityContextLogoutHandler();
        securityContextLogoutHandler.logout(httpRequest, httpResponse, null);
    }
}
