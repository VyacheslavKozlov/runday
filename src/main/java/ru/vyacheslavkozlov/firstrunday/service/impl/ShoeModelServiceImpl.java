package ru.vyacheslavkozlov.firstrunday.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vyacheslavkozlov.firstrunday.repository.ShoeModelRepository;

@AllArgsConstructor
@Service
public class ShoeModelServiceImpl {
    private final ShoeModelRepository shoeModelRepository;
}
