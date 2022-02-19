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
    private final WorkoutServiceImpl workoutService;

    public List<Sneakers> findAllByAccountId(int accountId){
        List<Sneakers> allSneakersByAccountId = sneakersRepository.findAllByAccountId(accountId);
//        allSneakersByAccountId.stream().forEach(sneakers -> sneakers.setWorkouts(workoutService.findAllBySneakersId(sneakers.getId())));
        System.out.println(allSneakersByAccountId);

        return allSneakersByAccountId;
    }
}


