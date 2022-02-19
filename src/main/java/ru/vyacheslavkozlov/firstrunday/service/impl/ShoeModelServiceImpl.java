package ru.vyacheslavkozlov.firstrunday.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vyacheslavkozlov.firstrunday.entity.ShoeModel;
import ru.vyacheslavkozlov.firstrunday.repository.ShoeModelRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class ShoeModelServiceImpl {
    private final ShoeModelRepository shoeModelRepository;

    public List<ShoeModel> findAll() {
        return shoeModelRepository.findAll();
    }
}
