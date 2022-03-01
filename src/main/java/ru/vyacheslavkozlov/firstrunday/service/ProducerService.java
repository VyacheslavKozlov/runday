package ru.vyacheslavkozlov.firstrunday.service;

import ru.vyacheslavkozlov.firstrunday.entity.Producer;

import java.util.List;

public interface ProducerService {
    public List<Producer> findAll();

    public void update(Producer producer);

    public void add(String producerName);

    public void delete(int producerId);
}
