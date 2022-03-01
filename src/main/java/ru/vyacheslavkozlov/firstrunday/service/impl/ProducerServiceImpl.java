package ru.vyacheslavkozlov.firstrunday.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vyacheslavkozlov.firstrunday.entity.Producer;
import ru.vyacheslavkozlov.firstrunday.repository.ProducerRopository;
import ru.vyacheslavkozlov.firstrunday.service.ProducerService;

import java.util.List;

@AllArgsConstructor
@Service
public class ProducerServiceImpl implements ProducerService {
    private final ProducerRopository producerRopository;

    public List<Producer> findAll() {
        return producerRopository.findAll();
    }

    @Override
    public void update(Producer updateProducer) {
        Producer producer = producerRopository.findById(updateProducer.getId()).get();
        producer.setName(updateProducer.getName());
        producerRopository.save(producer);
    }

    @Override
    public void add(String producerName) {
        Producer newProducer = new Producer();
        newProducer.setName(producerName);
        producerRopository.save(newProducer);
    }

    @Override
    public void delete(int producerId) {
        producerRopository.deleteById(producerId);
    }
}
