package ru.vyacheslavkozlov.firstrunday.service;

import ru.vyacheslavkozlov.firstrunday.entity.Sneakers;

import java.util.List;

public interface SneakersService {
    public List<Sneakers> findAllByAccountId(int accountId);

    public List<Sneakers> findAll();

    public void update(Sneakers sneakers);
}
