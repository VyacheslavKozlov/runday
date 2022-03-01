package ru.vyacheslavkozlov.firstrunday.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vyacheslavkozlov.firstrunday.entity.ShoeModel;
import ru.vyacheslavkozlov.firstrunday.repository.ShoeModelRepository;
import ru.vyacheslavkozlov.firstrunday.service.ShoeModelService;

import java.util.List;

@AllArgsConstructor
@Service
public class ShoeModelServiceImpl implements ShoeModelService {
    private final ShoeModelRepository shoeModelRepository;

    @Override
    public List<ShoeModel> findAll() {
        return shoeModelRepository.findAll();
    }
}
