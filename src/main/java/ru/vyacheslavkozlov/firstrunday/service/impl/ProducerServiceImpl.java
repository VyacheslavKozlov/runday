package ru.vyacheslavkozlov.firstrunday.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vyacheslavkozlov.firstrunday.entity.Producer;
import ru.vyacheslavkozlov.firstrunday.repository.ProducerRopository;

import java.util.List;

@AllArgsConstructor
@Service
public class ProducerServiceImpl {
    private final ProducerRopository producerRopository;

    public List<Producer> findAll() {
        return producerRopository.findAll();
    }
}
