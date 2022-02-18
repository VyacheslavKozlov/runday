package ru.vyacheslavkozlov.firstrunday.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vyacheslavkozlov.firstrunday.entity.Sneakers;
import ru.vyacheslavkozlov.firstrunday.repository.SneakersRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class SneakersServiceImpl {

    private final SneakersRepository sneakersRepository;

    public List<Sneakers> findAllByAccountId(int accountId){
        return sneakersRepository.findAllByAccountId(accountId);
    }
}


