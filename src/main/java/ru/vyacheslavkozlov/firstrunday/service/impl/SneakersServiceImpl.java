package ru.vyacheslavkozlov.firstrunday.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vyacheslavkozlov.firstrunday.entity.Sneakers;
import ru.vyacheslavkozlov.firstrunday.repository.SneakersRepository;
import ru.vyacheslavkozlov.firstrunday.service.SneakersService;

import java.util.List;

@AllArgsConstructor
@Service
public class SneakersServiceImpl implements SneakersService {

    private final SneakersRepository sneakersRepository;

    public List<Sneakers> findAllByAccountId(int accountId){
        List<Sneakers> allSneakersByAccountId = sneakersRepository.findAllByAccountId(accountId);
//        allSneakersByAccountId.stream().forEach(sneakers -> sneakers.setWorkouts(workoutService.findAllBySneakersId(sneakers.getId())));
        System.out.println(allSneakersByAccountId);

        return allSneakersByAccountId;
    }

    public List<Sneakers> findAll() {
        return sneakersRepository.findAll();
    }

    @Override
    public void update(Sneakers sneakers) {
        sneakersRepository.save(sneakers);
    }
}


